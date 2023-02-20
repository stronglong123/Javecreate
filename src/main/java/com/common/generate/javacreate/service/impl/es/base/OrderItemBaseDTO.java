package com.common.generate.javacreate.service.impl.es.base;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单基础明细信息
 *
 * @author Hu Liangzhi
 */
@ApiModel(description = "订单明细模型")
public class OrderItemBaseDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "应用接入方code", required = true)
	private String partnerCode;

	@ApiParam(description = "订单明细id")
	private Long orderItemId;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "产品skuId", required = true)
	private Long productSkuId;

	@ApiParam(description = "产品名", required = true)
	private String productName;

	@ApiParam(description = "产品原始数量", required = true)
	private BigDecimal originalCount;

	@ApiParam(description = "产品实际数量", required = true)
	private BigDecimal count;

	@ApiParam(description = "原始单价", required = true)
	private BigDecimal originalPrice;

	@ApiParam(description = "产品实际单价", required = true)
	private BigDecimal price;

	@ApiParam(description = "价格系数", required = true)
	private BigDecimal priceQuantity;

	@ApiParam(description = "出库数量")
	private BigDecimal outstockCount;

	@ApiParam(description = "配送数量")
	private BigDecimal deliveryCount;

	@ApiParam(description = "实际收货数量")
	private BigDecimal takeCount;

	/**
	 * 1-赠品
	 */
	@ApiParam(description = "是否赠品")
	private Boolean gift;

	@ApiParam(description = "成本单价")
	private BigDecimal cost;

	@ApiParam(description = "销售单位")
	private String saleUnit;

	@ApiParam(description = "销售规格名称")
	private String saleSpec;

	@ApiParam(description = "备注")
	private String remark;

	@ApiParam(description = "创建时间")
	private Date createTime;

	@ApiParam(description = "更新时间")
	private Date lastUpdateTime;

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
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

	public BigDecimal getOriginalCount() {
		return originalCount;
	}

	public void setOriginalCount(BigDecimal originalCount) {
		this.originalCount = originalCount;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceQuantity() {
		return priceQuantity;
	}

	public void setPriceQuantity(BigDecimal priceQuantity) {
		this.priceQuantity = priceQuantity;
	}

	public BigDecimal getOutstockCount() {
		return outstockCount;
	}

	public void setOutstockCount(BigDecimal outstockCount) {
		this.outstockCount = outstockCount;
	}

	public BigDecimal getDeliveryCount() {
		return deliveryCount;
	}

	public void setDeliveryCount(BigDecimal deliveryCount) {
		this.deliveryCount = deliveryCount;
	}

	public BigDecimal getTakeCount() {
		return takeCount;
	}

	public void setTakeCount(BigDecimal takeCount) {
		this.takeCount = takeCount;
	}

	public Boolean getGift() {
		return gift;
	}

	public void setGift(Boolean gift) {
		this.gift = gift;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getSaleUnit() {
		return saleUnit;
	}

	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}

	public String getSaleSpec() {
		return saleSpec;
	}

	public void setSaleSpec(String saleSpec) {
		this.saleSpec = saleSpec;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
