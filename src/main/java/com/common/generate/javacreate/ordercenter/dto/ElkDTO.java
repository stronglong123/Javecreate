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
}
