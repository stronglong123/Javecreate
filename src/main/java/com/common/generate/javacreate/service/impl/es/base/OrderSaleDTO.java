package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 销售订单信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "销售订单模型")
public class OrderSaleDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "应用接入方code", required = true)
	private String partnerCode;

	@ApiParam(description = "订单id", required = true)
	private Long orderId;

	@ApiParam(description = "是否预售")
	private Integer preSaleType;

	@ApiParam(description = "店铺id")
	private Long shopId;

	@ApiParam(description = "店铺名")
	private String shopName;

	@ApiParam(description = "预售转正常时间")
	private Date preSaleToNormalTime;

	@ApiParam(description = "经纪人id")
	private Long saleManId;

	@ApiParam(description = "经纪人姓名")
	private String saleManName;

	@ApiParam(description = "经纪人电话")
	private String saleManPhone;

	/**
	 * 用户收货状态 0-未收货，1-手动确认收货，2-自动确认收货
	 */
	@ApiParam(description = "用户收货状态", required = true)
	private Integer userConfirmState;

	@ApiParam(description = "创建时间")
	private Date createTime;

	@ApiParam(description = "更新时间")
	private Date lastUpdateTime;

	private Long checkoutWarehouseId;

	public Long getCheckoutWarehouseId() {
		return checkoutWarehouseId;
	}

	public void setCheckoutWarehouseId(Long checkoutWarehouseId) {
		this.checkoutWarehouseId = checkoutWarehouseId;
	}

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

	public Integer getPreSaleType() {
		return preSaleType;
	}

	public void setPreSaleType(Integer preSaleType) {
		this.preSaleType = preSaleType;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Date getPreSaleToNormalTime() {
		return preSaleToNormalTime;
	}

	public void setPreSaleToNormalTime(Date preSaleToNormalTime) {
		this.preSaleToNormalTime = preSaleToNormalTime;
	}

	public Long getSaleManId() {
		return saleManId;
	}

	public void setSaleManId(Long saleManId) {
		this.saleManId = saleManId;
	}

	public String getSaleManName() {
		return saleManName;
	}

	public void setSaleManName(String saleManName) {
		this.saleManName = saleManName;
	}

	public String getSaleManPhone() {
		return saleManPhone;
	}

	public void setSaleManPhone(String saleManPhone) {
		this.saleManPhone = saleManPhone;
	}

	public Integer getUserConfirmState() {
		return userConfirmState;
	}

	public void setUserConfirmState(Integer userConfirmState) {
		this.userConfirmState = userConfirmState;
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
