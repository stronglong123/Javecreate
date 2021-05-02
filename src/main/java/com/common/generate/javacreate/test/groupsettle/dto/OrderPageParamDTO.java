package com.common.generate.javacreate.test.groupsettle.dto;

import com.common.generate.javacreate.utils.CustomJsonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author xialei
 * @date 2021/4/30 22:28
 */
public class OrderPageParamDTO implements Serializable {
    /**
     * 城市ID
     */
    private Integer orgId;
    /**
     * 来源城市ID
     */
    private Integer fromCityId;
    private List<Integer> fromCityIds;
    /**
     * 仓库IDS
     */
    private List<Integer> warehouseIds;
    /**
     * 单号
     */
    private String businessNo;
    /**
     * 单据类型
     */
    private List<Byte> businessTypes;
    /**
     * 配送方式
     */
    private List<Byte> deliveryModes;
    /**
     * 收货人手机
     */
    private String contactPhone;
    /**
     * 联系人手机列表
     */
    private List<String> contactPhones;
    /**
     * 单据下单开始时间
     */
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date orderCreateTimeStart;
    /**
     * 单据下单结束时间
     */
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date orderCreateTimeEnd;
    /**
     * 单据下单开始时间
     */
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date lastUpdateTimeStart;
    /**
     * 单据下单结束时间
     */
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date lastUpdateTimeEnd;
    /**
     * 订单状态
     */
    private List<Byte> states;
    /**
     * 订单类型
     */
    private List<Byte> orderTypes;
    /**
     * 经济人ID
     */
    private Integer salesmanId;
    /**
     * 经纪人名
     */
    private String salesManName;
    /**
     * 区
     */
    private String county;
    /**
     * 街道
     */
    private String street;
    /**
     * 转配送门店名称
     */
    private Long shopExternalId;
    /**
     * 是否预售订单
     */
    private Byte preSaleType;
    /**
     * 是否地址异常
     */
    private Byte addressError;
    /**
     * 经销商Id
     */
    private Long distributorId;
    /**
     * 产品名称
     */
    private String productSkuName;
    /**
     * 地址
     */
    private Integer addressId;
    /**
     * 线路名称
     */
    private String routingName;
    /**
     * 经销商ID
     */
    private Long shopId;
    /**
     * 是否合并订单（ 0：否,1：是）
     */
    private Byte combineStatus;
    /**
     * 是否异常订单（ 0：否,1：是）
     */
    private Byte exceptionStatus;
    /**
     * 取货类型兑奖取货类型：1=司机，2=经纪人
     */
    private Byte takeType;
    /**
     * 城市名称查询
     */
    private String city;
    /**
     * 会员ID
     */
    private Integer bizUserId;
    /**
     * 期望送货开始时间
     */
    private String hopeDeliveryTimeStart;
    /**
     * 期望送货结束时间
     */
    private String hopeDeliveryTimeEnd;
    /**
     * 组织机构
     */
    private String companyCode;

    /**
     * 收货人
     */
    private String contact;
    /**
     * 省
     * */
    private String province;

    private List<String> businessNos;
    /**
     * 订单创建人
     */
    private Integer createUserId;
    /**
     * 拣货标识 true--已拣货 false--未拣货
     */
    private Boolean pickMarker;

    /**
     * 1=需要查询支付信息
     */
    private Integer queryPayTime;

    /**
     * 支付时间
     */
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date startPayTime;
    /**
     * 支付时间
     */
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date endPayTime;
    /**
     * 调拨类型
     */
    private List<Byte> allotTypes;

    /**
     * 订单来源
     */
    private Integer orderSource;

    private Integer currentPage;

    private Integer pageSize;

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

    public List<Integer> getFromCityIds() {
        return fromCityIds;
    }

    public void setFromCityIds(List<Integer> fromCityIds) {
        this.fromCityIds = fromCityIds;
    }

    public List<Integer> getWarehouseIds() {
        return warehouseIds;
    }

    public void setWarehouseIds(List<Integer> warehouseIds) {
        this.warehouseIds = warehouseIds;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public List<Byte> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<Byte> businessTypes) {
        this.businessTypes = businessTypes;
    }

    public List<Byte> getDeliveryModes() {
        return deliveryModes;
    }

