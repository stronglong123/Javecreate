package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单基础明细信息
 *
 * @author Hu Liangzhi
 */
public class OrderItemBaseDTO implements Serializable {
    private static final long serialVersionUID = 5079932771578474388L;

    //(description = "应用接入方code", required = true)
    private String partnerCode;

    //(description = "订单明细id")
    private Long orderItemId;

    //(description = "订单id")
    private Long orderId;

    //(description = "业务明细id")
    private String businessItemId;

    //(description = "产品skuId", required = true)
    private Long productSkuId;

    //(description = "产品名", required = true)
    private String productName;

    //(description = "产品分类")
    private Long productStatisticsClass;

    //(description = "统计类目")
    private String statisticsCategoryName;

    //(description = "条形码")
    private String boxCode;

    //(description = "产品原始数量，即下单数量", required = true)
    private BigDecimal originalCount;

    //(description = "产品实际数量", required = true)
    private BigDecimal count;

    //(description = "原始单价", required = true)
    private BigDecimal originalPrice;

    //(description = "产品实际单价", required = true)
    private BigDecimal price;

    //(description = "价格系数", required = true)
    private BigDecimal priceQuantity;

    //(description = "价格单位")
    private String priceUnit;

    //(description = "出库数量")
    @Deprecated
    private BigDecimal outStockCount;

    //(description = "入库数量")
    @Deprecated
    private BigDecimal inStockCount;

    //(description = "配送数量，即发货数量")
    private BigDecimal deliveryCount;

    //(description = "实际收货数量，即成交数量")
    private BigDecimal takeCount;

    /**
     * 1-赠品
     */
    //(description = "是否赠品")
    private Boolean gift;

    //(description = "成本单价")
    private BigDecimal cost;

    //(description = "成本价格单位")
    private String costPriceUnit;

    //(description = "销售单位")
    private String saleUnit;

    //(description = "销售规格名称")
    private String saleSpec;

    //(description = "销售规格系数", required = true)
    private BigDecimal saleSpecQuantity;

    //(description = "备注")
    private String remark;

    //(description = "创建时间")
    private Date createTime;

    //(description = "更新时间")
    private Date lastUpdateTime;

    //(description = "产品规格ID")
    private Long productSpecificationId;

    //(description = "产品一级货主ID")
    private Long ownerId;

    //(description = "包装规格大单位")
    private String packageName;

    //(description = "包装规格小单位")
    private String unitName;

    //(description = "包装系数", required = true)
    private BigDecimal packageQuantity;

    //(description = "包装规格名称")
    private String productSpec;

    //(description = "仓库skuId")
    private String warehouseProductSkuId;

    //(description = "作业中数量")
    private BigDecimal workingItemCount;

    //(description = "组合id")
    private Long compositeId;

    //(description = "采销模式 自营(0),批次入驻(1),实仓入驻(2),虚仓入驻(3),仓储服务(4),直配入驻(5),虚仓实配(6)")
    private Integer procurementMode;

    //(description = "可退货天数")
    private Integer returnableDays;


    //(description = "经销商id")
    private Long dealerId;

    public BigDecimal getWorkingItemCount() {
        return workingItemCount;
    }

    public void setWorkingItemCount(BigDecimal workingItemCount) {
        this.workingItemCount = workingItemCount;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
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

    public BigDecimal getOriginalCount() {
        return originalCount;
    }

    public void setOriginalCount(BigDecimal originalCount) {
        this.originalCount = originalCount;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceQuantity() {
        return priceQuantity;
    }

    public void setPriceQuantity(BigDecimal priceQuantity) {
        this.priceQuantity = priceQuantity;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    @Deprecated
    public BigDecimal getOutStockCount() {
        return outStockCount;
    }

    public void setOutStockCount(BigDecimal outStockCount) {
        this.outStockCount = outStockCount;
    }

    @Deprecated
    public BigDecimal getInStockCount() {
        return inStockCount;
    }

    public void setInStockCount(BigDecimal inStockCount) {
        this.inStockCount = inStockCount;
    }

    public BigDecimal getDeliveryCount() {
        return deliveryCount;
    }

    public void setDeliveryCount(BigDecimal deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    public BigDecimal getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(BigDecimal takeCount) {
        this.takeCount = takeCount;
    }

    public Boolean getGift() {
        return gift;
    }

    public void setGift(Boolean gift) {
        this.gift = gift;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    public String getSaleSpec() {
        return saleSpec;
    }

    public void setSaleSpec(String saleSpec) {
        this.saleSpec = saleSpec;
    }

    public BigDecimal getSaleSpecQuantity() {
        return saleSpecQuantity;
    }

    public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
        this.saleSpecQuantity = saleSpecQuantity;
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public BigDecimal getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(BigDecimal packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getCostPriceUnit() {
        return costPriceUnit;
    }

    public void setCostPriceUnit(String costPriceUnit) {
        this.costPriceUnit = costPriceUnit;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public String getWarehouseProductSkuId() {
        return warehouseProductSkuId;
    }

    public void setWarehouseProductSkuId(String warehouseProductSkuId) {
        this.warehouseProductSkuId = warehouseProductSkuId;
    }

    public Long getCompositeId() {
        return compositeId;
    }

    public void setCompositeId(Long compositeId) {
        this.compositeId = compositeId;
    }

    public Integer getProcurementMode() {
        return procurementMode;
    }

    public void setProcurementMode(Integer procurementMode) {
        this.procurementMode = procurementMode;
    }

    public Integer getReturnableDays() {
        return returnableDays;
    }

    public void setReturnableDays(Integer returnableDays) {
        this.returnableDays = returnableDays;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }
}
