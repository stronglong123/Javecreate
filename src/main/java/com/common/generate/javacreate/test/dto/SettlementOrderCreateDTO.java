package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 结转
 * @author xialei
 * @date 2021/3/31 11:48
 */
public class SettlementOrderCreateDTO implements Serializable {
    private static final long serialVersionUID = -2369299100528535846L;
    /**
     * 平台编号：110 美团优选，111 多多买菜 112橙心优选(必传)
     */
    private Integer channelNo;
    /**
     * 订单类型  75 结转出，76 结转入，77 结算出，78结算入，(必传)
     */
    private Byte orderType;
    /**
     * 关联单据号(必传)
     */
    private String relatedNoteNO;
    /**
     * 关联单据号
     */
    private Long relatedNoteId;
    /**
     * 服务商id
     */
    private Long parentOrgId;
    /**
     * 城市id(必传)
     */
    private Integer orgId;
    /**
     * 仓库ID(必传)
     */
    private Integer warehouseId;
    /**
     * 业务单据ID
     */
    private Long businessId;
    /**
     * 业务单号
     */
    private String businessNo;

    /**
     * 下单时间
     */
    private Date orderCreateTime;
    /**
     * 订单金额(必传)
     */
    private BigDecimal orderAmount;
    /**
     * 应收金额
     */
    private BigDecimal payableAmount;
    /**
     * 优惠金额
     */
    private BigDecimal useCouponAmount;
    /**
     * 支付方式
     */
    private Byte payType;
    /**
     * 会员id(必传)
     */
    private Integer userId;
    /**
     * 会员名称(必传)
     */
    private String userName;
    /**
     * 用户收货地址id(必传)
     */
    private Integer addressId;
    /**
     * 收货人(必传)
     */
    private String contact;
    /**
     * 收货人电话(必传)
     */
    private String contactPhone;
    /**
     * 收货人公司(必传)
     */
    private String contactCompanyName;
    /**
     * 送货详细地址(必传)
     */
    private String detailAddress;
    /**
     * 省(必传)
     */
    private String province;
    /**
     * 市(必传)
     */
    private String city;
    /**
     * 县区(必传)
     */
    private String county;
    /**
     * 街道(必传)
     */
    private String street;
    /**
     * 收货地址经纬度(必传)
     */
    private BigDecimal contactLongitude;
    /**
     * 收货地址经纬度(必传)
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
     * 配送方式
     */
    private Byte deliveryMode;

    private String remark;

    private Integer createUserId;
    /**
     * 状态
     */
    private Byte state;

    private Byte businessType;

    /**
     * 完成时间
     */
    private Date orderCompleteTime;

    /**
     * 关联账单id
     */
    private Long refSettleId;

    /**明细*/
    private List<SettlementOrderItemCreateDTO> items;

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
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

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
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

    public BigDecimal getUseCouponAmount() {
        return useCouponAmount;
    }

    public void setUseCouponAmount(BigDecimal useCouponAmount) {
        this.useCouponAmount = useCouponAmount;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public Byte getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Byte deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public List<SettlementOrderItemCreateDTO> getItems() {
        return items;
    }

    public void setItems(List<SettlementOrderItemCreateDTO> items) {
        this.items = items;
    }

    public String getRelatedNoteNO() {
        return relatedNoteNO;
    }

    public void setRelatedNoteNO(String relatedNoteNO) {
        this.relatedNoteNO = relatedNoteNO;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public Long getRelatedNoteId() {
        return relatedNoteId;
    }

    public void setRelatedNoteId(Long relatedNoteId) {
        this.relatedNoteId = relatedNoteId;
    }

    public Date getOrderCompleteTime() {
        return orderCompleteTime;
    }

    public void setOrderCompleteTime(Date orderCompleteTime) {
        this.orderCompleteTime = orderCompleteTime;
    }

    public Long getRefSettleId() {
        return refSettleId;
    }

    public void setRefSettleId(Long refSettleId) {
        this.refSettleId = refSettleId;
    }
}
