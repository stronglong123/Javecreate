package com.common.generate.javacreate.ordercenter.dto.eventrules;

import java.io.Serializable;
import java.util.List;

/**
 * 事件匹配器集合
 * 不同的匹配器之间为AND关系,即所有的事件匹配器都匹配才视为匹配成功
 */
public class EventMatchers implements Serializable {
    private List<EventMatcher> eventMatcherList;

    public List<EventMatcher> getEventMatcherList() {
        return eventMatcherList;
    }

    public void setEventMatcherList(List<EventMatcher> eventMatcherList) {
        this.eventMatcherList = eventMatcherList;
    }
}
