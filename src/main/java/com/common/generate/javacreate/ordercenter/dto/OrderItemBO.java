package com.common.generate.javacreate.ordercenter.dto;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2022/10/14 13:37
 */
public class OrderItemBO {

    private Long orderId;

    private Long orderItemId;

    private BigDecimal count;

    private BigDecimal workingItemCount;

    private BigDecimal outStockCount;

    private BigDecimal inStockCount;

    private BigDecimal wmsOutCount;

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

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getWorkingItemCount() {
        return workingItemCount;
    }

    public void setWorkingItemCount(BigDecimal workingItemCount) {
        this.workingItemCount = workingItemCount;
    }

    public BigDecimal getOutStockCount() {
        return outStockCount;
    }

    public void setOutStockCount(BigDecimal outStockCount) {
        this.outStockCount = outStockCount;
    }

    public BigDecimal getInStockCount() {
        return inStockCount;
    }

    public void setInStockCount(BigDecimal inStockCount) {
        this.inStockCount = inStockCount;
    }

    public BigDecimal getWmsOutCount() {
        return wmsOutCount;
    }

    public void setWmsOutCount(BigDecimal wmsOutCount) {
        this.wmsOutCount = wmsOutCount;
    }
}
