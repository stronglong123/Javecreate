package com.common.generate.javacreate.ordercenter.dto.event;

/**
 * @author xialei
 * @date 2022/7/25 10:37
 */
public class InEventAndConsumerBindDTO {

    private String eventId;

    private String partnerCode;

    private String eventCode;

    private String eventName;

    private String consumerId;

    private String consumerPartnerCode;


    private String consumerName;

    /**
     * 消费者绑定事件code
     */
    private String consumerSubscribedEventCodes;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

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

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
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
}
