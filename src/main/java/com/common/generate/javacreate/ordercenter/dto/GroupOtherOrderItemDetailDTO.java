package com.common.generate.javacreate.ordercenter.dto;



import java.io.Serializable;
import java.math.BigDecimal;

public class GroupOtherOrderItemDetailDTO implements Serializable {


    /**
     * 小单位总数量
     */
    private String unitTotalCount;

    /**
     * 二级货主id
     */
    private String secOwnerId;


	public String getUnitTotalCount() {
		return unitTotalCount;
	}

	public void setUnitTotalCount(String unitTotalCount) {
		this.unitTotalCount = unitTotalCount;
	}

	public String getSecOwnerId() {
		return secOwnerId;
	}

	public void setSecOwnerId(String secOwnerId) {
		this.secOwnerId = secOwnerId;
	}
}