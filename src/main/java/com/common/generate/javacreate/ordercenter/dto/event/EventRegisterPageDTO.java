package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.Date;
import java.util.List;

public class EventRegisterPageDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 授权的接入方列表
     */
    private List<String> authorizedPartnerCodeList;

    /**
     * 接入方应用
     */
    private String partnerCode;

    /**
     * 数据可见性
     */
    private Integer visibility;

    /**
     * 事件类型
     */
    private List<Integer> eventRegisterTypeList;

    /**
     * 事件Code（不可修改）
     */
    private String eventCode;

    /**
     * 事件名字  模糊查询
     */
    private String eventName;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 备注  模糊查询
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public List<Integer> getEventRegisterTypeList() {
        return eventRegisterTypeList;
    }

    public void setEventRegisterTypeList(List<Integer> eventRegisterTypeList) {
        this.eventRegisterTypeList = eventRegisterTypeList;
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

    public List<String> getAuthorizedPartnerCodeList() {
        return authorizedPartnerCodeList;
    }

    public void setAuthorizedPartnerCodeList(List<String> authorizedPartnerCodeList) {
        this.authorizedPartnerCodeList = authorizedPartnerCodeList;
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
