package com.common.generate.javacreate.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xialei
 * @date  2020-05-15
 */
public class AssetsManager implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 资产编号
     */
    private String assetCode;
    /**
     * 资产名称
     */
    private String assetName;
    /**
     * 资产规格
     */
    private String assetSpecification;
    /**
     * 编码类型,ZZ：转运箱，P：打印机
     */
    private String encodingType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态，0、停用，1、启用
     */
    private Byte status;
    /**
     * 是否在库 0、否，1、是
     */
    private Byte inStock;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改时间
     */
    private Timestamp lastUpdateTime;
    /**
     * 修改人
     */
    private String lastUpdateUser;


    /**
     * 获取id
     */
    public void setId (Long id) {this.id = id;} 
    /**
     * 设置id
     */
    public Long getId(){ return id;} 
    /**
     * 获取资产编号
     */
    public void setAssetCode (String assetCode) {this.assetCode = assetCode;} 
    /**
     * 设置资产编号
     */
    public String getAssetCode(){ return assetCode;} 
    /**
     * 获取资产名称
     */
    public void setAssetName (String assetName) {this.assetName = assetName;} 
    /**
     * 设置资产名称
     */
    public String getAssetName(){ return assetName;} 
    /**
     * 获取资产规格
     */
    public void setAssetSpecification (String assetSpecification) {this.assetSpecification = assetSpecification;} 
    /**
     * 设置资产规格
     */
    public String getAssetSpecification(){ return assetSpecification;} 
    /**
     * 获取编码类型,ZZ：转运箱，P：打印机
     */
    public void setEncodingType (String encodingType) {this.encodingType = encodingType;} 
    /**
     * 设置编码类型,ZZ：转运箱，P：打印机
     */
    public String getEncodingType(){ return encodingType;} 
    /**
     * 获取备注
     */
    public void setRemark (String remark) {this.remark = remark;} 
    /**
     * 设置备注
     */
    public String getRemark(){ return remark;} 
    /**
     * 获取状态，0、停用，1、启用
     */
    public void setStatus (Byte status) {this.status = status;} 
    /**
     * 设置状态，0、停用，1、启用
     */
    public Byte getStatus(){ return status;} 
    /**
     * 获取是否在库 0、否，1、是
     */
    public void setInStock (Byte inStock) {this.inStock = inStock;} 
    /**
     * 设置是否在库 0、否，1、是
     */
    public Byte getInStock(){ return inStock;} 
    /**
     * 获取创建时间
     */
    public void setCreateTime (Timestamp createTime) {this.createTime = createTime;} 
    /**
     * 设置创建时间
     */
    public Timestamp getCreateTime(){ return createTime;} 
    /**
     * 获取创建人
     */
    public void setCreateUser (String createUser) {this.createUser = createUser;} 
    /**
     * 设置创建人
     */
    public String getCreateUser(){ return createUser;} 
    /**
     * 获取修改时间
     */
    public void setLastUpdateTime (Timestamp lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;} 
    /**
     * 设置修改时间
     */
    public Timestamp getLastUpdateTime(){ return lastUpdateTime;} 
    /**
     * 获取修改人
     */
    public void setLastUpdateUser (String lastUpdateUser) {this.lastUpdateUser = lastUpdateUser;} 
    /**
     * 设置修改人
     */
    public String getLastUpdateUser(){ return lastUpdateUser;} 

}