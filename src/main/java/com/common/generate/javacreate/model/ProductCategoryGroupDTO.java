package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProductCategoryGroupDTO implements Serializable {
    private static final long serialVersionUID = -589712433195676577L;
    /**
     * id
     */
    private Long id;

    /**
     * 分组Id
     */
    private Long categoryGroupId;

    /**
     * 父类编号
     */
    private Long parentId;

    /**
     * 冗余外部类目Id
     */
    private String refCategoryId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 排序号
     */
    private Integer sequence;

    /**
     * 分类类型：类目(1)
     */
    private Integer type;

    /**
     * 是否关联外部类目 0:否 1:是
     */
    private Byte isRelated;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String lastUpdateUser;

    /**
     * 修改时间
     */
    private Date lastUpdateTime;

    /**
     * 子节点
     */
    private List<ProductCategoryGroupDTO> childProductCategoryGroupDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryGroupId() {
        return categoryGroupId;
    }

    public void setCategoryGroupId(Long categoryGroupId) {
        this.categoryGroupId = categoryGroupId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRefCategoryId() {
        return refCategoryId;
    }

    public void setRefCategoryId(String refCategoryId) {
        this.refCategoryId = refCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Byte getIsRelated() {
        return isRelated;
    }

    public void setIsRelated(Byte isRelated) {
        this.isRelated = isRelated;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<ProductCategoryGroupDTO> getChildProductCategoryGroupDTOS() {
        return childProductCategoryGroupDTOS;
    }

    public void setChildProductCategoryGroupDTOS(List<ProductCategoryGroupDTO> childProductCategoryGroupDTOS) {
        this.childProductCategoryGroupDTOS = childProductCategoryGroupDTOS;
    }
}
