package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/9/25 17:20
 */
public class ThirdRolePermissionDTO implements Serializable {

    private static final long serialVersionUID = 3866266323103442942L;
    /**
     * 系统code
     */
    private String appCode;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 服务商id
     */
    private Long serviceId;

//    /**
//     * 权限
//     */
//    private List<ThirdPriorityPermissionDTO> priorityPermissionDTOs;

    /**
     * 权限
     */
    private List<MenuSyncDTO> permissionDTOs;


    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }


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

//    public List<ThirdPriorityPermissionDTO> getPriorityPermissionDTOs() {
//        return priorityPermissionDTOs;
//    }
//
//    public void setPriorityPermissionDTOs(List<ThirdPriorityPermissionDTO> priorityPermissionDTOs) {
//        this.priorityPermissionDTOs = priorityPermissionDTOs;
//    }

    public List<MenuSyncDTO> getPermissionDTOs() {
        return permissionDTOs;
    }

    public void setPermissionDTOs(List<MenuSyncDTO> permissionDTOs) {
        this.permissionDTOs = permissionDTOs;
    }
}
