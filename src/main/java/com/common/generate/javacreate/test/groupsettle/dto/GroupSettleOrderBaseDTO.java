package com.common.generate.javacreate.test.groupsettle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 团购对账单详情
 * 
 * @author liaojiejie
 * @date 2021/03/26
 */
public class GroupSettleOrderBaseDTO implements Serializable {
	private static final long serialVersionUID = -2110219274993500392L;

	/**
	 * 账单ID
	 */
	private Long id;

	/**
	 * 账单编号
	 */
	private String settleNo;

	/**
	 * orgId
	 */
	private Integer orgId;

	/**
	 * 销售仓库
	 */
	private Integer saleWarehouseId;

	/**
	 * 销售仓库名字
	 */
	private String warehouseName;

	/**
	 * 平台编号
	 */
	private Integer channelNo;

	/**
	 * 结算状态：1:未结算 2:已结算
	 */
	private Byte settleState;

	/**
	 * 销售日期
	 */
	@JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
	private Date saleDate;

	/**
	 * 账单日期
	 */
	@JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
	private Date accountDate;

	/**
	 * 结算日期
	 */
	@JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
	private Date settleDate;

	/**
	 * 商品种类
	 */
	private Integer skuCount;

	/**
	 * 团购销售数量，大单位
	 */
	private BigDecimal saleDeliverPackageCount;

	/**
	 * 团购销售数量，小单位
	 */
	private BigDecimal saleDeliverUnitCount;

	/**
	 * 团购应退数量（账单客退），大单位
	 */
	private BigDecimal saleStorePackageCount;

	/**
	 * 团购应退数量（账单客退），小单位
	 */
	private BigDecimal saleStoreUnitCount;

	/**
	 * 账单总金额
	 */
	private BigDecimal settleAmount;

	/**
	 * 仓库出库数量（大单位数量）：仓库实出-多货继续销售；仅结算后存在值
	 */
	private BigDecimal deliverPackageCount;

	/**
	 * 仓库出库数量（小单位数量）：仓库实出-多货继续销售；仅结算后存在值
	 */
	private BigDecimal deliverUnitCount;

	/**
	 * 仓库入库数量（大单位数量）：(团购客退/实际入库)取小后取和；仅结算后存在值
	 */
	private BigDecimal storePackageCount;

	/**
	 * 仓库入库数量（小单位数量）：(团购客退/实际入库)取小后取和；仅结算后存在值
	 */
	private BigDecimal storeUnitCount;

	/**
	 * 未入库数量(应退未退合计（大单位）)
	 */
	private BigDecimal settleDiffPackageCount;

	/**
	 * 未入库数量(应退未退合计（小单位）)
	 */
	private BigDecimal settleDiffUnitCount;

	/** 是否有差异 1-有 0-无 */
	private Byte settleDiff;

	/** 创建时间 */
	private Date createTime;

	/** 创建人 */
	private Integer createUserId;

	/** 最后修改时间 */
	private Date lastUpdateTime;

	/** 最后修改人 */
	private Integer lastUpdateUserId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSettleNo() {
		return settleNo;
	}

	public void setSettleNo(String settleNo) {
		this.settleNo = settleNo;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getSaleWarehouseId() {
		return saleWarehouseId;
	}

	public void setSaleWarehouseId(Integer saleWarehouseId) {
		this.saleWarehouseId = saleWarehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Integer getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(Integer channelNo) {
		this.channelNo = channelNo;
	}

	public Byte getSettleState() {
		return settleState;
	}

	public void setSettleState(Byte settleState) {
		this.settleState = settleState;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	public Date getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(Date settleDate) {
		this.settleDate = settleDate;
	}

	public Integer getSkuCount() {
		return skuCount;
	}

	public void setSkuCount(Integer skuCount) {
		this.skuCount = skuCount;
	}

	public BigDecimal getSaleDeliverPackageCount() {
		return saleDeliverPackageCount;
	}

	public void setSaleDeliverPackageCount(BigDecimal saleDeliverPackageCount) {
		this.saleDeliverPackageCount = saleDeliverPackageCount;
	}

	public BigDecimal getSaleDeliverUnitCount() {
		return saleDeliverUnitCount;
	}

	public void setSaleDeliverUnitCount(BigDecimal saleDeliverUnitCount) {
		this.saleDeliverUnitCount = saleDeliverUnitCount;
	}

	public BigDecimal getSaleStorePackageCount() {
		return saleStorePackageCount;
	}

	public void setSaleStorePackageCount(BigDecimal saleStorePackageCount) {
		this.saleStorePackageCount = saleStorePackageCount;
	}

	public BigDecimal getSaleStoreUnitCount() {
		return saleStoreUnitCount;
	}

	public void setSaleStoreUnitCount(BigDecimal saleStoreUnitCount) {
		this.saleStoreUnitCount = saleStoreUnitCount;
	}

	public BigDecimal getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}

	public BigDecimal getDeliverPackageCount() {
		return deliverPackageCount;
	}

	public void setDeliverPackageCount(BigDecimal deliverPackageCount) {
		this.deliverPackageCount = deliverPackageCount;
	}

	public BigDecimal getDeliverUnitCount() {
		return deliverUnitCount;
	}

	public void setDeliverUnitCount(BigDecimal deliverUnitCount) {
		this.deliverUnitCount = deliverUnitCount;
	}

	public BigDecimal getStorePackageCount() {
		return storePackageCount;
	}

	public void setStorePackageCount(BigDecimal storePackageCount) {
		this.storePackageCount = storePackageCount;
	}

	public BigDecimal getStoreUnitCount() {
		return storeUnitCount;
	}

	public void setStoreUnitCount(BigDecimal storeUnitCount) {
		this.storeUnitCount = storeUnitCount;
	}

	public BigDecimal getSettleDiffPackageCount() {
		return settleDiffPackageCount;
	}

	public void setSettleDiffPackageCount(BigDecimal settleDiffPackageCount) {
		this.settleDiffPackageCount = settleDiffPackageCount;
	}

	public BigDecimal getSettleDiffUnitCount() {
		return settleDiffUnitCount;
	}

	public void setSettleDiffUnitCount(BigDecimal settleDiffUnitCount) {
		this.settleDiffUnitCount = settleDiffUnitCount;
	}

	public Byte getSettleDiff() {
		return settleDiff;
	}

	public void setSettleDiff(Byte settleDiff) {
		this.settleDiff = settleDiff;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(Integer lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
}
