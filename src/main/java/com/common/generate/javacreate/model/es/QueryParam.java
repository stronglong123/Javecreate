package com.common.generate.javacreate.model.es;

import lombok.Data;

/**
 * @author xialei
 * @date 2021/10/27 15:07
 */

@Data
public class QueryParam {
    /**
     * 搜索内容
     */
    private String queryContent;
    /**
     * 性别
     */
    private String sex;
    /**
     * 姓名
     */
    private String name;
}
