package com.common.generate.javacreate.ordercenter.dto;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * 库存分配参数
 * 
 * @author 张远志
 * @since 2021年2月23日16:16:52
 *
 */
public class AllocateInventoryParam implements Serializable {
	private static final long serialVersionUID = 1580826489780128789L;
	/**
	 * 分配类型
	 */
	@Deprecated
	private Integer allocateType;

	/**
	 * 扣库存的订单来源
	 */
	private String orderSource;
	/**
	 * 单据类型
	 */
	private Integer orderType;
	/**
	 * 单据ID
	 */
	private Long orderId;
	/**
	 * 单据编号
	 */
	private String orderNo;
	/**
	 * 城市ID
	 */
	private Integer cityId;
	/**
	 * 仓库ID
	 */
	private Integer warehouseId;
	/**
	 * 是否需要足额分配
	 */
	@Deprecated
	private Boolean isAchieved;
	/**
	 * 待分配明细
	 */
	private List<AllocateInventoryParamItem> items;

	/**
	 * 是否通知其他系统
	 */
	private Boolean needSyncThird;


	public Integer getAllocateType() {
		return allocateType;
	}

	public void setAllocateType(Integer allocateType) {
		this.allocateType = allocateType;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Boolean getIsAchieved() {
		return isAchieved;
	}

	public void setIsAchieved(Boolean isAchieved) {
		this.isAchieved = isAchieved;
	}

	public List<AllocateInventoryParamItem> getItems() {
		return items;
	}

	public void setItems(List<AllocateInventoryParamItem> items) {
		this.items = items;
	}

	public Boolean getNeedSyncThird() {
		return needSyncThird;
	}

	public void setNeedSyncThird(Boolean needSyncThird) {
		this.needSyncThird = needSyncThird;
	}
}
