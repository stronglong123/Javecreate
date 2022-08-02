package com.common.generate.javacreate.ordercenter.dto.event;

/**
 * @author xialei
 * @date 2022/7/21 15:39
 */
public class EventAndSubExcelDTO {

    private String eventId;

    private String partnerCode;

    private String eventCode;

    private String eventName;

    private Integer evnetType;

    private String evnetTypeName;

    private String bindOutEvent;

    private String bindOutEventType;


    private String bindOutPartnerCode;

    private String bindOutEventCode;
    /**
     * 公司code
     */
    private String subscribeCompanyCode;
    /**
     * 接入方应用
     */
    private String subscribePartnerCode;
    /**
     * 订阅的名字
     */
    private String subscribeName;

    /**
     * 事件消费类型
     */
    private String subscribeEventConsumptionType;


    /**
     * 消费者公司code
     */
    private String consumerId;
    /**
     * 消费者公司code
     */
    private String consumerCompanyCode;

    /**
     * 消费者应用code
     */
    private String consumerPartnerCode;

    /**
     * 消费者名字
     */
    private String consumerName;

    /**
     * 消费者绑定事件code
     */
    private String consumerSubscribedEventCodes;


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

    public String getSubscribeCompanyCode() {
        return subscribeCompanyCode;
    }

    public void setSubscribeCompanyCode(String subscribeCompanyCode) {
        this.subscribeCompanyCode = subscribeCompanyCode;
    }

    public String getSubscribePartnerCode() {
        return subscribePartnerCode;
    }

    public void setSubscribePartnerCode(String subscribePartnerCode) {
        this.subscribePartnerCode = subscribePartnerCode;
    }

    public String getSubscribeName() {
        return subscribeName;
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName;
    }

    public String getSubscribeEventConsumptionType() {
        return subscribeEventConsumptionType;
    }

    public void setSubscribeEventConsumptionType(String subscribeEventConsumptionType) {
        this.subscribeEventConsumptionType = subscribeEventConsumptionType;
    }


    public String getEvnetTypeName() {
        return evnetTypeName;
    }

    public void setEvnetTypeName(String evnetTypeName) {
        this.evnetTypeName = evnetTypeName;
    }

    public String getConsumerCompanyCode() {
        return consumerCompanyCode;
    }

    public void setConsumerCompanyCode(String consumerCompanyCode) {
        this.consumerCompanyCode = consumerCompanyCode;
    }

    public String getConsumerPartnerCode() {
        return consumerPartnerCode;
    }

    public void setConsumerPartnerCode(String consumerPartnerCode) {
        this.consumerPartnerCode = consumerPartnerCode;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerSubscribedEventCodes() {
        return consumerSubscribedEventCodes;
    }

    public void setConsumerSubscribedEventCodes(String consumerSubscribedEventCodes) {
        this.consumerSubscribedEventCodes = consumerSubscribedEventCodes;
    }

    public String getBindOutEvent() {
        return bindOutEvent;
    }

    public void setBindOutEvent(String bindOutEvent) {
        this.bindOutEvent = bindOutEvent;
    }

    public String getBindOutPartnerCode() {
        return bindOutPartnerCode;
    }

    public void setBindOutPartnerCode(String bindOutPartnerCode) {
        this.bindOutPartnerCode = bindOutPartnerCode;
    }

    public String getBindOutEventCode() {
        return bindOutEventCode;
    }

    public void setBindOutEventCode(String bindOutEventCode) {
        this.bindOutEventCode = bindOutEventCode;
    }

    public String getBindOutEventType() {
        return bindOutEventType;
    }

    public void setBindOutEventType(String bindOutEventType) {
        this.bindOutEventType = bindOutEventType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }
}
