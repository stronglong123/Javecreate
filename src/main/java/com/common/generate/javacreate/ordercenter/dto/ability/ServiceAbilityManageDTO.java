package com.common.generate.javacreate.ordercenter.dto.ability;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 服务能力
 * @author xialei
 * @date  2021-11-05
 */
public class ServiceAbilityManageDTO implements Serializable {
    private static final long serialVersionUID = 6303086283790101789L;

    /**
     * 
     */
    private Long id;
    /**
     * 接入方应用Code
     */
    private String partnerCode;
    /**
     * 可见性 0-公有（public）；1-应用私有（private）,2-内部（inner）
     */
    private Integer visibility;
    /**
     * 应用名
     */
    private String applicationName;
    /**
     * 代理URL（用于网关路由）
     */
    private String proxyUrl;
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
     * 描述
     */
    private String description;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date lastUpdateTime;

    /**
     * 特性
     */
    private Map features;
    /**
     * 版本号
     */
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取
     */
    public void setId (Long id) {this.id = id;} 
    /**
     * 设置
     */
    public Long getId(){ return id;} 
    /**
     * 获取接入方应用Code
     */
    public void setPartnerCode (String partnerCode) {this.partnerCode = partnerCode;} 
    /**
     * 设置接入方应用Code
     */
    public String getPartnerCode(){ return partnerCode;} 
    /**
     * 获取0-公有（public）；1-应用私有（private）,2-内部（inner）
     */
    public void setVisibility (Integer visibility) {this.visibility = visibility;} 
    /**
     * 设置0-公有（public）；1-应用私有（private）,2-内部（inner）
     */
    public Integer getVisibility(){ return visibility;} 
    /**
     * 获取服务能力名
     */
    public void setAbilityName (String abilityName) {this.abilityName = abilityName;} 
    /**
     * 设置服务能力名
     */
    public String getAbilityName(){ return abilityName;} 
    /**
     * 获取服务能力URL
     */
    public void setAbilityUrl (String abilityUrl) {this.abilityUrl = abilityUrl;} 
    /**
     * 设置服务能力URL
     */
    public String getAbilityUrl(){ return abilityUrl;} 
    /**
     * 获取1-启用，2-停用
     */
    public void setStatus (Integer status) {this.status = status;}
    /**
     * 设置1-启用，2-停用
     */
    public Integer getStatus(){ return status;}
    /**
     * 获取描述
     */
    public void setDescription (String description) {this.description = description;} 
    /**
     * 设置描述
     */
    public String getDescription(){ return description;} 
    /**
     * 获取备注
     */
    public void setRemark (String remark) {this.remark = remark;} 
    /**
     * 设置备注
     */
    public String getRemark(){ return remark;} 
    /**
     * 获取创建时间
     */
    public void setCreateTime (Date createTime) {this.createTime = createTime;}
    /**
     * 设置创建时间
     */
    public Date getCreateTime(){ return createTime;}
    /**
     * 获取更新时间
     */
    public void setLastUpdateTime (Date lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;}
    /**
     * 设置更新时间
     */
    public Date getLastUpdateTime(){ return lastUpdateTime;}

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

    public Map getFeatures() {
        return features;
    }

    public void setFeatures(Map features) {
        this.features = features;
    }
}