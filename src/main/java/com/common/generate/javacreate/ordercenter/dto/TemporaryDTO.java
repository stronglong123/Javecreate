package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2023/4/14 9:31
 */
public class TemporaryDTO implements Serializable {

    private Long id;

    private Long orderId;

    private Long orderItemId;

    private Long secOwnerId;

    private BigDecimal count;

    private Long omsItemId;

    private Long realSecOwnerId;

    private BigDecimal realItemCount;

    private BigDecimal realSecCount;

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

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public Long getOmsItemId() {
        return omsItemId;
    }

    public void setOmsItemId(Long omsItemId) {
        this.omsItemId = omsItemId;
    }

    public Long getRealSecOwnerId() {
        return realSecOwnerId;
    }

    public void setRealSecOwnerId(Long realSecOwnerId) {
        this.realSecOwnerId = realSecOwnerId;
    }

    public BigDecimal getRealItemCount() {
        return realItemCount;
    }

    public void setRealItemCount(BigDecimal realItemCount) {
        this.realItemCount = realItemCount;
    }

    public BigDecimal getRealSecCount() {
        return realSecCount;
    }

    public void setRealSecCount(BigDecimal realSecCount) {
        this.realSecCount = realSecCount;
    }
}
