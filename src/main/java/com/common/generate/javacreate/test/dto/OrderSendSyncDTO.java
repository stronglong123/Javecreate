package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/9/18 9:24
 */
public class OrderSendSyncDTO implements Serializable {

    private static final long serialVersionUID = 8627548393190397764L;
    /**
     * 原始订单号
     */
    private String businessNo;

    /**
     * 子订单数量，如果没有拆单，数量为1
     */
    private Integer subOrderSize;

    /**
     * 订单物流信息集合
     */
    List<LogsticsDTO> logstics;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public Integer getSubOrderSize() {
        return subOrderSize;
    }

    public void setSubOrderSize(Integer subOrderSize) {
        this.subOrderSize = subOrderSize;
    }

    public List<LogsticsDTO> getLogstics() {
        return logstics;
    }

    public void setLogstics(List<LogsticsDTO> logstics) {
        this.logstics = logstics;
    }
}
