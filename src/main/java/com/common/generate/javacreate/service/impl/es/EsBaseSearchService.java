package com.common.generate.javacreate.service.impl.es;

import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.model.es.BoTermQuery;
import com.common.generate.javacreate.model.es.PageParam;
import javafx.util.Pair;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2021/10/27 15:06
 */
public abstract class EsBaseSearchService<T> {
    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    /**
     * @Description 根据实体类创建索引，这里的实体类就是上面创建的EsSourceInfo实体
     * @Author Innocence
     */
    public Boolean createIndexByClass(Class<T> clazz) {
        Document document = clazz.getDeclaredAnnotation(Document.class);
        if (document == null) {
            return false;
        }
        String indexName = document.indexName();
        Boolean indexExist = isIndexExist(indexName);
        if (indexExist) {
            return false;
        }
        IndexOperations indexOps = restTemplate.indexOps(clazz);
        boolean result1 = indexOps.create(); //创建索引
        boolean result2 = indexOps.putMapping(indexOps.createMapping(clazz));
        return result1 & result2;
    }

    /**
     * @Description 根据索引名判断索引是否存在
     * @Author Innocence
     */
    public Boolean isIndexExist(String indexName) {
        IndexOperations indexOps = restTemplate.indexOps(IndexCoordinates.of(indexName));
        return indexOps.exists();
    }

    /**
     * @Description 根据索引名删除索引
     * @Author Innocence
     */
    public Boolean deleteIndexByName(String indexName) {
        IndexOperations indexOps = restTemplate.indexOps(IndexCoordinates.of(indexName));
        return indexOps.delete();
    }

    /**
     * 分页请求
     *
     * @param pageParam   分页参数
     * @param boTermQuery es查询对象封装
     * @param tClass      索引类
     * @return 文档对象集合
     */
    public abstract List<T> queryList(PageParam pageParam, BoTermQuery boTermQuery, String indexName, Class<T> tClass);


    /**
     * 根据id判断文档是否存在于指定索引中
     *
     * @param id        文档id,这里的id是需要我们在存储数据时指定
     * @param indexName 索引名
     * @return java.lang.Boolean
     * @author Innocence
     */
    public Boolean isExist(String id, String indexName) {
        return restTemplate.exists(id, IndexCoordinates.of(indexName));
    }

    /**
     * 单条数据插入
     *
     * @param data      待插入的数据实体
     * @param indexName 索引名
     * @return java.lang.String 返回文档id
     * @author Innocence
     */
    public String save(String id, T data, String indexName) {
        IndexQuery build = new IndexQueryBuilder()
                .withId(id) //这里的操作就是指定文档id
                .withObject(data).build();
        return restTemplate.index(build, IndexCoordinates.of(indexName));
    }

    /**
     * 批量插入
     *
     * @param saveList  待插入的数据实体集合
     * @param indexName 索引名
     * @return java.util.List<java.lang.String> 返回idList
     * @author Innocence
     */
    public void saveBatch(Map<String, T> saveList, String indexName) throws Exception {
        List<IndexQuery> queryList = new ArrayList<>();
        for (Map.Entry<String, T> entry : saveList.entrySet()) {
            String id = entry.getKey();
            T data = entry.getValue();
            IndexQuery build = new IndexQueryBuilder().withId(id).withObject(data).build();
            queryList.add(build);
        }
        restTemplate.bulkIndex(queryList, IndexCoordinates.of(indexName));
    }

