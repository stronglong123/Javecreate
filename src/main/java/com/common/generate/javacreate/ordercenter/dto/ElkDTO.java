package com.common.generate.javacreate.ordercenter.dto;

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
