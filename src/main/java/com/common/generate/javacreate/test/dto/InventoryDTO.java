package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/5/11 16:30
 */
public class InventoryDTO implements Serializable {

    private static final long serialVersionUID = -5620091813876968655L;
    private BigDecimal storeCountMaxUnit;

    private BigDecimal storeCountMinUnit;

    private BigDecimal totalCountMinUnit;

    public BigDecimal getStoreCountMaxUnit() {
        return storeCountMaxUnit;
    }

    public void setStoreCountMaxUnit(BigDecimal storeCountMaxUnit) {
        this.storeCountMaxUnit = storeCountMaxUnit;
    }

    public BigDecimal getStoreCountMinUnit() {
        return storeCountMinUnit;
    }

    public void setStoreCountMinUnit(BigDecimal storeCountMinUnit) {
        this.storeCountMinUnit = storeCountMinUnit;
    }

    public BigDecimal getTotalCountMinUnit() {
        return totalCountMinUnit;
    }

    public void setTotalCountMinUnit(BigDecimal totalCountMinUnit) {
        this.totalCountMinUnit = totalCountMinUnit;
    }
}
