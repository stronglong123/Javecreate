package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/8/7 9:54
 */
public class OrderQueryDTO implements Serializable {
    private static final long serialVersionUID = 8338129154881783847L;

    /** 快递单号 */
    private String logisticCode;
    /**
     * 城市ID
     */
    private Integer orgId;
    /**
     * 仓库IDS
     */
    private Integer warehouseId;

    /**
     * 单号
     */
    private String businessNo;

    /**
     * 订单状态
     */
    private List<Byte> states;

    /**
     * 单据下单开始时间
     */
    private String orderCreateTimeStart;
    /**
     * 单据下单结束时间
     */
    private String orderCreateTimeEnd;

    /**
     * 最后更新开始时间
     */
    private String lastUpdateTimeStart;
    /**
     * 最后更新结束时间
     */
    private String lastUpdateTimeEnd;

    private List<Integer> warehouseIds;

    private String code;


    private List<Byte> stateList;

    private Integer currentPage;

    private Integer pageSize;

    /**
     *   单据类型  1:订单，2:退货单
     */
    private List<Byte> businessTypes;


    public List<Byte> getStateList() {
        return stateList;
    }

    public void setStateList(List<Byte> stateList) {
        this.stateList = stateList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Integer> getWarehouseIds() {
        return warehouseIds;
    }

    public void setWarehouseIds(List<Integer> warehouseIds) {
        this.warehouseIds = warehouseIds;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
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

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public List<Byte> getStates() {
        return states;
    }

    public void setStates(List<Byte> states) {
        this.states = states;
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

    public String getLastUpdateTimeStart() {
        return lastUpdateTimeStart;
    }

    public void setLastUpdateTimeStart(String lastUpdateTimeStart) {
        this.lastUpdateTimeStart = lastUpdateTimeStart;
    }

    public String getLastUpdateTimeEnd() {
        return lastUpdateTimeEnd;
    }

    public void setLastUpdateTimeEnd(String lastUpdateTimeEnd) {
        this.lastUpdateTimeEnd = lastUpdateTimeEnd;
    }

    public List<Byte> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<Byte> businessTypes) {
        this.businessTypes = businessTypes;
    }
}
