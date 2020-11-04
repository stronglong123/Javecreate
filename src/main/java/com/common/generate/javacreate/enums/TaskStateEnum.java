package com.common.generate.javacreate.enums;

/**
 * 调拨单状态
 *
 * @author xialei
 * @date 2020/6/5 10:47
 */
public enum TaskStateEnum {
    /**
     * 未开始
     */
    INVALID((byte) -1, "作废"),
    /**
     * 未开始
     */
    WAIT((byte) 1, "未开始"),
    /**
     * 开发中
     */
    DOING((byte) 2, "开发中"),
    /**
     * 开发完成
     */
    COMPLETE((byte) 3, "开发完成"),
    /**
     * 部署test
     */
    TEST((byte) 4, "部署test"),
    /**
     * 部署release
     */
    RELEASE((byte) 5, "部署release"),
    /**
     * 部署pre
     */
    PRE((byte) 6, "部署pre"),
    /**
     * 部署product
     */
    PRODUCT((byte) 7, "部署product");


    TaskStateEnum(Byte value, String name) {
        this.name = name;
        this.value = value;
    }

    private Byte value;
    private String name;

    public Byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public static TaskStateEnum getTransferStateEnum(Byte value) {
        if (value == null) {
            return null;
        }
        TaskStateEnum[] stateEnums = TaskStateEnum.values();
        for (TaskStateEnum stateEnum : stateEnums) {
            if (value.equals(stateEnum.getValue())) {
                return stateEnum;
            }
        }
        return null;
    }
}
