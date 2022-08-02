package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ability.AbilityCheckResult;
import com.common.generate.javacreate.ordercenter.dto.ability.AbilityDiffDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityManageDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/7/7 17:18
 */
@Service
public class ServiceAbilityBL {


    public static void main(String[] args){

        AbilityCheckResult checkResult = checkAbility("test", "pre");
//        if(CollectionUtils.isNotEmpty(checkResult.getTargetNoExists())){
//            addAbility(checkResult.getTargetNoExists(),"pre");
//        }
    }


    public static AbilityCheckResult checkAbility(String sourceCode,String targetCode){
        List<ServiceAbilityManageDTO> sourceAbilityList = ApiUtil.findPageAblity(sourceCode, new ServiceAbilityQueryDTO());
        List<ServiceAbilityManageDTO> targetAbilityList = ApiUtil.findPageAblity(targetCode, new ServiceAbilityQueryDTO());
        AbilityCheckResult abilityCheckResult = compare(targetAbilityList, sourceAbilityList);
        System.out.println("结果："+JSON.toJSONString(abilityCheckResult));
        return abilityCheckResult;
    }

    /**
     * 比较
     * @param targetEventConsumers
     * @param sourceEventConsumers
     * @return
     */
    private static AbilityCheckResult compare(List<ServiceAbilityManageDTO> targetEventConsumers, List<ServiceAbilityManageDTO> sourceEventConsumers) {

        AbilityCheckResult eventCheckResult =new AbilityCheckResult();
        List<AbilityDiffDTO> diffDTOS = new ArrayList<>();
        List<String> sameConsumerKeys =new ArrayList<>();
        Map<String, List<ServiceAbilityManageDTO>> targetConsumerMap = targetEventConsumers.stream().collect(Collectors.groupingBy(it -> it.getAbilityUrl()));
        Map<String, List<ServiceAbilityManageDTO>> sourceConsumerMap = sourceEventConsumers.stream().collect(Collectors.groupingBy(it -> it.getAbilityUrl()));
        List<ServiceAbilityManageDTO> targetNoExists =new ArrayList<>();
        for (Map.Entry<String, List<ServiceAbilityManageDTO>> entry : sourceConsumerMap.entrySet()) {
            String sourceKey = entry.getKey();
            List<ServiceAbilityManageDTO> sourceConsumerList = entry.getValue();
            List<ServiceAbilityManageDTO> targetConsumerList = targetConsumerMap.get(sourceKey);
            if (sourceConsumerList.size() > 1 || (CollectionUtils.isNotEmpty(targetConsumerList) && targetConsumerList.size() > 1)) {
                sameConsumerKeys.add(entry.getKey());
                continue;
            }
            if(CollectionUtils.isEmpty(targetConsumerList)){
                targetNoExists.addAll(sourceConsumerList);
                continue;
            }
            ServiceAbilityManageDTO sourceConsumer = sourceConsumerList.get(0);
            ServiceAbilityManageDTO targetConsumer = targetConsumerList.get(0);

            if (!ObjectUtils.nullSafeEquals(sourceConsumer.getProxyUrl(), targetConsumer.getProxyUrl())||
                    !ObjectUtils.nullSafeEquals(sourceConsumer.getAbilityName(), targetConsumer.getAbilityName())) {
                AbilityDiffDTO abilityDiffDTO =new AbilityDiffDTO();
                abilityDiffDTO.setSource(sourceConsumer);
                abilityDiffDTO.setTarger(targetConsumer);
                diffDTOS.add(abilityDiffDTO);
            }
        }
        eventCheckResult.setDiffList(diffDTOS);
        eventCheckResult.setSameConsumerKeys(sameConsumerKeys);
        eventCheckResult.setTargetNoExists(targetNoExists);
        return eventCheckResult;
    }

    public static void addAbility(List<ServiceAbilityManageDTO> abilityList, String code) {
        for (ServiceAbilityManageDTO serviceAbilityManageDTO : abilityList) {
            ApiUtil.addAblity(code, serviceAbilityManageDTO);
        }

    }



}
