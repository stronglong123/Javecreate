package com.common.generate.javacreate.ordercenter.dto;


import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2023/5/5 11:06
 */
@ApiModel(description = "二级货主预分配明细")
public class OrderItemSecOwnerAllocateDTO implements Serializable {

    @ApiParam(description = "小件数量", required = true)
    private BigDecimal unitTotalCount;

    /**
     * 二级货主信息
     */
    @ApiParam(description = "二级货主Id")
    private Long secOwnerId;


    @ApiParam(description = "明细id", required = true)
    private Long orderItemId;


    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
}
