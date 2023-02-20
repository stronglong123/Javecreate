package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2022/12/16 13:43
 */
public class RepairBusinessItemIdDTO {

    private Long orderId;

    private Long orderItemId;

    private String businessItemId;

    private Long sourceOrderItemId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    public Long getSourceOrderItemId() {
        return sourceOrderItemId;
    }

    public void setSourceOrderItemId(Long sourceOrderItemId) {
        this.sourceOrderItemId = sourceOrderItemId;
    }
}
