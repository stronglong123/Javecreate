package com.common.generate.javacreate.test.erp;

import java.math.BigDecimal;
import java.util.Date;

public class GroupSettleOrderBillInsertDTO {

	private Integer orgId;

	private Long settleOrderId;

	private String businessNo;

	private Long orderId;

	private Long orderItemId;

	private Date orderDate;

	private Byte orderType;

	private Long skuId;

	private String skuName;

	private String productSaleSpec;

	private BigDecimal saleSpecQuantity;

	private String sellUnit;

	private BigDecimal orderPrice;

	private BigDecimal orderAmount;

	private BigDecimal originalMinUnitTotalCount;

	private BigDecimal minUnitTotalCount;

	private BigDecimal settleMinUnitTotalCount;

	private Long productOwnerId;

	private Long productSpecId;

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Long getSettleOrderId() {
		return settleOrderId;
	}

	public void setSettleOrderId(Long settleOrderId) {
		this.settleOrderId = settleOrderId;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
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

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
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

	public String getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(String sellUnit) {
		this.sellUnit = sellUnit;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOriginalMinUnitTotalCount() {
		return originalMinUnitTotalCount;
	}

	public void setOriginalMinUnitTotalCount(BigDecimal originalMinUnitTotalCount) {
		this.originalMinUnitTotalCount = originalMinUnitTotalCount;
	}

	public BigDecimal getMinUnitTotalCount() {
		return minUnitTotalCount;
	}

	public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
		this.minUnitTotalCount = minUnitTotalCount;
	}

	public BigDecimal getSettleMinUnitTotalCount() {
		return settleMinUnitTotalCount;
	}

	public void setSettleMinUnitTotalCount(BigDecimal settleMinUnitTotalCount) {
		this.settleMinUnitTotalCount = settleMinUnitTotalCount;
	}

	public Long getProductOwnerId() {
		return productOwnerId;
	}

	public void setProductOwnerId(Long productOwnerId) {
		this.productOwnerId = productOwnerId;
	}

	public Long getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(Long productSpecId) {
		this.productSpecId = productSpecId;
	}
}