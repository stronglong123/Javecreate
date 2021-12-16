package com.common.generate.javacreate.service.impl.es;

import com.common.generate.javacreate.advice.ElasticSearchConfig;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.model.es.BoTermQuery;
import com.common.generate.javacreate.model.es.PageParam;
import org.apache.commons.lang3.ObjectUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2021/10/27 15:08
 */
@Service
public abstract class EsHighLevelSearchServiceImpl<T> extends EsBaseSearchService<T> {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public List<T> queryList(PageParam pageParam, BoTermQuery boTermQuery, String indexName, Class<T> tClass) {
        /**组转查询条件*/
        BoolQueryBuilder queryBuilder = this.createQueryBuilder(boTermQuery);
        /**查询es*/
        SearchResponse searchResponse = queryByHighLevel(indexName, queryBuilder, pageParam);
        /**处理查询结果*/
        return convertList(searchResponse.getHits(), tClass);
    }


    private List<T> convertList(SearchHits searchHits, Class<T> tClass) {
        List<T> results = new ArrayList<>();
        //组装结果
        for (SearchHit searchHit : searchHits) {
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            Map<String, HighlightField> highlightFieldsResult = searchHit.getHighlightFields();
            try {
                T t = tClass.newInstance();
                Field[] declaredFields = t.getClass().getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    if (highlightFieldsResult.get(name) != null) {
                        field.set(t, (highlightFieldsResult.get(name).getFragments()[0]).toString());
                    } else {
                        Object fieldValue = sourceAsMap.get(name);
                        if(ObjectUtils.isNotEmpty(fieldValue)){
                            field.set(t, fieldValue);
                        }
                    }
                }
                results.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }


    private SearchResponse queryByHighLevel(String indexName, BoolQueryBuilder queryBuilder, PageParam pageParam) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(indexName);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        Integer pageNum = pageParam.getPageNum();
        Integer pageSize = pageParam.getPageSize();
        if (pageNum != null && pageSize != null) {
            searchSourceBuilder.size(pageSize);
            if (pageNum <= 0) {
                pageNum = 1;
            }
            searchSourceBuilder.from((pageNum - 1) * pageSize).size(pageSize);
        }
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
        } catch (IOException e) {
            throw new BusinessValidateException("es查询失败，请重试");
        }
        return searchResponse;
    }

}
