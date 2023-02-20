package com.common.generate.javacreate.ordercenter.dto.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AwardOrderBO
 * @Description oms兑奖单模型
 * @Author hhw
 * @Date 2022/5/13 10:17
 * @Version 1.0
 **/
public class AwardOrderBO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 组织机构代码
     */
    private String companyCode;

    /**
     * 组织机构ID_城市ID
     */
    private Integer org_Id;

    /**
     * 仓库、调拨仓库allotWarehouseId
     */
    private Integer warehouse_Id;

    /**
     * 关联业务单据ID
     */
    private Long business_Id;

    /**
     * 关联业务单据单号
     */
    private String businessNo;

    /**
     * 关联业务单据类型
     * 1=酒批业务订单，2=酒批业务退货单，3=经纪人撮合业务，4=兑奖订单业务，5=易经销委托配送
     */
    private Integer businessType;

    /**
     * true-跳过灰度检查， flase-不跳过灰度检查
     */
    private Boolean skipGrapCheck;

    /**
     * 订单状态
     * 【（BusinessType1->酒批订单）
     * 1=已下单，2=已取消，3=审核通过，4=审核拒绝，5=待发货，
     * 6=已发货，7=已完成，8=配送失败，10=待结账，11=待支付，
     * 12=支付成功，13=支付失败，14=延迟配送，16=作废，20=已结算，
     * 21=待结算，30=（已出库）仓管确认出库，35=调拨中，36=调拨发货，40=已合并】
     * <p>
     * 【（BusinessType2->酒批退货单）1申请退货/2 已取消退货/3区域审核通过/4区域审核拒绝/5运营审核通过/6运营审核拒绝/7待取货/8已取货/9拒绝取货/10已退货/11待结账/12取货中/延迟退货】
     * <p>
     * 【（BusinessType3->经纪人撮合） 1审核通过/2已发货/3待结账/4已经完成/5已取消】
     * <p>
     * 【（BusinessType4->兑奖订单）1=待打印，2 =待发货，3 =待结账，4=已完成，5=已取消，6=配送失败，7=已发货，8=延迟配送】
     */
    private Integer state;

    /**
     * 订单类型
     * 25=兑奖配送订单，0=销售订单，1=招商订单，10=大商转配送订单，11=轻加盟订单，
     * 3=大货批发订单，2=经销商直配订单， 12=经销商订单，13=共享仓配订单，14=团购直营订单，
     * 15=兑奖订单，17=经纪人订单，20=退货订单，6=临期订单，50=合并订单，
     * 8=拼团订单，9=独家包销订单，30=知花知果订单，21=无忧退货，22=质量退货，
     * 52=调拨出库，116=易款便利线下单，118=易款便利线下退货单，61=wms销售出库，62=wms调拨出库，
     * 63=wms破损出库，64=wms其他出库，65=wms采购退货，66=wms盘亏出库，68=wms同城调拨出库，
     * 69=wms处理品转入，70=wms加工出库，71=wms陈列品转入，80=wms采购入库，81=wms调拨入库，
     * 82=wms退货入库，84=wms同城调拨转入入库，85=wms处理品转出入库，86=wms兑奖入库，
     * 87=wms加工入库，88=wms陈列品转出入库，89=wms其它入库，90=wms盘盈入库，
     * 91=wms返库入库单，51=ERP兑奖入库单，119=多多买菜销售单，72=多多买菜客户退货单，
     * 73=多多买菜多货退货单，92=wms销售出库单的冲销单据'
     */
    private Integer orderType;

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
    private Integer address_Id;

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
     * 发货地址经纬度
     */
    private BigDecimal consignorLongitude;

    /**
     * 发货地址经纬度
     */
    private BigDecimal consignorLatitude;

    /**
     * 订单完成时间
     */
    private Date orderCompleteTime;

    /**
     * 经纪人ID
     */
    private Integer salesMan_Id;

    /**
     * 经纪人名称
     */
    private String salesManName;

    /**
     * 经纪人电话
     */
    private String salesManPhone;

    /**
     * 配送方式
     * 0=酒批配送，1=经销商配送，2=配送商配送，4=客户自提，5=总部物流，
     * 6=区域代配送，7=快递直发，20=门店转配送，21=城际调拨，-1=不配送
     */
    private Integer deliveryMode;

    /**
     * 物流商
     */
    private Integer logisticsId;

    /**
     * 物流商名称
     */
    private String logisticsName;

    /**
     * 物流费用
     */
    private BigDecimal deliveryFee;

    /**
     * 物流费用付款方：发货方付款(0)，收货方付款(1)
     */
    private Integer deliveryFeePayer;

    /**
     * 物流单号
     */
    private String deliveryOrderNO;

    /**
     * 物流时间
     */
    private Date deliveryTime;

    /**
     * 物流车辆
     */
    private Long deliveryCar_Id;

    /**
     * 物流车辆车牌号
     */
    private String deliveryCarNumber;

    /**
     * 物流车辆名称
     */
    private String deliveryCarName;

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
    private Integer createUser_Id;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    private Integer lastUpdateUser_Id;

    /**
     * 来源城市ID
     */
    private Integer fromCity_Id;

    /**
     * 波次号
     */
    private String waveNO;

    /**
     * 调度任务号
     */
    private String scheduleNO;

    /**
     * 配送员
     */
    private Integer deliveryUser_Id;

    /**
     * 配送员名称
     */
    private String deliveryUserName;

    /**
     * 装卸员工
     */
    private Integer stevedoreUser_Id;

    /**
     * 装卸员工名称
     */
    private String stevedoreUserName;

    /**
     * 打印次数
     */
    private Integer printCount;

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
     * 是否为合并子订单 0：否,1：是
     */
    private Integer combineStatus;

    /**
     * 是否为异常订单 0：否,1：是
     */
    private Integer exceptionStatus;

    /**
     * 成本价
     */
    private BigDecimal supplyCostPrice;

    /**
     * 关联合并订单id
     */
    private Long parentOrder_Id;

    /**
     * 拣货方式0 未设置 1按大件拣货 2按小件拣货
     */
    private Integer pickType;

    /**
     * 成本价总金额
     */
    private BigDecimal costAmount;

    /**
     * 期望配送时间
     */
    private Date hopeDeliveryTime;

    /**
     * 延迟配送入库方式 1还库存 2不还库存
     */
    private Integer delayEntryType;

    /**
     * 默认货位id
     */
    private Long defaultLocation_Id;

    /**
     * 默认货位名称
     */
    private String defaultLocationName;

    /**
     * 用户收货状态(0:未收货;1:用户确认收货;2:7天自动收货)
     */
    private Integer userConfirmState;

    /**
     * 预计送达时间
     */
    private Date hopeArriveTime;

    /**
     * 下单仓、发货仓库
     */
    private Integer fromWarehouse_Id;

    /**
     * 内配类型8=内配，9=内配退，11=中转，12=中转退，13=内配退入
     */
    private Integer allotType;


    /**
     * awardorder表主键
     */
    private Long awardOrderTableId;

    /**
     * awardorder表中org_id
     */
    private Integer awardOrderTableOrgId;

    /**
     * orders表主键
     */
    private Long order_Id;

    /**
     * awardorder表中的Warehouse_Id
     */
    private Integer awardOrderTableWarehouseId;

    /**
     * 配送标记状态 -1无配送状态 ，0全部兑换、2部分兑换、3延迟兑换，4不可兑换
     */
    private Integer deliveryState;

    /**
     * 兑换红包总金额
     */
    private BigDecimal awardBonusTotalAmount;

    /**
     * 申请兑换数量
     */
    private Integer applyAwardCount;

    /**
     * 审核通过的兑换数量
     */
    private Integer canAwardCount;

    /**
     * 用户ID
     */
    private Integer user_Id;

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
     * 兑奖版本号:1=老流程，2=新流程
     */
    private Integer awardVersion;

    /**
     * 取卷人名称
     */
    private String takeUserName;

    /**
     * 取货类型：1=司机，2=经纪人
     */
    private Integer takeType;

    /**
     * 兑奖来源(1:司机端,2:经纪人)
     */
    private Integer awardOrderSource;

    /**
     * 兑奖垫付(1:未垫付,2:已垫付)
     */
    private Integer awardAdvanceState;

    /**
     * 兑奖人id
     */
    private Integer awardUser_Id;

    private List<AwardOrderItemBO> awardOrderItemBOList;

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

    public Integer getOrg_Id() {
        return org_Id;
    }

    public void setOrg_Id(Integer org_Id) {
        this.org_Id = org_Id;
    }

    public Integer getWarehouse_Id() {
        return warehouse_Id;
    }

    public void setWarehouse_Id(Integer warehouse_Id) {
        this.warehouse_Id = warehouse_Id;
    }

    public Long getBusiness_Id() {
        return business_Id;
    }

    public void setBusiness_Id(Long business_Id) {
        this.business_Id = business_Id;
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

    public Boolean getSkipGrapCheck() {
        return skipGrapCheck;
    }

    public void setSkipGrapCheck(Boolean skipGrapCheck) {
        this.skipGrapCheck = skipGrapCheck;
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

    public Integer getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(Integer address_Id) {
        this.address_Id = address_Id;
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

    public BigDecimal getConsignorLongitude() {
        return consignorLongitude;
    }

    public void setConsignorLongitude(BigDecimal consignorLongitude) {
        this.consignorLongitude = consignorLongitude;
    }

    public BigDecimal getConsignorLatitude() {
        return consignorLatitude;
    }

    public void setConsignorLatitude(BigDecimal consignorLatitude) {
        this.consignorLatitude = consignorLatitude;
    }

    public Date getOrderCompleteTime() {
        return orderCompleteTime;
    }

    public void setOrderCompleteTime(Date orderCompleteTime) {
        this.orderCompleteTime = orderCompleteTime;
    }

    public Integer getSalesMan_Id() {
        return salesMan_Id;
    }

    public void setSalesMan_Id(Integer salesMan_Id) {
        this.salesMan_Id = salesMan_Id;
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

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getDeliveryFeePayer() {
        return deliveryFeePayer;
    }

    public void setDeliveryFeePayer(Integer deliveryFeePayer) {
        this.deliveryFeePayer = deliveryFeePayer;
    }

    public String getDeliveryOrderNO() {
        return deliveryOrderNO;
    }

    public void setDeliveryOrderNO(String deliveryOrderNO) {
        this.deliveryOrderNO = deliveryOrderNO;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Long getDeliveryCar_Id() {
        return deliveryCar_Id;
    }

    public void setDeliveryCar_Id(Long deliveryCar_Id) {
        this.deliveryCar_Id = deliveryCar_Id;
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

    public Integer getCreateUser_Id() {
        return createUser_Id;
    }

    public void setCreateUser_Id(Integer createUser_Id) {
        this.createUser_Id = createUser_Id;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUser_Id() {
        return lastUpdateUser_Id;
    }

    public void setLastUpdateUser_Id(Integer lastUpdateUser_Id) {
        this.lastUpdateUser_Id = lastUpdateUser_Id;
    }

    public Integer getFromCity_Id() {
        return fromCity_Id;
    }

    public void setFromCity_Id(Integer fromCity_Id) {
        this.fromCity_Id = fromCity_Id;
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

    public Integer getDeliveryUser_Id() {
        return deliveryUser_Id;
    }

    public void setDeliveryUser_Id(Integer deliveryUser_Id) {
        this.deliveryUser_Id = deliveryUser_Id;
    }

    public String getDeliveryUserName() {
        return deliveryUserName;
    }

    public void setDeliveryUserName(String deliveryUserName) {
        this.deliveryUserName = deliveryUserName;
    }

    public Integer getStevedoreUser_Id() {
        return stevedoreUser_Id;
    }

    public void setStevedoreUser_Id(Integer stevedoreUser_Id) {
        this.stevedoreUser_Id = stevedoreUser_Id;
    }

    public String getStevedoreUserName() {
        return stevedoreUserName;
    }

    public void setStevedoreUserName(String stevedoreUserName) {
        this.stevedoreUserName = stevedoreUserName;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
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

    public Integer getCombineStatus() {
        return combineStatus;
    }

    public void setCombineStatus(Integer combineStatus) {
        this.combineStatus = combineStatus;
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

    public Long getParentOrder_Id() {
        return parentOrder_Id;
    }

    public void setParentOrder_Id(Long parentOrder_Id) {
        this.parentOrder_Id = parentOrder_Id;
    }

    public Integer getPickType() {
        return pickType;
    }

    public void setPickType(Integer pickType) {
        this.pickType = pickType;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public Date getHopeDeliveryTime() {
        return hopeDeliveryTime;
    }

    public void setHopeDeliveryTime(Date hopeDeliveryTime) {
        this.hopeDeliveryTime = hopeDeliveryTime;
    }

    public Integer getDelayEntryType() {
        return delayEntryType;
    }

    public void setDelayEntryType(Integer delayEntryType) {
        this.delayEntryType = delayEntryType;
    }

    public Long getDefaultLocation_Id() {
        return defaultLocation_Id;
    }

    public void setDefaultLocation_Id(Long defaultLocation_Id) {
        this.defaultLocation_Id = defaultLocation_Id;
    }

    public String getDefaultLocationName() {
        return defaultLocationName;
    }

    public void setDefaultLocationName(String defaultLocationName) {
        this.defaultLocationName = defaultLocationName;
    }

    public Integer getUserConfirmState() {
        return userConfirmState;
    }

    public void setUserConfirmState(Integer userConfirmState) {
        this.userConfirmState = userConfirmState;
    }

    public Date getHopeArriveTime() {
        return hopeArriveTime;
    }

    public void setHopeArriveTime(Date hopeArriveTime) {
        this.hopeArriveTime = hopeArriveTime;
    }

    public Integer getFromWarehouse_Id() {
        return fromWarehouse_Id;
    }

    public void setFromWarehouse_Id(Integer fromWarehouse_Id) {
        this.fromWarehouse_Id = fromWarehouse_Id;
    }

    public Integer getAllotType() {
        return allotType;
    }

    public void setAllotType(Integer allotType) {
        this.allotType = allotType;
    }

    public Long getAwardOrderTableId() {
        return awardOrderTableId;
    }

    public void setAwardOrderTableId(Long awardOrderTableId) {
        this.awardOrderTableId = awardOrderTableId;
    }

    public Integer getAwardOrderTableOrgId() {
        return awardOrderTableOrgId;
    }

    public void setAwardOrderTableOrgId(Integer awardOrderTableOrgId) {
        this.awardOrderTableOrgId = awardOrderTableOrgId;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Integer getAwardOrderTableWarehouseId() {
        return awardOrderTableWarehouseId;
    }

    public void setAwardOrderTableWarehouseId(Integer awardOrderTableWarehouseId) {
        this.awardOrderTableWarehouseId = awardOrderTableWarehouseId;
    }

    public Integer getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    public BigDecimal getAwardBonusTotalAmount() {
        return awardBonusTotalAmount;
    }

    public void setAwardBonusTotalAmount(BigDecimal awardBonusTotalAmount) {
        this.awardBonusTotalAmount = awardBonusTotalAmount;
    }

    public Integer getApplyAwardCount() {
        return applyAwardCount;
    }

    public void setApplyAwardCount(Integer applyAwardCount) {
        this.applyAwardCount = applyAwardCount;
    }

    public Integer getCanAwardCount() {
        return canAwardCount;
    }

    public void setCanAwardCount(Integer canAwardCount) {
        this.canAwardCount = canAwardCount;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
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

    public Integer getAwardVersion() {
        return awardVersion;
    }

    public void setAwardVersion(Integer awardVersion) {
        this.awardVersion = awardVersion;
    }

    public String getTakeUserName() {
        return takeUserName;
    }

    public void setTakeUserName(String takeUserName) {
        this.takeUserName = takeUserName;
    }

    public Integer getTakeType() {
        return takeType;
    }

    public void setTakeType(Integer takeType) {
        this.takeType = takeType;
    }

    public Integer getAwardOrderSource() {
        return awardOrderSource;
    }

    public void setAwardOrderSource(Integer awardOrderSource) {
        this.awardOrderSource = awardOrderSource;
    }

    public Integer getAwardAdvanceState() {
        return awardAdvanceState;
    }

    public void setAwardAdvanceState(Integer awardAdvanceState) {
        this.awardAdvanceState = awardAdvanceState;
    }

    public Integer getAwardUser_Id() {
        return awardUser_Id;
    }

    public void setAwardUser_Id(Integer awardUser_Id) {
        this.awardUser_Id = awardUser_Id;
    }

    public List<AwardOrderItemBO> getAwardOrderItemBOList() {
        return awardOrderItemBOList;
    }

    public void setAwardOrderItemBOList(List<AwardOrderItemBO> awardOrderItemBOList) {
        this.awardOrderItemBOList = awardOrderItemBOList;
    }
}

