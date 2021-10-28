package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/2/8 8:55
 */
public class OutErrorResult implements Serializable {


    private String outNo;

    private Long outItemId;

    private Long outItemDetailId;

    private Long outOwnerId;

    private Long outSecOwnerId;

    private BigDecimal outUnitTotalCount;

    private String productName;

    /**
     * 产品规格ID
     */
    private Long productSpecificationId;

    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public String getOutNo() {
        return outNo;
    }

    public void setOutNo(String outNo) {
        this.outNo = outNo;
    }

    public Long getOutItemId() {
        return outItemId;
    }

    public void setOutItemId(Long outItemId) {
        this.outItemId = outItemId;
    }

    public Long getOutItemDetailId() {
        return outItemDetailId;
    }

    public void setOutItemDetailId(Long outItemDetailId) {
        this.outItemDetailId = outItemDetailId;
    }

    public Long getOutOwnerId() {
        return outOwnerId;
    }

    public void setOutOwnerId(Long outOwnerId) {
        this.outOwnerId = outOwnerId;
    }

    public Long getOutSecOwnerId() {
        return outSecOwnerId;
    }

    public void setOutSecOwnerId(Long outSecOwnerId) {
        this.outSecOwnerId = outSecOwnerId;
    }

    public BigDecimal getOutUnitTotalCount() {
        return outUnitTotalCount;
    }

    public void setOutUnitTotalCount(BigDecimal outUnitTotalCount) {
        this.outUnitTotalCount = outUnitTotalCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
