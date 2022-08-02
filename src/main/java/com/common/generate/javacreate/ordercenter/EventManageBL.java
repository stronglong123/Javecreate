package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.event.EventAndSubExcelDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventAndSubSimpleDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventAndSubscriptionResult;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerSimple;
import com.common.generate.javacreate.ordercenter.dto.event.EventRegisterDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventRegisterPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventSimple;
import com.common.generate.javacreate.ordercenter.dto.event.EventSubscriptionDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventSubscriptionPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.InEventAndConsumerBindDTO;
import com.common.generate.javacreate.ordercenter.dto.event.OutEventAndInEventDTO;
import com.common.generate.javacreate.ordercenter.dto.event.SubSimple;
import com.common.generate.javacreate.ordercenter.dto.eventrules.EventMatcher;
import com.common.generate.javacreate.ordercenter.enums.EventConsumptionTypeEnum;
import com.common.generate.javacreate.ordercenter.enums.EventTypeEnum;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/7/21 14:39
 */

@Service
public class EventManageBL {

    public static void main(String[] args) {
        EventManageBL eventManageBL = new EventManageBL();
        List<EventAndSubExcelDTO> event = eventManageBL.getEvent();
        List<InEventAndConsumerBindDTO> bindParams = convertInEventAndConsumerBind(event);
        bindInEventAndConsumer(true,"test", bindParams);
        updateConsumers(true,"test");
    }


