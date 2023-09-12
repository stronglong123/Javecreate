package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.constants.OrdercenterConstant;
import com.common.generate.javacreate.model.base.PageableResult;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.ordercenter.dto.ChangeCountMarkDTO;
import com.common.generate.javacreate.ordercenter.dto.ERPTransferOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.EsOrderSyncDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemAwardDTO;
import com.common.generate.javacreate.ordercenter.dto.PageTurnResult;
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
import com.common.generate.javacreate.service.impl.es.base.OrderAmountDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderConsignorDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderContactDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderReturnDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderSaleDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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
//    private static final String preUrl = "https://ocop.yijiupi.com/";


    private static final String saasUrl = "https://ocop.yjpcloud.com/";


    private static final String testToken = "41189675-7513-4bd4-af46-db644ff69ac0";

    private static final String releaseToken = "7ae9138e-5f74-4167-bd0b-29dea93391c2";

    private static final String token = "0cf45783-f8cd-4a9f-94ed-fe59c11d7b72";

    private static final String saasToken = "47bc24c8-cef0-426d-a7d6-dbe9138b4d14";

    private static String getUrl(String code) {
        switch (code) {
            case "test":
                return OrdercenterConstant.TestUrl;
            case "release":
                return OrdercenterConstant.ReleaseUrl;
            case "pre":
                return OrdercenterConstant.PreUrl;
            case "saas":
                return OrdercenterConstant.SaasUrl;
        }
        return OrdercenterConstant.TestUrl;
    }

    private static String getToken(String code) {
        switch (code) {
            case "test":
                return OrdercenterConstant.TestToken;
            case "release":
                return OrdercenterConstant.ReleaseToken;
            case "pre":
                return OrdercenterConstant.Token;
            case "saas":
                return OrdercenterConstant.SaasToken;
        }
        return OrdercenterConstant.Token;
    }

    @SneakyThrows
    public static void main(String[] args) {
//        String json = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\测试数据.txt");
//        List<OrderBO> orderBOS = JSON.parseArray(json, OrderBO.class);
//        addOmsSaleOrder("pre",json);
//        findPageByOrderSnapshot("pre", "[\n" +
//                "    {\n" +
//                "\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"pageIndex\": 1,\n" +
//                "        \"pageSize\": 101\n" +
//                "    }\n" +
//                "]");
//        getEffectiveById("release");
//        synOldOmsWarehouseDelivery("release");
//        synTmsDeliveryStation("release");
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
//            actionSelfOrder("pre", orderId);
//            evnetTryReturnAudit(orderId);
//            pushTms("saas",orderId);
//            pushWms("saas",orderId);
//            repairSaleDisPatch(orderId);
//            orderSyncEs("pre",orderId);
//            retrySyncOrderItemOwnerByOrderIds("pre",orderId);

//            startOrderCenter(orderId);
//            cancelTransferOrder("pre", orderId);
//            cancelSaleOrder("pre", orderId);
//            repairSaleComplete("pre", orderId);
//            repairReturnComplete("release",111111L);
//            completeSaleOrder("pre",orderId);
//            completeReturnOrder("pre",orderId);
//            preToSaleByOrderId("pre", orderId);
            pullScmTransferOrderToOrderCenter("pre",orderId);
//            deleteByOrderId("pre", orderId);
//            saleOrderPushWms("saas", orderId);
//            retrySyncOrderByOrderIds("saas", orderId);
//            pushFms("release", orderId);
//            auditComplete("pre", orderId);
//            reTrdSaleOrderComplete("pre",orderId);
//              Thread.sleep(300);
//              retrySyncOrderByOrderIds("pre", orderId);
//            initOrderCenterByOmsorderIds("pre",orderId);
        }
