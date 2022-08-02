package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.event.EventAndSubSimpleDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventAndSubscriptionResult;
import com.common.generate.javacreate.ordercenter.dto.event.EventCheckResult;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerAndRegisterDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumptionHttpInvokeDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventDiffDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventDiffSubDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventRegisterDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventRegisterPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventSubscriptionDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventSubscriptionPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.SubscribeCheckResult;
import com.common.generate.javacreate.ordercenter.enums.EventConsumptionTypeEnum;
import com.common.generate.javacreate.ordercenter.enums.EventTypeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/6/28 17:52
 */

@Service
public class EventCheckBL {


    public static void main(String[] args) {


//        handle(false, "test", "release");
//        addNotExistsEventCode(false, "test", "release");
//        checkEventSubscription(false, "test", "release");
    }


    /**
     * 指定事件，把source事件订阅关系同步到target
     * @param needUpdate
     * @param sourcecode
     * @param targetcode
     */
    public static void checkEventSubscription(boolean needUpdate, String sourcecode, String targetcode) {
        List<String> eventCodeList = Arrays.asList("TransferorderAdd");

        List<EventAndSubscriptionResult> sourceEventSubList = getEventAndSubscrip(sourcecode, eventCodeList);
        List<EventAndSubscriptionResult> targetEventSubList = getEventAndSubscrip(targetcode, eventCodeList);
        Map<String, EventAndSubscriptionResult> sourceMap = sourceEventSubList.stream().collect(Collectors.toMap(it -> it.getEventCode() + "_" + it.getPartnerCode(), it -> it));
        Map<String, EventAndSubscriptionResult> targetMap = targetEventSubList.stream().collect(Collectors.toMap(it -> it.getEventCode() + "_" + it.getPartnerCode(), it -> it));

        List<EventDiffSubDTO> resultList = new ArrayList<>();

        for (Map.Entry<String, EventAndSubscriptionResult> sourceEntry : sourceMap.entrySet()) {
            EventAndSubscriptionResult sourceResult = sourceEntry.getValue();
            EventAndSubscriptionResult targetResult = targetMap.get(sourceEntry.getKey());
            if (CollectionUtils.isEmpty(sourceResult.getSubscriptionList()) && CollectionUtils.isEmpty(targetResult.getSubscriptionList())) {
                continue;
            }

            if (targetResult == null || CollectionUtils.isEmpty(sourceResult.getSubscriptionList()) || CollectionUtils.isEmpty(targetResult.getSubscriptionList())
                    || sourceResult.getSubscriptionList().size() != targetResult.getSubscriptionList().size()) {
                EventDiffSubDTO eventDiffSub = new EventDiffSubDTO();
                eventDiffSub.setSourceResult(sourceResult);
                eventDiffSub.setTargetResult(targetResult);
                resultList.add(eventDiffSub);
                continue;
            }
        }
        System.out.println("比较事件绑定是否存在差异：" + JSON.toJSONString(resultList));

        if (!needUpdate) {
            return;
        }

        for (EventDiffSubDTO eventDiffSubDTO : resultList) {
            EventAndSubscriptionResult sourceResult = eventDiffSubDTO.getSourceResult();
            EventAndSubscriptionResult targetResult = eventDiffSubDTO.getTargetResult();
            if (CollectionUtils.isEmpty(targetResult.getSubscriptionList())) {
                allNoExists(sourceResult, targetResult, targetcode);
            }

        }

    }


