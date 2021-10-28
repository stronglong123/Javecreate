package com.common.generate.javacreate.test.jixiao;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2021/8/26 14:44
 */
public class JXDTO implements Serializable {

    private static final long serialVersionUID = -511819771099713685L;
    private String warehouseId;

    private String warehouseName;


    private String outWarehouseId;

    private String outWarehouseName;

    private Integer type;

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getOutWarehouseId() {
        return outWarehouseId;
    }

    public void setOutWarehouseId(String outWarehouseId) {
        this.outWarehouseId = outWarehouseId;
    }

    public String getOutWarehouseName() {
        return outWarehouseName;
    }

    public void setOutWarehouseName(String outWarehouseName) {
        this.outWarehouseName = outWarehouseName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
