package com.common.generate.javacreate.ordercenter.dto.eventrules;


public enum EventMapperType {
    /**
     * 更新Path
     */
    UPDATE(0),

    /**
     * 删除Path
     */
    DELETE(1),

    /**
     * 模板
     */
    TEMPLATE(2)
    ;

    private final int value;

    EventMapperType(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
