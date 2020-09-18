package com.common.generate.javacreate.model.base.exception;

/**
 * 数据检验异常，判断对象格式是否符合要求，比如必填项没有填，手机格式不正确等，这时系统将抛出数据检验异常
 *
 * @author xialei
 * @date 2020/9/18 16:37
 */
public class DataValidateException extends BaseException {

    public DataValidateException() {
        super();
    }

    public DataValidateException(String msg) {
        super(msg);
    }

    public DataValidateException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public DataValidateException(Throwable ex) {
        super(ex);
    }
}
