package com.common.generate.javacreate.ordercenter;

import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventConsumptionAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xialei
 * @date 2022/9/15 9:55
 */

@Service
public class EventRetryBL {


    public static void main(String[] args) {
        String code = "pre";
        List<EventPublishAuditDocumentDTO> eventPublishAudits = eventPublishAuditQuery(code);
        for (EventPublishAuditDocumentDTO eventPublishAudit : eventPublishAudits) {
            List<EventConsumptionAuditDocumentDTO> consumptionAudits = eventConsumptionAuditQuery(code, eventPublishAudit.getEventId());
            if(CollectionUtils.isEmpty(consumptionAudits)){
                publishEventRetry(code,eventPublishAudit.getBody(),eventPublishAudit.getEventId());
            }else {
                System.out.println("已处理:"+eventPublishAudit.getEventId());
            }
        }
    }


    public static List<EventPublishAuditDocumentDTO> eventPublishAuditQuery(String code) {
        List<EventPublishAuditDocumentDTO> eventPublishAuditDocumentDTOS = ApiUtil.eventPublishAuditQuery(code, "[{\"eventCode\":\"SaleOrderSplitAdd\",\"pageIndex\":1,\"pageSize\":250}]");
        return eventPublishAuditDocumentDTOS;
    }

    public static List<EventConsumptionAuditDocumentDTO> eventConsumptionAuditQuery(String code, String eventId) {
        String params = String.format("[{\"eventId\":\"%s\",\"pageIndex\":1,\"pageSize\":20}]", eventId);
        List<EventConsumptionAuditDocumentDTO> eventConsumptionAuditDocumentDTOS = ApiUtil.eventConsumptionAuditQuery(code, params);
        return eventConsumptionAuditDocumentDTOS;
    }


    public static void publishEventRetry(String code, String body, String eventId) {
        ApiUtil.publishEventRetry(code,body,eventId);
    }
}
