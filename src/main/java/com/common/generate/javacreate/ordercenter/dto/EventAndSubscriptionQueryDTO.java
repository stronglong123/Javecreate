package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2022/8/29 15:47
 */
public class EventAndSubscriptionQueryDTO {

    private static final long serialVersionUID = 8558505176219772870L;
    /**
     * 事件code
     */
    private String eventCode;
    /**
     * 事件名字
     */
    private String eventName;

    /**
     * 事件模板类型
     */
    private Integer eventType;


    private String partnerCode;

    private Integer pageSize;

    private Integer pageNum;


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

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
