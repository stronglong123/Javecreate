package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单发货人信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单发货人模型")
public class OrderConsignorDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	@ApiParam(description = "订单id")
	private Long orderId;

	@ApiParam(description = "应用方code")
	private String partnerCode;

	@ApiParam(description = "发货人", required = true)
	private String consignor;

	@ApiParam(description = "发货人电话", required = true)
	private String consignorPhone;
	
	@ApiParam(description = "发货人公司")
	private String consignorCompanyName;

	@ApiParam(description = "省")
	private String province;

	@ApiParam(description = "市")
	private String city;

	@ApiParam(description = "县（区）")
	private String county;

	@ApiParam(description = "街道")
	private String street;

	@ApiParam(description = "详细地址", required = true)
	private String detailAddress;

	@ApiParam(description = "经度")
	private BigDecimal longitude;

	@ApiParam(description = "纬度")
	private BigDecimal latitude;

	@ApiParam(description = "创建时间")
	private Date createTime;

	@ApiParam(description = "更新时间")
	private Date lastUpdateTime;

	@ApiParam(description = "配送地址id")
	private Long addressId;


	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getConsignor() {
		return consignor;
	}

	public void setConsignor(String consignor) {
		this.consignor = consignor;
	}

	public String getConsignorPhone() {
		return consignorPhone;
	}

	public void setConsignorPhone(String consignorPhone) {
		this.consignorPhone = consignorPhone;
	}

	public String getConsignorCompanyName() {
		return consignorCompanyName;
	}

	public void setConsignorCompanyName(String consignorCompanyName) {
		this.consignorCompanyName = consignorCompanyName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
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
