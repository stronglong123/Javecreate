package com.common.generate.javacreate.ordercenter.dto.eventrules;

import java.io.Serializable;

/**
 * 事件映射器
 */
public class EventMapper implements Serializable {

    /**
     * 类型
     * @see EventMapperType
     */
    private Integer type;

    /**
     * Json路径
     */
    private String jsonPath;

    /**
     * 内容
     */
    private String content;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
