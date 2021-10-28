package com.common.generate.javacreate.test.transferNote;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OutStockOrderItemDetailDTO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 城市id
     */
    private Integer orgId;

    /**
     * 出库单单项id
     */
    private Long outStockOrderItemId;

    /**
     * 转出货位id
     */
    private Long locationId;

    /**
     * 转出货位名称
     */
    private String locationName;

    /**
     * 产品生产日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date productionDate;

    /**
     * 产品批次时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date batchTime;

    /**
     * 小单位总数量
     */
    private BigDecimal unitTotalCount;

    /**
     * 已出库小单位总数量
     */
    private BigDecimal outStockUnitTotalCount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;

    /**
     * 产品规格ID
     */
    private Long productSpecificationId;

    /**
     * 货主id
     */
    private Long ownerId;

    /**
     * 二级货主id
     */
    private Long secOwnerId;

    /**
     * 批属性编号
     */
    private String batchAttributeInfoNo;

    /**
     * 是否残次品
     */
    private Boolean defective = false;

    /**
     * 出库单单项id
     */
    private Long outStockOrderId;

    /**
     * 出库单业务项id
     */
    private String businessItemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Long getOutStockOrderItemId() {
        return outStockOrderItemId;
    }

    public void setOutStockOrderItemId(Long outStockOrderItemId) {
        this.outStockOrderItemId = outStockOrderItemId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getBatchTime() {
        return batchTime;
    }

    public void setBatchTime(Date batchTime) {
        this.batchTime = batchTime;
    }

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigDecimal getOutStockUnitTotalCount() {
        return outStockUnitTotalCount;
    }

    public void setOutStockUnitTotalCount(BigDecimal outStockUnitTotalCount) {
        this.outStockUnitTotalCount = outStockUnitTotalCount;
    }

    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public String getBatchAttributeInfoNo() {
        return batchAttributeInfoNo;
    }

    public void setBatchAttributeInfoNo(String batchAttributeInfoNo) {
        this.batchAttributeInfoNo = batchAttributeInfoNo;
    }

    public Boolean getDefective() {
        return defective;
    }

    public void setDefective(Boolean defective) {
        this.defective = defective;
    }

    public Long getOutStockOrderId() {
        return outStockOrderId;
    }

    public void setOutStockOrderId(Long outStockOrderId) {
        this.outStockOrderId = outStockOrderId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }
}