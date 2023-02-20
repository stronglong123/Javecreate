package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 退货订单信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "退货订单模型")
public class OrderReturnDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "应用接入方code", required = true)
	private String partnerCode;

	@ApiParam(description = "订单id", required = true)
	private Long orderId;

	@ApiParam(description = "关联原订单id", required = true)
	private Long refOrderId;

	@ApiParam(description = "退货金额", required = true)
	private BigDecimal returnAmount;

	@ApiParam(description = "实退金额", required = true)
	private BigDecimal actualReturnAmount;

	@ApiParam(description = "退货原因")
	private String returnReason;

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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getRefOrderId() {
		return refOrderId;
	}

	public void setRefOrderId(Long refOrderId) {
		this.refOrderId = refOrderId;
	}

	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}

	public BigDecimal getActualReturnAmount() {
		return actualReturnAmount;
	}

	public void setActualReturnAmount(BigDecimal actualReturnAmount) {
		this.actualReturnAmount = actualReturnAmount;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
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
