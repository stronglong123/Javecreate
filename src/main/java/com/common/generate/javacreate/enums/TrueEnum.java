package com.common.generate.javacreate.enums;

/**
 * @author xialei
 * @date 2020/7/8 16:29
 */
public enum TrueEnum {
    /**
     * 数值
     */
    INTEGER(1, "是"),
    /**
     * 序列
     */
    BIGINT(0, "否");

    TrueEnum(Integer value, String name) {
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

    public static TrueEnum getTextEnum(Integer value) {
        if (value == null) {
            return null;
        }
        TrueEnum[] trueEnums = TrueEnum.values();
        for (TrueEnum trueEnum : trueEnums) {
            if (value.equals(trueEnum.getValue())) {
                return trueEnum;
            }
        }
        return null;
    }
}
