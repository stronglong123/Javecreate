package com.common.generate.javacreate.ordercenter.dto.event;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件订阅-HTTP消费
 *
 * @author ZhouXin
 */
public class EventConsumptionHttpInvokeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

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
     * 数据可见性
     */
    private Integer visibility;

    /**
     * 关联的事件订阅场景Id
     */
    private String eventSubscriptionId;

    /**
     * 回调URL
     */
    private String url;

    /**
     * 超时时间，单位是毫秒。默认3秒钟
     */
    private Integer timeout = 3000;

    /**
     * 重试次数。默认是0，即失败不重试
     * 只有返回值不等于200，或返回值等于200但返回的错误是非业务错误时，才会触发重试
     *
     * @see com.yijiupi.himalaya.ordercenter.event.dto.context.EventConsumptionHttpResult
     */
    private Integer retryCount = 0;

    /**
     * 重试间隔，单位是毫秒。默认3秒钟
     */
    private Integer retryInterval = 3000;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次更新时间
     */
    private Date lastUpdateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEventSubscriptionId() {
        return eventSubscriptionId;
    }

    public void setEventSubscriptionId(String eventSubscriptionId) {
        this.eventSubscriptionId = eventSubscriptionId;
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

    public Date getCreateTime() {
        return createTime;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
