package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderCenterMarkDTO implements Serializable {

    private static final long serialVersionUID = -5114153277412022171L;

    private Long omsOrderId;
    private String businessNo;

    /**
     * 订单状态
     *【（BusinessType1->酒批订单）
     * 1=已下单，2=已取消，3=审核通过，4=审核拒绝，5=待发货，
     * 6=已发货，7=已完成，8=配送失败，10=待结账，11=待支付，
     * 12=支付成功，13=支付失败，14=延迟配送，16=作废，20=已结算，
     * 21=待结算，30=（已出库）仓管确认出库，35=调拨中，36=调拨发货，40=已合并】
     */
    private Integer state;

    /**
     * 标记仓库
     */
    private Long markWarehouseId;

    /**
     * 应收金额
     */
    private BigDecimal payableAmount;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 司机配送应收金额
     */
    private BigDecimal driverOrderAmount;

    /**
     * 成本价
     */
    private BigDecimal supplyCostPrice;
    /**
     * 成本价总金额
     */
    private BigDecimal costAmount;

    private Long userId;
    /**
     * 订单满减
     */
    private BigDecimal reduceAmount;
    /**
     * 红包
     */
    private BigDecimal useBonusAmount;
    /**
     * 立减
     */
    private BigDecimal productReduceAmount;
    /**
     * 优惠金额
     */
    private BigDecimal useCouponAmount;
    /**
     * 赠送的红包总金额
     */
    private BigDecimal giveBonusAmount;
    /**
     * 赠送的优惠券总金额
     */
    private BigDecimal giveCouponAmount;
    /**
     * 优惠合计
     */
    private BigDecimal discountAmount;
    /**
     * 配送状态 无配送状态（ -1），全部配送(0),部分发货(1),部分配送(2),延迟配送(3),配送失败(4),延迟配送已入库(5)
     */
    private Byte deliveryState;

    /**
     * 修改订单数量时，调整货主信息
     */

    public Long getOmsOrderId() {
        return omsOrderId;
    }

    public void setOmsOrderId(Long omsOrderId) {
        this.omsOrderId = omsOrderId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public Long getMarkWarehouseId() {
        return markWarehouseId;
    }

    public void setMarkWarehouseId(Long markWarehouseId) {
        this.markWarehouseId = markWarehouseId;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getDriverOrderAmount() {
        return driverOrderAmount;
    }

    public void setDriverOrderAmount(BigDecimal driverOrderAmount) {
        this.driverOrderAmount = driverOrderAmount;
    }

    public BigDecimal getSupplyCostPrice() {
        return supplyCostPrice;
    }

    public void setSupplyCostPrice(BigDecimal supplyCostPrice) {
        this.supplyCostPrice = supplyCostPrice;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public BigDecimal getUseBonusAmount() {
        return useBonusAmount;
    }

    public void setUseBonusAmount(BigDecimal useBonusAmount) {
        this.useBonusAmount = useBonusAmount;
    }

    public BigDecimal getProductReduceAmount() {
        return productReduceAmount;
    }

    public void setProductReduceAmount(BigDecimal productReduceAmount) {
        this.productReduceAmount = productReduceAmount;
    }

    public BigDecimal getUseCouponAmount() {
        return useCouponAmount;
    }

    public void setUseCouponAmount(BigDecimal useCouponAmount) {
        this.useCouponAmount = useCouponAmount;
    }

    public BigDecimal getGiveBonusAmount() {
        return giveBonusAmount;
    }

    public void setGiveBonusAmount(BigDecimal giveBonusAmount) {
        this.giveBonusAmount = giveBonusAmount;
    }

    public BigDecimal getGiveCouponAmount() {
        return giveCouponAmount;
    }

    public void setGiveCouponAmount(BigDecimal giveCouponAmount) {
        this.giveCouponAmount = giveCouponAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Byte getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Byte deliveryState) {
        this.deliveryState = deliveryState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


}
