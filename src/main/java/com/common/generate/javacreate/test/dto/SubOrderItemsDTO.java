package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2020/9/18 9:26
 */
public class SubOrderItemsDTO implements Serializable {

    private static final long serialVersionUID = 7864820635739611872L;
    /**
     * 产品skuid
     */
    private String productSkuId;

    /**
     * 第三方产品skuid
     */
    private String refSkuId;

    /**
     * 发货数量，该参数为空则默认全部发货。
     */
    private BigDecimal logisticsCount;
    /**
     * 订单明细项Id
     */
    private Long orderItemId;


    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(String productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getRefSkuId() {
        return refSkuId;
    }

    public void setRefSkuId(String refSkuId) {
        this.refSkuId = refSkuId;
    }

    public BigDecimal getLogisticsCount() {
        return logisticsCount;
    }

    public void setLogisticsCount(BigDecimal logisticsCount) {
        this.logisticsCount = logisticsCount;
    }
}
