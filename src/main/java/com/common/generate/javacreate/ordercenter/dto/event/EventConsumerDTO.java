package com.common.generate.javacreate.ordercenter.dto.event;


import java.util.Date;
import java.util.List;

/**
 * 事件消费者
 */
public class EventConsumerDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String companyCode;

    /**
     * 接入方应用
     */
    private String partnerCode;

    /**
     * 消费者名字
     */
    private String consumerName;

    private String remark;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 事件规则
     */
    private EventRuleDTO eventRuleDTO;

    /**
     * 回调URL
     */
    private String url;

    /**
     * 超时时间，单位是毫秒。默认3秒钟
     */
    private Integer timeout = 3000;


    private Integer retryCount = 0;

    private Integer retryInterval = 3000;

    /**
     * 订阅的事件编码
     */
    private String subscribedEventCodes;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后一次更新时间
     */
    private Date lastUpdateTime;

    private List<EventConsumerRegisterDTO> eventRegisterList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public EventRuleDTO getEventRuleDTO() {
        return eventRuleDTO;
    }

    public void setEventRuleDTO(EventRuleDTO eventRuleDTO) {
        this.eventRuleDTO = eventRuleDTO;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    /**
     * 获取 订阅的事件编码
     *
     * @return subscribedEventCodes 订阅的事件编码
     */
    public String getSubscribedEventCodes() {
        return this.subscribedEventCodes;
    }

    /**
     * 设置 订阅的事件编码
     *
     * @param subscribedEventCodes 订阅的事件编码
     */
    public void setSubscribedEventCodes(String subscribedEventCodes) {
        this.subscribedEventCodes = subscribedEventCodes;
    }

    public List<EventConsumerRegisterDTO> getEventRegisterList() {
        return eventRegisterList;
    }

    public void setEventRegisterList(List<EventConsumerRegisterDTO> eventRegisterList) {
        this.eventRegisterList = eventRegisterList;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
