/**   
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.advice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: WebAppConfigurer 
* @Description: 
* @author wangran
* @date Apr 28, 2019 3:54:35 PM 
*/
@Component
public class WebAppConfigurer extends WebMvcConfigurerAdapter {


    private final AuthInterceptor interceptor;

    @Autowired
    public WebAppConfigurer(AuthInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    /**
     *
     * 加载自定义的Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean httpServletRequestReplacedFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestReplacedFilter());
        // /* 是全部的请求拦截，和Interceptor的拦截地址/**区别开
        registration.addUrlPatterns("/*");
        registration.setName("httpServletRequestReplacedFilter");
        registration.setOrder(1);
        return registration;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	    /**
	     * 排除掉原来的MappingJackson2HttpMessageConverter
	     */
	    List<MappingJackson2HttpMessageConverter> originalConverters = new ArrayList<>();
	    for (HttpMessageConverter<?> converter : converters) {
	        if (converter instanceof MappingJackson2HttpMessageConverter) {
	            originalConverters.add((MappingJackson2HttpMessageConverter) converter);
	        }
	    }
	    if (!CollectionUtils.isEmpty(originalConverters)) {
	        converters.removeAll(originalConverters);
	    }
	    MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	    ObjectMapper objectMapper = new ObjectMapper();

	    /**
	     * 将long类型的数据转为String类型
	     */
	    SimpleModule simpleModule = new SimpleModule();
	    simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
	    simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
	    simpleModule.addSerializer(long.class, ToStringSerializer.instance);
	    objectMapper.registerModule(simpleModule);
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    jackson2HttpMessageConverter.setObjectMapper(objectMapper);
	    converters.add(jackson2HttpMessageConverter);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.defaultContentTypeStrategy(new HeaderContentNegotiationStrategy());
	}
}
