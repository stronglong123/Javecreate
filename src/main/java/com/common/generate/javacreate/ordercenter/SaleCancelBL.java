package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.PushSaleOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xialei
 * @date 2023/7/5 9:59
 */
public class SaleCancelBL {


    public static void main(String[] args) {

        for (int i = 1; i <= 28; i++) {
            String param = "[\n" +
                    "    {\n" +
                    "        \"createTimeEnd\": \"1687752912000\",\n" +
                    "        \"createTimeStart\": \"1687745712000\",\n" +
                    "        \"eventCode\": \"SaleOrderCancel\",\n" +
                    "        \"pageIndex\": " + i + ",\n" +
                    "        \"pageSize\": 100\n" +
                    "    }\n" +
                    "]";
            List<EventPublishAuditDocumentDTO> publishAuditDocumentList = NewApiTest.eventConsumptionAuditQuery("pre", param);
            List<Long> orderIds = new ArrayList<>();
            for (EventPublishAuditDocumentDTO eventPublishAuditDocumentDTO : publishAuditDocumentList) {
                String body = eventPublishAuditDocumentDTO.getBody();
                if (body.contains("预售转正常超过90天")) {
                    PushSaleOrderDTO pushSaleOrderDTO = JSON.parseObject(body, PushSaleOrderDTO.class);
                    Long orderId = pushSaleOrderDTO.getSaleOrder().getOrderBaseDTO().getOrderId();
                    if(!checkState(orderId)){
                        orderIds.add(orderId);
                    }
                }
            }
            System.out.println(orderIds);
        }
    }


    private static boolean checkState(Long orderId) {
        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderId\":" + orderId + ",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
        if (CollectionUtils.isEmpty(orderList)) {
            System.out.println(orderId + ",订单id不存在");
            return false;
        }
        if(orderList.size()>1){
            System.out.println(orderId + ",订单id不存在");
            return false;
        }
        OrderDocumentDTO orderDocumentDTO = orderList.get(0);
        Integer state = orderDocumentDTO.getOrderBase().getState();
        if(!state.equals(300)){
            System.out.println(String.format("orderId=%s,stat=%s",orderId,state));
            return false;
        }
        return true;
    }

}
