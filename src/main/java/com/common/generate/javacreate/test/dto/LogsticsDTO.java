package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/9/18 9:25
 */
public class LogsticsDTO implements Serializable {

    private static final long serialVersionUID = 1450332566194337837L;
    /**
     * 快递编码
     */
    private String logisticsCompanyCode;
    /**
     * 快递公司名称
     */
    private String logisticsCompany;
    /**
     * 快递单号
     */
    private String logisticsNo;
    /**
     * 快递系统Code（1.拼多多。2.菜鸟。3.京东）
     */
    private String systemCode;
    /**
     * 子订单号，如没有拆单，则子订单号与原始单号相同
     */
    private String subOrderNo;

    /**
     * 子订单项
     */
    private List<SubOrderItemsDTO> subOrderItems;


    public String getLogisticsCompanyCode() {
        return logisticsCompanyCode;
    }

    public void setLogisticsCompanyCode(String logisticsCompanyCode) {
        this.logisticsCompanyCode = logisticsCompanyCode;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSubOrderNo() {
        return subOrderNo;
    }

    public void setSubOrderNo(String subOrderNo) {
        this.subOrderNo = subOrderNo;
    }

    public List<SubOrderItemsDTO> getSubOrderItems() {
        return subOrderItems;
    }

    public void setSubOrderItems(List<SubOrderItemsDTO> subOrderItems) {
        this.subOrderItems = subOrderItems;
    }
}
