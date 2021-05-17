package com.common.generate.javacreate.service.newcheck;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 结算二级货主数据比较对象
 * 
 * @author liaojiejie
 * @date 2021/05/14
 */
public class CompareSettleOwnerDataBO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4721731195743974600L;
	
	/**
	 * 1、ERP数据，2、Settle数据
	 */
	private Integer type;

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
	 * 产品名称
	 */
	private String skuName;


	private Long skuId;

	private String suggestOwnerIds;

	private Long errorOwnerId;
	
	/**
	 * 库存数量
	 */
	private BigDecimal warehouseMinUnitTotalCount = BigDecimal.ZERO;

	/**
	 * 出库数量
	 */
	private BigDecimal deliverMinUnitTotalCount = BigDecimal.ZERO;

	/**
	 * 入库数量
	 */
	private BigDecimal storeMinUnitTotalCount = BigDecimal.ZERO;

	/**
	 * 结算出库数量
	 */
	private BigDecimal settleDeliverMinUnitTotalCount = BigDecimal.ZERO;

	/**
	 * 结算入库数量
	 */
	private BigDecimal settleStoreMinUnitTotalCount = BigDecimal.ZERO;

	/**
	 * 其它出库数量
	 */
	private BigDecimal ortherDeliverMinUnitTotalCount = BigDecimal.ZERO;

	/**
	 * 其它入库数量
	 */
	private BigDecimal ortherStoreMinUnitTotalCount = BigDecimal.ZERO;


	public Long getErrorOwnerId() {
		return errorOwnerId;
	}

	public void setErrorOwnerId(Long errorOwnerId) {
		this.errorOwnerId = errorOwnerId;
	}

	public String getSuggestOwnerIds() {
		return suggestOwnerIds;
	}

	public void setSuggestOwnerIds(String suggestOwnerIds) {
		this.suggestOwnerIds = suggestOwnerIds;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public BigDecimal getWarehouseMinUnitTotalCount() {
		return warehouseMinUnitTotalCount;
	}

	public void setWarehouseMinUnitTotalCount(BigDecimal warehouseMinUnitTotalCount) {
		this.warehouseMinUnitTotalCount = warehouseMinUnitTotalCount;
	}

	public BigDecimal getDeliverMinUnitTotalCount() {
		return deliverMinUnitTotalCount;
	}

	public void setDeliverMinUnitTotalCount(BigDecimal deliverMinUnitTotalCount) {
		this.deliverMinUnitTotalCount = deliverMinUnitTotalCount;
	}

	public BigDecimal getStoreMinUnitTotalCount() {
		return storeMinUnitTotalCount;
	}

	public void setStoreMinUnitTotalCount(BigDecimal storeMinUnitTotalCount) {
		this.storeMinUnitTotalCount = storeMinUnitTotalCount;
	}

	public BigDecimal getSettleDeliverMinUnitTotalCount() {
		return settleDeliverMinUnitTotalCount;
	}

	public void setSettleDeliverMinUnitTotalCount(BigDecimal settleDeliverMinUnitTotalCount) {
		this.settleDeliverMinUnitTotalCount = settleDeliverMinUnitTotalCount;
	}

	public BigDecimal getSettleStoreMinUnitTotalCount() {
		return settleStoreMinUnitTotalCount;
	}

	public void setSettleStoreMinUnitTotalCount(BigDecimal settleStoreMinUnitTotalCount) {
		this.settleStoreMinUnitTotalCount = settleStoreMinUnitTotalCount;
	}

	public BigDecimal getOrtherDeliverMinUnitTotalCount() {
		return ortherDeliverMinUnitTotalCount;
	}

	public void setOrtherDeliverMinUnitTotalCount(BigDecimal ortherDeliverMinUnitTotalCount) {
		this.ortherDeliverMinUnitTotalCount = ortherDeliverMinUnitTotalCount;
	}

	public BigDecimal getOrtherStoreMinUnitTotalCount() {
		return ortherStoreMinUnitTotalCount;
	}

	public void setOrtherStoreMinUnitTotalCount(BigDecimal ortherStoreMinUnitTotalCount) {
		this.ortherStoreMinUnitTotalCount = ortherStoreMinUnitTotalCount;
	}

}