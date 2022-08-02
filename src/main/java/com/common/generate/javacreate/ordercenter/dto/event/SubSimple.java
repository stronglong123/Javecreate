package com.common.generate.javacreate.ordercenter.dto.event;

/**
 * @author xialei
 * @date 2022/7/21 15:45
 */
public class SubSimple {

    private String id;
    /**
     * 公司code
     */
    private String companyCode;
    /**
     * 接入方应用
     */
    private String partnerCode;
    /**
     * 订阅的名字
     */
    private String subscribeName;

    /**
     * 事件消费类型
     */
    private Integer eventConsumptionType;


    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getSubscribeName() {
        return subscribeName;
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName;
    }

    public Integer getEventConsumptionType() {
        return eventConsumptionType;
    }

    public void setEventConsumptionType(Integer eventConsumptionType) {
        this.eventConsumptionType = eventConsumptionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}