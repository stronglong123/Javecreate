package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.ordercenter.EventManageBL;
import com.common.generate.javacreate.ordercenter.dto.event.EventAndSubExcelDTO;
import com.common.generate.javacreate.utils.excel.XlsViewMap;
import com.common.generate.javacreate.utils.excel.XlsxViewMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2021/6/3 17:08
 */

@IgnoreAuthInterceptor
@Controller
public class ExportManageController {

    @Autowired
    private EventManageBL eventManageBL;

    /**
     * 下载货主批量导入模板
     */
    @GetMapping(value = "/templates/download")
    public String downloadCargoOwner(Model model) {
        model.addAttribute("dataList", Collections.emptyList());
        model.addAttribute("Fields", "");
        model.addAttribute("DisplayNames", "货主名称,货主编码,类型:经销商/供应商,联系人,电话");
        model.addAttribute("sheet","货主");
        model.addAttribute("fileName", "货主批量导入.xlsx");
        return XlsxViewMap.VIEW_NAME;
    }

    @GetMapping(value = "/event/download")
    public String downloadEvent(Model model) {
        List<EventAndSubExcelDTO> eventList = eventManageBL.getEvent();
        List<Map<String,String>> mapList =new ArrayList<>();
        for (EventAndSubExcelDTO eventAndSubExcelDTO : eventList) {
            Map map = transBean2Map(eventAndSubExcelDTO);
            mapList.add(map);
        }
        model.addAttribute("dataList", mapList);
        model.addAttribute("Fields", "partnerCode,eventCode,eventName,evnetTypeName,subscribeName,"
                + "subscribeEventConsumptionType,bindOutPartnerCode,bindOutEventCode,bindOutEvent,bindOutEventType," +
                "consumerCompanyCode,consumerPartnerCode,consumerName,consumerSubscribedEventCodes");
        model.addAttribute("DisplayNames", "partnerCode,事件code,事件名称,事件类型,订阅名称,"
                + "订阅类型,绑定事件partnerCode,绑定事件code,绑定事件名称,绑定事件类型," +
                "消费者公司code,消费者应用code,消费者名字,消费者绑定事件code");
        model.addAttribute("fileName", "事件.xls");
        model.addAttribute("sheet", "事件处理");
        return XlsxViewMap.VIEW_NAME;
    }



    public  Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                /** 过滤class属性 */
                if (!key.equals("class")) {
                    /** 得到property对应的getter方法 */
                    Method getter = property.getReadMethod();
                    /**	LOGGER.info("得到的key:{}", key); */
                    Object value = getter.invoke(obj);
//					if(null !=value && !"".equals(value))
                    map.put(key, value);
                }

            }
        } catch (Exception e) {
        }
        return map;

    }


}
