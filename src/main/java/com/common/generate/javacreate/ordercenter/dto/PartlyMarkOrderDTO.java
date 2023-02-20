package com.common.generate.javacreate.ordercenter.dto;

import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * @author xialei
 * @date 2022/10/14 11:12
 */
public class PartlyMarkOrderDTO {

    private Long orderId;

    private Integer markType;

    private List<PartlyMarkOrderItemDTO> trainsOutStockOrderItemList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getMarkType() {
        return markType;
    }

    public void setMarkType(Integer markType) {
        this.markType = markType;
    }

    public List<PartlyMarkOrderItemDTO> getTrainsOutStockOrderItemList() {
        return trainsOutStockOrderItemList;
    }

    public void setTrainsOutStockOrderItemList(List<PartlyMarkOrderItemDTO> trainsOutStockOrderItemList) {
        this.trainsOutStockOrderItemList = trainsOutStockOrderItemList;
    }
}
