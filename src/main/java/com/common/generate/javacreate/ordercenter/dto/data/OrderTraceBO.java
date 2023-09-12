package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderTraceBO
 * @Description oms订单操作日志BO
 * @Author hhw
 * @Date 2022/6/22 13:40
 * @Version 1.0
 **/
@ApiModel(description = "oms订单操作日志BO")
public class OrderTraceBO implements Serializable {

    private static final long serialVersionUID = -7785346216899282328L;
    @ApiParam(description = "id")
    private Long id;

    /**
     * 组织机构ID城市ID
     */
    @ApiParam(description = "组织机构ID城市ID")
    private Integer org_Id;

    /**
     * 订单ID
     */
    @ApiParam(description = "订单ID")
    private Long order_Id;

    /**
     * 关联业务单据ID
     */
    @ApiParam(description = "关联业务单据ID")
    private Long business_Id;

    /**
     * 操作描述
     */
    @ApiParam(description = "操作描述")
    private String description;
    @ApiParam(description = "备注")
    private String remark;
    @ApiParam(description = "创建时间")
    private Date createTime;
    @ApiParam(description = "创建人")
    private Integer createUser_Id;
    @ApiParam(description = "更新时间")
    private Date lastUpdateTime;
    @ApiParam(description = "更新人")
    private Integer lastUpdateUser_Id;

    /**
     * 模板类型 1 酒批内部模板 2 客户模板
     */
    @ApiParam(description = "模板类型")
    private Integer mouldShowType;

    /**
     * 日志标签，分组用
     */
    @ApiParam(description = "日志标签")
    private String tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrg_Id() {
        return org_Id;
    }

    public void setOrg_Id(Integer org_Id) {
        this.org_Id = org_Id;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Long getBusiness_Id() {
        return business_Id;
    }

    public void setBusiness_Id(Long business_Id) {
        this.business_Id = business_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getMouldShowType() {
        return mouldShowType;
    }

    public void setMouldShowType(Integer mouldShowType) {
        this.mouldShowType = mouldShowType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
