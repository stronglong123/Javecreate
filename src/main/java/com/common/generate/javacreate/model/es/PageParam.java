package com.common.generate.javacreate.model.es;

import lombok.Data;

/**
 * @author xialei
 * @date 2021/10/27 15:05
 */
@Data
public class PageParam {

    public PageParam(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    private Integer pageNum;
    private Integer pageSize = 10;
}
