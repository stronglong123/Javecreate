package com.common.generate.javacreate.ordercenter.dto.eventaudit;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 事件发布审计
 *
 * @author ZhouXin
 */
public class EventPublishAuditDocumentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 事件Id
     */
    private String eventId;

    /**
     * 公司code
     */
    private String companyCode;
    /**
     * 接入方应用
     */
    private String partnerCode;

    /**
     * 要发布的事件Code
     */
    private String eventCode;

    /**
     * 事件消息体，JSON格式
     */
    private String body;

    /**
     * 属性，过于扩展
     */
    private Map<String, Object> attribute;

    /**
     * 事件发布时间
     */
    private Date publishTime;
    /**
     * 插入时间
     */
    private Date insertTime;
    /**
     * 源业务流程Code
     */
    private String sourceBusinessFlowCode;
    /**
     * 源业务流程Id
     */
    private String sourceBusinessFlowId;
    /**
     * 源服务名
     */
    private String sourceApplicationName;


    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Map<String, Object> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    public String getSourceApplicationName() {
        return sourceApplicationName;
    }

    public void setSourceApplicationName(String sourceApplicationName) {
        this.sourceApplicationName = sourceApplicationName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
