package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;

import java.io.Serializable;

/**
 * 订单拣货信息
 *
 * @author xialei
 * @date 2021/11/30 10:42
 */
@ApiModel(description = "订单拣货信息")
public class OrderPickDocumentDTO extends OrderPickDTO implements Serializable {

    private static final long serialVersionUID = -4689815417568737818L;
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
