package com.common.generate.javacreate.test.groupsettle.dto;

import java.math.BigDecimal;

/**
 * 
 * 账单查询DTO
 * 
 * @author Hu Liangzhi
 * @Date:2021年4月2日 上午10:47:58
 */
public class GroupSettleOrderQueryDTO extends GroupSettleOrderBaseDTO {

	private static final long serialVersionUID = -1659129677253429556L;

	/** 平台城市 */
	private String channelCity;

	/** 结转出数量：多货结转销售数量=仓库实际出库数量-账单销售数量,大单位数量 */
	private BigDecimal transformPackageCount;

	/** 结转出数量：多货结转销售数量=仓库实际出库数量-账单销售数量,小单位数量 */
	private BigDecimal transformUnitCount;

	/** 核销入库数量=上一个账单周期剩余核销数量+本结算周期内的实际退货数量,大单位数量 */
	private BigDecimal cancelStorePackageCount;

	/** 核销入库数量=上一个账单周期剩余核销数量+本结算周期内的实际退货数量,小单位数量 */
	private BigDecimal cancelStoreUnitCount;

	/** 数据是否删除 0:有效 1:无效 */
	private Byte isdelete;

	public String getChannelCity() {
		return channelCity;
	}

	public void setChannelCity(String channelCity) {
		this.channelCity = channelCity;
	}

	public BigDecimal getTransformPackageCount() {
		return transformPackageCount;
	}

	public void setTransformPackageCount(BigDecimal transformPackageCount) {
		this.transformPackageCount = transformPackageCount;
	}

	public BigDecimal getTransformUnitCount() {
		return transformUnitCount;
	}

	public void setTransformUnitCount(BigDecimal transformUnitCount) {
		this.transformUnitCount = transformUnitCount;
	}

	public BigDecimal getCancelStorePackageCount() {
		return cancelStorePackageCount;
	}

	public void setCancelStorePackageCount(BigDecimal cancelStorePackageCount) {
		this.cancelStorePackageCount = cancelStorePackageCount;
	}

	public BigDecimal getCancelStoreUnitCount() {
		return cancelStoreUnitCount;
	}

	public void setCancelStoreUnitCount(BigDecimal cancelStoreUnitCount) {
		this.cancelStoreUnitCount = cancelStoreUnitCount;
	}

	public Byte getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Byte isdelete) {
		this.isdelete = isdelete;
	}
}
