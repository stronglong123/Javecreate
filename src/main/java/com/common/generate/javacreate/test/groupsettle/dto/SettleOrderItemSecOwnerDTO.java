package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/4/30 22:25
 */
public class SettleOrderItemSecOwnerDTO implements Serializable {

    private static final long serialVersionUID = 7352783705341496007L;

    private Long id;

    private Long productSkuId;
    private BigDecimal specQuantity;
    private Long productOwnerId;
    private String packageName;
    private String unitName;
    private Long omsOrdetItemId;
    private Long omsOrderId;
    private Long secOwnerId;
    private BigDecimal secCount;
    private String productName;

    /**
     * 下单时间
     */
    private String orderCreateTime;
    /**
     * 完成时间
     */
    private String orderCompleteTime;
    private String orderNo;
    private Byte orderType;

    private Integer warehouseId;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getOrderCompleteTime() {
        return orderCompleteTime;
    }

    public void setOrderCompleteTime(String orderCompleteTime) {
        this.orderCompleteTime = orderCompleteTime;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Long getOmsOrdetItemId() {
        return omsOrdetItemId;
    }

    public void setOmsOrdetItemId(Long omsOrdetItemId) {
        this.omsOrdetItemId = omsOrdetItemId;
    }

    public Long getOmsOrderId() {
        return omsOrderId;
    }

    public void setOmsOrderId(Long omsOrderId) {
        this.omsOrderId = omsOrderId;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public BigDecimal getSecCount() {
        return secCount;
    }

    public void setSecCount(BigDecimal secCount) {
        this.secCount = secCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
