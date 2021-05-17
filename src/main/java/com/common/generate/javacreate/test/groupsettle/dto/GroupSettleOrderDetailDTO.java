package com.common.generate.javacreate.test.groupsettle.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 团购对账单详情
 * 
 * @author liaojiejie
 * @date 2021/03/26
 */
public class GroupSettleOrderDetailDTO extends GroupSettleOrderBaseDTO {
	private static final long serialVersionUID = -2110219274993500392L;

	/**
	 * 差异金额(应退未退合计)
	 */
	private BigDecimal settleDiffAmount;

	/**
	 * 团购对账单Sku汇总数据
	 */
	private List<GroupSettleOrderSkuDTO> groupSettleOrderSkus;

	/**
	 * 团购对账单关联出入库单据
	 */
	private List<GroupSettleOrderBillDTO> groupSettleOrderBills;

	public BigDecimal getSettleDiffAmount() {
		return settleDiffAmount;
	}

	public void setSettleDiffAmount(BigDecimal settleDiffAmount) {
		this.settleDiffAmount = settleDiffAmount;
	}

	public List<GroupSettleOrderSkuDTO> getGroupSettleOrderSkus() {
		return groupSettleOrderSkus;
	}

	public void setGroupSettleOrderSkus(List<GroupSettleOrderSkuDTO> groupSettleOrderSkus) {
		this.groupSettleOrderSkus = groupSettleOrderSkus;
	}

	public List<GroupSettleOrderBillDTO> getGroupSettleOrderBills() {
		return groupSettleOrderBills;
	}

	public void setGroupSettleOrderBills(List<GroupSettleOrderBillDTO> groupSettleOrderBills) {
		this.groupSettleOrderBills = groupSettleOrderBills;
	}
}
