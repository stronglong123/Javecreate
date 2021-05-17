package com.common.generate.javacreate.test.groupsettle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 团购订单分页参数DTO
 *
 * @author Hu Liangzhi
 * @Date:2021年3月30日 下午5:35:25
 */
public class GroupSettleOrderPageParamDTO {

    private static final long serialVersionUID = -4326301531864169393L;

    /**
     * 页码.
     */
    private Integer pageNum;

    /**
     * 每页大小.
     */
    private Integer pageSize;

    /**
     * 团购账单编号
     */
    private String settleNo;

    /**
     * 区域id
     */
    private Integer orgId;

    /**
     * 销售日期
     */
    private Date saleDate;

    /**
     * 账单日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date accountDate;

    /**
     * 结算日期
     */
    private Date settleDate;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 平台编号 110-多多买菜 111-多多买菜
     */
    private Integer channelNo;

    /**
     * 平台城市
     */
    private String channelCity;

    /**
     * 是否有差异 1-有
     */
    private Integer settleDiff;

    private Integer settleState;

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelCity() {
        return channelCity;
    }

    public void setChannelCity(String channelCity) {
        this.channelCity = channelCity;
    }

    public Integer getSettleDiff() {
        return settleDiff;
    }

    public void setSettleDiff(Integer settleDiff) {
        this.settleDiff = settleDiff;
    }

    public Integer getSettleState() {
        return settleState;
    }

    public void setSettleState(Integer settleState) {
        this.settleState = settleState;
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
}
