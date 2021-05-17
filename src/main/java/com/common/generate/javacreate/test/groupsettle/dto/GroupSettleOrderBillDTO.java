package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 团购对账单关联出入库单据
 * 
 * @author liaojiejie
 * @date 2021/03/26
 */
public class GroupSettleOrderBillDTO implements Serializable {
	private static final long serialVersionUID = -2509607022606277777L;

	/**
	 * 主表的Id(settle_order)
	 */
	private Long settleOrderId;

	/**
	 * 单据编号
	 */
	private String orderNo;

	/**
	 * 单据日期
	 */
	private Date orderDate;

	/**
	 * 单据类型类型（1、销售出、2、销售退、3、结转入、4、结转出、5、差异）
	 */
	private Byte orderType;

	/**
	 * 产品名称
	 */
	private String skuName;

	/**
	 * 包装规格
	 */
	private String productSaleSpec;
	
	/**
	 * 销售规格系数
	 */
	private BigDecimal saleSpecQuantity;

	/**
	 * 单据录入，总数量
	 */
	private BigDecimal minUnitTotalCount;
	
	/**
	 * 单据录入，大单位
	 */
	private BigDecimal salePackageCount;

	/**
	 * 单据录入，小单位
	 */
	private BigDecimal saleUnitCount;

	/**
	 * 本次结算，总数量
	 */
	private BigDecimal settleMinUnitTotalCount;

	/**
	 * 本次结算，大单位
	 */
	private BigDecimal settlePackageCount;

	/**
	 * 本次结算，小单位
	 */
	private BigDecimal settleUnitCount;


	private BigDecimal inCount;

	private BigDecimal outCount;

	private BigDecimal calCount;

	public BigDecimal getCalCount() {
		return calCount;
	}

	public void setCalCount(BigDecimal calCount) {
		this.calCount = calCount;
	}

	public BigDecimal getInCount() {
		return inCount;
	}

	public void setInCount(BigDecimal inCount) {
		this.inCount = inCount;
	}

	public BigDecimal getOutCount() {
		return outCount;
	}

	public void setOutCount(BigDecimal outCount) {
		this.outCount = outCount;
	}

	public Long getSettleOrderId() {
		return settleOrderId;
	}

	public void setSettleOrderId(Long settleOrderId) {
		this.settleOrderId = settleOrderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
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

	public BigDecimal getMinUnitTotalCount() {
		return minUnitTotalCount;
	}

	public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
		this.minUnitTotalCount = minUnitTotalCount;
	}

	public BigDecimal getSalePackageCount() {
		return salePackageCount;
	}

	public void setSalePackageCount(BigDecimal salePackageCount) {
		this.salePackageCount = salePackageCount;
	}

	public BigDecimal getSaleUnitCount() {
		return saleUnitCount;
	}

	public void setSaleUnitCount(BigDecimal saleUnitCount) {
		this.saleUnitCount = saleUnitCount;
	}

	public BigDecimal getSettleMinUnitTotalCount() {
		return settleMinUnitTotalCount;
	}

	public void setSettleMinUnitTotalCount(BigDecimal settleMinUnitTotalCount) {
		this.settleMinUnitTotalCount = settleMinUnitTotalCount;
	}

	public BigDecimal getSettlePackageCount() {
		return settlePackageCount;
	}

	public void setSettlePackageCount(BigDecimal settlePackageCount) {
		this.settlePackageCount = settlePackageCount;
	}

	public BigDecimal getSettleUnitCount() {
		return settleUnitCount;
	}

	public void setSettleUnitCount(BigDecimal settleUnitCount) {
		this.settleUnitCount = settleUnitCount;
	}
	
}
