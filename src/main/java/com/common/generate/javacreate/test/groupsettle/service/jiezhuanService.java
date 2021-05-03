package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.test.groupsettle.dto.ErpProductOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleErrorDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleErrorSkuDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderAllPageDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderPageItemDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderItemOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderItemSecOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.WarehouseDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.FileUtil;
import com.common.generate.javacreate.utils.HttpClientUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/4/30 22:26
 */
public class jiezhuanService {
    private static String baseUrl = "http://wms.pre.yijiupi.com/supplyChain/";
    private static final String token = "cbedd29c-5223-4809-91aa-763d276aed4a";



    public static void main(String[] args) throws Exception {
        boolean needContinue =true;
        while (needContinue){
            needContinue = autoFindErrorSku();
        }
        System.out.println("完成");
    }

    public static boolean autoFindErrorSku(){
        Integer orgId =404;
        Integer warehouseId =4041;
        List<GroupSettleErrorDTO> list = listGroupSettleErrorOrder(orgId, warehouseId);
        Map<String, GroupSettleErrorDTO> orderMap = list.stream().collect(Collectors.toMap(GroupSettleErrorDTO::getOrderNo, it -> it, (v1, v2) -> v1));
        System.out.println(JSON.toJSONString(list));
        Collections.reverse(list);
        for (GroupSettleErrorDTO dto : list) {
            if(dto.getOrderType().equals((byte)75)){
                GroupSettleErrorDTO errorDTO ;
                if (dto.getOrderNo().equals("1619746259457100002")) {
                    errorDTO = orderMap.get("1619746259454100001");
                } else if(dto.getOrderNo().equals("1618992216528100002")){
                    errorDTO = orderMap.get("1618992216524100001");
                } else if(dto.getOrderNo().equals("1619317195702100002")){
                    errorDTO = orderMap.get("1619317195699100001");
                }else {
                    long orderNo = Long.parseLong(dto.getOrderNo()) - 1;
                    errorDTO = orderMap.get(String.valueOf(orderNo));
                }

                if(errorDTO==null){
                    throw new BusinessValidateException(dto.getOrderNo()+"结算入不存在");
                }
                findErrorSku(dto,errorDTO);
                System.out.println("结算出"+dto.getOrderNo()+":"+JSON.toJSONString(dto));
                System.out.println("结算入"+errorDTO.getOrderNo()+":"+JSON.toJSONString(errorDTO));
                return true;
            }
        }
        return false;
    }


