package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

//批次销售单新增模型
public class OrderAddDTO implements Serializable {
	private static final long serialVersionUID = 7807453131207341190L;


	private Long orderId;

	//订单号", required = true)
	//(message = "订单号不能为空")
	private String orderNo;

	//批次id")
	private Long orderBatchId;

	//订单状态", required = true)
	//(message = "订单状态不能为空")
	private Integer state;

	//系统备注")
	private String sysRemark;

	//期望送货时间")
	private Date hopeDeliveryTime;

	//下单时间", required = true)
	//(message = "下单时间不能为空")
	private Date orderCreateTime;

	//用户ID", required = true)
	//(message = "用户ID不能为空")
	private Integer userId;

	//城市ID", required = true)
	//(message = "城市ID不能为空")
	private Long cityId;

	//客户名称", required = true)
	//(message = "客户名称不能为空")
	private String userName;

	//客户店铺名", required = true)
	//(message = "客户店铺名不能为空")
	private String userCompanyName;

	//用户备注")
	private String userRemark;

	//用户类型")
	private String userClassName;

	//客户电话")
	private String userMobileNo;

	//订单配送地址id", required = true)
	//(message = "订单配送地址Id不能为空")
	private Integer addressId;

	//省", required = true)
	//(message = "收货地址-省 不能为空")
	private String province;

	//市", required = true)
	//(message = "收货地址-市 不能为空")
	private String city;

	//区、县", required = true)
	//(message = "收货地址-区县 不能为空")
	private String county;

	//街道")
	private String street;

	//详细地址")
	private String detailAddress;

	//收货地址纬度")
	private BigDecimal latitude;

	//收货地址经度")
	private BigDecimal longitude;

	//收货人", required = true)
	//(message = "收货人不能为空")
	private String contact;

	//收货人电话", required = true)
	//(message = "收货人电话不能为空")
	private String phone;

	//赠送优惠券总金额")
	private BigDecimal giveCouponAmount;

	//赠送红包总金额")
	private BigDecimal giveBonusAmount;

	//下单金额", required = true)
	//(message = "下单金额 不能为空")
	private BigDecimal orderAmount;

	//订单满减")
	private BigDecimal reduceAmount;

	//红包使用金额")
	private BigDecimal useBonusAmount;

	//立减合计")
	private BigDecimal productReduceAmount;

	//优惠券使用金额")
	private BigDecimal useCouponAmount;

	//应付金额", required = true)
	//(message = "应付金额 不能为空")
	private BigDecimal payableAmount;

	//订单明细", required = true)
	//(message = "订单明细不能为空")
	private List<OrderItemAddDTO> items;

	//经纪人ID")
	private Long saleUserId;

	//经纪人名称")
	private String salesmanName;

	//订单按店铺区分的运费")
//	private List<OrderFreightDTO> orderFreightList;

	//预计送达时间（客户下单后什么时候收到货）")
	private Date estimatedDeliveryTime;

	//订单类型")
	private Integer orderType;

	//创建人Id")
	private Long createUserId;

	//使用的红包ID")
	private Set<Long> useBonusIds;

	//使用的优惠券ID")
	private Set<Long> useCouponIds;

	//使用的优惠码ID")
	private Long useCouponCodeId;

	//邮政编码")
	private String zipCode;

	//渠道类型")
	private Integer channelType;

	//订单来源")
	private Integer orderSource;

	//下单APP版本号")
	private String appVersion;

	//下单设备序列号")
	private String deviceSequence;

	//会员等级")
	private Integer bizUserLevel;

	//会员来源")
	private Integer userSource;

	//拒绝原因")
	private String refuseReason;

	//是否vip会员下的单")
	private Boolean vipBizUserOrder;

	//该订单中钱包支付的金额")
	private BigDecimal balancePayAmount;

	//0 易久批 1 易尔惠/易酒团")
	private Integer salesPlatformId;

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getSysRemark() {
		return sysRemark;
	}

	public void setSysRemark(String sysRemark) {
		this.sysRemark = sysRemark;
	}

