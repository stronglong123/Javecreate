package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.PageableResult;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.ordercenter.dto.ChangeCountMarkDTO;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.EsOrderSyncDTO;
import com.common.generate.javacreate.ordercenter.dto.PushSaleOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.PushTmsPayConfirmDTO;
import com.common.generate.javacreate.ordercenter.dto.RepairBusinessItemIdDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderItemDTO;
import com.common.generate.javacreate.ordercenter.dto.TrainsOutStockDTO;
import com.common.generate.javacreate.ordercenter.dto.TrainsOutStockDealerDTO;
import com.common.generate.javacreate.ordercenter.dto.TrainsOutStockOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.UpdateSecOwnerDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityManageDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityQueryDTO;
import com.common.generate.javacreate.ordercenter.dto.data.OrderBO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventConsumptionAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.utils.SignUtil;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/11/21 13:44
 */
@Service
public class NewApiTest {

    private static final String testUrl = "http://ocop.test.yijiupidev.com/";

    private static final String releaseUrl = "http://ocop.release.yijiupidev.com/";

    private static final String preUrl = "http://ocop.pre.yijiupi.com/";

    private static final String testToken = "41189675-7513-4bd4-af46-db644ff69ac0";

    private static final String releaseToken = "01879606-60eb-4e2e-8e4b-b03590b6aeec";

    private static final String token = "63da1d63-b0d1-4acf-9623-7692095596e2";


    private static String getUrl(String code) {
        switch (code) {
            case "test":
                return testUrl;
            case "release":
                return releaseUrl;
            case "pre":
                return preUrl;
        }
        return testUrl;
    }

    private static String getToken(String code) {
        switch (code) {
            case "test":
                return testToken;
            case "release":
                return releaseToken;
            case "pre":
                return token;
        }
        return token;
    }

    @SneakyThrows
    public static void main(String[] args) {
//        expressDispatchNotifyList();
//        saveWarehouseConfig("pre");
//        fixModify();
//        UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
//        updateSecOwnerDTO.setId(1111L);
//        updateSecOwnerDTO.setWarehouseId(99991);
//        updateItemSercOwner("release",updateSecOwnerDTO);

//        ChangeCountMarkDTO changeCountMarkDTO =new ChangeCountMarkDTO();
//        changeCountMarkDTO.setOrderId(7010002304210916769L);
//        changeCountMarkDTO.setWarehouseId(7201L);

//        TrainsOutStockDTO preData = getPreData();
//        System.out.println(JSON.toJSONString(preData));
//        nptOutSyncErp("pre");

//            repairReturnComplete(5162088339163517276L);

        //        deleteByOrderId(5157699752078807362L);

//        update("release");
//        retrySyncOrderByOrderIds("release",5031224347955159367L);

//        repairErpSaleCompleteEventError("pre");


        List<Long> orderIds = getOrderIds();
        for (Long orderId : orderIds) {
//            repairSaleDisPatch(orderId);
//            orderSyncEs("pre",orderId);
//            retrySyncOrderItemOwnerByOrderIds("pre",orderId);

//            startOrderCenter(orderId);
//            cancelTransferOrder("pre", orderId);
//            repairSaleComplete(orderId);
//            repairReturnComplete(orderId);
//            completeSaleOrder("pre",orderId);
//            pullScmTransferOrderToOrderCenter("pre",orderId);
//            deleteByOrderId("release", orderId);
//            saleOrderPushWms(orderId);
//            Thread.sleep(500);
//            retrySyncOrderByOrderIds("pre", orderId);
//            pushFms("pre", orderId);
//            auditComplete("pre", orderId);
        }

//        for (Long orderId : orderIds) {
////            retrySyncOrderByOrderIds("pre", orderId);
////            initOrderCenterByOmsorderIds("pre",orderId);
//        }

//        warehouseConfigAdd();
//        repairErpSaleComplete(1L);
//        repairErpSaleComplete(5089272559036502528L);

//        RepairBusinessItemIdDTO repairBusinessItemIdDTO =new RepairBusinessItemIdDTO();
//        repairBusinessItemIdDTO.setOrderId(4040002212261627142L);
//        repairBusinessItemIdDTO.setOrderItemId(4040012212261600318L);
//        //5131285277274186182
//        repairBusinessItemIdDTO.setBusinessItemId("5139208355702886668");
//        //999001221209226954
//        repairBusinessItemIdDTO.setSourceOrderItemId(4040012212102341200L);
//        repairReturnOrderBusinessItemId(repairBusinessItemIdDTO);
    }

