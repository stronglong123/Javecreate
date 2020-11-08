package com.common.generate.javacreate.advice;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 
 * 实现该系统的filter
 * @author Hu Liangzhi
 * @Date:2020年7月4日 下午4:12:33
 */
public class HttpServletRequestReplacedFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            ServletRequest requestWrapper = new RequestReaderHttpServletRequestWrapper((HttpServletRequest) request);
            //获取请求中的流，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
            // 在chain.doFiler方法中传递新的request对象
            chain.doFilter(requestWrapper, response);
            return;
        }
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {		
	}

}
