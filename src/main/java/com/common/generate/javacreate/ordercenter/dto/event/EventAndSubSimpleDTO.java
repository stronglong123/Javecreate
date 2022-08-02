package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.List;

/**
 * @author xialei
 * @date 2022/7/21 15:39
 */
public class EventAndSubSimpleDTO {

    private String eventId;

    private String partnerCode;


    private String eventCode;

    private String eventName;

    private Integer evnetType;

    private List<SubSimple> subscriptionList;

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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEvnetType() {
        return evnetType;
    }

    public void setEvnetType(Integer evnetType) {
        this.evnetType = evnetType;
    }

    public List<SubSimple> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<SubSimple> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
