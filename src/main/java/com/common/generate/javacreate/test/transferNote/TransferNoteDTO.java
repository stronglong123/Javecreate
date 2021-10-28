package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author xialei
 * @date 2020-06-04
 */
public class TransferNoteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 业务类型， 1、仓间调拨  2、城际调拨
     */
    private Byte businessType;
    /**
     * 调拨单编号
     */
    private String transferNo;
    /**
     * 发送仓库id
     */
    private Integer outWarehouseId;
    /**
     * 发货仓库
     */
    private String outWarehouseName;
    /**
     * 发货人
     */
    private String consignor;
    /**
     * 发货电话
     */
    private String consignorPhone;
    /**
     * 发货地址
     */
    private String consignorAddress;
    /**
     * 发货城市id
     */
    private Integer orgId;
    /**
     * 发货城市
     */
    private String orgName;
    /**
     * 收货仓库
     */
    private Integer inWarehouseId;
    /**
     * 收货仓库
     */
    private String inWarehouseName;
    /**
     * 收货人
     */
    private String contact;
    /**
     * 收货电话
     */
    private String contactPhone;
    /**
     * 收货人地址
     */
    private String contactAddress;
    /**
     * 收货人城市id
     */
    private Integer inOrgId;
    /**
     * 收货人城市
     */
    private String inOrgName;
    /**
     * 0、已申请，1、待审核，2、已审核，3、已取消，4、已发货，5、部分完成，6、已完成，7、已驳回
     */
    private Byte state;
    /**
     * 下单时间
     */
    private Date orderCreateTime;
    /**
     * 发货时间
     */
    private Date deliveryTime;
    /**
     * 收货时间
     */
    private Date receivingTime;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 采购总金额
     */
    private BigDecimal totalAmount;
    /**
     * 产品种类数量
     */
    private Integer skuCount;
    /**
     * 收货小单位总数量
     */
    private BigDecimal inUnitTotalCount;
    /**
     * 发货小单位总数量
     */
    private BigDecimal outUnitTotalCount;
    /**
     * 入库货主id
     */
    private Long productOwnerId;
    /**
     * 入库货主名称
     */
    private String productOwnerName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date lastUpdateTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改人
     */
    private String lastUpdateUser;
    private List<TransferNoteItemDTO> transferNoteItems;

    /**
     * 来源系统
     */
    private String source;

    /**
     * 关联单号
     */
    private String relateNoteNo;

    /**
     * 关联id
     */
    private String relatedNoteId;


    public String getRelateNoteNo() {
        return relateNoteNo;
    }

    public void setRelateNoteNo(String relateNoteNo) {
        this.relateNoteNo = relateNoteNo;
    }

    public String getRelatedNoteId() {
        return relatedNoteId;
    }

    public void setRelatedNoteId(String relatedNoteId) {
        this.relatedNoteId = relatedNoteId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置id
     */
    public Long getId() {
        return id;
    }

    /**
     * 获取业务类型， 1、统采调拨  2、分采调拨
     */
    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    /**
     * 设置业务类型， 1、统采调拨  2、分采调拨
     */
    public Byte getBusinessType() {
        return businessType;
    }

    /**
     * 获取调拨单编号
     */
    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo;
    }

    /**
     * 设置调拨单编号
     */
    public String getTransferNo() {
        return transferNo;
    }

    /**
     * 获取发送仓库id
     */
    public void setOutWarehouseId(Integer outWarehouseId) {
        this.outWarehouseId = outWarehouseId;
    }

    /**
     * 设置发送仓库id
     */
    public Integer getOutWarehouseId() {
        return outWarehouseId;
    }

    /**
     * 获取发货仓库
     */
    public void setOutWarehouseName(String outWarehouseName) {
        this.outWarehouseName = outWarehouseName;
    }

    /**
     * 设置发货仓库
     */
    public String getOutWarehouseName() {
        return outWarehouseName;
    }

    /**
     * 获取发货人
     */
    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    /**
     * 设置发货人
     */
    public String getConsignor() {
        return consignor;
    }

    /**
     * 获取发货电话
     */
    public void setConsignorPhone(String consignorPhone) {
        this.consignorPhone = consignorPhone;
    }

    /**
     * 设置发货电话
     */
    public String getConsignorPhone() {
        return consignorPhone;
    }

    /**
     * 获取发货地址
     */
    public void setConsignorAddress(String consignorAddress) {
        this.consignorAddress = consignorAddress;
    }

    /**
     * 设置发货地址
     */
    public String getConsignorAddress() {
        return consignorAddress;
    }

    /**
     * 获取发货城市id
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * 设置发货城市id
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * 获取发货城市
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 设置发货城市
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 获取收货仓库
     */
    public void setInWarehouseId(Integer inWarehouseId) {
        this.inWarehouseId = inWarehouseId;
    }

    /**
     * 设置收货仓库
     */
    public Integer getInWarehouseId() {
        return inWarehouseId;
    }

    /**
     * 获取收货仓库
     */
    public void setInWarehouseName(String inWarehouseName) {
        this.inWarehouseName = inWarehouseName;
    }

    /**
     * 设置收货仓库
     */
    public String getInWarehouseName() {
        return inWarehouseName;
    }

    /**
     * 获取收货人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 设置收货人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 获取收货电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 设置收货电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 获取收货人地址
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     * 设置收货人地址
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * 获取收货人城市id
     */
    public void setInOrgId(Integer inOrgId) {
        this.inOrgId = inOrgId;
    }

    /**
     * 设置收货人城市id
     */
    public Integer getInOrgId() {
        return inOrgId;
    }

    /**
     * 获取收货人城市
     */
    public void setInOrgName(String inOrgName) {
        this.inOrgName = inOrgName;
    }

    /**
     * 设置收货人城市
     */
    public String getInOrgName() {
        return inOrgName;
    }

    /**
     * 获取0、已申请，1、待审核，2、已审核，3、已取消，4、已发货，5、部分完成，6、已完成，7、已驳回
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 设置0、已申请，1、待审核，2、已审核，3、已取消，4、已发货，5、部分完成，6、已完成，7、已驳回
     */
    public Byte getState() {
        return state;
    }

    /**
     * 获取下单时间
     */
    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    /**
     * 设置下单时间
     */
    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    /**
     * 获取发货时间
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 设置发货时间
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 获取收货时间
     */
    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    /**
     * 设置收货时间
     */
    public Date getReceivingTime() {
        return receivingTime;
    }

    /**
     * 获取供应商id
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 设置供应商id
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 获取供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * 设置供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 获取采购总金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 设置采购总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 获取产品种类数量
     */
    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    /**
     * 设置产品种类数量
     */
    public Integer getSkuCount() {
        return skuCount;
    }

    /**
     * 获取收货小单位总数量
     */
    public void setInUnitTotalCount(BigDecimal inUnitTotalCount) {
        this.inUnitTotalCount = inUnitTotalCount;
    }

    /**
     * 设置收货小单位总数量
     */
    public BigDecimal getInUnitTotalCount() {
        return inUnitTotalCount;
    }

    /**
     * 获取发货小单位总数量
     */
    public void setOutUnitTotalCount(BigDecimal outUnitTotalCount) {
        this.outUnitTotalCount = outUnitTotalCount;
    }

    /**
     * 设置发货小单位总数量
     */
    public BigDecimal getOutUnitTotalCount() {
        return outUnitTotalCount;
    }

    /**
     * 获取入库货主id
     */
    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    /**
     * 设置入库货主id
     */
    public Long getProductOwnerId() {
        return productOwnerId;
    }

    /**
     * 获取入库货主名称
     */
    public void setProductOwnerName(String productOwnerName) {
        this.productOwnerName = productOwnerName;
    }

    /**
     * 设置入库货主名称
     */
    public String getProductOwnerName() {
        return productOwnerName;
    }

    /**
     * 获取备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 设置备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 获取创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 设置创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 获取修改时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 设置修改时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 获取创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 设置创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 获取修改人
     */
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 设置修改人
     */
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setTransferNoteItems(List<TransferNoteItemDTO> transferNoteItems) {
        this.transferNoteItems = transferNoteItems;
    }

    public List<TransferNoteItemDTO> getTransferNoteItems() {
        return this.transferNoteItems;
    }

    @Override
    public String toString() {
        return "TransferNoteDTO{" +
                "id=" + id +
                ", businessType=" + businessType +
                ", transferNo='" + transferNo + '\'' +
                ", outWarehouseId=" + outWarehouseId +
                ", outWarehouseName='" + outWarehouseName + '\'' +
                ", consignor='" + consignor + '\'' +
                ", consignorPhone='" + consignorPhone + '\'' +
                ", consignorAddress='" + consignorAddress + '\'' +
                ", orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", inWarehouseId=" + inWarehouseId +
                ", inWarehouseName='" + inWarehouseName + '\'' +
                ", contact='" + contact + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", inOrgId=" + inOrgId +
                ", inOrgName='" + inOrgName + '\'' +
                ", state=" + state +
                ", orderCreateTime=" + orderCreateTime +
                ", deliveryTime=" + deliveryTime +
                ", receivingTime=" + receivingTime +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", totalAmount=" + totalAmount +
                ", skuCount=" + skuCount +
                ", inUnitTotalCount=" + inUnitTotalCount +
                ", outUnitTotalCount=" + outUnitTotalCount +
                ", productOwnerId=" + productOwnerId +
                ", productOwnerName='" + productOwnerName + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", createUser='" + createUser + '\'' +
                ", lastUpdateUser='" + lastUpdateUser + '\'' +
                ", transferNoteItems=" + transferNoteItems +
                '}';
    }
}