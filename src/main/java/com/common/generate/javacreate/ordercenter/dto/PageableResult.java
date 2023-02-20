package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2022/9/15 10:25
 */
public class PageableResult<T> implements Serializable {
    private Integer recordCount;
    private Integer totalPage;
    private Integer currentPage;
    private Integer pageSize;
    private List<T> datas;

    public PageableResult() {
        this.totalPage = 0;
        this.recordCount = 0;
        this.currentPage = 1;
        this.pageSize = 20;
    }

    public PageableResult(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public PageableResult(Integer recordCount, Integer totalPage) {
        this.recordCount = recordCount;
        this.totalPage = totalPage;
    }

    public Integer getRecordCount() {
        return this.recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getDatas() {
        return this.datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
