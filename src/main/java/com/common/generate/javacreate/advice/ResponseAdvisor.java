package com.common.generate.javacreate.advice;

import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 接口参数返回消息格式
 * @author Huliangzhi
 * @date: 2019年10月25日 上午9:49:30
 */
@ControllerAdvice
public class ResponseAdvisor implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		String requestPath = request.getURI().getPath();
		if (!requestPath.startsWith("/")) {
			return body;
		}
		if (body instanceof Result) {
			return body;
		}
		if (body instanceof String) {
			return body;
		}
		return RetResponse.makeOKRsp(body);
	}
}
