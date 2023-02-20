package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单配送信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单配送信息模型")
public class OrderDeliveryDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "应用方code")
	private String partnerCode;

	@ApiParam(description = "配送方式", required = true)
	private Integer deliveryMode;

	@ApiParam(description = "物流商id")
	private String logisticsId;

	@ApiParam(description = "物流商")
	private String logisticName;

	@ApiParam(description = "配送时间", required = true)
	private Date deliveryTime;

	@ApiParam(description = "配送车辆id")
	private Long deliveryCarId;

	@ApiParam(description = "配送车辆车牌号")
	private String deliveryCarNumber;

	@ApiParam(description = "配送车辆名称")
	private String deliveryCarName;

	@ApiParam(description = "配送员id")
	private Long deliveryUserId;

	@ApiParam(description = "配送员")
	private String deliveryUserName;

	@ApiParam(description = "配送中心id")
	private Long deliveryCenterId;

	@ApiParam(description = "司机应收金额")
	private BigDecimal deliveryPayAbleAmount;

	@ApiParam(description = "司机实收金额")
	private BigDecimal deliveryReceiveAmount;

	@ApiParam(description = "配送费用")
	private BigDecimal deliveryFee;

	@ApiParam(description = "预计送达时间")
	private Date hopeArriveTime;

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

	public Integer getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(Integer deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(String logisticsId) {
		this.logisticsId = logisticsId;
	}

	public String getLogisticName() {
		return logisticName;
	}

	public void setLogisticName(String logisticName) {
		this.logisticName = logisticName;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Long getDeliveryCarId() {
		return deliveryCarId;
	}

	public void setDeliveryCarId(Long deliveryCarId) {
		this.deliveryCarId = deliveryCarId;
	}

	public String getDeliveryCarNumber() {
		return deliveryCarNumber;
	}

	public void setDeliveryCarNumber(String deliveryCarNumber) {
		this.deliveryCarNumber = deliveryCarNumber;
	}

	public String getDeliveryCarName() {
		return deliveryCarName;
	}

	public void setDeliveryCarName(String deliveryCarName) {
		this.deliveryCarName = deliveryCarName;
	}

	public Long getDeliveryUserId() {
		return deliveryUserId;
	}

	public void setDeliveryUserId(Long deliveryUserId) {
		this.deliveryUserId = deliveryUserId;
	}

	public String getDeliveryUserName() {
		return deliveryUserName;
	}

	public void setDeliveryUserName(String deliveryUserName) {
		this.deliveryUserName = deliveryUserName;
	}

	public Long getDeliveryCenterId() {
		return deliveryCenterId;
	}

	public void setDeliveryCenterId(Long deliveryCenterId) {
		this.deliveryCenterId = deliveryCenterId;
	}

	public BigDecimal getDeliveryPayAbleAmount() {
		return deliveryPayAbleAmount;
	}

	public void setDeliveryPayAbleAmount(BigDecimal deliveryPayAbleAmount) {
		this.deliveryPayAbleAmount = deliveryPayAbleAmount;
	}

	public BigDecimal getDeliveryReceiveAmount() {
		return deliveryReceiveAmount;
	}

	public void setDeliveryReceiveAmount(BigDecimal deliveryReceiveAmount) {
		this.deliveryReceiveAmount = deliveryReceiveAmount;
	}

	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Date getHopeArriveTime() {
		return hopeArriveTime;
	}

	public void setHopeArriveTime(Date hopeArriveTime) {
		this.hopeArriveTime = hopeArriveTime;
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
