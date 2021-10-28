package com.common.generate.javacreate.test.transferNote;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 出库单详情po
 *
 * @author liushuang 2018/3/13
 */
public class OutStockOrderItemDTO implements Serializable {
    /** 订单项id*/
    private String id;

    /** 城市ID，分库用（第三方订单使用一个新的自定义CityId）*/
    private Integer orgId;

    /** 波次任务编号*/
    private String batchTaskNo;

    /** 波次任务Id*/
    private String batchTaskId;

    /** 关联出库单表id*/
    private String outStockOrderId;

    /** 商品名称*/
    private String productName;

    /** skuId（赠品SKUId可能为null）*/
    private Long skuId;

    /** 品牌*/
    private String productBrand;

    /** 类目*/
    private String categoryName;

    /** 包装规格*/
    private String specName;

    /** 包装规格大小单位转换系数*/
    private BigDecimal specQuantity;

    /** 销售规格名称*/
    private String saleSpec;

    /** 销售规格系数*/
    private BigDecimal saleSpecQuantity;

    /** 大单位名称*/
    private String packageName;

    /** 大单位数量*/
    private BigDecimal packageCount;

    /** 小单位名称*/
    private String unitName;

    /** 小单位数量*/
    private BigDecimal unitCount;

    /** 小单位总数量*/
    private BigDecimal unitTotalCount;

    /** 销售模式 代营(0),自营(1),合作(2),寄售(3),大商转自营(4),大商转配送(5),入驻(6),总部寄售(7),独家包销(8)*/
    private Byte saleMode;

    /** 销售单位*/
    private String sellUnit;

    /** 销售数量*/
    private BigDecimal saleCount;

    /** 产品总金额*/
    private BigDecimal totalAmount;

    /** 应付金额*/
    private BigDecimal payAmount;

    /** 创建时间*/
    private Date createTime;

    /** 货位id*/
    private Long locationid;

    /** 货位名称*/
    private String locationname;

    /**
     * 产品来源，0:酒批，1:微酒（贷款/抵押）
     */
    private Integer source = 0;

    /**
     * 库存渠道,0:酒批，1:大宗产品
     */
    private Integer channel = 0;

    /**
     * 所属人(货主)id
     */
    private Long ownerId;

    /**
     * 二级货主Id
     */
    private Long secOwnerId;

    /**
     * 产品规格ID
     */
    private Long productSpecificationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date productionDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date batchTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String lastUpdateUser;

    /**
     * 修改时间
     */
    private Date lastUpdateTime;

    /**
     * 播种任务id
     */
    private Long sowTaskId;

    /**
     * 播种任务编号
     */
    private String sowTaskNo;

    /**
     * 波次编号
     */
    private String batchNo;

    /**
     * 波次id
     */
    private Long batchId;

    /**
     * 播种单id
     */
    private Long sowOrderId;

    /**
     * 拣货任务项id
     */
    private String batchTaskItemId;

    /**
     * 是否赠品
     */
    private Boolean gift;

    /**
     * 是否赠品
     */
    private Byte isGift;

    /**
     * 已出库小单位总数量
     */
    private BigDecimal outStockUnitTotalCount;

    /**
     * 业务项id
     */
    private String businessItemId;

    /**
     * 业务项编号
     */
    private String businessItemNO;

    /**
     * 出库单项状态(0:待出库,1:出库中,2:已出库,3:已取消)
     */
    private Byte businessState;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 价格单位
     */
    private String priceUnit;

    /**
     * 箱码集合
     * @return
     */
    private List<String> packageCodes;

    /**
     * 条码集合
     * @return
     */
    private List<String> unitCodes;

    /**
     * 图片地址
     */
    private List<String> pictureUrls;

    /**
     * 出库单明细项
     */
    private List<OutStockOrderItemDetailDTO> outStockOrderItemDetailDTOS;

    /**
     * 关联单项id
     */
    private String associatedBusinessItemId;

    /**
     * 播种任务明细id
     */
    private Long sowTaskItemId;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 成本价单位
     */
    private String costPriceUnit;

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getBatchTaskNo() {
        return batchTaskNo;
    }

    public void setBatchTaskNo(String batchTaskNo) {
        this.batchTaskNo = batchTaskNo == null ? null : batchTaskNo.trim();
    }

