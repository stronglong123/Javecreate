package com.common.generate.javacreate.ordercenter.dto;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2023/2/10 14:02
 */
public class WarehouseSyncDTO {

    private Integer omscount;

    private BigDecimal omsamount;

    private Integer occount;

    private BigDecimal ocamount;

    private Long warehouseId;

    public Integer getOmscount() {
        return omscount;
    }

    public void setOmscount(Integer omscount) {
        this.omscount = omscount;
    }

    public BigDecimal getOmsamount() {
        return omsamount;
    }

    public void setOmsamount(BigDecimal omsamount) {
        this.omsamount = omsamount;
    }

    public Integer getOccount() {
        return occount;
    }

    public void setOccount(Integer occount) {
        this.occount = occount;
    }

    public BigDecimal getOcamount() {
        return ocamount;
    }

    public void setOcamount(BigDecimal ocamount) {
        this.ocamount = ocamount;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
