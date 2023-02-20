package com.common.generate.javacreate.ordercenter.dto.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ReturnOrderBO
 * @Description oms退货单模型
 * @Author hhw
 * @Date 2022/5/13 9:44
 * @Version 1.0
 **/
public class ReturnOrderBO implements Serializable {

    private static final long serialVersionUID = -7670123902971535729L;

    /** orders */
    /**
     * orders.id
     */
    private Long id;
    /**
     * 组织机构代码
     */
    private String companyCode;

    /**
     * 组织机构ID城市ID
     */
    private Integer orgId;

    /**
     * 来源城市ID
     */
    private Integer fromCityId;

    /**
     * 下单仓
     */
    private Integer fromWarehouseId;

    /**
     * 仓库
     */
    private Integer warehouseId;

    /**
     * 关联业务单据ID
     */
    private Long businessId;

    /**
     * 关联业务单据单号
     */
    private String businessNo;

    /**
     * 关联业务单据类型1=酒批业务订单，2=酒批业务退货单，3=经纪人撮合业务，4=兑奖订单业务
     */
    private Integer businessType;

    /**
     * 订单状态【（酒批退货单）1申请退货/2 已取消退货/3区域审核通过/4区域审核拒绝/5运营审核通过/6运营审核拒绝/7待取货/8已取货/9拒绝取货/10已退货/11待结账/12取货中/延迟退货】
     */
    private Integer state;

    /**
     * 订单类型0=酒批订单，1=招商订单，2=经销商直配订单，3=大货批发订单，4=经济人撮合订单，10=大商转配送订单，11=轻加盟订单，12=经销商订单，13=易经销订单，14=兑奖订单
     */
    private Integer orderType;

    private Integer originalOrderType;

    /**
     * 订单第二类型
     */
    private Integer secOrderType;

    /**
     * 下单时间
     */
    private Date orderCreateTime;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 应收金额
     */
    private BigDecimal payableAmount;

    /**
     * 司机配送应收金额
     */
    private BigDecimal driverOrderAmount;

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
     * 订单配送地址
     */
    private Integer addressId;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区县
     */
    private String county;

    /**
     * 街道
     */
    private String street;

    /**
     * 送货详细地址
     */
    private String detailAddress;

    /**
     * 收货地址经纬度
     */
    private BigDecimal contactLongitude;

    /**
     * 收货地址经纬度
     */
    private BigDecimal contactLatitude;

    /**
     * 发货人
     */
    private String consignor;

    /**
     * 发货人电话
     */
    private String consignorPhone;

    /**
     * 发货人公司
     */
    private String consignorCompanyName;

    /**
     * 发货人地址
     */
    private String consignorAddress;

    /**
     * 订单完成时间
     */
    private Date orderCompleteTime;

    /**
     * 经纪人ID
     */
    private Integer salesmanId;

    /**
     * 经纪人名称
     */
    private String salesManName;

    /**
     * 经纪人电话
     */
    private String salesManPhone;

    /**
     * 配送方式（0=酒批配送，1=合作商配送，2=配送商配送，4=客户自提，5=总部物流，6=区域代配送，20=门店转配送，-1=不配送）
     */
    private Integer deliveryMode;

    /**
     * 物流费用付款方：发货方付款(0)，收货方付款(1)
     */
    private Integer deliveryFeePayer;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 系统备注
     */
    private String sysRemark;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;
    /**
     * 最后更新人
     */
    private Integer lastUpdateUserId;
    /**
     * 波次号
     */
    private String waveNO;
    /**
     * 调度任务号
     */
    private String scheduleNO;
    /**
     * 打印次数
     */
    private Integer printCount;
    /**
     * 配送员
     */
    private Integer deliveryUserId;

    /**
     * 配送员名称
     */
    private String deliveryUserName;

    /**
     * 线路名称
     */
    private String routingName;

    /**
     * 地址序号
     */
    private Integer routingItemSequence;
    /**
     * 订单序号
     */
    private Integer orderSequence;

    /**
     * 是否为异常订单 0：否,1：是
     */
    private Integer exceptionStatus;

