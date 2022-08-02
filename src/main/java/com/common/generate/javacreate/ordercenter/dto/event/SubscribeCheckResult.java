package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.List;

/**
 * @author xialei
 * @date 2022/6/30 9:33
 */
public class SubscribeCheckResult {

    private List<EventConsumerAndRegisterDTO> eventConsumerAndRegisterDTOS;

    private List<String> notExistEventCode;

    public List<EventConsumerAndRegisterDTO> getEventConsumerAndRegisterDTOS() {
        return eventConsumerAndRegisterDTOS;
    }

    public void setEventConsumerAndRegisterDTOS(List<EventConsumerAndRegisterDTO> eventConsumerAndRegisterDTOS) {
        this.eventConsumerAndRegisterDTOS = eventConsumerAndRegisterDTOS;
    }

    public List<String> getNotExistEventCode() {
        return notExistEventCode;
    }

    public void setNotExistEventCode(List<String> notExistEventCode) {
        this.notExistEventCode = notExistEventCode;
    }
}
