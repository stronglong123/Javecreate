package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;

public class InStockOrderCommItemDetailDTO implements Serializable {

	/**
	 * 入库单子项明细ID
	 */
	private String orderItemDetailId;

	/**
	 * @Fields locationId 入库货位id
	 */
	private Long locationId;

	/**
	 * @Fields locationName 入库货位名称
	 */
	private String locationName;

	/**
	 * @Fields productionDate 产品生产日期
	 */

	private String productionDate;

	/**
	 * 过期时间
	 */
	private String expireTime;

	/**
	 * @Fields batchTime 产品批次时间
	 */
	private String batchTime;

	/**
	 * @Fields unitTotalCount 产品小单位总数量
	 */
	private BigDecimal unitTotalCount;

	/**
	 * @Fields inUnitTotalCount 已入库小单位总数量
	 */
	private BigDecimal inUnitTotalCount;

	/**
	 * @Fields remark 备注
	 */
	private String remark;

	/**
	 * @Fields productSpecificationId 产品规格ID
	 */
	private Long productSpecificationId;

	/**
	 * @Fields ownerId 所属人ID
	 */
	private Long ownerId;

	/**
	 * @Fields secOwnerId 二级货主Id(供应商ID)
	 */
	private Long secOwnerId;

	/**
	 * 批属性编号
	 */
	private String batchAttributeInfoNo;

	/**
	 * 供应链入库单项详情ID
	 */
	private Long wmsOrderItemDetailId;

	public String getOrderItemDetailId() {
		return orderItemDetailId;
	}

	public void setOrderItemDetailId(String orderItemDetailId) {
		this.orderItemDetailId = orderItemDetailId;
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

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}

	public BigDecimal getUnitTotalCount() {
		return unitTotalCount;
	}

	public void setUnitTotalCount(BigDecimal unitTotalCount) {
		this.unitTotalCount = unitTotalCount;
	}

	public BigDecimal getInUnitTotalCount() {
		return inUnitTotalCount;
	}

	public void setInUnitTotalCount(BigDecimal inUnitTotalCount) {
		this.inUnitTotalCount = inUnitTotalCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Long getWmsOrderItemDetailId() {
		return wmsOrderItemDetailId;
	}

	public void setWmsOrderItemDetailId(Long wmsOrderItemDetailId) {
		this.wmsOrderItemDetailId = wmsOrderItemDetailId;
	}
}
