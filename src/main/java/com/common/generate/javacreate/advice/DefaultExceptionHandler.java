package com.common.generate.javacreate.advice;

import com.common.generate.javacreate.enums.ExceptionLevel;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常拦截
 *
 * @date: 2017年8月24日 上午11:49:39
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);


    /**
     * 处理参数异常，一般用于校验body参数
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationBodyException(MethodArgumentNotValidException e) {
        for (ObjectError s : e.getBindingResult().getAllErrors()) {
            return  RetResponse.makeErrRsp("Invalid_Request_Parameter", s.getObjectName() + ": " + s.getDefaultMessage());
        }
        return  RetResponse.makeErrRsp(null, "未知参数错误");
    }

    /**
     * 异常拦截入口
     *
     * @param request
     * @param exception
     * @return
     * @return: BaseResult
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public Result processUnauthenticatedException(HttpServletRequest request, Exception exception) {
        // 获取所有参数
        Enumeration<String> requestParams = request.getParameterNames();
        Map<String, Object> paramMap = new HashMap<>();
        while (requestParams.hasMoreElements()) {
            String param = requestParams.nextElement();
            paramMap.put(param, request.getParameter(param));
        }
        ExceptionLevel exceptionType = ExceptionLevel.getExcetpionType(exception);
        return getErrorMsg(exceptionType, request, paramMap, exception);
    }

    /**
     * @param exceptionType
     * @param request
     * @param paramMap
     * @param e
     * @return
     */
    private Result getErrorMsg(ExceptionLevel exceptionType, HttpServletRequest request, Map<String, Object> paramMap, Exception e) {
        Result failedResult = null;
        if (ExceptionLevel.ERROR.equals(exceptionType)) {
            failedResult = RetResponse.makeErrRsp(e.getCause().getMessage(), e.getMessage());
            LOGGER.info("异常信息:{}", e.getMessage());
        } else if (ExceptionLevel.WARN.equals(exceptionType)) {
            LOGGER.info("WARN 发生错误：{}", e.getMessage());
            if (null != e.getCause() && StringUtils.isNumeric(e.getCause().getMessage())) {
                failedResult = RetResponse.makeExceptionRsp(e.getCause().getMessage(), e.getMessage());
            } else {
                failedResult = RetResponse.makeFailRsp(paramMap, e.getMessage());
            }
        } else {
            LOGGER.info("异常信息:{}", e.getMessage());
        }

        return failedResult;
    }
}
