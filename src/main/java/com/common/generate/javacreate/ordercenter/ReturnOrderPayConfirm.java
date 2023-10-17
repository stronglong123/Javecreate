package com.common.generate.javacreate.ordercenter;



import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "退货单付款模型")
public class ReturnOrderPayConfirm implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiParam(description = "单据id", required = true)
    private Long orderId;

    @ApiParam(description = "金额", required = true)
    private BigDecimal payAmount;

    @ApiParam(description = "付款时间")
    private Date payTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
