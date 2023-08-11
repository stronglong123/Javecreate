package com.common.generate.javacreate.ordercenter.dto;


import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.math.BigDecimal;

@ApiModel(description = "订单项货主信息")
public class OrderItemOwnerDTO implements java.io.Serializable {

    /**
     * 货主id
     */
    @ApiParam(description = "货主id")
    private Long ownerId;

    /**
     * 二级货主id
     */
    @ApiParam(description = "二级货主id")
    private Long secOwnerId;

    /**
     * 供货仓库id
     */
    @ApiParam(description = "供货仓库id", required = true)
    private Long warehouseId;

    /**
     * 货主供货数量，小单位
     */
    @ApiParam(description = "货主供货数量，小单位", required = true)
    private BigDecimal count;


    /**
     * 获取 货主id
     *
     * @return ownerId 货主id
     */
    public Long getOwnerId() {
        return this.ownerId;
    }

    /**
     * 设置 货主id
     *
     * @param ownerId 货主id
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取 二级货主id
     *
     * @return secOwnerId 二级货主id
     */
    public Long getSecOwnerId() {
        return this.secOwnerId;
    }

    /**
     * 设置 二级货主id
     *
     * @param secOwnerId 二级货主id
     */
    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    /**
     * 获取 供货仓库id
     *
     * @return warehouseId 供货仓库id
     */
    public Long getWarehouseId() {
        return this.warehouseId;
    }

    /**
     * 设置 供货仓库id
     *
     * @param warehouseId 供货仓库id
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取 货主供货数量，小单位
     *
     * @return count 货主供货数量，小单位
     */
    public BigDecimal getCount() {
        return this.count;
    }

    /**
     * 设置 货主供货数量，小单位
     *
     * @param count 货主供货数量，小单位
     */
    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