    /**
     * 成本价
     */
    private BigDecimal supplyCostPrice;

    /**
     * 拣货方式0 未设置 1按大件拣货 2按小件拣货
     */
    private Integer pickType;

    /**
     * 期望配送时间
     */
    private Date hopeDeliveryTime;

    /**
     * 内配类型8=内配，9=内配退，11=中转，12=中转退
     */
    private Integer allotType;

    /**jiupiReturnOrder*/
    /**
     * jiupireturnorder.id
     */
    private Long jiupiReturnOrderId;
    /**
     * 销售单ID
     */
    private Long orderId;

    /**
     * 关联订单ID
     */
    private Long refOrderId;

    /**
     * jiupireturnorder.仓库
     */
    private Integer jiuPiReturnWarehouseId;

    /**
     * 退货金额
     */
    private BigDecimal returnAmount;

    /**
     * 退红包
     */
    private BigDecimal returnBonusAmount;

    /**
     * 退酒币
     */
    private BigDecimal giveWineScore;

    /**
     * 退货原因
     */
    private String returnReason;

    /**
     * 配送状态 拒绝退货(8)，已退货（10），延迟退货（13）
     */
    private Integer deliveryState;

    /**
     * 支付方式 货到付款(0),微信支付(1),支付宝支付(2)
     */
    private Integer payType;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 客户名称
     */
    private String userName;

    /**
     * 客户电话
     */
    private String userMobileNo;

    /**
     * 用户标签
     */
    private String userRemark;

    /**
     * 用户类型
     */
    private String userClassName;

    /**
     * 关联合作商订单
     */
    private Long partnerOrderId;

    /**
     * 大商配送结算状态 1待对账/2已结账/4对账中/5已对账
     */
    private Integer partnerPayState;

    /**
     * 合作商ID
     */
    private Long parterId;

    /**
     * 合作商名称
     */
    private String parterName;

    /**
     * 经销商ID
     */
    private Long shopId;

    /**
     * 店铺Id
     */
    private Long jiupiShopId;

    /**
     * 经销商名称
     */
    private String shopName;

    /**
     * 易酒批零店铺ID
     */
    private Long shopExternalId;

    /**
     * 易酒批零店铺名称
     */
    private String shopExternalName;

    /**
     * 0: 酒批申请退货单，6：供应链申请退货单
     */
    private Integer orderSource;

    /**
     * 关联原单oms订单id
     */
    private Long refOmsOrderId;

    /**
     * 产品供货仓库Id
     */
    private Integer supplyWarehouseId;
    /**
     * 图片(附件)
     */
    private List<String> pictures;


    /**
     * 专区类型：0-休食；1-酒饮
     */
    private Integer specialAreaType;

    /**
     * CRM用
     * 申请人ID（AdminUser）.
     */
    private Integer applicantId;

    /***/
    /**
     * ReturnOrderExtensions.id
     */
    private Long extensionId;

    /**
     * 第三方订单编码
     */
    private String thirdOrderNo;

    /**
     * 服务商id
     */
    private Long parentOrgId;

    /**
     * 来源类型，0，易酒批，1、拼多多，2、淘宝，3、京东
     */
    private Integer extensionOrderSource;


    /**
     * 拍照退货id
     */
    private Long returnOrderApplyId;


    /**other*/
    /**
     * 审核拒绝原因
     */
    private String refuseReason;
    /**
     * 用于保存由于配售范围导致退货单原仓库被覆盖掉的值
     */
    private Integer originWarehouseId;

    /**
     * 配送中心
     */
    private Integer deliveryWarehouse_Id;

    /**
     * 上门验货
     */
    private Boolean needInspection = false;

    /**
     * 是否需要取货
     */
    private Boolean needPickup;

    private BigDecimal freightAmount;

    private Integer freightPayer;

    /**
     * 订单日志
     */
    private List<OrderTraceBO> orderTraceBOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public Integer getFromWarehouseId() {
        return fromWarehouseId;
    }

