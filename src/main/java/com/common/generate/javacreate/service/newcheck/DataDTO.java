package com.common.generate.javacreate.service.newcheck;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/5/14 20:59
 */
public class DataDTO implements Serializable {


    private static final long serialVersionUID = 6328012609984650799L;

    private Integer storehouseId;

    private String storehouseName;

    private Long specid;

    private String desc_ProductName;

    private BigDecimal totalCount;

    private String ownerId;

    private Long wmsOwnerId;

    private String ownerName;

    private String type;

    public Long getWmsOwnerId() {
        return wmsOwnerId;
    }

    public void setWmsOwnerId(Long wmsOwnerId) {
        this.wmsOwnerId = wmsOwnerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
    }

    public Long getSpecid() {
        return specid;
    }

    public void setSpecid(Long specid) {
        this.specid = specid;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
