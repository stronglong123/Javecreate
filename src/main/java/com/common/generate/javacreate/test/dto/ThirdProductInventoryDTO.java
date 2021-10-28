package com.common.generate.javacreate.test.dto;

import java.util.List;

/**
 * @author xialei
 * @date 2020/7/10 14:53
 */
public class ThirdProductInventoryDTO {

    private Integer wareHouseId;

    private Integer orgId;

    private List<Long> refSkuIdList;

    private List<Long> skuIdList;


    public Integer getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(Integer wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public List<Long> getRefSkuIdList() {
        return refSkuIdList;
    }

    public void setRefSkuIdList(List<Long> refSkuIdList) {
        this.refSkuIdList = refSkuIdList;
    }

    public List<Long> getSkuIdList() {
        return skuIdList;
    }

    public void setSkuIdList(List<Long> skuIdList) {
        this.skuIdList = skuIdList;
    }
}