    /**
     * 单条数据更新
     *
     * @param entity    待更新的数据实体
     * @param indexName 索引名
     * @return void
     * @author Innocence
     */
    public void updateByEntity(T entity, String id, String indexName) {
        Map<String, T> map = null;
        try {
            map = BeanUtils.describe(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        org.springframework.data.elasticsearch.core.document.Document document = org.springframework.data.elasticsearch.core.document.Document.from(map);
        document.setId(id);
        // 这里的UpdateQuery需要构造一个Document对象，但是Document对象不能用实体类转化而来
        //（可见Document的源码，位于：org.springframework.data.elasticsearch.core.document
        // 包下），因此上面才会BeanUtils.describe(entity)，将实体类转化成一个map，由map转化
        // 为Document对象。
        UpdateQuery build = UpdateQuery.builder(id)
                .withDocAsUpsert(false) //不加默认false。true表示更新时不存在就插入
                .withDocument(document)
                .build();
        restTemplate.update(build, IndexCoordinates.of(indexName));
    }

    /**
     * 根据maps批量更新
     *
     * @param maps      待更新的数据实体集合
     * @param indexName 索引名
     * @return void
     * @author Innocence
     */
    public void updateByMaps(List<Map<String, T>> maps, String indexName) {
        List<UpdateQuery> updateQueries = new ArrayList<>();
        maps.forEach(map -> map.forEach((id, data) -> {
            Map describe = null;
            try {
                describe = BeanUtils.describe(data);
                org.springframework.data.elasticsearch.core.document.Document document = org.springframework.data.elasticsearch.core.document.Document.from(describe);
                document.setId(id);
                UpdateQuery build = UpdateQuery.builder(document.getId())
                        .withDocument(document)
                        .build();
                updateQueries.add(build);
            } catch (Exception e) {
                throw new BusinessValidateException("批量更新失败");
            }
        }));
        restTemplate.bulkUpdate(updateQueries, IndexCoordinates.of(indexName));
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @param indexName 索引名
     * @return java.lang.String 被删除的id
     * @author Innocence
     */
    public String deleteById(String id, String indexName) {
        return restTemplate.delete(id, IndexCoordinates.of(indexName));
    }

    /**
     * 根据id批量删除数据
     *
     * @param docIdName 文档id字段名，如我们上面设置的文档id的字段名为“lngId”
     * @param ids       需要删除的id集合
     * @param indexName 索引名称
     * @return void
     * @author Innocence
     */
    public void deleteByIds(String docIdName, List<String> ids, String indexName,Class<T> clazz) {
        StringQuery query = new StringQuery(QueryBuilders.termsQuery(docIdName, ids).toString());
        restTemplate.delete(query, clazz, IndexCoordinates.of(indexName));
    }

    /**
     * 根据条件删除数据
     *
     * @param query     条件构造器
     * @param clazz     数据对应实体类
     * @param indexName 索引名
     * @return void
     * @author Innocence
     */
    public void deleteByQuery(Query query, Class<?> clazz, String indexName) {
        restTemplate.delete(query, clazz, IndexCoordinates.of(indexName));
    }


    /**
     * 构造查询器
     *
     * @param boTermQuery
     * @return
     */
    public BoolQueryBuilder createQueryBuilder(BoTermQuery boTermQuery) {
        List<Pair<String, ?>> termConditions = boTermQuery.getTermConditions();
        Map<String, Pair<?, ?>> rangeConditions = boTermQuery.getRangeConditions();
        List<Pair<?, String>> matchConditions = boTermQuery.getMatchConditions();

        BoTermQuery.Should should = boTermQuery.getShould();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (should != null) {
            boolQueryBuilder.minimumShouldMatch(should.getMinimumNumberShouldMatch());
            //should条件
            List<Pair<String, ?>> shouldTermConditions = should.getTermConditions();
            List<Pair<?, String>> shouldMatchConditions = should.getMatchConditions();
            Map<String, Pair<?, ?>> shouldRangeConditions = should.getRangeConditions();

            if (!CollectionUtils.isEmpty(shouldTermConditions)) {
                for (Pair<String, ?> shouldTermPair : shouldTermConditions) {
                    if (shouldTermPair.getValue() instanceof Collection) {
                        Collection<?> formatTermPair = (Collection<?>) shouldTermPair.getValue();
                        TermsQueryBuilder termsShouldQueryBuilder = QueryBuilders.termsQuery(shouldTermPair.getKey(), formatTermPair);
                        boolQueryBuilder.should(termsShouldQueryBuilder);
                    } else {
                        TermQueryBuilder termShouldQueryBuilder = QueryBuilders.termQuery(shouldTermPair.getKey(), shouldTermPair.getValue());
                        boolQueryBuilder.should(termShouldQueryBuilder);
                    }
                }
            }
            //匹配
            if (!CollectionUtils.isEmpty(shouldMatchConditions)) {
                for (Pair<?, String> shouldMatchPair : shouldMatchConditions) {
                    if (shouldMatchPair.getKey() instanceof String[]) {
                        String[] formatPairKey = (String[]) shouldMatchPair.getKey();
                        MultiMatchQueryBuilder multiShouldMatchQueryBuilder = QueryBuilders
                                .multiMatchQuery(shouldMatchPair.getValue(), formatPairKey);
                        boolQueryBuilder.should(multiShouldMatchQueryBuilder);
                    } else if (shouldMatchPair.getKey() instanceof String) {
                        String formatPairKey = (String) shouldMatchPair.getKey();
                        MatchQueryBuilder shouldMatchQueryBuilder = QueryBuilders
                                .matchQuery(formatPairKey, shouldMatchPair.getValue());
                        boolQueryBuilder.should(shouldMatchQueryBuilder);
                    }
                }
            }
            //范围
            if (!CollectionUtils.isEmpty(shouldRangeConditions)) {
                for (Map.Entry<String, Pair<?, ?>> shouldRangeEntry : shouldRangeConditions.entrySet()) {
                    RangeQueryBuilder rangeShouldQueryBuilder = QueryBuilders.rangeQuery(shouldRangeEntry.getKey());
                    rangeShouldQueryBuilder.to(shouldRangeEntry.getValue().getValue()).from(shouldRangeEntry.getValue().getKey());
                    boolQueryBuilder.should(rangeShouldQueryBuilder);
                }
            }
        }
        //过滤条件
        if (!CollectionUtils.isEmpty(termConditions)) {
            for (Pair<String, ?> termPair : termConditions) {
                if (termPair.getValue() instanceof Collection) {
                    Collection<?> formatTermPair = (Collection<?>) termPair.getValue();
                    TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery(termPair.getKey(), formatTermPair);
                    boolQueryBuilder.filter(termsQueryBuilder);
                } else {
                    TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(termPair.getKey(), termPair.getValue());
                    boolQueryBuilder.filter(termQueryBuilder);
                }
            }
        }
        //匹配条件
        if (!CollectionUtils.isEmpty(matchConditions)) {
            for (Pair<?, String> matchPair : matchConditions) {
                if (matchPair.getKey() instanceof String[]) {
                    String[] formatPairKey = (String[]) matchPair.getKey();
                    MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders
                            .multiMatchQuery(matchPair.getValue(), formatPairKey);
                    boolQueryBuilder.filter(multiMatchQueryBuilder);
                } else if (matchPair.getKey() instanceof String) {
                    String formatPairKey = (String) matchPair.getKey();
                    MatchQueryBuilder matchQueryBuilder = QueryBuilders
                            .matchQuery(formatPairKey, matchPair.getValue());
                    boolQueryBuilder.filter(matchQueryBuilder);
                }
            }
        }
        //range条件
        if (!CollectionUtils.isEmpty(rangeConditions)) {
            for (Map.Entry<String, Pair<?, ?>> rangeEntry : rangeConditions.entrySet()) {
                RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(rangeEntry.getKey());
                rangeQueryBuilder.to(rangeEntry.getValue().getValue()).from(rangeEntry.getValue().getKey());
                boolQueryBuilder.filter(rangeQueryBuilder);
            }
        }
        return boolQueryBuilder;
    }


}
