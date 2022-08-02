package com.common.generate.javacreate.ordercenter.dto.event;

/**
 * @author xialei
 * @date 2022/7/22 10:23
 */
public class EventSimple {


    private String partnerCode;

    private String eventCode;

    private String eventName;

    private Integer evnetType;

    private String evnetTypeName;

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

    public String getEvnetTypeName() {
        return evnetTypeName;
    }

    public void setEvnetTypeName(String evnetTypeName) {
        this.evnetTypeName = evnetTypeName;
    }
}
