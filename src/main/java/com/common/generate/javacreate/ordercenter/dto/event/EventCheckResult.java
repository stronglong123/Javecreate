package com.common.generate.javacreate.ordercenter.dto.event;

import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;

/**
 * @author xialei
 * @date 2022/6/29 20:56
 */
public class EventCheckResult {

    /**
     * 存在差异
     */
    private List<EventDiffDTO> diffList;
    /**
     * 目标消费者未设置
     */
    private List<EventConsumerDTO> targetConsumerNoExists;

    /**
     * 来源存在相同key
     */
    private List<String> sameConsumerKeys;

    /**
     * 目标事件不存在
     */
    private List<String> targetEventNoExists;


    private List<String> sameEventCodeList;

    public List<EventDiffDTO> getDiffList() {
        return diffList;
    }

    public void setDiffList(List<EventDiffDTO> diffList) {
        this.diffList = diffList;
    }

    public List<EventConsumerDTO> getTargetConsumerNoExists() {
        return targetConsumerNoExists;
    }

    public void setTargetConsumerNoExists(List<EventConsumerDTO> targetConsumerNoExists) {
        this.targetConsumerNoExists = targetConsumerNoExists;
    }

    public List<String> getSameConsumerKeys() {
        return sameConsumerKeys;
    }

    public void setSameConsumerKeys(List<String> sameConsumerKeys) {
        this.sameConsumerKeys = sameConsumerKeys;
    }

    public List<String> getTargetEventNoExists() {
        return targetEventNoExists;
    }

    public void setTargetEventNoExists(List<String> targetEventNoExists) {
        this.targetEventNoExists = targetEventNoExists;
    }

    public List<String> getSameEventCodeList() {
        return sameEventCodeList;
    }

    public void setSameEventCodeList(List<String> sameEventCodeList) {
        this.sameEventCodeList = sameEventCodeList;
    }
}
