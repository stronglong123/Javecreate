package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单基础信息
 *
 * @author Hu Liangzhi
 */
public class OrderBaseDTO implements Serializable {
    private static final long serialVersionUID = 5079932771578474388L;

    /**
     * 应用方code
     */
    //(description = "应用方code", required = true)
    private String partnerCode;

    //(description = "订单id")
    private Long orderId;

    // 上游传
    //(description = "订单号", required = true)
    private String orderNo;

    //(description = "订单短号")
    private String shortOrderNo;

    //(description = "业务id")
    private String businessId;

    /**
     * 一级单据类型  根据二级单据进行反查
     * 源于 表ordercenter_management.first_order_type
     */
    //(description = "一级单据")
    private Integer firstOrderType;

    /**
     * 公司code ？= orderSource 上下文取
     */
    //(description = "公司code", required = true)
    private String companyCode;

    //(description = "二级单据", required = true)
    private Integer secOrderType;

    //(description = "下单组织机构id", required = true)
    private Long orgId;

    /**
     * 源于 表ordercenter_management.order_status_config
     */
    //(description = "订单状态", required = true)
    private Integer state;

    //(description = "下单时间", required = true)
    private Date orderCreateTime;

    //(description = "完成时间")
    private Date orderCompleteTime;

    //(description = "系统备注")
    private String sysRemark;

    //(description = "创建时间")
    private Date createTime;

    //(description = "更新时间")
    private Date lastUpdateTime;


    //(description = "是否流程异常, 1-是, 0-否")
    private Boolean flowException;

    //(description = "订单是否有异常")
    private Boolean haveException;

    //(description = "订单运费")
    private BigDecimal deliveryFee;

    //(description = "店铺类型 普通经销商(0),易久批自营店铺(2),品牌商(3),虚仓实配-代运营店铺(4)")
    private Integer shopType;

    //(description = "订单来源类型")
    private Integer orderSourceType;

    //(description = "客服备注")
    private String customerRemark;

    //(description = "用户备注")
    private String userRemark;

    //(description = "经销商ID")
    private Long dealerId;

    //(description = "打印次数")
    private Integer printTimes;

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Boolean getFlowException() {
        return flowException;
    }

    public void setFlowException(Boolean flowException) {
        this.flowException = flowException;
    }

    public Boolean getHaveException() {
        return haveException;
    }

    public void setHaveException(Boolean haveException) {
        this.haveException = haveException;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getFirstOrderType() {
        return firstOrderType;
    }

    public void setFirstOrderType(Integer firstOrderType) {
        this.firstOrderType = firstOrderType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getSecOrderType() {
        return secOrderType;
    }

    public void setSecOrderType(Integer secOrderType) {
        this.secOrderType = secOrderType;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public String getShortOrderNo() {
        return shortOrderNo;
    }

    public void setShortOrderNo(String shortOrderNo) {
        this.shortOrderNo = shortOrderNo;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderCompleteTime() {
        return orderCompleteTime;
    }

    public void setOrderCompleteTime(Date orderCompleteTime) {
        this.orderCompleteTime = orderCompleteTime;
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    /**
     * 获取 //(description = "店铺类型 普通经销商(0)易久批自营店铺(2)品牌商(3)虚仓实配-代运营店铺(4)" required = true)
     *
     * @return shopType //(description = "店铺类型 普通经销商(0)易久批自营店铺(2)品牌商(3)虚仓实配-代运营店铺(4)" required = true)
     */
    public Integer getShopType() {
        return this.shopType;
    }

    /**
     * 设置 //(description = "店铺类型 普通经销商(0)易久批自营店铺(2)品牌商(3)虚仓实配-代运营店铺(4)" required = true)
     *
     * @param shopType //(description = "店铺类型 普通经销商(0)易久批自营店铺(2)品牌商(3)虚仓实配-代运营店铺(4)" required = true)
     */
    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    /**
     * 获取 //(description = "订单来源类型" required = true)
     *
     * @return orderSourceType //(description = "订单来源类型" required = true)
     */
    public Integer getOrderSourceType() {
        return this.orderSourceType;
    }

    /**
     * 设置 //(description = "订单来源类型" required = true)
     *
     * @param orderSourceType //(description = "订单来源类型" required = true)
     */
    public void setOrderSourceType(Integer orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    public Integer getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(Integer printTimes) {
        this.printTimes = printTimes;
    }
}
