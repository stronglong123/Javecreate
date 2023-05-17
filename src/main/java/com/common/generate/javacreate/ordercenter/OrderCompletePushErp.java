package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventConsumptionAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2023/4/27 16:43
 */
public class OrderCompletePushErp {

    @SneakyThrows
    public static void main(String[] args) {
        List<String> noFixOrderNoList = new ArrayList<>();
//        String filePath = "C:\\Users\\Administrator\\Desktop\\4月份销售单问题.xlsx";
//        FileInputStream file = new FileInputStream(filePath);
//        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "4月份销售单问题.xlsx");
//        for (ElkDTO elkDTO : list) {
//            if(StringUtils.isEmpty(elkDTO.getOrderNo())){
//                continue;
//            }
//            checkDataAndFix(elkDTO.getOrderNo(), noFixOrderNoList);
//        }
//        System.out.println(JSON.toJSONString("未处理销售单="+JSON.toJSONString(noFixOrderNoList)));



        List<String> orderNos = Arrays.asList("757312500019","757312500020","757312500021","757312500022","757312500023","757312500024 ","757312500025","757312500026");
        for (String orderNo : orderNos) {
           checkDataAndFix(orderNo, noFixOrderNoList);
        }


    }



    private static void checkDataAndFix(String orderNo,List<String> noFixOrderNoList){
        String code = "pre";

        Long orderId = getOrderIdByOrderNo(code, orderNo);

        EventPublishAuditDocumentDTO publishAuditDocument = eventSaleCompleteConsumptionAuditQuery(code, orderId);
        if (publishAuditDocument == null) {
            EventPublishAuditDocumentDTO exist = eventConsumptionAuditQuery(code, orderId);
            if (exist != null) {
                System.out.println(String.format("订单处理异常,不存在完成事件,orderId=%s,orderNo=%s", orderId, orderNo));
            } else {
                System.out.println(String.format("老流程完成订单,orderId=%s,orderNo=%s", orderId, orderNo));
            }
            return;
        }

        EventConsumptionAuditDocumentDTO auditDocument = findErrorEventConsum(code, publishAuditDocument.getEventId());
//        System.out.println("事件结果：" + JSON.toJSONString(auditDocument));
        if (auditDocument.getSuccess().equals(0)) {
            System.out.println(String.format("订单id完成事件成功,orderId=%s,orderNo=%s", orderId, orderNo));
            return;
        }
        System.out.println(String.format("订单id完成事件失败,orderId=%s,orderNo=%s,remark=%s", orderId, orderNo, auditDocument.getRemark()));
//        if (auditDocument.getRemark().contains("订单不能有多个不同的一级货主") || auditDocument.getRemark().contains("一级货主不存在")) {
////            retryExternal(code, auditDocument);
//            FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\erp数据推送重试处理.txt",
//                    JSON.toJSONString(auditDocument.getRemark()) + String.format("订单id完成事件失败,orderId=%s,orderNo=%s", orderId, orderNo) + ",");
//        } else {
//            FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\erp数据推送失败未处理.txt",
//                    JSON.toJSONString(auditDocument.getRemark()) + String.format("订单id完成事件失败,orderId=%s,orderNo=%s", orderId, orderNo) + ",");
//            noFixOrderNoList.add(orderNo);
//        }
    }


    /**
     * 1、查询id
     * https://ocop.yijiupi.com/ordercenter-aggregatequery-servicems/OrderCommonQueryService/findPageByOrderSnapshot
     * [{"orderWord":"472310100007-2"},{"pageIndex":1,"pageSize":10}]
     */
    private static Long getOrderIdByOrderNo(String code, String orderNo) {
        String params = "[\n" +
                "    {\n" +
                "        \"orderWord\":\" " + orderNo +
                "\"," +
                "        \"companyCode\":\"YJP\",\n" +
                "        \"firstOrderType\":2\n" +
                "    },\n" +
                "    {\n" +
                "        \"pageIndex\": 1,\n" +
                "        \"pageSize\": 10\n" +
                "    }\n" +
                "]";

        List<OrderDocumentDTO> pageByOrderSnapshot = NewApiTest.findPageByOrderSnapshot(code, params);
        return pageByOrderSnapshot.get(0).getOrderBase().getOrderId();
    }


    /**
     * 2、查询事件
     * https://ocop.yijiupi.com/ordercenter-event-managerms/EventPublishAuditQueryService/findPage
     * [{"body":"5177655736595987009","eventCode":"SaleComplete","pageIndex":1,"pageSize":20}]
     */
    private static EventPublishAuditDocumentDTO eventSaleCompleteConsumptionAuditQuery(String code, Long orderId) {
        String params = "[\n" +
                "    {\n" +
                "        \"body\": \"" + orderId +
                "\",\n" +
                "        \"eventCode\": \"ReturnOrderComplete\",\n" +
                "        \"pageIndex\": 1,\n" +
                "        \"pageSize\": 20\n" +
                "    }\n" +
                "]";
        List<EventPublishAuditDocumentDTO> documentDTOS = NewApiTest.eventConsumptionAuditQuery(code, params);
        if(CollectionUtils.isEmpty(documentDTOS)){
            return null;
        }
        return documentDTOS.get(0);
    }

    private static EventPublishAuditDocumentDTO eventConsumptionAuditQuery(String code, Long orderId) {
        String params = "[\n" +
                "    {\n" +
                "        \"body\": \"" + orderId +
                "\",\n" +
                "        \"pageIndex\": 1,\n" +
                "        \"pageSize\": 20\n" +
                "    }\n" +
                "]";
        List<EventPublishAuditDocumentDTO> documentDTOS = NewApiTest.eventConsumptionAuditQuery(code, params);
        if(CollectionUtils.isEmpty(documentDTOS)){
            return null;
        }
        return documentDTOS.get(0);
    }


    /**
     * 3、查看erp订阅
     * https://ocop.yijiupi.com/ordercenter-event-managerms/EventConsumptionAuditQueryService/findPage
     * [{"eventId":"SaleComplete:5179503116984220014","partnerCode":"YJP-ERP","pageIndex":1,"pageSize":20}]
     */
    private static EventConsumptionAuditDocumentDTO findErrorEventConsum(String code, String eventId) {
        String params = "[\n" +
                "    {\n" +
                "        \"eventId\":\" " + eventId +
                "\",\n" +
                "        \"pageIndex\": 1,\n" +
                "        \"pageSize\": 20,\n" +
                "        \"partnerCode\": \"YJP-ERP\"\n" +
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
