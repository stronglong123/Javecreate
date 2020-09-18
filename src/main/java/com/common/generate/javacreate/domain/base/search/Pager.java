package com.common.generate.javacreate.domain.base.search;

/**
 * @author xialei
 * @date 2020/9/18 16:27
 */
public class Pager extends PagerCondition {

    private static final long serialVersionUID = 7463230384231168940L;
    /**
     * 总记录数
     */
    private Integer recordCount;

    /**
     * 总页数
     */
    private Integer totalPage;

    public Pager() {
        super();
    }

    public Pager(Integer currentPage, Integer pageSize, Integer recordCount) {
        super(currentPage, pageSize);
        this.recordCount = recordCount;
        Integer totalPageSize = recordCount / pageSize;
        Integer remailder = recordCount % pageSize;
        // 如果总记录数与每页显示条数的余数大于0，总页数加1
        if (remailder > 0) {
            totalPageSize = totalPageSize + 1;
        }
        totalPage = totalPageSize;

    }

    /**
     * 分页查询时使用
     */
    public Pager(PagerCondition pageCondition, Integer recordCount) {
        setCurrentPage(pageCondition.getCurrentPage());
        setPageSize(pageCondition.getPageSize());
        setRecordCount(recordCount);
        setTotalPage((recordCount + getPageSize() - 1) / getPageSize());
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
