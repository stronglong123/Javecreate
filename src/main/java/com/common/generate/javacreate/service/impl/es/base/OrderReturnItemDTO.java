package com.common.generate.javacreate.service.impl.es.base;


import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单退货明细信息
 * 
 * @author Hu Liangzhi
 *
 */
public class OrderReturnItemDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "id")
	private Long id;

	@ApiParam(description = "应用接入方", required = true)
	private String partnerCode;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "订单明细id")
	private Long orderItemId;

	@ApiParam(description = "原订单id", required = true)
	private Long sourceOrderId;

	@ApiParam(description = "原订单明细id", required = true)
	private Long sourceOrderItemId;

	@ApiParam(description = "退货数量", required = true)
	private BigDecimal returnCount;

	@ApiParam(description = "退货金额", required = true)
	private BigDecimal returnAmount;

	@ApiParam(description = "创建时间")
	private Date createTime;

	@ApiParam(description = "更新时间")
	private Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
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

	public Long getSourceOrderId() {
		return sourceOrderId;
	}

	public void setSourceOrderId(Long sourceOrderId) {
		this.sourceOrderId = sourceOrderId;
	}

	public Long getSourceOrderItemId() {
		return sourceOrderItemId;
	}

	public void setSourceOrderItemId(Long sourceOrderItemId) {
		this.sourceOrderItemId = sourceOrderItemId;
	}

	public BigDecimal getReturnCount() {
		return returnCount;
	}

	public void setReturnCount(BigDecimal returnCount) {
		this.returnCount = returnCount;
	}

	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
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
