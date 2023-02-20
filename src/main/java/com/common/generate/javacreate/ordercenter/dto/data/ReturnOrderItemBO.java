package com.common.generate.javacreate.ordercenter.dto.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ReturnOrderItemBO
 * @Description oms退货单详情
 * @Author hhw
 * @Date 2022/5/13 9:46
 * @Version 1.0
 **/
public class ReturnOrderItemBO implements Serializable {

    private static final long serialVersionUID = -4315073514874601594L;
    /**
     * orderItem.id
     */
    private Long id;

    private Long orderId;

    private Long businessId;

    private Long businessItemId;

    /**
     * 产品ID
     */
    private Long productSkuId;

    /**
     * 产品中台unifySkuId
     */
    private Long unifySkuId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 数量
     */
    private BigDecimal saleCount;

    /**
     * 单位名称
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
     * 销售规格系数
     */
    private BigDecimal saleSpecQuantity;

    /**
     * 销售规格系数
     */
    private BigDecimal specQuantity;

    /**
     * 销售价格单位
     */
    private String sellPriceUnit;

    /**
     * 销售数量小单位
     */
    private BigDecimal minUnitTotalCount;

    /**
     * 销售单价
     */
    private BigDecimal sellPrice;

    /**
     * 金额
     */
    private BigDecimal totalAmount;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 配送费用金额
     */
    private BigDecimal deliveryAmount;

    /**
     * 大单位名称
     */
    private String packageName;

    /**
     * 小单位名称
     */
    private String unitName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUserId;
    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
    /**
     * 最后修改人
     */
    private Integer lastUpdateUserId;

    /**
     * 包装箱码
     */
    private String packageBoxNo;

    /**
     * 成本价
     */
    private BigDecimal supplyCostPrice;

    /**
     * 成本价单位
     */
    private String supplyCostPriceUnit;

    /**
     * 产品货主
     */
    private Long productOwnerId;

    /**
     * 规格ID
     */
    private Long specificationId;

    /**
     * 原始下单数量
     */
    private BigDecimal originalSaleCount;

    /**
     * 小单位内配成本价
     */
    private BigDecimal unitCostPrice;
    /**
     * 控货策略
     */
    private Long productControlId;
    private String productControlName;
    /**
     * 溯原码
     */
    private String productSourceName;
    /**
     * 扣库存数量
     */
    private BigDecimal inventoryCount;
    /**
     * 发货仓数量
     */
    private BigDecimal localOriginalSaleCount;

    /**
     * crm要求，不要用
     * 关联原单订单项id
     */
    private Long relOrderItemId;
    /**
     * SKU是否带票.
     */
    private Boolean skuHasInputTaxInvoice;
    /**
     * 是否强制--强制的话不管关不关连原单,一律强制退指定类型库存
     */
    private Boolean isForce = false;

    /**jiupiReturnOrderItem*/
    /**
     * jiupireturnorderitem.id
     */
    private Long jiupiReturnOrderItemId;
    private Long jiupiReturnOrderId;

    private Long orderItemId;

    /**
     * 销售模式  0代营/1自营/2合作/3寄售/4大商转自营/5大商转配送/6入驻/7总部寄售
     */
    private Integer saleMode;

    /**
     * 供应商ID
     */
    private Integer supplierId;

    /**
     * 品牌
     */
    private String productBrand;
    /**
     * 产品分类
     */
    private Long productStatisticsClass;
    /**
     * 统计类目
     */
    private String statisticsCategoryName;

    /**
     * 条形码
     */
    private String boxCode;

    /**
     * 订单项来源, 0普通商品/1产品满赠/2订单满赠 /3订单加价购/4限时惠/5组合活动商品 /6优惠券赠送商品/7凑单商品/8预售商品/9团购商品
     */
    private Integer sourceType;

    /**
     * 活动来源ID
     */
    private String sourceId;

    /**
     * 活动来源ID
     */
    private String sourceName;

    /**
     * 普通商品(0),赠送商品(1),限时惠商品(2),加价购商品(3)
     */
    private Integer productType;

    /**
     * 退货金额
     */
    private BigDecimal returnAmount;

    /**
     * 退红包
     */
    private BigDecimal returnBonusAmount;

    /**
     * 大商转配送，配送费用
     */
    private BigDecimal partnerDeliveryAmount;

    /**
     * 产品业务类型(0=酒类，1=非酒类)
     */
    private Integer productBusinessClass;

    /**
     * 退货数量
     */
    private BigDecimal returnCount;

    /**
     * 原始SKUid
     */
    private Long skuRefId;

    /**
     * 退货方式：0: 普通退货, 1: 质量退
     */
    private Integer returnWay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
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

    public Long getUnifySkuId() {
        return unifySkuId;
    }

