package com.common.generate.javacreate.test.dto;

import org.springframework.data.relational.core.sql.In;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/5/6 20:10
 */
public class ErpProductSecDTO implements Serializable {

    private static final long serialVersionUID = -3479123701014164496L;
    private Long id;

    private Integer cityid;

    private Integer storehouseId;

    private String desc_ProductName;

    private BigDecimal totalCount;

    private String ownerId;

    private Integer type;

    private BigDecimal outTotalCount;

    private BigDecimal inTotalCount;


    private BigDecimal calCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getDesc_ProductName() {
        return desc_ProductName;
    }

    public void setDesc_ProductName(String desc_ProductName) {
        this.desc_ProductName = desc_ProductName;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getOutTotalCount() {
        return outTotalCount;
    }

    public void setOutTotalCount(BigDecimal outTotalCount) {
        this.outTotalCount = outTotalCount;
    }

    public BigDecimal getInTotalCount() {
        return inTotalCount;
    }

    public void setInTotalCount(BigDecimal inTotalCount) {
        this.inTotalCount = inTotalCount;
    }

    public BigDecimal getCalCount() {
        return calCount;
    }

    public void setCalCount(BigDecimal calCount) {
        this.calCount = calCount;
    }
}
