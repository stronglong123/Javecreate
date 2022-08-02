package com.common.generate.javacreate.ordercenter.enums;

/**
 * 事件消费类型
 */
public enum EventConsumptionTypeEnum {
    /**
     * HTTP调用
     */
    HTTP_INVOKE(1,"HTTP调用"),

    /**
     * 服务能力调用
     */
    SERVICE_ABILITY(2,"服务能力调用"),

    /**
     * 事件消费者
     */
    EVENT_CONSUMER(3,"事件消费者"),

    /**
     * 触发事件
     */
    TRIGGER_EVENT(4,"触发事件"),

    /**
     * 内部事件消费者
     */
    INNER_EVENT_CONSUMER(6,"内部事件消费者");


    private Integer value;
    private String name;

    EventConsumptionTypeEnum(Integer value, String name) {
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static EventConsumptionTypeEnum getTextEnum(Integer value) {
        if (value == null) {
            return null;
        }
        EventConsumptionTypeEnum[] trueEnums = EventConsumptionTypeEnum.values();
        for (EventConsumptionTypeEnum trueEnum : trueEnums) {
            if (value.equals(trueEnum.getValue())) {
                return trueEnum;
            }
        }
        return null;
    }

}
