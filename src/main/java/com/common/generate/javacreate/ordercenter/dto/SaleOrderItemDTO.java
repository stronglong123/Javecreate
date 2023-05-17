package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;

/**
 * 销售订单明细模型
 *
 * @author Hu Liangzhi
 */
public class SaleOrderItemDTO implements Serializable {
    private static final long serialVersionUID = 5079932771578474388L;


    /**
     * 基础订单明细
     */
    private OrderItemBaseDTO orderItemBaseDTO;

    /**
     * 订单金额集合
     */
    private OrderItemAmountDTO orderItemAmountDTO;


    public OrderItemBaseDTO getOrderItemBaseDTO() {
        return orderItemBaseDTO;
    }

    public void setOrderItemBaseDTO(OrderItemBaseDTO orderItemBaseDTO) {
        this.orderItemBaseDTO = orderItemBaseDTO;
    }

    public OrderItemAmountDTO getOrderItemAmountDTO() {
        return orderItemAmountDTO;
    }

    public void setOrderItemAmountDTO(OrderItemAmountDTO orderItemAmountDTO) {
        this.orderItemAmountDTO = orderItemAmountDTO;
    }
}
