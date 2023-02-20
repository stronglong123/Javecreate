package com.common.generate.javacreate.ordercenter.dto.data;

import java.util.Date;

/**
 * @ClassName OrderFeatureBO
 * @Description oms订单特征
 * @Author hhw
 * @Date 2022/5/11 11:46
 * @Version 1.0
 **/
public class OrderFeatureBO {

    private Long id;

    private Long order_Id;

    /**
     * 特征类型1=大件;2=小件;3=单品;4=休食
     */
    private Integer featureType;

    private Date createTime;

    private Integer createUser_Id;

    private Date lastUpdateTime;

    private Integer lastUpdateUser_Id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Integer getFeatureType() {
        return featureType;
    }

    public void setFeatureType(Integer featureType) {
        this.featureType = featureType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser_Id() {
        return createUser_Id;
    }

    public void setCreateUser_Id(Integer createUser_Id) {
        this.createUser_Id = createUser_Id;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUser_Id() {
        return lastUpdateUser_Id;
    }

    public void setLastUpdateUser_Id(Integer lastUpdateUser_Id) {
        this.lastUpdateUser_Id = lastUpdateUser_Id;
    }
}
