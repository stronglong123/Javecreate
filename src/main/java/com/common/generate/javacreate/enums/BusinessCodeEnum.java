package com.common.generate.javacreate.enums;

public enum BusinessCodeEnum {

    /**
     * 成功
     */
    SUCCESS("200", "成功"),

    /**
     * 失败
     */
    FAIL("400", "失败"),

    /**
     * 未认证（签名错误）
     */
    UNAUTHORIZED("401", "未认证（签名错误）"),

    /**
     * 接口不存在
     */
    NOT_FOUND("404", "接口不存在"),

    /**
     * 请求方式不正确
     */
    METHOD_NOT_ALLOWED("405", "请求方式不正确"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    /**
     * 获取token失败
     */
    ERROR_TOKEN("501", " 获取token失败"),

    /**
     * 用户名或密码错误
     */
    LOGIN_ERROR("900", "用户名或密码错误"),

    /**
     * 登录超时
     */
    LOGIN_OUT_TIME("901", "登录超时"),

    /**
     * 用户名重复
     */
    DUPLICATE_USERNAME("903", "用户名重复"),

    /**
     * 角色名重复
     */
    DUPLICATE_ROLENAME("904", "角色名重复"),

    /**
     * 组织名重复
     */
    DUPLICATE_ORGNAME("905", "组织名重复"),

    /**
     * 菜单名重复
     */
    DUPLICATE_MENUNAME("906", "菜单名重复"),

    /**
     * 菜单路径重复
     */
    DUPLICATE_MENUPATH("907", "菜单路径重复"),

    /**
     * 账号被锁定
     */
    LOCKED_ACCOUNT("908", "账号被锁定"),

    
    /**
     * 用户不存在
     */
    USER_IS_NULL("911", "用户不存在"),

    /**
     * 参数为空
     */
    PARAM_EMPTY("6", "参数为空"),

    /**
     * 名称重复
     */
    DUPLICATE_NAME("7", "名称重复"),

    /**
     * 过滤字段未设置
     */
    EMPTY_FILTER("602", "过滤字段未设置"),

    /**
     * 未发现实体或单据（不包括子表）MODULE
     */
    NOT_FIND_MODULE("701", "未发现实体或单据"),

    /**
     * 空的实体
     */
    NULL_ENTITY("702", "空的实体");
	/**
	 * 代码
	 */
    public String code;
    /**
     * 描述
     */
    public String text;

    BusinessCodeEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

	public String getCode() {
		return code;
	}
	
	public String getText() {
		return text;
	}
}
