package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//ApiModel(description = "批次销售单明细新增模型")
public class OrderItemAddDTO implements Serializable {
    private static final long serialVersionUID = 7807453131207341190L;

    //ApiParam(description = "订单明细ID", required = true)
    //NotNull(message = "订单明细ID不能为空")
    private Long orderItemId;

    //ApiParam(description = "产品sku", required = true)
    //NotNull(message = "产品SKU 不能为空")
    private Long productSkuId;


    //ApiParam(description = "产品 OwnerId")
    private Long productOwnerId;

    //ApiParam(description = "产品名", required = true)
    //NotEmpty(message = "产品名不能为空")
    private String productName;

    //ApiParam(description = "店铺id", required = true)
    //NotNull(message = "店铺id不能为空")
    private Long shopId;

    //ApiParam(description = "店铺类型 普通经销商(0),易久批自营店铺(2),品牌商(3),虚仓实配-代运营店铺(4)", required = true)
    //NotNull(message = "店铺类型  不能为空")
    private Integer shopType;

    //ApiParam(description = "店铺名称", required = true)
    //NotNull(message = "店铺名称  不能为空")
    private String shopName;

    //ApiParam(description = "经销商ID")
    private Long dealerId;

    //ApiParam(description = "规格ID", required = true)
    //NotNull(message = "规格ID 不能为空")
    private Long specificationId;

    //ApiParam(description = "销售规格名称", required = true)
    //NotEmpty(message = "销售规格名称不能为空")
    private String productSaleSpec;

    //ApiParam(description = "包装规格名称", required = true)
    //NotEmpty(message = "包装规格名称不能为空")
    private String productSpec;

    //ApiParam(description = "销售规格系数", required = true)
    //NotNull(message = "销售规格系数不能为空")
    private Integer saleSpecQuantity;

    //ApiParam(description = "包装规格系数", required = true)
    //NotNull(message = "包装规格系数不能为空")
    private Integer specQuantity;

    //ApiParam(description = "包装规格大单位", required = true)
    //NotEmpty(message = "包装规格 大单位不能为空")
    private String packageName;

    //ApiParam(description = "包装规格小单位", required = true)
    //NotEmpty(message = "包装规格小单位不能为空")
    private String unitName;

    //ApiParam(description = "品牌")
    private String productBrand;

    //ApiParam(description = "销售单价", required = true)
    //NotNull(message = "销售单价不能为空")
    private BigDecimal sellPrice;

    //ApiParam(description = "销售单价单位", required = true)
    //NotEmpty(message = "销售单价单位不能为空")
    private String sellPriceUnit;

    //ApiParam(description = "成本价")
    private BigDecimal costPrice;

    //ApiParam(description = "成本价单位")
    private String costPriceUnit;

    //ApiParam(description = "销售模式", required = true)
    //NotNull(message = "销售模式不能为空")
    private Integer saleMode;

    //ApiParam(description = "合作商配送费用")
    private BigDecimal partnerDeliveryAmount;

    //ApiParam(description = "产品类型 普通商品(0), 赠送商品(1), 限时惠商品(2), 加价购商品(3)", required = true)
    //NotNull(message = "产品类型不能为空")
    private Integer productType;

    //ApiParam(description = "来源类型")
    private Integer sourceType;

    //ApiParam(description = "来源ID")
    private String sourceId;

    //ApiParam(description = "来源名称")
    private String sourceName;

    //ApiParam(description = "依赖订单项ID")
    private List<Long> relationOrderItemIds;

    //ApiParam(description = "销售数量", required = true)
    //NotNull(message = "销售数量不能为空")
    private BigDecimal saleCount;


    //ApiParam(description = "销售单位", required = true)
    //NotEmpty(message = "销售单位不能为空")
    private String sellUnit;

    //ApiParam(description = "销售数量小单位", required = true)
    //NotNull(message = "销售数量小单位不能为空")
    private BigDecimal minUnitTotalCount;

    //ApiParam(description = "产品总价", required = true)
    //NotNull(message = "产品总价不能为空")
    private BigDecimal totalAmount;

    //ApiParam(description = "总价立减")
    private BigDecimal reduceProductAmount;

    //ApiParam(description = "订单满减")
    private BigDecimal reduceOrderAmount;

    //ApiParam(description = "优惠券")
    private BigDecimal reduceCouponAmount;

    //ApiParam(description = "红包")
    private BigDecimal reduceBonusAmount;

    //ApiParam(description = "自提优惠金额")
    private BigDecimal reduceSelfPickUp;

    //ApiParam(description = "合计优惠金额")
    private BigDecimal reduceTotal;

    //ApiParam(description = "应付金额", required = true)
    //NotNull(message = "应付金额 不能为空")
    private BigDecimal payAmount;

