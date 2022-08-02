package com.common.generate.javacreate.ordercenter.dto.eventrules;

import java.io.Serializable;

/**
 * 事件过滤
 */
public class EventFilter implements Serializable {
    /**
     * JsonPath语法
     */
    private String jsonPath;

    /**
     * 是否提取.
     * 如果为true的话，则提取当前过滤的数组为消息体，而忽视其他的JSON结构
     * 如果为false的话，则消息体JSON结构总体不变，只是当前数组的数据为过滤后的
     */
    private Boolean extract = false;

    /**
     * 当过滤后的集合为空时，是否继续.
     */
    private Boolean continueWhenEmpty = false;

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public Boolean getExtract() {
        return extract;
    }

    public void setExtract(Boolean extract) {
        this.extract = extract;
    }

    public Boolean getContinueWhenEmpty() {
        return continueWhenEmpty;
    }

    public void setContinueWhenEmpty(Boolean continueWhenEmpty) {
        this.continueWhenEmpty = continueWhenEmpty;
    }
}