//
//        for (Long orderId : orderIds) {
//////            retrySyncOrderByOrderIds("pre", orderId);
//            initOrderCenterByOmsorderIds("pre",orderId);
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
        return Arrays.asList(5069537535068182921L,5069887154282978700L,5034870089092586893L);
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
        String code = "pre";
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-event-managerms/action/PublishEventRetryService/retry";
        String token = getToken(code);
        List<String> params = Arrays.asList("{\"orderId\":" + orderId + ",\"completeTime\":\"2023-04-10T14:00:00.350+08:00\",\"reason\":\"系统自动完成\"}", "DispatchAutoComplete:5136651219371885133_1671435634759_1671435783274");
        String body = JSON.toJSONString(params);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void evnetTryReturnAudit(Long orderId) {
        String code = "pre";
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-event-managerms/action/PublishEventRetryService/retry";
        String token = getToken(code);

        List<String> params = Arrays.asList("{\"orderId\":" + orderId + ",\"auditState\":1,\"auditUserId\":\"-1\",\"auditUserName\":\"系统\",\"deliveryMode\":null,\"auditTime\":\"2023-06-30T10:19:40.526+08:00\",\"reason\":\"系统自动审核\",\"remark\":\"系统自动审核\",\"returnAmount\":null,\"returnOrderAuditItemList\":null,\"returnOrderContact\":{\"province\":null,\"city\":null,\"county\":null,\"street\":null,\"detailAddress\":null,\"consigneeName\":null,\"consigneeMobileNo\":null},\"isNeedPickup\":null,\"attributes\":null}", "ReturnAutoAudit:5206586210319478689");
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


    public static void saleOrderPushWms(String code, Long orderId) {
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


    public static void repairSaleComplete(String code, Long orderId) {
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


    public static void repairReturnComplete(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairReturnComplete";
        String body = "[[" + orderId + "]]";
//        String token = "b2fcc534-7106-42ef-ba1e-f798900759c5";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void repairReturnOrderBusinessItemId(RepairBusinessItemIdDTO repairBusinessItemIdDTO) {
        String code = "pre";
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/repairReturnOrderBusinessItemId";
        String token = getToken(code);
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

    public static void warehouseConfigAdd(String code) {
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-config-managerms/warehouseconfig.WarehouseConfigService/save";
        String body = "[{\n" +
                "        \"warehouseId\": 9916,\n" +
                "        \"wmsSystem\": 1,\n" +
                "        \"remark\": null\n" +
                "    }]";
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void getEffectiveById(String code) {
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-config-managerms/warehousedeliveryservice.WarehouseDeliveryQueryService/getEffectiveById";
        String body = "[]";
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void warehouseDeliveryUpdate(String code) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-config-managerms/warehousedeliveryservice.WarehouseDeliveryManagerService/update";
        String body = "{\n" +
                "    \"afterSalesCategoryRangeExcludes\": [],\n" +
                "    \"afterSalesCategoryRangeIncludes\": [],\n" +
                "    \"afterSalesRangeExtendDelivery\": false,\n" +
                "    \"aggregatePickup\": false,\n" +
                "    \"deliveryCategoryRangeExcludes\": [],\n" +
                "    \"deliveryCategoryRangeIncludes\": [],\n" +
                "    \"deliveryCost\": 2,\n" +
                "    \"deliveryRegionRangeExcludes\": [],\n" +
                "    \"deliveryRegionRangeIncludes\": [\n" +
                "        {\n" +
                "            \"province\": \"安徽省\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"deliveryServiceId\": \"300\",\n" +
                "    \"deliveryTime\": 1,\n" +
                "    \"id\": \"111\",\n" +
                "    \"priority\": 1,\n" +
                "    \"serviceAddressTypes\": [\n" +
                "        0\n" +
                "    ],\n" +
                "    \"warehouseId\": \"9981\"\n" +
                "}";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }


    public static void synOldOmsWarehouseDelivery(String code) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-config-managerms/warehousedeliveryservice.WarehouseDeliveryManagerService/synOldOmsWarehouseDelivery";
        String body = "{\n" +
                "    \"category\": 1,\n" +
                "    \"companyCode\": \"YJP\",\n" +
                "    \"warehouseId\": 1641\n" +
                "}";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

    public static void synTmsDeliveryStation(String code) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-config-managerms/warehousedeliveryservice.WarehouseDeliveryManagerService/synTmsDeliveryStation";
        String body = "{\n" +
                "    \"deliveryStationDTOList\": [\n" +
                "        {\n" +
                "            \"deliveryCategoryRangeIncludes\": [\n" +
                "                1\n" +
                "            ],\n" +
                "            \"deliveryRegionRangeIncludes\": [\n" +

                "            ],\n" +
                "            \"id\": 1\n" +
                "        }\n" +
                "    ],\n" +
                "    \"warehouseId\": 1641\n" +
                "}";
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
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
//        System.out.println(resultstr);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<OrderDocumentDTO> eventRegisterDTOS = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), OrderDocumentDTO.class);
        return eventRegisterDTOS;
    }

    public static PageTurnResult<OrderDocumentDTO> findOrderSnapshotByPageTurn(String code, String params) {
        String url = getUrl(code) + "ordercenter-aggregatequery-servicems/OrderCommonQueryService/findOrderSnapshotByPageTurn";
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
//        System.out.println(resultstr);
        Result result = JSON.parseObject(resultstr, Result.class);

        Object data1 = result.getData();
        PageTurnResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageTurnResult.class);

        List<OrderDocumentDTO> orderDocumentDTOS = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), OrderDocumentDTO.class);
        PageTurnResult<OrderDocumentDTO> orderByPageTurn = pageableResult;
        orderByPageTurn.setDatas(orderDocumentDTOS);
        return orderByPageTurn;
    }

    public static List<OrderDTO> getOrderWithItemOwners(String code, String params) {
        String url = getUrl(code) + "ordercenter-aggregatequery-servicems/OrderQueryService/getOrderWithItemOwners";
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        List<OrderDTO> eventRegisterDTOS = JSON.parseArray(JSON.toJSONString(data1), OrderDTO.class);
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
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(OrdercenterConstant.Token, url, params);
        System.out.println(resultstr);
    }

    public static List<EventConsumptionAuditDocumentDTO> findErrorEventConsum(String code, String params) {
        String url = getUrl(code) + "ordercenter-event-managerms/EventConsumptionAuditQueryService/findPage";
        String token = getToken(code);
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

    public static void cancelSaleOrder(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/cancelByOrderId";
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


    public static void nptOutSyncErp(String code, String params) {
        String baseUrl = getUrl(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/nptOutSyncErp";
        String token = getToken(code);
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
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

    public static void updateWarehouse(String code, OrderPickDTO orderPickDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateWarehouse";
        String params = "[" + JSON.toJSONString(orderPickDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void updateState(String code, OrderBaseDTO orderBaseDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateOrderBase";
        String params = "[" + JSON.toJSONString(orderBaseDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void updateOrderReturn(String code, OrderReturnDTO orderReturnDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateOrderReturn";
        String params = "[" + JSON.toJSONString(orderReturnDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void updateOrderAmount(String code, OrderAmountDTO orderAmountDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateOrderAmount";
        String params = "[" + JSON.toJSONString(orderAmountDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void updateAwardItem(String code, OrderItemAwardDTO orderItemAwardDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateAwardItem";
        String params = "[" + JSON.toJSONString(orderItemAwardDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void updateOrderContract(String code, OrderContactDTO orderContactDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateOrderContract";
        String params = "[" + JSON.toJSONString(orderContactDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void updateOrderConsignor(String code, OrderConsignorDTO orderConsignorDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateOrderConsignor";
        String params = "[" + JSON.toJSONString(orderConsignorDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void updateOrderSale(String code, OrderSaleDTO orderSaleDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/updateOrderSale";
        String params = "[" + JSON.toJSONString(orderSaleDTO) + "]";
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

    public static void orderPayConfirm(String code, RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);

        String url = baseUrl + "ordercenter-datasync-servicems/OrderDeliveryTaskRepairService/orderPayConfirm";
        String params = "[" + JSON.toJSONString(repairSaleOrderConfirmPayDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void completeReturnOrder(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/completeReturnOrder";
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

    public static void preToSaleByOrderId(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/preToSaleByOrderId";
        String params = "[" + orderId + "]";
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

    public static void pushTms(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/pushTms";
        String params = "[" + orderId + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void pushWms(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/pushWms";
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


    public static void batchPayConfirm(String code, BatchPayConfirmDTO repairBatchPayConfirmDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderDeliveryTaskRepairService/batchPayConfirm";
        String params = "[" + JSON.toJSONString(repairBatchPayConfirmDTO) + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void orderOutStockNotify(String code, String params) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/orderOutStockNotify";
//        String params = "[" + param + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }

    public static void actionSelfOrder(String code, Long orderId) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/actionSelfOrder";
        String params = "[" + orderId + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void addOmsSaleOrder(String code,  String params) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/SaleOrderRepairService/addOmsSaleOrder";
        params = "[" + params + "]";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, params);
        System.out.println(resultstr);
    }


    public static void addTransferOrder(String code, ERPTransferOrderDTO erpTransferOrderDTO) {
        String baseUrl = getUrl(code);
        String token = getToken(code);
        String url = baseUrl + "ordercenter-datasync-servicems/OrderRepairService/addTransferOrder";
        String params = "[" + JSON.toJSONString(erpTransferOrderDTO) + "]";
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
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(OrdercenterConstant.Token, url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        String jsonString = JSON.toJSONString(data);
        if (jsonString.equals("[]")) {
            System.out.println("订单中台未处理," + orderId);
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
        String json = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\内配退异常数据.txt");
        ;


//        String json ="{\"advancePickup\":false,\"cityId\":756,\"deliveryCarNumber\":\"CK756123062600013\",\"deliveryTaskChangeFetchOrderList\":[{\"deliveryTaskChangeFetchOrderItemList\":[{\"orderId\":7560002304141051053,\"orderItemId\":7120012304141009459,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305121154042,\"orderItemId\":7120012305121120564,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305121154042,\"orderItemId\":7120012305121120565,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305121154042,\"orderItemId\":7120012305121120566,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305121154042,\"orderItemId\":7120012305121120567,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305121154042,\"orderItemId\":7120012305121120568,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305121154043,\"orderItemId\":7120012305121120569,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305121154044,\"orderItemId\":7120012305121120570,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305130954168,\"orderItemId\":7120012305130924213,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305130954169,\"orderItemId\":7120012305130924214,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305130954170,\"orderItemId\":7120012305130924215,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305130954172,\"orderItemId\":7120012305130924221,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305130954173,\"orderItemId\":7120012305130924222,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305131054175,\"orderItemId\":7120012305131024476,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305131054175,\"orderItemId\":7120012305131024477,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305131054175,\"orderItemId\":7120012305131024478,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305131054175,\"orderItemId\":7120012305131024479,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305131054175,\"orderItemId\":7120012305131024480,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305140954310,\"orderItemId\":7120012305140927956,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305140954309,\"orderItemId\":7120012305140927957,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305150954453,\"orderItemId\":7120012305150931457,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305150954454,\"orderItemId\":7120012305150931458,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305150954455,\"orderItemId\":7120012305150931459,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305161154642,\"orderItemId\":7120012305161136007,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305161154643,\"orderItemId\":7120012305161136008,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305161154643,\"orderItemId\":7120012305161136009,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305161154645,\"orderItemId\":7120012305161136011,\"scheduleUnitTotalCount\":9.0},{\"orderId\":7560002305170954791,\"orderItemId\":7120012305170939486,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305181054913,\"orderItemId\":7120012305181043521,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305181054914,\"orderItemId\":7120012305181043522,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305181054915,\"orderItemId\":7120012305181043523,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955100,\"orderItemId\":7120012305190946999,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955102,\"orderItemId\":7120012305190947036,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955102,\"orderItemId\":7120012305190947037,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305190955101,\"orderItemId\":7120012305190947035,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955103,\"orderItemId\":7120012305190947038,\"scheduleUnitTotalCount\":18.0},{\"orderId\":7560002305190955104,\"orderItemId\":7120012305190947039,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955105,\"orderItemId\":7120012305190947040,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955105,\"orderItemId\":7120012305190947041,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305190955106,\"orderItemId\":7120012305190947042,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305190955106,\"orderItemId\":7120012305190947043,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955107,\"orderItemId\":7120012305190947044,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955108,\"orderItemId\":7120012305190947045,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955110,\"orderItemId\":7120012305190947054,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947046,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947047,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947048,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947049,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947050,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947051,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947052,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955109,\"orderItemId\":7120012305190947053,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955111,\"orderItemId\":7120012305190947055,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955112,\"orderItemId\":7120012305190947056,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305190955113,\"orderItemId\":7120012305190947057,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305190955113,\"orderItemId\":7120012305190947058,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305191155124,\"orderItemId\":7120012305191147535,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305191155123,\"orderItemId\":7120012305191147534,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305191155126,\"orderItemId\":7120012305191147538,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305191155125,\"orderItemId\":7120012305191147536,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305191155125,\"orderItemId\":7120012305191147537,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305191155127,\"orderItemId\":7120012305191147539,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305191155128,\"orderItemId\":7120012305191147540,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002305191155128,\"orderItemId\":7120012305191147541,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305191155129,\"orderItemId\":7120012305191147542,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305200955234,\"orderItemId\":7120012305200951572,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305200955235,\"orderItemId\":7120012305200951573,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305200955237,\"orderItemId\":7120012305200951576,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305200955236,\"orderItemId\":7120012305200951574,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305200955236,\"orderItemId\":7120012305200951575,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305201255266,\"orderItemId\":7120012305201252545,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305201255265,\"orderItemId\":7120012305201252544,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305201255265,\"orderItemId\":7120012305201252546,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305201255267,\"orderItemId\":7120012305201252547,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305201255268,\"orderItemId\":7120012305201252548,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305251055718,\"orderItemId\":7120012305251069333,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305251055720,\"orderItemId\":7120012305251069408,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305260955798,\"orderItemId\":7120012305260972849,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305260955797,\"orderItemId\":7120012305260972850,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305260955799,\"orderItemId\":7120012305260972851,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305260955800,\"orderItemId\":7120012305260972852,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305260955803,\"orderItemId\":7120012305260972856,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305260955802,\"orderItemId\":7120012305260972854,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305260955802,\"orderItemId\":7120012305260972855,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305260955805,\"orderItemId\":7120012305260972858,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305260955804,\"orderItemId\":7120012305260972857,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305260955806,\"orderItemId\":7120012305260972859,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305271055892,\"orderItemId\":7120012305271076824,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305281055957,\"orderItemId\":7120012305281080271,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305281155965,\"orderItemId\":7120012305281180535,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002305281155965,\"orderItemId\":7120012305281180536,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305291056036,\"orderItemId\":7120012305291084473,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305291056038,\"orderItemId\":7120012305291084492,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305291056038,\"orderItemId\":7120012305291084493,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305291056037,\"orderItemId\":7120012305291084491,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002305291156046,\"orderItemId\":7120012305291184759,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305291156047,\"orderItemId\":7120012305291184760,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002305291156048,\"orderItemId\":7120012305291184761,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002305291156049,\"orderItemId\":7120012305291184762,\"scheduleUnitTotalCount\":24.0},{\"orderId\":7560002306041056514,\"orderItemId\":7120012306041010772,\"scheduleUnitTotalCount\":24.0},{\"orderId\":7560002306051056608,\"orderItemId\":7120012306051015045,\"scheduleUnitTotalCount\":19.0},{\"orderId\":7560002306051156619,\"orderItemId\":7120012306051115591,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115592,\"scheduleUnitTotalCount\":6.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115593,\"scheduleUnitTotalCount\":6.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115594,\"scheduleUnitTotalCount\":6.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115595,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115596,\"scheduleUnitTotalCount\":10.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115597,\"scheduleUnitTotalCount\":10.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115598,\"scheduleUnitTotalCount\":10.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115599,\"scheduleUnitTotalCount\":10.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115600,\"scheduleUnitTotalCount\":10.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115601,\"scheduleUnitTotalCount\":15.0},{\"orderId\":7560002306051156620,\"orderItemId\":7120012306051115602,\"scheduleUnitTotalCount\":10.0},{\"orderId\":7560002306051156623,\"orderItemId\":7120012306051115603,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306051156623,\"orderItemId\":7120012306051115604,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115605,\"scheduleUnitTotalCount\":7.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115606,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115607,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115608,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115609,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115610,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115611,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115612,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115613,\"scheduleUnitTotalCount\":20.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115614,\"scheduleUnitTotalCount\":20.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115615,\"scheduleUnitTotalCount\":20.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115616,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115617,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115618,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115619,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002306051156624,\"orderItemId\":7120012306051115620,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306061156733,\"orderItemId\":7120012306061120128,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306061156734,\"orderItemId\":7120012306061120129,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306061156734,\"orderItemId\":7120012306061120130,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306061156736,\"orderItemId\":7120012306061120132,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306061156735,\"orderItemId\":7120012306061120131,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306061156737,\"orderItemId\":7120012306061120133,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306071556852,\"orderItemId\":7120012306071524428,\"scheduleUnitTotalCount\":8.0},{\"orderId\":7560002306090957035,\"orderItemId\":7120012306090930067,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306090957034,\"orderItemId\":7120012306090930065,\"scheduleUnitTotalCount\":10.0},{\"orderId\":7560002306090957034,\"orderItemId\":7120012306090930066,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306090957037,\"orderItemId\":7120012306090930069,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306090957036,\"orderItemId\":7120012306090930068,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306090957039,\"orderItemId\":7120012306090930071,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306090957038,\"orderItemId\":7120012306090930070,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306101057169,\"orderItemId\":7120012306101033845,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306101157174,\"orderItemId\":7120012306101133896,\"scheduleUnitTotalCount\":12.0},{\"orderId\":7560002306110957281,\"orderItemId\":7120012306110937123,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306110957280,\"orderItemId\":7120012306110937122,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306110957282,\"orderItemId\":7120012306110937124,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306110957283,\"orderItemId\":7120012306110937125,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306110957283,\"orderItemId\":7120012306110937126,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306110957284,\"orderItemId\":7120012306110937127,\"scheduleUnitTotalCount\":4.0},{\"orderId\":7560002306110957285,\"orderItemId\":7120012306110937128,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306110957285,\"orderItemId\":7120012306110937129,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002306110957286,\"orderItemId\":7120012306110937130,\"scheduleUnitTotalCount\":3.0},{\"orderId\":7560002306110957286,\"orderItemId\":7120012306110937131,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306110957287,\"orderItemId\":7120012306110937132,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306110957288,\"orderItemId\":7120012306110937133,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306110957289,\"orderItemId\":7120012306110937134,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306110957290,\"orderItemId\":7120012306110937135,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306110957291,\"orderItemId\":7120012306110937136,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306111057300,\"orderItemId\":7120012306111037201,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306111057299,\"orderItemId\":7120012306111037200,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306111057302,\"orderItemId\":7120012306111037202,\"scheduleUnitTotalCount\":5.0},{\"orderId\":7560002306111057301,\"orderItemId\":7120012306111037203,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306111057304,\"orderItemId\":7120012306111037205,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306120957384,\"orderItemId\":7120012306120940435,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306120957383,\"orderItemId\":7120012306120940434,\"scheduleUnitTotalCount\":1.0},{\"orderId\":7560002306120957385,\"orderItemId\":7120012306120940436,\"scheduleUnitTotalCount\":2.0},{\"orderId\":7560002306121057397,\"orderItemId\":7120012306121040750,\"scheduleUnitTotalCount\":10.0},{\"orderId\":5200711388106015786,\"orderItemId\":5200711388294873640,\"scheduleUnitTotalCount\":30.0},{\"orderId\":5200711388106015786,\"orderItemId\":5200711388324233768,\"scheduleUnitTotalCount\":12.0},{\"orderId\":5200711388106015786,\"orderItemId\":5200711388345205283,\"scheduleUnitTotalCount\":12.0},{\"orderId\":5200711388106015786,\"orderItemId\":5200711388370371112,\"scheduleUnitTotalCount\":10.0},{\"orderId\":5200711388106015786,\"orderItemId\":5200711388391342627,\"scheduleUnitTotalCount\":9.0},{\"orderId\":5200734179547104301,\"orderItemId\":5200734179689824814,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5200734179534521381,\"orderItemId\":5200734179681436194,\"scheduleUnitTotalCount\":3.0},{\"orderId\":5201067815689471015,\"orderItemId\":5201067815836385838,\"scheduleUnitTotalCount\":3.0},{\"orderId\":5201068070187254825,\"orderItemId\":5201068070334169638,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5201068070344868590,\"orderItemId\":5201068070489584649,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5201126277645877985,\"orderItemId\":5201126277790594051,\"scheduleUnitTotalCount\":10.0},{\"orderId\":5201126277706368034,\"orderItemId\":5201126277878448683,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5201126409581904621,\"orderItemId\":5201126409739203585,\"scheduleUnitTotalCount\":5.0},{\"orderId\":5201126409581904622,\"orderItemId\":5201126409739203584,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5201241425815552743,\"orderItemId\":5201241425968657413,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5201796930956641312,\"orderItemId\":5201796931120333351,\"scheduleUnitTotalCount\":2.0},{\"orderId\":5201796930954871532,\"orderItemId\":5201796931112170509,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101520950285,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101550310413,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101579670531,\"scheduleUnitTotalCount\":5.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101600642054,\"scheduleUnitTotalCount\":5.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101621613575,\"scheduleUnitTotalCount\":3.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101638390794,\"scheduleUnitTotalCount\":3.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101659362312,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101680333826,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101697111044,\"scheduleUnitTotalCount\":2.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101718082568,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101739054091,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101768414220,\"scheduleUnitTotalCount\":2.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101793580038,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101818745870,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203243101342679781,\"orderItemId\":5203243101839717379,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203250818213692448,\"orderItemId\":5203250818364801576,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203274501865358058,\"orderItemId\":5203274502060405770,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203274501913265196,\"orderItemId\":5203274502081151534,\"scheduleUnitTotalCount\":3.0},{\"orderId\":5203274501913265196,\"orderItemId\":5203274502110511661,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203274501913265196,\"orderItemId\":5203274502135677484,\"scheduleUnitTotalCount\":3.0},{\"orderId\":5203274502609519651,\"orderItemId\":5203274502752240165,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203619518693786346,\"orderItemId\":5203619518893028355,\"scheduleUnitTotalCount\":2.0},{\"orderId\":5203619518710563566,\"orderItemId\":5203619518867862531,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203619519421170734,\"orderItemId\":5203619519589057061,\"scheduleUnitTotalCount\":1.0},{\"orderId\":5203619706029949987,\"orderItemId\":5203619706181059106,\"scheduleUnitTotalCount\":60.0},{\"orderId\":5203619939795289129,\"orderItemId\":5203619939963175469,\"scheduleUnitTotalCount\":15.0},{\"orderId\":5203619939795289129,\"orderItemId\":5203619939988341281,\"scheduleUnitTotalCount\":6.0}],\"fetchOrderId\":7560392306261138616}],\"deliveryTaskId\":\"5205082271804094727\",\"optUserId\":\"43053\",\"outStockTime\":1687773144626,\"trainsOutStockOrderList\":[{\"orderId\":7560002304141051053,\"orderType\":1,\"outStockOrderId\":5178620122225682593,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012304141009459,\"outStockOrderItemId\":5178620122248667140,\"trainsOutStockDealerList\":[{\"productSpecificationId\":52117,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305121154042,\"orderType\":1,\"outStockOrderId\":5188780052327535589,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305121120564,\"outStockOrderItemId\":5188780052354928162,\"trainsOutStockDealerList\":[{\"productSpecificationId\":163230,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305121120565,\"outStockOrderItemId\":5188780052409454115,\"trainsOutStockDealerList\":[{\"productSpecificationId\":131733,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012305121120566,\"outStockOrderItemId\":5188780052459785761,\"trainsOutStockDealerList\":[{\"productSpecificationId\":203898,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012305121120567,\"outStockOrderItemId\":5188780052505923104,\"trainsOutStockDealerList\":[{\"productSpecificationId\":83982,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305121120568,\"outStockOrderItemId\":5188780052564643361,\"trainsOutStockDealerList\":[{\"productSpecificationId\":141671,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305121154043,\"orderType\":1,\"outStockOrderId\":5188780052365284320,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305121120569,\"outStockOrderItemId\":5188780052392676907,\"trainsOutStockDealerList\":[{\"productSpecificationId\":7521,\"secOwnerId\":1395869718239571991,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305121154044,\"orderType\":1,\"outStockOrderId\":5188780052511208352,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305121120570,\"outStockOrderItemId\":5188780052543683597,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17165,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305130954168,\"orderType\":1,\"outStockOrderId\":5189119199117587365,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305130924213,\"outStockOrderItemId\":5189119199145868298,\"trainsOutStockDealerList\":[{\"productSpecificationId\":567367,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305130954169,\"orderType\":1,\"outStockOrderId\":5189119199118463973,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305130924214,\"outStockOrderItemId\":5189119199145856551,\"trainsOutStockDealerList\":[{\"productSpecificationId\":587184,\"secOwnerId\":1395869718239576516,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305130954170,\"orderType\":1,\"outStockOrderId\":5189119199591543722,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305130924215,\"outStockOrderItemId\":5189119199624018947,\"trainsOutStockDealerList\":[{\"productSpecificationId\":337408,\"secOwnerId\":1395869718239581510,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305130954172,\"orderType\":1,\"outStockOrderId\":5189119199788676001,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305130924221,\"outStockOrderItemId\":5189119199816956941,\"trainsOutStockDealerList\":[{\"productSpecificationId\":310838,\"secOwnerId\":1,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":7560002305130954173,\"orderType\":1,\"outStockOrderId\":5189119200396850081,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305130924222,\"outStockOrderItemId\":5189119200437713927,\"trainsOutStockDealerList\":[{\"productSpecificationId\":522161,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305131054175,\"orderType\":1,\"outStockOrderId\":5189128521327326125,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305131024476,\"outStockOrderItemId\":5189128521355607043,\"trainsOutStockDealerList\":[{\"productSpecificationId\":342967,\"secOwnerId\":1395869718239569155,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305131024477,\"outStockOrderItemId\":5189128521405938699,\"trainsOutStockDealerList\":[{\"productSpecificationId\":421453,\"secOwnerId\":1395869718239569155,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305131024478,\"outStockOrderItemId\":5189128521456270339,\"trainsOutStockDealerList\":[{\"productSpecificationId\":471531,\"secOwnerId\":1395869718239584393,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305131024479,\"outStockOrderItemId\":5189128521502407687,\"trainsOutStockDealerList\":[{\"productSpecificationId\":353087,\"secOwnerId\":1395869718239569155,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012305131024480,\"outStockOrderItemId\":5189128521548545026,\"trainsOutStockDealerList\":[{\"productSpecificationId\":353088,\"secOwnerId\":1395869718239569155,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":7560002305140954310,\"orderType\":1,\"outStockOrderId\":5189475735883846633,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305140927956,\"outStockOrderItemId\":5189475735911239211,\"trainsOutStockDealerList\":[{\"productSpecificationId\":584226,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305140954309,\"orderType\":1,\"outStockOrderId\":5189475735900623842,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305140927957,\"outStockOrderItemId\":5189475735932210727,\"trainsOutStockDealerList\":[{\"productSpecificationId\":584231,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305150954453,\"orderType\":1,\"outStockOrderId\":5189843615871767525,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305150931457,\"outStockOrderItemId\":5189843615899160110,\"trainsOutStockDealerList\":[{\"productSpecificationId\":23530,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305150954454,\"orderType\":1,\"outStockOrderId\":5189843616131814369,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305150931458,\"outStockOrderItemId\":5189843616163401255,\"trainsOutStockDealerList\":[{\"productSpecificationId\":453908,\"secOwnerId\":1,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":7560002305150954455,\"orderType\":1,\"outStockOrderId\":5189843616311292843,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305150931459,\"outStockOrderItemId\":5189843616343768069,\"trainsOutStockDealerList\":[{\"productSpecificationId\":453908,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305161154642,\"orderType\":1,\"outStockOrderId\":5190229658718540773,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305161136007,\"outStockOrderItemId\":5190229658745933349,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17145,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305161154643,\"orderType\":1,\"outStockOrderId\":5190229658735317993,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305161136008,\"outStockOrderItemId\":5190229658766904865,\"trainsOutStockDealerList\":[{\"productSpecificationId\":424453,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012305161136009,\"outStockOrderItemId\":5190229658817236516,\"trainsOutStockDealerList\":[{\"productSpecificationId\":424565,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305161154645,\"orderType\":1,\"outStockOrderId\":5190229710350423018,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305161136011,\"outStockOrderItemId\":5190229710377815587,\"trainsOutStockDealerList\":[{\"productSpecificationId\":64545,\"secOwnerId\":1,\"unitTotalCount\":9.0}],\"unitTotalCount\":9.0}]},{\"orderId\":7560002305170954791,\"orderType\":1,\"outStockOrderId\":5190567514107556768,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305170939486,\"outStockOrderItemId\":5190567514135837705,\"trainsOutStockDealerList\":[{\"productSpecificationId\":123667,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002305181054913,\"orderType\":1,\"outStockOrderId\":5190938957129381638,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305181043521,\"outStockOrderItemId\":5190938957157962305,\"trainsOutStockDealerList\":[{\"productSpecificationId\":81295,\"secOwnerId\":1395869718239581510,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305181054914,\"orderType\":1,\"outStockOrderId\":5190938957573977864,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305181043522,\"outStockOrderItemId\":5190938957598364235,\"trainsOutStockDealerList\":[{\"productSpecificationId\":74978,\"secOwnerId\":2405152967243330413,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305181054915,\"orderType\":1,\"outStockOrderId\":5190939004038477582,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305181043523,\"outStockOrderItemId\":5190939004067058249,\"trainsOutStockDealerList\":[{\"productSpecificationId\":46656,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955100,\"orderType\":1,\"outStockOrderId\":5191292539846036261,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190946999,\"outStockOrderItemId\":5191292539876530476,\"trainsOutStockDealerList\":[{\"productSpecificationId\":394607,\"secOwnerId\":1395869718239574314,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955102,\"orderType\":1,\"outStockOrderId\":5191295201765393249,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947036,\"outStockOrderItemId\":5191295201793228522,\"trainsOutStockDealerList\":[{\"productSpecificationId\":252104,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012305190947037,\"outStockOrderItemId\":5191295201856143084,\"trainsOutStockDealerList\":[{\"productSpecificationId\":407260,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305190955101,\"orderType\":1,\"outStockOrderId\":5191295201937230625,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947035,\"outStockOrderItemId\":5191295201963530538,\"trainsOutStockDealerList\":[{\"productSpecificationId\":555101,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955103,\"orderType\":1,\"outStockOrderId\":5191295202419704675,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947038,\"outStockOrderItemId\":5191295202443345640,\"trainsOutStockDealerList\":[{\"productSpecificationId\":6827,\"secOwnerId\":1395869718239554282,\"unitTotalCount\":18.0}],\"unitTotalCount\":18.0}]},{\"orderId\":7560002305190955104,\"orderType\":1,\"outStockOrderId\":5191295202444870507,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947039,\"outStockOrderItemId\":5191295202472705773,\"trainsOutStockDealerList\":[{\"productSpecificationId\":194879,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955105,\"orderType\":1,\"outStockOrderId\":5191295202910438241,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947040,\"outStockOrderItemId\":5191295202929884909,\"trainsOutStockDealerList\":[{\"productSpecificationId\":471530,\"secOwnerId\":1395869718239584393,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012305190947041,\"outStockOrderItemId\":5191295202984410853,\"trainsOutStockDealerList\":[{\"productSpecificationId\":253631,\"secOwnerId\":1395869718239569155,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305190955106,\"orderType\":1,\"outStockOrderId\":5191295203183068000,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947042,\"outStockOrderItemId\":5191295203206708961,\"trainsOutStockDealerList\":[{\"productSpecificationId\":420733,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012305190947043,\"outStockOrderItemId\":5191295203261234920,\"trainsOutStockDealerList\":[{\"productSpecificationId\":420735,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002305190955107,\"orderType\":1,\"outStockOrderId\":5191295203417819937,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947044,\"outStockOrderItemId\":5191295203448314157,\"trainsOutStockDealerList\":[{\"productSpecificationId\":36693,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955108,\"orderType\":1,\"outStockOrderId\":5191295203921136424,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947045,\"outStockOrderItemId\":5191295203947436333,\"trainsOutStockDealerList\":[{\"productSpecificationId\":449605,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955110,\"orderType\":1,\"outStockOrderId\":5191295204445553505,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947054,\"outStockOrderItemId\":5191295204469194471,\"trainsOutStockDealerList\":[{\"productSpecificationId\":85563,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955109,\"orderType\":1,\"outStockOrderId\":5191295204453813028,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947046,\"outStockOrderItemId\":5191295204480112936,\"trainsOutStockDealerList\":[{\"productSpecificationId\":73392,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305190947047,\"outStockOrderItemId\":5191295204534638890,\"trainsOutStockDealerList\":[{\"productSpecificationId\":554010,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012305190947048,\"outStockOrderItemId\":5191295204589164838,\"trainsOutStockDealerList\":[{\"productSpecificationId\":53183,\"secOwnerId\":1,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0},{\"orderItemId\":7120012305190947049,\"outStockOrderItemId\":5191295204643690785,\"trainsOutStockDealerList\":[{\"productSpecificationId\":203898,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305190947050,\"outStockOrderItemId\":5191295204698216739,\"trainsOutStockDealerList\":[{\"productSpecificationId\":534283,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305190947051,\"outStockOrderItemId\":5191295204752742699,\"trainsOutStockDealerList\":[{\"productSpecificationId\":203897,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305190947052,\"outStockOrderItemId\":5191295204807268645,\"trainsOutStockDealerList\":[{\"productSpecificationId\":542887,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305190947053,\"outStockOrderItemId\":5191295204861794592,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10857,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002305190955111,\"orderType\":1,\"outStockOrderId\":5191295204848077600,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947055,\"outStockOrderItemId\":5191295204874377508,\"trainsOutStockDealerList\":[{\"productSpecificationId\":85563,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955112,\"orderType\":1,\"outStockOrderId\":5191295204940352294,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947056,\"outStockOrderItemId\":5191295204966652199,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17160,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305190955113,\"orderType\":1,\"outStockOrderId\":5191295205393337125,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305190947057,\"outStockOrderItemId\":5191295205419637033,\"trainsOutStockDealerList\":[{\"productSpecificationId\":123667,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305190947058,\"outStockOrderItemId\":5191295205478357287,\"trainsOutStockDealerList\":[{\"productSpecificationId\":128309,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305191155124,\"orderType\":1,\"outStockOrderId\":5191317678029701985,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305191147535,\"outStockOrderItemId\":5191317678053342953,\"trainsOutStockDealerList\":[{\"productSpecificationId\":559571,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305191155123,\"orderType\":1,\"outStockOrderId\":5191317678042155822,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305191147534,\"outStockOrderItemId\":5191317678068455713,\"trainsOutStockDealerList\":[{\"productSpecificationId\":53960,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305191155126,\"orderType\":1,\"outStockOrderId\":5191317678587544421,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305191147538,\"outStockOrderItemId\":5191317678611185389,\"trainsOutStockDealerList\":[{\"productSpecificationId\":509085,\"secOwnerId\":1,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":7560002305191155125,\"orderType\":1,\"outStockOrderId\":5191317678591738729,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305191147536,\"outStockOrderItemId\":5191317678615379689,\"trainsOutStockDealerList\":[{\"productSpecificationId\":619437,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0},{\"orderItemId\":7120012305191147537,\"outStockOrderItemId\":5191317678665711331,\"trainsOutStockDealerList\":[{\"productSpecificationId\":619440,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":7560002305191155127,\"orderType\":1,\"outStockOrderId\":5191317679128609646,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305191147539,\"outStockOrderItemId\":5191317679152250601,\"trainsOutStockDealerList\":[{\"productSpecificationId\":542887,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305191155128,\"orderType\":1,\"outStockOrderId\":5191317679187329897,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305191147540,\"outStockOrderItemId\":5191317679210970853,\"trainsOutStockDealerList\":[{\"productSpecificationId\":143003,\"secOwnerId\":1395869718239557885,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0},{\"orderItemId\":7120012305191147541,\"outStockOrderItemId\":5191317679265496803,\"trainsOutStockDealerList\":[{\"productSpecificationId\":133955,\"secOwnerId\":1395869718239557885,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305191155129,\"orderType\":1,\"outStockOrderId\":5191317679849900835,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305191147542,\"outStockOrderItemId\":5191317679880395042,\"trainsOutStockDealerList\":[{\"productSpecificationId\":39005,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305200955234,\"orderType\":1,\"outStockOrderId\":5191651438590901633,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305200951572,\"outStockOrderItemId\":5191651438615035115,\"trainsOutStockDealerList\":[{\"productSpecificationId\":305622,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305200955235,\"orderType\":1,\"outStockOrderId\":5191651438595162691,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305200951573,\"outStockOrderItemId\":5191651438619995053,\"trainsOutStockDealerList\":[{\"productSpecificationId\":554008,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305200955237,\"orderType\":1,\"outStockOrderId\":5191651439153005131,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305200951576,\"outStockOrderItemId\":5191651439177837486,\"trainsOutStockDealerList\":[{\"productSpecificationId\":598761,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305200955236,\"orderType\":1,\"outStockOrderId\":5191651439178170953,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305200951574,\"outStockOrderItemId\":5191651439198808999,\"trainsOutStockDealerList\":[{\"productSpecificationId\":449605,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012305200951575,\"outStockOrderItemId\":5191651439253334944,\"trainsOutStockDealerList\":[{\"productSpecificationId\":68544,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305201255266,\"orderType\":1,\"outStockOrderId\":5191699921008016778,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305201252545,\"outStockOrderItemId\":5191699921036344544,\"trainsOutStockDealerList\":[{\"productSpecificationId\":38588,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305201255265,\"orderType\":1,\"outStockOrderId\":5191699921024793992,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305201252544,\"outStockOrderItemId\":5191699921048927460,\"trainsOutStockDealerList\":[{\"productSpecificationId\":544902,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012305201252546,\"outStockOrderItemId\":5191699921103453414,\"trainsOutStockDealerList\":[{\"productSpecificationId\":544796,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305201255267,\"orderType\":1,\"outStockOrderId\":5191699921586897475,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305201252547,\"outStockOrderItemId\":5191699921611729833,\"trainsOutStockDealerList\":[{\"productSpecificationId\":555101,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305201255268,\"orderType\":1,\"outStockOrderId\":5191699921662328203,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305201252548,\"outStockOrderItemId\":5191699921686461673,\"trainsOutStockDealerList\":[{\"productSpecificationId\":190520,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305251055718,\"orderType\":1,\"outStockOrderId\":5193471332289098210,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305251069333,\"outStockOrderItemId\":5193471332315921376,\"trainsOutStockDealerList\":[{\"productSpecificationId\":128464,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305251055720,\"orderType\":1,\"outStockOrderId\":5193473380102290542,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305251069408,\"outStockOrderItemId\":5193473380131530209,\"trainsOutStockDealerList\":[{\"productSpecificationId\":119546,\"secOwnerId\":5134042075079549510,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305260955798,\"orderType\":1,\"outStockOrderId\":5193821963858231680,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972849,\"outStockOrderItemId\":5193821963884030793,\"trainsOutStockDealerList\":[{\"productSpecificationId\":40140,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305260955797,\"orderType\":1,\"outStockOrderId\":5193821963906664846,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972850,\"outStockOrderItemId\":5193821963948410149,\"trainsOutStockDealerList\":[{\"productSpecificationId\":287638,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002305260955799,\"orderType\":1,\"outStockOrderId\":5193821964401592715,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972851,\"outStockOrderItemId\":5193821964426560802,\"trainsOutStockDealerList\":[{\"productSpecificationId\":163230,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305260955800,\"orderType\":1,\"outStockOrderId\":5193821964472895873,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972852,\"outStockOrderItemId\":5193821964497863975,\"trainsOutStockDealerList\":[{\"productSpecificationId\":310788,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305260955803,\"orderType\":1,\"outStockOrderId\":5193822198915416461,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972856,\"outStockOrderItemId\":5193822198941215566,\"trainsOutStockDealerList\":[{\"productSpecificationId\":364006,\"secOwnerId\":1395869718239581510,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305260955802,\"orderType\":1,\"outStockOrderId\":5193822198948970882,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972854,\"outStockOrderItemId\":5193822198974769986,\"trainsOutStockDealerList\":[{\"productSpecificationId\":79567,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012305260972855,\"outStockOrderItemId\":5193822199025101636,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10857,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002305260955805,\"orderType\":1,\"outStockOrderId\":5193822199509109132,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972858,\"outStockOrderItemId\":5193822199529882919,\"trainsOutStockDealerList\":[{\"productSpecificationId\":81289,\"secOwnerId\":1395869718239581510,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305260955804,\"orderType\":1,\"outStockOrderId\":5193822199540367755,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972857,\"outStockOrderItemId\":5193822199570361153,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10857,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305260955806,\"orderType\":1,\"outStockOrderId\":5193822200035295623,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305260972859,\"outStockOrderItemId\":5193822200061094724,\"trainsOutStockDealerList\":[{\"productSpecificationId\":364005,\"secOwnerId\":1395869718239581510,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305271055892,\"orderType\":1,\"outStockOrderId\":5194197567114004868,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305271076824,\"outStockOrderItemId\":5194197567138972973,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17145,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305281055957,\"orderType\":1,\"outStockOrderId\":5194558068211597708,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305281080271,\"outStockOrderItemId\":5194558068241591112,\"trainsOutStockDealerList\":[{\"productSpecificationId\":415359,\"secOwnerId\":1395869718239580993,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305281155965,\"orderType\":1,\"outStockOrderId\":5194576806075974017,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305281180535,\"outStockOrderItemId\":5194576806097578826,\"trainsOutStockDealerList\":[{\"productSpecificationId\":36693,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012305281180536,\"outStockOrderItemId\":5194576806164687689,\"trainsOutStockDealerList\":[{\"productSpecificationId\":307782,\"secOwnerId\":1395869718239580744,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305291056036,\"orderType\":1,\"outStockOrderId\":5194921362153294120,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305291084473,\"outStockOrderItemId\":5194921362174986408,\"trainsOutStockDealerList\":[{\"productSpecificationId\":423183,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305291056038,\"orderType\":1,\"outStockOrderId\":5194921976967513760,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305291084492,\"outStockOrderItemId\":5194921976996167053,\"trainsOutStockDealerList\":[{\"productSpecificationId\":154817,\"secOwnerId\":1395869718239584344,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012305291084493,\"outStockOrderItemId\":5194921977050693002,\"trainsOutStockDealerList\":[{\"productSpecificationId\":635645,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305291056037,\"orderType\":1,\"outStockOrderId\":5194921977034622627,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305291084491,\"outStockOrderItemId\":5194921977059081603,\"trainsOutStockDealerList\":[{\"productSpecificationId\":46720,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002305291156046,\"orderType\":1,\"outStockOrderId\":5194936653713819299,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305291184759,\"outStockOrderItemId\":5194936653746666894,\"trainsOutStockDealerList\":[{\"productSpecificationId\":30486,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305291156047,\"orderType\":1,\"outStockOrderId\":5194936653717457194,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305291184760,\"outStockOrderItemId\":5194936653739149477,\"trainsOutStockDealerList\":[{\"productSpecificationId\":20800,\"secOwnerId\":1395869718239554282,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002305291156048,\"orderType\":1,\"outStockOrderId\":5194936654338214180,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305291184761,\"outStockOrderItemId\":5194936654359906475,\"trainsOutStockDealerList\":[{\"productSpecificationId\":19714,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002305291156049,\"orderType\":1,\"outStockOrderId\":5194936679995328167,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012305291184762,\"outStockOrderItemId\":5194936680023981441,\"trainsOutStockDealerList\":[{\"productSpecificationId\":367861,\"secOwnerId\":1,\"unitTotalCount\":24.0}],\"unitTotalCount\":24.0}]},{\"orderId\":7560002306041056514,\"orderType\":1,\"outStockOrderId\":5197106660866135852,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306041010772,\"outStockOrderItemId\":5197106660888631652,\"trainsOutStockDealerList\":[{\"productSpecificationId\":6827,\"secOwnerId\":1395869718239554282,\"unitTotalCount\":24.0}],\"unitTotalCount\":24.0}]},{\"orderId\":7560002306051056608,\"orderType\":1,\"outStockOrderId\":5197467053979473709,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306051015045,\"outStockOrderItemId\":5197467054001969508,\"trainsOutStockDealerList\":[{\"productSpecificationId\":203898,\"secOwnerId\":1,\"unitTotalCount\":19.0}],\"unitTotalCount\":19.0}]},{\"orderId\":7560002306051156619,\"orderType\":1,\"outStockOrderId\":5197484556418515913,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306051115591,\"outStockOrderItemId\":5197484556446704002,\"trainsOutStockDealerList\":[{\"productSpecificationId\":509086,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306051156620,\"orderType\":1,\"outStockOrderId\":5197484627366647590,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306051115592,\"outStockOrderItemId\":5197484627393337705,\"trainsOutStockDealerList\":[{\"productSpecificationId\":32762,\"secOwnerId\":1395869718239576516,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":7120012306051115593,\"outStockOrderItemId\":5197484627452057955,\"trainsOutStockDealerList\":[{\"productSpecificationId\":32763,\"secOwnerId\":1395869718239576516,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":7120012306051115594,\"outStockOrderItemId\":5197484627510778218,\"trainsOutStockDealerList\":[{\"productSpecificationId\":36566,\"secOwnerId\":1395869718239576516,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":7120012306051115595,\"outStockOrderItemId\":5197484627569498469,\"trainsOutStockDealerList\":[{\"productSpecificationId\":86004,\"secOwnerId\":1395869718239571282,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0},{\"orderItemId\":7120012306051115596,\"outStockOrderItemId\":5197484627628218726,\"trainsOutStockDealerList\":[{\"productSpecificationId\":223790,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0},{\"orderItemId\":7120012306051115597,\"outStockOrderItemId\":5197484627703716206,\"trainsOutStockDealerList\":[{\"productSpecificationId\":286317,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0},{\"orderItemId\":7120012306051115598,\"outStockOrderItemId\":5197484627762436462,\"trainsOutStockDealerList\":[{\"productSpecificationId\":559503,\"secOwnerId\":2405152967242234237,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0},{\"orderItemId\":7120012306051115599,\"outStockOrderItemId\":5197484627812768102,\"trainsOutStockDealerList\":[{\"productSpecificationId\":559504,\"secOwnerId\":2405152967242234237,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0},{\"orderItemId\":7120012306051115600,\"outStockOrderItemId\":5197484627863099747,\"trainsOutStockDealerList\":[{\"productSpecificationId\":559505,\"secOwnerId\":2405152967242234237,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0},{\"orderItemId\":7120012306051115601,\"outStockOrderItemId\":5197484627913431404,\"trainsOutStockDealerList\":[{\"productSpecificationId\":559506,\"secOwnerId\":2405152967242234237,\"unitTotalCount\":15.0}],\"unitTotalCount\":15.0},{\"orderItemId\":7120012306051115602,\"outStockOrderItemId\":5197484627976345953,\"trainsOutStockDealerList\":[{\"productSpecificationId\":641745,\"secOwnerId\":2405152967242234237,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0}]},{\"orderId\":7560002306051156623,\"orderType\":1,\"outStockOrderId\":5197484679782864672,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306051115603,\"outStockOrderItemId\":5197484679805360489,\"trainsOutStockDealerList\":[{\"productSpecificationId\":117515,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012306051115604,\"outStockOrderItemId\":5197484679868275046,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10936,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306051156624,\"orderType\":1,\"outStockOrderId\":5197484731606205378,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306051115605,\"outStockOrderItemId\":5197484731630199175,\"trainsOutStockDealerList\":[{\"productSpecificationId\":7394,\"secOwnerId\":1395869718239571282,\"unitTotalCount\":7.0}],\"unitTotalCount\":7.0},{\"orderItemId\":7120012306051115606,\"outStockOrderItemId\":5197484731684725122,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10942,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":7120012306051115607,\"outStockOrderItemId\":5197484731739251083,\"trainsOutStockDealerList\":[{\"productSpecificationId\":11109,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":7120012306051115608,\"outStockOrderItemId\":5197484731802165640,\"trainsOutStockDealerList\":[{\"productSpecificationId\":21897,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012306051115609,\"outStockOrderItemId\":5197484731848302981,\"trainsOutStockDealerList\":[{\"productSpecificationId\":25847,\"secOwnerId\":5089219967342772953,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012306051115610,\"outStockOrderItemId\":5197484731902828936,\"trainsOutStockDealerList\":[{\"productSpecificationId\":34801,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012306051115611,\"outStockOrderItemId\":5197484731957354889,\"trainsOutStockDealerList\":[{\"productSpecificationId\":37170,\"secOwnerId\":5089219967342772953,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":7120012306051115612,\"outStockOrderItemId\":5197484732007686537,\"trainsOutStockDealerList\":[{\"productSpecificationId\":40289,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012306051115613,\"outStockOrderItemId\":5197484732062212481,\"trainsOutStockDealerList\":[{\"productSpecificationId\":72351,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":20.0}],\"unitTotalCount\":20.0},{\"orderItemId\":7120012306051115614,\"outStockOrderItemId\":5197484732112544140,\"trainsOutStockDealerList\":[{\"productSpecificationId\":72354,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":20.0}],\"unitTotalCount\":20.0},{\"orderItemId\":7120012306051115615,\"outStockOrderItemId\":5197484732162875780,\"trainsOutStockDealerList\":[{\"productSpecificationId\":87200,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":20.0}],\"unitTotalCount\":20.0},{\"orderItemId\":7120012306051115616,\"outStockOrderItemId\":5197484732221596040,\"trainsOutStockDealerList\":[{\"productSpecificationId\":154776,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012306051115617,\"outStockOrderItemId\":5197484732276121993,\"trainsOutStockDealerList\":[{\"productSpecificationId\":203898,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":7120012306051115618,\"outStockOrderItemId\":5197484732326453644,\"trainsOutStockDealerList\":[{\"productSpecificationId\":243039,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012306051115619,\"outStockOrderItemId\":5197484732372590982,\"trainsOutStockDealerList\":[{\"productSpecificationId\":477087,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0},{\"orderItemId\":7120012306051115620,\"outStockOrderItemId\":5197484732427116942,\"trainsOutStockDealerList\":[{\"productSpecificationId\":596855,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306061156733,\"orderType\":1,\"outStockOrderId\":5197835237339923394,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306061120128,\"outStockOrderItemId\":5197835237363917185,\"trainsOutStockDealerList\":[{\"productSpecificationId\":65057,\"secOwnerId\":1395869718239558051,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002306061156734,\"orderType\":1,\"outStockOrderId\":5197835237381866434,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306061120129,\"outStockOrderItemId\":5197835237401665921,\"trainsOutStockDealerList\":[{\"productSpecificationId\":46719,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":7120012306061120130,\"outStockOrderItemId\":5197835237464580490,\"trainsOutStockDealerList\":[{\"productSpecificationId\":611998,\"secOwnerId\":5160940572739711642,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002306061156736,\"orderType\":1,\"outStockOrderId\":5197835237893571528,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306061120132,\"outStockOrderItemId\":5197835237921759624,\"trainsOutStockDealerList\":[{\"productSpecificationId\":311120,\"secOwnerId\":2405152967271376502,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306061156735,\"orderType\":1,\"outStockOrderId\":5197835237895051047,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306061120131,\"outStockOrderItemId\":5197835237917546852,\"trainsOutStockDealerList\":[{\"productSpecificationId\":41179,\"secOwnerId\":2405152967243330413,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306061156737,\"orderType\":1,\"outStockOrderId\":5197835238405276617,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306061120133,\"outStockOrderItemId\":5197835238425076096,\"trainsOutStockDealerList\":[{\"productSpecificationId\":491546,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306071556852,\"orderType\":1,\"outStockOrderId\":5198260965931975628,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306071524428,\"outStockOrderItemId\":5198260965955969414,\"trainsOutStockDealerList\":[{\"productSpecificationId\":543381,\"secOwnerId\":1395869718254402484,\"unitTotalCount\":8.0}],\"unitTotalCount\":8.0}]},{\"orderId\":7560002306090957035,\"orderType\":1,\"outStockOrderId\":5198900000947312416,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306090930067,\"outStockOrderItemId\":5198900000969808237,\"trainsOutStockDealerList\":[{\"productSpecificationId\":11110,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306090957034,\"orderType\":1,\"outStockOrderId\":5198900001059079114,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306090930065,\"outStockOrderItemId\":5198900001083072905,\"trainsOutStockDealerList\":[{\"productSpecificationId\":555101,\"secOwnerId\":1,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0},{\"orderItemId\":7120012306090930066,\"outStockOrderItemId\":5198900001141793155,\"trainsOutStockDealerList\":[{\"productSpecificationId\":478280,\"secOwnerId\":2405152967235817706,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002306090957037,\"orderType\":1,\"outStockOrderId\":5198900001512063944,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306090930069,\"outStockOrderItemId\":5198900001536057735,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10922,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306090957036,\"orderType\":1,\"outStockOrderId\":5198900001517737769,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306090930068,\"outStockOrderItemId\":5198900001544427877,\"trainsOutStockDealerList\":[{\"productSpecificationId\":23530,\"secOwnerId\":1395869718239554917,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306090957039,\"orderType\":1,\"outStockOrderId\":5198900060056159175,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306090930071,\"outStockOrderItemId\":5198900060080152973,\"trainsOutStockDealerList\":[{\"productSpecificationId\":80382,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306090957038,\"orderType\":1,\"outStockOrderId\":5198900060070221609,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306090930070,\"outStockOrderItemId\":5198900060092717415,\"trainsOutStockDealerList\":[{\"productSpecificationId\":85563,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306101057169,\"orderType\":1,\"outStockOrderId\":5199279689170387909,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306101033845,\"outStockOrderItemId\":5199279689194381703,\"trainsOutStockDealerList\":[{\"productSpecificationId\":160852,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306101157174,\"orderType\":1,\"outStockOrderId\":5199284638282815269,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306101133896,\"outStockOrderItemId\":5199284638305311075,\"trainsOutStockDealerList\":[{\"productSpecificationId\":152658,\"secOwnerId\":1,\"unitTotalCount\":12.0}],\"unitTotalCount\":12.0}]},{\"orderId\":7560002306110957281,\"orderType\":1,\"outStockOrderId\":5199619133673625799,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937123,\"outStockOrderItemId\":5199619133698258531,\"trainsOutStockDealerList\":[{\"productSpecificationId\":40139,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306110957280,\"orderType\":1,\"outStockOrderId\":5199619133673625800,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937122,\"outStockOrderItemId\":5199619133698258530,\"trainsOutStockDealerList\":[{\"productSpecificationId\":40139,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":7560002306110957282,\"orderType\":1,\"outStockOrderId\":5199619134255125153,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937124,\"outStockOrderItemId\":5199619134280531941,\"trainsOutStockDealerList\":[{\"productSpecificationId\":555101,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306110957283,\"orderType\":1,\"outStockOrderId\":5199619134432794821,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937125,\"outStockOrderItemId\":5199619134461621864,\"trainsOutStockDealerList\":[{\"productSpecificationId\":130564,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012306110937126,\"outStockOrderItemId\":5199619134516147815,\"trainsOutStockDealerList\":[{\"productSpecificationId\":310745,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306110957284,\"orderType\":1,\"outStockOrderId\":5199619134856419529,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937127,\"outStockOrderItemId\":5199619134876857953,\"trainsOutStockDealerList\":[{\"productSpecificationId\":543381,\"secOwnerId\":1395869718254402484,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":7560002306110957285,\"orderType\":1,\"outStockOrderId\":5199619134959768238,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937128,\"outStockOrderItemId\":5199619134985175014,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10929,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":7120012306110937129,\"outStockOrderItemId\":5199619135035506667,\"trainsOutStockDealerList\":[{\"productSpecificationId\":243013,\"secOwnerId\":1395869718239568899,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":7560002306110957286,\"orderType\":1,\"outStockOrderId\":5199619135408558753,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937130,\"outStockOrderItemId\":5199619135429771242,\"trainsOutStockDealerList\":[{\"productSpecificationId\":252104,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":7120012306110937131,\"outStockOrderItemId\":5199619135484297197,\"trainsOutStockDealerList\":[{\"productSpecificationId\":287638,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306110957287,\"orderType\":1,\"outStockOrderId\":5199619135472982212,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937132,\"outStockOrderItemId\":5199619135497614958,\"trainsOutStockDealerList\":[{\"productSpecificationId\":15053,\"secOwnerId\":1395869718239576516,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306110957288,\"orderType\":1,\"outStockOrderId\":5199619135921772746,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937133,\"outStockOrderItemId\":5199619135946405475,\"trainsOutStockDealerList\":[{\"productSpecificationId\":130564,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306110957289,\"orderType\":1,\"outStockOrderId\":5199619135978984097,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937134,\"outStockOrderItemId\":5199619136000196586,\"trainsOutStockDealerList\":[{\"productSpecificationId\":50775,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306110957290,\"orderType\":1,\"outStockOrderId\":5199619136475420878,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937135,\"outStockOrderItemId\":5199619136500053604,\"trainsOutStockDealerList\":[{\"productSpecificationId\":69876,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306110957291,\"orderType\":1,\"outStockOrderId\":5199619136494883499,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306110937136,\"outStockOrderItemId\":5199619136520290279,\"trainsOutStockDealerList\":[{\"productSpecificationId\":214509,\"secOwnerId\":5089219967342772953,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306111057300,\"orderType\":1,\"outStockOrderId\":5199635838957312196,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306111037201,\"outStockOrderItemId\":5199635838981944932,\"trainsOutStockDealerList\":[{\"productSpecificationId\":576180,\"secOwnerId\":1395869718239558051,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306111057299,\"orderType\":1,\"outStockOrderId\":5199635839035495078,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306111037200,\"outStockOrderItemId\":5199635839060901858,\"trainsOutStockDealerList\":[{\"productSpecificationId\":79567,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306111057302,\"orderType\":1,\"outStockOrderId\":5199635839471702688,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306111037202,\"outStockOrderItemId\":5199635839497109473,\"trainsOutStockDealerList\":[{\"productSpecificationId\":25779,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":7560002306111057301,\"orderType\":1,\"outStockOrderId\":5199635839578069193,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306111037203,\"outStockOrderItemId\":5199635839602701931,\"trainsOutStockDealerList\":[{\"productSpecificationId\":582319,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306111057304,\"orderType\":1,\"outStockOrderId\":5199635840127523017,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306111037205,\"outStockOrderItemId\":5199635840152155750,\"trainsOutStockDealerList\":[{\"productSpecificationId\":398943,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306120957384,\"orderType\":1,\"outStockOrderId\":5199987441932030637,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306120940435,\"outStockOrderItemId\":5199987441957437410,\"trainsOutStockDealerList\":[{\"productSpecificationId\":576181,\"secOwnerId\":1395869718239558051,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306120957383,\"orderType\":1,\"outStockOrderId\":5199987441933539526,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306120940434,\"outStockOrderItemId\":5199987441958172265,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17163,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":7560002306120957385,\"orderType\":1,\"outStockOrderId\":5199987442540204714,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306120940436,\"outStockOrderItemId\":5199987442561417188,\"trainsOutStockDealerList\":[{\"productSpecificationId\":147372,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":7560002306121057397,\"orderType\":1,\"outStockOrderId\":5200004367338494148,\"trainsOutStockOrderItemList\":[{\"orderItemId\":7120012306121040750,\"outStockOrderItemId\":5200004367363126888,\"trainsOutStockDealerList\":[{\"productSpecificationId\":151408,\"secOwnerId\":1395869718239580993,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0}]},{\"orderId\":5200711388106015786,\"orderType\":3,\"outStockOrderId\":5200711444335745228,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5200711388294873640,\"outStockOrderItemId\":5200711444343600747,\"trainsOutStockDealerList\":[{\"productSpecificationId\":33285,\"secOwnerId\":1,\"unitTotalCount\":30.0}],\"unitTotalCount\":30.0},{\"orderItemId\":5200711388324233768,\"outStockOrderItemId\":5200711444356183651,\"trainsOutStockDealerList\":[{\"productSpecificationId\":31888,\"secOwnerId\":1395869718239581913,\"unitTotalCount\":12.0}],\"unitTotalCount\":12.0},{\"orderItemId\":5200711388345205283,\"outStockOrderItemId\":5200711444372960867,\"trainsOutStockDealerList\":[{\"productSpecificationId\":32552,\"secOwnerId\":1,\"unitTotalCount\":12.0}],\"unitTotalCount\":12.0},{\"orderItemId\":5200711388370371112,\"outStockOrderItemId\":5200711444389738082,\"trainsOutStockDealerList\":[{\"productSpecificationId\":67217,\"secOwnerId\":1395869718239561803,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0},{\"orderItemId\":5200711388391342627,\"outStockOrderItemId\":5200711444402321001,\"trainsOutStockDealerList\":[{\"productSpecificationId\":30977,\"secOwnerId\":1395869718239581913,\"unitTotalCount\":9.0}],\"unitTotalCount\":9.0}]},{\"orderId\":5200734179547104301,\"orderType\":3,\"outStockOrderId\":5200734219342041769,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5200734179689824814,\"outStockOrderItemId\":5200734219346477036,\"trainsOutStockDealerList\":[{\"productSpecificationId\":30479,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5200734179534521381,\"orderType\":3,\"outStockOrderId\":5200734219498739912,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5200734179681436194,\"outStockOrderItemId\":5200734219506595435,\"trainsOutStockDealerList\":[{\"productSpecificationId\":128870,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":5201067815689471015,\"orderType\":3,\"outStockOrderId\":5201067855225870534,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201067815836385838,\"outStockOrderItemId\":5201067855233726062,\"trainsOutStockDealerList\":[{\"productSpecificationId\":31461,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":5201068070187254825,\"orderType\":3,\"outStockOrderId\":5201068127866704556,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201068070334169638,\"outStockOrderItemId\":5201068127871139811,\"trainsOutStockDealerList\":[{\"productSpecificationId\":36813,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":5201068070344868590,\"orderType\":3,\"outStockOrderId\":5201068127994042560,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201068070489584649,\"outStockOrderItemId\":5201068127997703782,\"trainsOutStockDealerList\":[{\"productSpecificationId\":36813,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0}]},{\"orderId\":5201126277645877985,\"orderType\":3,\"outStockOrderId\":5201126323748133064,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201126277790594051,\"outStockOrderItemId\":5201126323755988583,\"trainsOutStockDealerList\":[{\"productSpecificationId\":496074,\"secOwnerId\":1395869718239561803,\"unitTotalCount\":10.0}],\"unitTotalCount\":10.0}]},{\"orderId\":5201126277706368034,\"orderType\":3,\"outStockOrderId\":5201126323894933706,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201126277878448683,\"outStockOrderItemId\":5201126323902789227,\"trainsOutStockDealerList\":[{\"productSpecificationId\":567922,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5201126409581904621,\"orderType\":3,\"outStockOrderId\":5201126450617440451,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201126409739203585,\"outStockOrderItemId\":5201126450625295968,\"trainsOutStockDealerList\":[{\"productSpecificationId\":544801,\"secOwnerId\":1,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0}]},{\"orderId\":5201126409581904622,\"orderType\":3,\"outStockOrderId\":5201126450755852491,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201126409739203584,\"outStockOrderItemId\":5201126450763708013,\"trainsOutStockDealerList\":[{\"productSpecificationId\":91295,\"secOwnerId\":1395869718239559678,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5201241425815552743,\"orderType\":3,\"outStockOrderId\":5201241478464026504,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201241425968657413,\"outStockOrderItemId\":5201241478469694339,\"trainsOutStockDealerList\":[{\"productSpecificationId\":25000,\"secOwnerId\":1,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0}]},{\"orderId\":5201796930956641312,\"orderType\":3,\"outStockOrderId\":5201796931698792651,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201796931120333351,\"outStockOrderItemId\":5201796931751454956,\"trainsOutStockDealerList\":[{\"productSpecificationId\":127818,\"secOwnerId\":1395869718239578523,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":5201796930954871532,\"orderType\":3,\"outStockOrderId\":5201796931698792652,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5201796931112170509,\"outStockOrderItemId\":5201796931743066343,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17145,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5203243101342679781,\"orderType\":3,\"outStockOrderId\":5203243102669171008,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203243101520950285,\"outStockOrderItemId\":5203243102719464836,\"trainsOutStockDealerList\":[{\"productSpecificationId\":51098,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":5203243101550310413,\"outStockOrderItemId\":5203243102732047746,\"trainsOutStockDealerList\":[{\"productSpecificationId\":51790,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":5203243101579670531,\"outStockOrderItemId\":5203243102744630664,\"trainsOutStockDealerList\":[{\"productSpecificationId\":31783,\"secOwnerId\":1,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0},{\"orderItemId\":5203243101600642054,\"outStockOrderItemId\":5203243102753019269,\"trainsOutStockDealerList\":[{\"productSpecificationId\":77558,\"secOwnerId\":1,\"unitTotalCount\":5.0}],\"unitTotalCount\":5.0},{\"orderItemId\":5203243101621613575,\"outStockOrderItemId\":5203243102761407879,\"trainsOutStockDealerList\":[{\"productSpecificationId\":23372,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":5203243101638390794,\"outStockOrderItemId\":5203243102769796481,\"trainsOutStockDealerList\":[{\"productSpecificationId\":23374,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":5203243101659362312,\"outStockOrderItemId\":5203243102786573709,\"trainsOutStockDealerList\":[{\"productSpecificationId\":288219,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":5203243101680333826,\"outStockOrderItemId\":5203243102794962309,\"trainsOutStockDealerList\":[{\"productSpecificationId\":51129,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":5203243101697111044,\"outStockOrderItemId\":5203243102803350917,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10944,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":5203243101718082568,\"outStockOrderItemId\":5203243102811739528,\"trainsOutStockDealerList\":[{\"productSpecificationId\":381106,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":5203243101739054091,\"outStockOrderItemId\":5203243102824322444,\"trainsOutStockDealerList\":[{\"productSpecificationId\":77220,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":5203243101768414220,\"outStockOrderItemId\":5203243102836905356,\"trainsOutStockDealerList\":[{\"productSpecificationId\":547969,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0},{\"orderItemId\":5203243101793580038,\"outStockOrderItemId\":5203243102845293957,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17151,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":5203243101818745870,\"outStockOrderItemId\":5203243102853682570,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17154,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":5203243101839717379,\"outStockOrderItemId\":5203243102862071171,\"trainsOutStockDealerList\":[{\"productSpecificationId\":41029,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5203250818213692448,\"orderType\":3,\"outStockOrderId\":5203250818909268288,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203250818364801576,\"outStockOrderItemId\":5203250818951173516,\"trainsOutStockDealerList\":[{\"productSpecificationId\":50773,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5203274501865358058,\"orderType\":3,\"outStockOrderId\":5203274502608321198,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203274502060405770,\"outStockOrderItemId\":5203274502660136263,\"trainsOutStockDealerList\":[{\"productSpecificationId\":379768,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5203274501913265196,\"orderType\":3,\"outStockOrderId\":5203274502722087244,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203274502081151534,\"outStockOrderItemId\":5203274502772381063,\"trainsOutStockDealerList\":[{\"productSpecificationId\":393665,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0},{\"orderItemId\":5203274502110511661,\"outStockOrderItemId\":5203274502784963980,\"trainsOutStockDealerList\":[{\"productSpecificationId\":311010,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0},{\"orderItemId\":5203274502135677484,\"outStockOrderItemId\":5203274502797546883,\"trainsOutStockDealerList\":[{\"productSpecificationId\":311012,\"secOwnerId\":1,\"unitTotalCount\":3.0}],\"unitTotalCount\":3.0}]},{\"orderId\":5203274502609519651,\"orderType\":3,\"outStockOrderId\":5203274503300381348,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203274502752240165,\"outStockOrderItemId\":5203274503356390729,\"trainsOutStockDealerList\":[{\"productSpecificationId\":379763,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5203619518693786346,\"orderType\":3,\"outStockOrderId\":5203619519437110016,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203619518893028355,\"outStockOrderItemId\":5203619519486177251,\"trainsOutStockDealerList\":[{\"productSpecificationId\":522162,\"secOwnerId\":1,\"unitTotalCount\":2.0}],\"unitTotalCount\":2.0}]},{\"orderId\":5203619518710563566,\"orderType\":3,\"outStockOrderId\":5203619519441304320,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203619518867862531,\"outStockOrderItemId\":5203619519486177252,\"trainsOutStockDealerList\":[{\"productSpecificationId\":129797,\"secOwnerId\":5168565388699316880,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5203619519421170734,\"orderType\":3,\"outStockOrderId\":5203619520141023555,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203619519589057061,\"outStockOrderItemId\":5203619520189397479,\"trainsOutStockDealerList\":[{\"productSpecificationId\":449474,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]},{\"orderId\":5203619706029949987,\"orderType\":3,\"outStockOrderId\":5203619706737949452,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203619706181059106,\"outStockOrderItemId\":5203619706782822370,\"trainsOutStockDealerList\":[{\"productSpecificationId\":311120,\"secOwnerId\":2405152967271376502,\"unitTotalCount\":60.0}],\"unitTotalCount\":60.0}]},{\"orderId\":5203619939795289129,\"orderType\":3,\"outStockOrderId\":5203619940612340490,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5203619939963175469,\"outStockOrderItemId\":5203619940657213417,\"trainsOutStockDealerList\":[{\"productSpecificationId\":154275,\"secOwnerId\":1,\"unitTotalCount\":15.0}],\"unitTotalCount\":15.0},{\"orderItemId\":5203619939988341281,\"outStockOrderItemId\":5203619940669796321,\"trainsOutStockDealerList\":[{\"productSpecificationId\":76373,\"secOwnerId\":1395869718239568782,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0}]}],\"warehouseId\":7561}";
        TrainsOutStockDTO trainsOutStockDTO = JSON.parseObject(json, TrainsOutStockDTO.class);
//        fixNptOutData(trainsOutStockDTO);

        List<Long> orderItemIds = new ArrayList<>();
        trainsOutStockDTO.getTrainsOutStockOrderList().forEach(it -> it.getTrainsOutStockOrderItemList().forEach(item -> {
            List<TrainsOutStockDealerDTO> trainsOutStockDealerList = item.getTrainsOutStockDealerList();
            for (TrainsOutStockDealerDTO trainsOutStockDealerDTO : trainsOutStockDealerList) {
                if (trainsOutStockDealerDTO.getSecOwnerId() == null) {
                    orderItemIds.add(item.getOrderItemId());
                }
            }
        }));

        if (CollectionUtils.isNotEmpty(orderItemIds)) {
            throw new BusinessException("二级货主id不能为null," + orderItemIds);
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
                    } else {
                        if (!elkDTO.getSecOwnerId().equals(secOwnerId)) {
                            System.out.println("二级货主变更," + item.getOrderItemId());
                            trainsOutStockDealerDTO.setSecOwnerId(elkDTO.getSecOwnerId());
                        }
                    }
                }
            }
        }));
    }


}
