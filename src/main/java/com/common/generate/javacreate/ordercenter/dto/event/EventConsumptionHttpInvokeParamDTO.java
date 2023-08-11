package com.common.generate.javacreate.ordercenter.dto.event;


import java.io.Serializable;

/**
 * 事件消费参数DTO
 */
public class EventConsumptionHttpInvokeParamDTO implements Serializable {

    /**
     * 事件订阅
     */
    private EventSubscriptionDTO eventSubscriptionDTO;

    /**
     * 事件应用
     */
    private EventContextDTO eventContextDTO;

    private Boolean retry;

    private String eventConsumptionAuditId;


    public Boolean getRetry() {
        return retry;
    }

    public void setRetry(Boolean retry) {
        this.retry = retry;
    }

    public EventSubscriptionDTO getEventSubscriptionDTO() {
        return eventSubscriptionDTO;
    }

    public void setEventSubscriptionDTO(EventSubscriptionDTO eventSubscriptionDTO) {
        this.eventSubscriptionDTO = eventSubscriptionDTO;
    }

    public EventContextDTO getEventContextDTO() {
        return eventContextDTO;
    }

    public void setEventContextDTO(EventContextDTO eventContextDTO) {
        this.eventContextDTO = eventContextDTO;
    }

    public String getEventConsumptionAuditId() {
        return eventConsumptionAuditId;
    }

    public void setEventConsumptionAuditId(String eventConsumptionAuditId) {
        this.eventConsumptionAuditId = eventConsumptionAuditId;
    }
}
