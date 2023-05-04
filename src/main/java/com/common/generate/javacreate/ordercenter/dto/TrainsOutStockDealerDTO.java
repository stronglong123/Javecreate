package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 出库二级货主信息
 */
public class TrainsOutStockDealerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 小件数量
     */
    //@ApiParam(description = "小件数量", required = true)
    private BigDecimal unitTotalCount;

    /**
     * 二级货主信息
     */
    //@ApiParam(description = "二级货主Id", required = true)
    private Long secOwnerId;

    /**
     * 生产日期
     */
    //@ApiParam(description = "生产日期")
    private Date productionDate;
    /**
     * 一级货主
     */
    //@ApiParam(description = "一级货主")
    private Long ownerId;

    /**
     * ERP二级货主
     */
    //@ApiParam(description = "erpSecOwnerId")
    private Long erpSecOwnerId;
    /**
     * 保质期
     */
    //@ApiParam(description = "保质期")
    private Date expirationDate;
    /**
     * 规格Id
     */
    //@ApiParam(description = "规格Id")
    private Long productSpecificationId;

    public BigDecimal getUnitTotalCount() {
        return unitTotalCount;
    }

    public void setUnitTotalCount(BigDecimal unitTotalCount) {
        this.unitTotalCount = unitTotalCount;
    }

    public Long getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(Long secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * 获取 一级货主
     *
     * @return ownerId 一级货主
     */
    public Long getOwnerId() {
        return this.ownerId;
    }

    /**
     * 设置 一级货主
     *
     * @param ownerId 一级货主
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取 规格Id
     *
     * @return productSpecificationId 规格Id
     */
    public Long getProductSpecificationId() {
        return this.productSpecificationId;
    }

    /**
     * 设置 规格Id
     *
     * @param productSpecificationId 规格Id
     */
    public void setProductSpecificationId(Long productSpecificationId) {
        this.productSpecificationId = productSpecificationId;
    }

    /**
     * 获取 ERP二级货主
     *
     * @return erpSecOwnerId ERP二级货主
     */
    public Long getErpSecOwnerId() {
        return this.erpSecOwnerId;
    }

    /**
     * 设置 ERP二级货主
     *
     * @param erpSecOwnerId ERP二级货主
     */
    public void setErpSecOwnerId(Long erpSecOwnerId) {
        this.erpSecOwnerId = erpSecOwnerId;
    }

    /**
     * 获取 保质期
     *
     * @return expirationDate 保质期
     */
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * 设置 保质期
     *
     * @param expirationDate 保质期
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