    public static void initOrderCenterByOmsorderIds(String code, Long orderId) {
        String params = "{\n" +
                "  \"omsorderIds\": [\n" +
                orderId +
                "  ]\n" +
                "  ,\n" +
                "  \"skipGrapCheck\":true\n" +
                "}";
        String url = "http://openapi.release.yijiupidev.com/openapi/oms/initOrderCenterByOmsorderIds";
        if ("pre".equals(code)) {
            url = "http://openapi.pre.yijiupi.com/openapi/oms/initOrderCenterByOmsorderIds";
        }
        String resultstr = HttpClientUtils.doPost(url, params);
    }


    private static List<Long> getOrderIds() {
        return Arrays.asList(
        );
    }


    private static void fixModify() {
        String json = "[\n" +
                "    {\n" +
                "        \"orderId\": 5182927564911535180,\n" +
                "        \"warehouseId\": 4721\n" +
                "    }\n" +
                "]";

//        String json ="[\n" +
//                "    {\n" +
//                "        \"orderId\": 998000230425156485,\n" +
//                "        \"warehouseId\": 9981" +
//                "    }\n" +
//                "]";
        List<ChangeCountMarkDTO> changeCountMarkDTOS = JSON.parseArray(json, ChangeCountMarkDTO.class);
        for (ChangeCountMarkDTO countMarkDTO : changeCountMarkDTOS) {
            retryChangeCountMarkByOrderId("pre", countMarkDTO);
        }
    }

