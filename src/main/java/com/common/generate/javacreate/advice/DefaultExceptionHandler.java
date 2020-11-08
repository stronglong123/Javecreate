package com.common.generate.javacreate.advice;

import com.common.generate.javacreate.enums.ExceptionLevel;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
     * 异常拦截入口
     *
     * @param request
     * @param exception
     * @return
     * @return: BaseResult
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({Exception.class})
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
            LOGGER.error("异常信息1", e);
        } else if (ExceptionLevel.WARN.equals(exceptionType)) {
            LOGGER.warn("WARN 发生错误：{}", e.getMessage());
            if (null != e.getCause() && StringUtils.isNumeric(e.getCause().getMessage())) {
                failedResult = RetResponse.makeExceptionRsp(e.getCause().getMessage(), e.getMessage());
            } else {
                failedResult = RetResponse.makeFailRsp(paramMap, e.getMessage());
            }
        } else {
            LOGGER.error("异常信息2", e.getMessage());
        }

        return failedResult;
    }
}
