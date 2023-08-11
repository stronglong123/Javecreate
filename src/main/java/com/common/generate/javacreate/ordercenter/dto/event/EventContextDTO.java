package com.common.generate.javacreate.ordercenter.dto.event;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

//@ApiModel(description = "事件上下文")
public class EventContextDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 事件Id，如果为空，则取rabbitmq的messageId
     */
    //(description = "事件ID")
    private String eventId;
    /**
     * 公司code
     */
    //(description = "公司code")
    private String companyCode;
    /**
     * 接入方应用
     */
    //(description = "接入方应用")
    private String partnerCode;

    /**
     * 要发布的事件Code
     */
    //(description = "要发布的事件Code")
    private String eventCode;

    /**
     * 事件消息体，JSON格式
     */
    private Object body;

    /**
     * 属性，用于扩展
     */
    //(description = "属性，用于扩展")
    private Map<String, Object> attribute;

    /**
     * 事件发布时间
     */
    //(description = "事件发布时间")
    private Date publishTime;

    /**
     * 源业务流程Code
     */
    //(description = "源业务流程Code")
    private String sourceBusinessFlowCode;
    /**
     * 源业务流程Id
     */
    //(description = "源业务流程Id")
    private String sourceBusinessFlowId;
    /**
     * 源服务名
     */
    //(description = "源服务名")
    private String sourceApplicationName;

    //(description = "订阅消费者应用")
    private String consumerPartnerCode;

    //(description = "应用方经销商id")
    private String dealerId;

    //(description = "应用方仓库类型")
    private Integer warehouseType;


    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Map<String, Object> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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

    public String getConsumerPartnerCode() {
        return consumerPartnerCode;
    }

    public void setConsumerPartnerCode(String consumerPartnerCode) {
        this.consumerPartnerCode = consumerPartnerCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(Integer warehouseType) {
        this.warehouseType = warehouseType;
    }
}
