package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class TrainsOutStockOrderItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 订单项id
     */
    //@ApiParam(description = "订单项id", required = true)
    private Long orderItemId;

    /**
     * 小件总数
     */
    //@ApiParam(description = "小件总数", required = true)
    private BigDecimal unitTotalCount;

    /**
     * 出库明细项Id
     */
    //@ApiParam(description = "出库明细项Id", required = true)
    private Long outStockOrderItemId;
    /**
     * 产品sku
     */
    //@ApiParam(description = "产品sku")
    private Long productSkuId;
    /**
     * 备注
     */
    //@ApiParam(description = "备注")
    private String tag;

    /**
     * 二级货主信息
     */
    private List<TrainsOutStockDealerDTO> trainsOutStockDealerList;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public List<TrainsOutStockDealerDTO> getTrainsOutStockDealerList() {
        return trainsOutStockDealerList;
    }

    public void setTrainsOutStockDealerList(List<TrainsOutStockDealerDTO> trainsOutStockDealerList) {
        this.trainsOutStockDealerList = trainsOutStockDealerList;
    }


    /**
     * 获取 出库明细项Id
     *
     * @return outStockOrderItemId 出库明细项Id
     */
    public Long getOutStockOrderItemId() {
        return this.outStockOrderItemId;
    }

    /**
     * 设置 出库明细项Id
     *
     * @param outStockOrderItemId 出库明细项Id
     */
    public void setOutStockOrderItemId(Long outStockOrderItemId) {
        this.outStockOrderItemId = outStockOrderItemId;
    }

    /**
     * 获取 产品sku
     *
     * @return productSkuId 产品sku
     */
    public Long getProductSkuId() {
        return this.productSkuId;
    }

    /**
     * 设置 产品sku
     *
     * @param productSkuId 产品sku
     */
    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * 获取 备注
     *
     * @return tag 备注
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * 设置 备注
     *
     * @param tag 备注
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
