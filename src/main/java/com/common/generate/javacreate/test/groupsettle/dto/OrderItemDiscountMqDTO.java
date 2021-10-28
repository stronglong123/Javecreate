package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单完成消息的优惠明细信息
 * 
 * @author 张远志
 * @since 2021年1月28日13:49:02
 *
 */
@SuppressWarnings("serial")
public class OrderItemDiscountMqDTO implements Serializable {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 优惠金额
	 */
	private BigDecimal amount;
	/**
	 * 优惠来源
	 */
	private Integer sourceType;
	/**
	 * 优惠来源ID
	 */
	private Long sourceId;
	/**
	 * 优惠分类
	 */
	private Integer classify;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

}
