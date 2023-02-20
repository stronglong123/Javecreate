package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderSaleDTO;

import java.io.Serializable;

/**
 * 销售单信息
 *
 * @author xialei
 * @date 2021/11/30 10:40
 */
@ApiModel(description = "销售单信息")
public class OrderSaleDocumentDTO extends OrderSaleDTO implements Serializable {

    private static final long serialVersionUID = 6090002703354308775L;

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
