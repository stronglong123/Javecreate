package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2023/9/12 14:39
 */
public class MqQueryDTO implements Serializable {


    private Integer pageIndex;

    private Integer pageSize;

    private String queueName;

    private Integer state;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