    public void setFromWarehouseId(Integer fromWarehouseId) {
        this.fromWarehouseId = fromWarehouseId;
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

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOriginalOrderType() {
        return originalOrderType;
    }

    public void setOriginalOrderType(Integer originalOrderType) {
        this.originalOrderType = originalOrderType;
    }

    public Integer getSecOrderType() {
        return secOrderType;
    }

    public void setSecOrderType(Integer secOrderType) {
        this.secOrderType = secOrderType;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
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

    public BigDecimal getDriverOrderAmount() {
        return driverOrderAmount;
    }

    public void setDriverOrderAmount(BigDecimal driverOrderAmount) {
        this.driverOrderAmount = driverOrderAmount;
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

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public String getConsignorPhone() {
        return consignorPhone;
    }

    public void setConsignorPhone(String consignorPhone) {
        this.consignorPhone = consignorPhone;
    }

    public String getConsignorCompanyName() {
        return consignorCompanyName;
    }

    public void setConsignorCompanyName(String consignorCompanyName) {
        this.consignorCompanyName = consignorCompanyName;
    }

    public String getConsignorAddress() {
        return consignorAddress;
    }

    public void setConsignorAddress(String consignorAddress) {
        this.consignorAddress = consignorAddress;
    }

    public Date getOrderCompleteTime() {
        return orderCompleteTime;
    }

    public void setOrderCompleteTime(Date orderCompleteTime) {
        this.orderCompleteTime = orderCompleteTime;
    }

    public Integer getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Integer salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }

    public String getSalesManPhone() {
        return salesManPhone;
    }

    public void setSalesManPhone(String salesManPhone) {
        this.salesManPhone = salesManPhone;
    }

    public Integer getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Integer deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Integer getDeliveryFeePayer() {
        return deliveryFeePayer;
    }

    public void setDeliveryFeePayer(Integer deliveryFeePayer) {
        this.deliveryFeePayer = deliveryFeePayer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getWaveNO() {
        return waveNO;
    }

    public void setWaveNO(String waveNO) {
        this.waveNO = waveNO;
    }

    public String getScheduleNO() {
        return scheduleNO;
    }

    public void setScheduleNO(String scheduleNO) {
        this.scheduleNO = scheduleNO;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
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

    public String getRoutingName() {
        return routingName;
    }

    public void setRoutingName(String routingName) {
        this.routingName = routingName;
    }

    public Integer getRoutingItemSequence() {
        return routingItemSequence;
    }

    public void setRoutingItemSequence(Integer routingItemSequence) {
        this.routingItemSequence = routingItemSequence;
    }

    public Integer getOrderSequence() {
        return orderSequence;
    }

    public void setOrderSequence(Integer orderSequence) {
        this.orderSequence = orderSequence;
    }

    public Integer getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(Integer exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public BigDecimal getSupplyCostPrice() {
        return supplyCostPrice;
    }

    public void setSupplyCostPrice(BigDecimal supplyCostPrice) {
        this.supplyCostPrice = supplyCostPrice;
    }

    public Integer getPickType() {
        return pickType;
    }

    public void setPickType(Integer pickType) {
        this.pickType = pickType;
    }

    public Date getHopeDeliveryTime() {
        return hopeDeliveryTime;
    }

    public void setHopeDeliveryTime(Date hopeDeliveryTime) {
        this.hopeDeliveryTime = hopeDeliveryTime;
    }

    public Integer getAllotType() {
        return allotType;
    }

    public void setAllotType(Integer allotType) {
        this.allotType = allotType;
    }

    public Long getJiupiReturnOrderId() {
        return jiupiReturnOrderId;
    }

    public void setJiupiReturnOrderId(Long jiupiReturnOrderId) {
        this.jiupiReturnOrderId = jiupiReturnOrderId;
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

    public Integer getJiuPiReturnWarehouseId() {
        return jiuPiReturnWarehouseId;
    }

    public void setJiuPiReturnWarehouseId(Integer jiuPiReturnWarehouseId) {
        this.jiuPiReturnWarehouseId = jiuPiReturnWarehouseId;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public BigDecimal getReturnBonusAmount() {
        return returnBonusAmount;
    }

    public void setReturnBonusAmount(BigDecimal returnBonusAmount) {
        this.returnBonusAmount = returnBonusAmount;
    }

    public BigDecimal getGiveWineScore() {
        return giveWineScore;
    }

    public void setGiveWineScore(BigDecimal giveWineScore) {
        this.giveWineScore = giveWineScore;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public Integer getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
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

    public Long getPartnerOrderId() {
        return partnerOrderId;
    }

    public void setPartnerOrderId(Long partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
    }

    public Integer getPartnerPayState() {
        return partnerPayState;
    }

    public void setPartnerPayState(Integer partnerPayState) {
        this.partnerPayState = partnerPayState;
    }

    public Long getParterId() {
        return parterId;
    }

    public void setParterId(Long parterId) {
        this.parterId = parterId;
    }

    public String getParterName() {
        return parterName;
    }

    public void setParterName(String parterName) {
        this.parterName = parterName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getJiupiShopId() {
        return jiupiShopId;
    }

    public void setJiupiShopId(Long jiupiShopId) {
        this.jiupiShopId = jiupiShopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getShopExternalId() {
        return shopExternalId;
    }

    public void setShopExternalId(Long shopExternalId) {
        this.shopExternalId = shopExternalId;
    }

    public String getShopExternalName() {
        return shopExternalName;
    }

    public void setShopExternalName(String shopExternalName) {
        this.shopExternalName = shopExternalName;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Long getRefOmsOrderId() {
        return refOmsOrderId;
    }

    public void setRefOmsOrderId(Long refOmsOrderId) {
        this.refOmsOrderId = refOmsOrderId;
    }

    public Integer getSupplyWarehouseId() {
        return supplyWarehouseId;
    }

    public void setSupplyWarehouseId(Integer supplyWarehouseId) {
        this.supplyWarehouseId = supplyWarehouseId;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public Integer getSpecialAreaType() {
        return specialAreaType;
    }

    public void setSpecialAreaType(Integer specialAreaType) {
        this.specialAreaType = specialAreaType;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Long getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(Long extensionId) {
        this.extensionId = extensionId;
    }

    public String getThirdOrderNo() {
        return thirdOrderNo;
    }

    public void setThirdOrderNo(String thirdOrderNo) {
        this.thirdOrderNo = thirdOrderNo;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public Integer getExtensionOrderSource() {
        return extensionOrderSource;
    }

    public void setExtensionOrderSource(Integer extensionOrderSource) {
        this.extensionOrderSource = extensionOrderSource;
    }

    public Long getReturnOrderApplyId() {
        return returnOrderApplyId;
    }

    public void setReturnOrderApplyId(Long returnOrderApplyId) {
        this.returnOrderApplyId = returnOrderApplyId;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Integer getOriginWarehouseId() {
        return originWarehouseId;
    }

    public void setOriginWarehouseId(Integer originWarehouseId) {
        this.originWarehouseId = originWarehouseId;
    }

    public Integer getDeliveryWarehouse_Id() {
        return deliveryWarehouse_Id;
    }

    public void setDeliveryWarehouse_Id(Integer deliveryWarehouse_Id) {
        this.deliveryWarehouse_Id = deliveryWarehouse_Id;
    }

    public Boolean getNeedInspection() {
        return needInspection;
    }

    public void setNeedInspection(Boolean needInspection) {
        this.needInspection = needInspection;
    }

    public Boolean getNeedPickup() {
        return needPickup;
    }

    public void setNeedPickup(Boolean needPickup) {
        this.needPickup = needPickup;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getFreightPayer() {
        return freightPayer;
    }

    public void setFreightPayer(Integer freightPayer) {
        this.freightPayer = freightPayer;
    }

    public List<OrderTraceBO> getOrderTraceBOList() {
        return orderTraceBOList;
    }

    public void setOrderTraceBOList(List<OrderTraceBO> orderTraceBOList) {
        this.orderTraceBOList = orderTraceBOList;
    }
}

