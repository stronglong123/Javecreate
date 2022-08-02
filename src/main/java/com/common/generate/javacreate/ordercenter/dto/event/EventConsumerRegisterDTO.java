package com.common.generate.javacreate.ordercenter.dto.event;

import java.io.Serializable;

/**
 * 事件消费者的订阅信息
 */
public class EventConsumerRegisterDTO implements Serializable {
    private String eventRegisterId;

    /**
     * 事件模板类型
     */
    private Integer eventRegisterType;

    /**
     * 接入方应用(不可修改)
     */
    private String partnerCode;


    /**
     * 事件Code（不可修改）
     */
    private String eventCode;

    /**
     * 事件名字
     */
    private String eventName;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 备注
     */
    private String remark;

    /**
     * 关联的事件订阅场景Id
     */
    private String eventSubscriptionId;

    public String getEventRegisterId() {
        return eventRegisterId;
    }

    public void setEventRegisterId(String eventRegisterId) {
        this.eventRegisterId = eventRegisterId;
    }

    public Integer getEventRegisterType() {
        return eventRegisterType;
    }

    public void setEventRegisterType(Integer eventRegisterType) {
        this.eventRegisterType = eventRegisterType;
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEventSubscriptionId() {
        return eventSubscriptionId;
    }

    public void setEventSubscriptionId(String eventSubscriptionId) {
        this.eventSubscriptionId = eventSubscriptionId;
    }
}