    /**
     * 仓库id 发货仓id
     */
    //ApiParam(description = "仓库id")
    private Long warehouseId;

    //ApiParam(description = "是否锁仓 如果是，则仓库id必传")
    private Boolean lockedWarehouse;

    //ApiParam(description = "是否预售", required = true)
    //NotNull(message = "是否预售字段 不能为空")
    private Boolean preSale;

    //ApiParam(description = "是否字自提", required = true)
    //NotNull(message = "是否自提字段 不能为空")
    private Boolean selfPickup;

    //ApiParam(description = "支付方式")
    private Integer payType;

    //ApiParam(description = "用户备注信息")
    private String userRemark;

    /**
     * 是否在线支付
     */
    //ApiParam(description = "是否在线支付")
    private Boolean onlinePayment;
    /**
     * SKU是否带票.
     */
    //ApiParam(description = "SKU是否带票")
    private Boolean skuHasInputTaxInvoice;

    //ApiParam(description = "配送方式0-久批配送,1-合作商配送,2-经销商配送,4-客户自提,5-总部物流,6-区域代配送,7-快递直发,20-门店转配送")
    private Integer deliveryMode;

    //ApiParam(description = "可退货天数")
    private Integer returnableDays;

    //ApiParam(description = "采销模式 自营(0),批次入驻(1),实仓入驻(2),虚仓入驻(3),仓储服务(4),直配入驻(5),虚仓实配(6)")
    private Integer procurementMode;

    //ApiParam(description = "明细参与优惠活动集合")
//	private List<OrderItemActivityDTO> orderItemActivityList;

    //ApiParam(description = "明细享受活动集合（分摊）")
//	private List<OrderItemDiscountActivityDTO> orderItemDiscountActivityList;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
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

    public Integer getSaleSpecQuantity() {
        return saleSpecQuantity;
    }

    public void setSaleSpecQuantity(Integer saleSpecQuantity) {
        this.saleSpecQuantity = saleSpecQuantity;
    }

    public Integer getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(Integer specQuantity) {
        this.specQuantity = specQuantity;
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

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getCostPriceUnit() {
        return costPriceUnit;
    }

    public void setCostPriceUnit(String costPriceUnit) {
        this.costPriceUnit = costPriceUnit;
    }

    public Integer getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(Integer saleMode) {
        this.saleMode = saleMode;
    }

    public BigDecimal getPartnerDeliveryAmount() {
        return partnerDeliveryAmount;
    }

    public void setPartnerDeliveryAmount(BigDecimal partnerDeliveryAmount) {
        this.partnerDeliveryAmount = partnerDeliveryAmount;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
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

    public List<Long> getRelationOrderItemIds() {
        return relationOrderItemIds;
    }

    public void setRelationOrderItemIds(List<Long> relationOrderItemIds) {
        this.relationOrderItemIds = relationOrderItemIds;
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

    public BigDecimal getMinUnitTotalCount() {
        return minUnitTotalCount;
    }

    public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
        this.minUnitTotalCount = minUnitTotalCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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

    public BigDecimal getReduceSelfPickUp() {
        return reduceSelfPickUp;
    }

    public void setReduceSelfPickUp(BigDecimal reduceSelfPickUp) {
        this.reduceSelfPickUp = reduceSelfPickUp;
    }

    public BigDecimal getReduceTotal() {
        return reduceTotal;
    }

    public void setReduceTotal(BigDecimal reduceTotal) {
        this.reduceTotal = reduceTotal;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Boolean getLockedWarehouse() {
        return lockedWarehouse;
    }

    public void setLockedWarehouse(Boolean lockedWarehouse) {
        this.lockedWarehouse = lockedWarehouse;
    }

    public Boolean getPreSale() {
        return preSale;
    }

    public void setPreSale(Boolean preSale) {
        this.preSale = preSale;
    }

    public Boolean getSelfPickup() {
        return selfPickup;
    }

    public void setSelfPickup(Boolean selfPickup) {
        this.selfPickup = selfPickup;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public Boolean getSkuHasInputTaxInvoice() {
        return skuHasInputTaxInvoice;
    }

    public void setSkuHasInputTaxInvoice(Boolean skuHasInputTaxInvoice) {
        this.skuHasInputTaxInvoice = skuHasInputTaxInvoice;
    }

    public Integer getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Integer deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Boolean getOnlinePayment() {
        return onlinePayment;
    }

    public void setOnlinePayment(Boolean onlinePayment) {
        this.onlinePayment = onlinePayment;
    }

    public Integer getReturnableDays() {
        return returnableDays;
    }

    public void setReturnableDays(Integer returnableDays) {
        this.returnableDays = returnableDays;
    }

    public Integer getProcurementMode() {
        return procurementMode;
    }

    public void setProcurementMode(Integer procurementMode) {
        this.procurementMode = procurementMode;
    }

}
