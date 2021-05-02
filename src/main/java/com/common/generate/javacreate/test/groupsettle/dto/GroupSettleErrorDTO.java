package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.util.List;

public class GroupSettleErrorDTO implements Serializable {

	private static final long serialVersionUID = -467286621467755986L;

	private String orderNo;

	private String orderId;

	private Byte orderType;

	private Integer orgId;

	private Integer warehouseId;

	private Integer orderSource;

	private List<GroupSettleErrorSkuDTO>  items;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	public List<GroupSettleErrorSkuDTO> getItems() {
		return items;
	}

	public void setItems(List<GroupSettleErrorSkuDTO> items) {
		this.items = items;
	}
}
