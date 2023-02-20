package com.common.generate.javacreate.ordercenter.dto.data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ReturnOrderComposeBO
 * @Description oms退货单组合模型
 * @Author hhw
 * @Date 2022/5/13 9:43
 * @Version 1.0
 **/
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

    /**
     * true-跳过灰度检查， flase-不跳过灰度检查
     */
    private Boolean skipGrapCheck;

    public ReturnOrderComposeBO() {
    }

    public ReturnOrderComposeBO(ReturnOrderBO returnOrderBO, List<ReturnOrderItemBO> returnOrderItemBOList) {
        this.returnOrderBO = returnOrderBO;
        this.returnOrderItemBOList = returnOrderItemBOList;
    }

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

    public Boolean getSkipGrapCheck() {
        return skipGrapCheck;
    }

    public void setSkipGrapCheck(Boolean skipGrapCheck) {
        this.skipGrapCheck = skipGrapCheck;
    }
}

