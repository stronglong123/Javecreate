package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.util.List;

public class TrainsOutStockOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 订单id
     */
    //@ApiParam(description = "订单id", required = true)
    private Long orderId;

    /**
     * 订单类型
     *
     */
    //@ApiParam(description = "订单类型", required = true)
    private Integer orderType;

    /**
     * WMS出库单类型
     * ALLOT_ORDER(1, "调拨单"), SALE_ORDER(2, "销售订单"), ON_LINE_RETURN_ORDER(3, "线上退货订单"), OFFLINE_RETURN_ORDER(4, "线下退货订单"),
     * SELF_PICKUP_SALE_ORDER(5, "自提订单"), EXPRESS_DELIVERY_SALE_ORDER(6, "快递直发订单"), VIRTUAL_WAREHOUSE_ORDER(7, "虚仓二次分拣订单"),
     * INTERNAL_DELIVERY_ORDER(8, "内配订单");
     */
    //@ApiParam(description = "WMS出库单类型 1调拨单， 2销售订单， 3线上退货订单， 4线下退货订单， 5自提订单， 6快递直发订单， 7虚仓二次分拣订单， 8内配订单", required = true)
    private Integer outStockOrderType;

    /**
     * 出库单Id
     */
    //@ApiParam(description = "出库单Id", required = true)
    private Long outStockOrderId;
    /**
     * 备注
     */
    //@ApiParam(description = "备注")
    private String tag;


    private List<TrainsOutStockOrderItemDTO> trainsOutStockOrderItemList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public List<TrainsOutStockOrderItemDTO> getTrainsOutStockOrderItemList() {
        return trainsOutStockOrderItemList;
    }

    public void setTrainsOutStockOrderItemList(List<TrainsOutStockOrderItemDTO> trainsOutStockOrderItemList) {
        this.trainsOutStockOrderItemList = trainsOutStockOrderItemList;
    }

    /**
     * 获取 WMS出库单类型
     *
     * @return outStockOrderType WMS出库单类型
     */
    public Integer getOutStockOrderType() {
        return this.outStockOrderType;
    }

    /**
     * 设置 WMS出库单类型
     *
     * @param outStockOrderType WMS出库单类型
     */
    public void setOutStockOrderType(Integer outStockOrderType) {
        this.outStockOrderType = outStockOrderType;
    }

    /**
     * 获取 出库单Id
     *
     * @return outStockOrderId 出库单Id
     */
    public Long getOutStockOrderId() {
        return this.outStockOrderId;
    }

    /**
     * 设置 出库单Id
     *
     * @param outStockOrderId 出库单Id
     */
    public void setOutStockOrderId(Long outStockOrderId) {
        this.outStockOrderId = outStockOrderId;
    }

    /**
     * 获取 备注
     *
     * @return tag 备注
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * 设置 备注
     *
     * @param tag 备注
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
