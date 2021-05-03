package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/4/29 23:37
 */
public class SettleOrderItemOwnerDTO implements Serializable {

    private static final long serialVersionUID = -8845788558360053829L;
    private Long id;
    private Long omsOrderId;
    private Long omsOrderItemId;
    private Long subOmsOrderId;
    private Long subOmsOrderItemId;
    private Long addSecProductOwnerId;
    private BigDecimal addCount;
    private Long dispatchSecProductOwnerId;
    private BigDecimal dispatchCount;
    private Long stockinSecProductOwnerId;
    private BigDecimal stockinCount;
    private Byte dispatchState;

    private Long oldSecOwerId;

    public Long getOldSecOwerId() {
        return oldSecOwerId;
    }

    public void setOldSecOwerId(Long oldSecOwerId) {
        this.oldSecOwerId = oldSecOwerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOmsOrderId() {
        return omsOrderId;
    }

    public void setOmsOrderId(Long omsOrderId) {
        this.omsOrderId = omsOrderId;
    }

    public Long getOmsOrderItemId() {
        return omsOrderItemId;
    }

    public void setOmsOrderItemId(Long omsOrderItemId) {
        this.omsOrderItemId = omsOrderItemId;
    }

    public Long getSubOmsOrderId() {
        return subOmsOrderId;
    }

    public void setSubOmsOrderId(Long subOmsOrderId) {
        this.subOmsOrderId = subOmsOrderId;
    }

    public Long getSubOmsOrderItemId() {
        return subOmsOrderItemId;
    }

    public void setSubOmsOrderItemId(Long subOmsOrderItemId) {
        this.subOmsOrderItemId = subOmsOrderItemId;
    }

    public Long getAddSecProductOwnerId() {
        return addSecProductOwnerId;
    }

    public void setAddSecProductOwnerId(Long addSecProductOwnerId) {
        this.addSecProductOwnerId = addSecProductOwnerId;
    }

    public BigDecimal getAddCount() {
        return addCount;
    }

    public void setAddCount(BigDecimal addCount) {
        this.addCount = addCount;
    }

    public Long getDispatchSecProductOwnerId() {
        return dispatchSecProductOwnerId;
    }

    public void setDispatchSecProductOwnerId(Long dispatchSecProductOwnerId) {
        this.dispatchSecProductOwnerId = dispatchSecProductOwnerId;
    }

    public BigDecimal getDispatchCount() {
        return dispatchCount;
    }

    public void setDispatchCount(BigDecimal dispatchCount) {
        this.dispatchCount = dispatchCount;
    }

    public Long getStockinSecProductOwnerId() {
        return stockinSecProductOwnerId;
    }

    public void setStockinSecProductOwnerId(Long stockinSecProductOwnerId) {
        this.stockinSecProductOwnerId = stockinSecProductOwnerId;
    }

    public BigDecimal getStockinCount() {
        return stockinCount;
    }

    public void setStockinCount(BigDecimal stockinCount) {
        this.stockinCount = stockinCount;
    }

    public Byte getDispatchState() {
        return dispatchState;
    }

    public void setDispatchState(Byte dispatchState) {
        this.dispatchState = dispatchState;
    }
}
