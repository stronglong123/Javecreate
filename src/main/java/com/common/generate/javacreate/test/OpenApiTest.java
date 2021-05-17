package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.dto.FindStoreQueryDTO;
import com.common.generate.javacreate.test.dto.OrderLogisticsSyncDTO;
import com.common.generate.javacreate.test.dto.OrderQueryDTO;
import com.common.generate.javacreate.test.dto.OrderSendSyncDTO;
import com.common.generate.javacreate.test.dto.PaymentReturnInfoQueryDTO;
import com.common.generate.javacreate.test.dto.ProductSkuListSO;
import com.common.generate.javacreate.test.dto.ThirdOrderCancelDTO;
import com.common.generate.javacreate.test.dto.ThirdReturnOrderQueryDTO;
import com.common.generate.javacreate.authutils.AuthUtil;
import com.common.generate.javacreate.utils.HttpUtil;

import java.util.Arrays;

/**
 * @author xialei
 * @date 2020/10/21 16:40
 */
public class OpenApiTest {


    private static final String TESTBASEURL = "http://api.test.yijiupi.com";
    private static final String RELEASEBASEURL = "http://api.release.yijiupidev.com";
    private static final String PRODUCTBASEURL = "https://api.yijiupi.com";
    private static final String PREBASEURL = "http://api.pre.yijiupi.com";
    private static final String BASEURL = "http://localhost:40000";
    private static String baseUrl;

    public static void main(String[] args) {
        baseUrl = getUrl("product");
        deal("test");
    }

    public static String getUrl(String system) {
        switch (system) {
            case "test":
                return TESTBASEURL;
            case "release":
                return RELEASEBASEURL;
            case "product":
                return PRODUCTBASEURL;
            case "pre":
                return PREBASEURL;
            default:
                return BASEURL;
        }
    }

    public static void deal(String system) {
        switch (system) {
            case "ruike":
                ruike();
                break;
            case "test":
                test();
                break;
            case "gjp":
                gjp();
                break;
            case "tss":
                tss();
                break;
            case "wdt":
                wdt();
            case "yd":
                yd();
            case "rq":
                rq();
                break;
        }
    }



    public static void rq() {
        String appKey = "c7e7848230da4885b63159b74b771c37";
        String appSecret = "8ca90846a0d8f2c4a6331b5c90b69ab7";

        getOrderList(appSecret, appKey);
        getOrderDetail(appSecret, appKey);

//        getReturnOrderList(appSecret, appKey);
//        getReturnPaymentState(appSecret, appKey);
//        listProductSku(appSecret, appKey);
//        orderSendSync(appSecret, appKey);
//        orderShipping(appSecret, appKey);
//        findSplitOrder(appSecret,appKey);
//        findStorePage(appSecret,appKey);
//        logisticsCompany(appSecret, appKey);

    }


    public static void yd() {
        String appKey = "64c25c3c9f9342968ef41d656a3849af";
        String appSecret = "e2aeddc072ffeaf641b5316cffe73426";

        getOrderList(appSecret, appKey);
        getOrderDetail(appSecret, appKey);

//        getReturnOrderList(appSecret, appKey);
//        getReturnPaymentState(appSecret, appKey);
//        listProductSku(appSecret, appKey);
//        orderSendSync(appSecret, appKey);
//        orderShipping(appSecret, appKey);
//        findSplitOrder(appSecret,appKey);
//        findStorePage(appSecret,appKey);
//        logisticsCompany(appSecret, appKey);

    }


    public static void wdt() {
        String appSecret = "f886c70b88d0a13eefcde3f36f940bc2";
        String appKey = "7ef15e875c4f4962b60778f4dfd3dcfe";

        getOrderList(appSecret, appKey);
        getOrderDetail(appSecret, appKey);

//        getReturnOrderList(appSecret, appKey);
//        getReturnPaymentState(appSecret, appKey);
//        listProductSku(appSecret, appKey);
//        orderSendSync(appSecret, appKey);
//        orderShipping(appSecret, appKey);
//        findSplitOrder(appSecret,appKey);
//        findStorePage(appSecret,appKey);
//        logisticsCompany(appSecret, appKey);

    }

