package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 库存分配参数
 * 
 * @author xialei
 * @since 2021年2月23日16:16:52
 *
 */
public class AllocateInventoryWithSecOwnerParam implements Serializable {

	private static final long serialVersionUID = -961678991587453702L;
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
//	@NotNull(message = "单据类型不能为空")
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
	 * 已分配二级货主销售数量明细
	 */
	private List<SaleInventoryAllocateDTO> orderItemSecOwnerInfos;

	/**
	 * 是否通知其他系统
	 */
	private Boolean needSyncThird;

	/**
	 * 能否修改指定货主
	 */
	private Boolean canChangeSecOwner;

	public Boolean getCanChangeSecOwner() {
		return this.canChangeSecOwner;
	}

	public void setCanChangeSecOwner(final Boolean canChangeSecOwner) {
		this.canChangeSecOwner = canChangeSecOwner;
	}

	public Integer getAllocateType() {
		return allocateType;
	}

	public void setAllocateType(Integer allocateType) {
		this.allocateType = allocateType;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
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

	public List<SaleInventoryAllocateDTO> getOrderItemSecOwnerInfos() {
		return orderItemSecOwnerInfos;
	}

	public void setOrderItemSecOwnerInfos(List<SaleInventoryAllocateDTO> orderItemSecOwnerInfos) {
		this.orderItemSecOwnerInfos = orderItemSecOwnerInfos;
	}

	public Boolean getNeedSyncThird() {
		return needSyncThird;
	}

	public void setNeedSyncThird(Boolean needSyncThird) {
		this.needSyncThird = needSyncThird;
	}
}