    public String getBatchTaskId() {
        return batchTaskId;
    }

    public void setBatchTaskId(String batchTaskId) {
        this.batchTaskId = batchTaskId == null ? null : batchTaskId.trim();
    }

    public String getOutStockOrderId() {
        return outStockOrderId;
    }

    public void setOutStockOrderId(String outStockOrderId) {
        this.outStockOrderId = outStockOrderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    public String getSaleSpec() {
        return saleSpec;
    }

    public void setSaleSpec(String saleSpec) {
        this.saleSpec = saleSpec == null ? null : saleSpec.trim();
    }

    public BigDecimal getSaleSpecQuantity() {
        return saleSpecQuantity;
    }

    public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
        this.saleSpecQuantity = saleSpecQuantity;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public BigDecimal getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(BigDecimal packageCount) {
        this.packageCount = packageCount;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public BigDecimal getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(BigDecimal unitCount) {
        this.unitCount = unitCount;
    }

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public Byte getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(Byte saleMode) {
        this.saleMode = saleMode;
    }

    public String getSellUnit() {
        return sellUnit;
    }

    public void setSellUnit(String sellUnit) {
        this.sellUnit = sellUnit == null ? null : sellUnit.trim();
    }

    public BigDecimal getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(BigDecimal saleCount) {
        this.saleCount = saleCount;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getLocationid() {
        return locationid;
    }

    public void setLocationid(Long locationid) {
        this.locationid = locationid;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getBatchTime() {
        return batchTime;
    }

    public void setBatchTime(Date batchTime) {
        this.batchTime = batchTime;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    public Byte getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Byte businessState) {
        this.businessState = businessState;
    }

    public Byte getIsGift() {
        return isGift;
    }

    public void setIsGift(Byte isGift) {
        this.isGift = isGift;
    }

    public BigDecimal getOutStockUnitTotalCount() {
        return outStockUnitTotalCount;
    }

    public void setOutStockUnitTotalCount(BigDecimal outStockUnitTotalCount) {
        this.outStockUnitTotalCount = outStockUnitTotalCount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getSowTaskId() {
        return sowTaskId;
    }

    public void setSowTaskId(Long sowTaskId) {
        this.sowTaskId = sowTaskId;
    }

    public String getSowTaskNo() {
        return sowTaskNo;
    }

    public void setSowTaskNo(String sowTaskNo) {
        this.sowTaskNo = sowTaskNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getSowOrderId() {
        return sowOrderId;
    }

    public void setSowOrderId(Long sowOrderId) {
        this.sowOrderId = sowOrderId;
    }

    public String getBatchTaskItemId() {
        return batchTaskItemId;
    }

    public void setBatchTaskItemId(String batchTaskItemId) {
        this.batchTaskItemId = batchTaskItemId;
    }

    public Boolean getGift() {
        return gift;
    }

    public void setGift(Boolean gift) {
        this.gift = gift;
    }

    public String getBusinessItemNO() {
        return businessItemNO;
    }

    public void setBusinessItemNO(String businessItemNO) {
        this.businessItemNO = businessItemNO;
    }

    public List<String> getPackageCodes() {
        return packageCodes;
    }

    public void setPackageCodes(List<String> packageCodes) {
        this.packageCodes = packageCodes;
    }

    public List<String> getUnitCodes() {
        return unitCodes;
    }

    public void setUnitCodes(List<String> unitCodes) {
        this.unitCodes = unitCodes;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public List<OutStockOrderItemDetailDTO> getOutStockOrderItemDetailDTOS() {
        return outStockOrderItemDetailDTOS;
    }

    public void setOutStockOrderItemDetailDTOS(List<OutStockOrderItemDetailDTO> outStockOrderItemDetailDTOS) {
        this.outStockOrderItemDetailDTOS = outStockOrderItemDetailDTOS;
    }

    public String getAssociatedBusinessItemId() {
        return associatedBusinessItemId;
    }

    public void setAssociatedBusinessItemId(String associatedBusinessItemId) {
        this.associatedBusinessItemId = associatedBusinessItemId;
    }

    public Long getSowTaskItemId() {
        return sowTaskItemId;
    }

    public void setSowTaskItemId(Long sowTaskItemId) {
        this.sowTaskItemId = sowTaskItemId;
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
}