    public static void evnetTrySaleComplete(Long orderId) {
        String baseUrl = getUrl("pre");
        String url = baseUrl + "ordercenter-event-managerms/action/PublishEventRetryService/retry";
        List<String> params = Arrays.asList("{\"orderId\":" + orderId + ",\"completeTime\":\"2023-04-10T14:00:00.350+08:00\",\"reason\":\"系统自动完成\"}", "DispatchAutoComplete:5136651219371885133_1671435634759_1671435783274");
        String body = JSON.toJSONString(params);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    /**
     * 消费者查询
     *
     * @return
     */
    public static List<ServiceAbilityManageDTO> findPageAblity() {
        String url = "http://ocop.release.yijiupidev.com/ordercenter-ability-managerms/ServiceAbilityManageService/findPageByCondition";
        String body = "[{\"pageIndex\":1,\"pageSize\":20}]";
        String token = "ae0ac0f2-e9d7-42e9-8431-510c7c02f5a8";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<ServiceAbilityManageDTO> resultList = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), ServiceAbilityManageDTO.class);
        return resultList;
    }

    /**
     * 消费者查询
     *
     * @return
     */
    public static void getTransferNoteList() {
        String url = "http://wms.release.yijiupidev.com/supplyChain/transfernote/getTransferNoteList";
        String body = "{\"pageNum\":3,\"pageSize\":20,\"beginTime\":1666416957076,\"endTime\":1669132799999,\"warehouseId\":9981}";
        String token = "0cc792a8-c36b-4490-bef3-4df9894a6135";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);

    }


    /**
     * 消费者查询
     *
     * @return
     */
    public static void retrySyncOrderByOrderIds(String code, Long orderId) {
        String baseUrl = getUrl(code);

        String token = getToken(code);
        String url = baseUrl + "ordercenter-elasticsearchsync-basems/EsRetrySyncService/retrySyncOrderByOrderIds";
        String body = "[[" + orderId + "]]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    /**
     * 消费者查询
     *
     * @return
     */
    public static void deleteByOrderId(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairOrderByOrderId";
        String body = "[[" + orderId + "]]";
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void saleOrderPushWms(Long orderId) {
        String code = "pre";
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-datasync-servicems/WmsRepairService/saleOrderPushWms";
        String body = "[[" + orderId + "]]";
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);

    }


    public static void repairErpSaleComplete(Long orderId) {
        String baseUrl = getUrl("pre");
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairErpSaleComplete";
        String body = "[[" + orderId + "]]";
        String token = "ec473598-5493-47ce-8123-dcdab96b654c";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void repairSaleComplete(Long orderId) {
        String code = "pre";
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairSaleComplete";
        String body = "[[" + orderId + "]]";
//        String token = "b2fcc534-7106-42ef-ba1e-f798900759c5";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void repairSaleDisPatch(Long orderId) {
        String code = "pre";
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairSaleDisPatch";
        String body = "[[" + orderId + "]]";
//        String token = "b2fcc534-7106-42ef-ba1e-f798900759c5";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void repairReturnComplete(Long orderId) {
        String code = "pre";
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairReturnComplete";
        String body = "[[" + orderId + "]]";
//        String token = "b2fcc534-7106-42ef-ba1e-f798900759c5";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void repairReturnOrderBusinessItemId(RepairBusinessItemIdDTO repairBusinessItemIdDTO) {
        String baseUrl = getUrl("pre");
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairReturnOrderBusinessItemId";
        String body = "[[" + JSON.toJSONString(repairBusinessItemIdDTO) + "]]";
//        String token = "b2fcc534-7106-42ef-ba1e-f798900759c5";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void updateBatchAllocatesSecOwner(Long orderId) {
        String baseUrl = getUrl("pre");
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateBatchAllocatesSecOwner";
        String body = "[[" + orderId + "],\"YJP-TRD\"]";
        String token = "b2fcc534-7106-42ef-ba1e-f798900759c5";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void retrySyncSaleOrder() {
        String url = "http://ocop.release.yijiupidev.com/ordercenter-datasync-servicems/OrderRepairService/retrySyncSaleOrder";
        String body = "{\"address_Id\":1088032227,\"allotType\":0,\"balanceAmount\":0.00,\"businessNo\":\"996233600010\",\"businessType\":1,\"business_Id\":996422120209139747,\"city\":\"林芝市\",\"combineStatus\":0,\"companyCode\":\"YJP\",\"contact\":\"接口测试\",\"contactCompanyName\":\"接口测试\",\"contactLatitude\":29.7887650,\"contactLongitude\":93.8517530,\"contactPhone\":\"18827040216\",\"county\":\"朗县\",\"createTime\":1669943544000,\"createUser_Id\":301395,\"delayEntryType\":1,\"deliveryFeePayer\":0,\"deliveryMode\":0,\"deliveryState\":-1,\"detailAddress\":\"测试地址\",\"discountAmount\":0.00,\"driverOrderAmount\":20.00,\"exceptionStatus\":0,\"fromCity_Id\":996,\"fromWarehouse_Id\":0,\"giveBonusAmount\":0.00,\"giveCouponAmount\":0.00,\"id\":996000221202092001,\"jiupiOrderSource\":1,\"jiupiOrderTableId\":996002221202091353,\"jiupiOrderTableOrderType\":0,\"jiupiOrderTableOrgId\":996,\"jiupiOrderTableWarehouseId\":9961,\"jiupiOrderType\":0,\"jiupiShop_Id\":9996,\"lastUpdateTime\":1669943552000,\"lastUpdateUser_Id\":301395,\"optType\":true,\"orderAmount\":20.00,\"orderCreateTime\":1669943543000,\"orderItemBOList\":[{\"boxCode\":\"6921317939200\",\"businessItem_Id\":5130402067822540945,\"business_Id\":996422120209139747,\"chgWarehouseId\":false,\"createTime\":1669943545000,\"createUser_Id\":301395,\"deliveryAmount\":0.00,\"discountAmount\":0.00,\"force\":false,\"id\":996001221202094378,\"inventoryCount\":1.000000,\"jiupiOrderItemTableId\":996003221202093946,\"jiupiOrder_Id\":996002221202091353,\"lastUpdateTime\":1669943545000,\"lastUpdateUser_Id\":301395,\"minUnitTotalCount\":16.000000,\"orderItem_Id\":996001221202094378,\"order_Id\":996000221202092001,\"originalSaleCount\":1.000000,\"packageName\":\"件\",\"payableAmount\":20.00,\"productBrand\":\"康师傅\",\"productBusinessClass\":0,\"productName\":\"康师傅鲜果橙500ml（1*16）\",\"productSaleSpec\":\"16瓶/件\",\"productSku_Id\":4898851427522006924,\"productSpec\":\"16瓶/件\",\"productStatisticsClass\":4729627945492273810,\"productType\":0,\"reduceBonusAmount\":0.00,\"reduceCouponAmount\":0.00,\"reduceOrderAmount\":0.00,\"reduceProductAmount\":0.00,\"replacePurchaseWithSales\":0,\"saleCount\":1.000000,\"saleMode\":0,\"saleSpecQuantity\":16.000000,\"selfPickUpReduceAmount\":0.00,\"sellPrice\":20.000000,\"sellPriceUnit\":\"件\",\"sellUnit\":\"件\",\"skuRef_Id\":99600328248259,\"sourceType\":19,\"source_Id\":\"5126429591508705297\",\"specQuantity\":16.000000,\"specification_Id\":328248,\"statisticsCategoryName\":\"饮料\",\"supplyCostPrice\":0.000000,\"totalAmount\":20.00,\"unitName\":\"瓶\"}],\"orderSequence\":4728,\"orderTraceBOList\":[{\"business_Id\":996422120209139747,\"createTime\":1669943545000,\"description\":\"审核处理[审核通过]\",\"id\":996006221202090260,\"lastUpdateTime\":1669943545000,\"mouldShowType\":1,\"org_Id\":996,\"tag\":\"\"},{\"business_Id\":996422120209139747,\"createTime\":1669943545000,\"description\":\"用户下单成功，订单类型为销售订单(仓库配送)\",\"id\":996006221202090261,\"lastUpdateTime\":1669943545000,\"mouldShowType\":1,\"org_Id\":996,\"tag\":\"\"},{\"business_Id\":996000221202092001,\"createTime\":1669943545000,\"description\":\"运单同步成功\",\"lastUpdateTime\":1669943545000,\"mouldShowType\":1,\"tag\":\"\"},{\"business_Id\":996422120209139747,\"createTime\":1669943552000,\"description\":\"订单取消,取消类型:客户取消订单;取消原因:收货信息填写错误，重新下单;操作人:接口测试\",\"id\":996006221202090263,\"lastUpdateTime\":1669943552000,\"mouldShowType\":1,\"org_Id\":996,\"tag\":\"\"},{\"business_Id\":996422120209139747,\"createTime\":1669943545000,\"description\":\"用户下单成功\",\"id\":996006221202090262,\"lastUpdateTime\":1669943545000,\"mouldShowType\":2,\"org_Id\":996,\"tag\":\"{\\\"title\\\":\\\"已下单\\\"}\"},{\"business_Id\":996422120209139747,\"createTime\":1669943552000,\"description\":\"订单取消,取消类型:客户取消订单;取消原因:收货信息填写错误，重新下单\",\"id\":996006221202090264,\"lastUpdateTime\":1669943552000,\"mouldShowType\":2,\"org_Id\":996,\"tag\":\"{\\\"title\\\":\\\"已取消\\\"}\"}],\"orderType\":0,\"order_Id\":996000221202092001,\"org_Id\":996,\"originAmount\":32.00,\"originalPayAmount\":20.00,\"partnerPayState\":0,\"payType\":0,\"payableAmount\":20.00,\"payee\":0,\"pickType\":0,\"pickupType\":0,\"preLargeTransfer\":false,\"preSaleType\":0,\"printCount\":0,\"productReduceAmount\":0.00,\"province\":\"西藏自治区\",\"reduceAmount\":0.00,\"remark\":\"\",\"scheduleNO\":\"\",\"secOrderType\":11001,\"state\":3,\"street\":\"朗镇\",\"supplyCostPrice\":0.000000,\"totalDiscount\":12.00,\"useBonusAmount\":0.00,\"useCouponAmount\":0.00,\"userClassName\":\"\",\"userConfirmState\":0,\"userMobileNo\":\"18827040216\",\"userName\":\"接口测试\",\"userRemark\":\"\",\"user_Id\":301395,\"warehouse_Id\":9961,\"waveNO\":\"\"}";
        String token = getToken("relase");
//        OrderBO orderBO = JSON.parseObject(body, OrderBO.class);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void expressDispatchNotifyList() {
        String code = "pre";
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/expressDispatchNotifyList";
        String token = getToken(code);

        String body = "[\n" +
                "    {\n" +
                "        \"orderId\": 5183751807324775488,\n" +
                "        \"optUserId\": \"1\",\n" +
                "        \"optUserName\": \"系统\",\n" +
                "        \"dispatchType\":0,\n" +
                "        \"orderExpressDispatchDTOList\": [\n" +
                "            {\n" +
                "                \"logisticsId\": \"JTSD\",\n" +
                "                \"logisticName\": \"极兔速递\",\n" +
                "                \"trackNumber\": \"JT-888888888888\",\n" +
                "                \"customerNo\": \"\",\n" +
                "                \"deliveryState\": 20,\n" +
                "                \"orderDeliveryItemDTOList\": [\n" +
                "                    {\n" +
                "                        \"orderItemId\": 5183751807597265739,\n" +
                "                        \"count\": 20,\n" +
                "                        \"orderId\": 5183751807324775488\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orderId\": 5183751807324775488,\n" +
                "                \"optUserId\": \"1\",\n" +
                "                \"optUserName\": \"系统\",\n" +
                "                \"deliveryTime\": 1682663130000\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void warehouseConfigAdd() {
        String baseUrl = getUrl("pre");
        String url = baseUrl + "ordercenter-config-managerms/warehouseconfig.WarehouseConfigService/save";
        String body = "[{\n" +
                "        \"warehouseId\": 9916,\n" +
                "        \"wmsSystem\": 1,\n" +
                "        \"remark\": null\n" +
                "    }]";
        String token = "67a59e54-87bc-4b0b-9819-c32b3bd4cc44";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void wmsTest() {
        String url = "http://wms.release.yijiupidev.com/supplyChain/transfernote/getTransferNoteList";
        String body = "{\n" +
                "    \"pageNum\": 1,\n" +
                "    \"pageSize\": 20,\n" +
                "    \"warehouseId\": null,\n" +
                "    \"relateNoteNo\": \"\",\n" +
                "    \"transferNo\":\"XC202101070051\"\n" +
                "}";
        String token = "5f8b91b2-44e7-4383-afee-2f482bbea606";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);

    }


    public static List<OrderDocumentDTO> findPageByOrderSnapshot(String code, String params) {
        String url = getUrl(code) + "ordercenter-aggregatequery-servicems/OrderCommonQueryService/findPageByOrderSnapshot";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<OrderDocumentDTO> eventRegisterDTOS = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), OrderDocumentDTO.class);
        return eventRegisterDTOS;
    }

    public static void updatePartner() {
        String params = "[\n" +
                "    {\n" +
                "        \"appId\": \"5145770321308562899\",\n" +
                "        \"appKey\": \"8217c86e-944f-4706-b1ff-12191d2d1976\",\n" +
                "        \"companyCode\": \"YJP\",\n" +
                "        \"createTime\": \"1673607620000\",\n" +
                "        \"id\": \"5145770321307728526\",\n" +
                "        \"lastUpdateTime\": \"1673607748000\",\n" +
                "        \"partnerCode\": \"ERP5运营系统\",\n" +
                "        \"partnerName\": \"erp5\",\n" +
                "        \"status\": 3\n" +
                "    }\n" +
                "]";
        String url = "https://ocop.yijiupi.com/ordercenter-partner-managerms/PartnerManageService/update";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static List<EventConsumptionAuditDocumentDTO> findErrorEventConsum(String code, String params) {
        String url = getUrl(code) + "ordercenter-event-managerms/EventConsumptionAuditQueryService/findPage";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data), PageableResult.class);
        List<EventConsumptionAuditDocumentDTO> list = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventConsumptionAuditDocumentDTO.class);
        return list;
    }


    public static List<EventPublishAuditDocumentDTO> eventConsumptionAuditQuery(String code, String params) {
        String url = getUrl(code) + "ordercenter-event-managerms/EventPublishAuditQueryService/findPage";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(getToken(code), url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data), PageableResult.class);
        List<EventPublishAuditDocumentDTO> list = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventPublishAuditDocumentDTO.class);
        return list;
    }


    public static void retryExternal(String code, String param) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-event-managerms/action/ConsumptionEventRetryService/retryExternal";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, param);
        System.out.println(resultstr);
    }


    public static void repairOrderComplete(String code, String param) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-event-managerms/action/PublishEventRetryService/retry";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, param);
        System.out.println(resultstr);
    }

    public static void repairErpSaleCompleteEventError(String code) {
        //  1.5号0点-1.17号0点
        String errorParam = "[{\"partnerCode\":\"YJP-ERP\",\"sourceBusinessFlowCode\":\"payConfirm\",\"success\":1,\"createTimeStart\":1673884800000,\"createTimeEnd\":1673971200000,\"pageIndex\":1,\"pageSize\":100}]";
        List<EventConsumptionAuditDocumentDTO> errorEventConsumList = findErrorEventConsum(code, errorParam);
        if (CollectionUtils.isEmpty(errorEventConsumList)) {
            return;
        }
        List<EventConsumptionAuditDocumentDTO> needFixList = errorEventConsumList.stream().filter(it -> StringUtils.isNotEmpty(it.getRemark())
                && it.getRemark().contains("ArgumentNullException: Value cannot be null. (Parameter 'request.body.inventoryAllocates.allocateCount')")).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(needFixList)) {
            return;
        }
        System.out.println("需要修复数量=" + needFixList.size());
        Integer dealerOrderCount = 0;
        Set<Long> warehouseIds = new HashSet<>();
        for (EventConsumptionAuditDocumentDTO eventConsumption : needFixList) {
            String eventId = eventConsumption.getEventId();
            String query = "[{\"eventId\":\"" + eventId + "\"}]";
            List<EventPublishAuditDocumentDTO> publishAuditDocumentList = eventConsumptionAuditQuery(code, query);
            EventPublishAuditDocumentDTO documentDTO = publishAuditDocumentList.get(0);
            String body = documentDTO.getBody();
            if (!body.contains("\"allocateCount\":null")) {
                continue;
            }
            PushSaleOrderDTO pushSaleOrderDTO = JSON.parseObject(body, PushSaleOrderDTO.class);
            SaleOrderDTO saleOrder = pushSaleOrderDTO.getSaleOrder();
            OrderBaseDTO orderBaseDTO = saleOrder.getOrderBaseDTO();
            OrderPickDTO orderPickDTO = saleOrder.getOrderPickDTO();
            if (orderBaseDTO.getDealerId() == null) {
                System.out.printf("非经销商订单，订单id=%s,经销商id=%s,仓库id=%s%n", orderBaseDTO.getOrderId(), orderBaseDTO.getDealerId(), orderPickDTO.getWarehouseId());
            } else {
                dealerOrderCount++;
            }
            System.out.printf("订单id=%s,经销商id=%s,仓库id=%s%n", orderBaseDTO.getOrderId(), orderBaseDTO.getDealerId(), orderPickDTO.getWarehouseId());
            warehouseIds.add(orderPickDTO.getWarehouseId());
//            String trueBody = body.replace("\"allocateCount\":null", "\"allocateCount\":0");
//
//            System.out.println(buildRepairSaleCompleteParam(trueBody, documentDTO.getEventId()));
//
//            repairOrderComplete(code,buildRepairSaleCompleteParam(trueBody,documentDTO.getEventId()));
        }
        System.out.println("经销商订单数量=" + needFixList.size());
        System.out.println("仓库=" + warehouseIds);

    }


    private static String buildRepairSaleCompleteParam(String body, String eventId) {
        List<String> strings = Arrays.asList(body, eventId);
        return JSON.toJSONString(strings);
    }


    public static void pullScmTransferOrderToOrderCenter(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/TransferOrderSyncService/pullScmTransferOrderToOrderCenter";
        String params = "[\n" +
                "    {\n" +
                "        \"orderIds\": [\n" +
                orderId +
                "        ],\n" +
                "\"needClearOld\": false" +
                "    }\n" +
                "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void update(String code) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-manager-basems/OrderBaseManageSPI/update";
        String params = "{\n" +
                "    \"orderId\": 5127257676756769223,\n" +
                "    \"state\": 203\n" +
                "}";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


//    public static void pullScmTransferOrderToOrderCenter(String code,Long orderId) {
//        String baseUrl = getUrl(code);
//        String token = getToken(code);
//        String url = baseUrl + "ordercenter-datasync-servicems/TransferOrderSyncService/pullScmTransferOrderToOrderCenter";
//        String params = "[\n" +
//                "    {\n" +
//                "        \"orderIds\": [\n" +
//                orderId+
//                "        ]\n" +
//                "    }\n" +
//                "]";
//        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
//        System.out.println(resultstr);
//    }


    public static void cancelTransferOrder(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/cancelTransferOrder";
        String params = "[" + orderId + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void nptOutSyncErp(String code) {
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/nptOutSyncErp";
        TrainsOutStockDTO trainsOutStock = getPreData();
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, JSON.toJSONString(trainsOutStock));
        System.out.println(resultstr);
    }


    public static void retrySyncOrderItemOwnerByOrderIds(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/retrySyncOrderItemOwnerByOrderIds";
        String params = "[[" + orderId + "]]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void updateItemSercOwner(String code, UpdateSecOwnerDTO updateSecOwnerDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/pdateItemSercOwner";
        String params = "[" + JSON.toJSONString(updateSecOwnerDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void updateOrderItem(String code, SaleOrderItemDTO saleOrderItemDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/updateOrderItem";
        String params = "[[" + JSON.toJSONString(saleOrderItemDTO) + "]]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void retryChangeCountMarkByOrderId(String code, ChangeCountMarkDTO changeCountMarkDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/retryChangeCountMarkByOrderId";
        String params = "[" + JSON.toJSONString(changeCountMarkDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void completeSaleOrder(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/completeSaleOrder";
        String params = "[" + orderId + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void reTrdSaleOrderComplete(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/reTrdSaleOrderComplete";
        String params = "[[" + orderId + "]]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void pushFms(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/pushFms";
        String params = "[" + orderId + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void auditComplete(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/auditComplete";
        String params = "[" + orderId + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void processConfirmReceiptAmount(String code, PushTmsPayConfirmDTO pushTmsPayConfirm) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/processConfirmReceiptAmount";
        String params = "[" + JSON.toJSONString(pushTmsPayConfirm) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void orderSyncEs(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/EsOrderSyncSerivce/orderSyncEs";
        EsOrderSyncDTO esOrderSyncDTO = new EsOrderSyncDTO();
        esOrderSyncDTO.setOrderIds(Arrays.asList(orderId));
        String params = "[" + JSON.toJSONString(esOrderSyncDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void saveWarehouseConfig(String code) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/WarehouseConfigSave";
        String body = "[\n" +
                "    {\n" +
                "        \"companyCode\": \"Omai\",\n" +
                "        \"partnerCode\": \"Omai_TRD\",\n" +
                "        \"warehouseId\": 9000027,\n" +
                "        \"wmsSystem\": 2\n" +
                "    }\n" +
                "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static boolean startOrderCenter(Long orderId) {
        String url = "https://ocop.yijiupi.com/ordercenter-aggregatequery-servicems/OrderLifeCycleQueryService/getOrderLifeCycleById";
        String params = "[" +
                "\"YJP-TRD\"," +
                orderId +
                "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        String jsonString = JSON.toJSONString(data);
        if (jsonString.equals("[]")) {
            return false;
        }
        System.out.println("订单中台已经处理," + orderId);
        return true;
    }


    private static TrainsOutStockDTO getReleaseData() {
        String json = "{\"cityId\":711,\"deliveryCarNumber\":\"CK711123041800021\",\"deliveryTaskChangeFetchOrderList\":[{\"deliveryTaskChangeFetchOrderItemList\":[{\"orderId\":5180194328175142048,\"orderItemId\":5180194328841092616,\"scheduleUnitTotalCount\":6.0}],\"fetchOrderId\":7110392304181800004}],\"deliveryTaskId\":\"5180194600131257671\",\"optUserId\":\"67799384\",\"outStockTime\":1681815120756,\"trainsOutStockOrderList\":[{\"orderId\":5180194328175142048,\"orderType\":3,\"outStockOrderId\":5180194331187885091,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5180194328841092616,\"outStockOrderItemId\":5180194331225729860,\"trainsOutStockDealerList\":[{\"productSpecificationId\":559951,\"secOwnerId\":1,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0}]}],\"warehouseId\":7111}";
        TrainsOutStockDTO trainsOutStockDTO = JSON.parseObject(json, TrainsOutStockDTO.class);
        return trainsOutStockDTO;
    }

    private static TrainsOutStockDTO getPreData() {
        String json = "{\"advancePickup\":false,\"cityId\":476,\"deliveryCarNumber\":\"CK476123052600003\",\"deliveryTaskChangeFetchOrderList\":[{\"deliveryTaskChangeFetchOrderItemList\":[{\"orderId\":5188015734628753034,\"orderItemId\":5188015734810768295,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5191671494981072620,\"orderItemId\":5191671495133953291,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5192824609914951463,\"orderItemId\":5192824610068806440,\"scheduleUnitTotalCount\":24.0},{\"orderId\":5192824609914951463,\"orderItemId\":5192824610093972263,\"scheduleUnitTotalCount\":18.0},{\"orderId\":5193438610378146856,\"orderItemId\":5193438610562810401,\"scheduleUnitTotalCount\":6.0}],\"fetchOrderId\":4760392305261108580}],\"deliveryTaskId\":\"5193857108537881358\",\"optUserId\":\"7120\",\"outStockTime\":1685155101748,\"trainsOutStockOrderList\":[{\"orderId\":5188015734628753034,\"orderType\":3,\"outStockOrderId\":5188015735621653473,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5188015734810768295,\"outStockOrderItemId\":5188015735628074529,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10748,\"secOwnerId\":1395869718285759601,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0}]},{\"orderId\":5191671494981072620,\"orderType\":3,\"outStockOrderId\":5191671495894515684,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5191671495133953291,\"outStockOrderItemId\":5191671495908169258,\"trainsOutStockDealerList\":[{\"productSpecificationId\":206150,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5192824609914951463,\"orderType\":3,\"outStockOrderId\":5192824610655318509,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5192824610068806440,\"outStockOrderItemId\":5192824610665364450,\"trainsOutStockDealerList\":[{\"productSpecificationId\":314,\"secOwnerId\":1,\"unitTotalCount\":24.0}],\"unitTotalCount\":24.0},{\"orderItemId\":5192824610093972263,\"outStockOrderItemId\":5192824610682141667,\"trainsOutStockDealerList\":[{\"productSpecificationId\":16946,\"secOwnerId\":1,\"unitTotalCount\":18.0}],\"unitTotalCount\":18.0}]},{\"orderId\":5193438610378146856,\"orderType\":3,\"outStockOrderId\":5193438611461225581,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5193438610562810401,\"outStockOrderItemId\":5193438611469493735,\"trainsOutStockDealerList\":[{\"productSpecificationId\":301852,\"secOwnerId\":1395869718239575996,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0}]}],\"warehouseId\":4761}";
        TrainsOutStockDTO trainsOutStockDTO = JSON.parseObject(json, TrainsOutStockDTO.class);
//        fixNptOutData(trainsOutStockDTO);

        List<Long> orderItemIds = new ArrayList<>();
        trainsOutStockDTO.getTrainsOutStockOrderList().forEach(it->it.getTrainsOutStockOrderItemList().forEach(item->{
            List<TrainsOutStockDealerDTO> trainsOutStockDealerList = item.getTrainsOutStockDealerList();
            for (TrainsOutStockDealerDTO trainsOutStockDealerDTO : trainsOutStockDealerList) {
                if(trainsOutStockDealerDTO.getSecOwnerId()==null){
                    orderItemIds.add(item.getOrderItemId());
                }
            }
        }));

        if(CollectionUtils.isNotEmpty(orderItemIds)){
            throw new BusinessException("二级货主id不能为null,"+orderItemIds);
        }
        return trainsOutStockDTO;
    }


    @SneakyThrows
    private static void fixNptOutData(TrainsOutStockDTO trainsOutStockDTO) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\内配退二级货主异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "内配退二级货主异常.xlsx");
        Map<Long, ElkDTO> map = list.stream().filter(it -> it.getItemId() != null).collect(Collectors.toMap(it -> it.getItemId(), it -> it));
        trainsOutStockDTO.getTrainsOutStockOrderList().forEach(it -> it.getTrainsOutStockOrderItemList().forEach(item -> {
            List<TrainsOutStockDealerDTO> trainsOutStockDealerList = item.getTrainsOutStockDealerList();
            for (TrainsOutStockDealerDTO trainsOutStockDealerDTO : trainsOutStockDealerList) {
                Long secOwnerId = trainsOutStockDealerDTO.getSecOwnerId();
                if (secOwnerId == null) {
                    ElkDTO elkDTO = map.get(item.getOrderItemId());
                    if (elkDTO == null || elkDTO.getCount().compareTo(trainsOutStockDealerDTO.getUnitTotalCount()) != 0) {
                        System.out.println("二级货主异常," + item.getOrderItemId());
                    }
                    trainsOutStockDealerDTO.setSecOwnerId(elkDTO.getSecOwnerId());
                } else {
                    ElkDTO elkDTO = map.get(item.getOrderItemId());
                    if (elkDTO == null || elkDTO.getCount().compareTo(trainsOutStockDealerDTO.getUnitTotalCount()) != 0) {
                        System.out.println("二级货主异常," + item.getOrderItemId());
                    }else {
                        if(!elkDTO.getSecOwnerId().equals(secOwnerId)){
                            System.out.println("二级货主变更,"+item.getOrderItemId());
                            trainsOutStockDealerDTO.setSecOwnerId(elkDTO.getSecOwnerId());
                        }
                    }
                }
            }
        }));
    }


}
