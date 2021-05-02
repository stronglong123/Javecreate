package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CommOrderDTO implements Serializable {

    /**
     * 城市id
     */
    private Integer orgId;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 创建人Id
     */
    private Integer createUserId;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 关联单Id
     */
    private String relatedOrderId;

    /**
     * 关联单编号
     */
    private String relatedOrderNo;

    /**
     * 单项
     */
    private List<CommOrderItemDTO> commOrderItemDTOS;

    /**
     * 总件数
     */
    private BigDecimal packageCount;

    /**
     * 总件数
     */
    private BigDecimal unitCount;

    /**
     * 总金额
     */
    private BigDecimal orderAmount;

    /**
     * 平台类型
     */
    private Byte accessPlatformType;

    /**
     * 日期
     */
    private Date saleTime;


    private String saleTimeStr;

    public String getSaleTimeStr() {
        return saleTimeStr;
    }

    public void setSaleTimeStr(String saleTimeStr) {
        this.saleTimeStr = saleTimeStr;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public List<CommOrderItemDTO> getCommOrderItemDTOS() {
        return commOrderItemDTOS;
    }

    public void setCommOrderItemDTOS(List<CommOrderItemDTO> commOrderItemDTOS) {
        this.commOrderItemDTOS = commOrderItemDTOS;
    }

    public String getRelatedOrderId() {
        return relatedOrderId;
    }

    public void setRelatedOrderId(String relatedOrderId) {
        this.relatedOrderId = relatedOrderId;
    }

    public String getRelatedOrderNo() {
        return relatedOrderNo;
    }

    public void setRelatedOrderNo(String relatedOrderNo) {
        this.relatedOrderNo = relatedOrderNo;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public BigDecimal getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(BigDecimal packageCount) {
        this.packageCount = packageCount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(BigDecimal unitCount) {
        this.unitCount = unitCount;
    }

    public Byte getAccessPlatformType() {
        return accessPlatformType;
    }

    public void setAccessPlatformType(Byte accessPlatformType) {
        this.accessPlatformType = accessPlatformType;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }
}
