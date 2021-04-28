package com.common.generate.javacreate.model.base;


import com.common.generate.javacreate.constants.ResultCode;

/**
 * 响应结果封装
 * @author xialei
 * @date  2019-08-20
 */
public class RetResponse {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private final static String FAIL = "fail";

    public static <T> Result<T> makeOKRsp(T data, String msg) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setResult(DEFAULT_SUCCESS_MESSAGE).setData(data).setMsg(msg);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setResult(DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static <T> Result<T> makeOKRsp() {
        return new Result<T>().setCode(ResultCode.SUCCESS).setResult(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> makeErrRsp(T data, String msg) {
        return new Result<T>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setResult(FAIL).setData(data).setMsg(msg);
    }

    public static <T> Result<T> makeErrRsp() {
        return new Result<T>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setResult(FAIL).setData(null).setMsg(null);
    }

    public static <T> Result<T> makeFailRsp(T data, String msg) {
        return new Result<T>().setCode(ResultCode.FAIL).setResult(FAIL).setData(data).setMsg(msg);
    }
    
    public static <T> Result<T> makeRsp(String code) {
        return new Result<T>().setCode(Integer.valueOf(code));
    }

    public static <T> Result<T> makeRsp(String code, String msg) {
        return new Result<T>().setCode(Integer.valueOf(code)).setMsg(msg);
    }

    public static <T> Result<T> makeExceptionRsp(String code, String msg) {
        return new Result<T>().setCode(Integer.valueOf(code)).setMsg(msg).setResult(FAIL);
    }

    public static <T> Result<T> makeRsp(Integer code, String msg, T data, String result) {
        return new Result<T>().setCode(code).setMsg(msg).setData(data).setResult(result);
    }
}
