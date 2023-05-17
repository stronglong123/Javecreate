package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.util.List;

public class BatchPayConfirmDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    List<SaleOrderPayConfirm> saleOrderPayConfirms;
    private String taskId;
    private String optUserId;
    private String optUserName;
    private String desc;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(String optUserId) {
        this.optUserId = optUserId;
    }

    public String getOptUserName() {
        return optUserName;
    }

    public void setOptUserName(String optUserName) {
        this.optUserName = optUserName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<SaleOrderPayConfirm> getSaleOrderPayConfirms() {
        return saleOrderPayConfirms;
    }

    public void setSaleOrderPayConfirms(List<SaleOrderPayConfirm> saleOrderPayConfirms) {
        this.saleOrderPayConfirms = saleOrderPayConfirms;
    }

}