    public static void ruike() {
//        String appSecret = "75e5038e7397e5fe0ab0360cfe921308";
//        String appKey = "3cb482c84106461698d44c8814a64ffd";

        String appSecret = "083bb928434cd43a9ec297b6a56435ae";
        String appKey = "a56b7ace805d4d18ae787e72e847ac79";
        getOrderList(appSecret, appKey);
//        getOrderDetail(appSecret, appKey);

//        getReturnOrderList(appSecret, appKey);
//        getReturnPaymentState(appSecret, appKey);
//        listProductSku(appSecret, appKey);
//        orderSendSync(appSecret, appKey);
//        findSplitOrder(appSecret,appKey);
//        findStorePage(appSecret,appKey);

    }


    public static void test() {
//        String appSecret = "4c41d2fdd2490b70468d1b95e6b2c140";
//        String appKey = "e46ef0c5-ae7d-4647-ac3a-e46ef0c5ae7d4647ac3a333864d21adb";

        String appSecret = "761f34725006ee79069773f971ea5344";
        String appKey = "7ed411e9ce1f41248cd90b878b7f8346";
        getOrderList(appSecret, appKey);
//        getOrderDetail(appSecret, appKey);
//        getReturnOrderList(appSecret, appKey);
//        getReturnPaymentState(appSecret, appKey);
//        listProductSku(appSecret, appKey);
//        orderSendSync(appSecret, appKey);
//        findSplitOrder(appSecret, appKey);
//        directOutStockByOrder(appSecret,appKey);
//        findStorePage(appSecret,appKey);
//        cancelOrderRequest(appSecret,appKey);

    }

    public static void gjp() {
        String appSecret = "0a9257677ca7143799a6bc625ed2574a";
        String appKey = "ff431ba1da5249d398940657785140a1";
//        getOrderList(appSecret, appKey);
//        getOrderDetail(appSecret, appKey);
//        getReturnOrderList(appSecret, appKey);
//        getReturnPaymentState(appSecret, appKey);
//        listProductSku(appSecret, appKey);
        orderSendSync(appSecret,appKey);
//        findSplitOrder(appSecret,appKey);
//        findStorePage(appSecret,appKey);
//        cancelOrderRequest(appSecret,appKey);

    }

    public static void tss() {
        String appSecret = "c91289a5fda435a3a09ff9528864a2c9\n";
        String appKey = "63750c273b064daa8e0b66e37377b67e";
//        getOrderList(appSecret, appKey);
//        getOrderDetail(appSecret, appKey);
//        getReturnOrderList(appSecret, appKey);
//        getReturnPaymentState(appSecret, appKey);
//        listProductSku(appSecret, appKey);
//        orderSendSync(appSecret,appKey);
//        findSplitOrder(appSecret,appKey);
//        findStorePage(appSecret,appKey);
        cancelOrderRequest(appSecret,appKey);
    }



