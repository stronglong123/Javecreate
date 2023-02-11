package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.PageableResult;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.ordercenter.dto.EventAndSubscriptionDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderTraceConfigDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityManageDTO;
import com.common.generate.javacreate.ordercenter.dto.ability.ServiceAbilityQueryDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventConsumerRegisterDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventRegisterDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventRegisterPageDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventSubscriptionDTO;
import com.common.generate.javacreate.ordercenter.dto.event.EventSubscriptionPageDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventConsumptionAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.ordercenter.dto.statusmachine.OrderStatusGraphDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.HttpClientUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xialei
 * @date 2022/7/7 17:19
 */
public class ApiUtil {

    private static final String testToken = "4684ab57-a97d-4eeb-a7cc-a62e40416428";

    private static final String relesaeToken = "d74314bf-b0da-423a-996e-774492d5cf57";

    private static final String preToken = "c0a74503-376b-45b1-a33e-899bc0cc1d5a";

    private static final String testUrl = "http://ocop.test.yijiupidev.com/";

    private static final String releaseUrl = "http://ocop.release.yijiupidev.com/";

    private static final String preUrl = "http://ocop.pre.yijiupi.com/";

    private static final String findPageAblity = "/ordercenter/ordercenter-ability-managerms/ServiceAbilityManageService/findPageByCondition";

    private static final String addAblity = "/ordercenter/ordercenter-ability-managerms/ServiceAbilityManageService/add";

    private static final String consumerFindPage = "ordercenter/ordercenter-event-managerms/EventConsumerQueryService/findPage";

    private static final String registerFindPage = "ordercenter/ordercenter-event-managerms/EventRegisterQueryService/findPage";

    private static final String subscribeEvent = "ordercenter/ordercenter-event-managerms/EventConsumerManageService/subscribeEvent";

    private static final String addConsumer = "ordercenter/ordercenter-event-managerms/EventConsumerManageService/add";

    private static final String updateConsumer ="ordercenter/ordercenter-event-managerms/EventConsumerManageService/update";

    private static final String addEvennt ="ordercenter/ordercenter-event-managerms/EventRegisterManageService/add";

    private static final String findEventRegisterList = "ordercenter/ordercenter-event-managerms/EventConsumerQueryService/findEventRegisterList";

    private static final String findPageEventSubscription = "ordercenter/ordercenter-event-managerms/EventSubscriptionQueryService/findPage";

    private static final String getByIdEventSubscription =  "ordercenter/ordercenter-event-managerms/EventSubscriptionQueryService/getById";

    private static final String addSub =  "ordercenter/ordercenter-event-managerms/EventSubscriptionManageService/add";


    private static final String findOrderStatusMachineBySecOrderType ="ordercenter/ordercenter-config-managerms/orderstatus.OrderStatusMachineQueryService/findOrderStatusMachineBySecOrderType";


    private static final String createOrderStatusGraph ="ordercenter/ordercenter-config-managerms/orderstatus.OrderStatusMachineManageService/createOrderStatusGraph";

    private static final String unsubscribeEvent ="ordercenter/ordercenter-event-managerms/EventConsumerManageService/unsubscribeEvent";

    private static final String eventPublishAuditQuery ="ordercenter/ordercenter-event-managerms/EventPublishAuditQueryService/findPage";

    private static final String eventConsumptionAuditQuery ="ordercenter/ordercenter-event-managerms/EventConsumptionAuditQueryService/findPage";

    private static final String publishEventRetry ="ordercenter/ordercenter-event-managerms/action/PublishEventRetryService/retry";

    private static final String repairOriginDiscountAmount = "ordercenter/ordercenter-datasync-servicems/OrderRepairService/repairOriginDiscountAmount";

    private static final String findEventAndSubscriptionByPartnerCode = "ordercenter/ordercenter-event-managerms/EventAndSubscriptionQueryService/findEventAndSubscriptionByPartnerCode";

    private static final String findByPageTraceConfigQuery = "ordercenter/ordercenter-config-managerms/ordertraceconfig.OrderTraceConfigQueryService/findByPage";

    private static final String addOrderTraceConfig = "ordercenter/ordercenter-config-managerms/ordertraceconfig.OrderTraceConfigManageService/add";
    private static final String updateOrderTraceConfig = "ordercenter/ordercenter-config-managerms/ordertraceconfig.OrderTraceConfigManageService/update";

