package com.common.generate.javacreate.ordercenter.dto.data;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderItemBO
 * @Description oms订单信息明细
 * @Author hhw
 * @Date 2022/5/11 11:48
 * @Version 1.0
 **/
public class OrderItemBO {
    /**
     * 主键
     */
    private Long id;

    private Long order_Id;

    /**
     * 业务id
     */
    private Long business_Id;

    private Long businessItem_Id;

    /**
     * 产品ID
     */
    private Long productSku_Id;

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
     * 产品实际货值金额
     */
    private BigDecimal totalRealAmount;

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

    private Date createTime;

    private Integer createUser_Id;

    private Date lastUpdateTime;

    private Integer lastUpdateUser_Id;

    /**
     * 包装箱码
     */
    private String packageBoxNo;

    /**
     * 成本金额
     */
    private BigDecimal supplyCostPrice;

    /**
     * 成本价单位
     */
    private String supplyCostPriceUnit;

    /**
     * 产品货主
     */
    private Long productOwner_Id;

    /**
     * 规格ID
     */
    private Long specification_Id;

    /**
     * 原始下单数量
     */
    private BigDecimal originalSaleCount;

    /**
     * 拣货顺序
     */
    private Integer pickSequence;

    /**
     * 小单位内配成本价
     */
    private BigDecimal unitCostprice;

    /**
     * 控货策略
     */
    private Long productControl_Id;

    /**
     * 控货策略
     */
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

    /**
     * jiupiorderitem表主键
     */
    private Long jiupiOrderItemTableId;

    /**
     * jiupiorder表主键
     */
    private Long jiupiOrder_Id;

    /**
     * orderitem表主键
     */
    private Long orderItem_Id;

    /**
     * 销售模式  0代营/1自营/2合作/3寄售/4大商转自营/5大商转配送/6入驻/7总部寄售
     */
    private Integer saleMode;

    /**
     * 供应商ID
     */
    private Integer supplier_Id;

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
     * 总价立减
     */
    private BigDecimal reduceProductAmount;

    /**
     * 订单满减
     */
    private BigDecimal reduceOrderAmount;

    /**
     * 优惠券
     */
    private BigDecimal reduceCouponAmount;

    /**
     * 红包
     */
    private BigDecimal reduceBonusAmount;

    /**
     * 自提优惠金额
     */
    private BigDecimal selfPickUpReduceAmount;

    /**
     * 订单项来源, 0普通商品/1产品满赠/2订单满赠 /3订单加价购/4限时惠/5组合活动商品 /6优惠券赠送商品/7凑单商品/8预售商品/9团购商品
     */
    private Integer sourceType;

    /**
     * 活动来源ID
     */
    private String source_Id;

    /**
     * 活动来源名称
     */
    private String sourceName;

    /**
     * 普通商品(0),赠送商品(1),限时惠商品(2),加价购商品(3)
     */
    private Integer productType;

    /**
     * 大商转配送，配送费用
     */
    private BigDecimal partnerDeliveryAmount;

    /**
     * 产品业务类型(0=酒类，1=非酒类)
     */
    private Integer productBusinessClass;

    /**
     * 优惠合计
     */
    private BigDecimal discountAmount;

    /**
     * 上游原始skuid
     */
    private Long skuRef_Id;


    /**
     * 服务费
     */
    private BigDecimal serviceFee;

    /**
     * 原价总金额
     */
    private BigDecimal originAmount;
    /**
     * 总优惠金额
     */
    private BigDecimal totalDiscount;

    /**
     * 依赖订单项ID
     */
    private List<Long> relationOrderItemIds;

    /**
     * 订单项优惠信息
     */
    private List<OrderItemDiscountBO> itemDiscounts;

    /**
     * 给crm的额外字段
     */
    private OrderItemOtherBO orderItemOtherBO;

    /**
     * 是否以销代采
     */
    private Integer replacePurchaseWithSales;

    /**
     * 经销商库存预分配
     */
    private List<OrderItemDealerAllocateInventoryBO> orderItemDealerAllocateInventoryBOList;

    /**
     * 久批来源仓库变化
     */
    @Deprecated
    private Boolean chgWarehouseId = false;
    /**
     * 采销模式
     */
    private Integer procurementMode;


    public Integer getProcurementMode() {
        return procurementMode;
    }

