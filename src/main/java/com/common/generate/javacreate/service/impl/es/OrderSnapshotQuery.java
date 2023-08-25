package com.common.generate.javacreate.service.impl.es;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderSnapshotQuery implements Serializable {
    private static final long serialVersionUID = -1L;


    private String orderWord;

    /**
     * 订单Id
     */
    private Long orderId;
    /**
     * 订单Id
     */
    private List<Long> orderIds;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 一级单据类型
     */
    private Integer firstOrderType;

    /**
     * 订单状态
     */
    private Integer state;

    /**
     * 收货人
     */
    private String contact;

    /**
     * 收货人电话
     */
    private String contactPhone;

    /**
     * 收货地址-省
     */
    private String contactProvince;

    /**
     * 收货地址-市
     */
    private String contactCity;

    /**
     * 收货地址-县(区)
     */
    private String contactCounty;

    /**
     * 下单时间-开始(开区间)
     */
    private Date orderCreateTimeStart;


    /**
     * 下单时间-结束(闭区间)
     */
    private Date orderCreateTimeEnd;

    /**
     * 完成时间-开始(开区间)
     *
     * @return
     */
    private Date orderCompleteTimeStart;

    /**
     * 完成时间-结束(闭区间)
     */
    private Date orderCompleteTimeEnd;

    /**
     * 公司Code
     */
    private String companyCode;

    /**
     * 经销商Id
     */
    private String dealerId;
    /**
     * 经销商Id
     */
    private List<String> dealerIds;

    private Long fromWarehouseId;

    private List<Long> fromWarehouseIds;

    /**
     * 仓库id
     */
    private Long warehouseId;

    /**
     * 仓库Id
     */
    private List<Long> warehouseIds;

    private Long anyWarehouseId;

    private List<Long> anyWarehouseIds;

    /**
     * 店铺Id
     */
    private Long shopId;

    /**
     * 店铺Id
     */
    private List<Long> shopIds;

    /**
     * 是否按照订单创建时间排序
     * 0为正序,1为倒序,若不传则默认倒叙
     */
    private Integer sortByOrderCreateTime;

    private Integer printTimesStart;

    private Integer printTimesEnd;

    private Integer deliveryMode;
    private List<Integer> deliveryModes;

    private Date estimatedDeliveryTimeStart;

    private Date estimatedDeliveryTimeEnd;

    private String productName;

    private Long productSpecificationId;

    private List<Integer> states;

    private List<Long> firstOrderTypes;
    private Integer offlineFlag;

    private List<Integer> tagTypes;

    private List<Integer> exceptionTypes;

    private Integer exceptionState;

    private Integer preSaleType;

    private String consignor;

    private String consignorPhone;

    private String consignorProvince;

    private String consignorCity;

    private String consignorCounty;

    /**
     * 结账仓库(销售单)
     */
    private Long checkoutWarehouseId;

    /**
     * 结账仓库(销售单)
     */
    private List<Long> checkoutWarehouseIds;

    /**
     * TMS链路所有仓库
     */
    private Long routeWarehouseId;

    /**
     * TMS链路所有仓库
     */
    private List<Long> routeWarehouseIds;

    /**
     * 调入仓库
     */
    private Long toWarehouseId;

    /**
     * 调入仓库
     */
    private List<Long> toWarehouseIds;

    /**
     * 出库时间-结束(闭区间)
     */
    private Date outStockTimeStart;

    /**
     * 出库时间-结束(闭区间)
     */
    private Date outStockTimeEnd;

    /**
     * 预售最晚到货时间-开始(开区间)
     *
     * @return
     */
    private Date latestDeliveryTimeStart;

    /**
     * 预售最晚到货时间-结束(闭区间)
     */
    private Date latestDeliveryTimeEnd;

    /**
     * 用户确认收货到期时间-开始(开区间)
     *
     * @return
     */
    private Date receiptDeadlineTimeStart;

    /**
     * 用户确认收货到期时间-结束(闭区间)
     */
    private Date receiptDeadlineTimeTimeEnd;

    /**
     * 最后更新时间-开始(开区间)
     */
    private Date lastUpdateTimeStart;

    /**
     * 最后更新时间-结束(闭区间)
     */
    private Date lastUpdateTimeEnd;
    /**
     * 发货人用户id
     */
    private String consignorUserId;
    /**
     * 收货人用户id
     */
    private String contactUserId;

    private String refOrderNo;

    public String getRefOrderNo() {
        return this.refOrderNo;
    }

    public void setRefOrderNo(final String refOrderNo) {
        this.refOrderNo = refOrderNo;
    }

    public String getConsignorUserId() {
        return this.consignorUserId;
    }

    public void setConsignorUserId(String consignorUserId) {
        this.consignorUserId = consignorUserId;
    }

    public String getContactUserId() {
        return this.contactUserId;
    }

    public void setContactUserId(String contactUserId) {
        this.contactUserId = contactUserId;
    }

    public Long getCheckoutWarehouseId() {
        return checkoutWarehouseId;
    }

    public void setCheckoutWarehouseId(Long checkoutWarehouseId) {
        this.checkoutWarehouseId = checkoutWarehouseId;
    }

    public Long getRouteWarehouseId() {
        return routeWarehouseId;
    }

    public void setRouteWarehouseId(Long routeWarehouseId) {
        this.routeWarehouseId = routeWarehouseId;
    }

    public Long getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Long toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public List<Integer> getStates() {
        return states;
    }

    public void setStates(List<Integer> states) {
        this.states = states;
    }

    public List<Long> getFirstOrderTypes() {
        return firstOrderTypes;
    }

    public void setFirstOrderTypes(List<Long> firstOrderTypes) {
        this.firstOrderTypes = firstOrderTypes;
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    public Integer getOfflineFlag() {
        return offlineFlag;
    }

    public void setOfflineFlag(Integer offlineFlag) {
        this.offlineFlag = offlineFlag;
    }

    public List<Integer> getTagTypes() {
        return tagTypes;
    }

    public void setTagTypes(List<Integer> tagTypes) {
        this.tagTypes = tagTypes;
    }

    public List<Integer> getExceptionTypes() {
        return exceptionTypes;
    }

    public void setExceptionTypes(List<Integer> exceptionTypes) {
        this.exceptionTypes = exceptionTypes;
    }

    public Integer getExceptionState() {
        return exceptionState;
    }

    public void setExceptionState(Integer exceptionState) {
        this.exceptionState = exceptionState;
    }

    public Integer getPreSaleType() {
        return preSaleType;
    }

    public void setPreSaleType(Integer preSaleType) {
        this.preSaleType = preSaleType;
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

    public String getConsignorProvince() {
        return consignorProvince;
    }

    public void setConsignorProvince(String consignorProvince) {
        this.consignorProvince = consignorProvince;
    }

    public String getConsignorCity() {
        return consignorCity;
    }

    public void setConsignorCity(String consignorCity) {
        this.consignorCity = consignorCity;
    }

    public String getConsignorCounty() {
        return consignorCounty;
    }

    public void setConsignorCounty(String consignorCounty) {
        this.consignorCounty = consignorCounty;
    }

    public Integer getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Integer deliveryMode) {
        this.deliveryMode = deliveryMode;
    }


    public Date getEstimatedDeliveryTimeStart() {
        return estimatedDeliveryTimeStart;
    }

    public void setEstimatedDeliveryTimeStart(Date estimatedDeliveryTimeStart) {
        this.estimatedDeliveryTimeStart = estimatedDeliveryTimeStart;
    }

    public Date getEstimatedDeliveryTimeEnd() {
        return estimatedDeliveryTimeEnd;
    }

    public void setEstimatedDeliveryTimeEnd(Date estimatedDeliveryTimeEnd) {
        this.estimatedDeliveryTimeEnd = estimatedDeliveryTimeEnd;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Integer getFirstOrderType() {
        return firstOrderType;
    }

    public void setFirstOrderType(Integer firstOrderType) {
        this.firstOrderType = firstOrderType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getContactProvince() {
        return contactProvince;
    }

    public void setContactProvince(String contactProvince) {
        this.contactProvince = contactProvince;
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity;
    }

    public String getContactCounty() {
        return contactCounty;
    }

    public void setContactCounty(String contactCounty) {
        this.contactCounty = contactCounty;
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

    public Date getOrderCompleteTimeStart() {
        return orderCompleteTimeStart;
    }

    public void setOrderCompleteTimeStart(Date orderCompleteTimeStart) {
        this.orderCompleteTimeStart = orderCompleteTimeStart;
    }

    public Date getOrderCompleteTimeEnd() {
        return orderCompleteTimeEnd;
    }

    public void setOrderCompleteTimeEnd(Date orderCompleteTimeEnd) {
        this.orderCompleteTimeEnd = orderCompleteTimeEnd;
    }

    public Long getAnyWarehouseId() {
        return anyWarehouseId;
    }

    public void setAnyWarehouseId(Long anyWarehouseId) {
        this.anyWarehouseId = anyWarehouseId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getSortByOrderCreateTime() {
        return sortByOrderCreateTime;
    }

    public void setSortByOrderCreateTime(Integer sortByOrderCreateTime) {
        this.sortByOrderCreateTime = sortByOrderCreateTime;
    }

    public String getOrderWord() {
        return orderWord;
    }

    public void setOrderWord(String orderWord) {
        this.orderWord = orderWord;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getFromWarehouseId() {
        return fromWarehouseId;
    }

    public void setFromWarehouseId(Long fromWarehouseId) {
        this.fromWarehouseId = fromWarehouseId;
    }


    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getPrintTimesStart() {
        return printTimesStart;
    }

    public void setPrintTimesStart(Integer printTimesStart) {
        this.printTimesStart = printTimesStart;
    }

    public Integer getPrintTimesEnd() {
        return printTimesEnd;
    }

    public void setPrintTimesEnd(Integer printTimesEnd) {
        this.printTimesEnd = printTimesEnd;
    }

    public Date getOutStockTimeStart() {
        return outStockTimeStart;
    }

    public void setOutStockTimeStart(Date outStockTimeStart) {
        this.outStockTimeStart = outStockTimeStart;
    }

    public Date getOutStockTimeEnd() {
        return outStockTimeEnd;
    }

    public void setOutStockTimeEnd(Date outStockTimeEnd) {
        this.outStockTimeEnd = outStockTimeEnd;
    }

    public Date getLatestDeliveryTimeStart() {
        return latestDeliveryTimeStart;
    }

    public void setLatestDeliveryTimeStart(Date latestDeliveryTimeStart) {
        this.latestDeliveryTimeStart = latestDeliveryTimeStart;
    }

    public Date getLatestDeliveryTimeEnd() {
        return latestDeliveryTimeEnd;
    }

    public void setLatestDeliveryTimeEnd(Date latestDeliveryTimeEnd) {
        this.latestDeliveryTimeEnd = latestDeliveryTimeEnd;
    }

    public Date getReceiptDeadlineTimeStart() {
        return receiptDeadlineTimeStart;
    }

    public void setReceiptDeadlineTimeStart(Date receiptDeadlineTimeStart) {
        this.receiptDeadlineTimeStart = receiptDeadlineTimeStart;
    }

    public Date getReceiptDeadlineTimeTimeEnd() {
        return receiptDeadlineTimeTimeEnd;
    }

    public void setReceiptDeadlineTimeTimeEnd(Date receiptDeadlineTimeTimeEnd) {
        this.receiptDeadlineTimeTimeEnd = receiptDeadlineTimeTimeEnd;
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



    public List<String> getDealerIds() {
        return dealerIds;
    }

    public void setDealerIds(List<String> dealerIds) {
        this.dealerIds = dealerIds;
    }

    public List<Long> getFromWarehouseIds() {
        return fromWarehouseIds;
    }

    public void setFromWarehouseIds(List<Long> fromWarehouseIds) {
        this.fromWarehouseIds = fromWarehouseIds;
    }

    public List<Long> getWarehouseIds() {
        return warehouseIds;
    }

    public void setWarehouseIds(List<Long> warehouseIds) {
        this.warehouseIds = warehouseIds;
    }

    public List<Long> getAnyWarehouseIds() {
        return anyWarehouseIds;
    }

    public void setAnyWarehouseIds(List<Long> anyWarehouseIds) {
        this.anyWarehouseIds = anyWarehouseIds;
    }

    public List<Long> getShopIds() {
        return shopIds;
    }

    public void setShopIds(List<Long> shopIds) {
        this.shopIds = shopIds;
    }

    public List<Long> getCheckoutWarehouseIds() {
        return checkoutWarehouseIds;
    }

    public void setCheckoutWarehouseIds(List<Long> checkoutWarehouseIds) {
        this.checkoutWarehouseIds = checkoutWarehouseIds;
    }

    public List<Long> getRouteWarehouseIds() {
        return routeWarehouseIds;
    }

    public void setRouteWarehouseIds(List<Long> routeWarehouseIds) {
        this.routeWarehouseIds = routeWarehouseIds;
    }

    public List<Long> getToWarehouseIds() {
        return toWarehouseIds;
    }

    public void setToWarehouseIds(List<Long> toWarehouseIds) {
        this.toWarehouseIds = toWarehouseIds;
    }

    public List<Integer> getDeliveryModes() {
        return deliveryModes;
    }

    public void setDeliveryModes(List<Integer> deliveryModes) {
        this.deliveryModes = deliveryModes;
    }
}
