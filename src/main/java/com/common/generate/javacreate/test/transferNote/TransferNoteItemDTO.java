package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xialei
 * @date  2020-06-04
 */
public class TransferNoteItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 调拨单id
     */
    private Long transferNoteId;
    /**
     * 发货城市id
     */
    private Integer orgId;
    /**
     * 发货skuId
     */
    private Long skuId;
    /**
     * 外部skuid
     */
    private String outerSkuId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 品牌
     */
    private String productBrand;
    /**
     * 类目
     */
    private String categoryName;
    /**
     * 规格id
     */
    private Long specificationId;
    /**
     * 包装规格大小单位转换系数
     */
    private BigDecimal specQuantity;
    /**
     * 大单位名称
     */
    private String packageName;
    /**
     * 小单位名称
     */
    private String unitName;
    /**
     * 规格
     */
    private String productSpec;
    /**
     * 货主id
     */
    private Long productOwnerId;
    /**
     * 二级货主id
     */
    private Long secOwnerId;
    /**
     * 收货小单位总数量
     */
    private BigDecimal inUnitTotalCount;
    /**
     * 发货小单位总数量
     */
    private BigDecimal outUnitTotalCount;
    /**
     * 采购价格
     */
    private BigDecimal price;
    /**
     * 采购价格单位
     */
    private String priceUnit;
    /**
     * 采购金额
     */
    private BigDecimal amount;
    /**
     * 毛重(kg)
     */
    private BigDecimal weight;
    /**
     * 体积(m3)
     */
    private BigDecimal volume;
    /**
     * 总毛重(kg)
     */
    private BigDecimal totalWeight;
    /**
     * 总体积(m3)
     */
    private BigDecimal totalVolume;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date lastUpdateTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改人
     */
    private String lastUpdateUser;

    /**
     * 调拨数量
     */
    private BigDecimal transferUnitTotalCount;

    /**
     * 关联单据项id
     */
    private String businessItemId;

    public BigDecimal getTransferUnitTotalCount() {
        return transferUnitTotalCount;
    }

    public void setTransferUnitTotalCount(BigDecimal transferUnitTotalCount) {
        this.transferUnitTotalCount = transferUnitTotalCount;
    }

    /**
     * 获取id
     */
    public void setId (Long id) {this.id = id;} 
    /**
     * 设置id
     */
    public Long getId(){ return id;} 
    /**
     * 获取调拨单id
     */
    public void setTransferNoteId (Long transferNoteId) {this.transferNoteId = transferNoteId;} 
    /**
     * 设置调拨单id
     */
    public Long getTransferNoteId(){ return transferNoteId;} 
    /**
     * 获取发货城市id
     */
    public void setOrgId (Integer orgId) {this.orgId = orgId;} 
    /**
     * 设置发货城市id
     */
    public Integer getOrgId(){ return orgId;} 
    /**
     * 获取发货skuId
     */
    public void setSkuId (Long skuId) {this.skuId = skuId;} 
    /**
     * 设置发货skuId
     */
    public Long getSkuId(){ return skuId;} 
    /**
     * 获取外部skuid
     */
    public void setOuterSkuId (String outerSkuId) {this.outerSkuId = outerSkuId;} 
    /**
     * 设置外部skuid
     */
    public String getOuterSkuId(){ return outerSkuId;} 
    /**
     * 获取产品名称
     */
    public void setProductName (String productName) {this.productName = productName;} 
    /**
     * 设置产品名称
     */
    public String getProductName(){ return productName;} 
    /**
     * 获取品牌
     */
    public void setProductBrand (String productBrand) {this.productBrand = productBrand;} 
    /**
     * 设置品牌
     */
    public String getProductBrand(){ return productBrand;} 
    /**
     * 获取类目
     */
    public void setCategoryName (String categoryName) {this.categoryName = categoryName;} 
    /**
     * 设置类目
     */
    public String getCategoryName(){ return categoryName;} 
    /**
     * 获取规格id
     */
    public void setSpecificationId (Long specificationId) {this.specificationId = specificationId;} 
    /**
     * 设置规格id
     */
    public Long getSpecificationId(){ return specificationId;} 
    /**
     * 获取包装规格大小单位转换系数
     */
    public void setSpecQuantity (BigDecimal specQuantity) {this.specQuantity = specQuantity;} 
    /**
     * 设置包装规格大小单位转换系数
     */
    public BigDecimal getSpecQuantity(){ return specQuantity;} 
    /**
     * 获取大单位名称
     */
    public void setPackageName (String packageName) {this.packageName = packageName;} 
    /**
     * 设置大单位名称
     */
    public String getPackageName(){ return packageName;} 
    /**
     * 获取小单位名称
     */
    public void setUnitName (String unitName) {this.unitName = unitName;} 
    /**
     * 设置小单位名称
     */
    public String getUnitName(){ return unitName;} 
    /**
     * 获取规格
     */
    public void setProductSpec (String productSpec) {this.productSpec = productSpec;} 
    /**
     * 设置规格
     */
    public String getProductSpec(){ return productSpec;} 
    /**
     * 获取货主id
     */
    public void setProductOwnerId (Long productOwnerId) {this.productOwnerId = productOwnerId;} 
    /**
     * 设置货主id
     */
    public Long getProductOwnerId(){ return productOwnerId;} 
    /**
     * 获取二级货主id
     */
    public void setSecOwnerId (Long secOwnerId) {this.secOwnerId = secOwnerId;} 
    /**
     * 设置二级货主id
     */
    public Long getSecOwnerId(){ return secOwnerId;} 
    /**
     * 获取收货小单位总数量
     */
    public void setInUnitTotalCount (BigDecimal inUnitTotalCount) {this.inUnitTotalCount = inUnitTotalCount;} 
    /**
     * 设置收货小单位总数量
     */
    public BigDecimal getInUnitTotalCount(){ return inUnitTotalCount;} 
    /**
     * 获取发货小单位总数量
     */
    public void setOutUnitTotalCount (BigDecimal outUnitTotalCount) {this.outUnitTotalCount = outUnitTotalCount;} 
    /**
     * 设置发货小单位总数量
     */
    public BigDecimal getOutUnitTotalCount(){ return outUnitTotalCount;} 
    /**
     * 获取采购价格
     */
    public void setPrice (BigDecimal price) {this.price = price;} 
    /**
     * 设置采购价格
     */
    public BigDecimal getPrice(){ return price;} 
    /**
     * 获取采购价格单位
     */
    public void setPriceUnit (String priceUnit) {this.priceUnit = priceUnit;} 
    /**
     * 设置采购价格单位
     */
    public String getPriceUnit(){ return priceUnit;} 
    /**
     * 获取采购金额
     */
    public void setAmount (BigDecimal amount) {this.amount = amount;} 
    /**
     * 设置采购金额
     */
    public BigDecimal getAmount(){ return amount;} 
    /**
     * 获取毛重(kg)
     */
    public void setWeight (BigDecimal weight) {this.weight = weight;} 
    /**
     * 设置毛重(kg)
     */
    public BigDecimal getWeight(){ return weight;} 
    /**
     * 获取体积(m3)
     */
    public void setVolume (BigDecimal volume) {this.volume = volume;} 
    /**
     * 设置体积(m3)
     */
    public BigDecimal getVolume(){ return volume;} 
    /**
     * 获取总毛重(kg)
     */
    public void setTotalWeight (BigDecimal totalWeight) {this.totalWeight = totalWeight;} 
    /**
     * 设置总毛重(kg)
     */
    public BigDecimal getTotalWeight(){ return totalWeight;} 
    /**
     * 获取总体积(m3)
     */
    public void setTotalVolume (BigDecimal totalVolume) {this.totalVolume = totalVolume;} 
    /**
     * 设置总体积(m3)
     */
    public BigDecimal getTotalVolume(){ return totalVolume;} 

    /**
     * 获取备注
     */
    public void setRemark (String remark) {this.remark = remark;} 
    /**
     * 设置备注
     */
    public String getRemark(){ return remark;} 
    /**
     * 获取创建时间
     */
    public void setCreateTime (Date createTime) {this.createTime = createTime;}
    /**
     * 设置创建时间
     */
    public Date getCreateTime(){ return createTime;}
    /**
     * 获取修改时间
     */
    public void setLastUpdateTime (Date lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;}
    /**
     * 设置修改时间
     */
    public Date getLastUpdateTime(){ return lastUpdateTime;}
    /**
     * 获取创建人
     */
    public void setCreateUser (String createUser) {this.createUser = createUser;} 
    /**
     * 设置创建人
     */
    public String getCreateUser(){ return createUser;} 
    /**
     * 获取修改人
     */
    public void setLastUpdateUser (String lastUpdateUser) {this.lastUpdateUser = lastUpdateUser;} 
    /**
     * 设置修改人
     */
    public String getLastUpdateUser(){ return lastUpdateUser;}

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    @Override
    public String toString() {
        return "TransferNoteItemDTO{" +
                "id=" + id +
                ", transferNoteId=" + transferNoteId +
                ", orgId=" + orgId +
                ", skuId=" + skuId +
                ", outerSkuId='" + outerSkuId + '\'' +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", specificationId=" + specificationId +
                ", specQuantity=" + specQuantity +
                ", packageName='" + packageName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", productSpec='" + productSpec + '\'' +
                ", productOwnerId=" + productOwnerId +
                ", secOwnerId=" + secOwnerId +
                ", inUnitTotalCount=" + inUnitTotalCount +
                ", outUnitTotalCount=" + outUnitTotalCount +
                ", price=" + price +
                ", priceUnit='" + priceUnit + '\'' +
                ", amount=" + amount +
                ", weight=" + weight +
                ", volume=" + volume +
                ", totalWeight=" + totalWeight +
                ", totalVolume=" + totalVolume +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", createUser='" + createUser + '\'' +
                ", lastUpdateUser='" + lastUpdateUser + '\'' +
                ", transferUnitTotalCount=" + transferUnitTotalCount +
                ", businessItemId=" + businessItemId +
                '}';
    }
}