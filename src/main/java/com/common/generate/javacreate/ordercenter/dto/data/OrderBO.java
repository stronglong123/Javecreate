package com.common.generate.javacreate.ordercenter.dto.data;


import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderBO
 * @Description oms销售单模型
 * @Author hhw
 * @Date 2022/5/11 11:37
 * @Version 1.0
 **/
public class OrderBO implements Serializable {
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
     * [SCM2-14675]：订单新增SecOrderType类型字段，所有取值来源于OrderTypeConstant
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
     * sourceOmsOrderId
     */
    private Long oldId;

    /**
     * sourceOmsOrderNo
     */
    private String oldOrderNo;

    /**
     * 拆分订单历史支付id
     */
    private Long oldPaymentInfoId;

    private String lastUpdateUserName;

    /**
     * 操作类型 true=默认不允许有流程 false=内配司机调整，继续配送，已经发车待入库
     */
    private Boolean optType = Boolean.TRUE;

    /**
     * 临时自动，存在分区
     */
    private Integer productStatisticsClassIndex;

    private Boolean needWavePicking;

    /**
     * 是否高货值
     */
    private Boolean highAmount;

    private String optUserName;

    /**
     * 是否车销活动（注册有礼）订单。
     * true =》 是
     * false =》 否
     */
    private Boolean registrationPromotion;
    /**
     * 高货值取消的需要生成内配退
     */
    private Boolean allotTrueAll;

    /**
     * 是否vip会员下的单
     */
    private Boolean vipBizUserOrder;

    /**
     * 调味品特征
     */
    private Boolean condimentFeature;

    /**
     * jiupiorder表主键
     */
    private Long jiupiOrderTableId;

    /**
     * jiupiorder表中org_id
     */
    private Integer jiupiOrderTableOrgId;

    /**
     * 销售单ID
     */
    private Long order_Id;

    /**
     * jiupiorder表中的Warehouse_Id
     */
    private Integer jiupiOrderTableWarehouseId;

    /**
     * jiupiorder表中的OrderType
     */
    private Integer jiupiOrderTableOrderType;

    /**
     * 合作商转酒批(0), 酒批订单(1)
     */
    private Integer jiupiOrderSource;

    /**
     * 酒批订单类型 普通订单(0),  分销商订单(1),  经销商直配订单(2), 大货批发订单(3), 撮合订单(4)
     */
    private Integer jiupiOrderType;

    /**
     * 订单满减
     */
    private BigDecimal reduceAmount;

    /**
     * 红包
     */
    private BigDecimal useBonusAmount;

    /**
     * 立减
     */
    private BigDecimal productReduceAmount;

    /**
     * 优惠金额
     */
    private BigDecimal useCouponAmount;

    /**
     * 下单本次抹零金额
     */
    private BigDecimal thisRemoveAmount;

    /**
     * 后续抹零金额
     */
    private BigDecimal laterRemoveAmount;

    /**
     * 用户账户金额
     */
    private BigDecimal balanceAmount;

    /**
     * 赠送的优惠券总金额
     */
    private BigDecimal giveCouponAmount;

    /**
     * 赠送的红包总金额
     */
    private BigDecimal giveBonusAmount;

    /**
     * 配送状态 无配送状态（ -1），全部配送(0),部分发货(1),部分配送(2),延迟配送(3),配送失败(4),延迟配送已入库(5)
     */
    private Integer deliveryState;

    /**
     * 支付方式 货到付款(0),微信支付(1),支付宝支付(2),白条支付(4)
     */
    private Integer payType;

    /**
     * 取货方 酒批(0),合作商(1)
     */
    private Integer pickupType;

    /**
     * 收款方 酒批(0),合作商(1)
     */
    private Integer payee;

    /**
     * 是否预售订单1=是0=否(ispresale)
     */
    private Integer preSaleType;

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
     * 关联合作商订单
     */
    private Long partnerOrder_Id;

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
    private Long shop_Id;

    /**
     * 经销商名称
     */
    private String shopName;

    /**
     * 易酒批零店铺ID
     */
    private Long shopExternal_Id;

    /**
     * 易酒批零店铺名称
     */
    private String shopExternalName;

    /**
     * 大货订单标记 1不进仓自提 2进仓自提 3进仓送货
     */
    private Integer bigGoodsMode;

