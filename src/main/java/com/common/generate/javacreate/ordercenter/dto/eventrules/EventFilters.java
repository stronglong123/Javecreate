package com.common.generate.javacreate.ordercenter.dto.eventrules;

import java.io.Serializable;
import java.util.List;

public class EventFilters implements Serializable {
    private List<EventFilter> eventFilterList;

    public List<EventFilter> getEventFilterList() {
        return eventFilterList;
    }

    public void setEventFilterList(List<EventFilter> eventFilterList) {
        this.eventFilterList = eventFilterList;
    }
}
