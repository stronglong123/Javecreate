package com.common.generate.javacreate.enums;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.converter.HttpMessageConversionException;

/**
 * 
 * @Description 异常级别  级别越高，数字越小
 * @author Hu Liangzhi
 * @version V1.0
 * @Date:2020年2月29日 下午12:24:02
 */
public enum ExceptionLevel {
	ERROR("错误", "error", 1),
	EXCEPTION("一般异常", "exception", 5),
	WARN("警告", "warn", 10);

	/**
	 * 中文文本
	 */
    public String text;
    /**
     * 异常级别类型
     */
    public String typeText;
    /**
     * 类型
     */
    public Integer type;

	/**
	 * 
	 * @param text 文本
	 * @param typeText 类型
	 * @param type 类型数字
	 */
	ExceptionLevel(String text, String typeText, Integer type) {
		this.text = text;
		this.typeText = typeText;
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public String getTypeText() {
		return typeText;
	}

	public Integer getType() {
		return type;
	}

	public static ExceptionLevel getExcetpionType(Throwable e) {
//		if (e instanceof BusinessValidateException) {
//			return ExceptionLevel.WARN;
//		}
//		if (e instanceof BusinessException) {
//			return ExceptionLevel.WARN;
//		}
//		if (e instanceof DataValidateException) {
//			return ExceptionLevel.WARN;
//		}
		if (e instanceof HttpMessageConversionException ||
				e instanceof JsonMappingException) {
			return ExceptionLevel.WARN;
		}
		return ExceptionLevel.ERROR;
	}
}
