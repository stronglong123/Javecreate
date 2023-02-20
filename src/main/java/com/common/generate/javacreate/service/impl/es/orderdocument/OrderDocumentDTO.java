package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderExtDTO;
import com.common.generate.javacreate.service.impl.es.orderitemdocument.OrderItemDocumentDTO;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

/**
 * es订单文档模型
 *
 * @author xialei
 * @date 2021/11/30 10:29
 */
@ApiModel(description = "订单文档模型")
@Document(indexName = "orderdocumentv1")
public class OrderDocumentDTO implements Serializable {
    private static final long serialVersionUID = -8931769265161203448L;


    private String id;
    /**
     * 订单id
     */
    @ApiParam(description = "订单id", required = true)
    private Long orderId;

    /**
     * 最后更新时间
     */
    @ApiParam(description = "最后更新时间", required = true)
    private Long lastUpdateTime;

    /**
     * 订单基础信息
     */
    @ApiParam(description = "订单基础信息")
    private OrderBaseDocumentDTO orderBase;
    /**
     * 销售单信息
     */
    @ApiParam(description = "销售单信息")
    private OrderSaleDocumentDTO orderSale;

    /**
     * 退货信息
     */
    @ApiParam(description = "退货信息")
    private OrderReturnDocumentDTO orderReturn;

    /**
     * 订单支付信息
     */
    @ApiParam(description = "订单支付信息")
    private OrderAmountDocumentDTO orderAmount;

    /**
     * 订单发货信息
     */
    @ApiParam(description = "订单发货信息")
    private OrderConsignorDocumentDTO orderConsignor;

    /**
     * 订单收货信息
     */
    @ApiParam(description = "订单收货信息")
    private OrderContactDocumentDTO orderContact;

    /**
     * 订单配送信息
     */
    @ApiParam(description = "订单配送信息")
    private OrderDeliveryDocumentDTO orderDelivery;

    /**
     * 订单拣货信息
     */
    @ApiParam(description = "订单拣货信息")
    private OrderPickDocumentDTO orderPick;

    /**
     * 订单明细信息
     */
    @ApiParam(description = "订单明细信息")
    @Field(type = FieldType.Nested)
    private List<OrderItemDocumentDTO> orderItems;

    /**
     * 扩展信息
     */
    @ApiParam(description = "扩展信息")
    private OrderExtDTO orderExt;
    /**
     * 日志记录
     */
    @ApiParam(description = "日志记录")
    @Field(type = FieldType.Nested)
    private List<OrderTraceDocumentDTO> orderTraces;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public OrderBaseDocumentDTO getOrderBase() {
        return orderBase;
    }

    public void setOrderBase(OrderBaseDocumentDTO orderBase) {
        this.orderBase = orderBase;
    }

    public OrderSaleDocumentDTO getOrderSale() {
        return orderSale;
    }

    public void setOrderSale(OrderSaleDocumentDTO orderSale) {
        this.orderSale = orderSale;
    }


    public OrderAmountDocumentDTO getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(OrderAmountDocumentDTO orderAmount) {
        this.orderAmount = orderAmount;
    }

    public OrderConsignorDocumentDTO getOrderConsignor() {
        return orderConsignor;
    }

    public void setOrderConsignor(OrderConsignorDocumentDTO orderConsignor) {
        this.orderConsignor = orderConsignor;
    }

    public OrderContactDocumentDTO getOrderContact() {
        return orderContact;
    }

    public void setOrderContact(OrderContactDocumentDTO orderContact) {
        this.orderContact = orderContact;
    }

    public OrderDeliveryDocumentDTO getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(OrderDeliveryDocumentDTO orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

    public OrderPickDocumentDTO getOrderPick() {
        return orderPick;
    }

    public void setOrderPick(OrderPickDocumentDTO orderPick) {
        this.orderPick = orderPick;
    }

    public OrderExtDTO getOrderExt() {
        return orderExt;
    }

    public void setOrderExt(OrderExtDTO orderExt) {
        this.orderExt = orderExt;
    }

    public OrderReturnDocumentDTO getOrderReturn() {
        return orderReturn;
    }

    public void setOrderReturn(OrderReturnDocumentDTO orderReturn) {
        this.orderReturn = orderReturn;
    }

    public List<OrderItemDocumentDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDocumentDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderTraceDocumentDTO> getOrderTraces() {
        return orderTraces;
    }

    public void setOrderTraces(List<OrderTraceDocumentDTO> orderTraces) {
        this.orderTraces = orderTraces;
    }
}
