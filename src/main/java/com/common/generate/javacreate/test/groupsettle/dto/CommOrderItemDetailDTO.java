package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommOrderItemDetailDTO implements Serializable {

    /**
     * 小单位总数量
     */
    private BigDecimal unitTotalCount;

    /**
     * 货主id
     */
    private Long ownerId;

    /**
     * 二级货主id
     */
    private Long secOwnerId;

    /**
     * @Fields productionDate 产品生产日期
     */
    private Date productionDate;

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
