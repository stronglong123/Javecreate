package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 库存分配条件
 * 
 * @author 张远志
 * @since 2021年2月23日16:13:48
 *
 */
public class AllocateInventoryParamItem implements Serializable {
	private static final long serialVersionUID = -6806949007995166885L;
	/**
	 * 单据明细ID
	 */
	private Long orderItemId;
	/**
	 * 规格ID
	 */
	private Long productSpecId;
	/**
	 * 一级货主ID
	 */
	private Long ownerId;
	/**
	 * 商品是否带票
	 */
	private Boolean hasTaxInvoice;
	/**
	 * 待分配数量（小单位数量）
	 */
	private BigDecimal toAllocateCount;

	/**
	 * 城市ID
	 */
//	@NotNull(message = "城市ID不能为空")
	private Integer cityId;

	/**
	 * 仓库ID
	 */
//	@NotNull(message = "仓库ID不能为空")
	private Integer warehouseId;

	/**
	 * 二级货主ID
	 */
	private Long secOwnerId;

	public AllocateInventoryParamItem() {
		super();
	}

	public AllocateInventoryParamItem(Long orderItemId, Long productSpecId, Long ownerId, BigDecimal toAllocateCount) {
		this.orderItemId = orderItemId;
		this.productSpecId = productSpecId;
		this.ownerId = ownerId;
		this.toAllocateCount = toAllocateCount;
	}

	public AllocateInventoryParamItem(Long orderItemId, Long productSpecId, Long ownerId, Boolean hasTaxInvoice,
			BigDecimal toAllocateCount) {
		super();
		this.orderItemId = orderItemId;
		this.productSpecId = productSpecId;
		this.ownerId = ownerId;
		this.hasTaxInvoice = hasTaxInvoice;
		this.toAllocateCount = toAllocateCount;
	}

	/**
	 * 获取 单据明细ID
	 *
	 * @return 单据明细ID
	 */
	public Long getOrderItemId() {
		return orderItemId;
	}

	/**
	 * 设置 单据明细ID
	 *
	 * @param orderItemId 单据明细ID
	 */
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * 获取 规格ID
	 *
	 * @return 规格ID
	 */
	public Long getProductSpecId() {
		return productSpecId;
	}

	/**
	 * 设置 规格ID
	 *
	 * @param productSpecId 规格ID
	 */
	public void setProductSpecId(Long productSpecId) {
		this.productSpecId = productSpecId;
	}

	/**
	 * 获取 一级货主ID
	 *
	 * @return 一级货主ID
	 */
	public Long getOwnerId() {
		return ownerId;
	}

	/**
	 * 设置 一级货主ID
	 *
	 * @param ownerId 一级货主ID
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Boolean isHasTaxInvoice() {
		return hasTaxInvoice;
	}

	public void setHasTaxInvoice(Boolean hasTaxInvoice) {
		this.hasTaxInvoice = hasTaxInvoice;
	}

	public BigDecimal getToAllocateCount() {
		return toAllocateCount;
	}

	public void setToAllocateCount(BigDecimal toAllocateCount) {
		this.toAllocateCount = toAllocateCount;
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

	public Boolean getHasTaxInvoice() {
		return hasTaxInvoice;
	}

	public Long getSecOwnerId() {
		return secOwnerId;
	}

	public void setSecOwnerId(Long secOwnerId) {
		this.secOwnerId = secOwnerId;
	}
}
