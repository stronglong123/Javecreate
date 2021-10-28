/*
 * @ClassName InStockOrderItemPODTO
 * @Description
 * @version 1.0
 * @Date 2019-01-05 10:34:47
 */
package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 通用入库单明细DTO
 */
public class InStockOrderCommItemDTO implements Serializable {

	/**
	 * @Fields itemId 订单子项id
	 */
	private String orderItemId;

	/**
	 * 订单子项NO
	 */
	private String orderItemNO;

	/**
	 * 关联单据子项ID
	 */
	private String relatedItemId;

	/**
	 * 单据子项状态
	 */
	private Integer orderItemState;

	/**
	 * @Fields productName 商品名称
	 */
	private String productName;

	/**
	 * 商品条码
	 */
	private String productBarCode;

	/**
	 * @Fields skuId 产品SKUid
	 */
	private Long skuId;
	/**
	 * @Fields productBrand 品牌
	 */
	private String productBrand;

	/**
	 * @Fields categoryName 类目
	 */
	private String categoryName;

	/**
	 * @Fields specName 包装规格
	 */
	private String specName;

	/**
	 * @Fields packageName 大单位名称
	 */
	private String packageName;

	/**
	 * @Fields unitName 小单位名称
	 */
	private String unitName;

	/**
	 * @Fields specQuantity 包装规格大小单位转换系数
	 */
	private BigDecimal specQuantity;

	/**
	 * @Fields unitTotalCount 小单位总数量
	 */
	private BigDecimal unitTotalCount;

	/**
	 * 已入库小单位总数量
	 */
	private BigDecimal inUnitTotalCount;

	/**
	 * 产品总金额
	 */
	private BigDecimal totalAmount;

	/**
	 * 应付金额
	 */
	private BigDecimal payAmount;

	/**
	 * @Fields locationId 货位id
	 */
	private Long locationId;

	/**
	 * @Fields locationName 货位名称
	 */
	private String locationName;

	/**
	 * @Fields ownerId 所属人ID
	 */
	private Long ownerId;

	/**
	 * 入库单货主名称
	 */
	private String ownerName;

	/**
	 * @Fields secOwnerId 二级货主Id
	 */
	private Long secOwnerId;

	/**
	 * @Fields productSpecificationId 产品规格ID
	 */
	private Long productSpecificationId;

	/**
	 * 商品信息ID
	 */
	private Long productInfoId;

	/**
	 * @Fields productionDate 生产日期 (格式:yyyy-MM-dd HH:mm:ss)
	 */
	private String productionDate;

	/**
	 * 商品保质期(天) 0 表示无保质期
	 */
	private Integer dayOfShelfLife;

	/**
	 * 过期日期 (格式:yyyy-MM-dd HH:mm:ss)
	 */
	private String expireTime;

	/**
	 * 业务时间(格式:yyyy-MM-dd HH:mm:ss)
	 */
	private String businessTime;

	/**
	 * 批次时间(格式:yyyy-MM-dd HH:mm:ss)
	 */
	private String batchTime;

	/**
	 * @Fields remark 备注
	 */
	private String remark;
	/**
	 * 是否赠品
	 */
	private Integer isGift;
	/**
	 * 是否删除0-不删除, 1-删除
	 */
	private Integer deleted;

	/**
	 * 扩展字段JSON格式(供应链仅需保存数据)
	 */
	private Map<String, Object> extContent;

	/**
	 * 价格
	 */
	private BigDecimal price;

	/**
	 * 价格单位
	 */
	private String priceUnit;

	/**
	 * 控货策略ID
	 */
	private Long productControlStrategyId;

	/**
	 * 溯源码Code集合
	 */
	private List<String> traceabilityCodeList;

	/**
	 * 生产日期 - 图片ID
	 */
	private String productionDateImgId;

	/**
	 * 生产日期 - 图片url
	 */
	private List<String> productionDateImgUrlList;

	/**
	 * 质检方式,1-全检,2-抽检
	 */
	private Byte qualityType;

	/**
	 * 抽检时检测比例质检比例
	 */
	private BigDecimal qualityRatio;

