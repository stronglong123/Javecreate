package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xialei
 * @date  2020-12-01
 */
public class QuestionBankDTO implements Serializable {
    private static final long serialVersionUID = -545964473858258714L;
    /**
     * id
     */
    private Long id;
    /**
     * 题目
     */
    private String question;
    /**
     * 关键词
     */
    private String keyWord;
    /**
     * 参考答案
     */
    private String answer;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp lastUpdateTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改人
     */
    private String lastUpdateUser;


    /**
     * 获取id
     */
    public void setId (Long id) {this.id = id;} 
    /**
     * 设置id
     */
    public Long getId(){ return id;} 
    /**
     * 获取题目
     */
    public void setQuestion (String question) {this.question = question;} 
    /**
     * 设置题目
     */
    public String getQuestion(){ return question;} 
    /**
     * 获取关键词
     */
    public void setKeyWord (String keyWord) {this.keyWord = keyWord;} 
    /**
     * 设置关键词
     */
    public String getKeyWord(){ return keyWord;} 
    /**
     * 获取
     */
    public void setAnswer (String answer) {this.answer = answer;} 
    /**
     * 设置
     */
    public String getAnswer(){ return answer;} 
    /**
     * 获取创建时间
     */
    public void setCreateTime (Timestamp createTime) {this.createTime = createTime;} 
    /**
     * 设置创建时间
     */
    public Timestamp getCreateTime(){ return createTime;} 
    /**
     * 获取修改时间
     */
    public void setLastUpdateTime (Timestamp lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;} 
    /**
     * 设置修改时间
     */
    public Timestamp getLastUpdateTime(){ return lastUpdateTime;} 
    /**
     * 获取创建人
     */
    public void setCreateUser (String createUser) {this.createUser = createUser;} 
    /**
     * 设置创建人
     */
    public String getCreateUser(){ return createUser;} 
    /**
     * 获取修改人
     */
    public void setLastUpdateUser (String lastUpdateUser) {this.lastUpdateUser = lastUpdateUser;} 
    /**
     * 设置修改人
     */
    public String getLastUpdateUser(){ return lastUpdateUser;} 

}