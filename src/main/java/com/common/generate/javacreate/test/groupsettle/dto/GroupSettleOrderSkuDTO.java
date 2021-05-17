package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 团购对账单Sku汇总数据
 * 
 * @author liaojiejie
 * @date 2021/03/26
 */
public class GroupSettleOrderSkuDTO implements Serializable {
	private static final long serialVersionUID = -6609890755044741871L;

	/**
	 * 主表的Id(settle_order)
	 */
	private Long settleOrderId;

	/**
	 * 产品名称
	 */
	private String channelSkuName;

	/**
	 * 包装规格名称
	 */
	private String productSaleSpec;

	/**
	 * 销售规格系数
	 */
	private BigDecimal saleSpecQuantity;

	/**
	 * 销售单价
	 */
	private BigDecimal salePrice;

	/**
	 * 团购销售(销售数量（大单位）)
	 */
	private BigDecimal saleDeliverPackageCount;

	/**
	 * 团购销售(销售数量（小单位）)
	 */
	private BigDecimal saleDeliverUnitCount;

	/**
	 * 仓库实出(销售数量（大单位）)
	 */
	private BigDecimal deliverPackageCount;

	/**
	 * 仓库实出(销售数量（小单位）)
	 */
	private BigDecimal deliverUnitCount;

	/**
	 * 多货继续销售(销售数量（大单位）)
	 */
	private BigDecimal transformPackageCount;

	/**
	 * 多货继续销售(销售数量（小单位）)
	 */
	private BigDecimal transformUnitCount;

	/**
	 * 团购客退(退货数量（大单位）)
	 */
	private BigDecimal saleStorePackageCount;

	/**
	 * 团购客退(退货数量（小单位）)
	 */
	private BigDecimal saleStoreUnitCount;

	/**
	 * 仓库实入(退货数量（大单位）)
	 */
	private BigDecimal cancelStorePackageCount;

	/**
	 * 仓库实入(退货数量（小单位）)
	 */
	private BigDecimal cancelStoreUnitCount;

	/**
	 * 数量(应退未退合计（大单位）)
	 */
	private BigDecimal settleDiffPackageCount;

	/**
	 * 数量(应退未退合计（小单位）)
	 */
	private BigDecimal settleDiffUnitCount;

	/**
	 * 金额(应退未退合计)
	 */
	private BigDecimal settleDiffAmount;

	/**
	 * 销售单价名称
	 */
	private String sellUnit;

	public Long getSettleOrderId() {
		return settleOrderId;
	}

	public void setSettleOrderId(Long settleOrderId) {
		this.settleOrderId = settleOrderId;
	}

	public String getChannelSkuName() {
		return channelSkuName;
	}

	public void setChannelSkuName(String channelSkuName) {
		this.channelSkuName = channelSkuName;
	}

	public String getProductSaleSpec() {
		return productSaleSpec;
	}

	public void setProductSaleSpec(String productSaleSpec) {
		this.productSaleSpec = productSaleSpec;
	}

	public BigDecimal getSaleSpecQuantity() {
		return saleSpecQuantity;
	}

	public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
		this.saleSpecQuantity = saleSpecQuantity;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getSaleDeliverPackageCount() {
		return saleDeliverPackageCount;
	}

	public void setSaleDeliverPackageCount(BigDecimal saleDeliverPackageCount) {
		this.saleDeliverPackageCount = saleDeliverPackageCount;
	}

	public BigDecimal getSaleDeliverUnitCount() {
		return saleDeliverUnitCount;
	}

	public void setSaleDeliverUnitCount(BigDecimal saleDeliverUnitCount) {
		this.saleDeliverUnitCount = saleDeliverUnitCount;
	}

	public BigDecimal getDeliverPackageCount() {
		return deliverPackageCount;
	}

	public void setDeliverPackageCount(BigDecimal deliverPackageCount) {
		this.deliverPackageCount = deliverPackageCount;
	}

	public BigDecimal getDeliverUnitCount() {
		return deliverUnitCount;
	}

	public void setDeliverUnitCount(BigDecimal deliverUnitCount) {
		this.deliverUnitCount = deliverUnitCount;
	}

	public BigDecimal getTransformPackageCount() {
		return transformPackageCount;
	}

	public void setTransformPackageCount(BigDecimal transformPackageCount) {
		this.transformPackageCount = transformPackageCount;
	}

	public BigDecimal getTransformUnitCount() {
		return transformUnitCount;
	}

	public void setTransformUnitCount(BigDecimal transformUnitCount) {
		this.transformUnitCount = transformUnitCount;
	}

	public BigDecimal getSaleStorePackageCount() {
		return saleStorePackageCount;
	}

	public void setSaleStorePackageCount(BigDecimal saleStorePackageCount) {
		this.saleStorePackageCount = saleStorePackageCount;
	}

	public BigDecimal getSaleStoreUnitCount() {
		return saleStoreUnitCount;
	}

	public void setSaleStoreUnitCount(BigDecimal saleStoreUnitCount) {
		this.saleStoreUnitCount = saleStoreUnitCount;
	}

	public BigDecimal getCancelStorePackageCount() {
		return cancelStorePackageCount;
	}

	public void setCancelStorePackageCount(BigDecimal cancelStorePackageCount) {
		this.cancelStorePackageCount = cancelStorePackageCount;
	}

	public BigDecimal getCancelStoreUnitCount() {
		return cancelStoreUnitCount;
	}

	public void setCancelStoreUnitCount(BigDecimal cancelStoreUnitCount) {
		this.cancelStoreUnitCount = cancelStoreUnitCount;
	}

	public BigDecimal getSettleDiffPackageCount() {
		return settleDiffPackageCount;
	}

	public void setSettleDiffPackageCount(BigDecimal settleDiffPackageCount) {
		this.settleDiffPackageCount = settleDiffPackageCount;
	}

	public BigDecimal getSettleDiffUnitCount() {
		return settleDiffUnitCount;
	}

	public void setSettleDiffUnitCount(BigDecimal settleDiffUnitCount) {
		this.settleDiffUnitCount = settleDiffUnitCount;
	}

	public BigDecimal getSettleDiffAmount() {
		return settleDiffAmount;
	}

	public void setSettleDiffAmount(BigDecimal settleDiffAmount) {
		this.settleDiffAmount = settleDiffAmount;
	}

	public String getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(String sellUnit) {
		this.sellUnit = sellUnit;
	}
}
