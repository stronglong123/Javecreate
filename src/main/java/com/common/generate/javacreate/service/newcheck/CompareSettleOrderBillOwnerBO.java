package com.common.generate.javacreate.service.newcheck;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 结算二级货主数据比较对象
 * 
 * @author liaojiejie
 * @date 2021/05/14
 */
public class CompareSettleOrderBillOwnerBO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 360795547400905499L;

	/**
	 * 仓库ID
	 */
	private Integer warehouseId;

	/**
	 * 规格ID
	 */
	private Long productSpecId;

	/**
	 * 二级货主ID
	 */
	private String productOwnerId;

	/**
	 * 二级货主数量
	 */
	private BigDecimal minUnitTotalCount;
	
	/**
	 * 类型
	 */
	private Byte orderType;

	private Long skuId;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(Long productSpecId) {
		this.productSpecId = productSpecId;
	}

	public String getProductOwnerId() {
		return productOwnerId;
	}

	public void setProductOwnerId(String productOwnerId) {
		this.productOwnerId = productOwnerId;
	}

	public BigDecimal getMinUnitTotalCount() {
		return minUnitTotalCount;
	}

	public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
		this.minUnitTotalCount = minUnitTotalCount;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

}