    public static void allNoExists(EventAndSubscriptionResult sourceResult, EventAndSubscriptionResult targetResult, String targetCode) {
        Map<String, EventRegisterDTO> eventMap = getRegisterMap(targetCode);
        List<EventSubscriptionDTO> subscriptionList = sourceResult.getSubscriptionList();

        List<EventSubscriptionDTO> targetSubList = new ArrayList<>();
        for (EventSubscriptionDTO sourceSub : subscriptionList) {
            if (sourceSub.getEventConsumptionType().equals(EventConsumptionTypeEnum.TRIGGER_EVENT.getValue())) {
                EventRegisterDTO bindEvent = eventMap.get(sourceSub.getBindCode());

                EventSubscriptionDTO targetSub = new EventSubscriptionDTO();
                BeanUtils.copyProperties(sourceSub, targetSub);
                targetSub.getEventConsumptionHttpInvokeDTO().setUrl(bindEvent.getId());
                targetSubList.add(targetSub);
            }
        }
        System.out.println("更新结果:" + JSON.toJSONString(targetSubList));
        for (EventSubscriptionDTO eventSubscriptionDTO : targetSubList) {
            ApiUtil.addSub(targetCode,eventSubscriptionDTO);
        }
    }


    public static List<EventAndSubscriptionResult> getEventAndSubscrip(String code, List<String> eventCodeList) {

        List<EventConsumerDTO> consumers = getEventConsumers(code);
        Map<String, EventConsumerDTO> consumerMap = consumers.stream().collect(Collectors.toMap(it -> it.getId(), it -> it));
        List<EventRegisterDTO> eventRegisterList = registerFindPage(code);
//        if (CollectionUtils.isNotEmpty(eventCodeList)) {
//            eventRegisterList = eventRegisterList.stream().filter(it -> eventCodeList.contains(it.getEventCode())).collect(Collectors.toList());
//        }

        List<EventSubscriptionDTO> subscriptionDTOList = findListEventSubscription(code);
        if (CollectionUtils.isNotEmpty(eventCodeList)) {
            subscriptionDTOList = subscriptionDTOList.stream().filter(it -> eventCodeList.contains(it.getSubscribeEventCode())).collect(Collectors.toList());
        }

        Map<String, EventRegisterDTO> eventMap = eventRegisterList.stream().collect(Collectors.toMap(it -> it.getId(), it -> it));

        List<EventSubscriptionDTO> notextSubLList = new ArrayList<>();

        List<EventSubscriptionDTO> detailList = new ArrayList<>();
        for (EventSubscriptionDTO eventSubscriptionDTO : subscriptionDTOList) {
            EventSubscriptionDTO eventSubscriptionDetail = ApiUtil.getByIdEventSubscription(code, eventSubscriptionDTO.getId());
            if (eventSubscriptionDetail.getEventConsumptionHttpInvokeDTO() == null) {
                System.out.println("不存在http绑定：" + eventSubscriptionDTO.getSubscribePartnerCode() + "_" + eventSubscriptionDTO.getSubscribeEventCode());
                notextSubLList.add(eventSubscriptionDTO);
                continue;
            }
            String url = eventSubscriptionDetail.getEventConsumptionHttpInvokeDTO().getUrl();
            if (eventSubscriptionDetail.getEventConsumptionType().equals(EventConsumptionTypeEnum.EVENT_CONSUMER.getValue())
                    || eventSubscriptionDetail.getEventConsumptionType().equals(EventConsumptionTypeEnum.INNER_EVENT_CONSUMER.getValue())) {
                EventConsumerDTO eventConsumer = consumerMap.get(url);
                if (eventConsumer != null) {
                    eventSubscriptionDetail.setBindId(eventConsumer.getId());
                    eventSubscriptionDetail.setBindCode("消费者");
                    eventSubscriptionDetail.setBindName(eventConsumer.getConsumerName());
                    eventSubscriptionDetail.setBindPartnerCode(eventConsumer.getPartnerCode());
                }
            } else if (eventSubscriptionDetail.getEventConsumptionType().equals(EventConsumptionTypeEnum.TRIGGER_EVENT.getValue())) {
                EventRegisterDTO eventRegisterDTO = eventMap.get(url);
                if (eventRegisterDTO != null) {
                    eventSubscriptionDetail.setBindId(eventRegisterDTO.getId());
                    eventSubscriptionDetail.setBindCode(eventRegisterDTO.getEventCode());
                    eventSubscriptionDetail.setBindName(eventRegisterDTO.getEventName());
                    eventSubscriptionDetail.setBindPartnerCode(eventRegisterDTO.getPartnerCode());
                }
            }
            detailList.add(eventSubscriptionDetail);
        }

        Map<String, List<EventSubscriptionDTO>> subscriptMap = detailList.stream()
                .collect(Collectors.groupingBy(it -> it.getSubscribePartnerCode() + "_" + it.getSubscribeEventCode()));
        ;
        List<EventAndSubscriptionResult> evetAndSub = buildEventAndSubscriptionResult(eventRegisterList, subscriptMap);

        System.out.println("不存在http绑定集合：" + JSON.toJSONString(notextSubLList));

        return evetAndSub;
    }


