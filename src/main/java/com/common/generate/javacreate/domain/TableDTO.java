package com.common.generate.javacreate.domain;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/5/15 15:26
 */
public class TableDTO implements Serializable {

    private static final long serialVersionUID = -3572153239503486313L;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 字段名
     */
    private String columnName;
    /**
     * 字段属性
     */
    private String type;
    /**
     * 是否非空
     */
    private String isNull;
    /**
     * 默认值
     */
    private String defaultValue;
    /**
     * 描述
     */
    private String comment;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
