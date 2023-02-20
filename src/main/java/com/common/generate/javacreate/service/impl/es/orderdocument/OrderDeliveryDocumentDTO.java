package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderDeliveryDTO;

import java.io.Serializable;

/**
 * 订单配送信息
 *
 * @author xialei
 * @date 2021/11/30 10:42
 */
@ApiModel(description = "订单配送信息")
public class OrderDeliveryDocumentDTO extends OrderDeliveryDTO implements Serializable {

    private static final long serialVersionUID = 5707493344327203503L;
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
