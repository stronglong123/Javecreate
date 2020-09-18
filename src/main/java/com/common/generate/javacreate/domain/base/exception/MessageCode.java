package com.common.generate.javacreate.domain.base.exception;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/9/18 16:35
 */
public class MessageCode implements Serializable {

    private static final long serialVersionUID = -3832150375023268642L;
    /**
     * 描述信息
     */
    private String description;

    /**
     * 错误码
     */
    private String errorCode;

    public MessageCode() {
        // defalut construct
    }

    // region 属性

    public MessageCode(String code) {
        this.setErrorCode(code);
        this.setDescription("");
    }

    public MessageCode(String code, String message) {
        this.setErrorCode(code);
        this.setDescription(message);
    }

    public String getDescription() {
        return description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
