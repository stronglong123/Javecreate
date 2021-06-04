package com.common.generate.javacreate.service.newcheck;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.groupsettle.dto.OrderAllPageDTO;
import com.common.generate.javacreate.test.groupsettle.dto.WarehouseDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.DateUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/18 10:06
 */
public class findSaleOrderDateError {
    public static void main(String[] args){
        List<WarehouseDTO> warehouseDTOS = BaseUtils.getJiezhuanWarehouse2();
        Date checkDate = DateUtils.string2Date("2021-04-01 00:00:55");

        List<OrderAllPageDTO> errorList =new ArrayList<>();
        for (WarehouseDTO warehouseDTO : warehouseDTOS) {
            List<OrderAllPageDTO> orderAllPageDTOList = listGroupSettleAndReturnOrder(warehouseDTO.getOrgId(), warehouseDTO.getWarehouseId(), 110);
            if(CollectionUtils.isEmpty(orderAllPageDTOList)){
                continue;
            }
            List<OrderAllPageDTO> collect = orderAllPageDTOList.stream().filter(it -> DateUtils.string2Date(it.getOrderCreateTime()).before(checkDate)).collect(Collectors.toList());
            errorList.addAll(collect);
        }
        System.out.println(JSON.toJSONString(errorList));
    }


    /**
     * 根据订单id获取二级货主数据
     *
     * @param orderIds
     * @return
     */
    public static List<OrderAllPageDTO> listGroupSettleAndReturnOrder(Integer orgId, Integer warehouseId, Integer orderSource) {
        String url = "/order/listGroupSettleOrder";
        System.out.println("订单获取" + url);
        String body = "{\"pageSize\":100,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderSource\":\"" + orderSource + "\",\"currentPage\":1,\"orderTypes\":[119,74]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        return orderAllPageDTOS;
    }
}
