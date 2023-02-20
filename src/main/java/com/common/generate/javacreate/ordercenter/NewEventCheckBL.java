package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.EventAndSubscriptionDTO;
import com.common.generate.javacreate.ordercenter.dto.EventAndSubscriptionQueryDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/10/10 14:44
 */
@Service
public class NewEventCheckBL {

    public static void main(String[] args) {
        List<String> partnerCodeList = Arrays.asList("Xiedu","Informa","YJP-YJX","YJP-FMS","YJP-WMS","YJP-ERP","YJP-TRD","YJP-TMS");
        for (String partnerCode : partnerCodeList) {
            check(partnerCode);
        }
    }


    public static void check(String partnerCode) {
        List<String> eventDiff  = new ArrayList<>();
        String targetCode = "pre";
        String sourceCode = "release";
        Map<String, List<EventAndSubscriptionDTO>> sourceEventMap = getNewEvent(sourceCode, partnerCode);
        Map<String, List<EventAndSubscriptionDTO>> targetEventMap = getNewEvent(targetCode, partnerCode);
        for (Map.Entry<String, List<EventAndSubscriptionDTO>> entry : targetEventMap.entrySet()) {
            String eventCode = entry.getKey();
            List<EventAndSubscriptionDTO> targetList = entry.getValue();
            List<EventAndSubscriptionDTO> sourceList = sourceEventMap.get(eventCode);

            if (CollectionUtils.isEmpty(sourceList)||targetList.size() != sourceList.size()) {
                eventDiff.add(eventCode);
            }else {
                List<String> targetUrlList = targetList.stream().map(it -> it.getUrl()).collect(Collectors.toList());
                List<String> sourceUrlList = sourceList.stream().map(it -> it.getUrl()).collect(Collectors.toList());
                for (String targetUrl : targetUrlList) {
                    if(!sourceUrlList.contains(targetUrl)){
                        eventDiff.add(eventCode);
                        break;
                    }
                }
            }
        }

        System.out.println(partnerCode + "差异数据：" + JSON.toJSONString(eventDiff));
    }


    public static Map<String, List<EventAndSubscriptionDTO>> getNewEvent(String code, String partnerCode) {
        EventAndSubscriptionQueryDTO queryDTO = new EventAndSubscriptionQueryDTO();
        queryDTO.setPartnerCode(partnerCode);
        queryDTO.setEventType(0);
        queryDTO.setPageSize(500);
        queryDTO.setPageNum(1);
        List<EventAndSubscriptionDTO> subscriptionDTOS = ApiUtil.findEventAndSubscriptionByPartnerCode(code, queryDTO);
        List<EventAndSubscriptionDTO> list = subscriptionDTOS.stream().filter(it -> StringUtils.isNotEmpty(it.getUrl())).collect(Collectors.toList());
        Map<String, List<EventAndSubscriptionDTO>> map = list.stream().collect(Collectors.groupingBy(it -> it.getEventCode()));
        return map;
    }

}
