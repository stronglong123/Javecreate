package com.common.generate.javacreate.ordercenter.dto.event;

/**
 * @author xialei
 * @date 2022/6/29 18:19
 */
public class EventDiffDTO {

    /**
     * 消费者id
     */
    private String consumerId;
    /**
     * 接入方应用
     */
    private String partnerCode;

    /**
     * 消费者名字
     */
    private String consumerName;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 订阅的事件编码
     */
    private String sourceSubscribedEventCodes;

    /**
     * 订阅的事件编码
     */
    private String targetSubscribedEventCodes;

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getSourceSubscribedEventCodes() {
        return sourceSubscribedEventCodes;
    }

    public void setSourceSubscribedEventCodes(String sourceSubscribedEventCodes) {
        this.sourceSubscribedEventCodes = sourceSubscribedEventCodes;
    }

    public String getTargetSubscribedEventCodes() {
        return targetSubscribedEventCodes;
    }

    public void setTargetSubscribedEventCodes(String targetSubscribedEventCodes) {
        this.targetSubscribedEventCodes = targetSubscribedEventCodes;
    }
}
