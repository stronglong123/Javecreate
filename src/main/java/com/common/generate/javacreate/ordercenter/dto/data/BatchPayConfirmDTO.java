package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.ordercenter.ReturnOrderPayConfirm;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderPayConfirm;

import java.io.Serializable;
import java.util.List;

public class BatchPayConfirmDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    List<ReturnOrderPayConfirm> returnOrderPayConfirms;

    List<SaleOrderPayConfirm> saleOrderPayConfirms;
    //(description = "批次Id", required = true)
    private Long taskId;
    //(description = "操作人Id", required = true)
    private Long optUserId;
    //(description = "操作人")
    private String optUserName;
    //(description = "描述")
    private String desc;

    public List<ReturnOrderPayConfirm> getReturnOrderPayConfirms() {
        return returnOrderPayConfirms;
    }

    public void setReturnOrderPayConfirms(List<ReturnOrderPayConfirm> returnOrderPayConfirms) {
        this.returnOrderPayConfirms = returnOrderPayConfirms;
    }

    public List<SaleOrderPayConfirm> getSaleOrderPayConfirms() {
        return saleOrderPayConfirms;
    }

    public void setSaleOrderPayConfirms(List<SaleOrderPayConfirm> saleOrderPayConfirms) {
        this.saleOrderPayConfirms = saleOrderPayConfirms;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(Long optUserId) {
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
}
