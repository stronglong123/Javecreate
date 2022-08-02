package com.common.generate.javacreate.ordercenter.dto.eventrules;

import java.io.Serializable;

/**
 * 事件匹配规则
 * 当返回值为 null、0、空集合、空字符串时，认为匹配失败
 * 其余返回值则认为匹配成功
 */
public class EventMatcher implements Serializable {
    /**
     * 匹配规则的JsonPath语法
     */
    private String jsonPath;

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }
}
