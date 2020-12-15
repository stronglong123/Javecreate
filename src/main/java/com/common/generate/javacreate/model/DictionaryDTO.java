package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xialei
 * @date  2020-12-10
 */
public class DictionaryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
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
     * 实例
     */
    private String instance;
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
    /**
     * 获取实例
     */
    public void setInstance (String instance) {this.instance = instance;} 
    /**
     * 设置实例
     */
    public String getInstance(){ return instance;} 
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