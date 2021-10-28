/*
 * @ClassName InStockApplyPO
 * @Description
 * @version 1.0
 * @Date 2019-01-05 11:14:35
 */
package com.common.generate.javacreate.test.transferNote;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 采购申请单
 */
public class InStockApplyDTO implements Serializable {

    /**
     * @Fields id 编号
     */
    private Long id;
    /**
     * @Fields cityId 城市编号
     */
    private Integer cityId;
    /**
     * @Fields storeHouseId 仓库编号
     */
    private String storeHouseId;
    /**
     * @Fields purchaseUserId 采购员编号
     */
    private Integer purchaseUserId;
    /**
     * @Fields purchaseName 采购姓名
     */
    private String purchaseName;
    /**
     * @Fields purchaseMobileNo 采购电话号码
     */
    private String purchaseMobileNo;
    /**
     * @Fields businessId ERP申请单编号
     */
    private String businessId;
    /**
     * @Fields businessNO ERP申请单编码
     */
    private String businessNO;
    /**
     * @Fields businessType 业务类型(申请单类型)：0-采购申请单, 1-调拨申请单
     */
    private Integer businessType;
    /**
     * @Fields supplierId 供应商id
     */
    private String supplierId;
    /**
     * @Fields supplierName 供应商名称
     */
    private String supplierName;
    /**
     * @Fields isDelete 是否删除
     */
    private Integer isDelete;
    /**
     * @Fields state 状态 未提交(0), 审核中(1), 交货中(2), 已拒绝(3), 已完成(4), 已过期(5), 已取消(6)
     */
    private Integer state;
    /**
     * @Fields createUser 创建用户
     */
    private String createUser;
    /**
     * @Fields createTime 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * @Fields lastUpdateUser 更新用户
     */
    private String lastUpdateUser;
    /**
     * @Fields lastUpdateTime 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;

    private List<InStockItemApplyDTO> items;

    /**
     * 入库商品数
     */
    private Integer productCount;

    /**
     * 入库大数量
     */
    private BigDecimal productPackageCount;

    /**
     * 入库小数量
     */
    private BigDecimal productUnitCount;

    /**
     * 采购入库单状态描述
     */
    private String stateDescription;

    // 通用申请单添加字段 - Start

    /**
     * 来源城市ID(发货城市ID)
     */
    private Integer fromCityId;

    /**
     * 来源仓库ID(发货仓库ID)
     */
    private Integer fromStoreHouseId;

    /**
     * @Fields businessSubType 子业务类型
     */
    private Integer businessSubType;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 实付总金额
     */
    private BigDecimal payAmount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 扩展字段(供应链仅需保存数据)
     */
    private String extContent;

    /**
     * 申请时间(业务时间)
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date businessTime;
    

    /**
     * 入库申请单货主ID
     */
    private Long ownerId;

    /**
     * 入库申请单货主名称
     */
    private String ownerName;

    /**
     * 申请单关联单据ID
     */
    private String relatedNoteId;

    /**
     * 申请单关联单据编号
     */
    private String relatedNoteNO;

    // 通用申请单添加字段 - End

    /**
     * 是否通过城市+规格+货主方式填充申请单产品信息
     *      false - 否（用skuId方式）
     *      true - 否（用规格ID方式）
     */
    private Boolean fillSkuInfoBySpec = false;

    /**
     * 当前申请单确认入库时产生入库单据编号
     */
    private String currentConfirmInStockNO;

	public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getProductPackageCount() {
        return productPackageCount;
    }

    public void setProductPackageCount(BigDecimal productPackageCount) {
        this.productPackageCount = productPackageCount;
    }

    public BigDecimal getProductUnitCount() {
        return productUnitCount;
    }

    public void setProductUnitCount(BigDecimal productUnitCount) {
        this.productUnitCount = productUnitCount;
    }

    public List<InStockItemApplyDTO> getItems() {
        return items;
    }

    public void setItems(List<InStockItemApplyDTO> items) {
        this.items = items;
    }

