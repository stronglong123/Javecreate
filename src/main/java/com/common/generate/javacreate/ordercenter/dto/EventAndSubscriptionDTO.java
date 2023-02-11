package com.common.generate.javacreate.ordercenter.dto;

import com.common.generate.javacreate.ordercenter.dto.event.EventConsumptionHttpInvokeDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventRuleDTO;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2022/8/29 15:47
 */
public class EventAndSubscriptionDTO implements Serializable {

    private static final long serialVersionUID = 3982100092030263099L;
    /**
     * 接入方应用
     */
    private String partnerCode;


    private String eventPartnerCode;

    private String eventId;
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
    /**
     * 事件订阅id
     */
    private String subscribeId;

    /**
     * 事件消费类型不能为空
     */
    private Integer eventConsumptionType;

    /**
     * 延时发送时间，单位是毫秒,默认不延时
     */
    private Integer delayTime = 0;

    /**
     *事件消费对象
     */
    private EventConsumptionHttpInvokeDTO eventConsumptionHttpInvokeDTO;

    /**
     * 事件规则
     */
    private EventRuleDTO eventRuleDTO;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 订阅的名字
     */
    private String subscribeName;

    /**
     * 订阅的事件
     */
    private String subscribeEventCode;


    private String subscribePartnerCode;

    private String url;


    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public String getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(String subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Integer getEventConsumptionType() {
        return eventConsumptionType;
    }

    public void setEventConsumptionType(Integer eventConsumptionType) {
        this.eventConsumptionType = eventConsumptionType;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

    public EventConsumptionHttpInvokeDTO getEventConsumptionHttpInvokeDTO() {
        return eventConsumptionHttpInvokeDTO;
    }

    public void setEventConsumptionHttpInvokeDTO(EventConsumptionHttpInvokeDTO eventConsumptionHttpInvokeDTO) {
        this.eventConsumptionHttpInvokeDTO = eventConsumptionHttpInvokeDTO;
    }

    public EventRuleDTO getEventRuleDTO() {
        return eventRuleDTO;
    }

    public void setEventRuleDTO(EventRuleDTO eventRuleDTO) {
        this.eventRuleDTO = eventRuleDTO;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getSubscribeName() {
        return subscribeName;
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName;
    }

    public String getSubscribeEventCode() {
        return subscribeEventCode;
    }

    public void setSubscribeEventCode(String subscribeEventCode) {
        this.subscribeEventCode = subscribeEventCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEventPartnerCode() {
        return eventPartnerCode;
    }

    public void setEventPartnerCode(String eventPartnerCode) {
        this.eventPartnerCode = eventPartnerCode;
    }

    public String getSubscribePartnerCode() {
        return subscribePartnerCode;
    }

    public void setSubscribePartnerCode(String subscribePartnerCode) {
        this.subscribePartnerCode = subscribePartnerCode;
    }
}
