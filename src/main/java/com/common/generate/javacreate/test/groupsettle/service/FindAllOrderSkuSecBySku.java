package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.groupsettle.dto.CommOrderDTO;
import com.common.generate.javacreate.test.groupsettle.dto.CommOrderItemDTO;
import com.common.generate.javacreate.test.groupsettle.dto.CommOrderItemDetailDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderAllPageDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderPageItemDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderPageParamDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderTypeEnum;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderItemSecOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/3 8:23
 */
public class FindAllOrderSkuSecBySku {


    public static void main(String[] args) {
        findOrderSecBySku(15900002112802L,"雀巢咖啡丝滑拿铁268ml（1*15）",159,1591);
    }


    /**
     * 根据产品获取所有单据
     * @param skuId
     * @param skuName
     * @param orgId
     * @param warehosueId
     * @return
     */
    public static Map<String, List<SettleOrderItemSecOwnerDTO>> findOrderSecBySku(Long skuId, String skuName, Integer orgId, Integer warehosueId) {
        Map<String, Object> result = new HashMap<>();

        /**1、根据产品名查出所有对应的出库单，退货单，结转单，结算单明细二级货主*/
        List<OrderAllPageDTO> orderList =new ArrayList<>();
        List<OrderAllPageDTO> ddorderList = listSaleOrderAndSec(orgId, warehosueId, 111, skuName,skuId,null);
        List<OrderAllPageDTO> mtorderList = listSaleOrderAndSec(orgId, warehosueId, 110, skuName,skuId,null);
        if(CollectionUtils.isNotEmpty(ddorderList)){
            orderList.addAll(ddorderList);
        }
        if(CollectionUtils.isNotEmpty(mtorderList)){
            orderList.addAll(mtorderList);
        }

        Map<String, List<OrderAllPageDTO>> orderMap = orderList.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getOrderType())));
        System.out.println("未合并数据："+JSON.toJSONString(orderMap));
        result.put("合并前",orderMap);

        /**根据ordertype合并订单相同二级货主数量*/
        Map<String, List<SettleOrderItemSecOwnerDTO>> mergeOrderMap =new HashMap<>();
        for (Map.Entry<String, List<OrderAllPageDTO>> entry : orderMap.entrySet()) {
            String orderType = entry.getKey();
            List<OrderAllPageDTO> list = entry.getValue();
            List<SettleOrderItemSecOwnerDTO> itemSecOwners = list.stream().flatMap(it -> it.getItems().stream()).flatMap(it -> it.getItemDetails().stream()).collect(Collectors.toList());

            /**同一个二级货主合并数量*/
            Map<Long, List<SettleOrderItemSecOwnerDTO>> secMap =  mergeBySecOwnerId(itemSecOwners);

            List<SettleOrderItemSecOwnerDTO> margeSecList =new ArrayList<>();
            for (List<SettleOrderItemSecOwnerDTO> details : secMap.values()) {
                Set<String> orderSet = details.stream().map(it -> it.getOrderNo()).collect(Collectors.toSet());
                BigDecimal totalCount = details.stream().filter(it -> it.getSecCount() != null).map(it -> it.getSecCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
                SettleOrderItemSecOwnerDTO secOwnerDTO = new SettleOrderItemSecOwnerDTO();
                BeanUtils.copyProperties(details.get(0),secOwnerDTO);
                secOwnerDTO.setSecCount(totalCount);
                secOwnerDTO.setOrderNo(JSON.toJSONString(orderSet));
                margeSecList.add(secOwnerDTO);
            }
            mergeOrderMap.put(orderType,margeSecList);
        }
        /**添加差异单*/

        mergeOrderMap.put(OrderTypeEnum.团购差异单.getValue().toString(),getChayiDan(skuId,skuName));
        System.out.println("根据orderType合并二级货主数量:"+JSON.toJSONString(mergeOrderMap));
        mergeDiff(mergeOrderMap);
        System.out.println("合并后:"+JSON.toJSONString(mergeOrderMap));

        result.put("合并后",mergeOrderMap);
        System.out.println(JSON.toJSONString(result));
        return mergeOrderMap;
    }


    public static void mergeDiff(Map<String, List<SettleOrderItemSecOwnerDTO>> mergeOrderMap){
        List<SettleOrderItemSecOwnerDTO> jiesuanRuDetail = mergeOrderMap.get(OrderTypeEnum.团购结算入.getValue().toString());
        List<SettleOrderItemSecOwnerDTO> jiesuanChuDetail = mergeOrderMap.get(OrderTypeEnum.团购结算出.getValue().toString());
        List<SettleOrderItemSecOwnerDTO> chayiDetail = mergeOrderMap.get(OrderTypeEnum.团购差异单.getValue().toString());

        List<SettleOrderItemSecOwnerDTO> all =new ArrayList<>();
        if(CollectionUtils.isNotEmpty(jiesuanChuDetail)){
            all.addAll(jiesuanChuDetail);
        }
        if(CollectionUtils.isNotEmpty(jiesuanRuDetail)){
            all.addAll(jiesuanRuDetail);
        }
        if(CollectionUtils.isNotEmpty(chayiDetail)){
            all.addAll(chayiDetail);
        }
        List<Integer> outType = Arrays.asList(77, 80);
        List<Integer> inType = Arrays.asList(78);
        List<SettleOrderItemSecOwnerDTO> result =new ArrayList<>();
        Map<Long, List<SettleOrderItemSecOwnerDTO>> mergeMap =mergeBySecOwnerId(all);
        for (List<SettleOrderItemSecOwnerDTO> list : mergeMap.values()) {
            Set<String> orderSet = list.stream().map(it -> it.getOrderType() + ":" + it.getOrderNo()).collect(Collectors.toSet());
            SettleOrderItemSecOwnerDTO secOwnerDTO = new SettleOrderItemSecOwnerDTO();
            BeanUtils.copyProperties(list.get(0),secOwnerDTO);
            BigDecimal outCount = list.stream().filter(it -> outType.contains(it.getOrderType().intValue())).filter(it -> it.getSecCount() != null).map(it -> it.getSecCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal intCount = list.stream().filter(it -> inType.contains(it.getOrderType().intValue())).filter(it -> it.getSecCount() != null).map(it -> it.getSecCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            secOwnerDTO.setSecCount(outCount.subtract(intCount));
            secOwnerDTO.setOrderNo(JSON.toJSONString(orderSet));

            result.add(secOwnerDTO);
        }
        mergeOrderMap.put("合并结果",result);
        System.out.println("合并差异单、结算出、结算出入结果:"+JSON.toJSONString(result));

    }



    /**根据二级货主处理合并数量*/
    public static Map<Long, List<SettleOrderItemSecOwnerDTO>> mergeBySecOwnerId(List<SettleOrderItemSecOwnerDTO> itemSecOwners){
        Map<Long, List<SettleOrderItemSecOwnerDTO>> saleSecListMap =new HashMap<>();
        for (SettleOrderItemSecOwnerDTO secOwnerDTO : itemSecOwners) {
            List<SettleOrderItemSecOwnerDTO> dtos = saleSecListMap.get(secOwnerDTO.getSecOwnerId());
            if(CollectionUtils.isNotEmpty(dtos)){
                dtos.add(secOwnerDTO);
                saleSecListMap.put(secOwnerDTO.getSecOwnerId(),dtos);
            }else {
                saleSecListMap.put(secOwnerDTO.getSecOwnerId(),new ArrayList<>(Arrays.asList(secOwnerDTO)));
            }
        }
        return saleSecListMap;
    }

    /**
     * 获取订单
     */
    public static List<OrderAllPageDTO> listSaleOrderAndSec(Integer orgId, Integer warehouseId, Integer orderSource, String productName, Long skuId,List<Byte> orderTypes) {
        /**获取订单*/
        String url = "/order/listGroupSettleOrder";
        System.out.println("订单获取" + url);
        String body = "{\"pageSize\":200,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"" + orderSource + "\",\"currentPage\":1,\"orderTypes\":[74,75,76,77,78,119],\"states\":[6,30,7,10]}";
        OrderPageParamDTO query = JSON.parseObject(body, OrderPageParamDTO.class);
        query.setProductSkuName(productName);
        if(CollectionUtils.isNotEmpty(orderTypes)){
            query.setOrderTypes(orderTypes);
        }
        String dataList = BaseUtils.pageList(url, JSON.toJSONString(query));
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        System.out.println("接口返回数据："+JSON.toJSONString(orderAllPageDTOS));
        if(CollectionUtils.isEmpty(orderAllPageDTOS)){
        return Collections.emptyList();
        
        }
        List<Long> orderIds = orderAllPageDTOS.stream().map(it -> Long.valueOf(it.getOrderId())).collect(Collectors.toList());
        /**获取二级货主*/
        Map<Long, List<SettleOrderItemSecOwnerDTO>> orderSecMap = selectOrderItemOwnerByOrderIds(orderIds);
        /**填充二级货主*/
        for (OrderAllPageDTO orderAllPageDTO : orderAllPageDTOS) {
            List<SettleOrderItemSecOwnerDTO> orderSecOwnerList = orderSecMap.get(Long.valueOf(orderAllPageDTO.getOrderId()));
            Map<Long, List<SettleOrderItemSecOwnerDTO>> itemSecMap = orderSecOwnerList.stream().collect(Collectors.groupingBy(it -> it.getOmsOrdetItemId()));
            /**只展示有这个sku的明细*/
            if (skuId != null) {
                orderAllPageDTO.setItems(orderAllPageDTO.getItems().stream().filter(it -> it.getProductSkuId().equals(skuId)).collect(Collectors.toList()));
            }
            /**填充二级货主数据*/
            for (OrderPageItemDTO item : orderAllPageDTO.getItems()) {
                List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = itemSecMap.get(item.getOrderItemId());
                secOwnerDTOS.stream().forEach(it -> {
                    it.setOrderCreateTime(orderAllPageDTO.getOrderCreateTime());
                    it.setOrderCompleteTime(orderAllPageDTO.getOrderCompleteTime());
                    it.setOrderNo(orderAllPageDTO.getBusinessNo());
                    it.setOrderType(orderAllPageDTO.getOrderType());
                });
                item.setItemDetails(secOwnerDTOS);
            }
        }
        System.out.println("查询结果："+JSON.toJSONString(orderAllPageDTOS));
        return orderAllPageDTOS;
    }

    public static List<SettleOrderItemSecOwnerDTO> getChayiDan(Long skuId,String skuName){
        List<SettleOrderItemSecOwnerDTO> itemSecOwners =new ArrayList<>();
        List<CommOrderDTO> otherOrder = chayiService.getOtherOrder();
        for (CommOrderDTO commOrderDTO : otherOrder) {
            for (CommOrderItemDTO commOrderItemDTO : commOrderDTO.getCommOrderItemDTOS()) {
                if(commOrderItemDTO.getSkuId().equals(skuId)){
                    for (CommOrderItemDetailDTO detailDTO : commOrderItemDTO.getCommOrderItemDetailDTOS()) {
                        SettleOrderItemSecOwnerDTO secOwnerDTO =new SettleOrderItemSecOwnerDTO();
                        secOwnerDTO.setOrderNo(commOrderDTO.getRelatedOrderNo());
                        secOwnerDTO.setSecCount(detailDTO.getUnitTotalCount());
                        secOwnerDTO.setSecOwnerId(detailDTO.getSecOwnerId());
                        secOwnerDTO.setOrderType(OrderTypeEnum.团购差异单.getValue().byteValue());
                        secOwnerDTO.setProductName(skuName);
                        secOwnerDTO.setProductSkuId(skuId);
                        itemSecOwners.add(secOwnerDTO);
                    }
                }
            }
        }

        /**同一个二级货主合并数量*/
        Map<Long, List<SettleOrderItemSecOwnerDTO>> secMap =  mergeBySecOwnerId(itemSecOwners);

        List<SettleOrderItemSecOwnerDTO> margeSecList =new ArrayList<>();
        for (List<SettleOrderItemSecOwnerDTO> details : secMap.values()) {
            Set<String> orderSet = details.stream().map(it -> it.getOrderNo()).collect(Collectors.toSet());
            BigDecimal totalCount = details.stream().filter(it -> it.getSecCount() != null).map(it -> it.getSecCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            SettleOrderItemSecOwnerDTO secOwnerDTO = new SettleOrderItemSecOwnerDTO();
            BeanUtils.copyProperties(details.get(0),secOwnerDTO);
            secOwnerDTO.setSecCount(totalCount);
            secOwnerDTO.setOrderNo(JSON.toJSONString(orderSet));
            margeSecList.add(secOwnerDTO);
        }

        return margeSecList;
    }


    /**
     * 根据订单id获取二级货主数据
     *
     * @param orderIds
     * @return
     */
    public static Map<Long, List<SettleOrderItemSecOwnerDTO>> selectOrderItemOwnerByOrderIds(List<Long> orderIds) {
        String url = "/groupsettle/selectOrderItemOwnerByOrderIds";
        String dataList = BaseUtils.list(url, JSON.toJSONString(orderIds));
        List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = JSON.parseArray(dataList, SettleOrderItemSecOwnerDTO.class);
        Map<Long, List<SettleOrderItemSecOwnerDTO>> secMap = secOwnerDTOS.stream().collect(Collectors.groupingBy(it -> it.getOmsOrderId()));
        return secMap;
    }





}
