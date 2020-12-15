package com.common.generate.javacreate.model;

import com.common.generate.javacreate.model.base.search.PageCondition;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xialei
 * @date  2020-12-10
 */
public class DictionaryQueryDTO extends PageCondition implements Serializable {
    private static final long serialVersionUID = 6092654632617589224L;
    /**
     * 名称
     */
    private String name;
    /**
     * 别名
     */
    private String alias;
    /**
     * 描述
     */
    private String description;
    /**
     * 出处
     */
    private String source;
    /**
     * 分类
     */
    private String type;
    /**
     * 获取名称
     */
    public void setName (String name) {this.name = name;} 
    /**
     * 设置名称
     */
    public String getName(){ return name;} 
    /**
     * 获取别名
     */
    public void setAlias (String alias) {this.alias = alias;} 
    /**
     * 设置别名
     */
    public String getAlias(){ return alias;} 
    /**
     * 获取描述
     */
    public void setDescription (String description) {this.description = description;} 
    /**
     * 设置描述
     */
    public String getDescription(){ return description;} 
    /**
     * 获取出处
     */
    public void setSource (String source) {this.source = source;} 
    /**
     * 设置出处
     */
    public String getSource(){ return source;} 
    /**
     * 获取分类
     */
    public void setType (String type) {this.type = type;} 
    /**
     * 设置分类
     */
    public String getType(){ return type;}

}