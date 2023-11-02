package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shangshaoyang
 * @email shangshaoyang@yijiupi.com
 * @description 货主分配结果DTO
 * @date 2021/8/18
 */
public class OwnerAllocateDTO implements Serializable {

    private static final long serialVersionUID = 1561837599668925798L;

    private Long id;
    private Long inventoryId;
    private Long omsOrderId;
    private Long omsOrderItemId;
    private Long productOwnerId;
    private Long addSecProductOwnerId;
    private BigDecimal addCount;
    private Long dispatchSecProductOwnerId;
    private BigDecimal dispatchCount;
    private Long stockinSecProductOwnerId;
    private BigDecimal stockinCount;
    private Long dispatchState;
    private Long wmsItemDetailId;
    private BigDecimal unitCostPrice;

    private String outAddSecProductOwnerId;

    private String outDisPatchSecProductOwnerId;

    private String outStockinSecProductOwnerId;
    /**
     * 仓库Id
     */
    private Integer warehouseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
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

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
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

    public Long getDispatchState() {
        return dispatchState;
    }

    public void setDispatchState(Long dispatchState) {
        this.dispatchState = dispatchState;
    }

    public Long getWmsItemDetailId() {
        return wmsItemDetailId;
    }

    public void setWmsItemDetailId(Long wmsItemDetailId) {
        this.wmsItemDetailId = wmsItemDetailId;
    }

    public BigDecimal getUnitCostPrice() {
        return unitCostPrice;
    }

    public void setUnitCostPrice(BigDecimal unitCostPrice) {
        this.unitCostPrice = unitCostPrice;
    }

    public String getOutAddSecProductOwnerId() {
        return outAddSecProductOwnerId;
    }

    public void setOutAddSecProductOwnerId(String outAddSecProductOwnerId) {
        this.outAddSecProductOwnerId = outAddSecProductOwnerId;
    }

    public String getOutDisPatchSecProductOwnerId() {
        return outDisPatchSecProductOwnerId;
    }

    public void setOutDisPatchSecProductOwnerId(String outDisPatchSecProductOwnerId) {
        this.outDisPatchSecProductOwnerId = outDisPatchSecProductOwnerId;
    }

    public String getOutStockinSecProductOwnerId() {
        return outStockinSecProductOwnerId;
    }

    public void setOutStockinSecProductOwnerId(String outStockinSecProductOwnerId) {
        this.outStockinSecProductOwnerId = outStockinSecProductOwnerId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "OwnerAllocateDTO{" +
                "id=" + id +
                ", inventoryId=" + inventoryId +
                ", omsOrderId=" + omsOrderId +
                ", omsOrderItemId=" + omsOrderItemId +
                ", productOwnerId=" + productOwnerId +
                ", addSecProductOwnerId=" + addSecProductOwnerId +
                ", addCount=" + addCount +
                ", dispatchSecProductOwnerId=" + dispatchSecProductOwnerId +
                ", dispatchCount=" + dispatchCount +
                ", stockinSecProductOwnerId=" + stockinSecProductOwnerId +
                ", stockinCount=" + stockinCount +
                ", dispatchState=" + dispatchState +
                ", wmsItemDetailId=" + wmsItemDetailId +
                ", unitCostPrice=" + unitCostPrice +
                '}';
    }
}
