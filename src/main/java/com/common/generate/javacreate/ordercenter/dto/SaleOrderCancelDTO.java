package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.util.Date;

public class SaleOrderCancelDTO implements Serializable {

    private static final long serialVersionUID = -4776752237670559743L;

    //(description = "订单id", required = true)
    //(message = "订单id不能为空")
    private Long orderId;

    //(description = "取消时间", required = true)
    //(message = "取消时间不能为空")
    private Date cancelTime;

    //(description = "取消类型:0为运营取消,1为赠品不足取消,2为支付超时自动取消")
    private int cancelType;

    //(description = "取消原因")
    private String reason;

    //(description = "操作人Id", required = true)
    //@NotEmpty(message = "操作人Id不能为空")
    private String optUserId;

    //(description = "操作人")
    private String optUserName;

    //(description = "礼品名字")
    private String giftName;

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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


    public int getCancelType() {
        return cancelType;
    }

    public void setCancelType(int cancelType) {
        this.cancelType = cancelType;
    }
}
