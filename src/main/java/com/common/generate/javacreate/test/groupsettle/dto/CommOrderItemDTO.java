package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.util.List;

public class CommOrderItemDTO implements Serializable {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 详情项
     */
    private List<CommOrderItemDetailDTO> commOrderItemDetailDTOS;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public List<CommOrderItemDetailDTO> getCommOrderItemDetailDTOS() {
        return commOrderItemDetailDTOS;
    }

    public void setCommOrderItemDetailDTOS(List<CommOrderItemDetailDTO> commOrderItemDetailDTOS) {
        this.commOrderItemDetailDTOS = commOrderItemDetailDTOS;
    }
}
