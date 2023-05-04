package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TrainsOutStockDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 订单信息
     */
    //@ApiParam(description = "订单信息", required = true)
    List<TrainsOutStockOrderDTO> trainsOutStockOrderList;

    /**
     * 批次id(车次di)
     */
    //@ApiParam(description = "批次id", required = true)
    private String deliveryTaskId;
    /**
     * 车牌号
     */
    //@ApiParam(description = "批次编号")
    private String deliveryCarNumber;
    /**
     * 城市id
     */
    //@ApiParam(description = "城市id")
    private Long cityId;
    /**
     * 出库仓库Id
     */
    //@ApiParam(description = "出库仓库Id", required = true)
    private Long warehouseId;
    /**
     * 出库时间
     */
    //@ApiParam(description = "出库时间", required = true)
    private Date outStockTime;
    /**
     * 操作人Id
     */
    //@ApiParam(description = "操作人Id", required = true)
    private String optUserId;

    /**
     * 是否提前拣货
     */
    //@ApiParam(description = "是否提前拣货", required = true)
    private Boolean advancePickup;

    public String getDeliveryTaskId() {
        return deliveryTaskId;
    }

    public void setDeliveryTaskId(String deliveryTaskId) {
        this.deliveryTaskId = deliveryTaskId;
    }

    public String getDeliveryCarNumber() {
        return deliveryCarNumber;
    }

    public void setDeliveryCarNumber(String deliveryCarNumber) {
        this.deliveryCarNumber = deliveryCarNumber;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Date getOutStockTime() {
        return outStockTime;
    }

    public void setOutStockTime(Date outStockTime) {
        this.outStockTime = outStockTime;
    }

    public String getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(String optUserId) {
        this.optUserId = optUserId;
    }

    public List<TrainsOutStockOrderDTO> getTrainsOutStockOrderList() {
        return trainsOutStockOrderList;
    }

    public void setTrainsOutStockOrderList(List<TrainsOutStockOrderDTO> trainsOutStockOrderList) {
        this.trainsOutStockOrderList = trainsOutStockOrderList;
    }

    /**
     * 获取 是否提前拣货
     *
     * @return advancePickup 是否提前拣货
     */
    public Boolean getAdvancePickup() {
        return this.advancePickup;
    }

    /**
     * 设置 是否提前拣货
     *
     * @param advancePickup 是否提前拣货
     */
    public void setAdvancePickup(Boolean advancePickup) {
        this.advancePickup = advancePickup;
    }
}