	/**
	 * 供应链入库单项ID
	 */
	private Long wmsOrderItemId;

	/**
	 * 入库单项详情信息
	 */
	private List<InStockOrderCommItemDetailDTO> itemDetailDTOList;

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderItemNO() {
		return orderItemNO;
	}

	public void setOrderItemNO(String orderItemNO) {
		this.orderItemNO = orderItemNO;
	}

	public String getRelatedItemId() {
		return relatedItemId;
	}

	public void setRelatedItemId(String relatedItemId) {
		this.relatedItemId = relatedItemId;
	}

	public Integer getOrderItemState() {
		return orderItemState;
	}

	public void setOrderItemState(Integer orderItemState) {
		this.orderItemState = orderItemState;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBarCode() {
		return productBarCode;
	}

	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
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

	public BigDecimal getSpecQuantity() {
		return specQuantity;
	}

	public void setSpecQuantity(BigDecimal specQuantity) {
		this.specQuantity = specQuantity;
	}

	public BigDecimal getUnitTotalCount() {
		return unitTotalCount;
	}

	public void setUnitTotalCount(BigDecimal unitTotalCount) {
		this.unitTotalCount = unitTotalCount;
	}

	public BigDecimal getInUnitTotalCount() {
		return inUnitTotalCount;
	}

	public void setInUnitTotalCount(BigDecimal inUnitTotalCount) {
		this.inUnitTotalCount = inUnitTotalCount;
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

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getSecOwnerId() {
		return secOwnerId;
	}

	public void setSecOwnerId(Long secOwnerId) {
		this.secOwnerId = secOwnerId;
	}

	public Long getProductSpecificationId() {
		return productSpecificationId;
	}

	public void setProductSpecificationId(Long productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
	}

	public Long getProductInfoId() {
		return productInfoId;
	}

	public void setProductInfoId(Long productInfoId) {
		this.productInfoId = productInfoId;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public Integer getDayOfShelfLife() {
		return dayOfShelfLife;
	}

	public void setDayOfShelfLife(Integer dayOfShelfLife) {
		this.dayOfShelfLife = dayOfShelfLife;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Map<String, Object> getExtContent() {
		return extContent;
	}

	public void setExtContent(Map<String, Object> extContent) {
		this.extContent = extContent;
	}


	public String getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Long getProductControlStrategyId() {
		return productControlStrategyId;
	}

	public void setProductControlStrategyId(Long productControlStrategyId) {
		this.productControlStrategyId = productControlStrategyId;
	}

	public List<String> getTraceabilityCodeList() {
		return traceabilityCodeList;
	}

	public void setTraceabilityCodeList(List<String> traceabilityCodeList) {
		this.traceabilityCodeList = traceabilityCodeList;
	}

	public String getProductionDateImgId() {
		return productionDateImgId;
	}

	public void setProductionDateImgId(String productionDateImgId) {
		this.productionDateImgId = productionDateImgId;
	}

	public List<String> getProductionDateImgUrlList() {
		return productionDateImgUrlList;
	}

	public void setProductionDateImgUrlList(List<String> productionDateImgUrlList) {
		this.productionDateImgUrlList = productionDateImgUrlList;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public List<InStockOrderCommItemDetailDTO> getItemDetailDTOList() {
		return itemDetailDTOList;
	}

	public void setItemDetailDTOList(List<InStockOrderCommItemDetailDTO> itemDetailDTOList) {
		this.itemDetailDTOList = itemDetailDTOList;
	}

	public Byte getQualityType() {
		return qualityType;
	}

	public void setQualityType(Byte qualityType) {
		this.qualityType = qualityType;
	}

	public BigDecimal getQualityRatio() {
		return qualityRatio;
	}

	public void setQualityRatio(BigDecimal qualityRatio) {
		this.qualityRatio = qualityRatio;
	}

	public Long getWmsOrderItemId() {
		return wmsOrderItemId;
	}

	public void setWmsOrderItemId(Long wmsOrderItemId) {
		this.wmsOrderItemId = wmsOrderItemId;
	}
}