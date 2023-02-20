package com.common.generate.javacreate.service.impl.es.orderdocument;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderContactDTO;

import java.io.Serializable;

/**
 * 订单收货信息
 *
 * @author xialei
 * @date 2021/11/30 10:41
 */
@ApiModel(description = "订单收货信息")
public class OrderContactDocumentDTO extends OrderContactDTO implements Serializable {

    private static final long serialVersionUID = 7873478166354580879L;
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
