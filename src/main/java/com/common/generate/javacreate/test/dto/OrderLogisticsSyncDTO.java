package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/8/18 10:23
 */
public class OrderLogisticsSyncDTO implements Serializable {

    private static final long serialVersionUID = 6492882875066597194L;

    /**
     * 系统编码
     */
    private String systemCode;

    private List<Integer> warehouseIds;

    /**
     * 订单号
     */
    private String businessNo;
    /**
     * 物流公司名称
     */
    public String logisticsCompany;
    /**
     * 物流公司编码
     */
    public String logisticsCompanyCode;
    /**
     * 物流单号
     */
    public String logisticsNo;
    /**
     * 客户录入信息，京东商家编码或顺丰手机号后四位
     */
    private String customerNo;
    /**
     * oms订单id
     */
    private Long omsOrderId;
    /**
     * 操作人
     */
    private Integer optUserId;
    /**
     * 城市id
     */
    private Integer orgId;
    /**
     * 物流单订单类型 0酒批单1退货单
     */
    private Integer logisticsOrderType;

//    private Long timestamp;
//
//    private String sid;
//
//    public String getSid() {
//        return sid;
//    }
//
//    public void setSid(String sid) {
//        this.sid = sid;
//    }
//
//    public Long getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Long timestamp) {
//        this.timestamp = timestamp;
//    }

    public List<Integer> getWarehouseIds() {
        return warehouseIds;
    }

    public void setWarehouseIds(List<Integer> warehouseIds) {
        this.warehouseIds = warehouseIds;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsCompanyCode() {
        return logisticsCompanyCode;
    }

    public void setLogisticsCompanyCode(String logisticsCompanyCode) {
        this.logisticsCompanyCode = logisticsCompanyCode;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Long getOmsOrderId() {
        return omsOrderId;
    }

    public void setOmsOrderId(Long omsOrderId) {
        this.omsOrderId = omsOrderId;
    }

    public Integer getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(Integer optUserId) {
        this.optUserId = optUserId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getLogisticsOrderType() {
        return logisticsOrderType;
    }

    public void setLogisticsOrderType(Integer logisticsOrderType) {
        this.logisticsOrderType = logisticsOrderType;
    }
}
