package com.common.generate.javacreate.test.dto;

import org.springframework.scheduling.support.SimpleTriggerContext;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/5/13 14:29
 */
public class ErpResultDTO implements Serializable {

    private Integer warehouseId;

    private String warehouseName;

    private String skuName;

    private Long skuId;

    private BigDecimal secCount;

    private String trueWmsSecOwnerId;

    private String trueErpSecOwnerId;

    private String falseWmsSecOwnerId;

    private String falseErpSecOwnerId;

    private String trueSecOwnerName;
    private String falseSecOwnerName;


    private String wmsNo;

    private String erpNo;

    public String getTrueSecOwnerName() {
        return trueSecOwnerName;
    }

    public void setTrueSecOwnerName(String trueSecOwnerName) {
        this.trueSecOwnerName = trueSecOwnerName;
    }

    public String getFalseSecOwnerName() {
        return falseSecOwnerName;
    }

    public void setFalseSecOwnerName(String falseSecOwnerName) {
        this.falseSecOwnerName = falseSecOwnerName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWmsNo() {
        return wmsNo;
    }

    public void setWmsNo(String wmsNo) {
        this.wmsNo = wmsNo;
    }

    public String getErpNo() {
        return erpNo;
    }

    public void setErpNo(String erpNo) {
        this.erpNo = erpNo;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getSecCount() {
        return secCount;
    }

    public void setSecCount(BigDecimal secCount) {
        this.secCount = secCount;
    }

    public String getTrueWmsSecOwnerId() {
        return trueWmsSecOwnerId;
    }

    public void setTrueWmsSecOwnerId(String trueWmsSecOwnerId) {
        this.trueWmsSecOwnerId = trueWmsSecOwnerId;
    }

    public String getTrueErpSecOwnerId() {
        return trueErpSecOwnerId;
    }

    public void setTrueErpSecOwnerId(String trueErpSecOwnerId) {
        this.trueErpSecOwnerId = trueErpSecOwnerId;
    }

    public String getFalseWmsSecOwnerId() {
        return falseWmsSecOwnerId;
    }

    public void setFalseWmsSecOwnerId(String falseWmsSecOwnerId) {
        this.falseWmsSecOwnerId = falseWmsSecOwnerId;
    }

    public String getFalseErpSecOwnerId() {
        return falseErpSecOwnerId;
    }

    public void setFalseErpSecOwnerId(String falseErpSecOwnerId) {
        this.falseErpSecOwnerId = falseErpSecOwnerId;
    }
}
