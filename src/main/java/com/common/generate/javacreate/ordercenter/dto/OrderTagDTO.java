package com.common.generate.javacreate.ordercenter.dto;


import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "订单标签模型")
public class OrderTagDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiParam(description = "id")
    private Long id;
    /**
     * 订单id
     */
    @ApiParam(description = "订单id", required = true)
    private Long orderId;

    @ApiParam(description = "标签类型", required = true)
    private Integer tagType;

    @ApiParam(description = "标签类型文本", required = true)
    private String tagTypeTxt;

    @ApiParam(description = "应用接入方Code")
    private String partnerCode;

    @ApiParam(description = "公司Code")
    private String companyCode;

    @ApiParam(description = "仓库id", required = true)
    private Long warehouseId;

    @ApiParam(description = "描述", required = true)
    private String description;

    @ApiParam(description = "创建时间")
    private Date createTime;

    @ApiParam(description = "最后更新时间")
    private Date lastUpdateTime;

    @ApiParam(description = "创建人")
    private String createUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getTagType() {
        return tagType;
    }

    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    public String getTagTypeTxt() {
        return tagTypeTxt;
    }

    public void setTagTypeTxt(String tagTypeTxt) {
        this.tagTypeTxt = tagTypeTxt;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
}