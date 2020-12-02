package com.common.generate.javacreate.model;

import com.common.generate.javacreate.model.base.search.PageCondition;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xialei
 * @date  2020-12-01
 */
public class QuestionBankQueryDTO extends PageCondition implements Serializable {
    private static final long serialVersionUID = -545964473858258714L;
    /**
     * 题目
     */
    private String question;
    /**
     * 关键词
     */
    private String keyWord;
    /**
     * 
     */
    private String answer;
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

}