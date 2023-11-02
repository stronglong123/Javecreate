package com.common.generate.javacreate.ordercenter.dto;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 销售库存分配记录
 * 
 * @author 张远志
 * @since 2021年3月8日17:52:05
 *
 */
public class SaleInventoryAllocateDTO implements Serializable {
	private static final long serialVersionUID = 4772411695521781185L;
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 阶段
	 */
	private Integer phase;

	/**
	 * 单据类型
	 */
	private Integer orderType;

	/**
	 * 单据ID（可以是oms系统id，或其他异构系统内部id）
	 */
	private Long orderId;

	/**
	 * 单据编号（可以是oms系统编号，或其他异构系统内部编号）
	 */
	private String orderNo;

	/**
	 * 单据项ID（可以是oms系统itemId，或其他异构系统内部itemId）
	 */
	private Long orderItemId;

	/**
	 * 单据来源类型（配合orderId使用，防止异构系统orderId重复）
	 * @see AllocateOrderSourceConstant
	 */
	private String orderSource;

	/**
	 * 销售库存ID
	 */
	private Long inventoryId;

	/**
	 * 城市ID
	 */
	private Integer cityId;

	/**
	 * 仓库ID
	 */
	private Integer warehouseId;

	/**
	 * SKUID
	 */
	private Long productSkuId;

	/**
	 * 商品规格ID
	 */
	private Long productSpecId;

	/**
	 * 一级货主ID
	 */
	private Long ownerId;

	/**
	 * 二级货主ID
	 */
	private Long secOwnerId;

	/**
	 * 分配数量
	 */
	private BigDecimal allocateCount;

	/**
	 * 差异数量（回单入库时，与实际出库数量的差异）
	 */
	private BigDecimal diffCount;

	/**
	 * 成本价格
	 */
	private BigDecimal costPrice;

	/**
	 * 出库数量
	 */
	private BigDecimal dispatchCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPhase() {
		return phase;
	}

	public void setPhase(Integer phase) {
		this.phase = phase;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
	}

	public Long getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(Long productSpecId) {
		this.productSpecId = productSpecId;
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

	public BigDecimal getAllocateCount() {
		return allocateCount;
	}

	public void setAllocateCount(BigDecimal allocateCount) {
		this.allocateCount = allocateCount;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getDispatchCount() {
		return dispatchCount;
	}

	public void setDispatchCount(BigDecimal dispatchCount) {
		this.dispatchCount = dispatchCount;
	}

	public BigDecimal getDiffCount() {
		return diffCount;
	}

	public void setDiffCount(BigDecimal diffCount) {
		this.diffCount = diffCount;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	@Override
	public String toString() {
		return "warehouseId=" + warehouseId + ",orderId=" + orderId + ",orderItemId=" + orderItemId + ",ownerId="
				+ ownerId + ",secOwnerId=" + secOwnerId + ",allocateCount=" + allocateCount + ",costPrice=" + costPrice;
	}
}
