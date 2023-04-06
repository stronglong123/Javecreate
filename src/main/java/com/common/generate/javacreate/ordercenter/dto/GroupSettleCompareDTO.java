package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2023/3/1 16:09
 */
public class GroupSettleCompareDTO {

    private Integer org_Id;

    private Integer warehouse_Id;

    private Long productSku_Id;

    private Long secOwner_Id;

    public Integer getOrg_Id() {
        return org_Id;
    }

    public void setOrg_Id(Integer org_Id) {
        this.org_Id = org_Id;
    }

    public Integer getWarehouse_Id() {
        return warehouse_Id;
    }

    public void setWarehouse_Id(Integer warehouse_Id) {
        this.warehouse_Id = warehouse_Id;
    }

    public Long getProductSku_Id() {
        return productSku_Id;
    }

    public void setProductSku_Id(Long productSku_Id) {
        this.productSku_Id = productSku_Id;
    }

    public Long getSecOwner_Id() {
        return secOwner_Id;
    }

    public void setSecOwner_Id(Long secOwner_Id) {
        this.secOwner_Id = secOwner_Id;
    }

    @Override
    public String toString() {
        return "GroupSettleCompareDTO{" +
                "org_Id=" + org_Id +
                ", warehouse_Id=" + warehouse_Id +
                ", productSku_Id=" + productSku_Id +
                ", secOwner_Id=" + secOwner_Id +
                '}';
    }
}
