package com.common.generate.javacreate.ordercenter.dto;



import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.util.List;

@ApiModel(description = "订单明细产品供货货主信息")
public class OrderItemDTO implements java.io.Serializable {

    @ApiParam(description = "订单明细id", required = true)
    private Long orderItemId;

    @ApiParam(description = "订单项供货货主")
    private List<OrderItemOwnerDTO> orderItemOwners;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public List<OrderItemOwnerDTO> getOrderItemOwners() {
        return orderItemOwners;
    }

    public void setOrderItemOwners(List<OrderItemOwnerDTO> orderItemOwners) {
        this.orderItemOwners = orderItemOwners;
    }
}
