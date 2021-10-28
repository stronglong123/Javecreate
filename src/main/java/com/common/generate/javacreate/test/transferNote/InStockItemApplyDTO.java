/*
 * @ClassName InStockItemApplyPO
 * @Description
 * @version 1.0
 * @Date 2019-01-05 11:15:07
 */
package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购申请单详情
 */
public class InStockItemApplyDTO implements Serializable {

    private static final long serialVersionUID = -9099179750984237495L;

    /**
     * @Fields id 编号
     */
    private Long id;
    /**
     * @Fields inStockApplyId 父编号
     */
    private Long inStockApplyId;
    /**
     * @Fields productType 商品类型
     */
    private Integer productType;
    /**
     * @Fields productTypeName 商品类型名称
     */
    private String productTypeName;
    /**
     * @Fields productSpecificationId 产品规格ID
     */
    private Long productSpecificationId;
    /**
     * @Fields inStockUnitCount 已入库小单位数量
     */
    private BigDecimal inStockUnitCount = BigDecimal.ZERO;
    /**
     * @Fields inStockPackageCount 已入库大单位数量
     */
    private BigDecimal inStockPackageCount = BigDecimal.ZERO;

    /**
     * 已入库小单位总数量
     */
    private BigDecimal inStockUnitTotalCount;

    /**
     * @Fields notInStockUnitCount 待入库小单位数量
     */
    private BigDecimal notInStockUnitCount;
    /**
     * @Fields notInStockPackageCount 待入库大单位数量
     */
    private BigDecimal notInStockPackageCount;

    /**
     * @Fields notInStockUnitCount 待入库小单位总数量
     */
    private BigDecimal notInStockUnitTotalCount;
    /**
     * @Fields applyUnitCount 申请小单位数量
     */
    private BigDecimal applyUnitCount;
    /**
     * @Fields applyPackageCount 申请大单位数量
     */
    private BigDecimal applyPackageCount;

    /**
     * 申请小单位总数量
     */
    private BigDecimal applyUnitTotalCount;

    /**
     * @Fields specQuantity 规格转换系数
     */
    private BigDecimal specQuantity;
    /**
     * @Fields productInfoId 商品信息的ID
     */
    private Long productInfoId;
    /**
     * @Fields dayOfShelfLife 商品保质期(天)
     */
    private Integer dayOfShelfLife;
    /**
     * @Fields productSkuId 商品SKUID
     */
    private Long productSkuId;
    /**
     * @Fields productName 商品名称
     */
    private String productName;
    /**
     * @Fields category 类目
     */
    private String category;
    /**
     * @Fields brandName 品牌名
     */
    private String brandName;
    /**
     * @Fields businessItemId 源申请项id
     */
    private String businessItemId;

    /**
     *  源申请单id
     */
    private String businessId;

    /**
     * @Fields packageName 大单位名称
     */
    private String packageName;
    /**
     * @Fields unitName 小单位名称
     */
    private String unitName;
    /**
     * @Fields isGift 是否赠品
     */
    private Integer isGift;
    /**
     * @Fields createUser 创建用户
     */
    private String createUser;
    /**
     * @Fields createTime 创建时间
     */
    private Date createTime;
    /**
     * @Fields lastUpdateUser 更新用户
     */
    private String lastUpdateUser;
    /**
     * @Fields lastUpdateTime 更新时间
     */
    private Date lastUpdateTime;

    private Byte source;

    /**
     * @Fields channel 库存渠道,0:酒批，1:大宗产品
     */
    private Byte channel;

    /**
     * @Fields ownerId 所属人ID
     */
    private String ownerId;

    /**
     * 所属人ID名称
     */
    private String ownerName;

    /**
     * @Fields secOwnerId 二级货主Id
     */
    private Long secOwnerId;

    /**
     * 包装规格
     */
    private String specificationText;

    // 通用申请单添加字段 - Start

    /**
     *  申请城市ID（分库用，入库城市ID）
     */
    private Integer cityId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 价格单位
     */
    private String priceUnit;

    /**
     * 产品总金额
     */
    private BigDecimal totalAmount;

    /**
     * 实付产品价格
     */
    private BigDecimal payPrice;

    /**
     * 实付产品总金额
     */
    private BigDecimal payAmount;

    /**
     * 是否删除 0:否，1：是
     */
    private Integer isDelete;

    /**
     * 备注
     */
    private String remark;

    /**
     * 扩展字段(供应链仅需保存数据)
     */
    private String extContent;


    // 通用申请单添加字段 - End

    /**
     * 获取  编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  父编号
     */
    public Long getInStockApplyId() {
        return inStockApplyId;
    }

    /**
     * 设置  父编号
     */
    public void setInStockApplyId(Long inStockApplyId) {
        this.inStockApplyId = inStockApplyId;
    }

    /**
     * 获取  商品类型
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     * 设置  商品类型
     */
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    /**
     * 获取  商品类型名称
     */
    public String getProductTypeName() {
        return productTypeName;
    }