    /**
     * 获取快递信息
     *
     * @param appSecret
     * @param appKey
     */
    public static void logisticsCompany(String appSecret, String appKey) {
        String url = baseUrl + "/logisticsCompany/list";
        System.out.println("获取快递信息" + url);
        String json = "{}";
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey);
        try {
            System.out.println("url:" + urlWithAuth);
            String post = HttpUtil.post(urlWithAuth, "{}");
            System.out.println("订单获取：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public static void getOrderList(String appSecret, String appKey) {
        String url = baseUrl + "/order/getOrderList";
        System.out.println("订单获取" + url);
        String json = "{\"currentPage\":1,\"orderCreateTimeStart\":\"2021-03-10 12:21:00\",\"orderCreateTimeEnd\":\"2021-03-11 15:21:00\",\"pageSize\":20}";
        OrderQueryDTO orderQueryDTO = JSON.parseObject(json, OrderQueryDTO.class);
//        orderQueryDTO.setBusinessNo("428107000056-2");
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, OrderQueryDTO.class, orderQueryDTO);
        try {
            System.out.println("url:" + urlWithAuth);
            System.out.println("data:" + JSON.toJSONString(orderQueryDTO));
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(orderQueryDTO));
            System.out.println("订单获取：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public static void getOrderDetail(String appSecret, String appKey) {
        String url = baseUrl + "/order/getOrderDetail";
        System.out.println("订单详情获取" + url);
        String json = "{\"businessNo\":\"428107000056-2\"}";
        OrderQueryDTO orderQueryDTO = JSON.parseObject(json, OrderQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, OrderQueryDTO.class, orderQueryDTO);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(orderQueryDTO));
            System.out.println("订单详情获取：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public static void cancelOrderRequest(String appSecret, String appKey) {
        String url = baseUrl + "/order/cancelOrderRequest";
        System.out.println("订单取消：" + url);
        String json = "{\"businessNo\":\"998033700008--1\"}";
        ThirdOrderCancelDTO cancelDTO = JSON.parseObject(json, ThirdOrderCancelDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdOrderCancelDTO.class, cancelDTO);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(cancelDTO));
            System.out.println("订单取消：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 获取退货单
     *
     * @param appSecret
     * @param appKey
     */
    public static void getReturnOrderList(String appSecret, String appKey) {
        String url = baseUrl + "/order/getReturnOrderList";
        System.out.println("退货单获取" + url);
//        String json = "{\"refNo\":\"TEST99802960001\",\"currentPage\":1,\"orderCreateTimeStart\":\"2020:10:15 14:12:49\",\"orderCreateTimeEnd\":\"2020:11:14 00:00:00\",\"pageSize\":20}";
        String json = "{\n" +
                "    \"currentPage\": 1,\n" +
                "    \"orderCreateTimeEnd\": \"2020-11-05 23:59:59\",\n" +
                "    \"orderCreateTimeStart\": \"2020-10-20 00:00:00\",\n" +
                "    \"businessNo\": \"998030000002\",\n" +
                "    \"pageSize\": 10,\n" +
                "}";
        ThirdReturnOrderQueryDTO dto = JSON.parseObject(json, ThirdReturnOrderQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ThirdReturnOrderQueryDTO.class, dto);
        try {
            System.out.println("url:" + urlWithAuth);
            System.out.println("data:" + JSON.toJSONString(dto));

            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("退货单获取：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }


    /**
     * 获取退款状态
     *
     * @param appSecret
     * @param appKey
     */
    public static void getReturnPaymentState(String appSecret, String appKey) {
        String url = baseUrl + "/order/getReturnPaymentState";
        System.out.println("获取退款状态" + url);
        String json = "{\"orderNo\":\"998030000001\"}";
        PaymentReturnInfoQueryDTO dto = JSON.parseObject(json, PaymentReturnInfoQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, PaymentReturnInfoQueryDTO.class, dto);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("获取退款状态：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }


    /**
     * 查询产品SKU
     *
     * @param appSecret
     * @param appKey
     */
    public static void listProductSku(String appSecret, String appKey) {
        String url = baseUrl + "/productSku/listProductSku";
        System.out.println("查询产品SKU：" + url);
        String json = "{\"pageNum\":1,\"pageSize\":10,\"cityId\":998,\"warehouseId\":11,\"lastUpdateTimeStart\":\"2020-10-13 12:48:40\",\"lastUpdateTimeEnd\":\"2020-11-13 12:48:40\"}";
        ProductSkuListSO dto = JSON.parseObject(json, ProductSkuListSO.class);
        dto.setProductSkuIdList(Arrays.asList(99900119334650L));

        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, ProductSkuListSO.class, dto);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("查询产品SKU：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }


    /**
     * 直接出库
     *
     * @param appSecret
     * @param appKey
     */
    public static void directOutStockByOrder(String appSecret, String appKey) {
        String url = baseUrl + "/order/directOutStockByOrder";
        System.out.println("直接出库：" + url);
        String json = "{\"code\":\"TEST99800220103011060301\"}";
        OrderQueryDTO dto = JSON.parseObject(json, OrderQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, OrderQueryDTO.class, dto);
        try {
            System.out.println("订单发货同步参数：" + JSON.toJSONString(dto));
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("直接出库：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }


    /**
     * 订单发货同步
     *
     * @param appSecret
     * @param appKey
     */
    public static void orderShipping(String appSecret, String appKey) {
        String url = baseUrl + "/order/orderShipping";
        System.out.println("订单发货同步：" + url);
        String json = "{ \"omsOrderId\" : \"omsOrderId\", \"businessNo\" : \"998016100017-2\", \"logisticsCompany\" : \"韵达快递\", \"logisticsCompanyCode\" : \"YD\", \"logisticsNo\" : \"11111\"}";
        OrderLogisticsSyncDTO dto = JSON.parseObject(json, OrderLogisticsSyncDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, OrderLogisticsSyncDTO.class, dto);
        try {
            System.out.println("订单发货同步参数：" + JSON.toJSONString(dto) + ",url:" + urlWithAuth);
//            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
//            System.out.println("订单发货同步：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }


    /**
     * 订单发货同步
     *
     * @param appSecret
     * @param appKey
     */
    public static void orderSendSync(String appSecret, String appKey) {
        String url = baseUrl + "/order/orderSendSync";
        System.out.println("订单发货同步：" + url);
//        String json = "{\n" +
//                "    \"businessNo\": \"998010800006\",\n" +
//                "    \"logstics\": [\n" +
//                "        {\n" +
////                "            \"logisticsCompany\": \"顺丰速运\",\n" +
////                "            \"logisticsCompanyCode\": \"SF\",\n" +
////                "            \"logisticsNo\": \"24312424\",\n" +
//                "            \"subOrderNo\": \"998010800006--1\",\n" +
//                "            \"subOrderItems\": [\n" +
//                "                {\n" +
//                "                    \"orderItemId\": 998120041711630312\n" +
//                "                }\n" +
//                "            ],\n" +
//                "        },\n" +
//                "        {\n" +
////                "            \"logisticsCompany\": \"顺丰速运\",\n" +
////                "            \"logisticsCompanyCode\": \"SF\",\n" +
////                "            \"logisticsNo\": \"5424133\",\n" +
//                "            \"subOrderNo\": \"998010800006--2\",\n" +
//                "            \"subOrderItems\": [\n" +
//                "                {\n" +
//                "                    \"orderItemId\": 998120041711630322\n" +
//                "                }\n" +
//                "            ],\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"subOrderSize\": 2\n" +
//                "}";
        String json ="{\n" +
                "    \"businessNo\": \"998016100017-2\",\n" +
                "    \"logstics\": [\n" +
                "        {\n" +
//                "            \"logisticsCompany\": \"韵达快递\",\n" +
//                "            \"logisticsCompanyCode\": \"001\",\n" +
//                "            \"logisticsNo\": \"4310617028378\",\n" +
                "            \"subOrderNo\": \"998016100017-2\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"subOrderSize\": \"1\"\n" +
                "}";
        OrderSendSyncDTO dto = JSON.parseObject(json, OrderSendSyncDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, OrderSendSyncDTO.class, dto);
        try {
            System.out.println("订单发货同步参数：" + JSON.toJSONString(dto));
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("订单发货同步：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 查询拆分订单接口
     *
     * @param appSecret
     * @param appKey
     */
    public static void findSplitOrder(String appSecret, String appKey) {
        String url = baseUrl + "/order/findSplitOrder";
        System.out.println("查询拆分订单接口：" + url);
        String json = "{\"businessNo\":\"998002201102152914\"}";
        OrderQueryDTO dto = JSON.parseObject(json, OrderQueryDTO.class);
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, OrderQueryDTO.class, dto);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("查询拆分订单接口：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    /**
     * 查询库存
     *
     * @param appSecret
     * @param appKey
     */
    public static void findStorePage(String appSecret, String appKey) {
        String url = baseUrl + "/store/findStorePage";
        System.out.println("查询库存：" + url);
        String json = "{\"pageNum\":1,\"pageSize\":10,}";
        FindStoreQueryDTO dto = JSON.parseObject(json, FindStoreQueryDTO.class);
        dto.setProductSkuIds(Arrays.asList(99900119334650L));
        String urlWithAuth = AuthUtil.getUrlWithAuth(url, appSecret, appKey, FindStoreQueryDTO.class, dto);
        try {
            String post = HttpUtil.post(urlWithAuth, JSON.toJSONString(dto));
            System.out.println("查询库存：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }



}