    public void setDeliveryModes(List<Byte> deliveryModes) {
        this.deliveryModes = deliveryModes;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<String> getContactPhones() {
        return contactPhones;
    }

    public void setContactPhones(List<String> contactPhones) {
        this.contactPhones = contactPhones;
    }

    public Date getOrderCreateTimeStart() {
        return orderCreateTimeStart;
    }

    public void setOrderCreateTimeStart(Date orderCreateTimeStart) {
        this.orderCreateTimeStart = orderCreateTimeStart;
    }

    public Date getOrderCreateTimeEnd() {
        return orderCreateTimeEnd;
    }

    public void setOrderCreateTimeEnd(Date orderCreateTimeEnd) {
        this.orderCreateTimeEnd = orderCreateTimeEnd;
    }

    public Date getLastUpdateTimeStart() {
        return lastUpdateTimeStart;
    }

    public void setLastUpdateTimeStart(Date lastUpdateTimeStart) {
        this.lastUpdateTimeStart = lastUpdateTimeStart;
    }

    public Date getLastUpdateTimeEnd() {
        return lastUpdateTimeEnd;
    }

    public void setLastUpdateTimeEnd(Date lastUpdateTimeEnd) {
        this.lastUpdateTimeEnd = lastUpdateTimeEnd;
    }

    public List<Byte> getStates() {
        return states;
    }

    public void setStates(List<Byte> states) {
        this.states = states;
    }

    public List<Byte> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<Byte> orderTypes) {
        this.orderTypes = orderTypes;
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

    public Long getShopExternalId() {
        return shopExternalId;
    }

    public void setShopExternalId(Long shopExternalId) {
        this.shopExternalId = shopExternalId;
    }

    public Byte getPreSaleType() {
        return preSaleType;
    }

    public void setPreSaleType(Byte preSaleType) {
        this.preSaleType = preSaleType;
    }

    public Byte getAddressError() {
        return addressError;
    }

    public void setAddressError(Byte addressError) {
        this.addressError = addressError;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public String getProductSkuName() {
        return productSkuName;
    }

    public void setProductSkuName(String productSkuName) {
        this.productSkuName = productSkuName;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getRoutingName() {
        return routingName;
    }

    public void setRoutingName(String routingName) {
        this.routingName = routingName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Byte getCombineStatus() {
        return combineStatus;
    }

    public void setCombineStatus(Byte combineStatus) {
        this.combineStatus = combineStatus;
    }

    public Byte getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(Byte exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public Byte getTakeType() {
        return takeType;
    }

    public void setTakeType(Byte takeType) {
        this.takeType = takeType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(Integer bizUserId) {
        this.bizUserId = bizUserId;
    }

    public String getHopeDeliveryTimeStart() {
        return hopeDeliveryTimeStart;
    }

    public void setHopeDeliveryTimeStart(String hopeDeliveryTimeStart) {
        this.hopeDeliveryTimeStart = hopeDeliveryTimeStart;
    }

    public String getHopeDeliveryTimeEnd() {
        return hopeDeliveryTimeEnd;
    }

    public void setHopeDeliveryTimeEnd(String hopeDeliveryTimeEnd) {
        this.hopeDeliveryTimeEnd = hopeDeliveryTimeEnd;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getBusinessNos() {
        return businessNos;
    }

    public void setBusinessNos(List<String> businessNos) {
        this.businessNos = businessNos;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Boolean getPickMarker() {
        return pickMarker;
    }

    public void setPickMarker(Boolean pickMarker) {
        this.pickMarker = pickMarker;
    }

    public Integer getQueryPayTime() {
        return queryPayTime;
    }

    public void setQueryPayTime(Integer queryPayTime) {
        this.queryPayTime = queryPayTime;
    }

    public Date getStartPayTime() {
        return startPayTime;
    }

    public void setStartPayTime(Date startPayTime) {
        this.startPayTime = startPayTime;
    }

    public Date getEndPayTime() {
        return endPayTime;
    }

    public void setEndPayTime(Date endPayTime) {
        this.endPayTime = endPayTime;
    }

    public List<Byte> getAllotTypes() {
        return allotTypes;
    }

    public void setAllotTypes(List<Byte> allotTypes) {
        this.allotTypes = allotTypes;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
