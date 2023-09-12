package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.util.Map;
import java.util.Set;

/**
 * @ClassName OrderOtherBO
 * @Description oms给crm的额外字段
 * @Author hhw
 * @Date 2022/5/11 13:58
 * @Version 1.0
 **/
@ApiModel(description = "oms给crm的额外字段模型")
public class OrderOtherBO {
    @ApiParam(description = "no")
    private String sourceOrderNo;
    /**
     * 订单批次ID.
     */
    @ApiParam(description = "订单批次ID")
    private Long orderBatchId;
    /**
     * 邮政编码.
     */
    @ApiParam(description = "邮政编码")
    private String zipCode;
    /**
     * 是否测试订单
     */
    @ApiParam(description = "是否测试订单")
    private Boolean isTestOrder;
    /**
     * 下单APP版本号.
     */
    @ApiParam(description = "下单APP版本号")
    private String appVersion;
    /**
     * 下单设备序列号.
     */
    @ApiParam(description = "下单设备序列号")
    private String deviceSequence;
    /**
     * 订单来源.
     */
    @ApiParam(description = "订单来源")
    private Integer orderSource;
    /**
     * 渠道类型。
     */
    @ApiParam(description = "渠道类型")
    private Integer channelType;
    /**
     * 会员等级.
     */
    @ApiParam(description = "会员等级")
    private Integer bizUserLevel;
    /**
     * 会员来源.
     */
    @ApiParam(description = "会员来源")
    private Integer userSource;
    /**
     * 使用的红包ID
     */
    @ApiParam(description = "使用的红包ID")
    private Set<Long> useBonusIds;
    /**
     * 使用的优惠券ID
     */
    @ApiParam(description = "使用的优惠券ID")
    private Set<Long> useCouponIds;
    /**
     * 使用的优惠码ID.
     */
    @ApiParam(description = "使用的优惠码ID")
    private Long useCouponCodeId;
    /**
     * 拒绝原因
     */
    @ApiParam(description = "拒绝原因")
    private String refuseReason;

    @ApiParam(description = "透传字段")
    private Map<String, Object> transferFields;

    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    public Long getOrderBatchId() {
        return orderBatchId;
    }

    public void setOrderBatchId(Long orderBatchId) {
        this.orderBatchId = orderBatchId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getTestOrder() {
        return isTestOrder;
    }

    public void setTestOrder(Boolean testOrder) {
        isTestOrder = testOrder;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceSequence() {
        return deviceSequence;
    }

    public void setDeviceSequence(String deviceSequence) {
        this.deviceSequence = deviceSequence;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getBizUserLevel() {
        return bizUserLevel;
    }

    public void setBizUserLevel(Integer bizUserLevel) {
        this.bizUserLevel = bizUserLevel;
    }

    public Integer getUserSource() {
        return userSource;
    }

    public void setUserSource(Integer userSource) {
        this.userSource = userSource;
    }

    public Set<Long> getUseBonusIds() {
        return useBonusIds;
    }

    public void setUseBonusIds(Set<Long> useBonusIds) {
        this.useBonusIds = useBonusIds;
    }

    public Set<Long> getUseCouponIds() {
        return useCouponIds;
    }

    public void setUseCouponIds(Set<Long> useCouponIds) {
        this.useCouponIds = useCouponIds;
    }

    public Long getUseCouponCodeId() {
        return useCouponCodeId;
    }

    public void setUseCouponCodeId(Long useCouponCodeId) {
        this.useCouponCodeId = useCouponCodeId;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Map<String, Object> getTransferFields() {
        return transferFields;
    }

    public void setTransferFields(Map<String, Object> transferFields) {
        this.transferFields = transferFields;
    }
}