    private static List<EventAndSubscriptionResult> buildEventAndSubscriptionResult(List<EventRegisterDTO> eventList, Map<String, List<EventSubscriptionDTO>> subscriptMap) {
        List<EventAndSubscriptionResult> resultList = new ArrayList<>();
        for (EventRegisterDTO event : eventList) {
            EventAndSubscriptionResult result = new EventAndSubscriptionResult();
            result.setPartnerCode(event.getPartnerCode());
            result.setEventCode(event.getEventCode());
            result.setEvnetType(event.getEventRegisterType());
            result.setEventName(event.getEventName());
            result.setEvent(event);
            result.setSubscriptionList(subscriptMap.get(event.getPartnerCode() + "_" + event.getEventCode()));
            resultList.add(result);
        }
        return resultList;
    }


    /**
     * 新增事件
     */
    public static void addNotExistsEventCode(boolean needUpdate, String sourcecode, String targetcode) {
        List<EventRegisterDTO> notExistsList = new ArrayList<>();
        Map<String, EventRegisterDTO> sourceRegisterMap = getRegisterMap(sourcecode);
        Map<String, EventRegisterDTO> targetRegisterMap = getRegisterMap(targetcode);
        for (Map.Entry<String, EventRegisterDTO> entry : sourceRegisterMap.entrySet()) {
            String eventCode = entry.getKey();
            if (targetRegisterMap.get(eventCode) == null) {
                notExistsList.add(entry.getValue());
            }
        }
        System.out.println("不存在事件:" + JSON.toJSONString(notExistsList));
        if (!needUpdate) {
            return;
        }
        for (EventRegisterDTO eventRegisterDTO : notExistsList) {
            ApiUtil.eventAdd(targetcode, eventRegisterDTO);
        }
    }

    public static void handle(boolean needUpdate, String sourceCode, String targerCode) {
        List<EventConsumerDTO> testEventConsumers = getEventConsumers(sourceCode);
        List<EventConsumerDTO> releaseEventConsumers = getEventConsumers(targerCode);
        System.out.println("sourceCode:" + JSON.toJSONString(testEventConsumers));
        System.out.println("targerCode:" + JSON.toJSONString(releaseEventConsumers));

        EventCheckResult checkResult = compare(releaseEventConsumers, testEventConsumers);
        checkEventCodeExists(targerCode, checkResult);
        System.out.println("比较结果:" + JSON.toJSONString(checkResult));
        if (needUpdate) {
            dealCheckResult(sourceCode, targerCode, checkResult);
        }
    }

    private static String getCompanyCode(String partnerCode) {
        if ("Informa".equals(partnerCode)) {
            return "Informa";
        }
        if ("Xiedu".equals(partnerCode)) {
            return "Xiedu";
        }
        return "YJP";
    }

    /**
     * 处理目前消费者未绑定事件
     *
     * @param checkResult
     */
    private static void dealCheckResult(String sourcecode, String targetcode, EventCheckResult checkResult) {
        addEventCode(sourcecode, targetcode, checkResult.getTargetEventNoExists());
        addCustomer(targetcode, checkResult.getTargetConsumerNoExists());
        addSubscribe(sourcecode, targetcode, checkResult.getDiffList());
    }

