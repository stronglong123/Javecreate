package com.common.generate.javacreate.model.user;

/**
 * @author xialei
 * @date 2020/11/6 17:31
 */
public class SaasGateWayUserLoginDTO {

    private static final long serialVersionUID = -3117462994369164370L;
    private Integer userId;
    private String trueName;
    private String userName;
    private String mobileNo;

    private String token;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
