package com.common.generate.javacreate.test.transferNote;

import com.common.generate.javacreate.model.base.search.PageCondition;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 采购入库申请单查询
 */
public class PurchaseInStockApplyQuery extends PageCondition implements Serializable{

	private static final long serialVersionUID = -8725906428521700480L;

	/**
	 * 城市id
	 */
	private Integer cityId;

	/**
	 * 仓库id
	 */
	private Integer storeHouseId;

	/**
	 * 采购申请单编号
	 */
	private String businessNO;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 供应商名称
	 */
	private String supplierName;

	/**
	 * 供应商ID
	 */
	private String supplierId;

	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date beginTime;

	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;

	/**
	 * 状态：
	 * 	WAITING_IN_STOCK(0, "待入库"),
	 * 	PART_IN_STOCK(2, "部分入库"),
	 * 	IN_STOCK(4, "已入库");
	 */
	private Integer state;

	/**
	 * 状态集合：
	 * 	WAITING_IN_STOCK(0, "待入库"),
	 * 	PART_IN_STOCK(2, "部分入库"),
	 * 	IN_STOCK(4, "已入库");
	 */
	private List<Integer> stateList;

	/**
	 * 申请单类型 0-采购申请单，1-调拨申请单
	 */
	private Integer businessType;

	/**
	 * 入库申请单货主ID
	 */
	private Long ownerId;

	/**
	 * 入库申请单货主名称
	 */
	private String ownerName;

	private String purchaseName;

	/**
	 * 品牌
	 */
	private String brandName;
	/**
	 * 类目
	 */
	private String category;

	/**
	 * 申请单关联单据编号
	 */
	private String relatedNoteNO;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStoreHouseId() {
		return storeHouseId;
	}

	public void setStoreHouseId(Integer storeHouseId) {
		this.storeHouseId = storeHouseId;
	}

	public String getBusinessNO() {
		return businessNO;
	}

	public void setBusinessNO(String businessNO) {
		this.businessNO = businessNO;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<Integer> getStateList() {
		return stateList;
	}

	public void setStateList(List<Integer> stateList) {
		this.stateList = stateList;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRelatedNoteNO() {
		return relatedNoteNO;
	}

	public void setRelatedNoteNO(String relatedNoteNO) {
		this.relatedNoteNO = relatedNoteNO;
	}
}
