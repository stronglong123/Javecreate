package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("serial")
public class OrderCompleteItemMqDTO implements Serializable {
	// id
	private Long id;
	// oms订单项id
	Long omsOrderItemId;
	// 订单项id
	private Long orderItemId;
	// skuid
	private Long productSkuId;
	// 货主Id
	private Long ownerId;
	// 规格Id
	private Long specificationId;
	// 销售价
	private BigDecimal sellPrice;
	// 销售单位
	private String sellUnit;
	// 销售规格
	private BigDecimal saleSpecQuantity;
	// 规格数量
	private BigDecimal specQuantity;
	// 大单位
	private String packageName;
	// 小单位
	private String unitName;
	// 销售模式
	private Integer saleMode;
	////////////// 金额/////////////////
	// 总金额
	private BigDecimal totalAmount;
	// 应收金额
	private BigDecimal payableAmount;
	// 单位立减
	private BigDecimal reduceProductPrice;
	// 产品立减金额
	private BigDecimal reduceProductAmount;
	// 优惠劵
	private BigDecimal reduceCouponAmount;
	// 红包
	private BigDecimal reduceBonusAmount;
	// 订单项立减
	private BigDecimal reduceOrderAmount;
	// 成本价
	private BigDecimal SupplyCostPrice;
	// 成本价单位
	private String SupplyCostPriceUnit;
	// 小单位成本价
	private BigDecimal unitCostprice;
	////////////// 数量/////////////////
	// 原始购买数量
	private BigDecimal buyCount;
	// 取货数量:客户实收数量
	private BigDecimal takeCount;
	// 实际配送数量:司机发货数量
	private BigDecimal deliveryCount;
	// 延时配送数量 无值
	private BigDecimal delayCount;
	// 退货数量 无值
	private BigDecimal returnCount;
	// 缺货数量 无值
	private BigDecimal lackCount;
	// 小单位总数量
	private BigDecimal minUnitTotalCount;
	//
	private Long omsItemId;
	/**
	 * 订单项总优惠
	 */
	private BigDecimal totalDiscount;
	/**
	 * 订单项原价总金额
	 */
	private BigDecimal originAmount;
	/**
	 * 订单项优惠信息
	 */
	private List<OrderItemDiscountMqDTO> itemDiscounts;
	private List<OrderItemProductOwnerDTO> secOwnerDetail;

	// 关联交易订单ID
	private Long refOrderId;
	// 关联oms订单ID
	private Long refOmsOrderId;
	/**
	 * 关联OMS订单编号
	 */
	private String refOmsorderNo;

	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getRefOrderId() {
		return refOrderId;
	}

	public void setRefOrderId(Long refOrderId) {
		this.refOrderId = refOrderId;
	}

	public Long getRefOmsOrderId() {
		return refOmsOrderId;
	}

	public void setRefOmsOrderId(Long refOmsOrderId) {
		this.refOmsOrderId = refOmsOrderId;
	}

	public String getRefOmsorderNo() {
		return refOmsorderNo;
	}

	public void setRefOmsorderNo(String refOmsorderNo) {
		this.refOmsorderNo = refOmsorderNo;
	}

	private BigDecimal serviceFee;

