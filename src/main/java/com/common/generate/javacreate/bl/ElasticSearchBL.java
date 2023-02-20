/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.bl;
//
//import com.common.generate.javacreate.model.base.exception.BusinessException;
//import com.common.generate.javacreate.utils.AssertUtils;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//
//import io.searchbox.action.Action;
//import io.searchbox.client.JestClient;
//import io.searchbox.client.JestResult;
//import io.searchbox.core.Bulk;
//import io.searchbox.core.BulkResult;
//import io.searchbox.core.Delete;
//import io.searchbox.core.DeleteByQuery;
//import io.searchbox.core.Search;
//import io.searchbox.core.SearchResult;
//import io.searchbox.core.SearchScroll;
//import io.searchbox.core.Update;
//import io.searchbox.core.UpdateByQuery;
//import io.searchbox.params.Parameters;
//import org.apache.commons.lang3.time.StopWatch;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * es基本服务
 * @author xialei
 * @date 2021/11/21
 */
@Repository
public class ElasticSearchBL<T> {
//    private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchBL.class);

//    @Autowired
//    private JestClient jestClient;
//    @Autowired
//    private Gson gson;
//
//    public SearchResult search(Action<SearchResult> search) {
//        try {
//            StopWatch stopWatch = new StopWatch();
//            stopWatch.start();
//            SearchResult searchResult = jestClient.execute(search);
//            stopWatch.stop();
//            AssertUtils.isTrue(searchResult.isSucceeded(), searchResult.getErrorMessage());
//            if (LOG.isDebugEnabled()) {
//                LOG.info("查询条件: {} \n{}", search, search.getData(gson));
//            }
//            return searchResult;
//        } catch (Exception e) {
//            LOG.info("查询条件: {} \n{}", search, search.getData(gson));
//            throw new BusinessException("查询服务异常: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * 删除文档(订单)
//     */
//    public JestResult deleteDocument(String index, String type, String query) {
//        DeleteByQuery build = new DeleteByQuery
//                .Builder(query)
//                .addType(type)
//                .addIndex(index)
//                .build();
//        JestResult result;
//        try {
//            result = jestClient.execute(build);
//            String jsonString = result.getJsonString();
//            LOG.info("删除文档的信息：" + jsonString);
//        } catch (IOException e) {
//            throw new BusinessException("删除服务异常: " + e.getMessage(), e);
//        }
//        return result;
//    }
//
//    /**
//     * 删除文档(订单Id)
//     */
//    public void deleteDocumentById(String index, String type, Long id) {
//        if (id != null) {
//            String cityId = id.toString().substring(0, 3);
//            Delete delete = new Delete.Builder(id.toString())
//                    .index(index)
//                    .type(type)
//                    .refresh(true)
//                    .setParameter(Parameters.ROUTING, Integer.valueOf(cityId))
//                    .build();
//            try {
//                JestResult result = jestClient.execute(delete);
//                String jsonString = result.getJsonString();
//                LOG.info("删除文档的信息：" + jsonString);
//                LOG.info("删除订单ID == " + id);
//            } catch (IOException e) {
//                throw new BusinessException("删除服务异常: " + e.getMessage(), e);
//            }
//        }
//    }
//
//    /**
//     * 修改文档
//     */
//    public void updateDocumentByQuery(String index, String type, QueryBuilder queryBuilder, String param, Integer value, Integer cityId) {
//        String script = "ctx._source." + param + "=" + value + ";";
//        try {
//            String payload = jsonBuilder()
//                    .startObject()
//                    .field("query", queryBuilder)
//                    .startObject("script")
//                    .field("inline", script)
//                    .endObject()
//                    .endObject().string();
//
//            UpdateByQuery updateByQuery = new UpdateByQuery.Builder(payload)
//                    .addIndex(index)
//                    .addType(type)
//                    .setParameter(Parameters.ROUTING, cityId)
//                    .build();
//
//            JestResult result = jestClient.execute(updateByQuery);
//            String jsonString = result.getJsonString();
//            LOG.info("修改文档的信息：" + jsonString);
//        } catch (IOException e) {
//            throw new BusinessException("修改文档服务异常: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * 批量修改文档
//     */
//    public void bulkUpdateDocument(Map<Long, Integer> map, Integer cityId) {
//        try {
//            Bulk.Builder builder = new Bulk.Builder()
//                    .defaultIndex("searchproductsku")
//                    .defaultType("searchproductsku");
//            map.forEach((k, v) -> {
//                String script = "{" +
//                        "\"doc\" : {" +
//                        "\"fullReduceProductRuleItemId\" : " + v +
//                        "}}";
//                builder.addAction(new Update.Builder(script)
//                        .id(String.valueOf(k))
//                        .setParameter(Parameters.ROUTING, cityId)
//                        .build());
//            });
//            BulkResult execute = jestClient.execute(builder.build());
//            List<BulkResult.BulkResultItem> failedItems = execute.getFailedItems();
//            boolean succeeded = execute.isSucceeded();
//            List<BulkResult.BulkResultItem> items = execute.getItems();
//            LOG.info("设置文档操作：{},失败项：{},更新项：{}", succeeded,
//                    gson.toJson(failedItems), gson.toJson(items));
//        } catch (IOException e) {
//            throw new BusinessException("修改文档服务异常: " + e.getMessage(), e);
//        }
//    }


//    public PageableResult<T> searchScroll(String index, String type, QueryBuilder queryBuilder, Class<T> tClass, Integer pageSize) {
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(queryBuilder);
//        LOG.info("scroll搜索,{}", gson.toJson(searchSourceBuilder));
//        try {
//            Search search = new Search.Builder(searchSourceBuilder.toString())
//                    .addIndex(index)
//                    .addType(type)
//                    .setParameter(Parameters.SCROLL, "1m")
//                    .setParameter(Parameters.SIZE, pageSize)
//                    .build();
//            JestResult result = jestClient.execute(search);
//
//            JsonObject jsonObject = result.getJsonObject().getAsJsonObject("hits");
//            JsonElement totalJsonElement = jsonObject.get("total");
//            int total = totalJsonElement.getAsInt();
//            JsonArray hits = jsonObject.getAsJsonArray("hits");
//            List<T> list = new ArrayList<>();
//            hits.forEach(p -> {
//                JsonObject jo = p.getAsJsonObject();
//                JsonElement source = jo.getAsJsonObject("_source");
//                T t = gson.fromJson(source, tClass);
//                list.add(t);
//            });
//            PageableResult<T> scrollResultDTO = new PageableResult<>();
//            scrollResultDTO.setDatas(list);
//            scrollResultDTO.setRecordCount(total);
//            return scrollResultDTO;
//        } catch (IOException e) {
//            throw new BusinessException("scroll查询服务异常: " + e.getMessage(), e);
//        }
//    }
//
//
//    public PageableResult<T> getDocumentByScrollId(String scrollId, Class<T> clazz) {
//        try {
//            List<T> tList = new ArrayList<>();
//            SearchScroll scroll = new SearchScroll.Builder(scrollId, "1m").build();
//            JestResult result = jestClient.execute(scroll);
//
//            JsonArray hits = result.getJsonObject().getAsJsonObject("hits").getAsJsonArray("hits");
//            hits.forEach(p -> {
//                JsonObject jo = p.getAsJsonObject();
//                JsonElement source = jo.getAsJsonObject("_source");
//                T t = gson.fromJson(source, clazz);
//                tList.add(t);
//            });
//            PageableResult<T> scrollResultDTO = new PageableResult<>();
//            scrollResultDTO.setDatas(tList);
//            return scrollResultDTO;
//        } catch (IOException e) {
//            throw new BusinessException("scroll查询服务异常: " + e.getMessage(), e);
//        }
//    }

//
//    /**
//     * 删除索引
//     * @param indexName
//     */
//    public boolean deleteIndex(String indexName) {
//        try {
//            JestResult result = jestClient.execute(new Delete.Builder(null).index(indexName).build());
//            if (result != null && !result.isSucceeded()) {
//                throw new RuntimeException(result.getErrorMessage()+"删除索引失败!");
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }



}