	public Date getHopeDeliveryTime() {
		return hopeDeliveryTime;
	}

	public void setHopeDeliveryTime(Date hopeDeliveryTime) {
		this.hopeDeliveryTime = hopeDeliveryTime;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCompanyName() {
		return userCompanyName;
	}

	public void setUserCompanyName(String userCompanyName) {
		this.userCompanyName = userCompanyName;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getUserClassName() {
		return userClassName;
	}

	public void setUserClassName(String userClassName) {
		this.userClassName = userClassName;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getGiveCouponAmount() {
		return giveCouponAmount;
	}

	public void setGiveCouponAmount(BigDecimal giveCouponAmount) {
		this.giveCouponAmount = giveCouponAmount;
	}

	public BigDecimal getGiveBonusAmount() {
		return giveBonusAmount;
	}

	public void setGiveBonusAmount(BigDecimal giveBonusAmount) {
		this.giveBonusAmount = giveBonusAmount;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getReduceAmount() {
		return reduceAmount;
	}

	public void setReduceAmount(BigDecimal reduceAmount) {
		this.reduceAmount = reduceAmount;
	}

	public BigDecimal getUseBonusAmount() {
		return useBonusAmount;
	}

	public void setUseBonusAmount(BigDecimal useBonusAmount) {
		this.useBonusAmount = useBonusAmount;
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

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public List<OrderItemAddDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemAddDTO> items) {
		this.items = items;
	}

	public Long getSaleUserId() {
		return saleUserId;
	}

	public void setSaleUserId(Long saleUserId) {
		this.saleUserId = saleUserId;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

//	public List<OrderFreightDTO> getOrderFreightList() {
//		return orderFreightList;
//	}
//
//	public void setOrderFreightList(List<OrderFreightDTO> orderFreightList) {
//		this.orderFreightList = orderFreightList;
//	}

	public Date getEstimatedDeliveryTime() {
		return estimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(Date estimatedDeliveryTime) {
		this.estimatedDeliveryTime = estimatedDeliveryTime;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Long getOrderBatchId() {
		return orderBatchId;
	}

	public void setOrderBatchId(Long orderBatchId) {
		this.orderBatchId = orderBatchId;
	}

	public Set<Long> getUseBonusIds() {
		return useBonusIds;
	}

	public void setUseBonusIds(Set<Long> useBonusIds) {
		this.useBonusIds = useBonusIds;
	}

	public Set<Long> getUseCouponIds() {
		return useCouponIds;
	}

	public void setUseCouponIds(Set<Long> useCouponIds) {
		this.useCouponIds = useCouponIds;
	}

	public Long getUseCouponCodeId() {
		return useCouponCodeId;
	}

	public void setUseCouponCodeId(Long useCouponCodeId) {
		this.useCouponCodeId = useCouponCodeId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getDeviceSequence() {
		return deviceSequence;
	}

	public void setDeviceSequence(String deviceSequence) {
		this.deviceSequence = deviceSequence;
	}

	public Integer getBizUserLevel() {
		return bizUserLevel;
	}

	public void setBizUserLevel(Integer bizUserLevel) {
		this.bizUserLevel = bizUserLevel;
	}

	public Integer getUserSource() {
		return userSource;
	}

	public void setUserSource(Integer userSource) {
		this.userSource = userSource;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public Boolean getVipBizUserOrder() {
		return vipBizUserOrder;
	}

	public void setVipBizUserOrder(Boolean vipBizUserOrder) {
		this.vipBizUserOrder = vipBizUserOrder;
	}

	public BigDecimal getBalancePayAmount() {
		return balancePayAmount;
	}

	public void setBalancePayAmount(BigDecimal balancePayAmount) {
		this.balancePayAmount = balancePayAmount;
	}

	public Integer getSalesPlatformId() {
		return salesPlatformId;
	}

	public void setSalesPlatformId(Integer salesPlatformId) {
		this.salesPlatformId = salesPlatformId;
	}
}
