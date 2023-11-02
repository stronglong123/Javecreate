package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售库存变更新增模型，变更类型+变更来源ID+变更来源项ID 不为空且联合唯一
 *
 * @author 张远志
 * @since 2021年2月23日19:41:47
 *
 */
@SuppressWarnings("serial")
public class SaleInventoryDTO implements Serializable {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 行关键字
	 */
	private String rowKey;
	/**
	 * 城市ID
	 */
	private Integer cityId;
	/**
	 * 仓库ID
	 */
	private Integer warehouseId;
	/**
	 * SKUID
	 */
	private Long productSkuId;

	/**
	 * 中台统一skuId 新增--[SCM2-14389]
	 */
	private Long unifySkuId;
	/**
	 * 商品规格ID
	 */
	private Long productSpecId;
	/**
	 * 一级货主ID
	 */
	private Long ownerId;
	/**
	 * 二级货主ID
	 */
	private Long secOwnerId;
	/**
	 * 销售库存
	 */
	private BigDecimal saleInventoryCount;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
	}

	public Long getUnifySkuId() {
		return unifySkuId;
	}

	public void setUnifySkuId(Long unifySkuId) {
		this.unifySkuId = unifySkuId;
	}

	public Long getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(Long productSpecId) {
		this.productSpecId = productSpecId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getSecOwnerId() {
		return secOwnerId;
	}

	public void setSecOwnerId(Long secOwnerId) {
		this.secOwnerId = secOwnerId;
	}

	public BigDecimal getSaleInventoryCount() {
		return saleInventoryCount;
	}

	public void setSaleInventoryCount(BigDecimal saleInventoryCount) {
		this.saleInventoryCount = saleInventoryCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
