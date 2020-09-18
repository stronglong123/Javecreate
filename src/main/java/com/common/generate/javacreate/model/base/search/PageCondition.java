package com.common.generate.javacreate.model.base.search;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/9/18 16:26
 */
public class PageCondition implements Serializable {

    /**
     * 页码.
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页大小.
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序条件.
     */
    public static String ORDER_BY = "orderBy";

    /**
     * 页码.
     */
    private Integer pageNum = 1;

    /**
     * 每页大小.
     */
    private Integer pageSize = 20;

    /**
     * 排序条件.
     */
    private String orderBy;

    /**
     * 获取 页码.
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * 设置 页码.
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取 每页大小.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 每页大小.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 排序条件.
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置 排序条件.
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
