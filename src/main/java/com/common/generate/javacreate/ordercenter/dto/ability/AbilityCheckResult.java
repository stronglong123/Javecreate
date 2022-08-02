package com.common.generate.javacreate.ordercenter.dto.ability;

import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventDiffDTO;

import java.util.List;

/**
 * @author xialei
 * @date 2022/6/29 20:56
 */
public class AbilityCheckResult {

    /**
     * 存在差异
     */
    private List<AbilityDiffDTO> diffList;
    /**
     * 目标消费者未设置
     */
    private List<ServiceAbilityManageDTO> targetNoExists;

    /**
     * 来源存在相同key
     */
    private List<String> sameConsumerKeys;

    public List<AbilityDiffDTO> getDiffList() {
        return diffList;
    }

    public void setDiffList(List<AbilityDiffDTO> diffList) {
        this.diffList = diffList;
    }

    public List<ServiceAbilityManageDTO> getTargetNoExists() {
        return targetNoExists;
    }

    public void setTargetNoExists(List<ServiceAbilityManageDTO> targetNoExists) {
        this.targetNoExists = targetNoExists;
    }

    public List<String> getSameConsumerKeys() {
        return sameConsumerKeys;
    }

    public void setSameConsumerKeys(List<String> sameConsumerKeys) {
        this.sameConsumerKeys = sameConsumerKeys;
    }
}
