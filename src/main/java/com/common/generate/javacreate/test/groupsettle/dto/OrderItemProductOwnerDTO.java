/**   
 * Copyright © 2020 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: yanpin
 * @date: 2020年9月8日 上午11:44:25
 */
public class OrderItemProductOwnerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long omsOrderId;
	private Long omsOrderItemId;
	private Long secProductOwnerId;
	private String erpSecProductOwnerId;
	private Long specId;
	private Long ownerId;
	private BigDecimal count;
	private BigDecimal dispatchCount;
	private BigDecimal addCount;
	private Long productSkuId;
	private BigDecimal saleSpecQuantity;
	private String secOwnerId;
	/**
	 * 总金额
	 */
	private BigDecimal totalAmount;
	private BigDecimal price;

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSecOwnerId() {
		return secOwnerId;
	}

	public void setSecOwnerId(String secOwnerId) {
		this.secOwnerId = secOwnerId;
	}

	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
	}

	public BigDecimal getSaleSpecQuantity() {
		return saleSpecQuantity;
	}

	public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
		this.saleSpecQuantity = saleSpecQuantity;
	}

	@Override
	public String toString() {
		return "OrderItemProductOwnerDTO [id=" + id + ", omsOrderId=" + omsOrderId + ", omsOrderItemId=" + omsOrderItemId + ", secProductOwnerId=" + secProductOwnerId + ", erpSecProductOwnerId=" + erpSecProductOwnerId + ", specId=" + specId + ", ownerId=" + ownerId + ", count=" + count + ", dispatchCount=" + dispatchCount + ", addCount=" + addCount + ", productSkuId=" + productSkuId + ", saleSpecQuantity=" + saleSpecQuantity + ", secOwnerId=" + secOwnerId + ", totalAmount=" + totalAmount + ", price=" + price + "]";
	}

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOmsOrderId() {
		return omsOrderId;
	}

	public void setOmsOrderId(Long omsOrderId) {
		this.omsOrderId = omsOrderId;
	}

	public Long getOmsOrderItemId() {
		return omsOrderItemId;
	}

	public void setOmsOrderItemId(Long omsOrderItemId) {
		this.omsOrderItemId = omsOrderItemId;
	}

	public Long getSecProductOwnerId() {
		return secProductOwnerId;
	}

	public void setSecProductOwnerId(Long secProductOwnerId) {
		this.secProductOwnerId = secProductOwnerId;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	/**
	 * 获取erpSecProductOwnerId
	 * @return erpSecProductOwnerId erpSecProductOwnerId
	 */
	public String getErpSecProductOwnerId() {
		return erpSecProductOwnerId;
	}

	/**
	 * 设置erpSecProductOwnerId
	 * @param erpSecProductOwnerId erpSecProductOwnerId
	 */
	public void setErpSecProductOwnerId(String erpSecProductOwnerId) {
		this.erpSecProductOwnerId = erpSecProductOwnerId;
	}

	/**
	 * 获取addCount
	 * @return addCount addCount
	 */
	public BigDecimal getAddCount() {
		return addCount;
	}

	/**
	 * 设置addCount
	 * @param addCount addCount
	 */
	public void setAddCount(BigDecimal addCount) {
		this.addCount = addCount;
	}

	/**
	 * 获取dispatchCount
	 * @return dispatchCount dispatchCount
	 */
	public BigDecimal getDispatchCount() {
		return dispatchCount;
	}

	/**
	 * 设置dispatchCount
	 * @param dispatchCount dispatchCount
	 */
	public void setDispatchCount(BigDecimal dispatchCount) {
		this.dispatchCount = dispatchCount;
	}
}
