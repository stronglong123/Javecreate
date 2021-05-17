package com.common.generate.javacreate.test.groupsettle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OutStockApplyDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 城市id
     */
    private Integer orgId;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 出库申请单单号
     */
    private String orderNo;

    /**
     * 出库申请单类型: 销售出库(51), 破损出库(53), 其他出库(54), 采购退货(55), 第三方出库(57);
     */
    private Byte orderType;

    /**
     * 出库申请单业务类型 日常破损(50), 招待(51), 福利(52), 客情(53), 借酒(54), 陈列(55); (对应OutStockOrderBusinessType)
     */
    private Byte businessType;

    /**
     * 出库申请单状态 待审核(0), 待出库(1), 部分出库(2), 已出库(3), 审核拒绝(4), 已取消(5);
     */
    private Byte state;

    /**
     * 商品种类数
     */
    private Integer skuCount;

    /**
     * 申请大单位数量
     */
    private BigDecimal packageAmount;

    /**
     * 申请小单位数量
     */
    private BigDecimal unitAmount;

    /**
     * 已出库大单位数量
     */
    private BigDecimal overPackageAmount;

    /**
     * 已出库小单位数量
     */
    private BigDecimal overUnitAmount;

    /**
     * 申请人名称
     */
    private String applyUserName;

    /**
     * 申请人id
     */
    private Integer applyUserId;

    /**
     * 客户名称
     */
    private String userName;

    /**
     * 客户id
     */
    private Integer userId;

    /**
     * 取货人名称
     */
    private String trueName;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 身份证
     */
    private String IDCard;

    /**
     * 供应商id
     */
    private Long supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预计出库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expectedOutStockTime;

    /**
     * 出库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date outStockTime;

    /**
     * 关联单id
     */
    private String refOrderId;

    /**
     * 关联单单号
     */
    private String refOrderNo;

    /**
     * 是否带票 不带票(0), 带票(1);
     */
    private Byte haveTickets;

    /**
     * 是否删除: 0:未删除, 1:已删除;
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String lastUpdateUser;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;

    /**
     * 关联审核工单id
     */
    private String auditId;

    /**
     * 申请明细项
     */
    private List<OutStockItemApplyDTO> outStockItemApplyDTOS;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 图片地址
     */
    private List<String> pictureUrls;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public BigDecimal getOverPackageAmount() {
        return overPackageAmount;
    }

    public void setOverPackageAmount(BigDecimal overPackageAmount) {
        this.overPackageAmount = overPackageAmount;
    }

    public BigDecimal getOverUnitAmount() {
        return overUnitAmount;
    }

    public void setOverUnitAmount(BigDecimal overUnitAmount) {
        this.overUnitAmount = overUnitAmount;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName == null ? null : applyUserName.trim();
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard == null ? null : IDCard.trim();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getExpectedOutStockTime() {
        return expectedOutStockTime;
    }

    public void setExpectedOutStockTime(Date expectedOutStockTime) {
        this.expectedOutStockTime = expectedOutStockTime;
    }

    public Date getOutStockTime() {
        return outStockTime;
    }

    public void setOutStockTime(Date outStockTime) {
        this.outStockTime = outStockTime;
    }

    public String getRefOrderId() {
        return refOrderId;
    }

    public void setRefOrderId(String refOrderId) {
        this.refOrderId = refOrderId == null ? null : refOrderId.trim();
    }

    public String getRefOrderNo() {
        return refOrderNo;
    }

    public void setRefOrderNo(String refOrderNo) {
        this.refOrderNo = refOrderNo == null ? null : refOrderNo.trim();
    }

    public Byte getHaveTickets() {
        return haveTickets;
    }

    public void setHaveTickets(Byte haveTickets) {
        this.haveTickets = haveTickets;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public List<OutStockItemApplyDTO> getOutStockItemApplyDTOS() {
        return outStockItemApplyDTOS;
    }

    public void setOutStockItemApplyDTOS(List<OutStockItemApplyDTO> outStockItemApplyDTOS) {
        this.outStockItemApplyDTOS = outStockItemApplyDTOS;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }
}