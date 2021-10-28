package com.common.generate.javacreate.test.transferNote;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 出库单表PO
 *
 * @author liushuang  2018/3/13
 */
public class OutStockOrderDTO implements Serializable {
    /** id*/
    private String id;

    /** 订单编号*/
    private String refOrderNo;

    /** 城市ID，分库用（第三方订单使用一个新的自定义CityId）*/
    private Integer orgId;
    /**
     * 下单城市id
     */
    private Integer fromCityId;

    /** 波次编号*/
    private String batchNo;

    /** 波次Id*/
    private String batchId;

    /** 波次状态： 待调度(0),待拣货(1),拣货中(2),已拣货(3),已出库(4),已取消(5),已作废(6)*/
    private Byte state = 0;
    /**
     * 波次状态名称
     */
    private String stateText;
    /**
     * 配送订单状态  延迟配送(3)
     */
    private Byte deliveryMarkState;
    /**
     * 配送订单状态
     */
    private String deliveryMarkStateText;

    /** 企业编码（SAAS用）：YJP*/
    private String companyCode;

    /** 订单类型0=酒批订单，1=招商订单，2=经销商直配订单，3=大货批发订单，4=经济人撮合订单，10=大商转配送订单，11=轻加盟订单，12=经销商订单，13=易经销订单，14=兑奖订单'*/
    private Byte orderType;

    /** 订单类型0=酒批订单，1=招商订单，2=经销商直配订单，3=大货批发订单，4=经济人撮合订单，10=大商转配送订单，11=轻加盟订单，12=经销商订单，13=易经销订单，14=兑奖订单'*/
    private String orderTypeText;

    /** 关联业务单据类型1=酒批业务订单，2=酒批业务退货单，3=经纪人撮合业务，4=兑奖订单业务 5 erp业务'*/
    private Byte businessType;

    /** 关联业务单据类型1=酒批业务订单，2=酒批业务退货单，3=经纪人撮合业务，4=兑奖订单业务 5 erp业务'*/
    private String businessTypeText;

    /** 订单金额*/
    private BigDecimal orderAmount;

    /** 应付金额*/
    private BigDecimal payableAmount;

    /** 商品种类数*/
    private Integer skuCount;

    /** 大件总数*/
    private BigDecimal packageAmount;

    /** 小件总数*/
    private BigDecimal unitAmount;

    /** 发货仓库id*/
    private Integer warehouseId;

    /** 收货人姓名*/
    private String username;

    /** 店铺名称*/
    private String shopName;

    /** 收货人手机号*/
    private String mobileNo;

    /** 收货地址*/
    private String detailAddress;

    /** 地址id*/
    private Integer addressId;

    /** 省*/
    private String province;

    /** 市*/
    private String city;

    /** 区*/
    private String county;

    /** 街道*/
    private String street;

    /** 托管方ID*/
    private Long parterId;

    /** 托管方名称*/
    private String parterName;

    /** 下单时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderCreateTime;

    /** 开始拣货时间*/
    private Date pickTime;

    /** 出库时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date outStockTime;

    /** 出库操作人*/
    private String outStockUser;

    /** 区域id*/
    private Long areaId;

    /** 区域名称*/
    private String areaName;

    /** 线路id*/
    private Long routeId;

    /** 线路名称*/
    private String routeName;

    /** 线路排序号*/
    private Integer routeSequence;

    /** 创建人*/
    private String createUser;

    /** 创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /** 更新人*/
    private String lastUpdateUser;

    /** 更新时间*/
    private Date lastUpdateTime;
    /**
     * 配送方式 （0=酒批配送，1=合作商配送，2=配送商配送，4=客户自提，5=总部物流，6=区域代配送，20=门店转配送，-1=不配送）
     */
    private Byte deliveryMode;
    /**
     * 配送方式 （0=酒批配送，1=合作商配送，2=配送商配送，4=客户自提，5=总部物流，6=区域代配送，20=门店转配送，-1=不配送）
     */
    private String deliveryModeText;

    private List<OutStockOrderItemDTO> outStockOrderItemDTOS;

