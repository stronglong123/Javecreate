package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author huliangzhi
 * @date 2020-06-04
 */
public class AllocationNoteItemFromErp implements Serializable{

	private static final long serialVersionUID = 2691461714798297154L;

	/** 产品货主 */
	private String productOwnerId;

    /** 订单明细ID */
	private String businessItemId;

    /** 产品信息规格ID*/
	private String specificationId;

    /** 产品id */
	private String productSkuId;

    /** SKU名称 */
	private String productName;

    /** 包装规格系数 */
	private Integer specQuantity;

    /** 销售数量小单位 */
	private BigDecimal minUnitTotalCount;

    /** 调拨单价 */
	private BigDecimal sellPrice;

    /** 调拨单价单位 */
	private String sellPriceUnit;

    /** 大单位 */
	private String packageName;

    /** 小单位 */
	private String unitName;

    /** 销售模式 无 = 0,自营 = 1,合作 = 2,寄售 = 3,大商转自营 = 4,大商转配送 = 5,代运营 = 6,入驻 = 7,总部寄售 = 8,独家包销 = 9,经销商直配 = 10, */
	private Integer saleMode;

    /** 产品总价 */
	private BigDecimal totalAmount;

    /** 应付金额 */
	private BigDecimal payAmount;

    /** 应付金额 */
	private String productBrand;

    /**
     * 统计类目
     */
	private String statisticsCategoryName;

    /** 备注 */
	private String remark;

	/**
	 * 出库数量 小单位
	 */
	public BigDecimal minUnitOutStockCount;

	/**
	 * 入库数量 小单位
	 */
	public BigDecimal minUnitInStockCount ;

	public String getProductOwnerId() {
		return productOwnerId;
	}

	public void setProductOwnerId(String productOwnerId) {
		this.productOwnerId = productOwnerId;
	}

	public String getBusinessItemId() {
		return businessItemId;
	}

	public void setBusinessItemId(String businessItemId) {
		this.businessItemId = businessItemId;
	}

	public String getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(String specificationId) {
		this.specificationId = specificationId;
	}

	public String getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSpecQuantity() {
		return specQuantity;
	}

	public void setSpecQuantity(Integer specQuantity) {
		this.specQuantity = specQuantity;
	}

	public BigDecimal getMinUnitTotalCount() {
		return minUnitTotalCount;
	}

	public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
		this.minUnitTotalCount = minUnitTotalCount;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSellPriceUnit() {
		return sellPriceUnit;
	}

	public void setSellPriceUnit(String sellPriceUnit) {
		this.sellPriceUnit = sellPriceUnit;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getSaleMode() {
		return saleMode;
	}

	public void setSaleMode(Integer saleMode) {
		this.saleMode = saleMode;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getStatisticsCategoryName() {
		return statisticsCategoryName;
	}

	public void setStatisticsCategoryName(String statisticsCategoryName) {
		this.statisticsCategoryName = statisticsCategoryName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getMinUnitOutStockCount() {
		return minUnitOutStockCount;
	}

	public void setMinUnitOutStockCount(BigDecimal minUnitOutStockCount) {
		this.minUnitOutStockCount = minUnitOutStockCount;
	}

	public BigDecimal getMinUnitInStockCount() {
		return minUnitInStockCount;
	}

	public void setMinUnitInStockCount(BigDecimal minUnitInStockCount) {
		this.minUnitInStockCount = minUnitInStockCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
