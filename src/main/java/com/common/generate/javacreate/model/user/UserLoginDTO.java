package com.common.generate.javacreate.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xialei
 * @date 2020/11/8 16:37
 */
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = -3655544076350413674L;
    private Integer userId;
    private String trueName;
    private String userName;
    private String mobileNo;

    /** 过期时间*/
    private Date expireDate;
    /** 是否长期有效*/
    private boolean isLongtime;
    /** 用户token*/
    private String usertoken;

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

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isLongtime() {
        return isLongtime;
    }

    public void setLongtime(boolean longtime) {
        isLongtime = longtime;
    }

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }
}
