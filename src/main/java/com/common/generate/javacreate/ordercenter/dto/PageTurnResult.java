package com.common.generate.javacreate.ordercenter.dto;


import java.io.Serializable;
import java.util.List;

public class PageTurnResult<T> implements Serializable {
    /**
     * 到底的Scroll_Id
     */
    public static final String SCROLL_ID_END = "-1";
    private static final long serialVersionUID = 1L;

    private Integer recordCount;

    private List<T> datas;

    private String nextScrollId;

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public String getNextScrollId() {
        return nextScrollId;
    }

    public void setNextScrollId(String nextScrollId) {
        this.nextScrollId = nextScrollId;
    }
}
