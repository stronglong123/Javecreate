package com.common.generate.javacreate.ordercenter.dto;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * erp调拨单
 *
 * @author xialei
 * @date 2021-12-29
 */

@ApiModel(description = "调拨单新增模型")
public class ERPTransferOrderDTO implements Serializable {

    private static final long serialVersionUID = 2691461714798297154L;

    /**
     * 发货城市ID
     */
    @ApiParam(description = "发货城市ID", required = true)
    private Long fromOrgId;

    /**
     * 发货仓库id
     */
    @ApiParam(description = "发货仓库ID", required = true)
    private Long fromWarehouseId;

    /**
     * 调拨单号
     */
    @ApiParam(description = "调拨单号", required = true)
    private String businessNo;

    /**
     * 调拨单id
     */
    @ApiParam(description = "调拨单ID", required = true)
    private String businessId;

    /**
     * 创建日期
     */
    @ApiParam(description = "创建日期")
    private Date orderCreateTime;


    /**
     * 收货城市id
     */
    @ApiParam(description = "收货城市ID", required = true)
    private Long orgId;

    /**
     * 收货仓库id
     */
    @ApiParam(description = "收货仓库ID", required = true)
    private Long warehouseId;
    /**
     * 收货人
     */
    @ApiParam(description = "收货人")
    private String contact;

    /**
     * 收货人电话
     */
    @ApiParam(description = "收货人电话")
    private String contactPhone;

    /**
     * 收货人地址
     */
    @ApiParam(description = "收货人地址")
    private String detailAddress;

    /**
     * 发货人
     */
    @ApiParam(description = "发货人")
    private String consignor;

    /**
     * 发货人电话
     */
    @ApiParam(description = "发货人电话")
    private String consignorPhone;

    /**
     * 发货人地址
     */
    @ApiParam(description = "发货人地址")
    private String consignorAddress;

    @ApiParam(description = "调拨单类型:1、仓库调拨；2、内配退")
    private Integer transferType;

    @ApiParam(description = "调拨单明细", required = true)
    private List<ERPTransferOrderItemDTO> items;

    @ApiParam(description = "调拨策略,0批次入驻优先(默认),1自营优先")
    private Integer allocationStrategy;

    public Integer getAllocationStrategy() {
        return allocationStrategy;
    }

    public void setAllocationStrategy(Integer allocationStrategy) {
        this.allocationStrategy = allocationStrategy;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public String getConsignorPhone() {
        return consignorPhone;
    }

    public void setConsignorPhone(String consignorPhone) {
        this.consignorPhone = consignorPhone;
    }

    public String getConsignorAddress() {
        return consignorAddress;
    }

    public void setConsignorAddress(String consignorAddress) {
        this.consignorAddress = consignorAddress;
    }

    public List<ERPTransferOrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ERPTransferOrderItemDTO> items) {
        this.items = items;
    }

    public Long getFromOrgId() {
        return fromOrgId;
    }

    public void setFromOrgId(Long fromOrgId) {
        this.fromOrgId = fromOrgId;
    }

    public Long getFromWarehouseId() {
        return fromWarehouseId;
    }

    public void setFromWarehouseId(Long fromWarehouseId) {
        this.fromWarehouseId = fromWarehouseId;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }
}
