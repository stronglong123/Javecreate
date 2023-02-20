package com.common.generate.javacreate.service.impl.es.orderitemdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderItemFeeDTO;

import java.io.Serializable;

/**
 * 订单明细费用信息
 *
 * @author xialei
 * @date 2021/11/30 10:51
 */
@ApiModel(description = "订单明细费用信息")
public class OrderItemFeeDocumentDTO extends OrderItemFeeDTO implements Serializable {

    private static final long serialVersionUID = -3439628812887369742L;
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
