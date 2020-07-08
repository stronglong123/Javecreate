package com.common.generate.javacreate.domain.base;

import com.common.generate.javacreate.constants.ResultCode;
import com.common.generate.javacreate.constants.WebConstants;

/**
 * 统一API响应结果封装
 *
 * @author xialei
 * @date 2019-08-20
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    private String result;

    public Result() {

    }


    /**
     * 异常构造方法
     * @param exception
     */
    public Result(Exception exception) {
        this.result = WebConstants.RESULT_FAILED;
        this.msg = exception.getMessage();
        this.data = (T) exception.getMessage();
    }

    /**
     * 异常构造方法
     * @param exception
     */
    public Result(String message, Exception exception) {
        this(exception);
        this.msg = message;
    }

    /**
     * 异常构造方法
     * @param exception
     */
    public Result(String message, Exception exception, Boolean success) {
        this(exception);
        this.code = ResultCode.FAIL.code();
        this.msg = message;
        this.result = WebConstants.RESULT_SUCCESS;
    }

    /**
     * 异常构造方法
     * @param exception
     */
    public Result(String message, Exception exception, Integer code) {
        this(exception);
        this.msg = message;
    }


    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;

    }

    public String getResult() {
        return result;
    }

    public Result setResult(String result) {
        this.result = result;
        return this;
    }

}
