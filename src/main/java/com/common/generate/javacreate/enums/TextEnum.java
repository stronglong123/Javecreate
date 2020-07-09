package com.common.generate.javacreate.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xialei
 * @date 2020/7/8 16:23
 */
public enum TextEnum {

    /**
     * 字符串
     */
    VARCHAR(1, "VARCHAR", "字符串"),
    /**
     * 布尔
     */
    BOOLEAN(2, "BOOLEAN", "布尔"),
    /**
     * 短数值
     */
    TINYINT(3, "TINYINT", "短数值"),
    /**
     * 数值
     */
    INTEGER(4, "INTEGER", "数值"),
    /**
     * 序列
     */
    BIGINT(5, "BIGINT", "序列");

    TextEnum(Integer value, String enName, String name) {
        this.name = name;
        this.value = value;
        this.enName = enName;
    }

    private Integer value;
    private String name;
    private String enName;

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getEnName() {
        return enName;
    }

    public static TextEnum getTextEnum(Integer value) {
        if (value == null) {
            return null;
        }
        TextEnum[] textEnums = TextEnum.values();
        for (TextEnum textEnum : textEnums) {
            if (value.equals(textEnum.getValue())) {
                return textEnum;
            }
        }
        return null;
    }

    public static TextEnum getTextEnumByeName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        TextEnum[] textEnums = TextEnum.values();
        for (TextEnum textEnum : textEnums) {
            if (name.equals(textEnum.getName())) {
                return textEnum;
            }
        }
        return null;
    }

    public static TextEnum getTextEnumByeEnName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        TextEnum[] textEnums = TextEnum.values();
        for (TextEnum textEnum : textEnums) {
            if (name.equals(textEnum.getEnName())) {
                return textEnum;
            }
        }
        return null;
    }
}
