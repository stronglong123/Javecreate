package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/7/10 10:43
 */
public class ThirdOrderCancelDTO implements Serializable {
    /**
     * 城市Id
     */
    private Integer orgId;
    /**
     * 仓库Id
     */
    private Integer warehouseId;
    /**
     * 第三方订单id
     */
    private Long businessId;
    /**
     * 第三方订单号
     */
    private String businessNo;
    /**
     * 操作人id
     */
    private Long userId;

    /**
     * 取消原因
     * @return
     */
    private String cancelReason;
    /**
     * 取消来源 0用户 1后台
     */
    private Integer cancelSource;
    /**
     * 系统编码
     */
    private String sysCode;

    /**
     * 系统参数
     */
    private String sysName;

    private List<Integer> warehouseIds;

    public List<Integer> getWarehouseIds() {
        return warehouseIds;
    }

    public void setWarehouseIds(List<Integer> warehouseIds) {
        this.warehouseIds = warehouseIds;
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

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Integer getCancelSource() {
        return cancelSource;
    }

    public void setCancelSource(Integer cancelSource) {
        this.cancelSource = cancelSource;
    }
}
