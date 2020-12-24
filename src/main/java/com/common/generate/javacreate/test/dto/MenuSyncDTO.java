package com.common.generate.javacreate.test.dto;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/9/23 21:14
 */
public class MenuSyncDTO implements Serializable {

    private static final long serialVersionUID = -4641084870527213776L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 菜单标识
     */
    private String code;
    /**
     * 组件路径
     */
    private String namespace;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父级code
     */
    private String parentCode;

    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 应用Id
     */
    private Long appId;
    /**
     * 类型：1、菜单 2、权限点
     */
    private Integer type;
    /** 参数 */
    private String argument;
    /** 图标地址 */
    private String imgIcon;
    /**
     * 类型：1、新增 2、修改
     */
    private Integer needAdd;
    /** 是否为叶子节点 1(true)-是 */
    private Integer leaf;

    public Integer getNeedAdd() {
        return needAdd;
    }

    public void setNeedAdd(Integer needAdd) {
        this.needAdd = needAdd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(String imgIcon) {
        this.imgIcon = imgIcon;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }
}
