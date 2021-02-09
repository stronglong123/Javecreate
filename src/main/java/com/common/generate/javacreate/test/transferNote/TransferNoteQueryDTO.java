package com.common.generate.javacreate.test.transferNote;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author xialei
 * @date 2020-06-04
 */
public class TransferNoteQueryDTO implements Serializable {
    private static final long serialVersionUID = -8052411429176133743L;

    /**
     * 业务类型， 1、统采调拨  2、分采调拨
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
     * 发货城市id
     */
    private Integer orgId;

    /**
     * 收货仓库
     */
    private Integer inWarehouseId;


    /**
     * 收货人城市id
     */
    private Integer inOrgId;

    /**
     * 0、已申请，1、待审核，2、已审核，3、已取消，4、已发货，5、部分完成，6、已完成，7、已驳回
     */
    private Byte state;
    /**
     * 供应商id
     */
    private Long supplierId;

    /**
     * 入库货主id
     */
    private Long productOwnerId;

    /**
     * 创建时间
     */
    private Date beginTime;

    /**
     * 创建时间
     */
    private Date endTime;

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

    /**
     * 登录人仓库id
     */
    private Integer warehouseId;

    /**
     * 状态集合
     */
    private List<Byte> stateList;


    private List<Byte> notStateList;

    private Date unusualTime;


    /**
     * 页码.
     */
    private Integer pageNum = 1;

    /**
     * 每页大小.
     */
    private Integer pageSize = 100;


    public List<Byte> getStateList() {
        return stateList;
    }

    public void setStateList(List<Byte> stateList) {
        this.stateList = stateList;
    }

    public List<Byte> getNotStateList() {
        return notStateList;
    }

    public void setNotStateList(List<Byte> notStateList) {
        this.notStateList = notStateList;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

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

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo;
    }

    public Integer getOutWarehouseId() {
        return outWarehouseId;
    }

    public void setOutWarehouseId(Integer outWarehouseId) {
        this.outWarehouseId = outWarehouseId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getInWarehouseId() {
        return inWarehouseId;
    }

    public void setInWarehouseId(Integer inWarehouseId) {
        this.inWarehouseId = inWarehouseId;
    }

    public Integer getInOrgId() {
        return inOrgId;
    }

    public void setInOrgId(Integer inOrgId) {
        this.inOrgId = inOrgId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }


    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Long productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUnusualTime() {
        return unusualTime;
    }

    public void setUnusualTime(Date unusualTime) {
        this.unusualTime = unusualTime;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "TransferNoteQueryDTO{" +
                "businessType=" + businessType +
                ", transferNo='" + transferNo + '\'' +
                ", outWarehouseId=" + outWarehouseId +
                ", orgId=" + orgId +
                ", inWarehouseId=" + inWarehouseId +
                ", inOrgId=" + inOrgId +
                ", state=" + state +
                ", supplierId=" + supplierId +
                ", productOwnerId=" + productOwnerId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", source='" + source + '\'' +
                ", relateNoteNo='" + relateNoteNo + '\'' +
                ", relatedNoteId='" + relatedNoteId + '\'' +
                ", warehouseId=" + warehouseId +
                '}';
    }
}