    private static void addCustomer(String code, List<EventConsumerDTO> eventConsumerDTO) {
        if (CollectionUtils.isEmpty(eventConsumerDTO)) {
            return;
        }
        for (EventConsumerDTO consumerDTO : eventConsumerDTO) {
            consumerDTO.setCompanyCode(getCompanyCode(consumerDTO.getPartnerCode()));
            ApiUtil.consumerAdd(code, consumerDTO);
        }
    }


    /**
     * 销售者订阅新事件
     */
    private static void addSubscribe(String sourceCode, String targetCode, List<EventDiffDTO> eventDiffDTOS) {

        SubscribeCheckResult subscribeCheckResult = checkSubscribe(targetCode, eventDiffDTOS);
        for (EventConsumerAndRegisterDTO consumerAndRegisterDTO : subscribeCheckResult.getEventConsumerAndRegisterDTOS()) {
            ApiUtil.subscribeEvent(targetCode, consumerAndRegisterDTO.getConsumerId(), consumerAndRegisterDTO.getEventRegisterIdList());
        }
    }


    /**
     * 新增事件
     */
    private static void addEventCode(String sourcecode, String targetcode, List<String> notExistEventCode) {
        if (CollectionUtils.isEmpty(notExistEventCode)) {
            return;
        }
        Map<String, EventRegisterDTO> sourceRegisterMap = getRegisterMap(sourcecode);
        for (String code : notExistEventCode) {
            EventRegisterDTO eventRegisterDTO = sourceRegisterMap.get(code);
            ApiUtil.eventAdd(targetcode, eventRegisterDTO);
        }
    }

    /**
     * 校验订阅事件，事件是否在目标环境存在
     */
    private static SubscribeCheckResult checkSubscribe(String code, List<EventDiffDTO> eventDiffDTOS) {
        if (CollectionUtils.isEmpty(eventDiffDTOS)) {
            return null;
        }
        List<EventConsumerAndRegisterDTO> eventConsumerAndRegisterList = new ArrayList<>();
        Map<String, EventRegisterDTO> registerMap = getRegisterMap(code);
        List<String> notExistEventCode = new ArrayList<>();
        for (EventDiffDTO eventDiffDTO : eventDiffDTOS) {
            List<String> eventRegisterIdList = new ArrayList<>();
            List<String> diffCode = getDiffCode(eventDiffDTO.getSourceSubscribedEventCodes(), eventDiffDTO.getTargetSubscribedEventCodes());
            for (String diff : diffCode) {
                EventRegisterDTO eventRegisterDTO = registerMap.get(diff);
                if (eventRegisterDTO != null) {
                    eventRegisterIdList.add(eventRegisterDTO.getId());
                } else {
                    notExistEventCode.add(diff);
                }
            }
            EventConsumerAndRegisterDTO consumerAndRegisterDTO = new EventConsumerAndRegisterDTO();
            consumerAndRegisterDTO.setConsumerId(eventDiffDTO.getConsumerId());
            consumerAndRegisterDTO.setEventRegisterIdList(eventRegisterIdList);
            eventConsumerAndRegisterList.add(consumerAndRegisterDTO);
        }

        SubscribeCheckResult subscribeCheckResult = new SubscribeCheckResult();
        subscribeCheckResult.setNotExistEventCode(notExistEventCode);
        subscribeCheckResult.setEventConsumerAndRegisterDTOS(eventConsumerAndRegisterList);

        System.out.println("检查结果：" + JSON.toJSONString(subscribeCheckResult));
        return subscribeCheckResult;
    }

    /**
     * 比较不同
     */
    private static List<String> getDiffCode(String sourceCode, String targetCode) {
        if (StringUtils.isEmpty(sourceCode) || sourceCode.equals("无")) {
            return Collections.emptyList();
        }
        String[] split = sourceCode.split(",");
        List<String> sourceCodeList = Arrays.asList(split);

        if (StringUtils.isEmpty(targetCode) || targetCode.equals("无")) {
            return sourceCodeList;
        }
        String[] split2 = targetCode.split(",");
        List<String> targetCodeList = Arrays.asList(split2);

        List<String> diffCodeList = new ArrayList<>();
        for (String code : sourceCodeList) {
            if (!targetCodeList.contains(code)) {
                diffCodeList.add(code);
            }
        }
        return diffCodeList;
    }


