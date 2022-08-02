package com.common.generate.javacreate.ordercenter.dto.event;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件订阅场景
 * @author ZhouXin
 */
public class EventSubscriptionDTO implements Serializable {
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

    private String subscribeCompanyCode;

    /**
     * 事件消费类型
     */
    private Integer eventConsumptionType;

    /**
     * 延时发送时间，单位是毫秒,默认不延时
     */
    private Integer delayTime = 0;

    /**
     *事件消费对象
     */
    private EventConsumptionHttpInvokeDTO eventConsumptionHttpInvokeDTO;


    /**
     * 事件规则
     */
    private EventRuleDTO eventRuleDTO;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次更新时间
     */
    private Date lastUpdateTime;

	/**
	 * 生产环境是否禁用
	 */
	private Boolean proDisable;

    private String bindId;

	private String bindCode;

	private String bindName;

	private String bindPartnerCode;

    public String getBindId() {
        return bindId;
    }

    public void setBindId(String bindId) {
        this.bindId = bindId;
    }

    public String getBindPartnerCode() {
        return bindPartnerCode;
    }

    public void setBindPartnerCode(String bindPartnerCode) {
        this.bindPartnerCode = bindPartnerCode;
    }

    public String getBindCode() {
        return bindCode;
    }

    public void setBindCode(String bindCode) {
        this.bindCode = bindCode;
    }

    public String getBindName() {
        return bindName;
    }

    public void setBindName(String bindName) {
        this.bindName = bindName;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

    public EventConsumptionHttpInvokeDTO getEventConsumptionHttpInvokeDTO() {
        return eventConsumptionHttpInvokeDTO;
    }

    public void setEventConsumptionHttpInvokeDTO(EventConsumptionHttpInvokeDTO eventConsumptionHttpInvokeDTO) {
        this.eventConsumptionHttpInvokeDTO = eventConsumptionHttpInvokeDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubscribeName() {
        return subscribeName;
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public EventRuleDTO getEventRuleDTO() {
        return eventRuleDTO;
    }

    public void setEventRuleDTO(EventRuleDTO eventRuleDTO) {
        this.eventRuleDTO = eventRuleDTO;
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

	public Boolean getProDisable() {
		return proDisable;
	}

	public void setProDisable(Boolean proDisable) {
		this.proDisable = proDisable;
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
