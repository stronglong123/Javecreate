package com.common.generate.javacreate.ordercenter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 销售库存分配记录结果
 */
public class SaleInventoryAllocateResult implements Serializable {
    private static final long serialVersionUID = 1L;

    //(description = "主键")
    private Long id;

    /**
     */
    //(description = "阶段", example = "-1=取消；1=预分配；2=出库；3=完成")
    private Integer phase;

    //(description = "订单ID")
    private Long orderId;

    //(description = "订单项Id")
    private Long orderItemId;

    //(description = "销售库存Id")
    private Long inventoryId;

    //(description = "组织机构Id")
    private Integer orgId;

    //(description = "仓库Id")
    private Integer warehouseId;

    //(description = "产品SkuId")
    private Long productSkuId;

    //(description = "产品规格Id")
    private Long productSpecId;

    //(description = "一级货主")
    private Long ownerId;

    //(description = "二级货主")
    private Long secOwnerId;

    //(description = "分配数量")
    private BigDecimal allocateCount;

    //(description = "差异数量(回单入库与出库数量的差异)")
    private BigDecimal diffCount;

    //(description = "外部二级货主")
    private String outSecOwnerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
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

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public BigDecimal getAllocateCount() {
        return allocateCount;
    }

    public void setAllocateCount(BigDecimal allocateCount) {
        this.allocateCount = allocateCount;
    }

    public String getOutSecOwnerId() {
        return outSecOwnerId;
    }

    public void setOutSecOwnerId(String outSecOwnerId) {
        this.outSecOwnerId = outSecOwnerId;
    }

    public BigDecimal getDiffCount() {
        return diffCount;
    }

    public void setDiffCount(BigDecimal diffCount) {
        this.diffCount = diffCount;
    }
}
