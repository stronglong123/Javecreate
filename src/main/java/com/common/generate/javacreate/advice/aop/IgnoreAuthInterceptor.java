package com.common.generate.javacreate.advice.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description 忽略拦截器校验
 * @author Hu Liangzhi
 * @since JDK 1.8
 * @version V1.0
 * @Date:2020年2月22日 下午11:34:47
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreAuthInterceptor {
	
	String value() default "";
}
