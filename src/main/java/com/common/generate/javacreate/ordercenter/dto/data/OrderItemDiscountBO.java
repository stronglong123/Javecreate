package com.common.generate.javacreate.ordercenter.dto.data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderItemDiscountBO
 * @Description oms订单项优惠信息
 * @Author hhw
 * @Date 2022/5/11 13:42
 * @Version 1.0
 **/
public class OrderItemDiscountBO {

    /**
     * 主键
     */
    private Long id;

    /**
     * orders表主键
     */
    private Long orderId;

    /**
     * orderitem表主键
     */
    private Long orderItemId;

    /**
     * jiupiorder表主键
     */
    private Long jiupiOrderId;

    /**
     * jiupiorderitem表主键
     */
    private Long jiupiOrderItemId;

    /**
     * 优惠金额
     */
    private BigDecimal amount;

    /**
     * 优惠来源
     */
    private Integer sourceType;

    /**
     * 优惠来源ID
     */
    private Long sourceId;

    /**
     * 优惠分类
     */
    private Integer classify;

    /**
     * 修改时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer createUserId;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    private Integer lastUpdateUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getJiupiOrderId() {
        return jiupiOrderId;
    }

    public void setJiupiOrderId(Long jiupiOrderId) {
        this.jiupiOrderId = jiupiOrderId;
    }

    public Long getJiupiOrderItemId() {
        return jiupiOrderItemId;
    }

    public void setJiupiOrderItemId(Long jiupiOrderItemId) {
        this.jiupiOrderItemId = jiupiOrderItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }
}

