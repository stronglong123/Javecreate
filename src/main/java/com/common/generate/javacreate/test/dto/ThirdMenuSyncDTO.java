package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

public class ThirdMenuSyncDTO implements Serializable {

    /**
     * 应用Id
     */
    private String appCode;

    private List<MenuSyncDTO> menus;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public List<MenuSyncDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuSyncDTO> menus) {
        this.menus = menus;
    }
}
