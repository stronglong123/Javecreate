package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2023/4/23 9:12
 */
public class UpdateSecOwnerDTO implements Serializable {

    private static final long serialVersionUID = 7101165402256676555L;

    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单项id
     */
    private Long orderItemId;
    /**
     * 二级货主id
     */
    private Long secOwnerId;
    /**
     * 数量
     */
    private BigDecimal count;
    /**
     * 仓库Id
     */
    private Integer warehouseId;

    /**
     * 货主Id
     */
    private Long ownerId;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return this.orderItemId;
    }

    public void setOrderItemId(final Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getSecOwnerId() {
        return this.secOwnerId;
    }

    public void setSecOwnerId(final Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public BigDecimal getCount() {
        return this.count;
    }

    public void setCount(final BigDecimal count) {
        this.count = count;
    }

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(final Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(final Long ownerId) {
        this.ownerId = ownerId;
    }
}
