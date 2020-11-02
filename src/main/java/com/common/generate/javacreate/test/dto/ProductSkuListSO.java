package com.common.generate.javacreate.test.dto;


import com.common.generate.javacreate.model.base.search.PageCondition;

import java.io.Serializable;
import java.util.List;

/**
 * 产品sku列表查询
 *
 * @author yupan@yijiupi.cn
 * @date 2019/4/25 14:08
 */
public class ProductSkuListSO implements Serializable {

    private static final long serialVersionUID = 5972322725034679043L;

    /**
     * 城市ID
     */
    private Integer cityId;

    /**
     * 货主ID
     */
    private Long ownerId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 一级统计类目id
     */
    private Long productStatisticsClass;

    /**
     * 二级统计类目id
     */
    private Long secondStatisticsClass;

    /**
     * 产品编码
     */
    private String productCode;

    /**
     * 瓶码（最小单位条码）
     */
    private String bottleCode;

    /**
     * 产品条码/包装条码
     */
    private String barCodeOrBoxCode;

    /**
     * 产品信息ID集合
     */
    private List<Long> productInfoIdList;

    /**
     * 产品规格ID集合
     */
    private List<Long> productSpecIdList;

    /**
     * 包装条码集合
     */
    private List<String> boxCodeList;


    /**
     * 品牌
     */
    private String productBrand;

    /**
     * 城市id集合
     */
    private List<Integer> cityIdList;

    /**
     * 名称集合
     */
    private List<String> productNameList;

    /**
     * 产品信息ID集合
     */
    private List<Long> productSkuIdList;


    /**
     * 产品状态 下架(0), 作废(1), 上架(2)
     */
    private Integer productState;

    private Long productInfoId;

    /**
     * 是否可以加工（0：不可以  1：可以）
     */
    private Byte process;

    /**
     * 页码.
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页大小.
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序条件.
     */
    public static String ORDER_BY = "orderBy";

    /**
     * 页码.
     */
    private Integer pageNum = 1;

    /**
     * 每页大小.
     */
    private Integer pageSize = 20;

    /**
     * 排序条件.
     */
    private String orderBy;

    /**
     * 获取 页码.
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * 设置 页码.
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取 每页大小.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 每页大小.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 排序条件.
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置 排序条件.
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }


    public Byte getProcess() {
        return process;
    }

    public void setProcess(Byte process) {
        this.process = process;
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

    public List<String> getProductNameList() {
        return productNameList;
    }

    public void setProductNameList(List<String> productNameList) {
        this.productNameList = productNameList;
    }

    public List<Integer> getCityIdList() {
        return cityIdList;
    }

    public void setCityIdList(List<Integer> cityIdList) {
        this.cityIdList = cityIdList;
    }

    public List<String> getBoxCodeList() {
        return boxCodeList;
    }

    public void setBoxCodeList(List<String> boxCodeList) {
        this.boxCodeList = boxCodeList;
    }

    public String getBarCodeOrBoxCode() {
        return barCodeOrBoxCode;
    }

    public void setBarCodeOrBoxCode(String barCodeOrBoxCode) {
        this.barCodeOrBoxCode = barCodeOrBoxCode;
    }

    public List<Long> getProductInfoIdList() {
        return productInfoIdList;
    }

    public void setProductInfoIdList(List<Long> productInfoIdList) {
        this.productInfoIdList = productInfoIdList;
    }

    public List<Long> getProductSpecIdList() {
        return productSpecIdList;
    }

    public void setProductSpecIdList(List<Long> productSpecIdList) {
        this.productSpecIdList = productSpecIdList;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public Long getSecondStatisticsClass() {
        return secondStatisticsClass;
    }

    public void setSecondStatisticsClass(Long secondStatisticsClass) {
        this.secondStatisticsClass = secondStatisticsClass;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public List<Long> getProductSkuIdList() {
        return productSkuIdList;
    }

    public void setProductSkuIdList(List<Long> productSkuIdList) {
        this.productSkuIdList = productSkuIdList;
    }
}
