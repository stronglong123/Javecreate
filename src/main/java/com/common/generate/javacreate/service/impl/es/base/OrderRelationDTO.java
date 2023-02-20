package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单关系表
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单关系模型")
public class OrderRelationDTO implements Serializable {
	private static final long serialVersionUID = 8774199265461955211L;

	@ApiParam(description = "应用接入方code", required = true)
    private String partnerCode;

	@ApiParam(description = "源业务id", required = true)
    private Long sourceBusinessId;

	@ApiParam(description = "订单id", required = true)
    private Long orderId;

    /**
	 * 订单关系类型 1-一对一关系，2-一对多关系，3，组合关系
	 */
	@ApiParam(description = "订单关系类型", required = true)
	private Integer type;

	@ApiParam(description = "描述", required = true)
    private String description;

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

	public Long getSourceBusinessId() {
		return sourceBusinessId;
	}

	public void setSourceBusinessId(Long sourceBusinessId) {
		this.sourceBusinessId = sourceBusinessId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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