    private static final String findPageByOrderSnapshot ="ordercenter-aggregatequery-servicems/OrderCommonQueryService/findPageByOrderSnapshot";

    /**
     * 消费者查询
     * @return
     */
    public static List<ServiceAbilityManageDTO> findPageAblity(String code, ServiceAbilityQueryDTO queryDTO) {
        queryDTO.setPageSize(200);
        queryDTO.setPageIndex(1);
        String url = getUrl(code) + findPageAblity;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(queryDTO));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<ServiceAbilityManageDTO> resultList = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), ServiceAbilityManageDTO.class);
        return resultList;
    }


    /**
     * 事件新增
     */
    public static void addAblity(String code, ServiceAbilityManageDTO abilityManageDTO){
        String url = getUrl(code) + addAblity;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(abilityManageDTO));
        System.out.println("新增结果:" + resultstr);
    }


    /**
     * 事件新增
     * @param eventRegisterDTO
     */
    public static void eventAdd(String code,EventRegisterDTO eventRegisterDTO){
        String url = getUrl(code) + addEvennt;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(eventRegisterDTO));
        System.out.println("新增结果:" + resultstr);
    }


    /**
     * 消费者查询
     * @param eventConsumerPageDTO
     * @return
     */
    public static List<EventConsumerDTO> consumerFindPage(String code, EventConsumerPageDTO eventConsumerPageDTO) {
        eventConsumerPageDTO.setPageSize(1000);
        eventConsumerPageDTO.setPageIndex(1);
        String url = getUrl(code) + consumerFindPage;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(eventConsumerPageDTO));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<EventConsumerDTO> eventConsumerDTOS = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventConsumerDTO.class);
        return eventConsumerDTOS;
    }


    /**
     * 事件查询
     * @param eventRegisterPageDTO
     * @return
     */
    public static List<EventRegisterDTO> registerFindPage(String code, EventRegisterPageDTO eventRegisterPageDTO) {
        eventRegisterPageDTO.setPageSize(1000);
        eventRegisterPageDTO.setPageIndex(1);
        String url = getUrl(code) + registerFindPage;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(eventRegisterPageDTO));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<EventRegisterDTO> eventRegisterDTOS = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventRegisterDTO.class);
        return eventRegisterDTOS;
    }


    /**消费者订阅事件查询*/
    public static List<EventConsumerRegisterDTO> findEventRegisterList(String code, String eventConsumerId) {
        String url = getUrl(code) + findEventRegisterList;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(eventConsumerId));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        List<EventConsumerRegisterDTO> list = JSON.parseArray(JSON.toJSONString(data1), EventConsumerRegisterDTO.class);
        return list;
    }


    /**
     * 消费者订阅事件
     * @param eventConsumerId
     * @param eventRegisterIdList
     */
    public static void subscribeEvent(String code,String eventConsumerId, List<String> eventRegisterIdList){
        if(CollectionUtils.isEmpty(eventRegisterIdList)){
            return;
        }
        String url = getUrl(code) + subscribeEvent;
        Object[] objects = {eventConsumerId, eventRegisterIdList};
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, JSON.toJSONString(objects));
        System.out.println("订阅结果:" + resultstr);
    }

    /**
     * 消费者新增
     * @param eventConsumerDTO
     */
    public static void consumerAdd(String code,EventConsumerDTO eventConsumerDTO){
        String url = getUrl(code) + addConsumer;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(eventConsumerDTO));
        System.out.println("新增结果:" + resultstr);
    }

    /**
     * 消费者新增
     * @param eventConsumerDTO
     */
    public static void updateConsumer(String code,EventConsumerDTO eventConsumerDTO){
        String url = getUrl(code) + updateConsumer;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(eventConsumerDTO));
        System.out.println("更新结果:" + resultstr);
    }
    /**
     * 事件绑定新增
     * @param eventSubscriptionDTO
     */
    public static void addSub(String code,EventSubscriptionDTO eventSubscriptionDTO){
        String url = getUrl(code) + addSub;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(eventSubscriptionDTO));
        System.out.println("新增结果:" + resultstr);
    }

    public static void unsubscribeEvent(String code, String consumerId, List<String> eventIds) {
        String url = getUrl(code) + unsubscribeEvent;
        Object[] objects = new Object[2];
        objects[0] = consumerId;
        objects[1] = eventIds;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, JSON.toJSONString(objects));
        System.out.println("新增结果:" + resultstr);
    }
    /**
     * 事件的订阅关系查询
     * @param pageDTO
     * @return
     */
    public static List<EventSubscriptionDTO> findPageEventSubscription(String code, EventSubscriptionPageDTO pageDTO){
        String url = getUrl(code) + findPageEventSubscription;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(pageDTO));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<EventSubscriptionDTO> eventRegisterDTOS = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventSubscriptionDTO.class);
        return eventRegisterDTOS;
    }


    public static EventSubscriptionDTO getByIdEventSubscription(String code, String id) {
        String url = getUrl(code) + getByIdEventSubscription;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(id));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        EventSubscriptionDTO eventSubscriptionDTO = JSON.parseObject(JSON.toJSONString(data), EventSubscriptionDTO.class);
        return eventSubscriptionDTO;
    }

    public static List<OrderStatusGraphDTO> findOrderStatusMachineBySecOrderType(String code, Integer secOrderType) {
        String url = getUrl(code) + findOrderStatusMachineBySecOrderType;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(secOrderType));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        List<OrderStatusGraphDTO> orderStatusGraphs = JSON.parseArray(JSON.toJSONString(data), OrderStatusGraphDTO.class);
        return orderStatusGraphs;
    }


    public static void createOrderStatusGraph(String code,OrderStatusGraphDTO orderStatusGraph){
        String url = getUrl(code) + createOrderStatusGraph;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(orderStatusGraph));
        System.out.println("新增结果:" + resultstr);
    }


    public static List<EventPublishAuditDocumentDTO> eventPublishAuditQuery(String code, String params){
        String url = getUrl(code) + eventPublishAuditQuery;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data), PageableResult.class);
        List<EventPublishAuditDocumentDTO> list = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventPublishAuditDocumentDTO.class);
        return list;
    }


    public static List<EventConsumptionAuditDocumentDTO> eventConsumptionAuditQuery(String code, String params){
        String url = getUrl(code) + eventConsumptionAuditQuery;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data), PageableResult.class);
        List<EventConsumptionAuditDocumentDTO> list = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), EventConsumptionAuditDocumentDTO.class);
        return list;
    }

    public static void publishEventRetry(String code,String body, String eventId){
        String url = getUrl(code) + publishEventRetry;
        Object[] obj =new Object[]{body,eventId};
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, JSON.toJSONString(obj));
        System.out.println("新增结果:" + resultstr);
    }


    /**
     * 事件新增
     */
    public static void repairOriginDiscountAmount(String code, Object params){
        String url = getUrl(code) + repairOriginDiscountAmount;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(params));
