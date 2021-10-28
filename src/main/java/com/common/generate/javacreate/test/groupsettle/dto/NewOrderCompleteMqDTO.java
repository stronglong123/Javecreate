package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class NewOrderCompleteMqDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 订单项列表
	private List<OrderCompleteItemMqDTO> items;
	/**
	 * 收款批次号
	 */
	private String batchNo;
	// oms_id
	private Long id;
	// oms_id
	private Long omsOrderId;
	private String allotOrderId;
	private String sysRemark;
	// 订单id
	private Long orderId;
	// 订单编号
	private String orderNo;
	// 供应链订单类型
	private Byte orderType;
	// 供应链订单类型
	private Byte businessType;
	// 是否自提
	private Boolean selfPickup;
	// 城市id
	private Integer orgId;
	// 仓库id
	private Integer warehouseId;
	// 仓库类型
	private Integer warehouseType;
	// 订单完成时间yyyy-MM-dd
	private String orderCompleteTime;
	////////// 金额//////////////
	// 支付类型
	private Byte payType;
	private Byte omsPayType;
	// 订单金额
	private BigDecimal orderAmount;
	// 应付金额
	private BigDecimal payableAmount;
	// 服务费,经销商直配专用
	private BigDecimal serviceFee;
	// 立减金额
	private BigDecimal reduceAmount;
	// 产品立减金额
	private BigDecimal productReduceAmount;
	// 优惠劵金额
	private BigDecimal useCouponAmount;
	// 红包金额
	private BigDecimal useBonusAmount;
	// 抹零金额
	private BigDecimal orderOddAmount;
	// 后续抹零金额
	private BigDecimal laterRemoveAmount;
	// 司机应收金额
	private BigDecimal driverOrderAmount;
	///////////// 配送///////////
	// 配送车辆
	private Long deliveryCarId;
	// 配送车辆名称
	private String deliveryCarName;
	// 配送状态
	private Byte deliveryState;
	// 配送状态
	private Byte state;
	// 配送员
	private Integer deliveryUserId;
	// 配送员
	private String deliveryUserName;
	// 装卸工
	private Integer stevedoreUserId;
	// 装卸工
	private String stevedoreUserName;
	// 会员id
	private Integer userId;
	// 经纪人
	private Integer salesmanId;
	// 配送模式
	private Byte deliveryMode;
	////////// 支付信息//////////
	// 支付宝支付金额
	private BigDecimal alipayAmount;
	// 银行卡付款金额（bankAmount + posAmount）
	private BigDecimal bankAmount;
	// 现金金额 + 其他金额
	private BigDecimal cashAmount;
	// 微信金额
	private BigDecimal weiXinAmount;
	// 若是退货
	// 经销商ID
	private Long shopId;
	// 关联交易订单ID
	private Long refOrderId;
	// 关联oms订单ID
	private Long refOmsOrderId;
	/**
	 * 关联OMS订单编号
	 */
	private String refOmsorderNo;
	// 拣货方式
	private Byte pickType;
	// 退货单来源,默认酒批,供应链先下退货的,会改成10
	private Byte orderSource = 0;
	// orderextensions.ordersource
	private Byte omsOrderSource;
	// 配送费
	private BigDecimal deliveryFee;
	private String companyCode;
	/**
	 * 是否联合仓订单 0否1是
	 */
	private Integer lhcType;
	/**
	 * 是否联合仓订单 1是
	 */
	private Integer lhcFrontPosition;

	@Override
	public String toString() {
		return "NewOrderCompleteMqDTO [items=" + items + ", batchNo=" + batchNo + ", id=" + id + ", omsOrderId=" + omsOrderId + ", allotOrderId=" + allotOrderId + ", sysRemark=" + sysRemark + ", orderId=" + orderId + ", orderNo=" + orderNo + ", orderType=" + orderType + ", businessType=" + businessType + ", selfPickup=" + selfPickup + ", orgId=" + orgId + ", warehouseId=" + warehouseId + ", warehouseType=" + warehouseType + ", orderCompleteTime=" + orderCompleteTime + ", payType=" + payType + ", omsPayType=" + omsPayType + ", orderAmount=" + orderAmount + ", payableAmount=" + payableAmount
				+ ", serviceFee=" + serviceFee + ", reduceAmount=" + reduceAmount + ", productReduceAmount=" + productReduceAmount + ", useCouponAmount=" + useCouponAmount + ", useBonusAmount=" + useBonusAmount + ", orderOddAmount=" + orderOddAmount + ", laterRemoveAmount=" + laterRemoveAmount + ", driverOrderAmount=" + driverOrderAmount + ", deliveryCarId=" + deliveryCarId + ", deliveryCarName=" + deliveryCarName + ", deliveryState=" + deliveryState + ", state=" + state + ", deliveryUserId=" + deliveryUserId + ", deliveryUserName=" + deliveryUserName + ", stevedoreUserId=" + stevedoreUserId
				+ ", stevedoreUserName=" + stevedoreUserName + ", userId=" + userId + ", salesmanId=" + salesmanId + ", deliveryMode=" + deliveryMode + ", alipayAmount=" + alipayAmount + ", bankAmount=" + bankAmount + ", cashAmount=" + cashAmount + ", weiXinAmount=" + weiXinAmount + ", shopId=" + shopId + ", refOrderId=" + refOrderId + ", refOmsOrderId=" + refOmsOrderId + ", refOmsorderNo=" + refOmsorderNo + ", pickType=" + pickType + ", orderSource=" + orderSource + ", omsOrderSource=" + omsOrderSource + ", deliveryFee=" + deliveryFee + ", companyCode=" + companyCode + ", lhcType=" + lhcType
				+ "]";
	}

	public Integer getLhcFrontPosition() {
		return lhcFrontPosition;
	}

	public void setLhcFrontPosition(Integer lhcFrontPosition) {
		this.lhcFrontPosition = lhcFrontPosition;
	}

	public Integer getLhcType() {
		return lhcType;
	}

	public void setLhcType(Integer lhcType) {
		this.lhcType = lhcType;
	}


	public Byte getOrderSource() {
		return orderSource;
	}

	public Byte getOmsPayType() {
		return omsPayType;
	}

	public void setOmsPayType(Byte omsPayType) {
		this.omsPayType = omsPayType;
	}

	public void setOrderSource(Byte orderSource) {
		this.orderSource = orderSource;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getRefOrderId() {
		return refOrderId;
	}

	public void setRefOrderId(Long refOrderId) {
		this.refOrderId = refOrderId;
	}

	public List<OrderCompleteItemMqDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderCompleteItemMqDTO> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getOrderCompleteTime() {
		return orderCompleteTime;
	}

	public void setOrderCompleteTime(String orderCompleteTime) {
		this.orderCompleteTime = orderCompleteTime;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public BigDecimal getReduceAmount() {
		return reduceAmount;
	}

	public void setReduceAmount(BigDecimal reduceAmount) {
		this.reduceAmount = reduceAmount;
	}

	public BigDecimal getProductReduceAmount() {
		return productReduceAmount;
	}

	public void setProductReduceAmount(BigDecimal productReduceAmount) {
		this.productReduceAmount = productReduceAmount;
	}

	public BigDecimal getUseCouponAmount() {
		return useCouponAmount;
	}

	public void setUseCouponAmount(BigDecimal useCouponAmount) {
		this.useCouponAmount = useCouponAmount;
	}

	public BigDecimal getUseBonusAmount() {
		return useBonusAmount;
	}

	public void setUseBonusAmount(BigDecimal useBonusAmount) {
		this.useBonusAmount = useBonusAmount;
	}

	public BigDecimal getOrderOddAmount() {
		return orderOddAmount;
	}

	public void setOrderOddAmount(BigDecimal orderOddAmount) {
		this.orderOddAmount = orderOddAmount;
	}

	public Long getDeliveryCarId() {
		return deliveryCarId;
	}

	public void setDeliveryCarId(Long deliveryCarId) {
		this.deliveryCarId = deliveryCarId;
	}

	public String getDeliveryCarName() {
		return deliveryCarName;
	}

	public void setDeliveryCarName(String deliveryCarName) {
		this.deliveryCarName = deliveryCarName;
	}

	public Byte getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(Byte deliveryState) {
		this.deliveryState = deliveryState;
	}

	public Integer getDeliveryUserId() {
		return deliveryUserId;
	}

	public void setDeliveryUserId(Integer deliveryUserId) {
		this.deliveryUserId = deliveryUserId;
	}

	public String getDeliveryUserName() {
		return deliveryUserName;
	}

	public void setDeliveryUserName(String deliveryUserName) {
		this.deliveryUserName = deliveryUserName;
	}

	public Integer getStevedoreUserId() {
		return stevedoreUserId;
	}

	public void setStevedoreUserId(Integer stevedoreUserId) {
		this.stevedoreUserId = stevedoreUserId;
	}

	public String getStevedoreUserName() {
		return stevedoreUserName;
	}

	public void setStevedoreUserName(String stevedoreUserName) {
		this.stevedoreUserName = stevedoreUserName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

	public Byte getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(Byte deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public BigDecimal getAlipayAmount() {
		return alipayAmount;
	}

	public void setAlipayAmount(BigDecimal alipayAmount) {
		this.alipayAmount = alipayAmount;
	}

	public BigDecimal getBankAmount() {
		return bankAmount;
	}

	public void setBankAmount(BigDecimal bankAmount) {
		this.bankAmount = bankAmount;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BigDecimal getWeiXinAmount() {
		return weiXinAmount;
	}

	public void setWeiXinAmount(BigDecimal weiXinAmount) {
		this.weiXinAmount = weiXinAmount;
	}

	public BigDecimal getDriverOrderAmount() {
		return driverOrderAmount;
	}

	public void setDriverOrderAmount(BigDecimal driverOrderAmount) {
		this.driverOrderAmount = driverOrderAmount;
	}

	/**
	 * 获取allotOrderId
	 * @return allotOrderId allotOrderId
	 */
	public String getAllotOrderId() {
		return allotOrderId;
	}

	/**
	 * 设置allotOrderId
	 * @param allotOrderId allotOrderId
	 */
	public void setAllotOrderId(String allotOrderId) {
		this.allotOrderId = allotOrderId;
	}

	public Byte getPickType() {
		return pickType;
	}

	public void setPickType(Byte pickType) {
		this.pickType = pickType;
	}

	/**
	 * 获取state
	 * @return state state
	 */
	public Byte getState() {
		return state;
	}

	/**
	 * 设置state
	 * @param state state
	 */
	public void setState(Byte state) {
		this.state = state;
	}

	/**
	 * 获取businessType
	 * @return businessType businessType
	 */
	public Byte getBusinessType() {
		return businessType;
	}

	/**
	 * 设置businessType
	 * @param businessType businessType
	 */
	public void setBusinessType(Byte businessType) {
		this.businessType = businessType;
	}

	public Integer getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(Integer warehouseType) {
		this.warehouseType = warehouseType;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Byte getPayType() {
		return payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	/**
	 * 获取omsOrderId
	 * @return omsOrderId omsOrderId
	 */
	public Long getOmsOrderId() {
		return omsOrderId;
	}

	/**
	 * 设置omsOrderId
	 * @param omsOrderId omsOrderId
	 */
	public void setOmsOrderId(Long omsOrderId) {
		this.omsOrderId = omsOrderId;
	}

	/**
	 * 获取selfPickup
	 * @return selfPickup selfPickup
	 */
	public Boolean getSelfPickup() {
		return selfPickup;
	}

	/**
	 * 设置selfPickup
	 * @param selfPickup selfPickup
	 */
	public void setSelfPickup(Boolean selfPickup) {
		this.selfPickup = selfPickup;
	}

	/**
	 * 获取sysRemark
	 * @return sysRemark sysRemark
	 */
	public String getSysRemark() {
		return sysRemark;
	}

	/**
	 * 设置sysRemark
	 * @param sysRemark sysRemark
	 */
	public void setSysRemark(String sysRemark) {
		this.sysRemark = sysRemark;
	}

	/**
	 * 获取refOmsOrderId
	 * @return refOmsOrderId refOmsOrderId
	 */
	public Long getRefOmsOrderId() {
		return refOmsOrderId;
	}

	/**
	 * 设置refOmsOrderId
	 * @param refOmsOrderId refOmsOrderId
	 */
	public void setRefOmsOrderId(Long refOmsOrderId) {
		this.refOmsOrderId = refOmsOrderId;
	}

	public String getRefOmsorderNo() {
		return refOmsorderNo;
	}

	public void setRefOmsorderNo(String refOmsorderNo) {
		this.refOmsorderNo = refOmsorderNo;
	}

	/**
	 * 获取deliveryFee
	 * @return deliveryFee deliveryFee
	 */
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	/**
	 * 设置deliveryFee
	 * @param deliveryFee deliveryFee
	 */
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	/**
	 * 获取omsOrderSource
	 * @return omsOrderSource omsOrderSource
	 */
	public Byte getOmsOrderSource() {
		return omsOrderSource;
	}

	/**
	 * 设置omsOrderSource
	 * @param omsOrderSource omsOrderSource
	 */
	public void setOmsOrderSource(Byte omsOrderSource) {
		this.omsOrderSource = omsOrderSource;
	}

	/**
	 * 获取companyCode
	 * @return companyCode companyCode
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * 设置companyCode
	 * @param companyCode companyCode
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * 获取serviceFee
	 * @return serviceFee serviceFee
	 */
	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	/**
	 * 设置serviceFee
	 * @param serviceFee serviceFee
	 */
	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public BigDecimal getLaterRemoveAmount() {
		return laterRemoveAmount;
	}

	public void setLaterRemoveAmount(BigDecimal laterRemoveAmount) {
		this.laterRemoveAmount = laterRemoveAmount;
	}

	
}
