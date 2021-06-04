/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */

/**
 * 
 */
package com.common.generate.javacreate.utils.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fengjiaqian
 *
 */
@Documented
@Inherited
@Target({ElementType.METHOD,ElementType.FIELD})  
@Retention(RetentionPolicy.RUNTIME) 
public @interface ExcelColumn {
	
	 String name();
	 int sort() default 0;
	 String color() default ""; 
	 String fontname() default "宋体";
	 int fontHeight() default 14;
	 int columnWidth() default 5000;
	 String format() default "";
}
