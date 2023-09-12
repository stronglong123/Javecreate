package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.service.impl.es.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * @Author daizhibing
 * @Description 退货单模型
 * @Date 18:19 2021/3/8
 **/
@ApiModel(description = "oms退货单模型")
public class ReturnOrderComposeBO implements Serializable {

    private static final long serialVersionUID = -499860484884400573L;
    /**
     * 退货单主单
     */
    private ReturnOrderBO returnOrderBO;
    /**
     * 退货单明细
     */
    private List<ReturnOrderItemBO> returnOrderItemBOList;


    public ReturnOrderBO getReturnOrderBO() {
        return returnOrderBO;
    }

    public void setReturnOrderBO(ReturnOrderBO returnOrderBO) {
        this.returnOrderBO = returnOrderBO;
    }

    public List<ReturnOrderItemBO> getReturnOrderItemBOList() {
        return returnOrderItemBOList;
    }

    public void setReturnOrderItemBOList(List<ReturnOrderItemBO> returnOrderItemBOList) {
        this.returnOrderItemBOList = returnOrderItemBOList;
    }

}