    private static Map<String, EventRegisterDTO> getRegisterMap(String code) {
        List<EventRegisterDTO> eventList = getEventList(code);
        Map<String, EventRegisterDTO> registerDTOMap = eventList.stream().collect(Collectors.toMap(EventRegisterDTO::getEventCode, it -> it));
        return registerDTOMap;
    }


    private static List<EventRegisterDTO> getEventList(String code) {
        EventRegisterPageDTO eventRegisterPageDTO = new EventRegisterPageDTO();
        eventRegisterPageDTO.setPageIndex(1000);
        eventRegisterPageDTO.setPageSize(1);
        List<EventRegisterDTO> eventRegisterDTOS = ApiUtil.registerFindPage(code, eventRegisterPageDTO);
        return eventRegisterDTOS;
    }


    /**
     * 比较
     */
    private static EventCheckResult compare(List<EventConsumerDTO> targetEventConsumers, List<EventConsumerDTO> sourceEventConsumers) {

        EventCheckResult eventCheckResult = new EventCheckResult();
        List<EventDiffDTO> diffDTOS = new ArrayList<>();
        List<String> sameConsumerKeys = new ArrayList<>();
        Map<String, List<EventConsumerDTO>> targetConsumerMap = targetEventConsumers.stream().collect(Collectors.groupingBy(it -> it.getPartnerCode() + "|" + it.getConsumerName()));
        Map<String, List<EventConsumerDTO>> sourceConsumerMap = sourceEventConsumers.stream().collect(Collectors.groupingBy(it -> it.getPartnerCode() + "|" + it.getConsumerName()));
        List<EventConsumerDTO> targetNoExists = new ArrayList<>();
        for (Map.Entry<String, List<EventConsumerDTO>> entry : sourceConsumerMap.entrySet()) {
            String sourceKey = entry.getKey();
            List<EventConsumerDTO> sourceConsumerList = entry.getValue();
            List<EventConsumerDTO> targetConsumerList = targetConsumerMap.get(sourceKey);
            if (sourceConsumerList.size() > 1 || (CollectionUtils.isNotEmpty(targetConsumerList) && targetConsumerList.size() > 1)) {
                sameConsumerKeys.add(entry.getKey());
                continue;
            }
            if (CollectionUtils.isEmpty(targetConsumerList)) {
                targetNoExists.addAll(sourceConsumerList);
                continue;
            }
            EventConsumerDTO sourceConsumer = sourceConsumerList.get(0);
            EventConsumerDTO targetConsumer = targetConsumerList.get(0);

            if (!checkSubscribedEventCodes(sourceConsumer.getSubscribedEventCodes(), targetConsumer.getSubscribedEventCodes())) {
                EventDiffDTO eventDiffDTO = new EventDiffDTO();
                eventDiffDTO.setConsumerId(targetConsumer.getId());
                eventDiffDTO.setPartnerCode(targetConsumer.getPartnerCode());
                eventDiffDTO.setConsumerName(targetConsumer.getConsumerName());
                eventDiffDTO.setEnable(targetConsumer.getEnable());
                eventDiffDTO.setSourceSubscribedEventCodes(sourceConsumer.getSubscribedEventCodes());
                eventDiffDTO.setTargetSubscribedEventCodes(targetConsumer.getSubscribedEventCodes());
                diffDTOS.add(eventDiffDTO);
            }
        }
        eventCheckResult.setDiffList(diffDTOS);
        eventCheckResult.setSameConsumerKeys(sameConsumerKeys);
        eventCheckResult.setTargetConsumerNoExists(targetNoExists);
        return eventCheckResult;
    }

