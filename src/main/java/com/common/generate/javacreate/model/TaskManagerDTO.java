package com.common.generate.javacreate.model;

import com.common.generate.javacreate.model.base.search.PageCondition;
import com.common.generate.javacreate.model.base.search.PagerCondition;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xialei
 * @date 2020-10-30
 */
public class TaskManagerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 开发任务名称
     */
    private String taskName;
    /**
     * 开发任务编号
     */
    private String taskNo;
    /**
     * 涉及项目
     */
    private String refProject;
    /**
     * 状态，1:未开始，2:开发中，3:开发完成，4:部署test，5:部署release，6:部署pre，7:部署product
     */
    private Byte state;
    /**
     * 优先级，从1开始
     */
    private Integer priority;
    /**
     * 备注
     */
    private String remark;
    /**
     * 开发人
     */
    private String operator;
    /**
     * 截止时间
     */
    private String deadTime;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 最后一次更新时间
     */
    private Timestamp lastUpdateTime;

    private String createUser;

    private String lastUpdateUser;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 获取主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 获取开发任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 设置开发任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 获取开发任务编号
     */
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * 设置开发任务编号
     */
    public String getTaskNo() {
        return taskNo;
    }

    /**
     * 获取涉及项目
     */
    public void setRefProject(String refProject) {
        this.refProject = refProject;
    }

    /**
     * 设置涉及项目
     */
    public String getRefProject() {
        return refProject;
    }

    /**
     * 获取状态，0:未开始，1:开发中，2:开发完成，3:部署test，4:部署release，5:部署pre，6:部署product
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 设置状态，0:未开始，1:开发中，2:开发完成，3:部署test，4:部署release，5:部署pre，6:部署product
     */
    public Byte getState() {
        return state;
    }

    /**
     * 获取优先级，从1开始
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 设置优先级，从1开始
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 获取备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 设置备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 获取开发人
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 设置开发人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 获取截止时间
     */
    public void setDeadTime(String deadTime) {
        this.deadTime = deadTime;
    }

    /**
     * 设置截止时间
     */
    public String getDeadTime() {
        return deadTime;
    }

    /**
     * 获取创建时间
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 设置创建时间
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * 获取最后一次更新时间
     */
    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 设置最后一次更新时间
     */
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

}