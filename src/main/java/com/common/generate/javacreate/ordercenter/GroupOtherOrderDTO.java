package com.common.generate.javacreate.ordercenter;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2023/3/13 21:56
 */
public class GroupOtherOrderDTO {

    /**
     * 平台编号：110 美团优选，111 多多买菜 112橙心优选(必传)
     */
    private String channelNo;
    /**
     * 城市id(必传)
     */
    private String orgId;
    /**
     * 仓库ID(必传)
     */
    private String warehouseId;

    /**
     * 产品SKU(必传)
     */
    private String productSkuId;
    /**
     * 产品名称(必传)
     */
    private String productName;
    /**
     * 销售数量小单位(必填)
     */
    private BigDecimal inStockCount;


    private BigDecimal outStockCount;
    /**
     * 产品货主(必传)
     */
    private String productOwnerId;

    /**
     * 二级货主id
     */
    private String secOwnerId;

    private Integer type;


    /**
     *  账单数据
     * @return
     */
    private String businessNo;

    private String inBusinessNo;

    private String inOrderId;

    private String inOrderItemId;

    private String orderId;

    private String orderItemId;

    private  String productSaleSpec;

    private String productSpecId;

    private String saleSpecQuantity;

    private String sellUnit;

    private String settleOrderId;

    private Integer needFix;

    public String getInBusinessNo() {
        return inBusinessNo;
    }

    public void setInBusinessNo(String inBusinessNo) {
        this.inBusinessNo = inBusinessNo;
    }

    public String getInOrderId() {
        return inOrderId;
    }

    public void setInOrderId(String inOrderId) {
        this.inOrderId = inOrderId;
    }

    public String getInOrderItemId() {
        return inOrderItemId;
    }

    public void setInOrderItemId(String inOrderItemId) {
        this.inOrderItemId = inOrderItemId;
    }

    public Integer getNeedFix() {
        return needFix;
    }

    public void setNeedFix(Integer needFix) {
        this.needFix = needFix;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(String productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getInStockCount() {
        return inStockCount;
    }

    public void setInStockCount(BigDecimal inStockCount) {
        this.inStockCount = inStockCount;
    }

    public BigDecimal getOutStockCount() {
        return outStockCount;
    }

    public void setOutStockCount(BigDecimal outStockCount) {
        this.outStockCount = outStockCount;
    }

    public String getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(String productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public String getSecOwnerId() {
        return secOwnerId;
    }

    public void setSecOwnerId(String secOwnerId) {
        this.secOwnerId = secOwnerId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getProductSaleSpec() {
        return productSaleSpec;
    }

    public void setProductSaleSpec(String productSaleSpec) {
        this.productSaleSpec = productSaleSpec;
    }

    public String getProductSpecId() {
        return productSpecId;
    }

    public void setProductSpecId(String productSpecId) {
        this.productSpecId = productSpecId;
    }

    public String getSaleSpecQuantity() {
        return saleSpecQuantity;
    }

    public void setSaleSpecQuantity(String saleSpecQuantity) {
        this.saleSpecQuantity = saleSpecQuantity;
    }

    public String getSellUnit() {
        return sellUnit;
    }

    public void setSellUnit(String sellUnit) {
        this.sellUnit = sellUnit;
    }

    public String getSettleOrderId() {
        return settleOrderId;
    }

    public void setSettleOrderId(String settleOrderId) {
        this.settleOrderId = settleOrderId;
    }
}
