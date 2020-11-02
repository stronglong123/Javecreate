package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 库存报表Query
 * @author Huliangzhi
 * @date: 2019年9月27日 下午5:05:00
 */
public class FindStoreQueryDTO implements Serializable {
	private static final long serialVersionUID = -1062911611613878263L;

	private Integer userId;
	/**
	 * 商品名称
	 */
	private String productSkuName;
	/**
	 * 仓库
	 */
	private List<Integer> warehouseIds;
	/**
	 * 货位
	 */
	private Integer goodsPositionId;
	/**
	 * 供应商
	 */
	private Long supplierId;
	/**
	 * 库存分类
	 */
	private Integer storeOwnerType;
	private Integer warehouseId;
	private Integer cityId;

	/**
	 * 产品skuid集合
	 */
	private List<Long> productSkuIds;


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
	private Integer pageNum;

	/**
	 * 每页大小.
	 */
	private Integer pageSize;

	/**
	 * 排序条件.
	 */
	private String orderBy;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProductSkuName() {
		return productSkuName;
	}

	public void setProductSkuName(String productSkuName) {
		this.productSkuName = productSkuName;
	}

	public List<Integer> getWarehouseIds() {
		return warehouseIds;
	}

	public void setWarehouseIds(List<Integer> warehouseIds) {
		this.warehouseIds = warehouseIds;
	}

	public Integer getGoodsPositionId() {
		return goodsPositionId;
	}

	public void setGoodsPositionId(Integer goodsPositionId) {
		this.goodsPositionId = goodsPositionId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getStoreOwnerType() {
		return storeOwnerType;
	}

	public void setStoreOwnerType(Integer storeOwnerType) {
		this.storeOwnerType = storeOwnerType;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public List<Long> getProductSkuIds() {
		return productSkuIds;
	}

	public void setProductSkuIds(List<Long> productSkuIds) {
		this.productSkuIds = productSkuIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getPageNum() {
		return PAGE_NUM;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public static void setPageNum(String pageNum) {
		PAGE_NUM = pageNum;
	}

	public static String getPageSize() {
		return PAGE_SIZE;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public static void setPageSize(String pageSize) {
		PAGE_SIZE = pageSize;
	}

	public static String getOrderBy() {
		return ORDER_BY;
	}

	public static void setOrderBy(String orderBy) {
		ORDER_BY = orderBy;
	}
}
