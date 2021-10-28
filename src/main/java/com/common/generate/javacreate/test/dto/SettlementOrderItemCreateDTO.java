package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/3/31 11:48
 */
public class SettlementOrderItemCreateDTO implements Serializable {

    private static final long serialVersionUID = -5667044554153026021L;
    /**
     * 关联项明细id
     */
    private Long businessItemId;
    /**
     * 产品SKU(必传)
     */
    private Long productSkuId;
    /**
     * 产品名称(必传)
     */
    private String productName;
    /**
     * 订单数量(必传)
     */
    private BigDecimal saleCount;
    /**
     * 单位名称(必传)
     */
    private String sellUnit;
    /**
     * 销售规格名称
     */
    private String productSaleSpec;
    /**
     * 包装规格名称
     */
    private String productSpec;
    /**
     * 包装规格系数
     */
    private BigDecimal specQuantity;
    /**
     * 规格
     */
    private Long specificationId;
    /**
     * 销售规格系数
     */
    private BigDecimal saleSpecQuantity;
    /**
     * 销售价格单位
     */
    private String sellPriceUnit;
    /**
     * 销售数量小单位(必填)
     */
    private BigDecimal minUnitTotalCount;
    /**
     * 销售单价
     */
    private BigDecimal sellPrice;
    /**
     * 金额(必传)
     */
    private BigDecimal totalAmount;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount;
    /**
     * 大单位
     */
    private String packageName;
    /**
     * 小单位
     */
    private String unitName;
    /**
     * 品牌
     */
    private String productBrand;
    /**
     * 产品货主(必传)
     */
    private Long productOwnerId;

    /**
     * 产品二级货主(必传)
     */
    private Long productSecOwnerId;
    /**
     * 条形码
     */
    private String boxCode;
    /**
     * 优惠金额
     */
    private BigDecimal useCouponAmount;

    /**
     * 产品二级货主明细
     */
    List<SettleOrderItemDetailDTO> details;

    /**
     * 关联账单明细id
     */
    private Long refSettleItemId;

    public Long getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(Long businessItemId) {
        this.businessItemId = businessItemId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(BigDecimal saleCount) {
        this.saleCount = saleCount;
    }

    public String getSellUnit() {
        return sellUnit;
    }

    public void setSellUnit(String sellUnit) {
        this.sellUnit = sellUnit;
    }

    public String getProductSaleSpec() {
        return productSaleSpec;
    }

    public void setProductSaleSpec(String productSaleSpec) {
        this.productSaleSpec = productSaleSpec;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public BigDecimal getSaleSpecQuantity() {
        return saleSpecQuantity;
    }

    public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
        this.saleSpecQuantity = saleSpecQuantity;
    }

    public String getSellPriceUnit() {
        return sellPriceUnit;
    }

    public void setSellPriceUnit(String sellPriceUnit) {
        this.sellPriceUnit = sellPriceUnit;
    }

    public BigDecimal getMinUnitTotalCount() {
        return minUnitTotalCount;
    }

    public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
        this.minUnitTotalCount = minUnitTotalCount;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public Long getProductSecOwnerId() {
        return productSecOwnerId;
    }

    public void setProductSecOwnerId(Long productSecOwnerId) {
        this.productSecOwnerId = productSecOwnerId;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public BigDecimal getUseCouponAmount() {
        return useCouponAmount;
    }

    public void setUseCouponAmount(BigDecimal useCouponAmount) {
        this.useCouponAmount = useCouponAmount;
    }

    public List<SettleOrderItemDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<SettleOrderItemDetailDTO> details) {
        this.details = details;
    }

    public Long getRefSettleItemId() {
        return refSettleItemId;
    }

    public void setRefSettleItemId(Long refSettleItemId) {
        this.refSettleItemId = refSettleItemId;
    }
}
