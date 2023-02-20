package com.common.generate.javacreate.ordercenter.dto;

import java.util.Date;

/**
 * @author xialei
 * @date 2023/1/4 17:37
 */
public class DeadLetterRecoverDTO {

    private String id;
    private String consumerQueue;
    private String messageBody;
    private String causeException;
    private Date deadTime;
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsumerQueue() {
        return consumerQueue;
    }

    public void setConsumerQueue(String consumerQueue) {
        this.consumerQueue = consumerQueue;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getCauseException() {
        return causeException;
    }

    public void setCauseException(String causeException) {
        this.causeException = causeException;
    }

    public Date getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(Date deadTime) {
        this.deadTime = deadTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