    /**
     * 获取  编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  城市编号
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置  城市编号
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取  仓库编号
     */
    public String getStoreHouseId() {
        return storeHouseId;
    }

    /**
     * 设置  仓库编号
     */
    public void setStoreHouseId(String storeHouseId) {
        this.storeHouseId = storeHouseId == null ? null : storeHouseId.trim();
    }

    /**
     * 获取  采购员编号
     */
    public Integer getPurchaseUserId() {
        return purchaseUserId;
    }

    /**
     * 设置  采购员编号
     */
    public void setPurchaseUserId(Integer purchaseUserId) {
        this.purchaseUserId = purchaseUserId;
    }

    /**
     * 获取  采购姓名
     */
    public String getPurchaseName() {
        return purchaseName;
    }

    /**
     * 设置  采购姓名
     */
    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName == null ? null : purchaseName.trim();
    }

    /**
     * 获取  采购电话号码
     */
    public String getPurchaseMobileNo() {
        return purchaseMobileNo;
    }

    /**
     * 设置  采购电话号码
     */
    public void setPurchaseMobileNo(String purchaseMobileNo) {
        this.purchaseMobileNo = purchaseMobileNo == null ? null : purchaseMobileNo.trim();
    }

    /**
     * 获取  ERP申请单编号
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * 设置  ERP申请单编号
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    /**
     * 获取  ERP申请单编码
     */
    public String getBusinessNO() {
        return businessNO;
    }

    /**
     * 设置  ERP申请单编码
     */
    public void setBusinessNO(String businessNO) {
        this.businessNO = businessNO == null ? null : businessNO.trim();
    }

    /**
     * 获取  采购类型 城市采购(0) 大区联采(1), 总部统采(2), 城际调拨(3),代理采购(4), 经销商直配(5)
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * 设置  采购类型 城市采购(0) 大区联采(1), 总部统采(2), 城际调拨(3),代理采购(4), 经销商直配(5)
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取  供应商id
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * 设置  供应商id
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    /**
     * 获取  供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 设置  供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * 获取  是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置  是否删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取  状态 未提交(0), 审核中(1), 交货中(2), 已拒绝(3), 已完成(4), 已过期(5), 已取消(6)
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置  状态 未提交(0), 审核中(1), 交货中(2), 已拒绝(3), 已完成(4), 已过期(5), 已取消(6)
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取  创建用户
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置  创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取  创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  更新用户
     */
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    /**
     * 设置  更新用户
     */
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 获取  更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置  更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public Integer getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(Integer fromCityId) {
        this.fromCityId = fromCityId;
    }

    public Integer getFromStoreHouseId() {
        return fromStoreHouseId;
    }

    public void setFromStoreHouseId(Integer fromStoreHouseId) {
        this.fromStoreHouseId = fromStoreHouseId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtContent() {
        return extContent;
    }

    public void setExtContent(String extContent) {
        this.extContent = extContent;
    }

    public Integer getBusinessSubType() {
        return businessSubType;
    }

    public void setBusinessSubType(Integer businessSubType) {
        this.businessSubType = businessSubType;
    }

    public Date getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Date businessTime) {
        this.businessTime = businessTime;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Boolean getFillSkuInfoBySpec() {
        return fillSkuInfoBySpec;
    }

    public void setFillSkuInfoBySpec(Boolean fillSkuInfoBySpec) {
        this.fillSkuInfoBySpec = fillSkuInfoBySpec;
    }

    public String getRelatedNoteId() {
        return relatedNoteId;
    }

    public void setRelatedNoteId(String relatedNoteId) {
        this.relatedNoteId = relatedNoteId;
    }

    public String getRelatedNoteNO() {
        return relatedNoteNO;
    }

    public void setRelatedNoteNO(String relatedNoteNO) {
        this.relatedNoteNO = relatedNoteNO;
    }

    public String getCurrentConfirmInStockNO() {
        return currentConfirmInStockNO;
    }

    public void setCurrentConfirmInStockNO(String currentConfirmInStockNO) {
        this.currentConfirmInStockNO = currentConfirmInStockNO;
    }
}