    /**
     * 原始金额
     */
    private BigDecimal originalPayAmount;

    /**
     * 0未处理，1已处理。ERP订单完成状态
     */
    private Integer erpCompleteStatus;

    /**
     * 优惠合计
     */
    private BigDecimal discountAmount;

    /**
     * 久批店铺id
     */
    private Long jiupiShop_Id;

    /**
     * 支付状态
     */
    private Integer payState;

    /**
     * 支付成功时间
     */
    private Date payTime;

    /**
     * 服务费
     */
    private BigDecimal serviceFee;

    /**
     * 内配中转退关联原单、7Gan是关联的退货单
     */
    private Long refOmsorder_Id;

    /**
     * 冲销状态(0:未冲销 1:已冲销)
     */
    private Integer chargeOffState;

    /**
     * 订单原价总金额
     */
    private BigDecimal originAmount;
    /**
     * 优惠总金额
     */
    private BigDecimal totalDiscount;

    /**
     * 给crm的额外字段
     */
    private OrderOtherBO orderOtherBO;

    /**
     * 非业务相关的透传字段
     */
    private Map<String, Object> transferFields;

    /**
     * 第三方订单来源
     */
    private OrderExtensionsBO orderExtensionsBO;

    /**
     * 订单特性
     */
    private List<OrderFeatureBO> orderFeatureBOList;

    /**
     * 该订单对应合并单详情
     */
    private CombineOrderModelBO combineOrderBO;

    private List<OrderItemBO> orderItemBOList;

    /**
     * 明细关联单-拆单相关
     */
    private List<OrderItemRefBO> orderItemRefBO;

    /**
     * 订单扩展
     */
    private OrderExtBO orderExtBO;

    /**
     * 交易的合约单Id
     */
    private Long contractOrderId;


    /**
     * 该订单中钱包支付的金额
     */
    private BigDecimal balancePayAmount;

    /**
     * 仓库范围配置的，用于记录虚仓对应的前置仓
     */
    private Integer dyyRefWarehouseId;

    /**
     * 配送中心
     */
    private Integer deliveryWarehouse_Id;

    /**
     * 是预售且满足LARGE_TRANSFER的配置
     */
    private Boolean preLargeTransfer = false;

    /**
     * 换货单号
     */
    private String exchangeOrderNo;

    /**
     * 订单日志
     */
    @ApiParam(description = "订单日志")
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

    public Long getOldId() {
        return oldId;
    }

    public void setOldId(Long oldId) {
        this.oldId = oldId;
    }

    public String getOldOrderNo() {
        return oldOrderNo;
    }

    public void setOldOrderNo(String oldOrderNo) {
        this.oldOrderNo = oldOrderNo;
    }

    public Long getOldPaymentInfoId() {
        return oldPaymentInfoId;
    }

