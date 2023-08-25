package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;

public class PageTurnParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private String scrollId;

    private Integer pageSize = 20;

    public String getScrollId() {
        return scrollId;
    }

    public void setScrollId(String scrollId) {
        this.scrollId = scrollId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
