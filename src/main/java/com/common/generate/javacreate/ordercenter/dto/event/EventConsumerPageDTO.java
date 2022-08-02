package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.Date;

public class EventConsumerPageDTO {
    private static final long serialVersionUID = 1L;

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
