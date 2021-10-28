package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/2/8 9:15
 */
public class InApplyErrorResult implements Serializable {

    private String productName;

    private Long inApplyItemId;

    private Long inApplyOwnerId;

    private Long inApplySecOwnerId;

    private BigDecimal inApplyUnitTotalCount;

    private BigDecimal inApplyUnitCount;

    private BigDecimal inApplyPackageCount;

    private BigDecimal applyHasInUnitTotalCount;

    private BigDecimal applyHasInUnitCount;

    private BigDecimal applyHasInPackageCount;

    private BigDecimal notInUnitCount;

    private BigDecimal notInPackageCount;

    private String businessItemId;

    /**
     * 产品规格ID
     */
    private Long productSpecificationId;

    private BigDecimal tranferItemInUnitTotalCount;

    private BigDecimal tranferItemInUnitCount;

    private BigDecimal tranferItemInPackageCount;

    /**
     * @Fields specQuantity 规格转换系数
     */
    private BigDecimal specQuantity;

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getInApplyItemId() {
        return inApplyItemId;
    }

    public void setInApplyItemId(Long inApplyItemId) {
        this.inApplyItemId = inApplyItemId;
    }

    public Long getInApplyOwnerId() {
        return inApplyOwnerId;
    }

    public void setInApplyOwnerId(Long inApplyOwnerId) {
        this.inApplyOwnerId = inApplyOwnerId;
    }

    public Long getInApplySecOwnerId() {
        return inApplySecOwnerId;
    }

    public void setInApplySecOwnerId(Long inApplySecOwnerId) {
        this.inApplySecOwnerId = inApplySecOwnerId;
    }

    public BigDecimal getInApplyUnitTotalCount() {
        return inApplyUnitTotalCount;
    }

    public void setInApplyUnitTotalCount(BigDecimal inApplyUnitTotalCount) {
        this.inApplyUnitTotalCount = inApplyUnitTotalCount;
    }

    public BigDecimal getApplyHasInUnitTotalCount() {
        return applyHasInUnitTotalCount;
    }

    public void setApplyHasInUnitTotalCount(BigDecimal applyHasInUnitTotalCount) {
        this.applyHasInUnitTotalCount = applyHasInUnitTotalCount;
    }

    public BigDecimal getApplyHasInUnitCount() {
        return applyHasInUnitCount;
    }

    public void setApplyHasInUnitCount(BigDecimal applyHasInUnitCount) {
        this.applyHasInUnitCount = applyHasInUnitCount;
    }

    public BigDecimal getApplyHasInPackageCount() {
        return applyHasInPackageCount;
    }

    public void setApplyHasInPackageCount(BigDecimal applyHasInPackageCount) {
        this.applyHasInPackageCount = applyHasInPackageCount;
    }

    public BigDecimal getNotInUnitCount() {
        return notInUnitCount;
    }

    public void setNotInUnitCount(BigDecimal notInUnitCount) {
        this.notInUnitCount = notInUnitCount;
    }

    public BigDecimal getNotInPackageCount() {
        return notInPackageCount;
    }

    public void setNotInPackageCount(BigDecimal notInPackageCount) {
        this.notInPackageCount = notInPackageCount;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public BigDecimal getTranferItemInUnitTotalCount() {
        return tranferItemInUnitTotalCount;
    }

    public void setTranferItemInUnitTotalCount(BigDecimal tranferItemInUnitTotalCount) {
        this.tranferItemInUnitTotalCount = tranferItemInUnitTotalCount;
    }

    public BigDecimal getTranferItemInUnitCount() {
        return tranferItemInUnitCount;
    }

    public void setTranferItemInUnitCount(BigDecimal tranferItemInUnitCount) {
        this.tranferItemInUnitCount = tranferItemInUnitCount;
    }

    public BigDecimal getTranferItemInPackageCount() {
        return tranferItemInPackageCount;
    }

    public void setTranferItemInPackageCount(BigDecimal tranferItemInPackageCount) {
        this.tranferItemInPackageCount = tranferItemInPackageCount;
    }

    public BigDecimal getInApplyUnitCount() {
        return inApplyUnitCount;
    }

    public void setInApplyUnitCount(BigDecimal inApplyUnitCount) {
        this.inApplyUnitCount = inApplyUnitCount;
    }

    public BigDecimal getInApplyPackageCount() {
        return inApplyPackageCount;
    }

    public void setInApplyPackageCount(BigDecimal inApplyPackageCount) {
        this.inApplyPackageCount = inApplyPackageCount;
    }
}