    public static void findErrorSku(GroupSettleErrorDTO dto,GroupSettleErrorDTO errorDTO){
        if(CollectionUtils.isEmpty(dto.getItems())){
            throw new BusinessValidateException("明细为空");
        }
        /**结转入*/
        Map<Long, GroupSettleErrorSkuDTO> errorMap = errorDTO.getItems().stream().collect(Collectors.toMap(GroupSettleErrorSkuDTO::getSkuId, it -> it, (v1, v2) -> v1));

        /**结算出*/
        for (GroupSettleErrorSkuDTO item : dto.getItems()) {
            List<SettleOrderItemSecOwnerDTO> saleList =new ArrayList<>();

            /**汇总同一个二级货主数量*/
//            Map<Long, List<SettleOrderItemSecOwnerDTO>> saleSecListMap = item.getSaleSkuSecList().stream().collect(Collectors.groupingBy(SettleOrderItemSecOwnerDTO::getSecOwnerId));
            Map<Long, List<SettleOrderItemSecOwnerDTO>> saleSecListMap =new HashMap<>();
            for (SettleOrderItemSecOwnerDTO secOwnerDTO : item.getSaleSkuSecList()) {
                List<SettleOrderItemSecOwnerDTO> dtos = saleSecListMap.get(secOwnerDTO.getSecOwnerId());
                if(CollectionUtils.isNotEmpty(dtos)){
                    dtos.add(secOwnerDTO);
                    saleSecListMap.put(secOwnerDTO.getSecOwnerId(),dtos);
                }else {
                    saleSecListMap.put(secOwnerDTO.getSecOwnerId(),new ArrayList<>(Arrays.asList(secOwnerDTO)));
                }
            }


            for (List<SettleOrderItemSecOwnerDTO> saleSecList : saleSecListMap.values()) {
                BigDecimal addCount = saleSecList.stream().filter(it->it.getSecCount()!=null).map(SettleOrderItemSecOwnerDTO::getSecCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                SettleOrderItemSecOwnerDTO secOwnerDTO = new SettleOrderItemSecOwnerDTO();
                BeanUtils.copyProperties(saleSecList.get(0),secOwnerDTO);
                secOwnerDTO.setSecCount(addCount);
                saleList.add(secOwnerDTO);
            }

            saleList = saleList.stream().sorted(Comparator.comparing(SettleOrderItemSecOwnerDTO::getSecCount).reversed()).collect(Collectors.toList());
            Long secOwnerId = saleList.get(0).getSecOwnerId();

            item.getSettleSkuSecList().forEach(settlesku->{
                settlesku.setSecOwnerId(secOwnerId);
                updateOrderItemOwner(settlesku.getId(),secOwnerId,settlesku.getSecOwnerId());
            });
            GroupSettleErrorSkuDTO errorSkuDTO = errorMap.get(item.getSkuId());
            errorSkuDTO.getSettleSkuSecList().forEach(it->{
                if(!it.getSecOwnerId().equals(secOwnerId)){
                    it.setSecOwnerId(secOwnerId);
                    updateOrderItemOwner(it.getId(),secOwnerId,it.getSecOwnerId());
                }
            });
        }

    }


    public static void lsitAllSku() {
        List<WarehouseDTO> duoduoWarehosue = BaseUtils.getJiezhuanWarehouse(Arrays.asList(4001,7041,1031,1191,7111,4041,4651,7211,1681,4211,4021,1591,4121,4571,4731,7231));
        List<WarehouseDTO> mtWarehosue = BaseUtils.getJiezhuanWarehouse(Arrays.asList(4001,7041,1191,7131,7231));

//        Set<Integer> warehouseAll = new HashSet<>();
//
//        for (WarehouseDTO warehouseDTO : jiezhuanWarehouse) {
//            List<OrderAllPageDTO> listorder = listorder(warehouseDTO.getOrgId(), warehouseDTO.getWarehouseId(),110);
//            if (CollectionUtils.isNotEmpty(listorder)) {
//                warehouseAll.add(warehouseDTO.getWarehouseId());
//            }
//        }
//        System.out.println("所有的仓库id："+JSON.toJSONString(warehouseAll));
    }






    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public static List<OrderAllPageDTO> listSaleOrder(Integer orgId,Integer warehouseId) {
        String url ="/order/listGroupSettleOrder";
        System.out.println("订单获取" + url);
        String body = "{\"pageSize\":100,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"111\",\"currentPage\":1,\"orderTypes\":[119]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        List<Long> orderIds = orderAllPageDTOS.stream().map(it -> Long.valueOf(it.getOrderId())).collect(Collectors.toList());
        Map<Long, List<SettleOrderItemSecOwnerDTO>> orderSecMap = selectOrderItemOwnerByOrderIds(orderIds);
        for (OrderAllPageDTO orderAllPageDTO : orderAllPageDTOS) {
            List<SettleOrderItemSecOwnerDTO> orderItemSecOwnerList = orderSecMap.get(Long.valueOf(orderAllPageDTO.getOrderId()));
            Map<Long, List<SettleOrderItemSecOwnerDTO>> itemSecMap = orderItemSecOwnerList.stream().collect(Collectors.groupingBy(it -> it.getOmsOrdetItemId()));
            for (OrderPageItemDTO item : orderAllPageDTO.getItems()) {
                List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = itemSecMap.get(item.getOrderItemId());
                secOwnerDTOS.stream().forEach(it->{
                    it.setOrderCreateTime(orderAllPageDTO.getOrderCreateTime());
                    it.setOrderCompleteTime(orderAllPageDTO.getOrderCompleteTime());
                    it.setOrderNo(orderAllPageDTO.getBusinessNo());
                    it.setOrderType(orderAllPageDTO.getOrderType());
                });
                item.setItemDetails(secOwnerDTOS);
            }
        }
        System.out.println(JSON.toJSONString(orderAllPageDTOS));
        return orderAllPageDTOS;
    }

    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public static List<GroupSettleErrorDTO> listGroupSettleErrorOrder(Integer orgId,Integer warehouseId) {
        String url ="/groupsettle/listGroupSettleErrorOrder";
        System.out.println("订单获取" + url);
        String body = "{\"pageSize\":200,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"111\",\"currentPage\":1,\"orderTypes\":[75,76],\"states\":[7,10]}";
        String dataList = BaseUtils.list(url, body);
        List<GroupSettleErrorDTO> groupSettleErrorDTOS = JSON.parseArray(dataList, GroupSettleErrorDTO.class);
        return groupSettleErrorDTOS;
    }


    public static List<OrderAllPageDTO> listorder(Integer orgId, Integer warehosueId) {
        String url = "order/listGroupSettleOrder";
        String body = "{\"pageSize\":200,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehosueId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"110\",\"currentPage\":1,\"orderTypes\":[75,76],\"states\":[7,10]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        return orderAllPageDTOS;
    }

    public static List<OrderAllPageDTO> listorder(Integer orgId, Integer warehosueId,Integer orderSource) {
        String url = "order/listGroupSettleOrder";
        String body = "{\"pageSize\":1,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehosueId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"" + orderSource + "\",\"currentPage\":1,\"orderTypes\":[75,76],\"states\":[7,10]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        return orderAllPageDTOS;
    }




    /**
     * 根据订单id获取二级货主数据
     * @param orderIds
     * @return
     */
    public static Map<Long, List<SettleOrderItemSecOwnerDTO>> selectOrderItemOwnerByOrderIds(List<Long> orderIds){
        String url = "/groupsettle/selectOrderItemOwnerByOrderIds";
        String dataList = BaseUtils.list(url, JSON.toJSONString(orderIds));
        List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = JSON.parseArray(dataList, SettleOrderItemSecOwnerDTO.class);
        Map<Long, List<SettleOrderItemSecOwnerDTO>> secMap = secOwnerDTOS.stream().collect(Collectors.groupingBy(it -> it.getOmsOrderId()));
        return secMap;
    }



    public static void updateOrderItemOwner(Long id,Long secOwnerId,Long oldSecOwnerId){
        SettleOrderItemOwnerDTO  dto =new SettleOrderItemOwnerDTO();
        dto.setId(id);
        if(secOwnerId==null){
            dto.setAddSecProductOwnerId(-1L);
            dto.setDispatchSecProductOwnerId(-1L);
            dto.setStockinSecProductOwnerId(-1L);
        }else {
            dto.setAddSecProductOwnerId(secOwnerId);
            dto.setDispatchSecProductOwnerId(secOwnerId);
            dto.setStockinSecProductOwnerId(secOwnerId);
        }
        dto.setOldSecOwerId(oldSecOwnerId);
        FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\二级货主修改日志.txt", DateUtils.getCurrentTimes()+" : " +JSON.toJSONString(dto));
//        System.out.println("二级货主修改参数：" + JSON.toJSONString(dto));
        String url ="/groupsettle/updateOrderItemOwner";
        BaseUtils.list(url, JSON.toJSONString(dto));
    }







}
