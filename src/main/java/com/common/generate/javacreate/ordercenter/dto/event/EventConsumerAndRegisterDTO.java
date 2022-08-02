package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.List;

/**
 * @author xialei
 * @date 2022/6/30 9:28
 */
public class EventConsumerAndRegisterDTO {

    /**
     * 消费者id
     */
    private String consumerId;

    private List<String> eventRegisterIdList;


    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public List<String> getEventRegisterIdList() {
        return eventRegisterIdList;
    }

    public void setEventRegisterIdList(List<String> eventRegisterIdList) {
        this.eventRegisterIdList = eventRegisterIdList;
    }
}
