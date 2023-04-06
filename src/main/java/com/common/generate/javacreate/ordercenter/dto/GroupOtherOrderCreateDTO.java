package com.common.generate.javacreate.ordercenter.dto;

import com.common.generate.javacreate.test.dto.SettlementOrderItemCreateDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 结转
 * @author xialei
 * @date 2021/3/31 11:48
 */
public class GroupOtherOrderCreateDTO implements Serializable {
    private static final long serialVersionUID = -2369299100528535846L;
    /**
     * 平台编号：110 美团优选，111 多多买菜 112橙心优选(必传)
     */
    private String channelNo;
    /**
     * 订单类型  75 结转出，76 结转入，77 结算出，78结算入，(必传)
     */
    private String orderType;
    /**
     * 城市id(必传)
     */
    private String orgId;
    /**
     * 仓库ID(必传)
     */
    private String warehouseId;

    /**
     * 订单金额(必传)
     */
    private String orderAmount;


    /**明细*/
    private List<GroupOtherOrderItemCreateDTO> items;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public List<GroupOtherOrderItemCreateDTO> getItems() {
        return items;
    }

    public void setItems(List<GroupOtherOrderItemCreateDTO> items) {
        this.items = items;
    }
}
