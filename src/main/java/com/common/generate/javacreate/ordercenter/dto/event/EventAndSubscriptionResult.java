package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.List;

/**
 * @author xialei
 * @date 2022/7/21 15:11
 */
public class EventAndSubscriptionResult {

    private String partnerCode;

    private String eventName;

    private String eventCode;

    private Integer evnetType;

    private EventRegisterDTO event;

    private List<EventSubscriptionDTO> subscriptionList;

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public EventRegisterDTO getEvent() {
        return event;
    }

    public void setEvent(EventRegisterDTO event) {
        this.event = event;
    }

    public List<EventSubscriptionDTO> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<EventSubscriptionDTO> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public Integer getEvnetType() {
        return evnetType;
    }

    public void setEvnetType(Integer evnetType) {
        this.evnetType = evnetType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
