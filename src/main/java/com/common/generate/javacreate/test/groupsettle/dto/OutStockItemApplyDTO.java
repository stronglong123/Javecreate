package com.common.generate.javacreate.test.groupsettle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OutStockItemApplyDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 城市id
     */
    private Integer orgId;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 申请单id
     */
    private Long applyOrderId;

    /**
     * 申请单单号
     */
    private String applyOrderNo;

    /**
     * skuId
     */
    private Long productSkuId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 品牌
     */
    private String productBrand;

    /**
     * 类目
     */
    private String categoryName;

    /**
     * 一级货主id
     */
    private Long ownerId;

    /**
     * 一级货主名称
     */
    private String ownerName;

    /**
     * 二级货主id
     */
    private Long secOwnerId;

    /**
     * 二级货主名称
     */
    private String secOwnerName;

    /**
     * 产品规格id
     */
    private Long productSpecificationId;

    /**
     * 是否增品，0:非赠品, 1:赠品;
     */
    private Byte isGift;

    /**
     * 规格名称
     */
    private String specName;

    /**
     * 规格系数
     */
    private BigDecimal specQuantity;

    /**
     * 大单位名称
     */
    private String packageName;

    /**
     * 申请大单位数量
     */
    private BigDecimal packageCount;

    /**
     * 小单位名称
     */
    private String unitName;

    /**
     * 申请小单位数量
     */
    private BigDecimal unitCount;

    /**
     * 申请小单位总数量
     */
    private BigDecimal unitTotalCount;

    /**
     * 已出库小单位总数量
     */
    private BigDecimal overUnitTotalCount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改人
     */
    private String lastUpdateUser;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 单价单位
     */
    private String priceUnit;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 是否残次品
     */
    private Boolean defective = false;

    /**
     * 是否自动计算
     */
    private Boolean allocationCalculation = false;

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

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getApplyOrderId() {
        return applyOrderId;
    }

    public void setApplyOrderId(Long applyOrderId) {
        this.applyOrderId = applyOrderId;
    }

    public String getApplyOrderNo() {
        return applyOrderNo;
    }

    public void setApplyOrderNo(String applyOrderNo) {
        this.applyOrderNo = applyOrderNo == null ? null : applyOrderNo.trim();
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
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

    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public Byte getIsGift() {
        return isGift;
    }

    public void setIsGift(Byte isGift) {
        this.isGift = isGift;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public BigDecimal getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(BigDecimal packageCount) {
        this.packageCount = packageCount;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public BigDecimal getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(BigDecimal unitCount) {
        this.unitCount = unitCount;
    }

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public BigDecimal getOverUnitTotalCount() {
        return overUnitTotalCount;
    }

    public void setOverUnitTotalCount(BigDecimal overUnitTotalCount) {
        this.overUnitTotalCount = overUnitTotalCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getDefective() {
        return defective;
    }

    public void setDefective(Boolean defective) {
        this.defective = defective;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSecOwnerName() {
        return secOwnerName;
    }

    public void setSecOwnerName(String secOwnerName) {
        this.secOwnerName = secOwnerName;
    }

    public Boolean getAllocationCalculation() {
        return allocationCalculation;
    }

    public void setAllocationCalculation(Boolean allocationCalculation) {
        this.allocationCalculation = allocationCalculation;
    }
}