/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */

/**
 *
 */
package com.common.generate.javacreate.utils.excel;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import java.util.Locale;

/**
 * 
 * @author fengjiaqian
 *
 */
@Component
public class XlsViewMapResolver extends BeanNameViewResolver {

	@Override
	public int getOrder() {
		  return Integer.MIN_VALUE;
	}

	@Override
	public View resolveViewName(String viewName, Locale locale) throws BeansException {
		if (!XlsViewMap.VIEW_NAME.equals(viewName)&&!XlsxViewMap.VIEW_NAME.equals(viewName)) {
			return null;
		}
		return super.resolveViewName(viewName, locale);
	}

}
