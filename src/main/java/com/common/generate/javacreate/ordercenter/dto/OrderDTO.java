package com.common.generate.javacreate.ordercenter.dto;


import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.util.List;

@ApiModel(description = "订单详情（包含订单项供货货主信息）")
public class OrderDTO implements java.io.Serializable {

    /**
     * 订单id
     */
    @ApiParam(description = "订单id", required = true)
    private Long orderId;

    /**
     * 订单项
     */
    @ApiParam(description = "订单项（包含供货货主信息）")
    private List<OrderItemDTO> orderItems;


    /**
     * 获取 订单id
     *
     * @return orderId 订单id
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 订单项
     *
     * @return orderItems 订单项
     */
    public List<OrderItemDTO> getOrderItems() {
        return this.orderItems;
    }

    /**
     * 设置 订单项
     *
     * @param orderItems 订单项
     */
    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
