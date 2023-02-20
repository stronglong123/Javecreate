package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单明细费用表
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单明细费用模型")
public class OrderItemFeeDTO implements Serializable {
	private static final long serialVersionUID = 5887890758323750031L;

	@ApiParam(description = "应用接入方code", required = true)
    private String partnerCode;

	@ApiParam(description = "订单id")
    private Long orderId;

	@ApiParam(description = "订单明细id")
    private Long orderItemId;

	@ApiParam(description = "费用类型", required = true)
    private Integer feeType;

	@ApiParam(description = "费用类型名", required = true)
    private String feeName;

	@ApiParam(description = "金额正负")
	private Integer plusminus;

	@ApiParam(description = "金额费用", required = true)
    private BigDecimal fee;

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

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public Integer getPlusminus() {
		return plusminus;
	}

	public void setPlusminus(Integer plusminus) {
		this.plusminus = plusminus;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
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