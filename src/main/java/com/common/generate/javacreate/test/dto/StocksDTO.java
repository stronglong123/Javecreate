package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 *  库存DTO
 * @author Hu Liangzhi
 * @Date:2020年8月20日 下午1:53:33
 */
public class StocksDTO implements Serializable {
	private static final long serialVersionUID = -7711090362976793938L;
	
	/** 外部仓库编码 */
	private String outerWarehouseCode;
	
	/** 库存明细 */
	private List<StocksItemDTO> stocks;

	/** 是否需要同步销售库存 true-需要 */
	private Boolean hasSyncSaleStock;

	public String getOuterWarehouseCode() {
		return outerWarehouseCode;
	}

	public void setOuterWarehouseCode(String outerWarehouseCode) {
		this.outerWarehouseCode = outerWarehouseCode;
	}

	public List<StocksItemDTO> getStocks() {
		return stocks;
	}

	public void setStocks(List<StocksItemDTO> stocks) {
		this.stocks = stocks;
	}

	public Boolean getHasSyncSaleStock() {
		return hasSyncSaleStock;
	}

	public void setHasSyncSaleStock(Boolean hasSyncSaleStock) {
		this.hasSyncSaleStock = hasSyncSaleStock;
	}
}