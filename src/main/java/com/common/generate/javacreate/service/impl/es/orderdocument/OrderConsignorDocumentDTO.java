package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderConsignorDTO;

import java.io.Serializable;

/**
 * 订单发货信息
 *
 * @author xialei
 * @date 2021/11/30 10:41
 */
@ApiModel(description = "订单发货信息")
public class OrderConsignorDocumentDTO extends OrderConsignorDTO implements Serializable {

    private static final long serialVersionUID = 7350761032755685147L;
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
