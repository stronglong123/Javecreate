package com.common.generate.javacreate.ordercenter.dto;

import com.common.generate.javacreate.ordercenter.SaleInventoryAllocateResult;

import java.util.List;

/**
 * @author xialei
 * @date 2023/1/18 9:33
 */
public class PushSaleOrderDTO {

    /**
     * 销售单推送模型
     */
    private SaleOrderDTO saleOrder;

    /**
     * 二级货主分配结果
     */
    List<SaleInventoryAllocateResult> inventoryAllocates;


    private SaleOrderCancelDTO cancel;

    public SaleOrderCancelDTO getCancel() {
        return cancel;
    }

    public void setCancel(SaleOrderCancelDTO cancel) {
        this.cancel = cancel;
    }

    public SaleOrderDTO getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrderDTO saleOrder) {
        this.saleOrder = saleOrder;
    }

    public List<SaleInventoryAllocateResult> getInventoryAllocates() {
        return inventoryAllocates;
    }

    public void setInventoryAllocates(List<SaleInventoryAllocateResult> inventoryAllocates) {
        this.inventoryAllocates = inventoryAllocates;
    }
}
