package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2023/4/23 18:57
 */
public class ChangeCountMarkDTO {
    private Long orderId;
    private Long warehouseId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
