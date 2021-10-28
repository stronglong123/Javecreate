package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 *  库存DTO
 * @author Hu Liangzhi
 * @Date:2020年8月20日 下午1:53:33
 */
public class StocksItemDTO implements Serializable {
	private static final long serialVersionUID = -7711090362976793938L;
	
	/** 外部系统sku编码 */
	private String outerSkuId;
	
	/** WMS sku系统编码 */
	private Long productSkuId;

	/** 同步仓库库存 */
	private BigDecimal stockNum;

	public String getOuterSkuId() {
		return outerSkuId;
	}

	public void setOuterSkuId(String outerSkuId) {
		this.outerSkuId = outerSkuId;
	}

	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
	}

	public BigDecimal getStockNum() {
		return stockNum;
	}

	public void setStockNum(BigDecimal stockNum) {
		this.stockNum = stockNum;
	}
}