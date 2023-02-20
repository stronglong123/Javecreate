package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderTraceConfigDTO implements Serializable {
    private static final long serialVersionUID = -1L;

    private Long id;

    /**
     *  trace类型
     */
    private Integer traceType;

    /**
     *  trace类型文本
     */
    private String traceTypeTxt;

    /**
     *  公司Code
     */
    private String companyCode;

    //todo 待前端后端都上线后可去掉这两个字段

    /**
     *  trace模板类型 1-默认文本模板，2-用户文本模板，3-后台文本模板
     */
    @Deprecated
    private Integer traceTemplateType;

    /**
     *  trace转换模板
     */
    @Deprecated
    private String traceConvertTemplate;

    /**
     * 接入应用方Code
     */
    private String partnerCode;

    /**
     * 默认trace文本
     */
    private String defaultTraceTemplate;

    /**
     * 用户trace文本
     */
    private String userTraceTemplate;

    /**
     * 系统trace文本
     */
    private String systemTraceTemplate;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *  修改时间
     */
    private Date lastUpDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTraceType() {
        return traceType;
    }

    public void setTraceType(Integer traceType) {
        this.traceType = traceType;
    }

    public String getTraceTypeTxt() {
        return traceTypeTxt;
    }

    public void setTraceTypeTxt(String traceTypeTxt) {
        this.traceTypeTxt = traceTypeTxt;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Deprecated
    public Integer getTraceTemplateType() {
        return traceTemplateType;
    }

    @Deprecated
    public void setTraceTemplateType(Integer traceTemplateType) {
        this.traceTemplateType = traceTemplateType;
    }

    @Deprecated
    public String getTraceConvertTemplate() {
        return traceConvertTemplate;
    }

    @Deprecated
    public void setTraceConvertTemplate(String traceConvertTemplate) {
        this.traceConvertTemplate = traceConvertTemplate;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpDateTime() {
        return lastUpDateTime;
    }

    public void setLastUpDateTime(Date lastUpDateTime) {
        this.lastUpDateTime = lastUpDateTime;
    }

    public String getDefaultTraceTemplate() {
        return defaultTraceTemplate;
    }

    public void setDefaultTraceTemplate(String defaultTraceTemplate) {
        this.defaultTraceTemplate = defaultTraceTemplate;
    }

    public String getUserTraceTemplate() {
        return userTraceTemplate;
    }

    public void setUserTraceTemplate(String userTraceTemplate) {
        this.userTraceTemplate = userTraceTemplate;
    }

    public String getSystemTraceTemplate() {
        return systemTraceTemplate;
    }

    public void setSystemTraceTemplate(String systemTraceTemplate) {
        this.systemTraceTemplate = systemTraceTemplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderTraceConfigDTO that = (OrderTraceConfigDTO) o;

        if (!traceType.equals(that.traceType)) return false;
        if (!partnerCode.equals(that.partnerCode)) return false;
        if (defaultTraceTemplate != null ? !defaultTraceTemplate.equals(that.defaultTraceTemplate) : that.defaultTraceTemplate != null)
            return false;
        if (userTraceTemplate != null ? !userTraceTemplate.equals(that.userTraceTemplate) : that.userTraceTemplate != null)
            return false;
        return systemTraceTemplate != null ? systemTraceTemplate.equals(that.systemTraceTemplate) : that.systemTraceTemplate == null;
    }

    @Override
    public int hashCode() {
        int result = traceType.hashCode();
        result = 31 * result + partnerCode.hashCode();
        result = 31 * result + (defaultTraceTemplate != null ? defaultTraceTemplate.hashCode() : 0);
        result = 31 * result + (userTraceTemplate != null ? userTraceTemplate.hashCode() : 0);
        result = 31 * result + (systemTraceTemplate != null ? systemTraceTemplate.hashCode() : 0);
        return result;
    }
}
