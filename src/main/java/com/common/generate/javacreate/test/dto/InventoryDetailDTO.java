package com.common.generate.javacreate.test.dto;

import com.common.generate.javacreate.utils.DateUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author xialei
 * @date 2021/5/11 16:21
 */
public class InventoryDetailDTO implements Serializable {


    private String id;


    private String orderNo;

    private Integer orderType;

    private String recordId;

    private BigDecimal addStoreCount;

    private BigDecimal newStoreCount;

    private BigDecimal sourceStoreCount;

    private Date createTime;
    private String createTimeString;


    private List<InventoryDTO>  addStoreCountDTO;

    private List<InventoryDTO>  newStoreCountDTO;

    private List<InventoryDTO>  sourceStoreCountDTO;

    public String getCreateTimeString() {
        return DateUtils.date2String(this.createTime);
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public List<InventoryDTO> getAddStoreCountDTO() {
        return addStoreCountDTO;
    }

    public void setAddStoreCountDTO(List<InventoryDTO> addStoreCountDTO) {
        this.addStoreCountDTO = addStoreCountDTO;
    }

    public List<InventoryDTO> getNewStoreCountDTO() {
        return newStoreCountDTO;
    }

    public void setNewStoreCountDTO(List<InventoryDTO> newStoreCountDTO) {
        this.newStoreCountDTO = newStoreCountDTO;
    }

    public List<InventoryDTO> getSourceStoreCountDTO() {
        return sourceStoreCountDTO;
    }

    public void setSourceStoreCountDTO(List<InventoryDTO> sourceStoreCountDTO) {
        this.sourceStoreCountDTO = sourceStoreCountDTO;
    }

    public BigDecimal getAddStoreCount() {
        return addStoreCount;
    }

    public void setAddStoreCount(BigDecimal addStoreCount) {
        this.addStoreCount = addStoreCount;
    }

    public BigDecimal getNewStoreCount() {
        return newStoreCount;
    }

    public void setNewStoreCount(BigDecimal newStoreCount) {
        this.newStoreCount = newStoreCount;
    }

    public BigDecimal getSourceStoreCount() {
        return sourceStoreCount;
    }

    public void setSourceStoreCount(BigDecimal sourceStoreCount) {
        this.sourceStoreCount = sourceStoreCount;
    }
}
