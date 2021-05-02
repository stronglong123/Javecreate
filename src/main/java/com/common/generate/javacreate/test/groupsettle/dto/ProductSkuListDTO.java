package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xialei
 * @date 2021/5/1 7:30
 */
public class ProductSkuListDTO implements Serializable {
    private static final long serialVersionUID = 2081811452919345618L;
    private Long id;
    private Integer cityId;
    private Long productSpecificationId;
    private Long productSkuId;
    private String name;
    private Integer sequence;
    private String remo;
    private Date createTime;
    private Integer createUserId;
    private Date lastUpdateTime;
    private Integer lastUpdateUserId;
    private Long companyId;
    private Integer saleModel;
    private BigDecimal distributionPercent;
    private BigDecimal distributionPercentForAmount;
    private String specificationName;
    private String packageName;
    private String unitName;
    private BigDecimal packageQuantity;
    private Integer source;
    private BigDecimal warehouseCustodyFee;
    private BigDecimal deliveryFee;
    private Integer deliveryPayType;
    private BigDecimal sortingFee;
    private Long productInfoId;
    private String productBrand;
    private String ownerName;
    private Integer productState;
    private Integer unpackage;
    private Integer monthOfShelfLife;
    private Integer shelfLifeUnit;
    private Integer productFeature;
    private BigDecimal maxInventory;
    private BigDecimal minInventory;
    private BigDecimal maxReplenishment;
    private BigDecimal minReplenishment;
    private Byte isComplete;
    private Byte storageType;
    private Byte pick;
    private Byte sow;
    private String inventoryRatio;
    private Byte unique;
    private Byte fleeGoods;
    private Byte productRelevantState;
    private String statisticsCategoryName;
    private String productCode;
    private String bottleCode;
    private String statisticsClassName;
    private String secondStatisticsClassName;
    private BigDecimal costPrice;
    private Long productStatisticsClass;
    private Long secondStatisticsClass;
    private Long secOwnerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getRemo() {
        return remo;
    }

    public void setRemo(String remo) {
        this.remo = remo;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getSaleModel() {
        return saleModel;
    }

    public void setSaleModel(Integer saleModel) {
        this.saleModel = saleModel;
    }

    public BigDecimal getDistributionPercent() {
        return distributionPercent;
    }

    public void setDistributionPercent(BigDecimal distributionPercent) {
        this.distributionPercent = distributionPercent;
    }

    public BigDecimal getDistributionPercentForAmount() {
        return distributionPercentForAmount;
    }

    public void setDistributionPercentForAmount(BigDecimal distributionPercentForAmount) {
        this.distributionPercentForAmount = distributionPercentForAmount;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public BigDecimal getWarehouseCustodyFee() {
        return warehouseCustodyFee;
    }

    public void setWarehouseCustodyFee(BigDecimal warehouseCustodyFee) {
        this.warehouseCustodyFee = warehouseCustodyFee;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getDeliveryPayType() {
        return deliveryPayType;
    }

    public void setDeliveryPayType(Integer deliveryPayType) {
        this.deliveryPayType = deliveryPayType;
    }

    public BigDecimal getSortingFee() {
        return sortingFee;
    }

    public void setSortingFee(BigDecimal sortingFee) {
        this.sortingFee = sortingFee;
    }

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getProductState() {
        return productState;
    }

    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    public Integer getUnpackage() {
        return unpackage;
    }

    public void setUnpackage(Integer unpackage) {
        this.unpackage = unpackage;
    }

    public Integer getMonthOfShelfLife() {
        return monthOfShelfLife;
    }

    public void setMonthOfShelfLife(Integer monthOfShelfLife) {
        this.monthOfShelfLife = monthOfShelfLife;
    }

    public Integer getShelfLifeUnit() {
        return shelfLifeUnit;
    }

    public void setShelfLifeUnit(Integer shelfLifeUnit) {
        this.shelfLifeUnit = shelfLifeUnit;
    }

    public Integer getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(Integer productFeature) {
        this.productFeature = productFeature;
    }

    public BigDecimal getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(BigDecimal maxInventory) {
        this.maxInventory = maxInventory;
    }

    public BigDecimal getMinInventory() {
        return minInventory;
    }

    public void setMinInventory(BigDecimal minInventory) {
        this.minInventory = minInventory;
    }

    public BigDecimal getMaxReplenishment() {
        return maxReplenishment;
    }

    public void setMaxReplenishment(BigDecimal maxReplenishment) {
        this.maxReplenishment = maxReplenishment;
    }

    public BigDecimal getMinReplenishment() {
        return minReplenishment;
    }

    public void setMinReplenishment(BigDecimal minReplenishment) {
        this.minReplenishment = minReplenishment;
    }

    public Byte getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Byte isComplete) {
        this.isComplete = isComplete;
    }

    public Byte getStorageType() {
        return storageType;
    }

    public void setStorageType(Byte storageType) {
        this.storageType = storageType;
    }

    public Byte getPick() {
        return pick;
    }

    public void setPick(Byte pick) {
        this.pick = pick;
    }

    public Byte getSow() {
        return sow;
    }

    public void setSow(Byte sow) {
        this.sow = sow;
    }

    public String getInventoryRatio() {
        return inventoryRatio;
    }

    public void setInventoryRatio(String inventoryRatio) {
        this.inventoryRatio = inventoryRatio;
    }

    public Byte getUnique() {
        return unique;
    }

    public void setUnique(Byte unique) {
        this.unique = unique;
    }

    public Byte getFleeGoods() {
        return fleeGoods;
    }

    public void setFleeGoods(Byte fleeGoods) {
        this.fleeGoods = fleeGoods;
    }

    public Byte getProductRelevantState() {
        return productRelevantState;
    }

    public void setProductRelevantState(Byte productRelevantState) {
        this.productRelevantState = productRelevantState;
    }

    public String getStatisticsCategoryName() {
        return statisticsCategoryName;
    }

    public void setStatisticsCategoryName(String statisticsCategoryName) {
        this.statisticsCategoryName = statisticsCategoryName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBottleCode() {
        return bottleCode;
    }

    public void setBottleCode(String bottleCode) {
        this.bottleCode = bottleCode;
    }

    public String getStatisticsClassName() {
        return statisticsClassName;
    }

    public void setStatisticsClassName(String statisticsClassName) {
        this.statisticsClassName = statisticsClassName;
    }

    public String getSecondStatisticsClassName() {
        return secondStatisticsClassName;
    }

    public void setSecondStatisticsClassName(String secondStatisticsClassName) {
        this.secondStatisticsClassName = secondStatisticsClassName;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Long getProductStatisticsClass() {
        return productStatisticsClass;
    }

    public void setProductStatisticsClass(Long productStatisticsClass) {
        this.productStatisticsClass = productStatisticsClass;
    }

    public Long getSecondStatisticsClass() {
        return secondStatisticsClass;
    }

    public void setSecondStatisticsClass(Long secondStatisticsClass) {
        this.secondStatisticsClass = secondStatisticsClass;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }
}