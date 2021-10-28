package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductSkuDTO implements Serializable {
	private static final long serialVersionUID = -6949930745347533509L;
	/**
	 * 城市ID
	 */
	private Integer cityId;
	/**
	 * 产品名称ID
	 */
	private Long productSpecificationId;
	/**
	 * 产品名称ID
	 */
	private Long productSkuId;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 失败报文ID
	 */
	private Long requestError_Id;
	/**
	 * 类型
	 */
	private Byte requestType;
	/**
	 * 公司ID
	 */
	private Long company_Id;
	/**
	 * 销售模式
	 */
	private Byte saleModel;
	/**
	 * 配送系数-件数
	 */
	private BigDecimal distributionPercent;
	/**
	 * 配送系数-工资
	 */
	private BigDecimal distributionPercentForAmount;
	/**
	 * 包装规格名称
	 */
	private String specificationName;
	/**
	 * 包装规格大单位
	 */
	private String packageName;
	/**
	 * 包装规格小单位
	 */
	private String unitName;
	/**
	 * 包装规格大小单位转换系数
	 */
	private BigDecimal packageQuantity;
	/**
	 * 产品来源，0:酒批，1:微酒（贷款/抵押
	 */
	private Byte source;
	/**
	 * 仓库托管费
	 */
	private BigDecimal warehouseCustodyFee;
	/**
	 * 配送费（单件配送费）
	 */
	private BigDecimal deliveryFee;
	/**
	 * 配送费支付方式（0：固定价格，1：百分比）
	 */
	private Integer deliveryPayType;
	/**
	 * 分拣费
	 */
	private BigDecimal sortingFee;
	/**
	 * 产品信息id
	 */
	private Long productInfoId;
	/**
	 * 产品状态
	 */
	private Integer productState;
	/**
	 * 品牌
	 */
	private String productBrand;
	/**
	 * 货主名称
	 */
	private String ownerName;
	/**
	 * 是否拆包,不拆包(0), 拆包(1)
	 */
	private Boolean unpackage;
	/**
	 * 产品的保质期
	 */
	private Integer monthOfShelfLife;
	/**
	 * 保质期单位(1：年 2：月 3：日）
	 */
	private Integer shelfLifeUnit;
	/**
	 * 长/cm
	 */
	private Double length;
	/**
	 * 宽/cm
	 */
	private Double width;
	/**
	 * 高/cm
	 */
	private Double height;
	/**
	 * 重量/KG
	 */
	private Double weight;
	/**
	 * 商品特征:1:大件,2:小件
	 */
	private Byte productFeature;
	/**
	 * 库存上限
	 */
	private BigDecimal maxInventory;
	/**
	 * 库存下限
	 */
	private BigDecimal minInventory;
	/**
	 * 补货上限
	 */
	private BigDecimal maxReplenishment;
	/**
	 * 补货下限
	 */
	private BigDecimal minReplenishment;
	/**
	 * 体积(长*宽*高的字符串)
	 */
	private String volume;
	/**
	 * 是否补全
	 */
	private Byte isComplete;
	/**
	 * 操作人id
	 */
	private Integer optUserId;

	/**
	 * 瓶码
	 */
	private String boxCode;

	/**
	 * 箱码
	 */
	private String packageCode;

	/**
	 * 最新瓶码
	 */
	private String newBoxCode;

	/**
	 * 最新箱码
	 */
	private String newPackageCode;

	/**
	 * 货主名称
	 */
	private String sourceName;

	/**
	 * 是否可以加工 0：不可以 1：可以
	 */
	private Byte process;

	/**
	 * 保存条件 0:常温 1:冷藏 2:冷冻
	 */
	private Byte storageType;

	/**
	 * 是否拣货，默认否  0:否 1:是
	 */
	private Byte pick;

	/**
	 * 是否播种，默认是  0:否 1:是
	 */
	private Byte sow;

	/**
	 * 当前 SKUID 对应库存数量(小数量)
	 */
	private BigDecimal currentInventory;

	/**
	 * 库存占比 json字符串
	 */
	private String inventoryRatio;

	/**
	 * 是否独家产品  0:否 1:是
	 */
	private Byte unique;

	/**
	 * 能否窜货（是否允许货主混放） 0:否 1:是
	 */
	private Byte fleeGoods;

	/**
	 * 产品关联状态 0:未关联 1:已关联
	 */
	private Byte productRelevantState;

	/**
	 * 关联产品SKUID集合
	 */
	private List<Long> refProductSkuIdList;

	/**
	 * 仓库ID
	 */
	private Integer warehouseId;

    /**
     * 产品关联货位ID集合
     */
	private List<Long> locationIdList;

	/**
	 * 产品分级属性:0：未设置，1:A,2:B,3:C
	 */
	private Integer productGrade;

	/**
	 * 关联产品是否存在多个库存信息,关联产品如果存在多个库存信息混盘直接报错，不允许提交
	 * 	false : 无
	 * 	true : 是
	 *
	 */
	private Boolean hasManyStore = false;

	/**
	 * 产品信息状态 上架(1), 下架(0), 废弃(-3), 不能设置（4）
	 */
	private Byte productInfoStatus;

	/**
	 * 产品标签（配送） 0：仓配 1：直配
	 */
	private String deliveryLabelId;

	/**
	 * 本仓库是否可销售 0:否 1:是
	 */
	private Byte enableSell;

	/**
	 * 图片ID
	 */
	private String defaultImageFileId;

    /**
     * 系列名
     */
    private String seriesName;

	/**
	 * 一级类目id
	 */
	private Long statisticsClassId;

	/**
	 * 一级类目名称
	 */
	private String statisticsClass;

	/**
	 * 二级类目id
	 */
	private Long secondStatisticsClassId;

	/**
	 * 二级类目名称
	 */
	private String secondStatisticsClass;

	/**
	 * 二级货主ID
	 */
	private Long secOwnerId;

	/**
	 * 成本价（最小单位）
	 */
	private BigDecimal costPrice;

	/**
	 * 关联外部的产品SKUID
	 */
	private String refProductSkuId;

	/**
	 * 产品关系分组ID
	 */
	private Long productRelationGroupId;

	/**
	 * 销售价
	 */
	private BigDecimal sellingPrice;

	/**
	 * 销售价单位
	 */
	private String sellingPriceUnit;

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getSellingPriceUnit() {
		return sellingPriceUnit;
	}

	public void setSellingPriceUnit(String sellingPriceUnit) {
		this.sellingPriceUnit = sellingPriceUnit;
	}

	public String getNewBoxCode() {
		return newBoxCode;
	}

	public void setNewBoxCode(String newBoxCode) {
		this.newBoxCode = newBoxCode;
	}

	public String getNewPackageCode() {
		return newPackageCode;
	}

	public void setNewPackageCode(String newPackageCode) {
		this.newPackageCode = newPackageCode;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Long getStatisticsClassId() {
		return statisticsClassId;
	}

	public void setStatisticsClassId(Long statisticsClassId) {
		this.statisticsClassId = statisticsClassId;
	}

	public String getStatisticsClass() {
		return statisticsClass;
	}

	public void setStatisticsClass(String statisticsClass) {
		this.statisticsClass = statisticsClass;
	}

	public Long getSecondStatisticsClassId() {
		return secondStatisticsClassId;
	}

	public void setSecondStatisticsClassId(Long secondStatisticsClassId) {
		this.secondStatisticsClassId = secondStatisticsClassId;
	}

	public String getSecondStatisticsClass() {
		return secondStatisticsClass;
	}

	public void setSecondStatisticsClass(String secondStatisticsClass) {
		this.secondStatisticsClass = secondStatisticsClass;
	}

	public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

	public String getDefaultImageFileId() {
		return defaultImageFileId;
	}

	public void setDefaultImageFileId(String defaultImageFileId) {
		this.defaultImageFileId = defaultImageFileId;
	}

	public Byte getEnableSell() {
		return enableSell;
	}

	public void setEnableSell(Byte enableSell) {
		this.enableSell = enableSell;
	}

	public String getDeliveryLabelId() {
		return deliveryLabelId;
	}

	public void setDeliveryLabelId(String deliveryLabelId) {
		this.deliveryLabelId = deliveryLabelId;
	}

	public Byte getProductInfoStatus() {
		return productInfoStatus;
	}

	public void setProductInfoStatus(Byte productInfoStatus) {
		this.productInfoStatus = productInfoStatus;
	}

	public Integer getProductGrade() {
		return productGrade;
	}

	public void setProductGrade(Integer productGrade) {
		this.productGrade = productGrade;
	}

    public List<Long> getLocationIdList() {
        return locationIdList;
    }

    public void setLocationIdList(List<Long> locationIdList) {
        this.locationIdList = locationIdList;
    }

    public Byte getUnique() {
		return unique;
	}

	public void setUnique(Byte unique) {
		this.unique = unique;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
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

	public List<Long> getRefProductSkuIdList() {
		return refProductSkuIdList;
	}

	public void setRefProductSkuIdList(List<Long> refProductSkuIdList) {
		this.refProductSkuIdList = refProductSkuIdList;
	}

	public String getInventoryRatio() {
		return inventoryRatio;
	}

	public void setInventoryRatio(String inventoryRatio) {
		this.inventoryRatio = inventoryRatio;
	}


	public Byte getProcess() {
		return process;
	}

	public void setProcess(Byte process) {
		this.process = process;
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

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
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

	public Byte getSource() {
		return source;
	}

	public void setSource(Byte source) {
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

	public Integer getProductState() {
		return productState;
	}

	public void setProductState(Integer productState) {
		this.productState = productState;
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

	public Boolean getUnpackage() {
		return unpackage;
	}

	public void setUnpackage(Boolean unpackage) {
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

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Byte getProductFeature() {
		return productFeature;
	}

	public void setProductFeature(Byte productFeature) {
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

	public Long getCompany_Id() {
		return company_Id;
	}

	public void setCompany_Id(Long company_Id) {
		this.company_Id = company_Id;
	}

	public Byte getSaleModel() {
		return saleModel;
	}

	public void setSaleModel(Byte saleModel) {
		this.saleModel = saleModel;
	}

	public Long getRequestError_Id() {
		return requestError_Id;
	}

	public void setRequestError_Id(Long requestError_Id) {
		this.requestError_Id = requestError_Id;
	}

	public Byte getRequestType() {
		return requestType;
	}

	public void setRequestType(Byte requestType) {
		this.requestType = requestType;
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

	/**
	 * 获取volume
	 * @return volume volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * 设置volume
	 * @param volume volume
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Byte getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Byte isComplete) {
		this.isComplete = isComplete;
	}

	/**
	 * 获取optUserId
	 * @return optUserId optUserId
	 */
	public Integer getOptUserId() {
		return optUserId;
	}

	/**
	 * 设置optUserId
	 * @param optUserId optUserId
	 */
	public void setOptUserId(Integer optUserId) {
		this.optUserId = optUserId;
	}

	/**
	 * 获取sourceName
	 * @return sourceName sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * 设置sourceName
	 * @param sourceName sourceName
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}


	public BigDecimal getCurrentInventory() {
		return currentInventory;
	}

	public void setCurrentInventory(BigDecimal currentInventory) {
		this.currentInventory = currentInventory;
	}



	public Boolean getHasManyStore() {
		return hasManyStore;
	}

	public void setHasManyStore(Boolean hasManyStore) {
		this.hasManyStore = hasManyStore;
	}

	public Long getSecOwnerId() {
		return secOwnerId;
	}

	public void setSecOwnerId(Long secOwnerId) {
		this.secOwnerId = secOwnerId;
	}

	public String getRefProductSkuId() {
		return refProductSkuId;
	}

	public void setRefProductSkuId(String refProductSkuId) {
		this.refProductSkuId = refProductSkuId;
	}

	public Long getProductRelationGroupId() {
		return productRelationGroupId;
	}

	public void setProductRelationGroupId(Long productRelationGroupId) {
		this.productRelationGroupId = productRelationGroupId;
	}
}
