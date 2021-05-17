package com.common.generate.javacreate.test.groupsettle.dto;

import com.common.generate.javacreate.enums.TrueEnum;

/**
 * @author xialei
 * @date 2021/5/3 9:42
 */
public enum  OrderTypeEnum {


    团购销售单(119, "团购销售单"),
    团购退货单(74, "团购退货单"),
    团购结转出(75, "团购结转出"),
    团购结转入(76, "团购结转入"),
    团购结算出(77, "团购结算出"),
    团购结算入(78, "团购结算入"),
    团购差异单(80, "团购差异单");

    OrderTypeEnum(Integer value, String name) {
        this.name = name;
        this.value = value;
    }

    private Integer value;
    private String name;

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static OrderTypeEnum getOrderTypeEnum(Integer value) {
        if (value == null) {
            return null;
        }
        OrderTypeEnum[] enums = OrderTypeEnum.values();
        for (OrderTypeEnum orderTypeEnum : enums) {
            if (value.equals(orderTypeEnum.getValue())) {
                return orderTypeEnum;
            }
        }
        return null;
    }
}
