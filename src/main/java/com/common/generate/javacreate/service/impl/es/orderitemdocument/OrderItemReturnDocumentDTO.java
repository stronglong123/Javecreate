package com.common.generate.javacreate.service.impl.es.orderitemdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderItemReturnDTO;

import java.io.Serializable;

/**
 * 退货订单明细信息
 *
 * @author xialei
 * @date 2021/11/30 10:52
 */
@ApiModel(description = "退货单明细信息")
public class OrderItemReturnDocumentDTO extends OrderItemReturnDTO implements Serializable {

    private static final long serialVersionUID = -4450753958699230154L;
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
