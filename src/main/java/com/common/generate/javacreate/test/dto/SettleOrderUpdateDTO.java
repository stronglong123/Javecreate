package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 团购对账单实体
 * 
 * @author liaojiejie
 * @date 2021/05/13
 */
public class SettleOrderUpdateDTO implements Serializable {


	private static final long serialVersionUID = 8104446544990425998L;
	/**
	 * 对账单ID
	 */
	private Long id;

	/**
	 * 变更账单出库数量:账单销售数量,大单位数量
	 */
	private BigDecimal saleDeliverPackageCount;
	/**
	 * 变更账单出库数量:账单销售数量,小单位数量
	 */
	private BigDecimal saleDeliverUnitCount;
	/**
	 * 变更仓库实际出库数量:仓库出库数量+多货结转出库数量,大单位数量
	 */
	private BigDecimal deliverPackageCount;
	/**
	 * 变更仓库实际出库数量:仓库出库数量+多货结转出库数量,小单位数量
	 */
	private BigDecimal deliverUnitCount;
	/**
	 * 变更账单入库数量：账单客退数量,大单位数量
	 */
	private BigDecimal saleStorePackageCount;
	/**
	 * 变更账单入库数量：账单客退数量,小单位数量
	 */
	private BigDecimal saleStoreUnitCount;
	/**
	 * 变更仓库实际入库数量：应退货数量=仓库实际出库数量-账单出库数量-结转出数量+账单入库数量,大单位数量
	 */
	private BigDecimal storePackageCount;
	/**
	 * 变更仓库实际入库数量：应退货数量=仓库实际出库数量-账单出库数量-结转出数量+账单入库数量,小单位数量
	 */
	private BigDecimal storeUnitCount;
	/**
	 * 变更账单总金额
	 */
	private BigDecimal settleAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}
}
