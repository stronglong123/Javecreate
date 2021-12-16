package com.common.generate.javacreate.test.groupsettle.dto;



import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/4/30 23:06
 */
public class ErpProductOwnerDTO implements Serializable {
    private static final long serialVersionUID = -4892034923289767722L;

    private Integer orgId;

    private Integer warehouseId;

    private Long specId;

    private BigDecimal unitTotalCount;

    private String errorErpOwnerId;

    private Long errorWmsOwnerId;

    private String tureWmsOwnerId;

    private String tureErpOwnerId;

    private String productName;

    private Long productSkuId;

    private Integer orderType;

    private String orderNo;

    private String date;

    private String type;


    private Integer isDiff;

    private Long omsItemId;

    private BigDecimal outCount;

    private BigDecimal inCount;

    public BigDecimal getOutCount() {
        return outCount;
    }

    public void setOutCount(BigDecimal outCount) {
        this.outCount = outCount;
    }

    public BigDecimal getInCount() {
        return inCount;
    }

    public void setInCount(BigDecimal inCount) {
        this.inCount = inCount;
    }

    public Integer getIsDiff() {
        return isDiff;
    }

    public void setIsDiff(Integer isDiff) {
        this.isDiff = isDiff;
    }

    public Long getOmsItemId() {
        return omsItemId;
    }

    public void setOmsItemId(Long omsItemId) {
        this.omsItemId = omsItemId;
    }

    public Integer getDiff() {
        return isDiff;
    }

    public void setDiff(Integer diff) {
        isDiff = diff;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public String getErrorErpOwnerId() {
        return errorErpOwnerId;
    }

    public void setErrorErpOwnerId(String errorErpOwnerId) {
        this.errorErpOwnerId = errorErpOwnerId;
    }

    public Long getErrorWmsOwnerId() {
        return errorWmsOwnerId;
    }

    public void setErrorWmsOwnerId(Long errorWmsOwnerId) {
        this.errorWmsOwnerId = errorWmsOwnerId;
    }

    public String getTureWmsOwnerId() {
        return tureWmsOwnerId;
    }

    public void setTureWmsOwnerId(String tureWmsOwnerId) {
        this.tureWmsOwnerId = tureWmsOwnerId;
    }

    public String getTureErpOwnerId() {
        return tureErpOwnerId;
    }

    public void setTureErpOwnerId(String tureErpOwnerId) {
        this.tureErpOwnerId = tureErpOwnerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