    public void setProcurementMode(Integer procurementMode) {
        this.procurementMode = procurementMode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Long getBusiness_Id() {
        return business_Id;
    }

    public void setBusiness_Id(Long business_Id) {
        this.business_Id = business_Id;
    }

    public Long getBusinessItem_Id() {
        return businessItem_Id;
    }

    public void setBusinessItem_Id(Long businessItem_Id) {
        this.businessItem_Id = businessItem_Id;
    }

    public Long getProductSku_Id() {
        return productSku_Id;
    }

    public void setProductSku_Id(Long productSku_Id) {
        this.productSku_Id = productSku_Id;
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

    public BigDecimal getTotalRealAmount() {
        return totalRealAmount;
    }

    public void setTotalRealAmount(BigDecimal totalRealAmount) {
        this.totalRealAmount = totalRealAmount;
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

    public Integer getCreateUser_Id() {
        return createUser_Id;
    }

    public void setCreateUser_Id(Integer createUser_Id) {
        this.createUser_Id = createUser_Id;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUser_Id() {
        return lastUpdateUser_Id;
    }

    public void setLastUpdateUser_Id(Integer lastUpdateUser_Id) {
        this.lastUpdateUser_Id = lastUpdateUser_Id;
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

    public Long getProductOwner_Id() {
        return productOwner_Id;
    }

    public void setProductOwner_Id(Long productOwner_Id) {
        this.productOwner_Id = productOwner_Id;
    }

    public Long getSpecification_Id() {
        return specification_Id;
    }

    public void setSpecification_Id(Long specification_Id) {
        this.specification_Id = specification_Id;
    }

    public BigDecimal getOriginalSaleCount() {
        return originalSaleCount;
    }

    public void setOriginalSaleCount(BigDecimal originalSaleCount) {
        this.originalSaleCount = originalSaleCount;
    }

    public Integer getPickSequence() {
        return pickSequence;
    }

    public void setPickSequence(Integer pickSequence) {
        this.pickSequence = pickSequence;
    }

    public BigDecimal getUnitCostprice() {
        return unitCostprice;
    }

    public void setUnitCostprice(BigDecimal unitCostprice) {
        this.unitCostprice = unitCostprice;
    }

    public Long getProductControl_Id() {
        return productControl_Id;
    }

    public void setProductControl_Id(Long productControl_Id) {
        this.productControl_Id = productControl_Id;
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

    public Long getJiupiOrderItemTableId() {
        return jiupiOrderItemTableId;
    }

    public void setJiupiOrderItemTableId(Long jiupiOrderItemTableId) {
        this.jiupiOrderItemTableId = jiupiOrderItemTableId;
    }

    public Long getJiupiOrder_Id() {
        return jiupiOrder_Id;
    }

    public void setJiupiOrder_Id(Long jiupiOrder_Id) {
        this.jiupiOrder_Id = jiupiOrder_Id;
    }

    public Long getOrderItem_Id() {
        return orderItem_Id;
    }

    public void setOrderItem_Id(Long orderItem_Id) {
        this.orderItem_Id = orderItem_Id;
    }

    public Integer getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(Integer saleMode) {
        this.saleMode = saleMode;
    }

    public Integer getSupplier_Id() {
        return supplier_Id;
    }

    public void setSupplier_Id(Integer supplier_Id) {
        this.supplier_Id = supplier_Id;
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

    public BigDecimal getReduceProductAmount() {
        return reduceProductAmount;
    }

    public void setReduceProductAmount(BigDecimal reduceProductAmount) {
        this.reduceProductAmount = reduceProductAmount;
    }

    public BigDecimal getReduceOrderAmount() {
        return reduceOrderAmount;
    }

    public void setReduceOrderAmount(BigDecimal reduceOrderAmount) {
        this.reduceOrderAmount = reduceOrderAmount;
    }

    public BigDecimal getReduceCouponAmount() {
        return reduceCouponAmount;
    }

    public void setReduceCouponAmount(BigDecimal reduceCouponAmount) {
        this.reduceCouponAmount = reduceCouponAmount;
    }

    public BigDecimal getReduceBonusAmount() {
        return reduceBonusAmount;
    }

    public void setReduceBonusAmount(BigDecimal reduceBonusAmount) {
        this.reduceBonusAmount = reduceBonusAmount;
    }

    public BigDecimal getSelfPickUpReduceAmount() {
        return selfPickUpReduceAmount;
    }

    public void setSelfPickUpReduceAmount(BigDecimal selfPickUpReduceAmount) {
        this.selfPickUpReduceAmount = selfPickUpReduceAmount;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getSource_Id() {
        return source_Id;
    }

    public void setSource_Id(String source_Id) {
        this.source_Id = source_Id;
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

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getSkuRef_Id() {
        return skuRef_Id;
    }

    public void setSkuRef_Id(Long skuRef_Id) {
        this.skuRef_Id = skuRef_Id;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
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

    public List<Long> getRelationOrderItemIds() {
        return relationOrderItemIds;
    }

    public void setRelationOrderItemIds(List<Long> relationOrderItemIds) {
        this.relationOrderItemIds = relationOrderItemIds;
    }

    public List<OrderItemDiscountBO> getItemDiscounts() {
        return itemDiscounts;
    }

    public void setItemDiscounts(List<OrderItemDiscountBO> itemDiscounts) {
        this.itemDiscounts = itemDiscounts;
    }

    public OrderItemOtherBO getOrderItemOtherBO() {
        return orderItemOtherBO;
    }

    public void setOrderItemOtherBO(OrderItemOtherBO orderItemOtherBO) {
        this.orderItemOtherBO = orderItemOtherBO;
    }

    public Integer getReplacePurchaseWithSales() {
        return replacePurchaseWithSales;
    }

    public void setReplacePurchaseWithSales(Integer replacePurchaseWithSales) {
        this.replacePurchaseWithSales = replacePurchaseWithSales;
    }

    public List<OrderItemDealerAllocateInventoryBO> getOrderItemDealerAllocateInventoryBOList() {
        return orderItemDealerAllocateInventoryBOList;
    }

    public void setOrderItemDealerAllocateInventoryBOList(List<OrderItemDealerAllocateInventoryBO> orderItemDealerAllocateInventoryBOList) {
        this.orderItemDealerAllocateInventoryBOList = orderItemDealerAllocateInventoryBOList;
    }

    public Boolean getChgWarehouseId() {
        return chgWarehouseId;
    }

    public void setChgWarehouseId(Boolean chgWarehouseId) {
        this.chgWarehouseId = chgWarehouseId;
    }
}
