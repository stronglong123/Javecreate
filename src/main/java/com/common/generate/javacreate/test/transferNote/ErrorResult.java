package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/2/8 8:49
 */
public class ErrorResult implements Serializable {


    private static final long serialVersionUID = 5331807838922040095L;

    private String transferNo;

    private String inApplyNo;

    private String outNo;

    private String productName;

    private Long inApplyItemId;

    private Long outItemDetailId;

    private Long outItemId;

    private Long transferItemId;

    private Long inApplyOwnerId;

    private Long inApplySecOwnerId;

    private BigDecimal inApplyUnitTotalCount;

    private BigDecimal applyHasInUnitTotalCount;

    private Long outOwnerId;

    private Long outSecOwnerId;

    private BigDecimal outUnitTotalCount;


    private List<OutErrorResult> outErrorResults;

    private List<InApplyErrorResult> inApplyErrorResults;


    private boolean isError;

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public List<OutErrorResult> getOutErrorResults() {
        return outErrorResults;
    }

    public void setOutErrorResults(List<OutErrorResult> outErrorResults) {
        this.outErrorResults = outErrorResults;
    }

    public List<InApplyErrorResult> getInApplyErrorResults() {
        return inApplyErrorResults;
    }

    public void setInApplyErrorResults(List<InApplyErrorResult> inApplyErrorResults) {
        this.inApplyErrorResults = inApplyErrorResults;
    }

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo;
    }

    public String getInApplyNo() {
        return inApplyNo;
    }

    public void setInApplyNo(String inApplyNo) {
        this.inApplyNo = inApplyNo;
    }

    public String getOutNo() {
        return outNo;
    }

    public void setOutNo(String outNo) {
        this.outNo = outNo;
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

    public Long getOutItemDetailId() {
        return outItemDetailId;
    }

    public void setOutItemDetailId(Long outItemDetailId) {
        this.outItemDetailId = outItemDetailId;
    }

    public Long getOutItemId() {
        return outItemId;
    }

    public void setOutItemId(Long outItemId) {
        this.outItemId = outItemId;
    }

    public Long getTransferItemId() {
        return transferItemId;
    }

    public void setTransferItemId(Long transferItemId) {
        this.transferItemId = transferItemId;
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
}
