package com.common.generate.javacreate.ordercenter.dto;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2022/11/15 19:06
 */
public class OutstockOwnerDTO {

    private Long id;

    private Long orderId;

    private Long orderItemId;

    private BigDecimal addCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getAddCount() {
        return addCount;
    }

    public void setAddCount(BigDecimal addCount) {
        this.addCount = addCount;
    }
}
