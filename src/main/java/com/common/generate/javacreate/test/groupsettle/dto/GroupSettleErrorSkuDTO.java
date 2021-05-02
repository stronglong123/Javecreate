package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.util.List;

public class GroupSettleErrorSkuDTO implements Serializable {

	private static final long serialVersionUID = 1865145969220730694L;
	private String productName;

	private Long skuId;

	private List<SettleOrderItemSecOwnerDTO> saleSkuSecList;

	private List<SettleOrderItemSecOwnerDTO> settleSkuSecList;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public List<SettleOrderItemSecOwnerDTO> getSaleSkuSecList() {
		return saleSkuSecList;
	}

	public void setSaleSkuSecList(List<SettleOrderItemSecOwnerDTO> saleSkuSecList) {
		this.saleSkuSecList = saleSkuSecList;
	}

	public List<SettleOrderItemSecOwnerDTO> getSettleSkuSecList() {
		return settleSkuSecList;
	}

	public void setSettleSkuSecList(List<SettleOrderItemSecOwnerDTO> settleSkuSecList) {
		this.settleSkuSecList = settleSkuSecList;
	}
}





