/**   
 * Copyright © 2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单项完整对象
 * @author: yanpin
 * @date: 2019年10月12日 下午2:35:38
 */
public class OrderItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long orderId;
	private Long businessId;
	private Long businessItemId;
	private Long productSkuId;
	private String productName;
	private BigDecimal saleCount;
	private String sellUnit;
	private String productSaleSpec;
	private String productSpec;
	private BigDecimal saleSpecQuantity;
	private BigDecimal specQuantity;
	private String sellPriceUnit;
	private BigDecimal minUnitTotalCount;
	private BigDecimal sellPrice;
	private BigDecimal totalAmount;
	private BigDecimal payableAmount;
	private BigDecimal deliveryAmount;
	private String packageName;
	private String unitName;
	private String remark;
	private String packageBoxNo;
	private BigDecimal supplyCostPrice;
	private String supplyCostPriceUnit;
	private Long productOwnerId;
	private Long specificationId;
	private BigDecimal originalSaleCount;
	private BigDecimal localOriginalSaleCount;
	private Integer pickSequence;
	private BigDecimal unitCostprice;
	private BigDecimal inventoryCount;
	private String undeliverableReason;
	// oms订单项id;
	private Long omsOrderItemId;
	// 购买数量;
	private BigDecimal buyCount;
	// 发货数量;
	private BigDecimal deliverCount;
	// 退货数量;
	private BigDecimal returnCount;
	// 配送数量;
	private BigDecimal takeCount;
	// 外部单项id;
	private Long orderItemId;
	// 外部单项id;
	private Long opOrderItemId;
	// 货主Id;
	private Long ownerId;
	// 规格Id;
	private Long productSpecificationId;

	@Override
	public String toString() {
		return "OrderItemDTO [id=" + id + ", orderId=" + orderId + ", businessId=" + businessId + ", businessItemId=" + businessItemId + ", productSkuId=" + productSkuId + ", productName=" + productName + ", saleCount=" + saleCount + ", sellUnit=" + sellUnit + ", productSaleSpec=" + productSaleSpec + ", productSpec=" + productSpec + ", saleSpecQuantity=" + saleSpecQuantity + ", specQuantity=" + specQuantity + ", sellPriceUnit=" + sellPriceUnit + ", minUnitTotalCount=" + minUnitTotalCount + ", sellPrice=" + sellPrice + ", totalAmount=" + totalAmount + ", payableAmount=" + payableAmount
				+ ", deliveryAmount=" + deliveryAmount + ", packageName=" + packageName + ", unitName=" + unitName + ", remark=" + remark + ", packageBoxNo=" + packageBoxNo + ", supplyCostPrice=" + supplyCostPrice + ", supplyCostPriceUnit=" + supplyCostPriceUnit + ", productOwnerId=" + productOwnerId + ", specificationId=" + specificationId + ", originalSaleCount=" + originalSaleCount + ", pickSequence=" + pickSequence + ", unitCostprice=" + unitCostprice + ", inventoryCount=" + inventoryCount + ", undeliverableReason=" + undeliverableReason + ", omsOrderItemId=" + omsOrderItemId
				+ ", buyCount=" + buyCount + ", deliverCount=" + deliverCount + ", returnCount=" + returnCount + ", takeCount=" + takeCount + ", orderItemId=" + orderItemId + ", opOrderItemId=" + opOrderItemId + ", ownerId=" + ownerId + ", productSpecificationId=" + productSpecificationId + "]";
	}

	public Long getOmsOrderItemId() {
		return omsOrderItemId;
	}

	public void setOmsOrderItemId(Long omsOrderItemId) {
		this.omsOrderItemId = omsOrderItemId;
	}

	public BigDecimal getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(BigDecimal buyCount) {
		this.buyCount = buyCount;
	}

	public BigDecimal getDeliverCount() {
		return deliverCount;
	}

	public void setDeliverCount(BigDecimal deliverCount) {
		this.deliverCount = deliverCount;
	}

	public BigDecimal getReturnCount() {
		return returnCount;
	}

	public void setReturnCount(BigDecimal returnCount) {
		this.returnCount = returnCount;
	}

	public BigDecimal getTakeCount() {
		return takeCount;
	}

	public void setTakeCount(BigDecimal takeCount) {
		this.takeCount = takeCount;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getProductSpecificationId() {
		return productSpecificationId;
	}

	public void setProductSpecificationId(Long productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getBusinessItemId() {
		return businessItemId;
	}

	public void setBusinessItemId(Long businessItemId) {
		this.businessItemId = businessItemId;
	}

	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(BigDecimal saleCount) {
		this.saleCount = saleCount;
	}

	public String getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(String sellUnit) {
		this.sellUnit = sellUnit;
	}

	public String getProductSaleSpec() {
		return productSaleSpec;
	}

	public void setProductSaleSpec(String productSaleSpec) {
		this.productSaleSpec = productSaleSpec;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

	public BigDecimal getSaleSpecQuantity() {
		return saleSpecQuantity;
	}

	public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
		this.saleSpecQuantity = saleSpecQuantity;
	}

	public BigDecimal getSpecQuantity() {
		return specQuantity;
	}

	public void setSpecQuantity(BigDecimal specQuantity) {
		this.specQuantity = specQuantity;
	}

	public String getSellPriceUnit() {
		return sellPriceUnit;
	}

	public void setSellPriceUnit(String sellPriceUnit) {
		this.sellPriceUnit = sellPriceUnit;
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

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public BigDecimal getDeliveryAmount() {
		return deliveryAmount;
	}

	public void setDeliveryAmount(BigDecimal deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPackageBoxNo() {
		return packageBoxNo;
	}

	public void setPackageBoxNo(String packageBoxNo) {
		this.packageBoxNo = packageBoxNo;
	}

	public BigDecimal getSupplyCostPrice() {
		return supplyCostPrice;
	}

	public void setSupplyCostPrice(BigDecimal supplyCostPrice) {
		this.supplyCostPrice = supplyCostPrice;
	}

	public String getSupplyCostPriceUnit() {
		return supplyCostPriceUnit;
	}

	public void setSupplyCostPriceUnit(String supplyCostPriceUnit) {
		this.supplyCostPriceUnit = supplyCostPriceUnit;
	}

	public Long getProductOwnerId() {
		return productOwnerId;
	}

	public void setProductOwnerId(Long productOwnerId) {
		this.productOwnerId = productOwnerId;
	}

	public Long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(Long specificationId) {
		this.specificationId = specificationId;
	}

	public BigDecimal getOriginalSaleCount() {
		return originalSaleCount;
	}

	public void setOriginalSaleCount(BigDecimal originalSaleCount) {
		this.originalSaleCount = originalSaleCount;
	}

	public Integer getPickSequence() {
		return pickSequence;
	}

	public void setPickSequence(Integer pickSequence) {
		this.pickSequence = pickSequence;
	}

	public BigDecimal getUnitCostprice() {
		return unitCostprice;
	}

	public void setUnitCostprice(BigDecimal unitCostprice) {
		this.unitCostprice = unitCostprice;
	}

	public BigDecimal getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(BigDecimal inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public String getUndeliverableReason() {
		return undeliverableReason;
	}

	public void setUndeliverableReason(String undeliverableReason) {
		this.undeliverableReason = undeliverableReason;
	}

	/**
	 * 获取opOrderItemId
	 * @return opOrderItemId opOrderItemId
	 */
	public Long getOpOrderItemId() {
		return opOrderItemId;
	}

	/**
	 * 设置opOrderItemId
	 * @param opOrderItemId opOrderItemId
	 */
	public void setOpOrderItemId(Long opOrderItemId) {
		this.opOrderItemId = opOrderItemId;
	}

	/**  
	 * 获取localOriginalSaleCount  
	 * @return localOriginalSaleCount localOriginalSaleCount  
	 */  
	public BigDecimal getLocalOriginalSaleCount() {
		return localOriginalSaleCount;
	}

	/**  
	 * 设置localOriginalSaleCount  
	 * @param localOriginalSaleCount localOriginalSaleCount  
	 */
	public void setLocalOriginalSaleCount(BigDecimal localOriginalSaleCount) {
		this.localOriginalSaleCount = localOriginalSaleCount;
	}
}
