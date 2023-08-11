package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2023/7/18 14:02
 */
public class RepairAddressIdDTO implements Serializable {

    private Long orderId;

    private Long addressId;

    private Long trdAddressId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTrdAddressId() {
        return trdAddressId;
    }

    public void setTrdAddressId(Long trdAddressId) {
        this.trdAddressId = trdAddressId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