    /**
     * 设置  商品类型名称
     */
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName == null ? null : productTypeName.trim();
    }

    /**
     * 获取  产品规格ID
     */
    public Long getProductSpecificationId() {
        return productSpecificationId;
    }

    /**
     * 设置  产品规格ID
     */
    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    /**
     * 获取  已入库小单位数量
     */
    public BigDecimal getInStockUnitCount() {
        return inStockUnitCount;
    }

    /**
     * 设置  已入库小单位数量
     */
    public void setInStockUnitCount(BigDecimal inStockUnitCount) {
        this.inStockUnitCount = inStockUnitCount;
    }

    /**
     * 获取  已入库大单位数量
     */
    public BigDecimal getInStockPackageCount() {
        return inStockPackageCount;
    }

    /**
     * 设置  已入库大单位数量
     */
    public void setInStockPackageCount(BigDecimal inStockPackageCount) {
        this.inStockPackageCount = inStockPackageCount;
    }

    /**
     * 获取  待入库小单位数量
     */
    public BigDecimal getNotInStockUnitCount() {
        return notInStockUnitCount;
    }

    /**
     * 设置  待入库小单位数量
     */
    public void setNotInStockUnitCount(BigDecimal notInStockUnitCount) {
        this.notInStockUnitCount = notInStockUnitCount;
    }

    /**
     * 获取  待入库大单位数量
     */
    public BigDecimal getNotInStockPackageCount() {
        return notInStockPackageCount;
    }

    /**
     * 设置  待入库大单位数量
     */
    public void setNotInStockPackageCount(BigDecimal notInStockPackageCount) {
        this.notInStockPackageCount = notInStockPackageCount;
    }

    /**
     * 获取  申请小单位数量
     */
    public BigDecimal getApplyUnitCount() {
        return applyUnitCount;
    }

    /**
     * 设置  申请小单位数量
     */
    public void setApplyUnitCount(BigDecimal applyUnitCount) {
        this.applyUnitCount = applyUnitCount;
    }

    /**
     * 获取  申请大单位数量
     */
    public BigDecimal getApplyPackageCount() {
        return applyPackageCount;
    }

    /**
     * 设置  申请大单位数量
     */
    public void setApplyPackageCount(BigDecimal applyPackageCount) {
        this.applyPackageCount = applyPackageCount;
    }

    /**
     * 获取  规格转换系数
     */
    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    /**
     * 设置  规格转换系数
     */
    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    /**
     * 获取  商品信息的ID
     */
    public Long getProductInfoId() {
        return productInfoId;
    }

    /**
     * 设置  商品信息的ID
     */
    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    /**
     * 获取  商品保质期(天)
     */
    public Integer getDayOfShelfLife() {
        return dayOfShelfLife;
    }

    /**
     * 设置  商品保质期(天)
     */
    public void setDayOfShelfLife(Integer dayOfShelfLife) {
        this.dayOfShelfLife = dayOfShelfLife;
    }

    /**
     * 获取  商品SKUID
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    /**
     * 设置  商品SKUID
     */
    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * 获取  商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置  商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取  类目
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置  类目
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 获取  品牌名
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置  品牌名
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 获取  ERP采购申请项id
     */
    public String getBusinessItemId() {
        return businessItemId;
    }

    /**
     * 设置  ERP采购申请项id
     */
    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId == null ? null : businessItemId.trim();
    }

    /**
     * 获取  大单位名称
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 设置  大单位名称
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    /**
     * 获取  小单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置  小单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * 获取  是否赠品
     */
    public Integer getIsGift() {
        return isGift;
    }

    /**
     * 设置  是否赠品
     */
    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    /**
     * 获取  创建用户
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置  创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取  创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  更新用户
     */
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    /**
     * 设置  更新用户
     */
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 获取  更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置  更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Byte getChannel() {
        return channel;
    }

    public void setChannel(Byte channel) {
        this.channel = channel;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

	public String getSpecificationText() {
		return specificationText;
	}

	public void setSpecificationText(String specificationText) {
		this.specificationText = specificationText;
	}

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtContent() {
        return extContent;
    }

    public void setExtContent(String extContent) {
        this.extContent = extContent;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public BigDecimal getInStockUnitTotalCount() {
        return inStockUnitTotalCount;
    }

    public void setInStockUnitTotalCount(BigDecimal inStockUnitTotalCount) {
        this.inStockUnitTotalCount = inStockUnitTotalCount;
    }

    public BigDecimal getApplyUnitTotalCount() {
        return applyUnitTotalCount;
    }

    public void setApplyUnitTotalCount(BigDecimal applyUnitTotalCount) {
        this.applyUnitTotalCount = applyUnitTotalCount;
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

    public BigDecimal getNotInStockUnitTotalCount() {
        return notInStockUnitTotalCount;
    }

    public void setNotInStockUnitTotalCount(BigDecimal notInStockUnitTotalCount) {
        this.notInStockUnitTotalCount = notInStockUnitTotalCount;
    }
}
