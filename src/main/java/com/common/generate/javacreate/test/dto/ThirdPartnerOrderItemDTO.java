package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2020/7/16 9:49
 */
public class ThirdPartnerOrderItemDTO implements Serializable {

    private static final long serialVersionUID = -6947099015008417207L;
    private String refSkuId;
    private Long businessItemId;
    private Long productSkuId;
    private String productName;
    private BigDecimal saleCount;
    private String sellUnit;
    private String productSaleSpec;
    private String productSpec;
    private BigDecimal specQuantity;
    private Long specificationId;
    private BigDecimal saleSpecQuantity;
    private String sellPriceUnit;
    private BigDecimal minUnitTotalCount;
    private BigDecimal sellPrice;
    private BigDecimal totalAmount;
    private BigDecimal payableAmount;
    private String packageName;
    private String unitName;
    private BigDecimal useCouponAmount;
    private String productBrand;
    private Long productOwnerId;
    private String sourceId;
    private Byte saleMode;
    private Byte sourceType;
    private String sourceName;
    private String boxCode;
    private String outerSkuId;
    private String remark;

    public String getRefSkuId() {
        return refSkuId;
    }

    public void setRefSkuId(String refSkuId) {
        this.refSkuId = refSkuId;
    }

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

    public BigDecimal getUseCouponAmount() {
        return useCouponAmount;
    }

    public void setUseCouponAmount(BigDecimal useCouponAmount) {
        this.useCouponAmount = useCouponAmount;
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

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Byte getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(Byte saleMode) {
        this.saleMode = saleMode;
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
