package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单拣货信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单拣货信息模型")
public class OrderPickDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "应用接入方code", required = true)
	private String partnerCode;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "来源城市id")
	private Long fromOrgId;

	@ApiParam(description = "本地城市id", required = true)
	private Long orgId;

	@ApiParam(description = "来源仓库id")
	private Long fromWarehouseId;

	@ApiParam(description = "本地仓库id", required = true)
	private Long warehouseId;

	@ApiParam(description = "波次号")
	private String waveNo;

	@ApiParam(description = "装卸员id")
	private Long stevedoreUserId;

	@ApiParam(description = "装卸员")
	private String stevedoreUserName;

	@ApiParam(description = "货位")
	private Long defaultLocationId;

	@ApiParam(description = "货位")
	private String defaultLocationName;
	
	@ApiParam(description = "出库时间")
	private Date outstockTime;
	
	@ApiParam(description = "创建时间")
	private Date createTime;

	@ApiParam(description = "更新时间")
	private Date lastUpdateTime;

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getFromOrgId() {
		return fromOrgId;
	}

	public void setFromOrgId(Long fromOrgId) {
		this.fromOrgId = fromOrgId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(Long fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWaveNo() {
		return waveNo;
	}

	public void setWaveNo(String waveNo) {
		this.waveNo = waveNo;
	}

	public Long getStevedoreUserId() {
		return stevedoreUserId;
	}

	public void setStevedoreUserId(Long stevedoreUserId) {
		this.stevedoreUserId = stevedoreUserId;
	}

	public String getStevedoreUserName() {
		return stevedoreUserName;
	}

	public void setStevedoreUserName(String stevedoreUserName) {
		this.stevedoreUserName = stevedoreUserName;
	}

	public Long getDefaultLocationId() {
		return defaultLocationId;
	}

	public void setDefaultLocationId(Long defaultLocationId) {
		this.defaultLocationId = defaultLocationId;
	}

	public String getDefaultLocationName() {
		return defaultLocationName;
	}

	public void setDefaultLocationName(String defaultLocationName) {
		this.defaultLocationName = defaultLocationName;
	}

	public Date getOutstockTime() {
		return outstockTime;
	}

	public void setOutstockTime(Date outstockTime) {
		this.outstockTime = outstockTime;
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
