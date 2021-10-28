package com.common.generate.javacreate.test.dto;



import java.io.Serializable;
import java.math.BigDecimal;

public class SettleOrderItemDetailDTO implements Serializable {

    /**
     * 出库入库单明细id
     */
    private Long businessItemId;

    /**
     * 小单位总数量
     */
    private BigDecimal unitTotalCount;

    /**
     * 货主id
     */
    private Long ownerId;

    /**
     * 二级货主id
     */
    private Long secOwnerId;


	public Long getBusinessItemId() {
		return businessItemId;
	}

	public void setBusinessItemId(Long businessItemId) {
		this.businessItemId = businessItemId;
	}

	public BigDecimal getUnitTotalCount() {
		return unitTotalCount;
	}

	public void setUnitTotalCount(BigDecimal unitTotalCount) {
		this.unitTotalCount = unitTotalCount;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getSecOwnerId() {
		return secOwnerId;
	}

	public void setSecOwnerId(Long secOwnerId) {
		this.secOwnerId = secOwnerId;
	}
    
    
    

}