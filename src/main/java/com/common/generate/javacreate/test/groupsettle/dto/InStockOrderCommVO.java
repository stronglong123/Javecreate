package com.common.generate.javacreate.test.groupsettle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class InStockOrderCommVO implements Serializable {

    private static final long serialVersionUID = 2312119540608099010L;
    /**
     * @Fields 单据ID
     */
    private String orderId;

    /**
     * @Fields orderNo 订单编号
     */
    private String orderNo;

    /**
     * 关联单据ID
     */
    private String relatedNoteId;

    /**
     * 关联单据编号
     */
    private String relatedNoteNO;

    /**
     * @Fields orgId 城市ID，分库用（第三方订单使用一个新的自定义CityId）
     */
    private Integer orgId;

    /**
     * 仓库ID
     */
    private Integer warehouseId;

    /**
     * 单据状态
     */
    private Integer orderState = 0;

    /**
     * 单据状态
     */
    private String orderStateText;

    /**
     * @Fields orderType 单据类型
     */
    private Integer orderType;
    /**
     * @Fields orderType 单据类型
     */
    private String orderTypeText;
    /**
     * @Fields businessType 关联业务单据类型
     */
    private Integer businessType;

    /**
     * @Fields businessType 关联业务单据类型
     */
    private String businessTypeText;

    /**
     * 业务时间(格式:yyyy-MM-dd HH:mm:ss)
     */
    private String businessTime;

    /**
     * 操作人
     */
    private String operators;

    /**
     * @Fields supplierId 供应商Id
     */
    private String supplierId;

    /**
     * @Fields supplierName 供应商名称
     */
    private String supplierName;

    /**
     * @Fields mobileNo 供应商手机号
     */
    private String mobileNo;

    /**
     * 单据用户
     */
    private String orderUserId;

    /**
     * 单据用户姓名
     */
    private String orderUserName;

    /**
     * 是否跨库0否 1是
     */
    private Integer crossWareHouse;

    /**
     * 是否需要生内配单,0:否，1:是
     */
    private Integer createAllocation;

    /**
     * 批次号编号
     */
    private String batchNO;

    /**
     * 是否集团内部采购
     */
    private Integer isInternal;

    /**
     * 内部往来ID: 仓库或城市ID
     */
    private String internalBusinessId;

    /**
     * 是否删除：0-不删除, 1-删除
     */
    private Integer deleted;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 应付金额
     */
    private BigDecimal payAmount;

    /**
     * @Fields remark 备注
     */
    private String remark;

    /**
     * 扩展字段(供应链仅需保存数据)
     */
    private Map<String, Object> extContent;

    /**
     * 入库单货主ID
     */
    private Long ownerId;

    /**
     * 入库单货主名称
     */
    private String ownerName;

    /**
     * @Fields imgBusinessId 复核图片ID
     */
    private String imgBusinessId;

    /**
     * 业务申请人ID : 采购入库单此字段值为采购员ID
     */
    private String businessApplicantId;

    /**
     * 业务申请人名称：采购入库单此字段值为采购员名称
     */
    private String businessApplicantName;

    /**
     * 单据下推状态
     */
    private Byte pushState;

    /**
     * 单据下推人
     */
    private String pushUser;

    /**
     * 单据下推时间
     * 业务时间(格式:yyyy-MM-dd HH:mm:ss)
     */
    private String pushTime;

    /**
     * 复核图片 - 图片url
     */
    private List<String> imgBusinessUrlList;

    /**
     * 单据使用方式：1、召回，2、冲销
     *      - 供 Erp 调拨入库时处理逻辑使用
     */
    private Integer orderDisposeType;

    private List<InStockOrderCommItemVO> commItemDTOList;

    private Long wmsOrderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRelatedNoteId() {
        return relatedNoteId;
    }

    public void setRelatedNoteId(String relatedNoteId) {
        this.relatedNoteId = relatedNoteId;
    }

    public String getRelatedNoteNO() {
        return relatedNoteNO;
    }

    public void setRelatedNoteNO(String relatedNoteNO) {
        this.relatedNoteNO = relatedNoteNO;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderStateText() {
        return orderStateText;
    }

    public void setOrderStateText(String orderStateText) {
        this.orderStateText = orderStateText;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeText() {
        return orderTypeText;
    }

    public void setOrderTypeText(String orderTypeText) {
        this.orderTypeText = orderTypeText;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getBusinessTypeText() {
        return businessTypeText;
    }

    public void setBusinessTypeText(String businessTypeText) {
        this.businessTypeText = businessTypeText;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public Integer getCrossWareHouse() {
        return crossWareHouse;
    }

    public void setCrossWareHouse(Integer crossWareHouse) {
        this.crossWareHouse = crossWareHouse;
    }

    public Integer getCreateAllocation() {
        return createAllocation;
    }

    public void setCreateAllocation(Integer createAllocation) {
        this.createAllocation = createAllocation;
    }

    public String getBatchNO() {
        return batchNO;
    }

    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    public Integer getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Integer isInternal) {
        this.isInternal = isInternal;
    }

    public String getInternalBusinessId() {
        return internalBusinessId;
    }

    public void setInternalBusinessId(String internalBusinessId) {
        this.internalBusinessId = internalBusinessId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Map<String, Object> getExtContent() {
        return extContent;
    }

    public void setExtContent(Map<String, Object> extContent) {
        this.extContent = extContent;
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

    public String getImgBusinessId() {
        return imgBusinessId;
    }

    public void setImgBusinessId(String imgBusinessId) {
        this.imgBusinessId = imgBusinessId;
    }

    public String getBusinessApplicantId() {
        return businessApplicantId;
    }

    public void setBusinessApplicantId(String businessApplicantId) {
        this.businessApplicantId = businessApplicantId;
    }

    public String getBusinessApplicantName() {
        return businessApplicantName;
    }

    public void setBusinessApplicantName(String businessApplicantName) {
        this.businessApplicantName = businessApplicantName;
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

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public List<String> getImgBusinessUrlList() {
        return imgBusinessUrlList;
    }

    public void setImgBusinessUrlList(List<String> imgBusinessUrlList) {
        this.imgBusinessUrlList = imgBusinessUrlList;
    }

    public Integer getOrderDisposeType() {
        return orderDisposeType;
    }

    public void setOrderDisposeType(Integer orderDisposeType) {
        this.orderDisposeType = orderDisposeType;
    }

    public List<InStockOrderCommItemVO> getCommItemDTOList() {
        return commItemDTOList;
    }

    public void setCommItemDTOList(List<InStockOrderCommItemVO> commItemDTOList) {
        this.commItemDTOList = commItemDTOList;
    }

    public Long getWmsOrderId() {
        return wmsOrderId;
    }

    public void setWmsOrderId(Long wmsOrderId) {
        this.wmsOrderId = wmsOrderId;
    }
}
