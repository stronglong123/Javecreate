package com.common.generate.javacreate.ordercenter.dto;


import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单支付模型
 *
 * @author xialei
 * @date 2021/12/30 10:21
 */

@ApiModel(description = "订单支付模型")
public class OrderPayDTO implements Serializable {
    private static final long serialVersionUID = -1665542394215060554L;

    /**
     * 单据id
     */
    @ApiParam(description = "订单Id", required = true)
    private Long orderId;
    /**
     * 业务标识
     */
    @ApiParam(description = "业务标识", required = true)
    private String partnerCode;

    @ApiParam(description = "支付状态 1-成功，2-失败", required = true)
    private Integer payState;

    /**
     * 支付单号
     */
    @ApiParam(description = "支付单号", required = true)
    private String payOrderNo;

    @ApiParam(description = "支付类型")
    private Integer payType;

    @ApiParam(description = "支付类型名")
    private String payTypeName;

    @ApiParam(description = "支付时间")
    private Date payTime;

    @ApiParam(description = "实收金额", required = true)
    private BigDecimal receiveAmount;

    @ApiParam(description = "未收金额", required = true)
    private BigDecimal uncollectedAmount;

    @ApiParam(description = "操作人Id", required = true)
    private String optUserId;

    @ApiParam(description = "操作人")
    private String optUserName;

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public BigDecimal getUncollectedAmount() {
        return uncollectedAmount;
    }

    public void setUncollectedAmount(BigDecimal uncollectedAmount) {
        this.uncollectedAmount = uncollectedAmount;
    }

    public String getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(String optUserId) {
        this.optUserId = optUserId;
    }

    public String getOptUserName() {
        return optUserName;
    }

    public void setOptUserName(String optUserName) {
        this.optUserName = optUserName;
    }
}
