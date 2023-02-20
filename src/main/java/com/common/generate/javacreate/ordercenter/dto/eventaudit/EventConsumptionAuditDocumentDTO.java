package com.common.generate.javacreate.ordercenter.dto.eventaudit;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件中心订阅审计
 *
 * @author ZhouXin
 */
public class EventConsumptionAuditDocumentDTO implements Serializable {
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
     *
     * @see com.yijiupi.himalaya.ordercenter.common.enums.Visibility
     */
    private Integer visibility;

    /**
     * 事件Id
     */
    private String eventId;

    /**
     * 关联的事件订阅场景Id
     */
    private String eventSubscriptionId;

    /**
     * 源业务流程Code
     */
    private String sourceBusinessFlowCode;
    /**
     * 源业务流程Id
     */
    private String sourceBusinessFlowId;
    /**
     * 订阅的事件
     */
    private String subscribeEventCode;
    /**
     * 订阅的应用Code
     */
    private String subscribePartnerCode;

    private String subscribeCompanyCode;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 是否成功
     *
     */
    private Integer success;
    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 备注 模糊查询
     */
    private String remark;

    /**
     * 事件订阅场景名字
     */
    private String eventSubscriptionName;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventSubscriptionName() {
        return eventSubscriptionName;
    }

    public void setEventSubscriptionName(String eventSubscriptionName) {
        this.eventSubscriptionName = eventSubscriptionName;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
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

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventSubscriptionId() {
        return eventSubscriptionId;
    }

    public void setEventSubscriptionId(String eventSubscriptionId) {
        this.eventSubscriptionId = eventSubscriptionId;
    }

    public String getSourceBusinessFlowCode() {
        return sourceBusinessFlowCode;
    }

    public void setSourceBusinessFlowCode(String sourceBusinessFlowCode) {
        this.sourceBusinessFlowCode = sourceBusinessFlowCode;
    }

    public String getSourceBusinessFlowId() {
        return sourceBusinessFlowId;
    }

    public void setSourceBusinessFlowId(String sourceBusinessFlowId) {
        this.sourceBusinessFlowId = sourceBusinessFlowId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
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
}
