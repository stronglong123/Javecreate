package com.common.generate.javacreate.ordercenter.dto;

import java.util.List;

/**
 * @author xialei
 * @date 2023/4/26 11:11
 */
public class EsOrderSyncDTO {

    private List<Long> warehouseIds;
    private List<Long> orderIds;

    public List<Long> getWarehouseIds() {
        return this.warehouseIds;
    }

    public void setWarehouseIds(List<Long> warehouseIds) {
        this.warehouseIds = warehouseIds;
    }

    public List<Long> getOrderIds() {
        return this.orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
