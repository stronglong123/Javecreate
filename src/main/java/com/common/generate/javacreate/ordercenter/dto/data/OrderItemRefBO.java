package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.util.Date;

/**
 * @ClassName OrderItemRefBO
 * @Description oms明细关联单-拆单相关
 * @Author hhw
 * @Date 2022/5/11 14:05
 * @Version 1.0
 **/
@ApiModel(description = "oms明细关联单-拆单相关模型")
public class OrderItemRefBO {
    @ApiParam(description = "id")
    private Long id;

    /**
     * 城市ID
     */
    @ApiParam(description = "城市ID")
    private Integer org_Id;

    /**
     * oms单据明细ID
     */
    @ApiParam(description = "oms单据明细ID")
    private Long orderItem_Id;

    /**
     * 来源方单据明细id
     */
    @ApiParam(description = "来源方单据明细id")
    private Long businessItem_Id;

    /**
     * 关联单据ID
     */
    @ApiParam(description = "关联单据ID")
    private Long refOrder_Id;

    /**
     * 关联明细单据ID
     */
    @ApiParam(description = "关联明细单据ID")
    private Long refOrderItem_Id;

    /**
     * 关联单据ID
     */
    @ApiParam(description = "关联单据ID")
    private Long refBusiness_Id;

    /**
     * 关联明细单据ID
     */
    @ApiParam(description = "关联明细单据ID")
    private Long refBusinessItem_Id;
    @ApiParam(description = "创建时间")
    private Date createTime;
    @ApiParam(description = "创建人")
    private Integer createUser_Id;
    @ApiParam(description = "更新时间")
    private Date lastUpdateTime;
    @ApiParam(description = "更新人")
    private Integer lastUpdateUser_Id;

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

    public Long getOrderItem_Id() {
        return orderItem_Id;
    }

    public void setOrderItem_Id(Long orderItem_Id) {
        this.orderItem_Id = orderItem_Id;
    }

    public Long getBusinessItem_Id() {
        return businessItem_Id;
    }

    public void setBusinessItem_Id(Long businessItem_Id) {
        this.businessItem_Id = businessItem_Id;
    }

    public Long getRefOrder_Id() {
        return refOrder_Id;
    }

    public void setRefOrder_Id(Long refOrder_Id) {
        this.refOrder_Id = refOrder_Id;
    }

    public Long getRefOrderItem_Id() {
        return refOrderItem_Id;
    }

    public void setRefOrderItem_Id(Long refOrderItem_Id) {
        this.refOrderItem_Id = refOrderItem_Id;
    }

    public Long getRefBusiness_Id() {
        return refBusiness_Id;
    }

    public void setRefBusiness_Id(Long refBusiness_Id) {
        this.refBusiness_Id = refBusiness_Id;
    }

    public Long getRefBusinessItem_Id() {
        return refBusinessItem_Id;
    }

    public void setRefBusinessItem_Id(Long refBusinessItem_Id) {
        this.refBusinessItem_Id = refBusinessItem_Id;
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
