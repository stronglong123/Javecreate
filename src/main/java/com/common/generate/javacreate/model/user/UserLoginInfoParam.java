package com.common.generate.javacreate.model.user;

/**
 * @author: tangkun
 * @date: 2018年11月16日 下午3:28:43
 */
public class UserLoginInfoParam {
	/**
	 * 用户token
	 */
	private String userToken;
	
	private Integer userId;
	
	/** cookie信息标识 */
	private String yjpId;
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 手机号
	 */
	private String phoneNum;

	/**
	 * 密码
	 */
	private String password;
	/**
	 * 验证码
	 */
	private String captchaCode;

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getYjpId() {
		return yjpId;
	}

	public void setYjpId(String yjpId) {
		this.yjpId = yjpId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}
}
