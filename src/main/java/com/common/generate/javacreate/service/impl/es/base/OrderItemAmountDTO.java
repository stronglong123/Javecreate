package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单金额信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单金额模型")
public class OrderItemAmountDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "应用接入方code")
	private String partnerCode;

	@ApiParam(description = "订单明细id")
	private Long orderItemId;

	@ApiParam(description = "原始订单金额", required = true)
	private BigDecimal originalOrderItemAmount;

	@ApiParam(description = "订单金额", required = true)
	private BigDecimal orderItemAmount;

	@ApiParam(description = "原始应付金额", required = true)
	private BigDecimal originalPayableAmount;

	@ApiParam(description = "应付金额", required = true)
	private BigDecimal payableAmount;

	@ApiParam(description = "原始优惠金额", required = true)
	private BigDecimal originalDiscount;

	@ApiParam(description = "优惠金额", required = true)
	private BigDecimal discount;

	@ApiParam(description = "创建时间")
	private Date createTime;

	@ApiParam(description = "更新时间")
	private Date lastUpdateTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

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

	public BigDecimal getOriginalOrderItemAmount() {
		return originalOrderItemAmount;
	}

	public void setOriginalOrderItemAmount(BigDecimal originalOrderItemAmount) {
		this.originalOrderItemAmount = originalOrderItemAmount;
	}

	public BigDecimal getOrderItemAmount() {
		return orderItemAmount;
	}

	public void setOrderItemAmount(BigDecimal orderItemAmount) {
		this.orderItemAmount = orderItemAmount;
	}

	public BigDecimal getOriginalPayableAmount() {
		return originalPayableAmount;
	}

	public void setOriginalPayableAmount(BigDecimal originalPayableAmount) {
		this.originalPayableAmount = originalPayableAmount;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public BigDecimal getOriginalDiscount() {
		return originalDiscount;
	}

	public void setOriginalDiscount(BigDecimal originalDiscount) {
		this.originalDiscount = originalDiscount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
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
