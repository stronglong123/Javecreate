package com.common.generate.javacreate.ordercenter.dto.eventrules;

import java.io.Serializable;
import java.util.List;

/**
 * 事件映射器集合
 */
public class EventMappers implements Serializable {
    private List<EventMapper> eventMapperList;

    public List<EventMapper> getEventMapperList() {
        return eventMapperList;
    }

    public void setEventMapperList(List<EventMapper> eventMapperList) {
        this.eventMapperList = eventMapperList;
    }
}