    public void setUnifySkuId(Long unifySkuId) {
        this.unifySkuId = unifySkuId;
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

    public BigDecimal getSaleSpecQuantity() {
        return saleSpecQuantity;
    }

    public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
        this.saleSpecQuantity = saleSpecQuantity;
    }

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
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

    public BigDecimal getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(BigDecimal deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getPackageBoxNo() {
        return packageBoxNo;
    }

    public void setPackageBoxNo(String packageBoxNo) {
        this.packageBoxNo = packageBoxNo;
    }

    public BigDecimal getSupplyCostPrice() {
        return supplyCostPrice;
    }

    public void setSupplyCostPrice(BigDecimal supplyCostPrice) {
        this.supplyCostPrice = supplyCostPrice;
    }

    public String getSupplyCostPriceUnit() {
        return supplyCostPriceUnit;
    }

    public void setSupplyCostPriceUnit(String supplyCostPriceUnit) {
        this.supplyCostPriceUnit = supplyCostPriceUnit;
    }

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public BigDecimal getOriginalSaleCount() {
        return originalSaleCount;
    }

    public void setOriginalSaleCount(BigDecimal originalSaleCount) {
        this.originalSaleCount = originalSaleCount;
    }

    public BigDecimal getUnitCostPrice() {
        return unitCostPrice;
    }

    public void setUnitCostPrice(BigDecimal unitCostPrice) {
        this.unitCostPrice = unitCostPrice;
    }

    public Long getProductControlId() {
        return productControlId;
    }

    public void setProductControlId(Long productControlId) {
        this.productControlId = productControlId;
    }

    public String getProductControlName() {
        return productControlName;
    }

    public void setProductControlName(String productControlName) {
        this.productControlName = productControlName;
    }

    public String getProductSourceName() {
        return productSourceName;
    }

    public void setProductSourceName(String productSourceName) {
        this.productSourceName = productSourceName;
    }

    public BigDecimal getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(BigDecimal inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public BigDecimal getLocalOriginalSaleCount() {
        return localOriginalSaleCount;
    }

    public void setLocalOriginalSaleCount(BigDecimal localOriginalSaleCount) {
        this.localOriginalSaleCount = localOriginalSaleCount;
    }

    public Long getRelOrderItemId() {
        return relOrderItemId;
    }

    public void setRelOrderItemId(Long relOrderItemId) {
        this.relOrderItemId = relOrderItemId;
    }

    public Boolean getSkuHasInputTaxInvoice() {
        return skuHasInputTaxInvoice;
    }

    public void setSkuHasInputTaxInvoice(Boolean skuHasInputTaxInvoice) {
        this.skuHasInputTaxInvoice = skuHasInputTaxInvoice;
    }

    public Boolean getForce() {
        return isForce;
    }

    public void setForce(Boolean force) {
        isForce = force;
    }

    public Long getJiupiReturnOrderItemId() {
        return jiupiReturnOrderItemId;
    }

    public void setJiupiReturnOrderItemId(Long jiupiReturnOrderItemId) {
        this.jiupiReturnOrderItemId = jiupiReturnOrderItemId;
    }

    public Long getJiupiReturnOrderId() {
        return jiupiReturnOrderId;
    }

    public void setJiupiReturnOrderId(Long jiupiReturnOrderId) {
        this.jiupiReturnOrderId = jiupiReturnOrderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(Integer saleMode) {
        this.saleMode = saleMode;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Long getProductStatisticsClass() {
        return productStatisticsClass;
    }

    public void setProductStatisticsClass(Long productStatisticsClass) {
        this.productStatisticsClass = productStatisticsClass;
    }

    public String getStatisticsCategoryName() {
        return statisticsCategoryName;
    }

    public void setStatisticsCategoryName(String statisticsCategoryName) {
        this.statisticsCategoryName = statisticsCategoryName;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public BigDecimal getReturnBonusAmount() {
        return returnBonusAmount;
    }

    public void setReturnBonusAmount(BigDecimal returnBonusAmount) {
        this.returnBonusAmount = returnBonusAmount;
    }

    public BigDecimal getPartnerDeliveryAmount() {
        return partnerDeliveryAmount;
    }

    public void setPartnerDeliveryAmount(BigDecimal partnerDeliveryAmount) {
        this.partnerDeliveryAmount = partnerDeliveryAmount;
    }

    public Integer getProductBusinessClass() {
        return productBusinessClass;
    }

    public void setProductBusinessClass(Integer productBusinessClass) {
        this.productBusinessClass = productBusinessClass;
    }

    public BigDecimal getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(BigDecimal returnCount) {
        this.returnCount = returnCount;
    }

    public Long getSkuRefId() {
        return skuRefId;
    }

    public void setSkuRefId(Long skuRefId) {
        this.skuRefId = skuRefId;
    }

    public Integer getReturnWay() {
        return returnWay;
    }

    public void setReturnWay(Integer returnWay) {
        this.returnWay = returnWay;
    }
}

