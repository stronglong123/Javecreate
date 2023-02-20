package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;

public class OrderTraceConfigQueryParam implements Serializable {
    private static final long serialVersionUID = -1L;

    private Integer traceType;

    private String traceTypeTxt;

    private String partnerCode;

    //todo 后期前端代码后端代码都上线后可去掉此字段
    @Deprecated
    private Integer traceTemplateType;

    private String companyCode;

    private Integer pageIndex = 1;

    private Integer pageSize = 20;

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

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    @Deprecated
    public Integer getTraceTemplateType() {
        return traceTemplateType;
    }

    @Deprecated
    public void setTraceTemplateType(Integer traceTemplateType) {
        this.traceTemplateType = traceTemplateType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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
