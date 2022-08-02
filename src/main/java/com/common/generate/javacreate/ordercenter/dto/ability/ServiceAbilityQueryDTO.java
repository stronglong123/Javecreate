package com.common.generate.javacreate.ordercenter.dto.ability;

import java.io.Serializable;
import java.util.List;

/**
 * 服务能力查询
 * @author xialei
 * @date 2021-11-05
 */
public class ServiceAbilityQueryDTO implements Serializable {
    private static final long serialVersionUID = -1182554977553216070L;

    private Integer pageIndex = 1;
    private Integer pageSize = 20;
    /**
     * 接入方应用Code
     */
    private String partnerCode;
    /**
     * 0-公有（public）；1-应用私有（private）,2-内部（inner）
     */
    private Integer visibility;
    /**
     * 服务能力名
     */
    private String abilityName;
    /**
     * 服务能力URL
     */
    private String abilityUrl;
    /**
     * 1-启用，2-停用
     */
    private Integer status;
    /**
     * 应用名
     */
    private String applicationName;
    /**
     * 代理URL（用于网关路由）
     */
    private String proxyUrl;

    /**
     * 是否需要查询应用code为公用的数据
     */
    private Boolean needPublicPartnerCode = false;


    /**
     * 接入方应用集合(优先使用接入方应用集合)
     */
    private List<String> partnerCodeList;

    /**
     * 获取接入方应用Code
     */
    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    /**
     * 设置接入方应用Code
     */
    public String getPartnerCode() {
        return partnerCode;
    }

    /**
     * 获取0-公有（public）；1-应用私有（private）,2-内部（inner）
     */
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    /**
     * 设置0-公有（public）；1-应用私有（private）,2-内部（inner）
     */
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * 获取服务能力名
     */
    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    /**
     * 设置服务能力名
     */
    public String getAbilityName() {
        return abilityName;
    }

    /**
     * 获取服务能力URL
     */
    public void setAbilityUrl(String abilityUrl) {
        this.abilityUrl = abilityUrl;
    }

    /**
     * 设置服务能力URL
     */
    public String getAbilityUrl() {
        return abilityUrl;
    }

    /**
     * 获取1-启用，2-停用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 设置1-启用，2-停用
     */
    public Integer getStatus() {
        return status;
    }


    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getProxyUrl() {
        return proxyUrl;
    }

    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    public Boolean getNeedPublicPartnerCode() {
        return needPublicPartnerCode;
    }

    public void setNeedPublicPartnerCode(Boolean needPublicPartnerCode) {
        this.needPublicPartnerCode = needPublicPartnerCode;
    }

    public List<String> getPartnerCodeList() {
        return partnerCodeList;
    }

    public void setPartnerCodeList(List<String> partnerCodeList) {
        this.partnerCodeList = partnerCodeList;
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