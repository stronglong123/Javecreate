package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderBillDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderDetailDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderPageParamDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderQueryDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderAllPageDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderPageItemDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderPageParamDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderTypeEnum;
import com.common.generate.javacreate.test.groupsettle.dto.OutStockApplyDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OutStockApplyQueryDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OutStockItemApplyDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderItemSecOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.test.transferNote.InStockOrderCommDTO;
import com.common.generate.javacreate.test.transferNote.InStockOrderCommItemDTO;
import com.common.generate.javacreate.test.transferNote.InStockOrderCommItemDetailDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/6 10:11
 */
public class finderrorbygroubill {


    public static void main(String[] args){
//        getChayuChu("MTYX998120210331",998,9981,null);

//        findAllGroupSettleOrde(159,1591,"脉动青柠口味600ml（1*15）",15900001542822L);
        findAllGroupSettleOrde2(103,1031,null,null);

//        allSearch(103,1031);

    }

    //  `OrderType` tinyint(4) NOT NULL COMMENT '单据类型类型（1、销售出、2、销售退、3、结转出、4、结转入、5、差异）',


    public static void findAllGroupSettleOrde2(Integer orgId,Integer warehosueId,String skuName, Long skuId) {
        List< Map<String, List<SettleOrderItemSecOwnerDTO>>> list =new ArrayList<>();
        List<GroupSettleOrderQueryDTO> pageList = grouplist(warehosueId);
        for (GroupSettleOrderQueryDTO dto : pageList) {
            GroupSettleOrderDetailDTO detail = detail(dto.getId(), dto.getOrgId());
            Map<String,  Map<String, List<SettleOrderItemSecOwnerDTO>>> map = singleSearch(orgId, warehosueId, skuName, skuId, detail);
            list.add(map.get("合并二级货主"));
        }
        System.out.println(JSON.toJSONString(list));

        List<SettleOrderItemSecOwnerDTO> result =new ArrayList<>();
        List<SettleOrderItemSecOwnerDTO> allMerge = list.stream().flatMap(it -> it.get("合并结果").stream()).collect(Collectors.toList());
        Map<String, List<SettleOrderItemSecOwnerDTO>> collect = allMerge.stream().collect(Collectors.groupingBy(it -> it.getProductSkuId() + "_" + it.getSecOwnerId()));
        for (List<SettleOrderItemSecOwnerDTO> value : collect.values()) {
            BigDecimal addCount = value.stream().map(it -> it.getSecCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            SettleOrderItemSecOwnerDTO dto =new SettleOrderItemSecOwnerDTO();
            BeanUtils.copyProperties(value.get(0),dto);
            dto.setSecCount(addCount);
            result.add(dto);
        }
        result = result.stream().sorted(Comparator.comparing(it->it.getProductSkuId())).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result));
    }



    public static void findAllGroupSettleOrde(Integer orgId,Integer warehosueId,String skuName, Long skuId) {
        Map<String, Object> result = new HashMap<>();
        List<GroupSettleOrderQueryDTO> pageList = grouplist(warehosueId);
        for (GroupSettleOrderQueryDTO dto : pageList) {
            GroupSettleOrderDetailDTO detail = detail(dto.getId(), dto.getOrgId());
            Map<String,  Map<String, List<SettleOrderItemSecOwnerDTO>>> map = singleSearch(orgId, warehosueId, skuName, skuId, detail);
            result.put(detail.getSettleNo(),map);
        }
        System.out.println(JSON.toJSONString(result));
    }


    public static List<GroupSettleOrderBillDTO> allSearch(Integer orgId,Integer warehosueId){
        List<GroupSettleOrderQueryDTO> pageList = grouplist(warehosueId);
        List<GroupSettleOrderBillDTO> groupSettleOrderBills =new ArrayList<>();
        for (GroupSettleOrderQueryDTO dto : pageList) {
            GroupSettleOrderDetailDTO detail = detail(dto.getId(), dto.getOrgId());
            if(CollectionUtils.isNotEmpty(detail.getGroupSettleOrderBills())){
                groupSettleOrderBills.addAll(detail.getGroupSettleOrderBills());
            }
        }
        if(CollectionUtils.isEmpty(groupSettleOrderBills)){
            return Collections.emptyList();
        }
        Map<String, List<GroupSettleOrderBillDTO>> listMap = groupSettleOrderBills.stream().collect(Collectors.groupingBy(it -> it.getSkuName()));

        List<GroupSettleOrderBillDTO> result =new ArrayList<>();
        for (List<GroupSettleOrderBillDTO> value : listMap.values()) {
            GroupSettleOrderBillDTO billDTO = new GroupSettleOrderBillDTO();
            BeanUtils.copyProperties(value.get(0),billDTO);
            BigDecimal outCount = value.stream().filter(it -> Arrays.asList((byte) 1, (byte) 3).contains(it.getOrderType())).map(it -> it.getSettleMinUnitTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inCount = value.stream().filter(it -> Arrays.asList((byte) 2, (byte) 4, (byte) 5).contains(it.getOrderType())).map(it -> it.getSettleMinUnitTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            billDTO.setOutCount(outCount);
            billDTO.setInCount(inCount);
            billDTO.setCalCount(outCount.subtract(inCount));
            result.add(billDTO);
        }

        result = result.stream().sorted(Comparator.comparing(it -> it.getSkuName())).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result));
        return result;

    }









    public static Map<String,  Map<String, List<SettleOrderItemSecOwnerDTO>>> singleSearch(Integer orgId,Integer warehosueId,String skuName, Long skuId,GroupSettleOrderDetailDTO detailDTO){
        Map<String, Map<String, List<SettleOrderItemSecOwnerDTO>>> result = new HashMap<>();

        List<OrderAllPageDTO> grouporders = listSaleOrderAndSec(orgId, warehosueId, 111, skuName, skuId, null,Arrays.asList((byte)77,(byte)78));
        List<OrderAllPageDTO> groupList = grouporders.stream().filter(it -> it.getRemark().equals(detailDTO.getSettleNo())).collect(Collectors.toList());
        System.out.println(JSON.toJSONString("结算单数据:"+JSON.toJSONString(groupList)));


        Set<String> orderNos = detailDTO.getGroupSettleOrderBills().stream().map(it -> it.getOrderNo()).collect(Collectors.toSet());
        List<OrderAllPageDTO> orderList = listSaleOrderAndSec(orgId, warehosueId, 111, skuName, skuId, new ArrayList<>(orderNos),null);

        /**获取差异单*/
        List<OutStockApplyDTO> chayuChu = getChayuChu(detailDTO.getSettleNo(), orgId, warehosueId, skuId);
        if(CollectionUtils.isEmpty(orderList)){
            orderList = new ArrayList<>();
        }
        if(CollectionUtils.isNotEmpty(groupList)){
            orderList.addAll(groupList);
        }

        System.out.println(JSON.toJSONString(orderList));

        Map<String, List<OrderAllPageDTO>> orderMap = orderList.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getOrderType())));
        System.out.println("未合并数据："+JSON.toJSONString(orderMap));
        List<InStockOrderCommDTO> chayuRu = getChayuRu(detailDTO.getSettleNo(), detailDTO.getOrgId(), detailDTO.getSaleWarehouseId(), skuId);
        System.out.println("差异入库单:"+ JSON.toJSONString(chayuRu));

        Map<String,Object> orignDataMap =new HashMap<>();
        orignDataMap.putAll(orderMap);
        orignDataMap.put("81",chayuRu);

