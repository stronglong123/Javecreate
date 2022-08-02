package com.common.generate.javacreate.ordercenter.dto.event;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件模板
 *
 * @author ZhouXin
 */
public class EventRegisterDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String id;

    /**
     * 接入方应用(不可修改)
     */
    private String partnerCode;

    /**
     * 事件模板类型
     */
    private Integer eventRegisterType;

    /**
     * 数据可见性(不可修改)
     */
    private Integer visibility;

    /**
     * 事件Code（不可修改）
     */
    private String eventCode;

    /**
     * 事件名字
     */
    private String eventName;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 属性
     */
    private EventRegisterAttribute attributes;

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

    public Boolean getEnable() {
        return enable;
    }

    public Integer getEventRegisterType() {
        return eventRegisterType;
    }

    public void setEventRegisterType(Integer eventRegisterType) {
        this.eventRegisterType = eventRegisterType;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventRegisterAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(EventRegisterAttribute attributes) {
        this.attributes = attributes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

}
