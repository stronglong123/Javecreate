package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.dto.FindStoreQueryDTO;
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
        baseUrl = getUrl("pre");
        deal("tss");
    }

    public static String getUrl(String system) {
        switch (system) {
            case "test":
                return TESTBASEURL;
            case "release":
                return TESTBASEURL;
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
        }
    }

    public static void ruike() {
        String appSecret = "75e5038e7397e5fe0ab0360cfe921308";
        String appKey = "3cb482c84106461698d44c8814a64ffd";
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
        String appSecret = "4c41d2fdd2490b70468d1b95e6b2c140";
        String appKey = "e46ef0c5-ae7d-4647-ac3a-e46ef0c5ae7d4647ac3a333864d21adb";
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
//        orderSendSync(appSecret,appKey);
//        findSplitOrder(appSecret,appKey);
        findStorePage(appSecret,appKey);

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
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public static void getOrderList(String appSecret, String appKey) {
        String url = baseUrl + "/order/getOrderList";
        System.out.println("订单获取" + url);
        String json = "{\"pageSize\":20,\"orderCreateTimeStart\":\"2020-10-21 00:00:00\",\"orderCreateTimeEnd\":\"2020-11-13 23:59:59\",\"currentPage\":1}";
        OrderQueryDTO orderQueryDTO = JSON.parseObject(json, OrderQueryDTO.class);
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
        String json = "{\"businessNo\":\"998002201102150613\"}";
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
        String json = "{\"businessNo\":\"412032900096\"}";
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
    public static void orderSendSync(String appSecret, String appKey) {
        String url = baseUrl + "/order/orderSendSync";
        System.out.println("订单发货同步：" + url);
        String json = "{\n" +
                "    \"businessNo\": \"998002201102150613\",\n" +
                "    \"logstics\": [\n" +
                "        {\n" +
                "            \"logisticsCompany\": \"顺丰速运\",\n" +
                "            \"logisticsCompanyCode\": \"SF\",\n" +
                "            \"logisticsNo\": \"24312424\",\n" +
                "            \"subOrderItems\": [\n" +
                "                {\n" +
                "                    \"orderItemId\": 998001201102151638\n" +
                "                }\n" +
                "            ],\n" +
                "        },\n" +
                "        {\n" +
                "            \"logisticsCompany\": \"顺丰速运\",\n" +
                "            \"logisticsCompanyCode\": \"SF\",\n" +
                "            \"logisticsNo\": \"5424133\",\n" +
                "            \"subOrderItems\": [\n" +
                "                {\n" +
                "                    \"orderItemId\": 998001201102151639\n" +
                "                }\n" +
                "            ],\n" +
                "        }\n" +
                "    ],\n" +
                "    \"subOrderSize\": 2\n" +
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
