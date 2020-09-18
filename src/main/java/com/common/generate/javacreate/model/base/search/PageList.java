package com.common.generate.javacreate.model.base.search;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/9/18 16:27
 */
public class PageList<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 6715454397990178794L;
    /**
     * 返回的数据集合
     */
    private List<T> dataList;

    /**
     * 返回的分页对象信息
     */
    private Pager pager;

    /**
     * 获取 返回的数据集合
     */
    public List<T> getDataList() {
        return dataList;
    }

    /**
     * 设置 返回的数据集合
     */
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    /**
     * 获取 返回的分页对象信息
     */
    public Pager getPager() {
        return pager;
    }

    /**
     * 设置 返回的分页对象信息
     */
    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
