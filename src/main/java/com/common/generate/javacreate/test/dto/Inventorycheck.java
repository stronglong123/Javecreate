package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author xialei
 * @date  2021-05-11
 */
public class Inventorycheck implements Serializable {
    private static final long serialVersionUID = -2909768579612876841L;
    /**
     * id
     */
    private Long id;

    private Byte orderType;
    /**
     * 城市id
     */
    private Integer orgId;
    /**
     * 仓库id
     */
    private Integer warehouseId;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * skuid
     */
    private Long productSkuId;
    /**
     * 规格id
     */
    private Long productSpecificationId;
    /**
     * 产品名
     */
    private String productName;
    /**
     * 规格名
     */
    private String specName;
    /**
     * 货主id
     */
    private Long ownerId;
    /**
     * 货主名
     */
    private String ownerName;
    /**
     * 二级货主id
     */
    private String secOwnerId;
    /**
     * 二级货主名
     */
    private String secOwnerName;
    /**
     * 差异数量
     */
    private BigDecimal diffTotalCount;
    /**
     * erp数量
     */
    private BigDecimal erpRealCount;
    /**
     * wms数量
     */
    private BigDecimal storeCountMinUnit;
    /**
     * tms已发货数量
     */
    private BigDecimal tmsDeliveryedCount;
    /**
     * wms已发货数量
     */
    private BigDecimal wmsDeliveryedCount;
    /**
     * 规格系数
     */
    private BigDecimal packageQuantity;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp lastUpdateTime;

    private BigDecimal costPrice;

    private Integer needFix;



//    private String trueOwnerId;

    private Integer userId;

    private String companyCode;

    private String trueOwnerId;


    private String errorOwnerId;


    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrueOwnerId() {
        return trueOwnerId;
    }

    public void setTrueOwnerId(String trueOwnerId) {
        this.trueOwnerId = trueOwnerId;
    }

    public String getErrorOwnerId() {
        return errorOwnerId;
    }

    public void setErrorOwnerId(String errorOwnerId) {
        this.errorOwnerId = errorOwnerId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

//    public String getTrueOwnerId() {
//        return trueOwnerId;
//    }
//
//    public void setTrueOwnerId(String trueOwnerId) {
//        this.trueOwnerId = trueOwnerId;
//    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getNeedFix() {
        return needFix;
    }

    public void setNeedFix(Integer needFix) {
        this.needFix = needFix;
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
     * 获取城市id
     */
    public void setOrgId (Integer orgId) {this.orgId = orgId;} 
    /**
     * 设置城市id
     */
    public Integer getOrgId(){ return orgId;} 
    /**
     * 获取仓库id
     */
    public void setWarehouseId (Integer warehouseId) {this.warehouseId = warehouseId;} 
    /**
     * 设置仓库id
     */
    public Integer getWarehouseId(){ return warehouseId;} 
    /**
     * 获取仓库名称
     */
    public void setWarehouseName (String warehouseName) {this.warehouseName = warehouseName;} 
    /**
     * 设置仓库名称
     */
    public String getWarehouseName(){ return warehouseName;} 
    /**
     * 获取skuid
     */
    public void setProductSkuId (Long productSkuId) {this.productSkuId = productSkuId;} 
    /**
     * 设置skuid
     */
    public Long getProductSkuId(){ return productSkuId;} 
    /**
     * 获取规格id
     */
    public void setProductSpecificationId (Long productSpecificationId) {this.productSpecificationId = productSpecificationId;} 
    /**
     * 设置规格id
     */
    public Long getProductSpecificationId(){ return productSpecificationId;} 
    /**
     * 获取产品名
     */
    public void setProductName (String productName) {this.productName = productName;} 
    /**
     * 设置产品名
     */
    public String getProductName(){ return productName;} 
    /**
     * 获取规格名
     */
    public void setSpecName (String specName) {this.specName = specName;} 
    /**
     * 设置规格名
     */
    public String getSpecName(){ return specName;} 
    /**
     * 获取货主id
     */
    public void setOwnerId (Long ownerId) {this.ownerId = ownerId;} 
    /**
     * 设置货主id
     */
    public Long getOwnerId(){ return ownerId;} 
    /**
     * 获取货主名
     */
    public void setOwnerName (String ownerName) {this.ownerName = ownerName;} 
    /**
     * 设置货主名
     */
    public String getOwnerName(){ return ownerName;} 
    /**
     * 获取二级货主id
     */
    public void setSecOwnerId (String secOwnerId) {this.secOwnerId = secOwnerId;}
    /**
     * 设置二级货主id
     */
    public String getSecOwnerId(){ return secOwnerId;}
    /**
     * 获取二级货主名
     */
    public void setSecOwnerName (String secOwnerName) {this.secOwnerName = secOwnerName;} 
    /**
     * 设置二级货主名
     */
    public String getSecOwnerName(){ return secOwnerName;} 
    /**
     * 获取差异数量
     */
    public void setDiffTotalCount (BigDecimal diffTotalCount) {this.diffTotalCount = diffTotalCount;} 
    /**
     * 设置差异数量
     */
    public BigDecimal getDiffTotalCount(){ return diffTotalCount;} 
    /**
     * 获取erp数量
     */
    public void setErpRealCount (BigDecimal erpRealCount) {this.erpRealCount = erpRealCount;} 
    /**
     * 设置erp数量
     */
    public BigDecimal getErpRealCount(){ return erpRealCount;} 
    /**
     * 获取wms数量
     */
    public void setStoreCountMinUnit (BigDecimal storeCountMinUnit) {this.storeCountMinUnit = storeCountMinUnit;} 
    /**
     * 设置wms数量
     */
    public BigDecimal getStoreCountMinUnit(){ return storeCountMinUnit;} 
    /**
     * 获取tms已发货数量
     */
    public void setTmsDeliveryedCount (BigDecimal tmsDeliveryedCount) {this.tmsDeliveryedCount = tmsDeliveryedCount;} 
    /**
     * 设置tms已发货数量
     */
    public BigDecimal getTmsDeliveryedCount(){ return tmsDeliveryedCount;} 
    /**
     * 获取wms已发货数量
     */
    public void setWmsDeliveryedCount (BigDecimal wmsDeliveryedCount) {this.wmsDeliveryedCount = wmsDeliveryedCount;} 
    /**
     * 设置wms已发货数量
     */
    public BigDecimal getWmsDeliveryedCount(){ return wmsDeliveryedCount;} 
    /**
     * 获取规格系数
     */
    public void setPackageQuantity (BigDecimal packageQuantity) {this.packageQuantity = packageQuantity;} 
    /**
     * 设置规格系数
     */
    public BigDecimal getPackageQuantity(){ return packageQuantity;} 
    /**
     * 获取创建时间
     */
    public void setCreateTime (Timestamp createTime) {this.createTime = createTime;} 
    /**
     * 设置创建时间
     */
    public Timestamp getCreateTime(){ return createTime;} 
    /**
     * 获取修改时间
     */
    public void setLastUpdateTime (Timestamp lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;} 
    /**
     * 设置修改时间
     */
    public Timestamp getLastUpdateTime(){ return lastUpdateTime;} 

}