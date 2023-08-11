package com.common.generate.javacreate.ordercenter.dto;


import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * erp调拨单明细
 *
 * @author xialei
 * @date 2021-12-29
 */
@ApiModel(description = "调拨单明细新增模型")
public class ERPTransferOrderItemDTO implements Serializable {

    private static final long serialVersionUID = 2691461714798297154L;

    /**
     * 产品货主
     */
    @ApiParam(description = "产品货主ID")
    private Long productOwnerId;

    /**
     * 订单明细ID
     */
    @ApiParam(description = "订单明细ID", required = true)
    private String businessItemId;

    /**
     * 产品信息规格ID
     */
    @ApiParam(description = "产品信息规格ID", required = true)
    private Long specificationId;

    /**
     * 产品id
     */
    @ApiParam(description = "产品ID", required = true)
    private Long productSkuId;

    /**
     * SKU名称
     */
    @ApiParam(description = "SKU名称", required = true)
    private String productName;


    /**
     * 规格系数
     */
    @ApiParam(description = "销售规格系数", required = true)
    private BigDecimal specQuantity;

    /**
     * 销售规格
     */
    @ApiParam(description = "销售规格", required = true)
    private String saleSpec;

    /**
     * 销售数量小单位
     */
    @ApiParam(description = "销售数量小单位", required = true)
    private BigDecimal minUnitTotalCount;

    /**
     * 调拨单价
     */
    @ApiParam(description = "调拨单价")
    private BigDecimal sellPrice;

    /**
     * 调拨单价单位
     */
    @ApiParam(description = "调拨单价单位")
    private String sellPriceUnit;

    /**
     * 大单位
     */
    @ApiParam(description = "大单位", required = true)
    private String packageName;

    /**
     * 小单位
     */
    @ApiParam(description = "小单位", required = true)
    private String unitName;


    /**
     * 产品总价
     */
    @ApiParam(description = "产品总价")
    private BigDecimal totalAmount;

    /**
     * 应付金额
     */
    @ApiParam(description = "应付金额")
    private BigDecimal payAmount;
    /**
     * 统计类目
     */
    @ApiParam(description = "统计类目")
    private String statisticsCategoryName;

    @ApiParam(description = "产品包装规格")
    private String productSpec;


    /**
     * 调拨策略，可选：0：批次入驻优先（默认）；  1：自营优先
     */
    @ApiParam(description = "调拨策略,0批次入驻优先(默认),1自营优先")
    private Integer allocationStrategy;

    @ApiParam(description = "调拨二级货主明细")
    private List<OrderItemSecOwnerAllocateDTO>  itemSecOwnerAllocates;

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
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

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
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

    public String getSellPriceUnit() {
        return sellPriceUnit;
    }

    public void setSellPriceUnit(String sellPriceUnit) {
        this.sellPriceUnit = sellPriceUnit;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getStatisticsCategoryName() {
        return statisticsCategoryName;
    }

    public void setStatisticsCategoryName(String statisticsCategoryName) {
        this.statisticsCategoryName = statisticsCategoryName;
    }

    public String getSaleSpec() {
        return saleSpec;
    }

    public void setSaleSpec(String saleSpec) {
        this.saleSpec = saleSpec;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public Integer getAllocationStrategy() {
        return this.allocationStrategy;
    }

    public void setAllocationStrategy(final Integer allocationStrategy) {
        this.allocationStrategy = allocationStrategy;
    }

    public List<OrderItemSecOwnerAllocateDTO> getItemSecOwnerAllocates() {
        return itemSecOwnerAllocates;
    }

    public void setItemSecOwnerAllocates(List<OrderItemSecOwnerAllocateDTO> itemSecOwnerAllocates) {
        this.itemSecOwnerAllocates = itemSecOwnerAllocates;
    }
}
