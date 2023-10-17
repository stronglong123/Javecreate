package com.common.generate.javacreate.ordercenter.dto;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2022/9/1 12:01
 */
public class ElkDTO {


    private ElkSourceDTO _source;

    private String orderNo;

    private Long orderId;

    private Long itemId;

    private Long saleItemId;

    private Long businessItemId;

    private Integer isFix;

    private Long id;

    private Integer trueWarehouseId;

    private Long secOwnerId;

    private BigDecimal count;

    private BigDecimal workingItemCount;
    private BigDecimal  originalCount;

    private BigDecimal outStockCount;

    private BigDecimal specQuantity;

    private Long fromCityId;

    private Long fromWarehouseId;
    private Long orgId;
    private Long warehouseId;


    private Long orderItemId;

    private BigDecimal deliveryCount;

    private Long secId;

    private Integer state;

    private Long awardProduct_Id;

    private Long userId;

    private Integer featureType;

    public Integer getFeatureType() {
        return featureType;
    }

    public void setFeatureType(Integer featureType) {
        this.featureType = featureType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAwardProduct_Id() {
        return awardProduct_Id;
    }

    public void setAwardProduct_Id(Long awardProduct_Id) {
        this.awardProduct_Id = awardProduct_Id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getSecId() {
        return secId;
    }

    public void setSecId(Long secId) {
        this.secId = secId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public BigDecimal getDeliveryCount() {
        return deliveryCount;
    }

    public void setDeliveryCount(BigDecimal deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    public BigDecimal getOriginalCount() {
        return originalCount;
    }

    public void setOriginalCount(BigDecimal originalCount) {
        this.originalCount = originalCount;
    }

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    public BigDecimal getOutStockCount() {
        return outStockCount;
    }

    public void setOutStockCount(BigDecimal outStockCount) {
        this.outStockCount = outStockCount;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrueWarehouseId() {
        return trueWarehouseId;
    }

    public void setTrueWarehouseId(Integer trueWarehouseId) {
        this.trueWarehouseId = trueWarehouseId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(Long saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Long getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(Long businessItemId) {
        this.businessItemId = businessItemId;
    }

    public ElkSourceDTO get_source() {
        return _source;
    }

    public void set_source(ElkSourceDTO _source) {
        this._source = _source;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getIsFix() {
        return isFix;
    }

    public void setIsFix(Integer isFix) {
        this.isFix = isFix;
    }

    public BigDecimal getWorkingItemCount() {
        return workingItemCount;
    }

    public void setWorkingItemCount(BigDecimal workingItemCount) {
        this.workingItemCount = workingItemCount;
    }

    public Long getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(Long fromCityId) {
        this.fromCityId = fromCityId;
    }

    public Long getFromWarehouseId() {
        return fromWarehouseId;
    }

    public void setFromWarehouseId(Long fromWarehouseId) {
        this.fromWarehouseId = fromWarehouseId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
