package com.common.generate.javacreate.test.dto;

import java.io.Serializable;

/**
 *
 * 三只松鼠退货DTO
 * @author xialei
 * @date 2020/11/19 14:33
 */
public class ThirdSSCancelOrderDTO implements Serializable {

    private static final long serialVersionUID = 1606809330404328864L;
    /**
     * 来源系统
     */
    private String sourceName;

    /**
     * 买家名称
     */
    private String buyerNick;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退款单号
     */
    private String refundId;

    /**
     * 退款金额
     */
    private String refundMoney;

    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * 退货原因
     */
    private String refundReason;

    /**
     * 退货产品小单位数量
     */
    private Integer num;

    /**
     * 验证信息
     */
    private String sign;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(String refundMoney) {
        this.refundMoney = refundMoney;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
