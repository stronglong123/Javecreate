package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2023/3/1 16:09
 */
public class GroupSettleCompareDTO {

    private Integer orgId;

    private Integer warehouseId;


    private Long productSkuId;

    private Long secOwnerId;

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
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

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }
}
