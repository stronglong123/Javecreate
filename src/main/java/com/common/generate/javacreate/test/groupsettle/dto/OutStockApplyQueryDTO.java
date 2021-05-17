package com.common.generate.javacreate.test.groupsettle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class OutStockApplyQueryDTO  {
    /**
     * @Fields 当前页
     */
    private Integer currentPage = 1;

    /**
     * @Fields 每页的数量
     */
    private Integer pageSize = 20;
    /**
     * 城市id
     */
    private Integer orgId;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 单号
     */
    private String orderNo;

    /**
     * 客户名称
     */
    private String userName;

    /**
     * 出库开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 出库结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 查询模式
     */
    private Byte queryCondition = (byte) 1;

    /**
     * 状态
     */
    private List<Byte> states;

    /**
     * 单据类型
     */
    private List<Byte> orderTypes;

    /**
     *
     */
    private List<Byte> businessTypes;
    /**
     * 申请人id
     */
    private Integer applyUserId;

    /**
     * 申请人名称
     */
    private String applyUserName;

    /**
     * 关联单号
     */
    private String refOrderNo;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Byte getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(Byte queryCondition) {
        this.queryCondition = queryCondition;
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

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public List<Byte> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<Byte> businessTypes) {
        this.businessTypes = businessTypes;
    }

    public String getRefOrderNo() {
        return refOrderNo;
    }

    public void setRefOrderNo(String refOrderNo) {
        this.refOrderNo = refOrderNo;
    }
}