//        System.out.println("新增结果:" + resultstr);
    }

    public static List<EventAndSubscriptionDTO> findEventAndSubscriptionByPartnerCode(String code, Object params){
        String url = getUrl(code) + findEventAndSubscriptionByPartnerCode;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(params));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        List<EventAndSubscriptionDTO> list = JSON.parseArray(JSON.toJSONString(data1), EventAndSubscriptionDTO.class);
        return list;
    }


    /**
     * 事件查询
     * @param eventRegisterPageDTO
     * @return
     */
    public static List<OrderTraceConfigDTO> findByPageTraceConfigQuery(String code, Object params) {
        String url = getUrl(code) + findByPageTraceConfigQuery;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(params));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data1 = result.getData();
        PageableResult pageableResult = JSON.parseObject(JSON.toJSONString(data1), PageableResult.class);
        List<OrderTraceConfigDTO> eventRegisterDTOS = JSON.parseArray(JSON.toJSONString(pageableResult.getDatas()), OrderTraceConfigDTO.class);
        return eventRegisterDTOS;
    }


    public static void addOrderTraceConfig(String code, Object param) {
        String url = getUrl(code) + addOrderTraceConfig;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(param));
    }


    public static void updateOrderTraceConfig(String code, Object param) {
        String url = getUrl(code) + updateOrderTraceConfig;
        String resultstr = HttpClientUtils.doPostWithToken(getToken(code), url, addPreFix(param));
        System.out.println(resultstr);
    }


    private static String addPreFix(Object params) {
        return JSON.toJSONString(Collections.singletonList(params));
    }



    private static String getUrl(String code){
        switch (code){
            case "test":
                return testUrl;
            case "release":
                return releaseUrl;
            case "pre":
                return preUrl;
        }
        return testUrl;
    }


    private static String getToken(String code){
        switch (code){
            case "test":
                return testToken;
            case "release":
                return relesaeToken;
            case "pre":
                return preToken;
        }
        return testUrl;
    }



}
