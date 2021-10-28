package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2021/4/29 10:23
 */
public class SettleOrderCompleteMqDTO extends NewOrderCompleteMqDTO implements Serializable {

    private static final long serialVersionUID = -7962776733809190381L;
    /**
     * 下单时间
     */
    private String orderCreateTime;
	
	    /**
     * 关联账单id
     */
    private String refSettleId;

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getRefSettleId() {
        return refSettleId;
    }

    public void setRefSettleId(String refSettleId) {
        this.refSettleId = refSettleId;
    }
}
