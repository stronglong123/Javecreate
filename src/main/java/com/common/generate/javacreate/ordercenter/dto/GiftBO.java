package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2023/8/10 15:44
 */
public class GiftBO {


    private Long orderId;

    private String orderNo;

    private boolean ifGiftOrder;

    private Integer state;

    private Integer deliveryMode;

    private boolean isOutOfStock;

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        isOutOfStock = outOfStock;
    }

    public Integer getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Integer deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public boolean isIfGiftOrder() {
        return ifGiftOrder;
    }

    public void setIfGiftOrder(boolean ifGiftOrder) {
        this.ifGiftOrder = ifGiftOrder;
    }
}
