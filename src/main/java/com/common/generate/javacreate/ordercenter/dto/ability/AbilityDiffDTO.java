package com.common.generate.javacreate.ordercenter.dto.ability;

/**
 * @author xialei
 * @date 2022/6/29 18:19
 */
public class AbilityDiffDTO {

    private ServiceAbilityManageDTO targer;


    private ServiceAbilityManageDTO source;

    public ServiceAbilityManageDTO getTarger() {
        return targer;
    }

    public void setTarger(ServiceAbilityManageDTO targer) {
        this.targer = targer;
    }

    public ServiceAbilityManageDTO getSource() {
        return source;
    }

    public void setSource(ServiceAbilityManageDTO source) {
        this.source = source;
    }
}
