package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.statusmachine.OrderStatusEdgeDTO;
import com.common.generate.javacreate.ordercenter.dto.statusmachine.OrderStatusGraphDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author xialei
 * @date 2022/8/1 16:40
 */

@Service
public class StatusMachineManageBL {


    public static void main(String[] args) {
        //2002  10003 20003
        checkMachineExpression(false, "pre", 10003);
    }

    /**
     * 变更状态机表达式，适配新表达式
     * @param needUpdate
     * @param code
     * @param secOrderType
     */
    public static void checkMachineExpression(boolean needUpdate, String code, Integer secOrderType) {
        List<OrderStatusGraphDTO> orderStatusMachines = ApiUtil.findOrderStatusMachineBySecOrderType(code, secOrderType);
        System.out.println(secOrderType + "状态机：" + JSON.toJSONString(orderStatusMachines));
        if (CollectionUtils.isEmpty(orderStatusMachines)) {
            return;
        }
        for (OrderStatusGraphDTO orderStatusMachine : orderStatusMachines) {
            if (CollectionUtils.isEmpty(orderStatusMachine.getEdgeList())) {
                continue;
            }
            for (OrderStatusEdgeDTO orderStatusEdge : orderStatusMachine.getEdgeList()) {
                if (StringUtils.isEmpty(orderStatusEdge.getExpression())) {
                    continue;
                }
                String expression = orderStatusEdge.getExpression();
                orderStatusEdge.setExpression(checkExpression(expression));
            }
            orderStatusMachine.setVisibility(1);
        }
        System.out.println("变更后状态机：" + JSON.toJSONString(orderStatusMachines));
        if (!needUpdate) {
            return;
        }

        ApiUtil.createOrderStatusGraph(code, orderStatusMachines.get(0));
    }

    /**
     * 装配表达式
     * @param expression
     * @return
     */
    private static String checkExpression(String expression) {
        if (expression.contains("#event.") || expression.contains("#context.")) {
            return expression;
        }
        boolean isChange = false;
        List<String> replaceEventWordList = getReplaceEventWord();
        for (String eventWord : replaceEventWordList) {
            if (expression.contains(eventWord)) {
                isChange = true;
                expression = expression.replaceAll(eventWord, "#event." + eventWord);
            }
        }
        List<String> replaceContextWordList = getReplaceContextWord();
        for (String context : replaceContextWordList) {
            if (expression.contains(context)) {
                isChange = true;
                expression = expression.replaceAll(context, "#context." + context);
            }
        }
        System.out.println("表达式:" + expression);
        return expression;
    }


    private static List<String> getReplaceEventWord() {
        return Arrays.asList("pickUpState", "markType", "auditState");
    }

    private static List<String> getReplaceContextWord() {
        return Arrays.asList("needPurchasingManager", "needCityManagerAudit");
    }

}
