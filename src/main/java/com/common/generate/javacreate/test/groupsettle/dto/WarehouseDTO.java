package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2021/5/1 9:04
 */
public class WarehouseDTO implements Serializable {
    private Integer orgId;

    private Integer warehouseId;

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
}
