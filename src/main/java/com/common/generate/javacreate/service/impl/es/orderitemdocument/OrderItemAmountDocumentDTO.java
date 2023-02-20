package com.common.generate.javacreate.service.impl.es.orderitemdocument;


import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderItemAmountDTO;

import java.io.Serializable;

/**
 * 订单明细金额信息
 *
 * @author xialei
 * @date 2021/11/30 10:50
 */
@ApiModel(description = "订单明细金额信息")
public class OrderItemAmountDocumentDTO extends OrderItemAmountDTO implements Serializable {

    private static final long serialVersionUID = -3071909078873210178L;

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
