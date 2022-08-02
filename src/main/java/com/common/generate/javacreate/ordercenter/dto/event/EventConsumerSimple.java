package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.List;

/**
 * @author xialei
 * @date 2022/7/22 11:52
 */
public class EventConsumerSimple {


    /**
     * 接入方应用
     */
    private String partnerCode;

    /**
     * 消费者名字
     */
    private String consumerName;


    /**
     * 订阅的事件编码
     */
    private String subscribedEventCodes;


    private List<String> hasBindEvent;

    private List<String> noBindEvent;

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

    public String getSubscribedEventCodes() {
        return subscribedEventCodes;
    }

    public void setSubscribedEventCodes(String subscribedEventCodes) {
        this.subscribedEventCodes = subscribedEventCodes;
    }

    public List<String> getHasBindEvent() {
        return hasBindEvent;
    }

    public void setHasBindEvent(List<String> hasBindEvent) {
        this.hasBindEvent = hasBindEvent;
    }

    public List<String> getNoBindEvent() {
        return noBindEvent;
    }

    public void setNoBindEvent(List<String> noBindEvent) {
        this.noBindEvent = noBindEvent;
    }
}
