package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2023/1/4 17:47
 */
public class FixReturnOrderBO {


    private Long saleOrderId;

    private String mqId;

    private String returnOrderNo;

    public Long getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Long saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getMqId() {
        return mqId;
    }

    public void setMqId(String mqId) {
        this.mqId = mqId;
    }

    public String getReturnOrderNo() {
        return returnOrderNo;
    }

    public void setReturnOrderNo(String returnOrderNo) {
        this.returnOrderNo = returnOrderNo;
    }
}
