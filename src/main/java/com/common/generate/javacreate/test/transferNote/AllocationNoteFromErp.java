package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author huliangzhi
 * @date 2020-06-04
 */
public class AllocationNoteFromErp implements Serializable{

	private static final long serialVersionUID = 2691461714798297154L;

	/** 发货城市ID */
	private Integer orgId;

    /** 发货仓库id */
	private Integer warehouseId;

    /** 调拨单号 */
	private String businessNo;

    /** 调拨单id */
	private String businessId;

    /** 创建日期 */
	private Long orderCreateTime;

    /** 应收金额 */
	private BigDecimal orderAmount;

    /** 实收金额  */
	private BigDecimal payableAmount;

    /** 收货城市id */
	private String toOrgId;

    /** 收货仓库id */
	private Integer toWarehouseId;

    /** 城际调拨((byte) 110), 统采调拨((byte) 111), 大区联采((byte) 112) */
	private int refType;
    
	private String refTypeName;

    /** 收货人 */
	private String contact;

    /** 收货人电话 */
	private String contactPhone;

    /** 收货人地址 */
    private String detailAddress;

	/** 待发货=1，收获中-未出未入=21，收获中-已出未入=22*/
	public Integer state;
	/**
	 * 调拨单历史出库单编号
	 */
	private String oldOutStockOrderNo;


	public String getOldOutStockOrderNo() {
		return oldOutStockOrderNo;
	}

	public void setOldOutStockOrderNo(String oldOutStockOrderNo) {
		this.oldOutStockOrderNo = oldOutStockOrderNo;
	}


	private List<AllocationNoteItemFromErp> items;

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

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Long getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Long orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getToOrgId() {
		return toOrgId;
	}

	public void setToOrgId(String toOrgId) {
		this.toOrgId = toOrgId;
	}

	public Integer getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(Integer toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public int getRefType() {
		return refType;
	}

	public void setRefType(int refType) {
		this.refType = refType;
	}

	public String getRefTypeName() {
		return refTypeName;
	}

	public void setRefTypeName(String refTypeName) {
		this.refTypeName = refTypeName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<AllocationNoteItemFromErp> getItems() {
		return items;
	}

	public void setItems(List<AllocationNoteItemFromErp> items) {
		this.items = items;
	}
}