    public void setOldPaymentInfoId(Long oldPaymentInfoId) {
        this.oldPaymentInfoId = oldPaymentInfoId;
    }

    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    public void setLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
    }

    public Boolean getOptType() {
        return optType;
    }

    public void setOptType(Boolean optType) {
        this.optType = optType;
    }

    public Integer getProductStatisticsClassIndex() {
        return productStatisticsClassIndex;
    }

    public void setProductStatisticsClassIndex(Integer productStatisticsClassIndex) {
        this.productStatisticsClassIndex = productStatisticsClassIndex;
    }

    public Boolean getNeedWavePicking() {
        return needWavePicking;
    }

    public void setNeedWavePicking(Boolean needWavePicking) {
        this.needWavePicking = needWavePicking;
    }

    public Boolean getHighAmount() {
        return highAmount;
    }

    public void setHighAmount(Boolean highAmount) {
        this.highAmount = highAmount;
    }

    public String getOptUserName() {
        return optUserName;
    }

    public void setOptUserName(String optUserName) {
        this.optUserName = optUserName;
    }

    public Boolean getRegistrationPromotion() {
        return registrationPromotion;
    }

    public void setRegistrationPromotion(Boolean registrationPromotion) {
        this.registrationPromotion = registrationPromotion;
    }

    public Boolean getAllotTrueAll() {
        return allotTrueAll;
    }

    public void setAllotTrueAll(Boolean allotTrueAll) {
        this.allotTrueAll = allotTrueAll;
    }

    public Boolean getVipBizUserOrder() {
        return vipBizUserOrder;
    }

    public void setVipBizUserOrder(Boolean vipBizUserOrder) {
        this.vipBizUserOrder = vipBizUserOrder;
    }

    public Boolean getCondimentFeature() {
        return condimentFeature;
    }

    public void setCondimentFeature(Boolean condimentFeature) {
        this.condimentFeature = condimentFeature;
    }

    public Long getJiupiOrderTableId() {
        return jiupiOrderTableId;
    }

    public void setJiupiOrderTableId(Long jiupiOrderTableId) {
        this.jiupiOrderTableId = jiupiOrderTableId;
    }

    public Integer getJiupiOrderTableOrgId() {
        return jiupiOrderTableOrgId;
    }

    public void setJiupiOrderTableOrgId(Integer jiupiOrderTableOrgId) {
        this.jiupiOrderTableOrgId = jiupiOrderTableOrgId;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Integer getJiupiOrderTableWarehouseId() {
        return jiupiOrderTableWarehouseId;
    }

    public void setJiupiOrderTableWarehouseId(Integer jiupiOrderTableWarehouseId) {
        this.jiupiOrderTableWarehouseId = jiupiOrderTableWarehouseId;
    }

    public Integer getJiupiOrderTableOrderType() {
        return jiupiOrderTableOrderType;
    }

    public void setJiupiOrderTableOrderType(Integer jiupiOrderTableOrderType) {
        this.jiupiOrderTableOrderType = jiupiOrderTableOrderType;
    }

    public Integer getJiupiOrderSource() {
        return jiupiOrderSource;
    }

    public void setJiupiOrderSource(Integer jiupiOrderSource) {
        this.jiupiOrderSource = jiupiOrderSource;
    }

    public Integer getJiupiOrderType() {
        return jiupiOrderType;
    }

    public void setJiupiOrderType(Integer jiupiOrderType) {
        this.jiupiOrderType = jiupiOrderType;
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

    public BigDecimal getThisRemoveAmount() {
        return thisRemoveAmount;
    }

    public void setThisRemoveAmount(BigDecimal thisRemoveAmount) {
        this.thisRemoveAmount = thisRemoveAmount;
    }

    public BigDecimal getLaterRemoveAmount() {
        return laterRemoveAmount;
    }

    public void setLaterRemoveAmount(BigDecimal laterRemoveAmount) {
        this.laterRemoveAmount = laterRemoveAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
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

    public Integer getPickupType() {
        return pickupType;
    }

    public void setPickupType(Integer pickupType) {
        this.pickupType = pickupType;
    }

    public Integer getPayee() {
        return payee;
    }

    public void setPayee(Integer payee) {
        this.payee = payee;
    }

    public Integer getPreSaleType() {
        return preSaleType;
    }

    public void setPreSaleType(Integer preSaleType) {
        this.preSaleType = preSaleType;
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

    public Long getPartnerOrder_Id() {
        return partnerOrder_Id;
    }

    public void setPartnerOrder_Id(Long partnerOrder_Id) {
        this.partnerOrder_Id = partnerOrder_Id;
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

    public Long getShop_Id() {
        return shop_Id;
    }

    public void setShop_Id(Long shop_Id) {
        this.shop_Id = shop_Id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getShopExternal_Id() {
        return shopExternal_Id;
    }

    public void setShopExternal_Id(Long shopExternal_Id) {
        this.shopExternal_Id = shopExternal_Id;
    }

    public String getShopExternalName() {
        return shopExternalName;
    }

    public void setShopExternalName(String shopExternalName) {
        this.shopExternalName = shopExternalName;
    }

    public Integer getBigGoodsMode() {
        return bigGoodsMode;
    }

    public void setBigGoodsMode(Integer bigGoodsMode) {
        this.bigGoodsMode = bigGoodsMode;
    }

    public BigDecimal getOriginalPayAmount() {
        return originalPayAmount;
    }

    public void setOriginalPayAmount(BigDecimal originalPayAmount) {
        this.originalPayAmount = originalPayAmount;
    }

    public Integer getErpCompleteStatus() {
        return erpCompleteStatus;
    }

    public void setErpCompleteStatus(Integer erpCompleteStatus) {
        this.erpCompleteStatus = erpCompleteStatus;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getJiupiShop_Id() {
        return jiupiShop_Id;
    }

    public void setJiupiShop_Id(Long jiupiShop_Id) {
        this.jiupiShop_Id = jiupiShop_Id;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Long getRefOmsorder_Id() {
        return refOmsorder_Id;
    }

    public void setRefOmsorder_Id(Long refOmsorder_Id) {
        this.refOmsorder_Id = refOmsorder_Id;
    }

    public Integer getChargeOffState() {
        return chargeOffState;
    }

    public void setChargeOffState(Integer chargeOffState) {
        this.chargeOffState = chargeOffState;
    }

    public BigDecimal getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(BigDecimal originAmount) {
        this.originAmount = originAmount;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public OrderOtherBO getOrderOtherBO() {
        return orderOtherBO;
    }

    public void setOrderOtherBO(OrderOtherBO orderOtherBO) {
        this.orderOtherBO = orderOtherBO;
    }

    public Map<String, Object> getTransferFields() {
        return transferFields;
    }

    public void setTransferFields(Map<String, Object> transferFields) {
        this.transferFields = transferFields;
    }

    public OrderExtensionsBO getOrderExtensionsBO() {
        return orderExtensionsBO;
    }

    public void setOrderExtensionsBO(OrderExtensionsBO orderExtensionsBO) {
        this.orderExtensionsBO = orderExtensionsBO;
    }

    public List<OrderFeatureBO> getOrderFeatureBOList() {
        return orderFeatureBOList;
    }

    public void setOrderFeatureBOList(List<OrderFeatureBO> orderFeatureBOList) {
        this.orderFeatureBOList = orderFeatureBOList;
    }

    public CombineOrderModelBO getCombineOrderBO() {
        return combineOrderBO;
    }

    public void setCombineOrderBO(CombineOrderModelBO combineOrderBO) {
        this.combineOrderBO = combineOrderBO;
    }

    public List<OrderItemBO> getOrderItemBOList() {
        return orderItemBOList;
    }

    public void setOrderItemBOList(List<OrderItemBO> orderItemBOList) {
        this.orderItemBOList = orderItemBOList;
    }

    public List<OrderItemRefBO> getOrderItemRefBO() {
        return orderItemRefBO;
    }

    public void setOrderItemRefBO(List<OrderItemRefBO> orderItemRefBO) {
        this.orderItemRefBO = orderItemRefBO;
    }

    public OrderExtBO getOrderExtBO() {
        return orderExtBO;
    }

    public void setOrderExtBO(OrderExtBO orderExtBO) {
        this.orderExtBO = orderExtBO;
    }

    public Long getContractOrderId() {
        return contractOrderId;
    }

    public void setContractOrderId(Long contractOrderId) {
        this.contractOrderId = contractOrderId;
    }

    public BigDecimal getBalancePayAmount() {
        return balancePayAmount;
    }

    public void setBalancePayAmount(BigDecimal balancePayAmount) {
        this.balancePayAmount = balancePayAmount;
    }

    public Integer getDyyRefWarehouseId() {
        return dyyRefWarehouseId;
    }

    public void setDyyRefWarehouseId(Integer dyyRefWarehouseId) {
        this.dyyRefWarehouseId = dyyRefWarehouseId;
    }

    public Integer getDeliveryWarehouse_Id() {
        return deliveryWarehouse_Id;
    }

    public void setDeliveryWarehouse_Id(Integer deliveryWarehouse_Id) {
        this.deliveryWarehouse_Id = deliveryWarehouse_Id;
    }

    public Boolean getPreLargeTransfer() {
        return preLargeTransfer;
    }

    public void setPreLargeTransfer(Boolean preLargeTransfer) {
        this.preLargeTransfer = preLargeTransfer;
    }

    public String getExchangeOrderNo() {
        return exchangeOrderNo;
    }

    public void setExchangeOrderNo(String exchangeOrderNo) {
        this.exchangeOrderNo = exchangeOrderNo;
    }

    public List<OrderTraceBO> getOrderTraceBOList() {
        return orderTraceBOList;
    }

    public void setOrderTraceBOList(List<OrderTraceBO> orderTraceBOList) {
        this.orderTraceBOList = orderTraceBOList;
    }
}

