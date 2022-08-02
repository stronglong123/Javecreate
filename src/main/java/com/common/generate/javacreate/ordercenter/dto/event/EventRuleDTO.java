package com.common.generate.javacreate.ordercenter.dto.event;



import com.common.generate.javacreate.ordercenter.dto.eventrules.EventFilters;
import com.common.generate.javacreate.ordercenter.dto.eventrules.EventMappers;
import com.common.generate.javacreate.ordercenter.dto.eventrules.EventMatchers;

import java.io.Serializable;

/**
 * 事件规则
 */
public class EventRuleDTO implements Serializable {

    /**
     * 事件匹配
     */
    private EventMatchers eventMatchers;

    /**
     * 事件过滤
     */
    private EventFilters eventFilters;

    /**
     * 事件映射
     */
    private EventMappers eventMappers;

    public EventMatchers getEventMatchers() {
        return eventMatchers;
    }

    public void setEventMatchers(EventMatchers eventMatchers) {
        this.eventMatchers = eventMatchers;
    }

    public EventFilters getEventFilters() {
        return eventFilters;
    }

    public void setEventFilters(EventFilters eventFilters) {
        this.eventFilters = eventFilters;
    }

    public EventMappers getEventMappers() {
        return eventMappers;
    }

    public void setEventMappers(EventMappers eventMappers) {
        this.eventMappers = eventMappers;
    }
}
