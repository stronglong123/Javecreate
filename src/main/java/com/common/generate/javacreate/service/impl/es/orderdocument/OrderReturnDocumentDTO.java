package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderReturnDTO;

import java.io.Serializable;

/**
 * 退货信息
 *
 * @author xialei
 * @date 2021/11/30 10:46
 */
@ApiModel(description = "退货信息")
public class OrderReturnDocumentDTO extends OrderReturnDTO implements Serializable {

    private static final long serialVersionUID = -4868588510202178605L;
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
