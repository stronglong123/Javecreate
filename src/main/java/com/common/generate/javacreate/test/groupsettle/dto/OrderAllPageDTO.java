package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单查询分页
 * @author: tangkun
 * @date: 2018年3月27日 下午4:06:04
 */
public class OrderAllPageDTO implements Serializable {
	private static final long serialVersionUID = -1226432272869985204L;
	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 城市ID
	 */
	private Integer orgId;
	/**
	 * 下单城市
	 */
	private Integer fromCityId;
	/**
	 * 下单城市名称
	 */
	private String fromCityName;
	/**
	 * 仓库ID
	 */
	private Integer warehouseId;
	/**
	 * 业务单据ID，外部
	 */
	private Long businessId;
	/**
	 * 业务单据号
	 */
	private String businessNo;
	/**
	 * 业务单据类型
	 */
	private Byte businessType;
	/**
	 * 下单时间
	 */
	private String orderCreateTime;
	/**
	 * 完成时间
	 */
	private String orderCompleteTime;
	/**
	 * 最后更新时间
	 */
	private String lastUpdateTime;
	/**
	 * 配送时间
	 */
	private String deliveryTime;
	/**
	 * 单据类型
	 */
	private Byte orderType;
	/**
	 * 单据类型名称
	 */
	private String orderTypeName;
	/**
	 * 单据状态
	 */
	private Byte state;
	/**
	 * 单据状态
	 */
	private String stateName;
	/**
	 * 应付金额
	 */
	private BigDecimal payableAmount;
	/**
	 * 收货人
	 */
	private String contact;
	/**
	 * 收货人电话
	 */
	private String contactPhone;
	/**
	 * 收货人公司
	 */
	private String contactCompanyName;
	/**
	 * 收货人地址
	 */
	private String detailAddress;
	private BigDecimal consignorLatitude;
	private BigDecimal consignorLongitude;
	/**
	 * 地址ID
	 */
	private Integer addressId;
	/**
	 * 配送方式
	 */
	private Byte deliveryMode;
	/**
	 * 物流费用
	 */
	private BigDecimal deliveryFee;
	private Integer userId;
	/**
	 * 经纪人名称
	 */
	private String salesManName;
	private Integer salesManId;
	private String city;
	private String county;
	private String province;
	private String street;
	/**
	 * 线路名
	 */
	private String routingName;
	private BigDecimal driverOrderAmount;
	private BigDecimal discountAmount;
	/**
	 * 明细
	 */
	private List<OrderPageItemDTO> items;
	/**
	 * 收货地址经纬度
	 */
	private BigDecimal contactLongitude;
	/**
	 * 收货地址经纬度
	 */
	private BigDecimal contactLatitude;

	/**
	 * 备注
	 */
	private String remark;
	
	/** 公司编码 */
	private String companyCode;
	
	/**
	 * 拣货标识 true--已拣货 false-未拣货
	 */
	private Boolean pickMark;
	/**
	 * 打印次数
	 */
	private Integer printCount;
	/**
	 * 支付日期
	 */
	private Date payTime;
	
	private Byte allotType;

	/**
	 * 订单来源
	 */
	private Integer orderSource;

	private String createTime;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}
	
	
	public Byte getAllotType() {
		return allotType;
	}

	public void setAllotType(Byte allotType) {
		this.allotType = allotType;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}

	public String getOrderCompleteTime() {
		return orderCompleteTime;
	}

	public void setOrderCompleteTime(String orderCompleteTime) {
		this.orderCompleteTime = orderCompleteTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public List<OrderPageItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderPageItemDTO> items) {
		this.items = items;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getDriverOrderAmount() {
		return driverOrderAmount;
	}

	public void setDriverOrderAmount(BigDecimal driverOrderAmount) {
		this.driverOrderAmount = driverOrderAmount;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getSalesManId() {
		return salesManId;
	}

	public void setSalesManId(Integer salesManId) {
		this.salesManId = salesManId;
	}

	public String getSalesManName() {
		return salesManName;
	}

	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getConsignorLatitude() {
		return consignorLatitude;
	}

	public void setConsignorLatitude(BigDecimal consignorLatitude) {
		this.consignorLatitude = consignorLatitude;
	}

	public BigDecimal getConsignorLongitude() {
		return consignorLongitude;
	}

	public void setConsignorLongitude(BigDecimal consignorLongitude) {
		this.consignorLongitude = consignorLongitude;
	}

	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Byte getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(Byte deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getFromCityId() {
		return fromCityId;
	}

	public void setFromCityId(Integer fromCityId) {
		this.fromCityId = fromCityId;
	}

	public String getFromCityName() {
		return fromCityName;
	}

	public void setFromCityName(String fromCityName) {
		this.fromCityName = fromCityName;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public Byte getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Byte businessType) {
		this.businessType = businessType;
	}

	public String getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(String orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	public String getOrderTypeName() {
		return orderTypeName;
	}

	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactCompanyName() {
		return contactCompanyName;
	}

	public void setContactCompanyName(String contactCompanyName) {
		this.contactCompanyName = contactCompanyName;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	/**
	 * 获取routingName
	 * @return routingName routingName
	 */
	public String getRoutingName() {
		return routingName;
	}

	/**
	 * 设置routingName
	 * @param routingName routingName
	 */
	public void setRoutingName(String routingName) {
		this.routingName = routingName;
	}

	public BigDecimal getContactLongitude() {
		return contactLongitude;
	}

	public void setContactLongitude(BigDecimal contactLongitude) {
		this.contactLongitude = contactLongitude;
	}

	public BigDecimal getContactLatitude() {
		return contactLatitude;
	}

	public void setContactLatitude(BigDecimal contactLatitude) {
		this.contactLatitude = contactLatitude;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Boolean getPickMark() {
		return pickMark;
	}

	public void setPickMark(Boolean pickMark) {
		this.pickMark = pickMark;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "OrderAllPageDTO [orderId=" + orderId + ", orgId=" + orgId + ", fromCityId=" + fromCityId
				+ ", fromCityName=" + fromCityName + ", warehouseId=" + warehouseId + ", businessId=" + businessId
				+ ", businessNo=" + businessNo + ", businessType=" + businessType + ", orderCreateTime="
				+ orderCreateTime + ", orderCompleteTime=" + orderCompleteTime + ", lastUpdateTime=" + lastUpdateTime
				+", orderType=" + orderType + ", orderTypeName=" + orderTypeName + ", state=" + state + ", stateName="
				+ stateName + ", payableAmount=" + payableAmount + ", contact=" + contact + ", contactPhone="
				+ contactPhone + ", contactCompanyName=" + contactCompanyName + ", detailAddress=" + detailAddress
				+ ", consignorLatitude=" + consignorLatitude + ", consignorLongitude=" + consignorLongitude
				+ ", addressId=" + addressId + ", deliveryMode=" + deliveryMode + ", deliveryFee=" + deliveryFee
				+ ", userId=" + userId + ", salesManName=" + salesManName + ", salesManId=" + salesManId + ", city="
				+ city + ", county=" + county + ", province=" + province + ", street=" + street + ", routingName="
				+ routingName + ", driverOrderAmount=" + driverOrderAmount + ", discountAmount=" + discountAmount
				+ ", items=" + items + ", contactLongitude=" + contactLongitude + ", contactLatitude=" + contactLatitude
				+ ", remark=" + remark + ", companyCode=" + companyCode + ", pickMark=" + pickMark + "]";
	}

	
	
}
