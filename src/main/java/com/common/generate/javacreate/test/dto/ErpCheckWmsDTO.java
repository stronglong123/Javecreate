package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/5/13 10:57
 */
public class ErpCheckWmsDTO implements Serializable {
    private static final long serialVersionUID = 6018134618082114780L;

    private Integer warehouseId;

    private String warehouseName;

    private String businessNo;

    private String businessDate;

    private String type;

    private String orderType;

    private String secOwnerName;

    private String wmsSecOwnerId;

    private String erpSecOwnerId;


    private Long skuId;

    private String productName;

    private BigDecimal secCount;

    private String state;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSecOwnerName() {
        return secOwnerName;
    }

    public void setSecOwnerName(String secOwnerName) {
        this.secOwnerName = secOwnerName;
    }

    public String getWmsSecOwnerId() {
        return wmsSecOwnerId;
    }

    public void setWmsSecOwnerId(String wmsSecOwnerId) {
        this.wmsSecOwnerId = wmsSecOwnerId;
    }

    public String getErpSecOwnerId() {
        return erpSecOwnerId;
    }

    public void setErpSecOwnerId(String erpSecOwnerId) {
        this.erpSecOwnerId = erpSecOwnerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getSecCount() {
        return secCount;
    }

    public void setSecCount(BigDecimal secCount) {
        this.secCount = secCount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}
