package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 日记
 * @author xialei
 * @date  2022-08-12
 */
public class DiaryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 开发任务名称
     */
    private String title;
    /**
     * 开发任务编号
     */
    private String content;
    /**
     * 状态，0:开始，1:创作中，2:完成
     */
    private Integer state;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 最后更新时间
     */
    private Timestamp lastUpdateTime;


    /**
     * 获取主键
     */
    public void setId (Long id) {this.id = id;} 
    /**
     * 设置主键
     */
    public Long getId(){ return id;} 
    /**
     * 获取开发任务名称
     */
    public void setTitle (String title) {this.title = title;} 
    /**
     * 设置开发任务名称
     */
    public String getTitle(){ return title;} 
    /**
     * 获取开发任务编号
     */
    public void setContent (String content) {this.content = content;} 
    /**
     * 设置开发任务编号
     */
    public String getContent(){ return content;} 
    /**
     * 获取状态，0:开始，1:创作中，2:完成
     */
    public void setState (Integer state) {this.state = state;} 
    /**
     * 设置状态，0:开始，1:创作中，2:完成
     */
    public Integer getState(){ return state;} 
    /**
     * 获取备注
     */
    public void setRemark (String remark) {this.remark = remark;} 
    /**
     * 设置备注
     */
    public String getRemark(){ return remark;} 
    /**
     * 获取创建时间
     */
    public void setCreateTime (Timestamp createTime) {this.createTime = createTime;} 
    /**
     * 设置创建时间
     */
    public Timestamp getCreateTime(){ return createTime;} 
    /**
     * 获取最后更新时间
     */
    public void setLastUpdateTime (Timestamp lastUpdateTime) {this.lastUpdateTime = lastUpdateTime;} 
    /**
     * 设置最后更新时间
     */
    public Timestamp getLastUpdateTime(){ return lastUpdateTime;} 

}