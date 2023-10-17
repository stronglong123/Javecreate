package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventConsumptionAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
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

        String code = "pre";
        String filePath = "C:\\Users\\Administrator\\Desktop\\fms完成异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "fms完成异常.xlsx");
        for (ElkDTO elkDTO : list) {
            String orderNo = elkDTO.getOrderNo();
            Long orderId = getByOrderNo(orderNo);
            EventPublishAuditDocumentDTO publishAuditDocument = eventSaleCompleteConsumptionAuditQuery(code, orderId);
            if (publishAuditDocument == null) {
                continue;
            }
            EventConsumptionAuditDocumentDTO auditDocument = findErrorEventConsum(code, publishAuditDocument.getEventId());
            if (auditDocument.getSuccess().equals(0)) {
                System.out.println(String.format("订单id完成事件推送fms成功,orderId=%s,orderNo=%s", orderId, orderNo));
                continue;
            }
            System.out.println(String.format("订单id完成事件推送fms失败,orderId=%s,orderNo=%s,remark=%s", orderId, orderNo, auditDocument.getRemark()));

            if (auditDocument.getRemark().contains("资金平台接口返回值解析错误")) {
                retryExternal(code, auditDocument);
                FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\fms数据推送重试处理.txt",
                        JSON.toJSONString(auditDocument.getRemark()) + String.format("订单id完成事件失败,orderId=%s,orderNo=%s", orderId, orderNo) + ",");
            }else {
                System.out.println(String.format("其他异常:%s,orderId=%s,orderNo=%s",auditDocument.getRemark(),orderId,orderNo));
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


    private static EventPublishAuditDocumentDTO eventSaleCompleteConsumptionAuditQuery(String code, Long orderId) {
        String params = "[\n" +
                "    {\n" +
                "        \"body\": \"" + orderId +
                "\",\n" +
                "        \"eventCode\": \"SaleComplete\",\n" +
                "        \"pageIndex\": 1,\n" +
                "        \"pageSize\": 20\n" +
                "    }\n" +
                "]";
        List<EventPublishAuditDocumentDTO> documentDTOS = NewApiTest.eventConsumptionAuditQuery(code, params);
        if (com.alibaba.dubbo.common.utils.CollectionUtils.isEmpty(documentDTOS)) {
            return null;
        }
        return documentDTOS.get(0);
    }


    private static EventConsumptionAuditDocumentDTO findErrorEventConsum(String code, String eventId) {
        String params = "[\n" +
                "    {\n" +
                "        \"eventId\":\" " + eventId +
                "\",\n" +
                "        \"pageIndex\": 1,\n" +
                "        \"pageSize\": 20,\n" +
                "        \"partnerCode\": \"YJP-FMS\"\n" +
                "    }\n" +
                "]";
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
        NewApiTest.retryExternal(code,JSON.toJSONString(map));
    }

}
