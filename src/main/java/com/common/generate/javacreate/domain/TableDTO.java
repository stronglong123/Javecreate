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
    private String TableName;

    /**
     * 表描述
     */
    private String TableComment;

    /**
     * 列名
     */
    private String ColumnName;
    /**
     * 列属性
     */
    private String Type;
    /**
     * 是否非空
     */
    private String IsNull;
    /**
     * 默认值
     */
    private String DefaultValue;
    /**
     * 描述
     */
    private String comment;

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public String getTableComment() {
        return TableComment;
    }

    public void setTableComment(String tableComment) {
        TableComment = tableComment;
    }

    public String getColumnName() {
        return ColumnName;
    }

    public void setColumnName(String columnName) {
        ColumnName = columnName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getIsNull() {
        return IsNull;
    }

    public void setIsNull(String isNull) {
        IsNull = isNull;
    }

    public String getDefaultValue() {
        return DefaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        DefaultValue = defaultValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
