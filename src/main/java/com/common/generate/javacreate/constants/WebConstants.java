package com.common.generate.javacreate.constants;

/*********************************************
 * ClassName: WebConstants Description: 常量类
 * @author wangran Date 2016年3月04日
 *********************************************/
public class WebConstants {
	/**
	 * 程序返还常量
	 */
	// 返还成功
	public static final String RESULT_SUCCESS = "success";
	// 返还异常-业务异常
	public static final String RESULT_FAILED = "fail";
	// 返还失败-系统异常
	public static final String RESULT_ERROR = "error";
	// token
	public static final String HEADER_TOKEN = "token";
	// Token验证失败,用户验证异常
	public static final Integer AUTH_VALIDTE_FAILED = -1;
	public static final String SERVICE_ERROR_TIPS = "服务内部异常，请稍后再试";
	// 库存服务-仓库库存
	public static final Integer INVENTROY_STORE_TYPE_WAREHOUSE = 1;
}
