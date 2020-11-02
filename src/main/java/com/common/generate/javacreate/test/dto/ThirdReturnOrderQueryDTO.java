package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/10/15 14:29
 */
public class ThirdReturnOrderQueryDTO implements Serializable {

    private static final long serialVersionUID = -9027907650190434356L;
    /**
     * 城市ID
     */
    private Integer orgId;
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
     * 单据下单开始时间
     */
    private String orderCreateTimeStart;
    /**
     * 单据下单结束时间
     */
    private String orderCreateTimeEnd;
    /**
     * 订单状态
     */
    private List<Byte> states;
    /**
     * 订单类型
     */
    private List<Byte> orderTypes;
    /**
     * 订单来源
     */
    private Byte orderSource;
    /**
     * 关联单号
     */
    private String refNo;
    /**
     * 组织结构
     */
    private List<String> companyCodes;
    /**
     * 配送模式
     */
    private List<Byte> deliveryModes;
    /**
     * @Fields 当前页
     */
    private Integer currentPage;

    /**
     * @Fields 每页的数量
     */
    private Integer pageSize;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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

    public String getOrderCreateTimeStart() {
        return orderCreateTimeStart;
    }

    public void setOrderCreateTimeStart(String orderCreateTimeStart) {
        this.orderCreateTimeStart = orderCreateTimeStart;
    }

    public String getOrderCreateTimeEnd() {
        return orderCreateTimeEnd;
    }

    public void setOrderCreateTimeEnd(String orderCreateTimeEnd) {
        this.orderCreateTimeEnd = orderCreateTimeEnd;
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

    public Byte getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public List<String> getCompanyCodes() {
        return companyCodes;
    }

    public void setCompanyCodes(List<String> companyCodes) {
        this.companyCodes = companyCodes;
    }

    public List<Byte> getDeliveryModes() {
        return deliveryModes;
    }

    public void setDeliveryModes(List<Byte> deliveryModes) {
        this.deliveryModes = deliveryModes;
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
