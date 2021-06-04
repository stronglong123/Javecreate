package com.common.generate.javacreate.utils.excel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author wangran
 * @ClassName: ExcelUtils
 * @Description:
 * @date Apr 21, 2019 12:03:18 PM
 */
public class ExcelApiUtils {
	private ExcelApiUtils () {}

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelApiUtils.class);

	/** 发送响应流方法 */
	public static void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				LOGGER.error("发送响应流失败", e);
			}
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			LOGGER.error("发送响应流失败", ex);
		}
	}
	
	public static String getFileName(String constant, String timeStart, String timeEnd, String fileText) {
		if (StringUtils.isEmpty(timeStart)) {
			return constant.concat(fileText);
		}
		return constant.concat(timeStart).concat("-").concat(timeEnd).concat(fileText);
	}
}
