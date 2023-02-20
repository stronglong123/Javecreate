package com.common.generate.javacreate.service.impl.es.base;



import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 订单Trace
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单Trace模型")
public class OrderTraceDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "接入应用方code")
	private String partnerCode;

	@ApiParam(description = "阶段描述", required = true)
	private String sectionName;

	@ApiParam(description = "阶段类型", required = true)
	private Integer sectionType;

	@ApiParam(description = "trace描述", required = true)
	private String traceName;

	@ApiParam(description = "trace类型", required = true)
	private Integer traceType;

	@ApiParam(description = "标签")
	private Map<String, Object> tags;

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

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Integer getSectionType() {
		return sectionType;
	}

	public void setSectionType(Integer sectionType) {
		this.sectionType = sectionType;
	}

	public String getTraceName() {
		return traceName;
	}

	public void setTraceName(String traceName) {
		this.traceName = traceName;
	}

	public Integer getTraceType() {
		return traceType;
	}

	public void setTraceType(Integer traceType) {
		this.traceType = traceType;
	}

	public Map<String, Object> getTags() {
		return tags;
	}

	public void setTags(Map<String, Object> tags) {
		this.tags = tags;
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
