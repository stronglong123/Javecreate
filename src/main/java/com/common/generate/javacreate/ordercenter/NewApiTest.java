package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.PageableResult;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.ordercenter.dto.PushSaleOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.RepairBusinessItemIdDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityManageDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityQueryDTO;
import com.common.generate.javacreate.ordercenter.dto.data.OrderBO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventConsumptionAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.utils.SignUtil;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

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

    private static final String testToken ="0c34bcbe-53de-4abe-aa45-f0763abdbadb";

    private static final String releaseToken ="32eb5d73-4733-4ffd-b1d9-546c9447fdfd";

    private static final String token ="5109ce27-886d-4133-85ec-46276a1714ba";



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
//        deleteByOrderId(5157699752078807362L);

//        update("release");
//        retrySyncOrderByOrderIds("release",5031224347955159367L);

//        repairErpSaleCompleteEventError("pre");


        List<Long> orderIds = getOrderIds();
        for (Long orderId : orderIds) {
//            repairSaleComplete(orderId);
//            repairReturnComplete(orderId);
//            evnetTrySaleComplete(orderId);
//            pullScmTransferOrderToOrderCenter("pre",orderId);
            deleteByOrderId(orderId);
            Thread.sleep(500);
        }
//        for (Long orderId : orderIds) {
////            retrySyncOrderByOrderIds("pre", orderId);
//            initOrderCenterByOmsorderIds(orderId);
//            Thread.sleep(500);
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

    public static void initOrderCenterByOmsorderIds(Long orderId) {
        String params = "{\n" +
                "  \"omsorderIds\": [\n" +
                orderId +
                "  ]\n" +
                "  ,\n" +
                "  \"skipGrapCheck\":true\n" +
                "}";
        String url = "http://openapi.pre.yijiupi.com/openapi/oms/initOrderCenterByOmsorderIds";
        String resultstr = HttpClientUtils.doPost(url, params);
    }


    private static List<Long> getOrderIds() {
        return Arrays.asList(7550002102160868187L,7550002103191575412L,7550002102160768186L);
    }

    public static void evnetTrySaleComplete(Long orderId) {
        String baseUrl = getUrl("pre");
        String url = baseUrl + "ordercenter-event-managerms/action/PublishEventRetryService/retry";
        List<String> params = Arrays.asList("{\"orderId\":" + orderId + ",\"completeTime\":\"2022-12-30T14:00:00.350+08:00\",\"reason\":\"系统自动完成\"}", "DispatchAutoComplete:5136651219371885133_1671435634759_1671435783274");
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
    public static void retrySyncOrderByOrderIds(String code,Long orderId) {
        String baseUrl = getUrl(code);

        String token = getToken(code);
        String url = baseUrl +"ordercenter-elasticsearchsync-basems/EsRetrySyncService/retrySyncOrderByOrderIds";
        String body = "[[" + orderId + "]]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    /**
     * 消费者查询
     *
     * @return
     */
    public static void deleteByOrderId(Long orderId) {
        String code = "release";
        String baseUrl = getUrl(code);
        String url = baseUrl +"ordercenter-datasync-servicems/OrderRepairService/repairOrderByOrderId";
        String body = "[[" + orderId + "]]";
        String token =getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void saleOrderPushWms() {
        String url = "http://ocop.release.yijiupidev.com/ordercenter-datasync-servicems/WmsRepairService/saleOrderPushWms";
        String body = "[[5127602366330377228]]";
        String token = "9370754d-70fe-4e4e-af28-8b31c2bde742";
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
        String code ="pre";
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairSaleComplete";
        String body = "[[" + orderId + "]]";
//        String token = "b2fcc534-7106-42ef-ba1e-f798900759c5";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void repairReturnComplete(Long orderId) {
        String code ="pre";
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
        String body ="[["+ JSON.toJSONString(repairBusinessItemIdDTO)+"]]";
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
        String token = "2b508e7b-9733-4e9d-8093-7b3b2937ddac";
//        OrderBO orderBO = JSON.parseObject(body, OrderBO.class);
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
        String params ="[\n" +
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

    public static List<EventConsumptionAuditDocumentDTO> findErrorEventConsum(String code,String params){
        String url = getUrl(code) + "ordercenter-event-managerms/EventConsumptionAuditQueryService/findPage";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data), PageableResult.class);
        List<EventConsumptionAuditDocumentDTO> list = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventConsumptionAuditDocumentDTO.class);
        return list;
    }


    public static List<EventPublishAuditDocumentDTO> eventConsumptionAuditQuery(String code, String params){
        String url = getUrl(code) + "ordercenter-event-managerms/EventPublishAuditQueryService/findPage";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(getToken(code), url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data), PageableResult.class);
        List<EventPublishAuditDocumentDTO> list = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventPublishAuditDocumentDTO.class);
        return list;
    }


    public static void repairOrderComplete(String code, String param) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-event-managerms/action/PublishEventRetryService/retry";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, param);
        System.out.println(resultstr);
    }

    public static void repairErpSaleCompleteEventError(String code){
        //  1.5号0点-1.17号0点
        String errorParam = "[{\"partnerCode\":\"YJP-ERP\",\"sourceBusinessFlowCode\":\"payConfirm\",\"success\":1,\"createTimeStart\":1673884800000,\"createTimeEnd\":1673971200000,\"pageIndex\":1,\"pageSize\":100}]";
        List<EventConsumptionAuditDocumentDTO> errorEventConsumList = findErrorEventConsum(code, errorParam);
        if(CollectionUtils.isEmpty(errorEventConsumList)){
            return;
        }
        List<EventConsumptionAuditDocumentDTO> needFixList = errorEventConsumList.stream().filter(it -> StringUtils.isNotEmpty(it.getRemark())
                && it.getRemark().contains("ArgumentNullException: Value cannot be null. (Parameter 'request.body.inventoryAllocates.allocateCount')")).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(needFixList)){
            return;
        }
        System.out.println("需要修复数量="+needFixList.size());
        Integer dealerOrderCount = 0;
        Set<Long> warehouseIds = new HashSet<>();
        for (EventConsumptionAuditDocumentDTO eventConsumption : needFixList) {
            String eventId = eventConsumption.getEventId();
            String query = "[{\"eventId\":\"" + eventId + "\"}]";
            List<EventPublishAuditDocumentDTO> publishAuditDocumentList = eventConsumptionAuditQuery(code, query);
            EventPublishAuditDocumentDTO documentDTO = publishAuditDocumentList.get(0);
            String body = documentDTO.getBody();
            if(!body.contains("\"allocateCount\":null")){
                continue;
            }
            PushSaleOrderDTO pushSaleOrderDTO = JSON.parseObject(body,PushSaleOrderDTO.class);
            SaleOrderDTO saleOrder = pushSaleOrderDTO.getSaleOrder();
            OrderBaseDTO orderBaseDTO = saleOrder.getOrderBaseDTO();
            OrderPickDTO orderPickDTO = saleOrder.getOrderPickDTO();
            if(orderBaseDTO.getDealerId()==null){
                System.out.printf("非经销商订单，订单id=%s,经销商id=%s,仓库id=%s%n",orderBaseDTO.getOrderId(),orderBaseDTO.getDealerId(),orderPickDTO.getWarehouseId());
            }else {
                dealerOrderCount++;
            }
            System.out.printf("订单id=%s,经销商id=%s,仓库id=%s%n",orderBaseDTO.getOrderId(),orderBaseDTO.getDealerId(),orderPickDTO.getWarehouseId());
            warehouseIds.add(orderPickDTO.getWarehouseId());
//            String trueBody = body.replace("\"allocateCount\":null", "\"allocateCount\":0");
//
//            System.out.println(buildRepairSaleCompleteParam(trueBody, documentDTO.getEventId()));
//
//            repairOrderComplete(code,buildRepairSaleCompleteParam(trueBody,documentDTO.getEventId()));
        }
        System.out.println("经销商订单数量="+needFixList.size());
        System.out.println("仓库="+warehouseIds);

    }


    private static String buildRepairSaleCompleteParam(String body,String eventId){
        List<String> strings = Arrays.asList(body, eventId);
        return JSON.toJSONString(strings);
    }




    public static void pullScmTransferOrderToOrderCenter(String code,Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/TransferOrderSyncService/pullScmTransferOrderToOrderCenter";
        String params = "[\n" +
                "    {\n" +
                "        \"orderIds\": [\n" +
                            orderId+
                "        ]\n" +
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




}
