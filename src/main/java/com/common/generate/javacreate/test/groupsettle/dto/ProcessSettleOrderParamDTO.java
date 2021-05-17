package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;

/**
 * 团购订单结算服务参数
 * 
 * @author liaojiejie
 * @date 2021/03/26
 */
public class ProcessSettleOrderParamDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -793954144257130109L;

	/**
	 * 账单ID
	 */
	private Long id;

	/**
	 * orgId
	 */
	private Integer orgId;

	/**
	 * 销售仓库
	 */
	private Integer saleWarehouseId;
	
	/**
	 * 操作人Id
	 */
	private Integer operatorId;
	
	/**
	 * 操作人姓名
	 */
	private String operatorName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
