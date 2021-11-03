package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/10/8 17:32
 */
public class GroupSettleDTO implements Serializable {

    private List<ReturnSettle> returnSettleSkuList;
    private List<SaleSettleSku> saleSettleSkuList;


    public List<ReturnSettle> getReturnSettleSkuList() {
        return returnSettleSkuList;
    }

    public void setReturnSettleSkuList(List<ReturnSettle> returnSettleSkuList) {
        this.returnSettleSkuList = returnSettleSkuList;
    }

    public List<SaleSettleSku> getSaleSettleSkuList() {
        return saleSettleSkuList;
    }

    public void setSaleSettleSkuList(List<SaleSettleSku> saleSettleSkuList) {
        this.saleSettleSkuList = saleSettleSkuList;
    }
}