	@Override
	public String toString() {
		return "OrderCompleteItemMqDTO [id=" + id + ", omsOrderItemId=" + omsOrderItemId + ", orderItemId="
				+ orderItemId + ", productSkuId=" + productSkuId + ", ownerId=" + ownerId + ", specificationId="
				+ specificationId + ", sellPrice=" + sellPrice + ", sellUnit=" + sellUnit + ", saleSpecQuantity="
				+ saleSpecQuantity + ", specQuantity=" + specQuantity + ", packageName=" + packageName + ", unitName="
				+ unitName + ", saleMode=" + saleMode + ", totalAmount=" + totalAmount + ", payableAmount="
				+ payableAmount + ", reduceProductPrice=" + reduceProductPrice + ", reduceProductAmount="
				+ reduceProductAmount + ", reduceCouponAmount=" + reduceCouponAmount + ", reduceBonusAmount="
				+ reduceBonusAmount + ", reduceOrderAmount=" + reduceOrderAmount + ", SupplyCostPrice="
				+ SupplyCostPrice + ", SupplyCostPriceUnit=" + SupplyCostPriceUnit + ", unitCostprice=" + unitCostprice
				+ ", buyCount=" + buyCount + ", takeCount=" + takeCount + ", deliveryCount=" + deliveryCount
				+ ", delayCount=" + delayCount + ", returnCount=" + returnCount + ", lackCount=" + lackCount
				+ ", minUnitTotalCount=" + minUnitTotalCount + ", omsItemId=" + omsItemId + ", secOwnerDetail="
				+ secOwnerDetail + ", serviceFee=" + serviceFee + "]";
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Long getOmsOrderItemId() {
		return omsOrderItemId;
	}

	public void setOmsOrderItemId(Long omsOrderItemId) {
		this.omsOrderItemId = omsOrderItemId;
	}

	public Long getOmsItemId() {
		return omsItemId;
	}

	public void setOmsItemId(Long omsItemId) {
		this.omsItemId = omsItemId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(Long specificationId) {
		this.specificationId = specificationId;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(String sellUnit) {
		this.sellUnit = sellUnit;
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

	public BigDecimal getReduceProductPrice() {
		return reduceProductPrice;
	}

	public void setReduceProductPrice(BigDecimal reduceProductPrice) {
		this.reduceProductPrice = reduceProductPrice;
	}

	public BigDecimal getReduceProductAmount() {
		return reduceProductAmount;
	}

	public void setReduceProductAmount(BigDecimal reduceProductAmount) {
		this.reduceProductAmount = reduceProductAmount;
	}

	public BigDecimal getReduceCouponAmount() {
		return reduceCouponAmount;
	}

	public void setReduceCouponAmount(BigDecimal reduceCouponAmount) {
		this.reduceCouponAmount = reduceCouponAmount;
	}

	public BigDecimal getReduceBonusAmount() {
		return reduceBonusAmount;
	}

	public void setReduceBonusAmount(BigDecimal reduceBonusAmount) {
		this.reduceBonusAmount = reduceBonusAmount;
	}

	public BigDecimal getReduceOrderAmount() {
		return reduceOrderAmount;
	}

	public void setReduceOrderAmount(BigDecimal reduceOrderAmount) {
		this.reduceOrderAmount = reduceOrderAmount;
	}

	public BigDecimal getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(BigDecimal buyCount) {
		this.buyCount = buyCount;
	}

	public BigDecimal getTakeCount() {
		return takeCount;
	}

	public void setTakeCount(BigDecimal takeCount) {
		this.takeCount = takeCount;
	}

	public BigDecimal getDeliveryCount() {
		return deliveryCount;
	}

	public void setDeliveryCount(BigDecimal deliveryCount) {
		this.deliveryCount = deliveryCount;
	}

	public BigDecimal getDelayCount() {
		return delayCount;
	}

	public void setDelayCount(BigDecimal delayCount) {
		this.delayCount = delayCount;
	}

	public BigDecimal getReturnCount() {
		return returnCount;
	}

	public void setReturnCount(BigDecimal returnCount) {
		this.returnCount = returnCount;
	}

	public BigDecimal getLackCount() {
		return lackCount;
	}

	public void setLackCount(BigDecimal lackCount) {
		this.lackCount = lackCount;
	}

	public BigDecimal getMinUnitTotalCount() {
		return minUnitTotalCount;
	}

	public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
		this.minUnitTotalCount = minUnitTotalCount;
	}

	public BigDecimal getSupplyCostPrice() {
		return SupplyCostPrice;
	}

	public void setSupplyCostPrice(BigDecimal supplyCostPrice) {
		SupplyCostPrice = supplyCostPrice;
	}

	public String getSupplyCostPriceUnit() {
		return SupplyCostPriceUnit;
	}

	public void setSupplyCostPriceUnit(String supplyCostPriceUnit) {
		SupplyCostPriceUnit = supplyCostPriceUnit;
	}

	/**
	 * 获取payableAmount
	 * 
	 * @return payableAmount payableAmount
	 */
	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	/**
	 * 设置payableAmount
	 * 
	 * @param payableAmount payableAmount
	 */
	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	/**
	 * 获取unitCostprice
	 * 
	 * @return unitCostprice unitCostprice
	 */
	public BigDecimal getUnitCostprice() {
		return unitCostprice;
	}

	/**
	 * 设置unitCostprice
	 * 
	 * @param unitCostprice unitCostprice
	 */
	public void setUnitCostprice(BigDecimal unitCostprice) {
		this.unitCostprice = unitCostprice;
	}

	/**
	 * 获取secOwnerDetail
	 * 
	 * @return secOwnerDetail secOwnerDetail
	 */
	public List<OrderItemProductOwnerDTO> getSecOwnerDetail() {
		return secOwnerDetail;
	}

	/**
	 * 设置secOwnerDetail
	 * 
	 * @param secOwnerDetail secOwnerDetail
	 */
	public void setSecOwnerDetail(List<OrderItemProductOwnerDTO> secOwnerDetail) {
		this.secOwnerDetail = secOwnerDetail;
	}

	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public BigDecimal getOriginAmount() {
		return originAmount;
	}

	public void setOriginAmount(BigDecimal originAmount) {
		this.originAmount = originAmount;
	}

	public List<OrderItemDiscountMqDTO> getItemDiscounts() {
		return itemDiscounts;
	}

	public void setItemDiscounts(List<OrderItemDiscountMqDTO> itemDiscounts) {
		this.itemDiscounts = itemDiscounts;
	}

}
