package com.common.generate.javacreate.test.transferNote;

import com.common.generate.javacreate.model.base.search.PageCondition;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class OutStockOrderQueryDTO extends PageCondition {

	/**
     * 城市id
     */
    private Integer orgId;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 单据编号
     */
    private String refOrderNo;

    /**
     * 审核状态
     */
    private Byte businessState;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单据类型
     */
    private Byte orderType;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 单据类型集合
     */
    private List<Byte> orderTypes;


    /**
     * 订单编号集合
     */
    private List<String> refOrderNos;

    /**
     * 是否查询明细项(0:否，1:是)
     */
    private Integer queryOrderItems = 0;

    /**
     * 关联单号
     */
    private String associatedBusinessNo;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 库内作业状态： 待调度(0),待拣货(1),拣货中(2),已拣货(3),已出库(4),已取消(5),已作废(6)
     */
    private Byte state;

    /** 收货地址-省市*/
    private String province;
    /** 收货地址-城市*/
    private String city;
    /** 收货地址-区*/
    private String county;
    /** 收货地址-街道*/
    private String street;

    /**
     * 三方单号
     */
    private List<String> businessNos;

    /**
     * 订单id
     */
    private List<Long> orderIds;

    /**
     * 单据状态
     */
    private List<Byte> states;

    /**
     * 不被搜索的业务单据类型
     */
    private List<Byte> notBusinessTypes;

    /**
     * 指定搜索的业务单据类型
     */
    private List<Byte> businessTypes;

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

    public String getRefOrderNo() {
        return refOrderNo;
    }

    public void setRefOrderNo(String refOrderNo) {
        this.refOrderNo = refOrderNo;
    }

    public Byte getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Byte businessState) {
        this.businessState = businessState;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Byte> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<Byte> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public List<String> getRefOrderNos() {
        return refOrderNos;
    }

    public void setRefOrderNos(List<String> refOrderNos) {
        this.refOrderNos = refOrderNos;
    }
    public Integer getQueryOrderItems() {
        return queryOrderItems;
    }

    public void setQueryOrderItems(Integer queryOrderItems) {
        this.queryOrderItems = queryOrderItems;
    }

    public String getAssociatedBusinessNo() {
        return associatedBusinessNo;
    }

    public void setAssociatedBusinessNo(String associatedBusinessNo) {
        this.associatedBusinessNo = associatedBusinessNo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public List<String> getBusinessNos() {
        return businessNos;
    }

    public void setBusinessNos(List<String> businessNos) {
        this.businessNos = businessNos;
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    public List<Byte> getStates() {
        return states;
    }

    public void setStates(List<Byte> states) {
        this.states = states;
    }

	public List<Byte> getNotBusinessTypes() {
		return notBusinessTypes;
	}

	public void setNotBusinessTypes(List<Byte> notBusinessTypes) {
		this.notBusinessTypes = notBusinessTypes;
	}

	public List<Byte> getBusinessTypes() {
		return businessTypes;
	}

	public void setBusinessTypes(List<Byte> businessTypes) {
		this.businessTypes = businessTypes;
	}
}