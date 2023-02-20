package com.common.generate.javacreate.service.impl.es.orderitemdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderItemExtDTO;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

/**
 * 订单明细文档模型
 *
 * @author xialei
 * @date 2021/11/30 10:52
 */
@ApiModel(description = "订单明细文档模型")
public class OrderItemDocumentDTO implements Serializable {
    private static final long serialVersionUID = -7144970158796743753L;
    /**
     * 订单id
     */
    @ApiParam(description = "订单id")
    private Long orderId;

    /**
     * 订单明细id
     */
    @ApiParam(description = "订单明细id")
    private Long orderItemId;

    /**
     * 基础订单明细集合
     */
    @ApiParam(description = "基础订单明细集合")
    private OrderItemBaseDocumentDTO orderItemBase;

    /**
     * 退货订单明细信息
     */
    @ApiParam(description = "退货订单明细信息")
    private OrderItemReturnDocumentDTO orderItemReturn;

    /**
     * 订单明细金额集合
     */
    @ApiParam(description = "订单明细金额集合")
    @Field(type = FieldType.Nested)
    private List<OrderItemAmountDocumentDTO> orderItemAmounts;

    /**
     * 订单明细费用集合
     */
    @ApiParam(description = "订单明细费用集合")
    @Field(type = FieldType.Nested)
    private List<OrderItemFeeDocumentDTO> orderItemFees;

    /**
     * 扩展信息
     */
    @ApiParam(description = "扩展信息")
    private OrderItemExtDTO orderItemExt;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public OrderItemBaseDocumentDTO getOrderItemBase() {
        return orderItemBase;
    }

    public void setOrderItemBase(OrderItemBaseDocumentDTO orderItemBase) {
        this.orderItemBase = orderItemBase;
    }

    public OrderItemReturnDocumentDTO getOrderItemReturn() {
        return orderItemReturn;
    }

    public void setOrderItemReturn(OrderItemReturnDocumentDTO orderItemReturn) {
        this.orderItemReturn = orderItemReturn;
    }

    public List<OrderItemAmountDocumentDTO> getOrderItemAmounts() {
        return orderItemAmounts;
    }

    public void setOrderItemAmounts(List<OrderItemAmountDocumentDTO> orderItemAmounts) {
        this.orderItemAmounts = orderItemAmounts;
    }

    public List<OrderItemFeeDocumentDTO> getOrderItemFees() {
        return orderItemFees;
    }

    public void setOrderItemFees(List<OrderItemFeeDocumentDTO> orderItemFees) {
        this.orderItemFees = orderItemFees;
    }

    public OrderItemExtDTO getOrderItemExt() {
        return orderItemExt;
    }

    public void setOrderItemExt(OrderItemExtDTO orderItemExt) {
        this.orderItemExt = orderItemExt;
    }
}
