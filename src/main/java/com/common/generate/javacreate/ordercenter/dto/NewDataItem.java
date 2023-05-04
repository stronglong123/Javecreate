package com.common.generate.javacreate.ordercenter.dto;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2023/4/20 11:21
 */
public class NewDataItem {


    private Long businessItemId;

    private Long secOwnerId;

    private BigDecimal unitTotalCount;

    public Long getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(Long businessItemId) {
        this.businessItemId = businessItemId;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }
}