    public static void updateConsumers(boolean needUpdate,String code) {
        List<EventConsumerDTO> consumers = getEventConsumers(code);
        List<EventConsumerDTO> informaConsumers = consumers.stream().collect(Collectors.toList());

        List<EventConsumerDTO> updateList =new ArrayList<>();
        System.out.println(JSON.toJSONString(informaConsumers));
        for (EventConsumerDTO consumer : consumers) {
            if (consumer.getEventRuleDTO() != null
                    && consumer.getEventRuleDTO().getEventMatchers() != null
                    && CollectionUtils.isNotEmpty(consumer.getEventRuleDTO().getEventMatchers().getEventMatcherList())) {
                continue;
            }
            if(consumer.getSubscribedEventCodes().contains("10002")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 10002)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }else if(consumer.getSubscribedEventCodes().contains("20002")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 20002)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }else if(consumer.getSubscribedEventCodes().contains("20003")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 20003)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }else if(consumer.getSubscribedEventCodes().contains("20006")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 20006)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }else if(consumer.getSubscribedEventCodes().contains("10003")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 10003)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }else if(consumer.getSubscribedEventCodes().contains("10004")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 10004)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }else if(consumer.getSubscribedEventCodes().contains("10005")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 10005)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }else if(consumer.getSubscribedEventCodes().contains("10006")){
                EventMatcher eventMatcher =new EventMatcher();
                eventMatcher.setJsonPath("$.attribute[?(@.secOrderType == 10006)]");
                consumer.getEventRuleDTO().getEventMatchers().setEventMatcherList(Arrays.asList(eventMatcher));
                updateList.add(consumer);
            }
        }
        System.out.println("需要变更消费者:"+JSON.toJSONString(updateList));
        if(CollectionUtils.isEmpty(updateList)){
            return;
        }
        if(!needUpdate){
            return;
        }
        for (EventConsumerDTO eventConsumerDTO : updateList) {
            ApiUtil.updateConsumer(code,eventConsumerDTO);
        }
    }

    private static List<InEventAndConsumerBindDTO> convertInEventAndConsumerBind(List<EventAndSubExcelDTO> eventList) {
        if (CollectionUtils.isEmpty(eventList)) {
            return Collections.emptyList();
        }
        List<InEventAndConsumerBindDTO> inEventBindList = new ArrayList<>();

        for (EventAndSubExcelDTO eventAndSubExcelDTO : eventList) {
            if (ObjectUtils.nullSafeEquals(eventAndSubExcelDTO.getEvnetType(), EventTypeEnum.ORDER_INTERNAL.getValue())
                    && ObjectUtils.nullSafeEquals(eventAndSubExcelDTO.getBindOutEventType(), EventTypeEnum.ORDER_EXTERNAL.getName())
                    && StringUtils.isNotEmpty(eventAndSubExcelDTO.getConsumerName())
                    && !ObjectUtils.nullSafeEquals(eventAndSubExcelDTO.getBindOutPartnerCode(), "Informa")
                    && !ObjectUtils.nullSafeEquals(eventAndSubExcelDTO.getBindOutPartnerCode(), "Xiedu")
            ) {
                InEventAndConsumerBindDTO bind = new InEventAndConsumerBindDTO();
                bind.setEventId(eventAndSubExcelDTO.getEventId());
                bind.setPartnerCode(eventAndSubExcelDTO.getPartnerCode());
                bind.setEventCode(eventAndSubExcelDTO.getEventCode());
                bind.setEventName(eventAndSubExcelDTO.getEventName());
                bind.setConsumerId(eventAndSubExcelDTO.getConsumerId());
                bind.setConsumerPartnerCode(eventAndSubExcelDTO.getConsumerPartnerCode());
                bind.setConsumerName(eventAndSubExcelDTO.getConsumerName());
                bind.setConsumerSubscribedEventCodes(eventAndSubExcelDTO.getConsumerSubscribedEventCodes());
                inEventBindList.add(bind);
            }
        }
        return inEventBindList;
    }


    public static void bindInEventAndConsumer(boolean needUpdate,String code, List<InEventAndConsumerBindDTO> bindDTOS) {
        if (CollectionUtils.isEmpty(bindDTOS)) {
            return;
        }
        System.out.println("消费者订阅的内部事件："+JSON.toJSONString(bindDTOS));
        if(!needUpdate){
            return;
        }
        bindDTOS = bindDTOS.stream().filter(it -> !it.getConsumerSubscribedEventCodes().contains(it.getEventCode())).collect(Collectors.toList());
        System.out.println("需要订阅的消费者："+JSON.toJSONString(bindDTOS));

        for (InEventAndConsumerBindDTO bindDTO : bindDTOS) {
            ApiUtil.subscribeEvent(code, bindDTO.getConsumerId(), Collections.singletonList(bindDTO.getEventId()));
        }
    }


    public List<EventAndSubExcelDTO> getEvent() {
        String code = "test";
        List<EventRegisterDTO> eventRegisterList = registerFindPage(code);
        EventSubscriptionPageDTO page = new EventSubscriptionPageDTO();
        page.setPageIndex(1);
        page.setPageSize(1000);
        List<EventSubscriptionDTO> eventSubscriptionList = ApiUtil.findPageEventSubscription(code, page);
        Map<String, List<EventSubscriptionDTO>> subscriptMap = eventSubscriptionList.stream()
                .collect(Collectors.groupingBy(it -> it.getSubscribePartnerCode() + "_" + it.getSubscribeEventCode()));
        List<EventConsumerDTO> consumers = getEventConsumers(code);
        Map<String, EventConsumerDTO> consumerMap = consumers.stream().collect(Collectors.toMap(it -> it.getId(), it -> it));
        Map<String, EventRegisterDTO> eventMap = eventRegisterList.stream().collect(Collectors.toMap(it -> it.getId(), it -> it));

        List<EventAndSubSimpleDTO> eventAndSubSimpleDTOS = getSimple(eventRegisterList, subscriptMap, false);
        List<EventAndSubSimpleDTO> andSubSimpleDTOList = eventAndSubSimpleDTOS.stream().filter(it -> it.getEvnetType() != null).sorted(Comparator.comparing(it -> it.getEvnetType())).collect(Collectors.toList());
        List<EventAndSubExcelDTO> result = buildEventAndSubExcel(code, andSubSimpleDTOList, consumerMap, eventMap);
        return result;
    }


    private static List<EventAndSubExcelDTO> buildEventAndSubExcel(String code, List<EventAndSubSimpleDTO> collect,
                                                                   Map<String, EventConsumerDTO> consumerMap,
                                                                   Map<String, EventRegisterDTO> eventMap) {
        List<EventAndSubExcelDTO> result = new ArrayList<>();
        for (EventAndSubSimpleDTO event : collect) {
            if (CollectionUtils.isEmpty(event.getSubscriptionList())) {
                continue;
            }
            event.getSubscriptionList().forEach(sub -> {
                EventAndSubExcelDTO eventAndSubExcelDTO = new EventAndSubExcelDTO();
                eventAndSubExcelDTO.setEventId(event.getEventId());
                eventAndSubExcelDTO.setPartnerCode(event.getPartnerCode());
                eventAndSubExcelDTO.setEventCode(event.getEventCode());
                eventAndSubExcelDTO.setEventName(event.getEventName());
                eventAndSubExcelDTO.setEvnetType(event.getEvnetType());
                eventAndSubExcelDTO.setEvnetTypeName(EventTypeEnum.getTextEnum(event.getEvnetType()).getName());
                eventAndSubExcelDTO.setSubscribeCompanyCode(sub.getCompanyCode());
                eventAndSubExcelDTO.setSubscribePartnerCode(sub.getPartnerCode());
                eventAndSubExcelDTO.setSubscribeName(sub.getSubscribeName());
                eventAndSubExcelDTO.setSubscribeEventConsumptionType(EventConsumptionTypeEnum.getTextEnum(sub.getEventConsumptionType()).getName());
                EventSubscriptionDTO eventSubscriptionDTO = ApiUtil.getByIdEventSubscription(code, sub.getId());
                String url = eventSubscriptionDTO.getEventConsumptionHttpInvokeDTO().getUrl();
                if (sub.getEventConsumptionType().equals(EventConsumptionTypeEnum.EVENT_CONSUMER.getValue())
                        || sub.getEventConsumptionType().equals(EventConsumptionTypeEnum.INNER_EVENT_CONSUMER.getValue())) {
                    EventConsumerDTO eventConsumer = consumerMap.get(url);
                    if (eventConsumer != null) {
                        eventAndSubExcelDTO.setConsumerId(eventConsumer.getId());
                        eventAndSubExcelDTO.setConsumerCompanyCode(eventConsumer.getCompanyCode());
                        eventAndSubExcelDTO.setConsumerPartnerCode(eventConsumer.getPartnerCode());
                        eventAndSubExcelDTO.setConsumerName(eventConsumer.getConsumerName());
                        eventAndSubExcelDTO.setConsumerSubscribedEventCodes(eventConsumer.getSubscribedEventCodes());
                    }
                } else if (sub.getEventConsumptionType().equals(EventConsumptionTypeEnum.TRIGGER_EVENT.getValue())) {
                    EventRegisterDTO eventRegisterDTO = eventMap.get(url);
                    if (eventRegisterDTO != null) {
                        eventAndSubExcelDTO.setBindOutEvent(eventRegisterDTO.getEventName());
                        eventAndSubExcelDTO.setBindOutEventCode(eventRegisterDTO.getEventCode());
                        eventAndSubExcelDTO.setBindOutPartnerCode(eventRegisterDTO.getPartnerCode());
                        eventAndSubExcelDTO.setBindOutEventType(EventTypeEnum.getTextEnum(eventRegisterDTO.getEventRegisterType()).getName());
                    }
                }
                result.add(eventAndSubExcelDTO);
            });
        }
        List<EventAndSubExcelDTO> excelDTOS = buildOutEventSub(result);
        for (EventAndSubSimpleDTO event : collect) {
            if (CollectionUtils.isEmpty(event.getSubscriptionList())) {
                EventAndSubExcelDTO eventAndSubExcelDTO = new EventAndSubExcelDTO();
                eventAndSubExcelDTO.setEventId(event.getEventId());
                eventAndSubExcelDTO.setPartnerCode(event.getPartnerCode());
                eventAndSubExcelDTO.setEventCode(event.getEventCode());
                eventAndSubExcelDTO.setEventName(event.getEventName());
                eventAndSubExcelDTO.setEvnetType(event.getEvnetType());
                eventAndSubExcelDTO.setEvnetTypeName(EventTypeEnum.getTextEnum(event.getEvnetType()).getName());
                excelDTOS.add(eventAndSubExcelDTO);
            }
        }
        return excelDTOS;
    }


    private static List<EventAndSubExcelDTO> buildOutEventSub(List<EventAndSubExcelDTO> excelList) {
        List<EventAndSubExcelDTO> resultList = new ArrayList<>();
        List<EventAndSubExcelDTO> inExcelList = excelList.stream().filter(it -> it.getEvnetType().equals(EventTypeEnum.ORDER_INTERNAL.getValue())).collect(Collectors.toList());
        List<EventAndSubExcelDTO> outExcelList = excelList.stream().filter(it -> it.getEvnetType().equals(EventTypeEnum.ORDER_EXTERNAL.getValue())).collect(Collectors.toList());
        List<EventAndSubExcelDTO> commonExcelList = excelList.stream().filter(it -> it.getEvnetType().equals(EventTypeEnum.COMMON_EXTERNAL.getValue())).collect(Collectors.toList());
        Map<String, List<EventAndSubExcelDTO>> outMap = outExcelList.stream().collect(Collectors.groupingBy(it -> it.getPartnerCode() + "_" + it.getEventCode()));
        Map<String, List<EventAndSubExcelDTO>> inMap = inExcelList.stream().collect(Collectors.groupingBy(it -> it.getBindOutPartnerCode() + "_" + it.getBindOutEventCode()));

        for (EventAndSubExcelDTO eventAndSubExcelDTO : inExcelList) {
            if (!eventAndSubExcelDTO.getSubscribeEventConsumptionType().equals(EventConsumptionTypeEnum.TRIGGER_EVENT.getName())
                    || StringUtils.isEmpty(eventAndSubExcelDTO.getBindOutEventCode())) {
                resultList.add(eventAndSubExcelDTO);
                continue;
            }
            List<EventAndSubExcelDTO> outEventAndSubExcelDTOS = outMap.get(eventAndSubExcelDTO.getBindOutPartnerCode() + "_" + eventAndSubExcelDTO.getBindOutEventCode());
            if (CollectionUtils.isEmpty(outEventAndSubExcelDTOS)) {
                resultList.add(eventAndSubExcelDTO);
                continue;
            }
            resultList.addAll(convertList(eventAndSubExcelDTO, outEventAndSubExcelDTOS));
        }

        for (EventAndSubExcelDTO outExcel : outExcelList) {
            if (!outExcel.getSubscribeEventConsumptionType().equals(EventConsumptionTypeEnum.EVENT_CONSUMER.getName()) &&
                    !outExcel.getSubscribeEventConsumptionType().equals(EventConsumptionTypeEnum.INNER_EVENT_CONSUMER.getName())) {
                resultList.add(outExcel);
                continue;
            }
            if (CollectionUtils.isEmpty(inMap.get(outExcel.getPartnerCode() + "_" + outExcel.getEventCode()))) {
                resultList.add(outExcel);
            }
        }
        resultList.addAll(commonExcelList);
        return resultList;
    }


    private static List<EventAndSubExcelDTO> convertList(EventAndSubExcelDTO old, List<EventAndSubExcelDTO> outEventAndSubExcelDTOS) {
        List<EventAndSubExcelDTO> result = new ArrayList<>();
        for (EventAndSubExcelDTO excelDTO : outEventAndSubExcelDTOS) {
            if (!excelDTO.getSubscribeEventConsumptionType().equals(EventConsumptionTypeEnum.EVENT_CONSUMER.getName()) &&
                    !excelDTO.getSubscribeEventConsumptionType().equals(EventConsumptionTypeEnum.INNER_EVENT_CONSUMER.getName())) {
                continue;
            }
            EventAndSubExcelDTO newdto = new EventAndSubExcelDTO();
            BeanUtils.copyProperties(old, newdto);
            newdto.setConsumerId(excelDTO.getConsumerId());
            newdto.setConsumerCompanyCode(excelDTO.getConsumerCompanyCode());
            newdto.setConsumerPartnerCode(excelDTO.getConsumerPartnerCode());
            newdto.setConsumerName(excelDTO.getConsumerName());
            newdto.setConsumerSubscribedEventCodes(excelDTO.getConsumerSubscribedEventCodes());
            result.add(newdto);
        }
        return result;
    }


    public static void checkEvnet(String code) {

        List<EventRegisterDTO> eventRegisterList = registerFindPage(code);
        Map<String, List<EventSubscriptionDTO>> subscriptMap = findPageEventSubscription(code);

        /**外部事件*/
        List<EventRegisterDTO> outEventList = eventRegisterList.stream()
                .filter(it -> it.getEventRegisterType() != null && it.getEventRegisterType().equals(10))
                .collect(Collectors.toList());
        /**通用外部事件*/
        List<EventRegisterDTO> commonOutEventList = eventRegisterList.stream()
                .filter(it -> it.getEventRegisterType() != null && it.getEventRegisterType().equals(11))
                .collect(Collectors.toList());
        /**内部事件*/
        List<EventRegisterDTO> inEventList = eventRegisterList.stream()
                .filter(it -> it.getEventRegisterType() != null && it.getEventRegisterType().equals(0))
                .collect(Collectors.toList());

        List<EventRegisterDTO> otherEventList = eventRegisterList.stream()
                .filter(it -> it.getEventRegisterType() == null)
                .collect(Collectors.toList());
//        List<EventAndSubscriptionResult> outResult = compare(outEventList,subscriptMap);
//        List<EventAndSubscriptionResult> commonOutResult = compare(commonOutEventList,subscriptMap);
//        List<EventAndSubscriptionResult> inResult = compare(inEventList,subscriptMap);
//        List<EventAndSubscriptionResult> otherResult = compare(otherEventList,subscriptMap);


        List<EventAndSubSimpleDTO> outResult = getSimple(outEventList, subscriptMap, true);
        List<EventAndSubSimpleDTO> commonOutResult = getSimple(commonOutEventList, subscriptMap, true);
        List<EventAndSubSimpleDTO> inResult = getSimple(inEventList, subscriptMap, true);
        List<EventAndSubSimpleDTO> otherResult = getSimple(otherEventList, subscriptMap, true);

        System.out.println("外部事件:" + JSON.toJSONString(outResult));
        System.out.println("通用外部事件:" + JSON.toJSONString(commonOutResult));
        System.out.println("内部事件:" + JSON.toJSONString(inResult));
        System.out.println("其他事件:" + JSON.toJSONString(otherResult));
    }


    public static void checkInEvent(String code) {
        List<EventRegisterDTO> eventRegisterList = registerFindPage(code);
        Map<String, List<EventSubscriptionDTO>> subscriptMap = findPageEventSubscription(code);
        List<EventConsumerDTO> consumers = getEventConsumers(code);

        Map<String, EventRegisterDTO> eventMap = eventRegisterList.stream().collect(Collectors.toMap(it -> it.getId(), it -> it));

        List<EventRegisterDTO> inEventList = eventRegisterList.stream()
                .filter(it -> it.getEventRegisterType() != null && it.getEventRegisterType().equals(0))
                .collect(Collectors.toList());

        List<OutEventAndInEventDTO> resultList = new ArrayList<>();
        List<EventSimple> hasBindOutEvent = new ArrayList<>();
        List<EventAndSubscriptionResult> inSubscriptionResult = build(inEventList, subscriptMap);
        for (EventAndSubscriptionResult subscriptionResult : inSubscriptionResult) {
            if (CollectionUtils.isEmpty(subscriptionResult.getSubscriptionList())) {
                continue;
            }
            OutEventAndInEventDTO outEventAndInEventDTO = new OutEventAndInEventDTO();
            outEventAndInEventDTO.setInPartnerCode(subscriptionResult.getPartnerCode());
            outEventAndInEventDTO.setInEventCode(subscriptionResult.getEventCode());
            outEventAndInEventDTO.setInEventName(subscriptionResult.getEventName());
            outEventAndInEventDTO.setOutEventList(Lists.newArrayList());
            List<EventSimple> outEvnetList = new ArrayList<>();
            List<EventSubscriptionDTO> outEventSubList = subscriptionResult.getSubscriptionList().stream().filter(it -> it.getEventConsumptionType().equals(4)).collect(Collectors.toList());
            for (EventSubscriptionDTO eventSubscriptionDTO : outEventSubList) {
                EventSubscriptionDTO detail = ApiUtil.getByIdEventSubscription(code, eventSubscriptionDTO.getId());
                String outEventId = detail.getEventConsumptionHttpInvokeDTO().getUrl();
                EventRegisterDTO outEvent = eventMap.get(outEventId);
                EventSimple eventSimple = new EventSimple();
                eventSimple.setPartnerCode(outEvent.getPartnerCode());
                eventSimple.setEventCode(outEvent.getEventCode());
                eventSimple.setEventName(outEvent.getEventName());
                eventSimple.setEvnetType(outEvent.getEventRegisterType());
                eventSimple.setEvnetTypeName(EventTypeEnum.getTextEnum(outEvent.getEventRegisterType()).getName());
                outEvnetList.add(eventSimple);
                hasBindOutEvent.add(eventSimple);
            }
            outEventAndInEventDTO.setOutEventList(outEvnetList);
            resultList.add(outEventAndInEventDTO);
        }
        System.out.println("内部事件与外部事件绑定关系:" + JSON.toJSONString(resultList));


        List<EventRegisterDTO> noBindOutEventList = new ArrayList<>();
        List<EventRegisterDTO> outAllEventList = eventRegisterList.stream()
                .filter(it -> it.getEventRegisterType() != null && it.getEventRegisterType().equals(EventTypeEnum.ORDER_EXTERNAL.getValue()))
                .collect(Collectors.toList());
        Map<String, EventSimple> hasBindEventMap = hasBindOutEvent.stream().collect(Collectors.toMap(it -> it.getEventCode() + "_" + it.getPartnerCode(), it -> it, (t1, t2) -> t1));
        for (EventRegisterDTO outEvent : outAllEventList) {
            if (hasBindEventMap.get(outEvent.getEventCode() + "_" + outEvent.getPartnerCode()) == null) {
                noBindOutEventList.add(outEvent);
            }
        }
        List<EventSimple> noBindEventSimples = buildEvenSimple(noBindOutEventList);
        System.out.println("未绑定内部事件的事件:" + JSON.toJSONString(noBindEventSimples));

        Map<String, EventRegisterDTO> noBindOutEventMap = noBindOutEventList.stream().collect(Collectors.toMap(it -> it.getEventCode() + "_" + it.getPartnerCode(), it -> it));

        /**是否存在相同事件code*/

        checkSameCodeEvent(eventRegisterList);

        List<EventConsumerSimple> consumerSimpleList = new ArrayList<>();
        Map<String, EventRegisterDTO> eventmap = eventRegisterList.stream().collect(Collectors.toMap(it -> it.getEventCode(), it -> it));
        for (EventConsumerDTO consumer : consumers) {
            if (StringUtils.isEmpty(consumer.getSubscribedEventCodes())) {
                continue;
            }
            EventConsumerSimple consumerSimple = new EventConsumerSimple();
            consumerSimple.setPartnerCode(consumer.getPartnerCode());
            consumerSimple.setConsumerName(consumer.getConsumerName());
            consumerSimple.setSubscribedEventCodes(consumer.getSubscribedEventCodes());

            List<String> hasBindEvent = new ArrayList<>();
            List<String> noBindEvent = new ArrayList<>();
            if (StringUtils.isNotEmpty(consumer.getSubscribedEventCodes())) {
                String subscribedEventCodes = consumer.getSubscribedEventCodes();
                String[] split = subscribedEventCodes.split(",");
                List<String> consumerEventCodeList = Arrays.asList(split);
                for (String eventCode : consumerEventCodeList) {
                    EventRegisterDTO eventRegisterDTO = eventmap.get(eventCode);
                    if (eventRegisterDTO == null) {
                        System.out.println("事件code不存在：" + eventCode);
                        continue;
                    }
                    EventSimple hasBind = hasBindEventMap.get(eventRegisterDTO.getEventCode() + "_" + eventRegisterDTO.getPartnerCode());
                    EventRegisterDTO noBind = noBindOutEventMap.get(eventRegisterDTO.getEventCode() + "_" + eventRegisterDTO.getPartnerCode());
                    if (hasBind != null) {
                        hasBindEvent.add(hasBind.getEventCode());
                    }
                    if (noBind != null) {
                        noBindEvent.add(noBind.getEventCode());
                    }
                }
            }
            consumerSimple.setHasBindEvent(hasBindEvent);
            consumerSimple.setNoBindEvent(noBindEvent);
            consumerSimpleList.add(consumerSimple);
        }
        List<EventConsumerSimple> noEventConsumers = consumerSimpleList.stream().filter(it -> isEmpty(it.getSubscribedEventCodes())).collect(Collectors.toList());
        List<EventConsumerSimple> inBindConsumers = consumerSimpleList.stream().filter(it -> !isEmpty(it.getSubscribedEventCodes()) && CollectionUtils.isEmpty(it.getNoBindEvent())).collect(Collectors.toList());
        List<EventConsumerSimple> outBindConsumers = consumerSimpleList.stream().filter(it -> !isEmpty(it.getSubscribedEventCodes()) && CollectionUtils.isNotEmpty(it.getNoBindEvent())).collect(Collectors.toList());
        System.out.println("没绑定的消费者：" + JSON.toJSONString(noEventConsumers));
        System.out.println("消费者绑定的事件没有绑定内部事件：" + JSON.toJSONString(outBindConsumers));
        System.out.println("消费者绑定的事件有内部事件:" + JSON.toJSONString(inBindConsumers));
    }

    private static boolean isEmpty(String param) {
        if (StringUtils.isEmpty(param) || "无".equals(param)) {
            return true;
        }
        return false;
    }


    private static void checkSameCodeEvent(List<EventRegisterDTO> eventRegisterList) {
        List<String> sameEventCodeList = new ArrayList<>();
        Map<String, List<EventRegisterDTO>> eventCodeMap = eventRegisterList.stream().collect(Collectors.groupingBy(it -> it.getEventCode()));

        for (Map.Entry<String, List<EventRegisterDTO>> entry : eventCodeMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                sameEventCodeList.add(entry.getKey());
            }
        }
        System.out.println("存在相同事件code" + JSON.toJSONString(sameEventCodeList));
    }

    private static List<EventSimple> buildEvenSimple(List<EventRegisterDTO> eventRegisterList) {
        List<EventSimple> eventSimples = new ArrayList<>();
        for (EventRegisterDTO eventRegisterDTO : eventRegisterList) {
            EventSimple eventSimple = new EventSimple();
            eventSimple.setPartnerCode(eventRegisterDTO.getPartnerCode());
            eventSimple.setEventCode(eventRegisterDTO.getEventCode());
            eventSimple.setEventName(eventRegisterDTO.getEventName());
            eventSimple.setEvnetType(eventRegisterDTO.getEventRegisterType());
            eventSimple.setEvnetTypeName(EventTypeEnum.getTextEnum(eventRegisterDTO.getEventRegisterType()).getName());
            eventSimples.add(eventSimple);
        }
        return eventSimples;
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


    private static List<EventAndSubSimpleDTO> getSimple(List<EventRegisterDTO> eventList, Map<String, List<EventSubscriptionDTO>> subscriptMap, boolean hasSub) {
        List<EventAndSubSimpleDTO> resultList = new ArrayList<>();
        for (EventRegisterDTO event : eventList) {
            EventAndSubSimpleDTO result = new EventAndSubSimpleDTO();
            result.setEventId(event.getId());
            result.setPartnerCode(event.getPartnerCode());
            result.setEventCode(event.getEventCode());
            result.setEvnetType(event.getEventRegisterType());
            result.setEventName(event.getEventName());
            List<SubSimple> subSimpleList = new ArrayList<>();

            List<EventSubscriptionDTO> eventSubscriptionDTOS = subscriptMap.get(event.getPartnerCode() + "_" + event.getEventCode());
            if (CollectionUtils.isEmpty(eventSubscriptionDTOS)) {
                if (!hasSub) {
                    resultList.add(result);
                }
                continue;
            }
            for (EventSubscriptionDTO eventSubscriptionDTO : eventSubscriptionDTOS) {
                SubSimple subSimple = new SubSimple();
                subSimple.setId(eventSubscriptionDTO.getId());
                subSimple.setCompanyCode(eventSubscriptionDTO.getCompanyCode());
                subSimple.setPartnerCode(eventSubscriptionDTO.getPartnerCode());
                subSimple.setSubscribeName(eventSubscriptionDTO.getSubscribeName());
                subSimple.setEventConsumptionType(eventSubscriptionDTO.getEventConsumptionType());
                subSimpleList.add(subSimple);
            }
            result.setSubscriptionList(subSimpleList);
            resultList.add(result);
        }
        return resultList;
    }


    private static List<EventAndSubscriptionResult> build(List<EventRegisterDTO> eventList, Map<String, List<EventSubscriptionDTO>> subscriptMap) {
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
     * 获取所有事件消费者
     *
     * @return
     */
    private static List<EventConsumerDTO> getEventConsumers(String code) {
        List<EventConsumerDTO> eventConsumerList = ApiUtil.consumerFindPage(code, new EventConsumerPageDTO());
        if (com.alibaba.dubbo.common.utils.CollectionUtils.isEmpty(eventConsumerList)) {
            Collections.emptyList();
        }
        return eventConsumerList;
    }


    private static List<InEventAndConsumerBindDTO> getBindParams(){
        String json ="[\n" +
                "    {\n" +
                "        \"consumerName\": \"英富曼退货单待审核（CRM）\",\n" +
                "        \"consumerPartnerCode\": \"Informa\",\n" +
                "        \"eventCode\": \"ReturnOrderAdd\",\n" +
                "        \"eventId\": \"62d133d59f875300012be196\",\n" +
                "        \"eventName\": \"退货单下单\",\n" +
                "        \"partnerCode\": \"SELF\"\n" +
                "    }]";

        List<InEventAndConsumerBindDTO> inEventAndConsumerBindDTOS = JSON.parseArray(json, InEventAndConsumerBindDTO.class);
        return inEventAndConsumerBindDTOS;
    }

}
