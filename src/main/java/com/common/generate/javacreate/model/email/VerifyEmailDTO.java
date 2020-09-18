package com.common.generate.javacreate.model.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author xialei
 * @date 2020/5/26 15:36
 */
public class VerifyEmailDTO extends Authenticator {

    //构造方法
    public VerifyEmailDTO() {
        super();
    }

    public VerifyEmailDTO(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }


    //账号
    private String userName;
    //密码
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
