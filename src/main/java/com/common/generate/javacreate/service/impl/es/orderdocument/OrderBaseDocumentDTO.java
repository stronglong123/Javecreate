package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;

import java.io.Serializable;

/**
 * 订单基础信息
 *
 * @author xialei
 * @date 2021/11/30 10:39
 */
@ApiModel(description = "订单基础信息")
public class OrderBaseDocumentDTO extends OrderBaseDTO implements Serializable {
    private static final long serialVersionUID = 158172392116651544L;
    /**
     * 主键id
     */
    @ApiParam(description = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
