package com.common.generate.javacreate.model.email;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/5/26 15:29
 */
public class EmailDTO implements Serializable {


    private static final long serialVersionUID = 1963212415971091478L;

    /**
     * 邮箱服务器地址
     */
    private String host = "smtp.yijiupi.com";
    /**
     * 主机端口
     */
    private Integer port = 587;
    /**
     * 发送者的邮箱账号
     */
    private String senderUserName;
    /**
     * 发送者的密码
     */
    private String senderPassword;
    /**
     * 发送者的邮箱地址
     */
    private String senderAddress;
    /**
     * 接收者的邮箱地址,支持多个收件人，逗号分隔
     */
    private String receiveAddress;
    /**
     * 设置邮件主题
     */
    private String tittle;
    /**
     * 设置邮件内容
     */
    private String Content;
    /**
     * 设置邮件类型
     */
    private String contextType = "text/html;charset=UTF-8";
    /**
     * 发送图片的路径
     */
    private List<File> photoSrcs;
    /**
     * 发送附件的路径
     */
    private List<File> fileList;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }


    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public List<File> getPhotoSrcs() {
        return photoSrcs;
    }

    public void setPhotoSrcs(List<File> photoSrcs) {
        this.photoSrcs = photoSrcs;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
