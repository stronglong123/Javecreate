package com.common.generate.javacreate.ordercenter.dto.data;

import java.util.Date;

/**
 * @ClassName OrderExtensionsBO
 * @Description oms第三方订单来源
 * @Author hhw
 * @Date 2022/5/11 11:47
 * @Version 1.0
 **/
public class OrderExtensionsBO {

    private Long id;

    /**
     * oms订单id
     */
    private Long order_Id;

    /**
     * 第三方订单编码
     */
    private String thirdOrderNo;

    /**
     * 服务商id
     */
    private Long parentOrg_Id;

    /**
     * 来源类型，0，易酒批，1、拼多多，2、淘宝，3、京东
     */
    private Integer orderSouorce;

    private Date createTime;

    private Date lastUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public String getThirdOrderNo() {
        return thirdOrderNo;
    }

    public void setThirdOrderNo(String thirdOrderNo) {
        this.thirdOrderNo = thirdOrderNo;
    }

    public Long getParentOrg_Id() {
        return parentOrg_Id;
    }

    public void setParentOrg_Id(Long parentOrg_Id) {
        this.parentOrg_Id = parentOrg_Id;
    }

    public Integer getOrderSouorce() {
        return orderSouorce;
    }

    public void setOrderSouorce(Integer orderSouorce) {
        this.orderSouorce = orderSouorce;
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
}

