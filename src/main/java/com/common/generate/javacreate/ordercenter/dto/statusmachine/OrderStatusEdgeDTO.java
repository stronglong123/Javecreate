package com.common.generate.javacreate.ordercenter.dto.statusmachine;

import java.io.Serializable;
import java.util.List;

/**
 * 订单状态拓扑图 - 边
 *
 * @author Hu Liangzhi
 */
public class OrderStatusEdgeDTO implements Serializable {
    private static final long serialVersionUID = 9162414509527908682L;

    /**
     * 开始节点
     */
    private String from;

    /**
     * 状态开始节点
     */
    private Integer fromStatus;

    /**
     * 结束节点
     */
    private String to;

    /**
     * 状态结束节点
     */
    private Integer toStatus;

    /**
     * 节点名 --服务能力名集合
     */
    private List<String> abilityLabelList;

    /**
     * 节点id 服务能力id
     */
    private List<Long> abilityIdList;

    /**
     * 备注
     */
    private String remark;

    /**
     * 优先度
     */
    private Integer priority;

    /**
     * 脚本描述
     */
    private String expressionDesc;

    /**
     * 脚本
     */
    private String expression;

    /**
     * 错误信息提示
     */
    private String failureMessage;

    /**
     * 触发spi实现集合
     */
    private List<Long> spiProviderIds;

    /**
     * 节点名 --服务能力名集合
     */
    private List<String> spiProviderLabelList;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(Integer fromStatus) {
        this.fromStatus = fromStatus;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getToStatus() {
        return toStatus;
    }

    public void setToStatus(Integer toStatus) {
        this.toStatus = toStatus;
    }

    public List<String> getAbilityLabelList() {
        return abilityLabelList;
    }

    public void setAbilityLabelList(List<String> abilityLabelList) {
        this.abilityLabelList = abilityLabelList;
    }

    public List<Long> getAbilityIdList() {
        return abilityIdList;
    }

    public void setAbilityIdList(List<Long> abilityIdList) {
        this.abilityIdList = abilityIdList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getExpressionDesc() {
        return expressionDesc;
    }

    public void setExpressionDesc(String expressionDesc) {
        this.expressionDesc = expressionDesc;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public List<Long> getSpiProviderIds() {
        return spiProviderIds;
    }

    public void setSpiProviderIds(List<Long> spiProviderIds) {
        this.spiProviderIds = spiProviderIds;
    }

    public List<String> getSpiProviderLabelList() {
        return spiProviderLabelList;
    }

    public void setSpiProviderLabelList(List<String> spiProviderLabelList) {
        this.spiProviderLabelList = spiProviderLabelList;
    }
}