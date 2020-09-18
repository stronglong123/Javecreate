package com.common.generate.javacreate.model.base.exception;

/**
 * 业务异常，如指定Id的对象不存在，订单不能提交等，以Warn方式进行输出。
 *
 * @author xialei
 * @date 2020/9/18 16:36
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1501110999698708589L;

    public BusinessException() {
        super();
    }

    public BusinessException(MessageCode message) {
        super(message);
    }

    public BusinessException(String msg) {
        super(msg);
    }

    /**
     * @param errorMessage 错误详情
     * @param errorCode    错误码
     */
    public BusinessException(String errorMessage, String errorCode) {
        super(errorMessage, new Throwable(errorCode));
    }

    public BusinessException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public BusinessException(Throwable ex) {
        super(ex);
    }
}
