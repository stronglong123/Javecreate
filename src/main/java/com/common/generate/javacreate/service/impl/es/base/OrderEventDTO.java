package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单事件
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单事件模型")
public class OrderEventDTO implements Serializable {

	private static final long serialVersionUID = 8260654272942684479L;

	@ApiParam(description = "应用接入方code", required = true)
	private String partnerCode;

	@ApiParam(description = "订单id", required = true)
	private Long orderId;

	@ApiParam(description = "事件类型", required = true)
	private String eventType;

	@ApiParam(description = "事件发送时间", required = true)
	private Date eventTime;

	@ApiParam(description = "流程id", required = true)
	private String flowId;

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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
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
