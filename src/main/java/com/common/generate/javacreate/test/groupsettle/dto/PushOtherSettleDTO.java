package com.common.generate.javacreate.test.groupsettle.dto;


import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2022/1/28 10:32
 */
public class PushOtherSettleDTO {
    /**
     * 平台编号：110 美团优选，111 多多买菜 112橙心优选(必传)
     */
    private Integer channelNo;
    /**
     * 关联单据号(必传)
     */
    private String relatedNoteNO;

    private Integer orderType;

    private Integer orgId;

    private Integer warehouseId;

    /**
     * 产品SKU(必传)
     */
    private Long productSkuId;
    /**
     * 产品名称(必传)
     */
    private String productName;

    /**
     * 小单位总数量
     */
    private BigDecimal unitTotalCount;

    /**
     * 货主id
     */
    private Long ownerId;

    /**
     * 二级货主id
     */
    private Long secOwnerId;

    /**
     * 1：已发送
     */
    private Integer hasSend;



    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public String getRelatedNoteNO() {
        return relatedNoteNO;
    }

    public void setRelatedNoteNO(String relatedNoteNO) {
        this.relatedNoteNO = relatedNoteNO;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getHasSend() {
        return hasSend;
    }

    public void setHasSend(Integer hasSend) {
        this.hasSend = hasSend;
    }
}
