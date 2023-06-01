package com.common.generate.javacreate.ordercenter.dto;

import java.util.List;

/**
 * @author zcd
 */
public class PushTmsPayConfirmDTO {
    /**
     * 配送批次id
     */
    private Long deliveryTaskId;

    /**
     * 操作人id
     */
    private Long optUserId;

    /**
     * 订单id列表
     */
    private List<Long> orderIds;

    public Long getDeliveryTaskId() {
        return deliveryTaskId;
    }

    public void setDeliveryTaskId(Long deliveryTaskId) {
        this.deliveryTaskId = deliveryTaskId;
    }

    public Long getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(Long optUserId) {
        this.optUserId = optUserId;
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    @Override
    public String toString() {
        return "PushTMSPayConfirmDTO{" +
                "deliveryTaskId=" + deliveryTaskId +
                ", optUserId=" + optUserId +
                ", orderIds=" + orderIds +
                '}';
    }
}
