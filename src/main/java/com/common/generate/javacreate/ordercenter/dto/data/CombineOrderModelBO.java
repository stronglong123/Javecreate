package com.common.generate.javacreate.ordercenter.dto.data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CombineOrderModelBO
 * @Description oms合并单
 * @Author hhw
 * @Date 2022/5/11 14:09
 * @Version 1.0
 **/
public class CombineOrderModelBO {

    /**
     * 申请合并的单据(既发起合并请求的单据)
     */
    private OrderBO applyOrder;

    /**
     * 已存在的合并主单(若没有有效合并单则为空)
     */
    private OrderBO existCombineOrder;

    /**
     * 待合并子单列表
     */
    private List<OrderBO> combineSubOrderList;

    /**
     * 需要重新组合的单据
     * (是备份，之前争抢合并资格失败)
     */
    private Map<Integer, OrderBO> productStatisticsClassIndexMap;

    public OrderBO getApplyOrder() {
        return applyOrder;
    }

    public void setApplyOrder(OrderBO applyOrder) {
        this.applyOrder = applyOrder;
    }

    public OrderBO getExistCombineOrder() {
        return existCombineOrder;
    }

    public void setExistCombineOrder(OrderBO existCombineOrder) {
        this.existCombineOrder = existCombineOrder;
    }

    public List<OrderBO> getCombineSubOrderList() {
        return combineSubOrderList;
    }

    public void setCombineSubOrderList(List<OrderBO> combineSubOrderList) {
        this.combineSubOrderList = combineSubOrderList;
    }

    public Map<Integer, OrderBO> getProductStatisticsClassIndexMap() {
        return productStatisticsClassIndexMap;
    }

    public void setProductStatisticsClassIndexMap(Map<Integer, OrderBO> productStatisticsClassIndexMap) {
        this.productStatisticsClassIndexMap = productStatisticsClassIndexMap;
    }
}

