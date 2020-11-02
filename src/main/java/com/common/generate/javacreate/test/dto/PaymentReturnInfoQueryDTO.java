package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020-09-03
 */
public class PaymentReturnInfoQueryDTO implements Serializable {
    private static final long serialVersionUID = 4240772276655005899L;
    /**
     * 城市Id
     */
    private Integer orgId;
    /**
     * 仓库Id
     */
    private List<Integer> warehouseIds;
    /**
     * 订单单Id
     */
    private Long omsOrderId;
    /**
     * 订单单号
     */
    private String orderNo;
    /**
     * 订单类型
     */
    private Byte orderType;
    /**
     * 关联原单omsid,没有则为空
     */
    private Long refOmsOrderId;
    /**
     * 支付单号,没有关联原单则为空
     */
    private String payNo;
    /**
     * 退款单号
     */
    private String refundNo;
    /**
     * 退款状态:申请(0),退款中(1),退款成功(2),退款失败(3),已拒绝(4),已转发至快钱支付管理平台(5),延迟处理(6)
     */
    private Byte refundState;

    /**
     * 获取城市Id
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * 设置城市Id
     */
    public Integer getOrgId() {
        return orgId;
    }

    public List<Integer> getWarehouseIds() {
        return warehouseIds;
    }

    public void setWarehouseIds(List<Integer> warehouseIds) {
        this.warehouseIds = warehouseIds;
    }

    /**
     * 获取订单单Id
     */
    public void setOmsOrderId(Long omsOrderId) {
        this.omsOrderId = omsOrderId;
    }

    /**
     * 设置订单单Id
     */
    public Long getOmsOrderId() {
        return omsOrderId;
    }

    /**
     * 获取订单单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 设置订单单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 获取订单类型
     */
    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    /**
     * 设置订单类型
     */
    public Byte getOrderType() {
        return orderType;
    }

    /**
     * 获取关联原单omsid,没有则为空
     */
    public void setRefOmsOrderId(Long refOmsOrderId) {
        this.refOmsOrderId = refOmsOrderId;
    }

    /**
     * 设置关联原单omsid,没有则为空
     */
    public Long getRefOmsOrderId() {
        return refOmsOrderId;
    }

    /**
     * 获取支付单号,没有关联原单则为空
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * 设置支付单号,没有关联原单则为空
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * 获取退款单号
     */
    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    /**
     * 设置退款单号
     */
    public String getRefundNo() {
        return refundNo;
    }

    /**
     * 获取退款状态:申请(0),退款中(1),退款成功(2),退款失败(3),已拒绝(4),已转发至快钱支付管理平台(5),延迟处理(6)
     */
    public void setRefundState(Byte refundState) {
        this.refundState = refundState;
    }

    /**
     * 设置退款状态:申请(0),退款中(1),退款成功(2),退款失败(3),已拒绝(4),已转发至快钱支付管理平台(5),延迟处理(6)
     */
    public Byte getRefundState() {
        return refundState;
    }

}