    /**
     * 订单序号
     */
    private Integer orderSequence;

    /**
     * 是否需要生内配单
     */
    private Boolean createAllocation;

    /**
     * ERP出库单Id
     */
    private String newNoteId;
    /**
     * ERP出库单编号
     */
    private String newNoteNo;

    /**
     * 是否直接改变库存
     */
    public Boolean directChangeStock;

    /**
     * 是否不更新库存，只处理批次库存
     */
    private Boolean isNotUpdateProductStore;

    /**
     * @Fields warehouseName 仓库名称
     */
    private String warehouseName;
    /**
     * @Fields orgName 组织机构名称
     */
    private String orgName;
    /**
     * @Fields erpState ERP审核状态 待采购审核 = 1,待财务审核 = 2,采购拒绝 = 3,财务拒绝 = 4,异常审核 = 5,异常拒绝 = 6, 已核算 = 9
     */
    private Integer erpState;
    /**
     * @Fields erpState ERP审核状态 待采购审核 = 1,待财务审核 = 2,采购拒绝 = 3,财务拒绝 = 4,异常审核 = 5,异常拒绝 = 6, 已核算 = 9
     */
    private String erpStateText;
    /**
     * @Fields businessId ERP入库单编号
     */
    private String businessId;

    /**
     * @Fields imgBusinessId 复核图片ID
     */
    private String imgBusinessId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 采购商id
     */
    private String purchaserId;

    /**
     * 采购商名称
     */
    private String purchaserName;

    /**
     * 业务状态
     */
    private Byte businessState;

    /**
     * 业务状态
     */
    private String businessStateText;

    /**
     * 订单属性（1: 大件订单 2: 小件订单）
     */
    private Byte packageAttribute;

    /**
     * 预计出库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expectedOutStockTime;

    /**
     * 采购员id
     */
    private String buyerId;

    /**
     * 采购员名称
     */
    private String buyerName;

    /**
     * 是否内部往来(默认非内部往来，销售出库,采购退货出库为内部往来)
     */
    private Boolean internalContacts = false;

    /**
     * 关联单据编号
     */
    private String associatedBusinessNo;

    /**
     * 关联单据编号
     */
    private String associatedBusinessId;

    /**
     * 是否需要检查库存
     */
    private Boolean needCheckStoreCount;

    /**
     *  外部单据编号
     */
    private String businessNo;

    /**
     * 货主id
     */
    private Long ownerId;

    /**
     *  货主名称
     */
    private String ownerName;

    /**
     * 是否跨库
     */
    private Boolean crossWareHouse;

    /**
     * 目标仓库id
     */
    private Integer toWarehouseId;

    /**
     * 下推状态
     */
    private Byte pushState;

    /**
     * 下推人
     */
    private String pushUser;

    /**
     * 下推时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pushTime;

    /**
     * 图片地址
     */
    private List<String> pictureUrls;

    /**
     * 目标城市类型
     */
    private Byte toOrgType;


    /**
     * 目标城市id
     */
    private Integer toOrgId;

    /**
     * 内配类型: 8.内配，9.内配退，11.中转 12.中转退
     */
    private Byte allotType;

    /**
     * 是否分配计算
     */
    private Boolean allocationCalculation = true;

    /**
     * 操作人id
     */
    private Integer createUserId;

    /**
     * 操作人id
     */
    private Long weaverUserId;

    /**
     * 是否有票：0-无，1-有
     */
    private Integer haveTickets;

    /**
     * 主供应商id
     */
    private String erpMasterSupplierId;


    public Byte getPackageAttribute() {
        return packageAttribute;
    }

    public void setPackageAttribute(Byte packageAttribute) {
        this.packageAttribute = packageAttribute;
    }

    public Boolean getCreateAllocation() {
        return createAllocation;
    }

    public void setCreateAllocation(Boolean createAllocation) {
        this.createAllocation = createAllocation;
    }

    public Integer getOrderSequence() {
        return orderSequence;
    }

    public void setOrderSequence(Integer orderSequence) {
        this.orderSequence = orderSequence;
    }

