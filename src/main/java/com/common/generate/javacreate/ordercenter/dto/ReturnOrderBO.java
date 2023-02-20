package com.common.generate.javacreate.ordercenter.dto;

/**
 * @author xialei
 * @date 2023/1/4 17:43
 */
public class ReturnOrderBO {

    private Long refOmsOrderId;

    private String businessNo;


    public Long getRefOmsOrderId() {
        return refOmsOrderId;
    }

    public void setRefOmsOrderId(Long refOmsOrderId) {
        this.refOmsOrderId = refOmsOrderId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }
}
