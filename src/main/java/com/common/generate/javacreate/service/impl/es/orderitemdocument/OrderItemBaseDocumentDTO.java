package com.common.generate.javacreate.service.impl.es.orderitemdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderItemBaseDTO;

import java.io.Serializable;

/**
 * 订单明细基础信息
 *
 * @author xialei
 * @date 2021/11/30 10:48
 */
@ApiModel(description = "订单明细基础信息")
public class OrderItemBaseDocumentDTO extends OrderItemBaseDTO implements Serializable {

    private static final long serialVersionUID = 4905589109193824611L;

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
