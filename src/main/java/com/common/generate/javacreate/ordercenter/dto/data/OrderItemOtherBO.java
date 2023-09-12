package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.math.BigDecimal;

/**
 * @ClassName OrderItemOtherBO
 * @Description oms给crm的额外字段
 * @Author hhw
 * @Date 2022/5/11 13:43
 * @Version 1.0
 **/
@ApiModel(description = "oms给crm的额外字段模型")
public class OrderItemOtherBO {
    @ApiParam(description = "id")
    private Long omsOrderItemId;
    /**
     * 来源数量.
     */
    @ApiParam(description = "来源数量")
    private Integer sourceCount;

    /**
     * 原价.
     */
    @ApiParam(description = "原价")
    private BigDecimal originalPrice;
    /**
     * 原价单位.
     */
    @ApiParam(description = "原价单位")
    private String originalPriceUnit;

    /**
     * 小单位价格.
     */
    @ApiParam(description = "小单位价格")
    private BigDecimal minUnitPrice;

    /**
     * 立减价格.
     */
    @ApiParam(description = "立减价格")
    private BigDecimal reduceProductPrice;
    /**
     * 立减价格单位.
     */
    @ApiParam(description = "立减价格单位")
    private String reduceProductPriceUnit;

    /**
     * 销售规格系数.
     */
    @ApiParam(description = "销售规格系数")
    private Integer sellToMinUnitQuantity;
    /**
     * 包装规格系数.
     */
    @ApiParam(description = "包装规格系数")
    private Integer maxToMinUnitQuantity;
    /**
     * 酒币数量.
     */
    @ApiParam(description = "酒币数量")
    private Integer wineScore;
    /**
     * 自提优惠减价.
     */
    @ApiParam(description = "自提优惠减价")
    private BigDecimal reduceSelfPickup;
    /**
     * 产品信息Id.
     */
    @ApiParam(description = "产品信息Id")
    private Integer productInfoId;
    /**
     * 是否可使用红包.
     */
    @ApiParam(description = "是否可使用红包")
    private Boolean isUseBonus;
    /**
     * 是否可使用优惠券.
     */
    @ApiParam(description = "是否可使用优惠券")
    private Boolean isUseCoupon;

    /**
     * 优惠码优惠金额
     */
    @ApiParam(description = "优惠码优惠金额")
    private BigDecimal reduceCouponCodeAmount;

    /**
     * 自提优惠金额.
     */
    @ApiParam(description = "自提优惠金额")
    private BigDecimal reduceSelfPickUp;

    /**
     * SKU是否带票.
     */
    @ApiParam(description = "SKU是否带票")
    private Boolean skuHasInputTaxInvoice;
    /**
     * 订单项 VIP价格优惠 + VIP会员首单优惠
     */
    @ApiParam(description = "订单项")
    private BigDecimal vipPriceDiscount;
    /**
     * 连锁商户id
     */
    @ApiParam(description = "连锁商户id")
    private Long chainStoreId;
    /**
     * 订单项原价总金额
     */
    @ApiParam(description = "订单项原价总金额")
    private BigDecimal originAmount;
    /**
     * 订单项总优惠
     */
    @ApiParam(description = "订单项总优惠")
    private BigDecimal totalDiscount;

    public Long getOmsOrderItemId() {
        return omsOrderItemId;
    }

    public void setOmsOrderItemId(Long omsOrderItemId) {
        this.omsOrderItemId = omsOrderItemId;
    }

    public Integer getSourceCount() {
        return sourceCount;
    }

    public void setSourceCount(Integer sourceCount) {
        this.sourceCount = sourceCount;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getOriginalPriceUnit() {
        return originalPriceUnit;
    }

    public void setOriginalPriceUnit(String originalPriceUnit) {
        this.originalPriceUnit = originalPriceUnit;
    }

    public BigDecimal getMinUnitPrice() {
        return minUnitPrice;
    }

    public void setMinUnitPrice(BigDecimal minUnitPrice) {
        this.minUnitPrice = minUnitPrice;
    }

    public BigDecimal getReduceProductPrice() {
        return reduceProductPrice;
    }

    public void setReduceProductPrice(BigDecimal reduceProductPrice) {
        this.reduceProductPrice = reduceProductPrice;
    }

    public String getReduceProductPriceUnit() {
        return reduceProductPriceUnit;
    }

    public void setReduceProductPriceUnit(String reduceProductPriceUnit) {
        this.reduceProductPriceUnit = reduceProductPriceUnit;
    }

    public Integer getSellToMinUnitQuantity() {
        return sellToMinUnitQuantity;
    }

    public void setSellToMinUnitQuantity(Integer sellToMinUnitQuantity) {
        this.sellToMinUnitQuantity = sellToMinUnitQuantity;
    }

    public Integer getMaxToMinUnitQuantity() {
        return maxToMinUnitQuantity;
    }

    public void setMaxToMinUnitQuantity(Integer maxToMinUnitQuantity) {
        this.maxToMinUnitQuantity = maxToMinUnitQuantity;
    }

    public Integer getWineScore() {
        return wineScore;
    }

    public void setWineScore(Integer wineScore) {
        this.wineScore = wineScore;
    }

    public BigDecimal getReduceSelfPickup() {
        return reduceSelfPickup;
    }

    public void setReduceSelfPickup(BigDecimal reduceSelfPickup) {
        this.reduceSelfPickup = reduceSelfPickup;
    }

    public Integer getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Integer productInfoId) {
        this.productInfoId = productInfoId;
    }

    public Boolean getUseBonus() {
        return isUseBonus;
    }

    public void setUseBonus(Boolean useBonus) {
        isUseBonus = useBonus;
    }

    public Boolean getUseCoupon() {
        return isUseCoupon;
    }

    public void setUseCoupon(Boolean useCoupon) {
        isUseCoupon = useCoupon;
    }

    public BigDecimal getReduceCouponCodeAmount() {
        return reduceCouponCodeAmount;
    }

    public void setReduceCouponCodeAmount(BigDecimal reduceCouponCodeAmount) {
        this.reduceCouponCodeAmount = reduceCouponCodeAmount;
    }

    public BigDecimal getReduceSelfPickUp() {
        return reduceSelfPickUp;
    }

    public void setReduceSelfPickUp(BigDecimal reduceSelfPickUp) {
        this.reduceSelfPickUp = reduceSelfPickUp;
    }

    public Boolean getSkuHasInputTaxInvoice() {
        return skuHasInputTaxInvoice;
    }

    public void setSkuHasInputTaxInvoice(Boolean skuHasInputTaxInvoice) {
        this.skuHasInputTaxInvoice = skuHasInputTaxInvoice;
    }

    public BigDecimal getVipPriceDiscount() {
        return vipPriceDiscount;
    }

    public void setVipPriceDiscount(BigDecimal vipPriceDiscount) {
        this.vipPriceDiscount = vipPriceDiscount;
    }

    public Long getChainStoreId() {
        return chainStoreId;
    }

    public void setChainStoreId(Long chainStoreId) {
        this.chainStoreId = chainStoreId;
    }

    public BigDecimal getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(BigDecimal originAmount) {
        this.originAmount = originAmount;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }
}