    private static boolean checkSubscribedEventCodes(String sourceSubscribedEventCodes, String targetSubscribedEventCodes) {
        if (ObjectUtils.nullSafeEquals(sourceSubscribedEventCodes, targetSubscribedEventCodes)) {
            return true;
        }
        if (sourceSubscribedEventCodes.equals("无") || targetSubscribedEventCodes.equals("无")) {
            return false;
        }
        String[] sourceArray = sourceSubscribedEventCodes.split(",");
        List<String> sourceList = Arrays.asList(sourceArray);
        String[] targetArray = targetSubscribedEventCodes.split(",");
        List<String> targetList = Arrays.asList(targetArray);
        if (sourceList.size() != targetList.size()) {
            return false;
        }
        Map<String, String> sourceMap = sourceList.stream().collect(Collectors.toMap(it -> it, it -> it));
        for (String target : targetList) {
            if (sourceMap.get(target) == null) {
                return false;
            }
        }
        return true;
    }


    /**
     * 校验订阅事件，事件是否在目标环境存在
     */
    private static void checkEventCodeExists(String targetCode, EventCheckResult checkResult) {
        List<EventDiffDTO> eventDiffDTOS = checkResult.getDiffList();
        if (CollectionUtils.isEmpty(eventDiffDTOS)) {
            return;
        }
        List<String> eventCodeExsits = new ArrayList<>();
        List<EventRegisterDTO> eventList = getEventList(targetCode);
        Map<String, List<EventRegisterDTO>> eventListMap = eventList.stream().collect(Collectors.groupingBy(it -> it.getEventCode()));
        for (Map.Entry<String, List<EventRegisterDTO>> entry : eventListMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                eventCodeExsits.add(entry.getKey());
            }
        }
        Map<String, EventRegisterDTO> eventMap = eventList.stream().collect(Collectors.toMap(EventRegisterDTO::getEventCode, it -> it));

        List<String> notExistEventCode = new ArrayList<>();
        for (EventDiffDTO eventDiffDTO : eventDiffDTOS) {
            List<String> diffCode = getDiffCode(eventDiffDTO.getSourceSubscribedEventCodes(), eventDiffDTO.getTargetSubscribedEventCodes());
            for (String diff : diffCode) {
                EventRegisterDTO eventRegisterDTO = eventMap.get(diff);
                if (eventRegisterDTO == null) {
                    notExistEventCode.add(diff);
                }
            }
        }
        checkResult.setSameEventCodeList(eventCodeExsits);
        checkResult.setTargetEventNoExists(notExistEventCode);
    }


    /**
     * 获取所有事件消费者
     */
    private static List<EventConsumerDTO> getEventConsumers(String code) {
        List<EventConsumerDTO> eventConsumerList = ApiUtil.consumerFindPage(code, new EventConsumerPageDTO());
        if (CollectionUtils.isEmpty(eventConsumerList)) {
            Collections.emptyList();
        }
        System.out.println(JSON.toJSONString(eventConsumerList));
        return eventConsumerList;
    }


    private static List<EventRegisterDTO> registerFindPage(String code) {
        EventRegisterPageDTO pageDTO = new EventRegisterPageDTO();
        pageDTO.setPageSize(1000);
        pageDTO.setPageIndex(1);
        return ApiUtil.registerFindPage(code, pageDTO);
    }


    private static Map<String, List<EventSubscriptionDTO>> findPageEventSubscription(String code) {
        EventSubscriptionPageDTO page = new EventSubscriptionPageDTO();
        page.setPageIndex(1);
        page.setPageSize(1000);
        List<EventSubscriptionDTO> eventSubscriptionList = ApiUtil.findPageEventSubscription(code, page);
        return eventSubscriptionList.stream()
                .collect(Collectors.groupingBy(it -> it.getSubscribePartnerCode() + "_" + it.getSubscribeEventCode()));
    }


    private static List<EventSubscriptionDTO> findListEventSubscription(String code) {
        EventSubscriptionPageDTO page = new EventSubscriptionPageDTO();
        page.setPageIndex(1);
        page.setPageSize(1000);
        return ApiUtil.findPageEventSubscription(code, page);
    }


    private static String addPreFix(Object params) {
        return JSON.toJSONString(Collections.singletonList(params));
    }
}
