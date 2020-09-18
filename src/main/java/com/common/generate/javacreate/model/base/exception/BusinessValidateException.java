package com.common.generate.javacreate.model.base.exception;

/**
 * 业务检验异常，如检验用户名是否唯一，用户是否可提交订单等.
 *
 * @author xialei
 * @date 2020/9/18 16:36
 */
public class BusinessValidateException extends BusinessException {

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public BusinessValidateException() {
        super();
    }

    public BusinessValidateException(MessageCode message) {
        super(message);
    }

    public BusinessValidateException(String msg) {
        super(msg);
    }

    public BusinessValidateException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public BusinessValidateException(Throwable ex) {
        super(ex);
    }

    @Override
    public String getMessage() {
        return super.getOriginalMessage();
    }
}
