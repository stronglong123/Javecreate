package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
    private String createTime;
    /**
     * 修改时间
     */
    private String lastUpdateTime;

    private BigDecimal costPrice;

    private Integer needFix;



//    private String trueOwnerId;

    private Integer userId;

    private String companyCode;

    private String trueOwnerId;


    private String errorOwnerId;


    private String settleNo;


    private Long settleId;


    private Long orderId;

    private Long orderItemId;


    private Long groupOrderSkuId;


    private String date;


    private String completeTime;

    private BigDecimal totalAmount;


    private BigDecimal specQuantity;

    private String packageName;

    private String unitName;

    /**
     * 数据操作类型（1、新增，2、修改）
     */
    private Integer sqlType;


    private String orderNo;


    private String channelCity;


    private Long billId;

    private String dateSource;

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getDateSource() {
        return dateSource;
    }

    public void setDateSource(String dateSource) {
        this.dateSource = dateSource;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getChannelCity() {
        return channelCity;
    }

    public void setChannelCity(String channelCity) {
        this.channelCity = channelCity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getSqlType() {
        return sqlType;
    }

    public void setSqlType(Integer sqlType) {
        this.sqlType = sqlType;
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

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    public Long getSettleId() {
        return settleId;
    }

    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getGroupOrderSkuId() {
        return groupOrderSkuId;
    }

    public void setGroupOrderSkuId(Long groupOrderSkuId) {
        this.groupOrderSkuId = groupOrderSkuId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /***/
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
    public void setCreateTime (String createTime) {this.createTime = createTime;}
    /**
     * 设置创建时间
     */
    public String getCreateTime(){ return createTime;}
    /**
     * 获取修改时间
     */
    public void setLastUpdateTime (String lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;}
    /**
     * 设置修改时间
     */
    public String getLastUpdateTime(){ return lastUpdateTime;}

}