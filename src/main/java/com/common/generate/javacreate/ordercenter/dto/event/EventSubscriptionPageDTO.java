package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.Date;

public class EventSubscriptionPageDTO {

    private static final long serialVersionUID = 1L;
    /**
     * 公司code
     */
    private String companyCode;
    /**
     * 接入方应用
     */
    private String partnerCode;

    /**
     * 数据可见性
     */
    private Integer visibility;

    /**
     * 订阅的名字
     */
    private String subscribeName;

    /**
     * 订阅的事件
     */
    private String subscribeEventCode;

    /**
     * 订阅的应用Code
     */
    private String subscribePartnerCode;

    /**
     * 订阅的公司Code
     */
    private String subscribeCompanyCode;

    /**
     * 事件消费类型
     */
    private Integer eventConsumptionType;

    /**
     * 预处理脚本
     */
    private String preHandle;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间（起始）
     */
    private Date createTimeStart;

    /**
     * 创建时间（结束）
     */
    private Date createTimeEnd;

    private Integer pageIndex = 1;
    private Integer pageSize = 20;

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getSubscribeName() {
        return subscribeName;
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName;
    }

    public String getSubscribeEventCode() {
        return subscribeEventCode;
    }

    public void setSubscribeEventCode(String subscribeEventCode) {
        this.subscribeEventCode = subscribeEventCode;
    }

    public String getSubscribePartnerCode() {
        return subscribePartnerCode;
    }

    public void setSubscribePartnerCode(String subscribePartnerCode) {
        this.subscribePartnerCode = subscribePartnerCode;
    }

    public Integer getEventConsumptionType() {
        return eventConsumptionType;
    }

    public void setEventConsumptionType(Integer eventConsumptionType) {
        this.eventConsumptionType = eventConsumptionType;
    }

    public String getPreHandle() {
        return preHandle;
    }

    public void setPreHandle(String preHandle) {
        this.preHandle = preHandle;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSubscribeCompanyCode() {
        return subscribeCompanyCode;
    }

    public void setSubscribeCompanyCode(String subscribeCompanyCode) {
        this.subscribeCompanyCode = subscribeCompanyCode;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