//        result.put("合并前",orignDataMap);

        /**根据ordertype合并订单相同二级货主数量*/
        Map<String, List<SettleOrderItemSecOwnerDTO>> mergeOrderMap =new HashMap<>();

        for (Map.Entry<String, Object> entry : orignDataMap.entrySet()) {
            List<SettleOrderItemSecOwnerDTO> itemSecOwners =new ArrayList<>();
            String orderType = entry.getKey();
            if(orderType.equals("81")){
                List<InStockOrderCommDTO> inStockOrderCommDTOS = (List<InStockOrderCommDTO>) entry.getValue();
                for (InStockOrderCommDTO inStockOrderDTO : inStockOrderCommDTOS) {
                    for (InStockOrderCommItemDTO itemDTO : inStockOrderDTO.getCommItemDTOList()) {
                        for (InStockOrderCommItemDetailDTO itemDetailDTO : itemDTO.getItemDetailDTOList()) {
                            SettleOrderItemSecOwnerDTO secOwnerDTO =new SettleOrderItemSecOwnerDTO();
                            secOwnerDTO.setOrderNo(inStockOrderDTO.getOrderNo());
                            secOwnerDTO.setProductSkuId(itemDTO.getSkuId());
                            secOwnerDTO.setOmsOrderId(Long.valueOf(inStockOrderDTO.getOrderId()));
                            secOwnerDTO.setOmsOrdetItemId(Long.valueOf(itemDTO.getOrderItemId()));
                            secOwnerDTO.setSecCount(itemDetailDTO.getUnitTotalCount());
                            secOwnerDTO.setSecOwnerId(itemDetailDTO.getSecOwnerId());
                            secOwnerDTO.setProductName(itemDTO.getProductName());
                            secOwnerDTO.setOrderType((byte)81);
                            secOwnerDTO.setSpecQuantity(itemDTO.getSpecQuantity());
                            itemSecOwners.add(secOwnerDTO);
                        }
                    }
                }
            }else {
                List<OrderAllPageDTO> list = (List<OrderAllPageDTO>)entry.getValue();
                itemSecOwners = list.stream().flatMap(it -> it.getItems().stream()).flatMap(it -> it.getItemDetails().stream()).collect(Collectors.toList());
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
            mergeOrderMap.put(orderType,margeSecList);
        }

        mergeDiff(mergeOrderMap);
        result.put("合并二级货主",mergeOrderMap);

        System.out.println("根据orderType合并二级货主数量:"+JSON.toJSONString(mergeOrderMap));
        return result;
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
    public static List<OrderAllPageDTO> listSaleOrderAndSec(Integer orgId, Integer warehouseId, Integer orderSource, String productName, Long skuId,List<String> orderNos,List<Byte> orderTypes) {
        /**获取订单*/
        String url = "/order/listGroupSettleOrder";
        System.out.println("订单获取" + url);
        String body = "{\"pageSize\":200,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-05-30 23:59:59\",\"orderSource\":\"" + orderSource + "\",\"currentPage\":1,\"orderTypes\":[74,75,76,77,78,119],\"states\":[7,10]}";
        OrderPageParamDTO query = JSON.parseObject(body, OrderPageParamDTO.class);
        query.setProductSkuName(productName);
        if(CollectionUtils.isNotEmpty(orderNos)){
            query.setBusinessNos(orderNos);
        }
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


    /**
     * 查询账单明细
     * @param id
     * @param orgId
     * @return
     */
    public static GroupSettleOrderDetailDTO detail(Long id,Integer orgId) {
        String url = "/groupsettle/detail";
        String body = "{\"id\":\"" + id + "\",\"orgId\":" + orgId + "}";
        String dataList = BaseUtils.postRequest(url, body);
        GroupSettleOrderDetailDTO result = JSON.parseObject(dataList, GroupSettleOrderDetailDTO.class);
        return result;
    }


    /**
     * 查询账单列表
     * @param warehosueId
     * @return
     */
    public static List<GroupSettleOrderQueryDTO> grouplist(Integer warehosueId) {
        String url = "groupsettle/list";
        String body = "{\"warehouseId\":1591,\"settleState\":\"2\",\"pageNum\":1,\"pageSize\":100}";
        GroupSettleOrderPageParamDTO query=JSON.parseObject(body,GroupSettleOrderPageParamDTO.class);
//        query.setSettleNo("DDMC103120210422");
        query.setWarehouseId(warehosueId);
        String dataList = BaseUtils.pageList(url, JSON.toJSONString(query));
        List<GroupSettleOrderQueryDTO> result = JSON.parseArray(dataList, GroupSettleOrderQueryDTO.class);
        return result;
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


    /***
     *获取差异入
     */
    public static List<InStockOrderCommDTO> getChayuRu(String relatedNo, Integer orgId, Integer warehouseid,Long skuId){
        /**获取订单*/
        String url = "/inStockOrder/findInStockOrder";
        String body ="{\"relatedNoteNO\":\""+relatedNo+"\",\"pageNum\":1,\"pageSize\":20,\"orgId\":"+orgId+",\"warehouseId\":"+warehouseid+",\"startTime\":\"2021-03-30 00:00:00\",\"endTime\":\"2021-04-30 23:59:59\",\"orderStateList\":[1,2,3,5]}";
        String dataList = BaseUtils.pageList(url, body);
        List<InStockOrderCommDTO> result = JSON.parseArray(dataList, InStockOrderCommDTO.class);
        if(CollectionUtils.isEmpty(result)){
            return Collections.emptyList();
        }
        for (InStockOrderCommDTO inStockOrderCommDTO : result) {
            List<InStockOrderCommItemDTO> items = inStockOrderCommDTO.getCommItemDTOList().stream().filter(it -> it.getSkuId().equals(skuId)).collect(Collectors.toList());
            inStockOrderCommDTO.setCommItemDTOList(items);
        }

        result = result.stream().filter(it->CollectionUtils.isNotEmpty(it.getCommItemDTOList())).collect(Collectors.toList());
        System.out.println("接口返回数据："+JSON.toJSONString(result));
        return result;
    }


    /***
     *获取差异出
     */
    public static List<OutStockApplyDTO> getChayuChu(String relatedNo, Integer orgId, Integer warehouseid, Long skuId) {
        /**获取订单*/
        String url = "/outStockOrderApply/pageListOutStockApply";
        String body = "{\"currentPage\":1,\"orgId\":" + orgId + ",\"pageSize\":100,\"queryCondition\":1,\"refOrderNo\":\"" + relatedNo + "\",\"warehouseId\":" + warehouseid + "}";
        OutStockApplyQueryDTO queryDTO =JSON.parseObject(body,OutStockApplyQueryDTO.class);
        queryDTO.setBusinessTypes(Arrays.asList((byte)115));
        String dataList = BaseUtils.pageList(url, body);
        List<OutStockApplyDTO> result = JSON.parseArray(dataList, OutStockApplyDTO.class);
        if (CollectionUtils.isEmpty(result)) {
            return Collections.emptyList();
        }


        if (skuId != null) {
            for (OutStockApplyDTO outStockApplyDTO : result) {
                List<OutStockItemApplyDTO> items = outStockApplyDTO.getOutStockItemApplyDTOS().stream().filter(it -> it.getProductSkuId().equals(skuId)).collect(Collectors.toList());
                outStockApplyDTO.setOutStockItemApplyDTOS(items);
            }
        }

        result = result.stream().filter(it -> CollectionUtils.isNotEmpty(it.getOutStockItemApplyDTOS())).collect(Collectors.toList());
        System.out.println("接口返回数据：" + JSON.toJSONString(result));
        return result;
    }

}
