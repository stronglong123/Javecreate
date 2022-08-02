package com.common.generate.javacreate.ordercenter.enums;

/**
 * @author xialei
 * @date 2020/7/8 16:29
 */
public enum EventTypeEnum {
    /**
     * 数值
     */
    /**
     * 订单内部事件
     */
    ORDER_INTERNAL(0,"订单内部事件"),

    /**
     * 订单外部事件
     */
    ORDER_EXTERNAL(10,"订单外部事件"),

    /**
     * 通用外部事件
     */
    COMMON_EXTERNAL(11,"通用外部事件");

    EventTypeEnum(Integer value, String name) {
        this.name = name;
        this.value = value;
    }

    private Integer value;
    private String name;

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static EventTypeEnum getTextEnum(Integer value) {
        if (value == null) {
            return null;
        }
        EventTypeEnum[] trueEnums = EventTypeEnum.values();
        for (EventTypeEnum trueEnum : trueEnums) {
            if (value.equals(trueEnum.getValue())) {
                return trueEnum;
            }
        }
        return null;
    }
}
