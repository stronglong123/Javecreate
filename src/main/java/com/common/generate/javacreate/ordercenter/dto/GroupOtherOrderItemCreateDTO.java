package com.common.generate.javacreate.ordercenter.dto;

import com.common.generate.javacreate.test.dto.SettleOrderItemDetailDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/3/31 11:48
 */
public class GroupOtherOrderItemCreateDTO implements Serializable {

    private static final long serialVersionUID = -5667044554153026021L;
    /**
     * 产品SKU(必传)
     */
    private String productSkuId;
    /**
     * 产品名称(必传)
     */
    private String productName;
    /**
     * 销售数量小单位(必填)
     */
    private String minUnitTotalCount;

    /**
     * 金额(必传)
     */
    private String totalAmount;
    /**
     * 产品货主(必传)
     */
    private String productOwnerId;
    /**
     * 产品二级货主明细
     */
    List<GroupOtherOrderItemDetailDTO> details;

    public String getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(String productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMinUnitTotalCount() {
        return minUnitTotalCount;
    }

    public void setMinUnitTotalCount(String minUnitTotalCount) {
        this.minUnitTotalCount = minUnitTotalCount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(String productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public List<GroupOtherOrderItemDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<GroupOtherOrderItemDetailDTO> details) {
        this.details = details;
    }
}
