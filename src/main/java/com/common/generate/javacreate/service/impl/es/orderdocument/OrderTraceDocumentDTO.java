package com.common.generate.javacreate.service.impl.es.orderdocument;



import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.common.generate.javacreate.service.impl.es.base.OrderTraceDTO;

import java.io.Serializable;

/**
 * 订单日志
 * @author xialei
 * @date 2021/12/9 9:46
 */
public class OrderTraceDocumentDTO extends OrderTraceDTO implements Serializable {
    private static final long serialVersionUID = 8445600419420242416L;
    /**
     * 主键id
     */
    @ApiParam(description = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
