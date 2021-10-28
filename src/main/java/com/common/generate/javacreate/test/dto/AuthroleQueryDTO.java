/*
 * @ClassName AuthroleDTO
 * @Description 
 * @version 1.0
 * @Date 2020-01-21 16:46:46
 */
package com.common.generate.javacreate.test.dto;

import java.io.Serializable;

public class AuthroleQueryDTO implements Serializable {
	private static final long serialVersionUID = -1421168920664502452L;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 服务商id
     */
    private Long serviceId;

    /**
     * 1、查询可被授权上级角色，2.查询可授权下级角色
     */
    private Integer type;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}