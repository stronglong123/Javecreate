package com.common.generate.javacreate.ordercenter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GroupSettleOrderBillInsertDTO implements Serializable {

	private static final long serialVersionUID = -3606179379894037959L;
	private String orgId;

	private String settleOrderId;

	private String businessNo;

	private String orderId;

	private String orderItemId;

	private String orderType;

	private String skuId;

	private String skuName;

	private String productSaleSpec;

	private String saleSpecQuantity;

	private String sellUnit;

	private String orderPrice;

	private String orderAmount;

	private String originalMinUnitTotalCount;

	private String minUnitTotalCount;

	private String settleMinUnitTotalCount;

	private String productOwnerId;

	private String productSpecId;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSettleOrderId() {
		return settleOrderId;
	}

	public void setSettleOrderId(String settleOrderId) {
		this.settleOrderId = settleOrderId;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
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

	public String getSaleSpecQuantity() {
		return saleSpecQuantity;
	}

	public void setSaleSpecQuantity(String saleSpecQuantity) {
		this.saleSpecQuantity = saleSpecQuantity;
	}

	public String getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(String sellUnit) {
		this.sellUnit = sellUnit;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOriginalMinUnitTotalCount() {
		return originalMinUnitTotalCount;
	}

	public void setOriginalMinUnitTotalCount(String originalMinUnitTotalCount) {
		this.originalMinUnitTotalCount = originalMinUnitTotalCount;
	}

	public String getMinUnitTotalCount() {
		return minUnitTotalCount;
	}

	public void setMinUnitTotalCount(String minUnitTotalCount) {
		this.minUnitTotalCount = minUnitTotalCount;
	}

	public String getSettleMinUnitTotalCount() {
		return settleMinUnitTotalCount;
	}

	public void setSettleMinUnitTotalCount(String settleMinUnitTotalCount) {
		this.settleMinUnitTotalCount = settleMinUnitTotalCount;
	}

	public String getProductOwnerId() {
		return productOwnerId;
	}

	public void setProductOwnerId(String productOwnerId) {
		this.productOwnerId = productOwnerId;
	}

	public String getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(String productSpecId) {
		this.productSpecId = productSpecId;
	}
}