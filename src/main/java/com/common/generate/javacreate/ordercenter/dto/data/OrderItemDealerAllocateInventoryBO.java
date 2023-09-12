package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.math.BigDecimal;

/**
 * @ClassName OrderItemDealerAllocateInventoryBO
 * @Description oms经销商库存预分配
 * @Author hhw
 * @Date 2022/5/11 13:44
 * @Version 1.0
 **/
@ApiModel(description = "oms经销商库存预分配模型")
public class OrderItemDealerAllocateInventoryBO {

    /**
     * 城市ID
     */
    @ApiParam(description = "城市ID")
    private Integer cityId;

    /**
     * 经销商仓库ID
     */
    @ApiParam(description = "经销商仓库ID")
    private Integer dealerWarehouseId;

    /**
     * 商品规格ID
     */
    @ApiParam(description = "商品规格ID")
    private Long productSpecId;

    /**
     * 一级货主ID
     */
    @ApiParam(description = "一级货主ID")
    private Long ownerId;

    @ApiParam(description = "金额")
    private BigDecimal assignedAmount = BigDecimal.ZERO;

    /**
     * 成本价格
     */
    @ApiParam(description = "成本价格")
    private BigDecimal costPrice;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDealerWarehouseId() {
        return dealerWarehouseId;
    }

    public void setDealerWarehouseId(Integer dealerWarehouseId) {
        this.dealerWarehouseId = dealerWarehouseId;
    }

    public Long getProductSpecId() {
        return productSpecId;
    }

    public void setProductSpecId(Long productSpecId) {
        this.productSpecId = productSpecId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public BigDecimal getAssignedAmount() {
        return assignedAmount;
    }

    public void setAssignedAmount(BigDecimal assignedAmount) {
        this.assignedAmount = assignedAmount;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}