    public List<OutStockOrderItemDTO> getOutStockOrderItemDTOS() {
        return outStockOrderItemDTOS;
    }

    public void setOutStockOrderItemDTOS(List<OutStockOrderItemDTO> outStockOrderItemDTOS) {
        this.outStockOrderItemDTOS = outStockOrderItemDTOS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefOrderNo() {
        return refOrderNo;
    }

    public void setRefOrderNo(String refOrderNo) {
        this.refOrderNo = refOrderNo == null ? null : refOrderNo.trim();
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Integer getSkuCount() {
        return skuCount;
    }

    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    public BigDecimal getPackageAmount() {
        return packageAmount;
    }

    public void setPackageAmount(BigDecimal packageAmount) {
        this.packageAmount = packageAmount;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public Long getParterId() {
        return parterId;
    }

    public void setParterId(Long parterId) {
        this.parterId = parterId;
    }

    public String getParterName() {
        return parterName;
    }

    public void setParterName(String parterName) {
        this.parterName = parterName == null ? null : parterName.trim();
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getPickTime() {
        return pickTime;
    }

    public void setPickTime(Date pickTime) {
        this.pickTime = pickTime;
    }

    public Date getOutStockTime() {
        return outStockTime;
    }

    public void setOutStockTime(Date outStockTime) {
        this.outStockTime = outStockTime;
    }

    public String getOutStockUser() {
        return outStockUser;
    }

    public void setOutStockUser(String outStockUser) {
        this.outStockUser = outStockUser == null ? null : outStockUser.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    public Integer getRouteSequence() {
        return routeSequence;
    }

    public void setRouteSequence(Integer routeSequence) {
        this.routeSequence = routeSequence;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Byte getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Byte deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Integer getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(Integer fromCityId) {
        this.fromCityId = fromCityId;
    }

    public Byte getDeliveryMarkState() {
        return deliveryMarkState;
    }

    public void setDeliveryMarkState(Byte deliveryMarkState) {
        this.deliveryMarkState = deliveryMarkState;
    }

    public String getNewNoteId() {
        return newNoteId;
    }

    public void setNewNoteId(String newNoteId) {
        this.newNoteId = newNoteId;
    }

    public String getNewNoteNo() {
        return newNoteNo;
    }

    public void setNewNoteNo(String newNoteNo) {
        this.newNoteNo = newNoteNo;
    }

    public Boolean getDirectChangeStock() {
        return directChangeStock;
    }

    public void setDirectChangeStock(Boolean directChangeStock) {
        this.directChangeStock = directChangeStock;
    }

    public Boolean getNotUpdateProductStore() {
        return isNotUpdateProductStore;
    }

    public void setNotUpdateProductStore(Boolean notUpdateProductStore) {
        isNotUpdateProductStore = notUpdateProductStore;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getErpState() {
        return erpState;
    }

    public void setErpState(Integer erpState) {
        this.erpState = erpState;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getImgBusinessId() {
        return imgBusinessId;
    }

    public void setImgBusinessId(String imgBusinessId) {
        this.imgBusinessId = imgBusinessId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public Byte getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Byte businessState) {
        this.businessState = businessState;
    }

    public Date getExpectedOutStockTime() {
        return expectedOutStockTime;
    }

    public void setExpectedOutStockTime(Date expectedOutStockTime) {
        this.expectedOutStockTime = expectedOutStockTime;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Boolean getInternalContacts() {
        return internalContacts;
    }

    public void setInternalContacts(Boolean internalContacts) {
        this.internalContacts = internalContacts;
    }

    public String getAssociatedBusinessNo() {
        return associatedBusinessNo;
    }

    public void setAssociatedBusinessNo(String associatedBusinessNo) {
        this.associatedBusinessNo = associatedBusinessNo;
    }

    public Boolean getNeedCheckStoreCount() {
        return needCheckStoreCount;
    }

    public void setNeedCheckStoreCount(Boolean needCheckStoreCount) {
        this.needCheckStoreCount = needCheckStoreCount;
    }

    public String getAssociatedBusinessId() {
        return associatedBusinessId;
    }

    public void setAssociatedBusinessId(String associatedBusinessId) {
        this.associatedBusinessId = associatedBusinessId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

	/**
	 * @return the stateText
	 */
	public String getStateText() {
		return stateText;
	}

	/**
	 * @param stateText the stateText to set
	 */
	public void setStateText(String stateText) {
		this.stateText = stateText;
	}

	/**
	 * @return the deliveryMarkStateText
	 */
	public String getDeliveryMarkStateText() {
		return deliveryMarkStateText;
	}

	/**
	 * @param deliveryMarkStateText the deliveryMarkStateText to set
	 */
	public void setDeliveryMarkStateText(String deliveryMarkStateText) {
		this.deliveryMarkStateText = deliveryMarkStateText;
	}

	/**
	 * @return the orderTypeText
	 */
	public String getOrderTypeText() {
		return orderTypeText;
	}

	/**
	 * @param orderTypeText the orderTypeText to set
	 */
	public void setOrderTypeText(String orderTypeText) {
		this.orderTypeText = orderTypeText;
	}

	/**
	 * @return the businessTypeText
	 */
	public String getBusinessTypeText() {
		return businessTypeText;
	}

	/**
	 * @param businessTypeText the businessTypeText to set
	 */
	public void setBusinessTypeText(String businessTypeText) {
		this.businessTypeText = businessTypeText;
	}

	/**
	 * @return the deliveryModeText
	 */
	public String getDeliveryModeText() {
		return deliveryModeText;
	}

	/**
	 * @param deliveryModeText the deliveryModeText to set
	 */
	public void setDeliveryModeText(String deliveryModeText) {
		this.deliveryModeText = deliveryModeText;
	}

	/**
	 * @return the erpStateText
	 */
	public String getErpStateText() {
		return erpStateText;
	}

	/**
	 * @param erpStateText the erpStateText to set
	 */
	public void setErpStateText(String erpStateText) {
		this.erpStateText = erpStateText;
	}

	/**
	 * @return the businessStateText
	 */
	public String getBusinessStateText() {
		return businessStateText;
	}

	/**
	 * @param businessStateText the businessStateText to set
	 */
	public void setBusinessStateText(String businessStateText) {
		this.businessStateText = businessStateText;
	}

    public Boolean getCrossWareHouse() {
        return crossWareHouse;
    }

    public void setCrossWareHouse(Boolean crossWareHouse) {
        this.crossWareHouse = crossWareHouse;
    }

    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public Byte getPushState() {
        return pushState;
    }

    public void setPushState(Byte pushState) {
        this.pushState = pushState;
    }

    public String getPushUser() {
        return pushUser;
    }

    public void setPushUser(String pushUser) {
        this.pushUser = pushUser;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public Byte getToOrgType() {
        return toOrgType;
    }

    public void setToOrgType(Byte toOrgType) {
        this.toOrgType = toOrgType;
    }

    public Integer getToOrgId() {
        return toOrgId;
    }

    public void setToOrgId(Integer toOrgId) {
        this.toOrgId = toOrgId;
    }

    public Byte getAllotType() {
        return allotType;
    }

    public void setAllotType(Byte allotType) {
        this.allotType = allotType;
    }

    public Boolean getAllocationCalculation() {
        return allocationCalculation;
    }

    public void setAllocationCalculation(Boolean allocationCalculation) {
        this.allocationCalculation = allocationCalculation;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getHaveTickets() {
        return haveTickets;
    }

    public void setHaveTickets(Integer haveTickets) {
        this.haveTickets = haveTickets;
    }

    public Long getWeaverUserId() {
        return weaverUserId;
    }

    public void setWeaverUserId(Long weaverUserId) {
        this.weaverUserId = weaverUserId;
    }

    public String getErpMasterSupplierId() {
        return erpMasterSupplierId;
    }

    public void setErpMasterSupplierId(String erpMasterSupplierId) {
        this.erpMasterSupplierId = erpMasterSupplierId;
    }
}