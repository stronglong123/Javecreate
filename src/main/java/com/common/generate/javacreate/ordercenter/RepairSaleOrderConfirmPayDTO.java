package com.common.generate.javacreate.ordercenter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售单单据完成参数
 *
 * @author xialei
 * @date 2021/12/13 11:39
 */
public class RepairSaleOrderConfirmPayDTO implements Serializable {

    private static final long serialVersionUID = -6381973099344200156L;

    private Long orderId;

    private BigDecimal payAmount;

    private Date collectionTime;

    private String optUserId;

    // @NotEmpty(message = "操作人不能为空")
    private String optUserName;

    private String desc;


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

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
