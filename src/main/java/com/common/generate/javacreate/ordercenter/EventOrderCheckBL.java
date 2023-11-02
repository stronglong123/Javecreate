package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.PushSaleOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventConsumptionAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2023/10/16 11:59
 */
public class EventOrderCheckBL {


    @SneakyThrows
    public static void main(String[] args) {
        erpEventPushError();
//        findEventPushError();
    }

    @SneakyThrows
    public static void erpEventPushError() {
        String code = "pre";
        List<EventConsumptionAuditDocumentDTO> erpErrorEventConsum = findErpErrorEventConsum(code);
        List<Long> orderIds = new ArrayList<>();
        for (EventConsumptionAuditDocumentDTO auditDocumentDTO : erpErrorEventConsum) {
            if (auditDocumentDTO.getRemark().contains("Nullable object must have a value")) {
//                String params = "[{\"eventId\":\"" +
//                        auditDocumentDTO.getEventId() +
//                        "\",\"pageIndex\":1,\"pageSize\":1}]";
//                EventPublishAuditDocumentDTO eventPublish = eventSaleCompleteConsumptionAuditQuery(code, params);
//                PushSaleOrderDTO pushSaleOrderDTO = JSON.parseObject(eventPublish.getBody(), PushSaleOrderDTO.class);
//                Long orderId = pushSaleOrderDTO.getSaleOrder().getOrderBaseDTO().getOrderId();
//                if (pushSaleOrderDTO.getSaleOrder().getOrderAmountDTO().getPayType() == null) {
//                    System.out.println(orderId + "paytype为空");
//                }
//                OrderDocumentDTO order = NewApiTest.getOrderById(code, orderId);
//                if (order.getOrderAmount().getPayType() != null) {
//                    System.out.println(orderId + "数据已修复");
//                    NewApiTest.repairSaleComplete(code, orderId);
//                    orderIds.add(orderId);
//                } else {
//                    System.out.println(orderId + "数据未修复");
//                }
            }else if(auditDocumentDTO.getRemark().contains("不匹配")){
                String params = "[{\"eventId\":\"" +
                        auditDocumentDTO.getEventId() +
                        "\",\"pageIndex\":1,\"pageSize\":1}]";
                EventPublishAuditDocumentDTO eventPublish = eventSaleCompleteConsumptionAuditQuery(code, params);
                PushSaleOrderDTO pushSaleOrderDTO = JSON.parseObject(eventPublish.getBody(), PushSaleOrderDTO.class);
                Long orderId = pushSaleOrderDTO.getSaleOrder().getOrderBaseDTO().getOrderId();
                System.out.println(orderId + "数据未修复"+","+auditDocumentDTO.getRemark());
                NewApiTest.repairSaleComplete(code, orderId);
            }
        }
        System.out.println(orderIds);
    }

    @SneakyThrows
    public static void findEventPushError() {
        String code = "pre";
        List<Long> orderList = Arrays.asList(7110002310302183625L, 7110002310302083617L, 7110002310301783526L, 7110002310301783532L, 7110002310302083593L, 7110002310301783531L, 7110002310301783530L, 7110002310302183650L, 7110002310302183624L, 7110002310301783527L, 7110002310302183639L, 7110002310302183660L, 7110002310302183661L, 7110002310302183638L, 7110002310301783533L, 7110002310301883560L, 7110002310302083606L, 7110002310301983582L, 7110002310302283664L, 7110002310302083605L, 7110002310301983570L, 7110002310302283665L, 7110002310302283670L, 7110002310302283669L, 7110002310301983569L, 7110002310302083595L, 7110002310302083596L, 7110002310301883561L, 7110002310302283673L, 7110002310302083594L, 7110002310301783522L, 7110002310301783517L, 7110002310302183635L, 7110002310302183636L, 7110002310302083616L, 7110002310302083615L, 7110002310301783516L, 7110002310301783514L);
        for (Long orderId : orderList) {
            String params = "[\n" +
                    "    {\n" +
                    "        \"body\": \"" + orderId +
                    "\",\n" +
                    "        \"eventCode\": \"SaleComplete\",\n" +
                    "        \"pageIndex\": 1,\n" +
                    "        \"pageSize\": 20\n" +
                    "    }\n" +
                    "]";
            EventPublishAuditDocumentDTO publishAuditDocument = eventSaleCompleteConsumptionAuditQuery(code, params);
            if (publishAuditDocument == null) {
                continue;
            }
            String auditParams = "[\n" +
                    "    {\n" +
                    "        \"eventId\":\" " + publishAuditDocument.getEventId() +
                    "\",\n" +
                    "        \"pageIndex\": 1,\n" +
                    "        \"pageSize\": 20,\n" +
                    "        \"partnerCode\": \"YJP-ERP\"\n" +
                    "    }\n" +
                    "]";
            EventConsumptionAuditDocumentDTO auditDocument = findErrorEventConsum(code, auditParams);
            if (auditDocument.getSuccess().equals(0)) {
                System.out.println(String.format("订单id完成事件推送erp成功,orderId=%s", orderId));
                continue;
            }
            System.out.println(String.format("订单id完成事件推送erp失败,orderId=%s,remark=%s", orderId, auditDocument.getRemark()));
        }
    }


