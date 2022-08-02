package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.List;

/**
 * @author xialei
 * @date 2022/7/25 9:18
 */
public class EventDiffSubDTO {


    private EventAndSubscriptionResult sourceResult;

    private EventAndSubscriptionResult targetResult;

    public EventAndSubscriptionResult getSourceResult() {
        return sourceResult;
    }

    public void setSourceResult(EventAndSubscriptionResult sourceResult) {
        this.sourceResult = sourceResult;
    }

    public EventAndSubscriptionResult getTargetResult() {
        return targetResult;
    }

    public void setTargetResult(EventAndSubscriptionResult targetResult) {
        this.targetResult = targetResult;
    }
}
