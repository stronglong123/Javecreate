package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单支付金额信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单金额模型")
public class OrderAmountDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "应用方code")
	private String partnerCode;
	
	@ApiParam(description = "原始订单金额", required = true)
	private BigDecimal originalOrderAmount;

	@ApiParam(description = "订单金额", required = true)
	private BigDecimal orderAmount;

	@ApiParam(description = "原始应付金额", required = true)
	private BigDecimal originalPayableAmount;

	@ApiParam(description = "应付金额", required = true)
	private BigDecimal payableAmount;

	@ApiParam(description = "原始总优惠金额", required = true)
	private BigDecimal originalTotalDiscount;

	@ApiParam(description = "总优惠金额", required = true)
	private BigDecimal totalDiscount;

	@ApiParam(description = "实收金额", required = true)
	private BigDecimal receiveAmount;

	@ApiParam(description = "未收金额", required = true)
	private BigDecimal uncollectedAmount;

	@ApiParam(description = "支付类型")
	private Integer payType;

	@ApiParam(description = "支付类型名")
	private String payTypeName;

	@ApiParam(description = "支付时间")
	private Date payTime;

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

	public BigDecimal getOriginalOrderAmount() {
		return originalOrderAmount;
	}

	public void setOriginalOrderAmount(BigDecimal originalOrderAmount) {
		this.originalOrderAmount = originalOrderAmount;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
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

	public BigDecimal getOriginalTotalDiscount() {
		return originalTotalDiscount;
	}

	public void setOriginalTotalDiscount(BigDecimal originalTotalDiscount) {
		this.originalTotalDiscount = originalTotalDiscount;
	}

	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public BigDecimal getUncollectedAmount() {
		return uncollectedAmount;
	}

	public void setUncollectedAmount(BigDecimal uncollectedAmount) {
		this.uncollectedAmount = uncollectedAmount;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
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