    @SneakyThrows
    public static void fmsEventPushError() {
        String code = "pre";
        String filePath = "C:\\Users\\Administrator\\Desktop\\fms完成异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "fms完成异常.xlsx");
        for (ElkDTO elkDTO : list) {
            String orderNo = elkDTO.getOrderNo();
            Long orderId = getByOrderNo(orderNo);
            String params = "[\n" +
                    "    {\n" +
                    "        \"body\": \"" + orderId +
                    "\",\n" +
                    "        \"eventCode\": \"SaleComplete\",\n" +
                    "        \"pageIndex\": 1,\n" +
                    "        \"pageSize\": 20\n" +
                    "    }\n" +
                    "]";
            EventPublishAuditDocumentDTO publishAuditDocument = eventSaleCompleteConsumptionAuditQuery(code, params);
            if (publishAuditDocument == null) {
                continue;
            }

            String auditParams = "[\n" +
                    "    {\n" +
                    "        \"eventId\":\" " + publishAuditDocument.getEventId() +
                    "\",\n" +
                    "        \"pageIndex\": 1,\n" +
                    "        \"pageSize\": 20,\n" +
                    "        \"partnerCode\": \"YJP-FMS\"\n" +
                    "    }\n" +
                    "]";
            EventConsumptionAuditDocumentDTO auditDocument = findErrorEventConsum(code, auditParams);
            if (auditDocument.getSuccess().equals(0)) {
                System.out.println(String.format("订单id完成事件推送fms成功,orderId=%s,orderNo=%s", orderId, orderNo));
                continue;
            }
            System.out.println(String.format("订单id完成事件推送fms失败,orderId=%s,orderNo=%s,remark=%s", orderId, orderNo, auditDocument.getRemark()));

            if (auditDocument.getRemark().contains("资金平台接口返回值解析错误")) {
                retryExternal(code, auditDocument);
                FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\fms数据推送重试处理.txt",
                        JSON.toJSONString(auditDocument.getRemark()) + String.format("订单id完成事件失败,orderId=%s,orderNo=%s", orderId, orderNo) + ",");
            } else {
                System.out.println(String.format("其他异常:%s,orderId=%s,orderNo=%s", auditDocument.getRemark(), orderId, orderNo));
            }
        }
    }


    private static Long getByOrderNo(String orderNo) {
        String param = "[{\"orderWord\":\"" +
                orderNo +
                "\"},{\"pageIndex\":1,\"pageSize\":10}]";
        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", param);
        if (CollectionUtils.isEmpty(orderList)) {
            return null;
        }
        return orderList.get(0).getOrderBase().getOrderId();
    }


    private static EventPublishAuditDocumentDTO eventSaleCompleteConsumptionAuditQuery(String code, String params) {
        List<EventPublishAuditDocumentDTO> documentDTOS = NewApiTest.eventConsumptionAuditQuery(code, params);
        if (com.alibaba.dubbo.common.utils.CollectionUtils.isEmpty(documentDTOS)) {
            return null;
        }
        return documentDTOS.get(0);
    }


    private static List<EventConsumptionAuditDocumentDTO> findErpErrorEventConsum(String code) {
        String params = "[{\"eventId\":\"\",\"partnerCode\":\"YJP-ERP\",\"sourceBusinessFlowCode\":\"payConfirm\",\"success\":1,\"pageIndex\":1,\"pageSize\":100}]";
        List<EventConsumptionAuditDocumentDTO> errorEventConsum = NewApiTest.findErrorEventConsum(code, params);
        return errorEventConsum;
    }

    private static EventConsumptionAuditDocumentDTO findErrorEventConsum(String code, String params) {
        List<EventConsumptionAuditDocumentDTO> errorEventConsum = NewApiTest.findErrorEventConsum(code, params);
        EventConsumptionAuditDocumentDTO auditDocumentDTO = errorEventConsum.get(0);
        return auditDocumentDTO;
    }


    /**
     * 4、重试
     * https://ocop.yijiupi.com/ordercenter-event-managerms/action/ConsumptionEventRetryService/retryExternal
     * {"eventSubscriptionId":"632bf4920725b00001ce4baf","eventId":"SaleComplete:5179503116984220014","eventConsumptionAuditId":"PPIoiocBtSr0l09e4Gi9"}
     */
    private static void retryExternal(String code, EventConsumptionAuditDocumentDTO auditDocument) {
        Map<String, String> map = new HashMap<>();
        map.put("eventSubscriptionId", auditDocument.getEventSubscriptionId());
        map.put("eventId", auditDocument.getEventId());
        map.put("eventConsumptionAuditId", auditDocument.getId());
        NewApiTest.retryExternal(code, JSON.toJSONString(map));
    }

}
