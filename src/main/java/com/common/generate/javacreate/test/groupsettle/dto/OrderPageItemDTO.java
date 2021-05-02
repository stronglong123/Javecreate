package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单查询分页明细
 * @author: tangkun
 * @date: 2018年3月27日 下午4:06:04
 */
public class OrderPageItemDTO implements Serializable {
	private static final long serialVersionUID = -1226432272869985204L;
	private Long orderItemId;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 产品ID
	 */
	private Long productSkuId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 销售数量
	 */
	private BigDecimal saleCount;
	/**
	 * 销售单位
	 */
	private String sellUnit;
	/**
	 * 销售规格名称
	 */
	private String productSaleSpec;
	/**
	 * 包装规格名称
	 */
	private String productSpec;
	/**
	 * 销售规格系数
	 */
	private BigDecimal saleSpecQuantity;
	/**
	 * 包装规格系数
	 */
	private BigDecimal specQuantity;
	/**
	 * 销售价格单位
	 */
	private String sellPriceUnit;
	/**
	 * 销售数量小单位
	 */
	private BigDecimal minUnitTotalCount;
	/**
	 * 销售单价
	 */
	private BigDecimal sellPrice;
	/**
	 * 金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 应付金额
	 */
	private BigDecimal payableAmount;
	/**
	 * 配送费用
	 */
	private BigDecimal deliveryAmount;
	/**
	 * 大单位
	 */
	private String packageName;
	/**
	 * 小单位
	 */
	private String unitName;
	/**
	 * 条形码
	 */
	private String boxCode;
	/**
	 * 交易id
	 */
	private Long businessItemId;
	/**
	 * 原始数量
	 */
	private BigDecimal originalSaleCount;


	private List<SettleOrderItemSecOwnerDTO> itemDetails;

	public Long getBusinessItemId() {
		return businessItemId;
	}

	public void setBusinessItemId(Long businessItemId) {
		this.businessItemId = businessItemId;
	}

	public BigDecimal getOriginalSaleCount() {
		return originalSaleCount;
	}

	public void setOriginalSaleCount(BigDecimal originalSaleCount) {
		this.originalSaleCount = originalSaleCount;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	@Override
	public String toString() {
		return "OrderPageItemDTO [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productSkuId=" + productSkuId + ", productName=" + productName + ", saleCount=" + saleCount + ", sellUnit=" + sellUnit + ", productSaleSpec=" + productSaleSpec + ", productSpec=" + productSpec + ", saleSpecQuantity=" + saleSpecQuantity + ", specQuantity=" + specQuantity + ", sellPriceUnit=" + sellPriceUnit + ", minUnitTotalCount=" + minUnitTotalCount + ", sellPrice=" + sellPrice + ", totalAmount=" + totalAmount + ", payableAmount=" + payableAmount + ", deliveryAmount=" + deliveryAmount
				+ ", packageName=" + packageName + ", unitName=" + unitName + "]";
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public List<SettleOrderItemSecOwnerDTO> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<SettleOrderItemSecOwnerDTO> itemDetails) {
		this.itemDetails = itemDetails;
	}
}
