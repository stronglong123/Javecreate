package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.groupsettle.dto.ErpProductOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderAllPageDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderPageItemDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderItemSecOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.WarehouseDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.FileUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
public class MergeService {

    public static void main(String[] args) throws Exception {
//        List<ErpProductOwnerDTO> jiesuanOrder = getJiesuanChuOrder();
//        List<ErpProductOwnerDTO> jiesuanRuOrder = getJiesuanRuOrder();
//        List<ErpProductOwnerDTO> chayiOrder = getChayiOrder();

//        System.out.println("结算出：" + JSON.toJSONString(jiesuanOrder));
//        System.out.println("结算入："+JSON.toJSONString(jiesuanRuOrder));
//        System.out.println("差异："+JSON.toJSONString(chayiOrder));

        Map<String, List<Long>> warehouseProduct = getChayiWarehouseProduct();

        Map<String, String> secOwnerMap = findSaleProductSecOwner(723, 7231, new HashSet<>(), warehouseProduct.get(String.valueOf(7231)));
        System.out.println(JSON.toJSONString(secOwnerMap));

    }


    /**
     * 获取结算单数据
     *
     * @return
     */
    private static List<ErpProductOwnerDTO> getJiesuanChuOrder() {
        List<ErpProductOwnerDTO> getallerpdata = geterpjiesuandata();
        List<ErpProductOwnerDTO> geterpdata = getallerpdata.stream().filter(it -> it.getOrderType().equals(77)).collect(Collectors.toList());
        Map<String, String> productSecOwner = new HashMap<>();
        Set<String> secOwnerList = new HashSet<>();
        List<WarehouseDTO> warehouse = BaseUtils.getJiesuanWarehouse();
        Map<String, List<Long>> warehouseProduct = getJiesuanWarehouseProduct();

        for (WarehouseDTO dto : warehouse) {
            List<Long> skuIds = warehouseProduct.get(dto.getWarehouseId().toString());
            Map<String, String> secOwnerMap = findSaleProductSecOwner(dto.getOrgId(), dto.getWarehouseId(), secOwnerList, skuIds);
            productSecOwner.putAll(secOwnerMap);
        }

        System.out.println("产品二级货主数据:" + JSON.toJSONString(productSecOwner));
        System.out.println("所有二级货主：" + JSON.toJSONString(secOwnerList));
        Map<String, String> owerMap = BaseUtils.getErpOwner();
        geterpdata.forEach(it -> {
            String owner = productSecOwner.get(it.getProductSkuId().toString());
            it.setTureWmsOwnerId(owner);
            it.setTureErpOwnerId(BaseUtils.getErpOwnerString(owerMap, owner));

        });
        System.out.println(JSON.toJSONString(geterpdata));

        geterpdata.forEach(it -> it.setType("结算单"));
        return geterpdata;
    }


    /**
     * 获取结算单数据
     *
     * @return
     */
    private static List<ErpProductOwnerDTO> getJiesuanRuOrder() {
        List<ErpProductOwnerDTO> getallerpdata = geterpjiesuandata();
        List<ErpProductOwnerDTO> geterpdata = getallerpdata.stream().filter(it -> it.getOrderType().equals(78)).collect(Collectors.toList());
        Map<String, String> productSecOwner = new HashMap<>();
        Set<String> secOwnerList = new HashSet<>();
        Map<String, List<Long>> warehouseProduct = getJiesuanWarehouseProduct();

        List<WarehouseDTO> warehouse = BaseUtils.getJiesuanWarehouse();
        for (WarehouseDTO dto : warehouse) {
            List<Long> skuIds = warehouseProduct.get(dto.getWarehouseId().toString());
            Map<String, String> secOwnerMap = findJiesuaSaleAndReturnProductSecOwner(dto.getOrgId(), dto.getWarehouseId(), secOwnerList, skuIds);
            productSecOwner.putAll(secOwnerMap);
        }

        System.out.println("产品二级货主数据:" + JSON.toJSONString(productSecOwner));
        System.out.println("所有二级货主：" + JSON.toJSONString(secOwnerList));
        Map<String, String> owerMap = BaseUtils.getErpOwner();
        geterpdata.forEach(it -> {
            String owner = productSecOwner.get(it.getProductSkuId().toString());
            it.setTureWmsOwnerId(owner);
            it.setTureErpOwnerId(BaseUtils.getErpOwnerString(owerMap, owner));

        });
        System.out.println(JSON.toJSONString(geterpdata));

        geterpdata.forEach(it -> it.setType("结算单"));
        return geterpdata;
    }


    /**
     * 获取差异单
     *
     * @return
     */
    private static List<ErpProductOwnerDTO> getChayiOrder() {
        List<ErpProductOwnerDTO> geterpdata = getChayierpdata();
        Map<String, String> productSecOwner = new HashMap<>();
        Set<String> secOwnerList = new HashSet<>();
        List<WarehouseDTO> warehouse = BaseUtils.getChayiWarehouse();
        Map<String, List<Long>> warehouseProduct = getChayiWarehouseProduct();

        for (WarehouseDTO dto : warehouse) {
            List<Long> skuIds = warehouseProduct.get(dto.getWarehouseId().toString());
            Map<String, String> secOwnerMap = findSaleProductSecOwner(dto.getOrgId(), dto.getWarehouseId(), secOwnerList, skuIds);
            productSecOwner.putAll(secOwnerMap);
        }

        System.out.println("产品二级货主数据:" + JSON.toJSONString(productSecOwner));
        System.out.println("所有二级货主：" + JSON.toJSONString(secOwnerList));
        Map<String, String> owerMap = BaseUtils.getErpOwner();
        geterpdata.forEach(it -> {
            String owner = productSecOwner.get(it.getProductSkuId().toString());
            it.setTureWmsOwnerId(owner);
            it.setTureErpOwnerId(BaseUtils.getErpOwnerString(owerMap, owner));

        });

        System.out.println(JSON.toJSONString(geterpdata));
        geterpdata.forEach(it -> it.setType("差异单"));
        return geterpdata;
    }


    private List<ErpProductOwnerDTO> margeCount(List<ErpProductOwnerDTO> list) {
        List<ErpProductOwnerDTO> result = new ArrayList<>();
        /**合并数量,产品加规格分组，每组根据出入加减*/
        Map<String, List<ErpProductOwnerDTO>> map = list.stream().collect(Collectors.groupingBy(it -> it.getProductSkuId() + "_" + it.getErrorWmsOwnerId()));
        for (List<ErpProductOwnerDTO> value : map.values()) {
            BigDecimal addCount = value.stream().map(it -> it.getUnitTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            ErpProductOwnerDTO dto = new ErpProductOwnerDTO();
            BeanUtils.copyProperties(value.get(0), dto);
            dto.setOrderType(null);
            dto.setUnitTotalCount(addCount);
            result.add(dto);
        }
        return result;
    }

    /**
     * 查询出库单所有产品
     *
     * @param orgId
     * @param warehouseId
     * @param secOwnerList
     * @return
     */
    public static Map<String, String> findSaleProductSecOwner(Integer orgId, Integer warehouseId, Set<String> secOwnerList, List<Long> skuIds) {
        /**查询销售出库单*/
        List<OrderAllPageDTO> orderList = listSaleOrder(orgId, warehouseId);
        System.out.println("销售出和退货入:"+ JSON.toJSONString(orderList));
        List<SettleOrderItemSecOwnerDTO> dtoList = orderList.stream()
                .filter(it -> CollectionUtils.isNotEmpty(it.getItems()))
                .flatMap(it -> it.getItems().stream())
                .filter(it -> CollectionUtils.isNotEmpty(it.getItemDetails()))
                .flatMap(it -> it.getItemDetails().stream())
                .filter(it -> skuIds.contains(it.getProductSkuId())).collect(Collectors.toList());

        Set<String> allOwnerSet = dtoList.stream().map(it -> String.valueOf(it.getSecOwnerId())).collect(Collectors.toSet());
        secOwnerList.addAll(allOwnerSet);
        Map<String, List<SettleOrderItemSecOwnerDTO>> listMap = dtoList.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getProductSkuId())));

        Map<String, String> secMap = new HashMap<>();
        for (Map.Entry<String, List<SettleOrderItemSecOwnerDTO>> entry : listMap.entrySet()) {
            Set<String> secSet = entry.getValue().stream().map(it -> String.valueOf(it.getSecOwnerId())).collect(Collectors.toSet());
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : secSet) {
                stringBuilder.append(s).append(",");
            }
            secMap.put(entry.getKey(), stringBuilder.toString());
        }
        return secMap;
    }


    public static Map<String, String> findJiesuaSaleAndReturnProductSecOwner(Integer orgId, Integer warehouseId, Set<String> secOwnerList, List<Long> skuIds) {
        /**查询销售出库单*/
        List<OrderAllPageDTO> orderList = listSaleAndReturnOrder(orgId, warehouseId);
        List<SettleOrderItemSecOwnerDTO> dtoList = orderList.stream()
                .filter(it -> CollectionUtils.isNotEmpty(it.getItems()))
                .flatMap(it -> it.getItems().stream())
                .filter(it -> CollectionUtils.isNotEmpty(it.getItemDetails()))
                .flatMap(it -> it.getItemDetails().stream())
                .filter(it -> skuIds.contains(it.getProductSkuId())).collect(Collectors.toList());
        Set<String> allOwnerSet = dtoList.stream().map(it -> String.valueOf(it.getSecOwnerId())).collect(Collectors.toSet());
        secOwnerList.addAll(allOwnerSet);
        Map<String, List<SettleOrderItemSecOwnerDTO>> skuOwnerMap = dtoList.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getProductSkuId())));

        Map<String, String> secMap = new HashMap<>();
        for (Map.Entry<String, List<SettleOrderItemSecOwnerDTO>> entry : skuOwnerMap.entrySet()) {
            Set<String> secSet = entry.getValue().stream().map(it -> String.valueOf(it.getSecOwnerId())).collect(Collectors.toSet());
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : secSet) {
                stringBuilder.append(s).append(",");
            }
            secMap.put(entry.getKey(), stringBuilder.toString());
        }
        return secMap;
    }


    /**
     * 获取订单
     */
    public static List<OrderAllPageDTO> listSaleOrder(Integer orgId, Integer warehouseId) {
        List<OrderAllPageDTO> orderAllPageDTOS = listGroupSettleOrder(orgId, warehouseId);
        if (CollectionUtils.isEmpty(orderAllPageDTOS)) {
            return Collections.emptyList();
        }
        List<Long> orderIds = orderAllPageDTOS.stream().map(it -> Long.valueOf(it.getOrderId())).collect(Collectors.toList());
        Map<Long, List<SettleOrderItemSecOwnerDTO>> orderSecMap = selectOrderItemOwnerByOrderIds(orderIds);
        for (OrderAllPageDTO orderAllPageDTO : orderAllPageDTOS) {
            List<SettleOrderItemSecOwnerDTO> orderItemSecOwnerList = orderSecMap.get(Long.valueOf(orderAllPageDTO.getOrderId()));
            Map<Long, List<SettleOrderItemSecOwnerDTO>> itemSecMap = orderItemSecOwnerList.stream().collect(Collectors.groupingBy(it -> it.getOmsOrdetItemId()));
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
        System.out.println(JSON.toJSONString(orderAllPageDTOS));
        return orderAllPageDTOS;
    }

    public static List<OrderAllPageDTO> listSaleAndReturnOrder(Integer orgId, Integer warehouseId) {
        List<OrderAllPageDTO> orderAllPageDTOS = listGroupSettleAndReturnOrder(orgId, warehouseId);
        if (CollectionUtils.isEmpty(orderAllPageDTOS)) {
            return Collections.emptyList();
        }
        List<Long> orderIds = orderAllPageDTOS.stream().map(it -> Long.valueOf(it.getOrderId())).collect(Collectors.toList());
        Map<Long, List<SettleOrderItemSecOwnerDTO>> orderSecMap = selectOrderItemOwnerByOrderIds(orderIds);
        for (OrderAllPageDTO orderAllPageDTO : orderAllPageDTOS) {
            List<SettleOrderItemSecOwnerDTO> orderItemSecOwnerList = orderSecMap.get(Long.valueOf(orderAllPageDTO.getOrderId()));
            Map<Long, List<SettleOrderItemSecOwnerDTO>> itemSecMap = orderItemSecOwnerList.stream().collect(Collectors.groupingBy(it -> it.getOmsOrdetItemId()));
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
        System.out.println(JSON.toJSONString(orderAllPageDTOS));
        return orderAllPageDTOS;
    }


    public static List<OrderAllPageDTO> listGroupSettleAndReturnOrder(Integer orgId, Integer warehouseId) {
        List<OrderAllPageDTO> result = new ArrayList<>();
        List<OrderAllPageDTO> orderAllPage1 = listGroupSettleAndReturnOrder(orgId, warehouseId, 111);
        List<OrderAllPageDTO> orderAllPage2 = listGroupSettleAndReturnOrder(orgId, warehouseId, 110);
        if (CollectionUtils.isNotEmpty(orderAllPage1)) {
            result.addAll(orderAllPage1);
        }
        if (CollectionUtils.isNotEmpty(orderAllPage2)) {
            result.addAll(orderAllPage2);
        }
        return result;
    }

    public static List<OrderAllPageDTO> listGroupSettleOrder(Integer orgId, Integer warehouseId) {
        List<OrderAllPageDTO> result = new ArrayList<>();
        List<OrderAllPageDTO> orderAllPage1 = listGroupSettleOrder(orgId, warehouseId, 111);
        List<OrderAllPageDTO> orderAllPage2 = listGroupSettleOrder(orgId, warehouseId, 110);
        if (CollectionUtils.isNotEmpty(orderAllPage1)) {
            result.addAll(orderAllPage1);
        }
        if (CollectionUtils.isNotEmpty(orderAllPage2)) {
            result.addAll(orderAllPage2);
        }
        return result;
    }


    /**
     * 根据订单id获取二级货主数据
     *
     * @param orderIds
     * @return
     */
    public static List<OrderAllPageDTO> listGroupSettleOrder(Integer orgId, Integer warehouseId, Integer orderSource) {
        String url = "/order/listGroupSettleOrder";
        System.out.println("订单获取" + url);
        String body = "{\"pageSize\":100,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"" + orderSource + "\",\"currentPage\":1,\"orderTypes\":[119,74]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        return orderAllPageDTOS;
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
        String body = "{\"pageSize\":100,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"" + orderSource + "\",\"currentPage\":1,\"orderTypes\":[119,74]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        return orderAllPageDTOS;
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


    /**
     * 获取差异单
     *
     * @return
     */
    public static List<ErpProductOwnerDTO> getChayierpdata() {
        String text = "[{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"cb1a0a65e97e4ad48a9d241e75d059d6\",\"errorWmsOwnerId\":1395869718239580157,\"orderNo\":\"DDMC704120210419\",\"orgId\":704,\"productName\":\"伊利优酸乳原味250ml（1*24）\",\"productSkuId\":70400003872819,\"specId\":3872,\"unitTotalCount\":14.237538,\"warehouseId\":7041},{\"date\":\"2021-04-18 00:00:00\",\"orderNo\":\"DDMC704120210419\",\"orgId\":704,\"productName\":\"太原高粱白【升级版】42度450ml（1*12）\",\"productSkuId\":70400058662050,\"specId\":58662,\"unitTotalCount\":14.458647,\"warehouseId\":7041},{\"date\":\"2021-04-25 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210426\",\"orgId\":400,\"productName\":\"康师傅包装饮用水[瓶]550ml（1*28）\",\"productSkuId\":4867681516293513043,\"specId\":370265,\"unitTotalCount\":112.000000,\"warehouseId\":4001},{\"date\":\"2021-04-25 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210426\",\"orgId\":400,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":40000002257189,\"specId\":2257,\"unitTotalCount\":3.000000,\"warehouseId\":4001},{\"date\":\"2021-04-25 00:00:00\",\"errorErpOwnerId\":\"5415013070959675082\",\"errorWmsOwnerId\":1395869718239566340,\"orderNo\":\"DDMC400120210426\",\"orgId\":400,\"productName\":\"蒙牛特仑苏（纯牛奶）250ml（1*12）\",\"productSkuId\":40000004919492,\"specId\":4919,\"unitTotalCount\":9.000000,\"warehouseId\":4001},{\"date\":\"2021-04-25 00:00:00\",\"errorErpOwnerId\":\"a56ba2f7277a46febc36e61b9489c7af\",\"errorWmsOwnerId\":1395869718239576507,\"orderNo\":\"DDMC400120210426\",\"orgId\":400,\"productName\":\"康师傅香辣牛肉面桶装108g（1*12）\",\"productSkuId\":40000011177290,\"specId\":11177,\"unitTotalCount\":40.000000,\"warehouseId\":4001},{\"date\":\"2021-04-24 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210425\",\"orgId\":400,\"productName\":\"康师傅包装饮用水[瓶]550ml（1*28）\",\"productSkuId\":4867681516293513043,\"specId\":370265,\"unitTotalCount\":3.000000,\"warehouseId\":4001},{\"date\":\"2021-04-24 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210425\",\"orgId\":400,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":40000002257189,\"specId\":2257,\"unitTotalCount\":336.000000,\"warehouseId\":4001},{\"date\":\"2021-04-23 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210424\",\"orgId\":400,\"productName\":\"美汁源果粒橙420ml（1*12）\",\"productSkuId\":40000125367050,\"specId\":125367,\"unitTotalCount\":0.004286,\"warehouseId\":4001},{\"date\":\"2021-04-23 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210424\",\"orgId\":400,\"productName\":\"康师傅包装饮用水[瓶]550ml（1*28）\",\"productSkuId\":4867681516293513043,\"specId\":370265,\"unitTotalCount\":26.772308,\"warehouseId\":4001},{\"date\":\"2021-04-23 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210424\",\"orgId\":400,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":40000002257189,\"specId\":2257,\"unitTotalCount\":4.260551,\"warehouseId\":4001},{\"date\":\"2021-04-23 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210424\",\"orgId\":400,\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":40000001188672,\"specId\":1188,\"unitTotalCount\":11.760000,\"warehouseId\":4001},{\"date\":\"2021-04-23 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210424\",\"orgId\":400,\"productName\":\"冰露饮用纯净水550ml（1*24）\",\"productSkuId\":40000008122805,\"specId\":8122,\"unitTotalCount\":3.648000,\"warehouseId\":4001},{\"date\":\"2021-04-22 00:00:00\",\"errorErpOwnerId\":\"5c073d11239040fcbd4509a94f045aa8\",\"errorWmsOwnerId\":1395869718239569085,\"orderNo\":\"DDMC400120210423\",\"orgId\":400,\"productName\":\"康师傅包装饮用水[瓶]550ml（1*28）\",\"productSkuId\":4867681516293513043,\"specId\":370265,\"unitTotalCount\":155.184615,\"warehouseId\":4001},{\"date\":\"2021-04-22 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210423\",\"orgId\":400,\"productName\":\"康师傅香辣牛肉面桶装108g（1*12）\",\"productSkuId\":40000011177290,\"specId\":11177,\"unitTotalCount\":30.000000,\"warehouseId\":4001},{\"date\":\"2021-04-21 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210422\",\"orgId\":400,\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":40000001188672,\"specId\":1188,\"unitTotalCount\":11.680000,\"warehouseId\":4001},{\"date\":\"2021-04-21 00:00:00\",\"errorErpOwnerId\":\"dee89d942e8c43e5b9c4b023f8d4b6a8\",\"errorWmsOwnerId\":1395869718239582114,\"orderNo\":\"DDMC400120210422\",\"orgId\":400,\"productName\":\"美汁源果粒橙1.8L（1*6）\",\"productSkuId\":40000003839768,\"specId\":3839,\"unitTotalCount\":0.481304,\"warehouseId\":4001},{\"date\":\"2021-04-21 00:00:00\",\"errorErpOwnerId\":\"0de1086f242645d6aa1ac0c083921164\",\"errorWmsOwnerId\":1395869718239554799,\"orderNo\":\"DDMC400120210422\",\"orgId\":400,\"productName\":\"古越龙山清醇三年500ml\",\"productSkuId\":40000000314758,\"specId\":314,\"unitTotalCount\":9.637681,\"warehouseId\":4001},{\"date\":\"2021-04-20 00:00:00\",\"errorErpOwnerId\":\"f4c36f98-756e-4dbc-8761-6670f02a02bb\",\"errorWmsOwnerId\":1395869718392263257,\"orderNo\":\"DDMC400120210421\",\"orgId\":400,\"productName\":\"汾酒光瓶53度475ml（1*12）\",\"productSkuId\":40000000274708,\"specId\":274,\"unitTotalCount\":1.000000,\"warehouseId\":4001},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210420\",\"orgId\":400,\"productName\":\"冰露饮用纯净水550ml（1*24）\",\"productSkuId\":40000008122805,\"specId\":8122,\"unitTotalCount\":24.000000,\"warehouseId\":4001},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210420\",\"orgId\":400,\"productName\":\"美汁源果粒橙420ml（1*12）\",\"productSkuId\":40000125367050,\"specId\":125367,\"unitTotalCount\":47.400000,\"warehouseId\":4001},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"dee89d942e8c43e5b9c4b023f8d4b6a8\",\"errorWmsOwnerId\":1395869718239582114,\"orderNo\":\"DDMC400120210420\",\"orgId\":400,\"productName\":\"美汁源果粒橙1.8L（1*6）\",\"productSkuId\":40000003839768,\"specId\":3839,\"unitTotalCount\":23.926957,\"warehouseId\":4001},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"644fc7e59ac14f208c8b81deaab80a80\",\"errorWmsOwnerId\":1395869718239569899,\"orderNo\":\"DDMC400120210420\",\"orgId\":400,\"productName\":\"蒙牛特仑苏（纯牛奶）250ml（1*12）\",\"productSkuId\":40000004919492,\"specId\":4919,\"unitTotalCount\":12.000000,\"warehouseId\":4001},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210420\",\"orgId\":400,\"productName\":\"旺仔牛奶8罐*245ml+旺旺O泡果奶原味4罐*245ml\",\"productSkuId\":4864434714945576796,\"specId\":381180,\"unitTotalCount\":3.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":40000001548114,\"specId\":1548,\"unitTotalCount\":120.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"旺仔牛奶8罐*245ml+旺旺O泡果奶原味4罐*245ml\",\"productSkuId\":4864434714945576796,\"specId\":381180,\"unitTotalCount\":0.999770,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"雀巢咖啡丝滑拿铁268ml（1*15）\",\"productSkuId\":40000002112159,\"specId\":2112,\"unitTotalCount\":30.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":40000001188672,\"specId\":1188,\"unitTotalCount\":23.840000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"康师傅红烧牛肉面108g（1*12）\",\"productSkuId\":40000007147440,\"specId\":7147,\"unitTotalCount\":60.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"d771a5f1d3934300a10a45f6ead7f4e0\",\"errorWmsOwnerId\":1395869718239581420,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"脉动青柠口味600ml（1*15）\",\"productSkuId\":40000001542800,\"specId\":1542,\"unitTotalCount\":15.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"13a95dc0bc984609ab054b857ef5ed80\",\"errorWmsOwnerId\":1395869718239555488,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"冰露饮用纯净水550ml（1*24）\",\"productSkuId\":40000008122805,\"specId\":8122,\"unitTotalCount\":528.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"王老吉（听装）310ml（1*24）\",\"productSkuId\":40000002057402,\"specId\":2057,\"unitTotalCount\":48.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"a9c5819a733e4705a59d129d1500ba91\",\"errorWmsOwnerId\":1395869718239576923,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"美汁源果粒橙420ml（1*12）\",\"productSkuId\":40000125367050,\"specId\":125367,\"unitTotalCount\":36.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"496d871e8cdb4c46a57e220137a5922b\",\"errorWmsOwnerId\":1395869718239562859,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"绵柔尖庄（红）42度500ml（1*4）\",\"productSkuId\":4810048808338993613,\"specId\":334557,\"unitTotalCount\":4.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"今麦郎软化纯净水550ml（1*24）\",\"productSkuId\":40000025226449,\"specId\":25226,\"unitTotalCount\":48.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"33e34ea3b29d4458b0891e8dfefe4b79\",\"errorWmsOwnerId\":1395869718239558853,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"七度空间（QUC8110）优雅系列卫生巾空气感日用丝柔超薄（10片）245mm\",\"productSkuId\":40000031358303,\"specId\":31358,\"unitTotalCount\":2.000000,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"13a95dc0bc984609ab054b857ef5ed80\",\"errorWmsOwnerId\":1395869718239555488,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":40000002257189,\"specId\":2257,\"unitTotalCount\":311.685138,\"warehouseId\":4001},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"496d871e8cdb4c46a57e220137a5922b\",\"errorWmsOwnerId\":1395869718239562859,\"orderNo\":\"DDMC400120210419\",\"orgId\":400,\"productName\":\"牛栏山陈酿42度500ml（1*12）\",\"productSkuId\":40000000311338,\"specId\":311,\"unitTotalCount\":22.000000,\"warehouseId\":4001},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"6f4a73bb-37a1-4c58-85cb-f0a723788084\",\"errorWmsOwnerId\":1395869718239571015,\"orderNo\":\"MTYX400120210422\",\"orgId\":400,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":40000002257189,\"specId\":2257,\"unitTotalCount\":24.000000,\"warehouseId\":4001},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"6f4a73bb-37a1-4c58-85cb-f0a723788084\",\"errorWmsOwnerId\":1395869718239571015,\"orderNo\":\"MTYX400120210420\",\"orgId\":400,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":40000002257189,\"specId\":2257,\"unitTotalCount\":48.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"dee89d942e8c43e5b9c4b023f8d4b6a8\",\"errorWmsOwnerId\":1395869718239582114,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":40000001548114,\"specId\":1548,\"unitTotalCount\":167.990204,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"dee89d942e8c43e5b9c4b023f8d4b6a8\",\"errorWmsOwnerId\":1395869718239582114,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":40000001188672,\"specId\":1188,\"unitTotalCount\":36.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"65dad4901c894f429f1004ecbf1a60df\",\"errorWmsOwnerId\":1395869718239570091,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"康师傅红烧牛肉面108g（1*12）\",\"productSkuId\":40000007147440,\"specId\":7147,\"unitTotalCount\":48.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"a9c5819a733e4705a59d129d1500ba91\",\"errorWmsOwnerId\":1395869718239576923,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"冰露饮用纯净水550ml（1*24）\",\"productSkuId\":40000008122805,\"specId\":8122,\"unitTotalCount\":120.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"5385492797905426051\",\"errorWmsOwnerId\":1395869718239566116,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"王老吉（听装）310ml（1*24）\",\"productSkuId\":40000002057402,\"specId\":2057,\"unitTotalCount\":120.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"dee89d942e8c43e5b9c4b023f8d4b6a8\",\"errorWmsOwnerId\":1395869718239582114,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"美汁源果粒橙420ml（1*12）\",\"productSkuId\":40000125367050,\"specId\":125367,\"unitTotalCount\":36.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"496d871e8cdb4c46a57e220137a5922b\",\"errorWmsOwnerId\":1395869718239562859,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"牛栏山陈酿42度500ml（1*12）\",\"productSkuId\":40000000311338,\"specId\":311,\"unitTotalCount\":14.200000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"5c073d11239040fcbd4509a94f045aa8\",\"errorWmsOwnerId\":1395869718239569085,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"康师傅包装饮用水[瓶]550ml（1*28）\",\"productSkuId\":4867681516293513043,\"specId\":370265,\"unitTotalCount\":28.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"644fc7e59ac14f208c8b81deaab80a80\",\"errorWmsOwnerId\":1395869718239569899,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"蒙牛特仑苏（纯牛奶）250ml（1*12）\",\"productSkuId\":40000004919492,\"specId\":4919,\"unitTotalCount\":83.889438,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"33e34ea3b29d4458b0891e8dfefe4b79\",\"errorWmsOwnerId\":1395869718239558853,\"orderNo\":\"DDMC400120210418\",\"orgId\":400,\"productName\":\"七度空间（QUC8110）优雅系列卫生巾空气感日用丝柔超薄（10片）245mm\",\"productSkuId\":40000031358303,\"specId\":31358,\"unitTotalCount\":1.000000,\"warehouseId\":4001},{\"date\":\"\",\"errorErpOwnerId\":\"2101e1617de347c097400f652c40a329\",\"errorWmsOwnerId\":1395869718239556789,\"orderNo\":\"DDMC119120210420\",\"orgId\":119,\"productName\":\"乐虎380ml（1*15）\",\"productSkuId\":11900003173415,\"specId\":3173,\"unitTotalCount\":74.856383,\"warehouseId\":1191},{\"date\":\"\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC119120210420\",\"orgId\":119,\"productName\":\"水润坊能量100牛磺酸强化型维生素饮料600ml（1*15）\",\"productSkuId\":11900107485366,\"specId\":107485,\"unitTotalCount\":135.000000,\"warehouseId\":1191},{\"date\":\"\",\"errorErpOwnerId\":\"4631018059840549903\",\"errorWmsOwnerId\":1395869718239560776,\"orderNo\":\"DDMC119120210420\",\"orgId\":119,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":11900002257872,\"specId\":2257,\"unitTotalCount\":78.497455,\"warehouseId\":1191},{\"date\":\"\",\"errorErpOwnerId\":\"2101e1617de347c097400f652c40a329\",\"errorWmsOwnerId\":1395869718239556789,\"orderNo\":\"DDMC119120210419\",\"orgId\":119,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":11900002257872,\"specId\":2257,\"unitTotalCount\":95.476364,\"warehouseId\":1191},{\"date\":\"\",\"errorErpOwnerId\":\"00fea80105fc474cab0fbc0a97a860dd\",\"errorWmsOwnerId\":1395869718239553509,\"orderNo\":\"DDMC711120210419\",\"orgId\":711,\"productName\":\"娃哈哈饮用天然矿泉水4.5L（1*4）\",\"productSkuId\":4911289754947203800,\"specId\":277444,\"unitTotalCount\":4.000000,\"warehouseId\":7111},{\"date\":\"\",\"errorErpOwnerId\":\"6aa6a3dc754343d98ebd7b1f98b3e137\",\"errorWmsOwnerId\":1395869718239570580,\"orderNo\":\"DDMC711120210419\",\"orgId\":711,\"productName\":\"雕牌全效加浓洗洁精1.5kg\",\"productSkuId\":71100083356891,\"specId\":83356,\"unitTotalCount\":4.228571,\"warehouseId\":7111},{\"date\":\"\",\"errorErpOwnerId\":\"6aa6a3dc754343d98ebd7b1f98b3e137\",\"errorWmsOwnerId\":1395869718239570580,\"orderNo\":\"DDMC711120210418\",\"orgId\":711,\"productName\":\"雕牌全效加浓洗洁精1.5kg\",\"productSkuId\":71100083356891,\"specId\":83356,\"unitTotalCount\":398.000000,\"warehouseId\":7111},{\"date\":\"\",\"orderNo\":\"DDMC711120210418\",\"orgId\":711,\"productName\":\"秋林格瓦斯350ml（1*12）\",\"productSkuId\":71100009754035,\"specId\":9754,\"unitTotalCount\":11.768889,\"warehouseId\":7111},{\"date\":\"\",\"orderNo\":\"DDMC711120210418\",\"orgId\":711,\"productName\":\"立白新金桔洗洁精1kg+120g（1*10）\",\"productSkuId\":71100045702871,\"specId\":45702,\"unitTotalCount\":44.000000,\"warehouseId\":7111},{\"date\":\"\",\"orderNo\":\"DDMC711120210418\",\"orgId\":711,\"productName\":\"金沙河刀削原味面片200g（1*25）\",\"productSkuId\":4798125746493601992,\"specId\":48025,\"unitTotalCount\":3.000000,\"warehouseId\":7111},{\"date\":\"2021-04-19 00:00:00\",\"errorWmsOwnerId\":1395869718239559734,\"orderNo\":\"DDMC103120210420\",\"orgId\":103,\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":10300001188290,\"specId\":1188,\"unitTotalCount\":22.749851,\"warehouseId\":1031},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"66f86c68a2b44e6f85681b78e1aa4713\",\"errorWmsOwnerId\":1395869718239570212,\"orderNo\":\"DDMC103120210420\",\"orgId\":103,\"productName\":\"怡宝水555ml （1*24）\",\"productSkuId\":10300001198659,\"specId\":1198,\"unitTotalCount\":24.000000,\"warehouseId\":1031},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"2e4bbb973b83461cb5748aa75bf5355d\",\"errorWmsOwnerId\":1395869718239558274,\"orderNo\":\"DDMC103120210420\",\"orgId\":103,\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":10300002257379,\"specId\":2257,\"unitTotalCount\":23.222143,\"warehouseId\":1031},{\"date\":\"\",\"errorErpOwnerId\":\"09003312-b024-4298-99e8-eefcb47a6bac\",\"errorWmsOwnerId\":1395869718368273196,\"orderNo\":\"DDMC103120210418\",\"orgId\":103,\"productName\":\"黄鹤楼升级版15年42度500ml（1*6）\",\"productSkuId\":10300034772186,\"specId\":34772,\"unitTotalCount\":12.000000,\"warehouseId\":1031},{\"date\":\"\",\"errorErpOwnerId\":\"45138ca865384a068ca8684b579b5def\",\"errorWmsOwnerId\":1395869718239560582,\"orderNo\":\"DDMC103120210418\",\"orgId\":103,\"productName\":\"统一绿茶1L（1*8）\",\"productSkuId\":10300001541851,\"specId\":1541,\"unitTotalCount\":8.000000,\"warehouseId\":1031},{\"date\":\"\",\"errorErpOwnerId\":\"ceaceeb7d4864da9add112e6daf501bc\",\"errorWmsOwnerId\":1395869718239580513,\"orderNo\":\"DDMC103120210418\",\"orgId\":103,\"productName\":\"百事可乐1L（1*12）\",\"productSkuId\":10300001817353,\"specId\":1817,\"unitTotalCount\":11.147027,\"warehouseId\":1031},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"b830ef80d37d40cdaadcd62a305e3402\",\"errorWmsOwnerId\":1395869718299174727,\"orderNo\":\"DDMC404120210418\",\"orgId\":404,\"productName\":\"中盐精制加碘盐500g（1*40）\",\"productSkuId\":4792681681467797833,\"specId\":308897,\"unitTotalCount\":36.932432,\"warehouseId\":4041},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"4637465940436225111\",\"errorWmsOwnerId\":1395869718239560816,\"orderNo\":\"DDMC404120210418\",\"orgId\":404,\"productName\":\"和酒金色年华6年（红箱）9度500ml\",\"productSkuId\":40400003532053,\"specId\":3532,\"unitTotalCount\":114.000000,\"warehouseId\":4041},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"ae7d2167bc68464bbc2c7a10b06c987a\",\"errorWmsOwnerId\":1395869718239577392,\"orderNo\":\"DDMC404120210418\",\"orgId\":404,\"productName\":\"东北坊珍酿六年45度450ml\",\"productSkuId\":40400001083802,\"specId\":1083,\"unitTotalCount\":24.000000,\"warehouseId\":4041},{\"date\":\"2021-04-17 00:00:00\",\"errorWmsOwnerId\":1395869718239575072,\"orderNo\":\"DDMC404120210418\",\"orgId\":404,\"productName\":\"银鹭桂圆莲子八宝粥360g（1*12）\",\"productSkuId\":40400004804436,\"specId\":4804,\"unitTotalCount\":12.000000,\"warehouseId\":4041},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"60afd0f22ba74028948e327d66a4512c\",\"errorWmsOwnerId\":1395869718239569537,\"orderNo\":\"DDMC404120210418\",\"orgId\":404,\"productName\":\"多力葵花籽油5.68L（1*4）\",\"productSkuId\":4863407525556840346,\"specId\":19914,\"unitTotalCount\":13.871241,\"warehouseId\":4041},{\"date\":\"2021-04-17 00:00:00\",\"orderNo\":\"DDMC404120210418\",\"orgId\":404,\"productName\":\"银鹭桂圆八宝粥360g（1*12）\",\"productSkuId\":4843976557031033624,\"specId\":112022,\"unitTotalCount\":12.000000,\"warehouseId\":4041},{\"date\":\"\",\"errorErpOwnerId\":\"d3f1d2f30f1d4af99ca15e85cafbcf72\",\"errorWmsOwnerId\":1395869718239581073,\"orderNo\":\"DDMC465120210420\",\"orgId\":465,\"productName\":\"蒙牛纯牛奶（盒装）250ml（1*24）\",\"productSkuId\":46500004120239,\"specId\":4120,\"unitTotalCount\":95.023729,\"warehouseId\":4651},{\"date\":\"\",\"errorErpOwnerId\":\"d3f1d2f30f1d4af99ca15e85cafbcf72\",\"errorWmsOwnerId\":1395869718239581073,\"orderNo\":\"DDMC465120210419\",\"orgId\":465,\"productName\":\"蒙牛纯牛奶（盒装）250ml（1*24）\",\"productSkuId\":46500004120239,\"specId\":4120,\"unitTotalCount\":20.587119,\"warehouseId\":4651},{\"date\":\"\",\"errorErpOwnerId\":\"e2e25334d50340b1b5ffe21be0bff9c5\",\"errorWmsOwnerId\":1395869718355813066,\"orderNo\":\"DDMC465120210418\",\"orgId\":465,\"productName\":\"蒙牛纯牛奶（盒装）250ml（1*24）\",\"productSkuId\":46500004120239,\"specId\":4120,\"unitTotalCount\":286.169492,\"warehouseId\":4651},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC721120210419\",\"orgId\":721,\"productName\":\"哈尔滨小麦王【听】10度330ml（1*24）\",\"productSkuId\":72100000561291,\"specId\":561,\"unitTotalCount\":23.000471,\"warehouseId\":7211},{\"date\":\"2021-04-26 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC168120210427\",\"orgId\":168,\"productName\":\"维他奶原味豆奶【盒】250ml（1*24）\",\"productSkuId\":16800005831135,\"specId\":5831,\"unitTotalCount\":48.000000,\"warehouseId\":1681},{\"date\":\"2021-04-26 00:00:00\",\"errorErpOwnerId\":\"a355131be38745f49da5192e6a9a9863\",\"errorWmsOwnerId\":1395869718239576307,\"orderNo\":\"DDMC168120210427\",\"orgId\":168,\"productName\":\"百事可乐[瓶]500ml（1*24）\",\"productSkuId\":16800001550060,\"specId\":1550,\"unitTotalCount\":46.000000,\"warehouseId\":1681},{\"date\":\"2021-04-25 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC168120210426\",\"orgId\":168,\"productName\":\"百事可乐[瓶]500ml（1*24）\",\"productSkuId\":16800001550060,\"specId\":1550,\"unitTotalCount\":23.000000,\"warehouseId\":1681},{\"date\":\"2021-04-24 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC168120210425\",\"orgId\":168,\"productName\":\"百事可乐[瓶]500ml（1*24）\",\"productSkuId\":16800001550060,\"specId\":1550,\"unitTotalCount\":25.604677,\"warehouseId\":1681},{\"date\":\"2021-04-24 00:00:00\",\"errorErpOwnerId\":\"2dd8dcf530004065a4bbb3713ae230fa\",\"errorWmsOwnerId\":1395869718239558230,\"orderNo\":\"DDMC168120210425\",\"orgId\":168,\"productName\":\"统一阿萨姆原味奶茶新装500ml（1*15）\",\"productSkuId\":16800054414485,\"specId\":54414,\"unitTotalCount\":15.000000,\"warehouseId\":1681},{\"date\":\"2021-04-23 00:00:00\",\"errorErpOwnerId\":\"2dd8dcf530004065a4bbb3713ae230fa\",\"errorWmsOwnerId\":1395869718239558230,\"orderNo\":\"DDMC168120210424\",\"orgId\":168,\"productName\":\"统一阿萨姆原味奶茶新装500ml（1*15）\",\"productSkuId\":16800054414485,\"specId\":54414,\"unitTotalCount\":43.803226,\"warehouseId\":1681},{\"date\":\"2021-04-21 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC168120210422\",\"orgId\":168,\"productName\":\"维他奶原味豆奶【盒】250ml（1*24）\",\"productSkuId\":16800005831135,\"specId\":5831,\"unitTotalCount\":51.655384,\"warehouseId\":1681},{\"date\":\"\",\"errorWmsOwnerId\":1395869718239576245,\"orderNo\":\"DDMC168120210421\",\"orgId\":168,\"productName\":\"维他奶原味豆奶【盒】250ml（1*24）\",\"productSkuId\":16800005831135,\"specId\":5831,\"unitTotalCount\":22.987252,\"warehouseId\":1681},{\"date\":\"\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC168120210420\",\"orgId\":168,\"productName\":\"怡宝水555ml （1*24）\",\"productSkuId\":16800001198513,\"specId\":1198,\"unitTotalCount\":32.668657,\"warehouseId\":1681},{\"date\":\"\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC168120210419\",\"orgId\":168,\"productName\":\"怡宝水555ml （1*24）\",\"productSkuId\":16800001198513,\"specId\":1198,\"unitTotalCount\":78.797015,\"warehouseId\":1681},{\"date\":\"\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC168120210419\",\"orgId\":168,\"productName\":\"夏宝牛牛菊花植物饮料250ml（1*24）\",\"productSkuId\":4856422847213753558,\"specId\":382026,\"unitTotalCount\":31.979130,\"warehouseId\":1681},{\"date\":\"\",\"errorErpOwnerId\":\"b801a6567af84d19a8f44514e6dd76a5\",\"errorWmsOwnerId\":1395869718239578271,\"orderNo\":\"DDMC168120210418\",\"orgId\":168,\"productName\":\"康师傅矿物质水500ml（1*28）\",\"productSkuId\":4837683092788004680,\"specId\":270849,\"unitTotalCount\":2348.614925,\"warehouseId\":1681},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC421120210419\",\"orgId\":421,\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":42100001548502,\"specId\":1548,\"unitTotalCount\":61.965000,\"warehouseId\":4211},{\"date\":\"\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC421120210418\",\"orgId\":421,\"productName\":\"芬达橙味汽水500ml（1*24）\",\"productSkuId\":42100001740974,\"specId\":1740,\"unitTotalCount\":24.000000,\"warehouseId\":4211},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"5538190906147972170\",\"errorWmsOwnerId\":1395869718239567101,\"orderNo\":\"DDMC405120210420\",\"orgId\":405,\"productName\":\"百威啤酒9.7度【听】500ml（1*12）\",\"productSkuId\":40500047275913,\"specId\":47275,\"unitTotalCount\":11.882835,\"warehouseId\":4051},{\"date\":\"\",\"errorErpOwnerId\":\"5ebe65c868f84e03b14eb2c1a7f371e2\",\"errorWmsOwnerId\":1395869718239569353,\"orderNo\":\"DDMC405120210419\",\"orgId\":405,\"productName\":\"百威啤酒9.7度【听】500ml（1*12）\",\"productSkuId\":40500047275913,\"specId\":47275,\"unitTotalCount\":36.000000,\"warehouseId\":4051},{\"date\":\"\",\"errorWmsOwnerId\":1395869718239574029,\"orderNo\":\"DDMC405120210419\",\"orgId\":405,\"productName\":\"椰树椰汁1L（1*12）\",\"productSkuId\":40500001732374,\"specId\":1732,\"unitTotalCount\":24.000000,\"warehouseId\":4051},{\"date\":\"\",\"orderNo\":\"DDMC405120210419\",\"orgId\":405,\"productName\":\"脉动水蜜桃口味600ml（1*15）\",\"productSkuId\":40500001543931,\"specId\":1543,\"unitTotalCount\":15.000000,\"warehouseId\":4051},{\"date\":\"\",\"errorErpOwnerId\":\"5013873825982573777\",\"errorWmsOwnerId\":1395869718239563807,\"orderNo\":\"DDMC405120210419\",\"orgId\":405,\"productName\":\"脉动青柠口味600ml（1*15）\",\"productSkuId\":40500001542870,\"specId\":1542,\"unitTotalCount\":15.000000,\"warehouseId\":4051},{\"date\":\"\",\"errorWmsOwnerId\":1395869718239582625,\"orderNo\":\"DDMC114120210418\",\"orgId\":114,\"productName\":\"乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\"productSkuId\":11400151112789,\"specId\":151112,\"unitTotalCount\":12.000000,\"warehouseId\":1141},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC402120210420\",\"orgId\":402,\"productName\":\"乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\"productSkuId\":40200151112433,\"specId\":151112,\"unitTotalCount\":110.193721,\"warehouseId\":4021},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"cbcdb67b3cff4e73a37dd5a56715e923\",\"errorWmsOwnerId\":1395869718239580225,\"orderNo\":\"DDMC402120210420\",\"orgId\":402,\"productName\":\"农夫山泉550ml（1*24）\",\"productSkuId\":40200001196309,\"specId\":1196,\"unitTotalCount\":120.000000,\"warehouseId\":4021},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC402120210419\",\"orgId\":402,\"productName\":\"可口可乐2L（1*6）\",\"productSkuId\":40200001185134,\"specId\":1185,\"unitTotalCount\":42.000000,\"warehouseId\":4021},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"42f0d096302c4a71b61a298fb975862b\",\"errorWmsOwnerId\":1395869718239560371,\"orderNo\":\"DDMC402120210419\",\"orgId\":402,\"productName\":\"乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\"productSkuId\":40200151112433,\"specId\":151112,\"unitTotalCount\":72.000000,\"warehouseId\":4021},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"cbcdb67b3cff4e73a37dd5a56715e923\",\"errorWmsOwnerId\":1395869718239580225,\"orderNo\":\"DDMC402120210419\",\"orgId\":402,\"productName\":\"农夫山泉550ml（1*24）\",\"productSkuId\":40200001196309,\"specId\":1196,\"unitTotalCount\":168.000000,\"warehouseId\":4021},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"7c3a5f5f2574442e8134578c870d4c10\",\"errorWmsOwnerId\":1395869718272179017,\"orderNo\":\"DDMC402120210419\",\"orgId\":402,\"productName\":\"加多宝（瓶装）550ml（1*15）\",\"productSkuId\":40200191003138,\"specId\":191003,\"unitTotalCount\":30.000000,\"warehouseId\":4021},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"cbcdb67b3cff4e73a37dd5a56715e923\",\"errorWmsOwnerId\":1395869718239580225,\"orderNo\":\"DDMC402120210419\",\"orgId\":402,\"productName\":\"农夫山泉维他命水柑橘风味（力量帝）500ml（1*15）\",\"productSkuId\":4772133343308590227,\"specId\":29222,\"unitTotalCount\":15.000000,\"warehouseId\":4021},{\"date\":\"\",\"errorErpOwnerId\":\"1\",\"errorWmsOwnerId\":1,\"orderNo\":\"DDMC402120210418\",\"orgId\":402,\"productName\":\"可口可乐2L（1*6）\",\"productSkuId\":40200001185134,\"specId\":1185,\"unitTotalCount\":389.615436,\"warehouseId\":4021},{\"date\":\"\",\"errorErpOwnerId\":\"42f0d096302c4a71b61a298fb975862b\",\"errorWmsOwnerId\":1395869718239560371,\"orderNo\":\"DDMC402120210418\",\"orgId\":402,\"productName\":\"乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\"productSkuId\":40200151112433,\"specId\":151112,\"unitTotalCount\":48.000000,\"warehouseId\":4021},{\"date\":\"\",\"errorErpOwnerId\":\"cbcdb67b3cff4e73a37dd5a56715e923\",\"errorWmsOwnerId\":1395869718239580225,\"orderNo\":\"DDMC402120210418\",\"orgId\":402,\"productName\":\"农夫山泉550ml（1*24）\",\"productSkuId\":40200001196309,\"specId\":1196,\"unitTotalCount\":144.000000,\"warehouseId\":4021},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210420\",\"orgId\":159,\"productName\":\"百事可乐[瓶]600ml（1*24）\",\"productSkuId\":15900001555063,\"specId\":1555,\"unitTotalCount\":93.886061,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210420\",\"orgId\":159,\"productName\":\"脉动水蜜桃口味600ml（1*15）\",\"productSkuId\":15900001543515,\"specId\":1543,\"unitTotalCount\":22.230000,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210420\",\"orgId\":159,\"productName\":\"百事可乐2L（1*6）\",\"productSkuId\":15900003107231,\"specId\":3107,\"unitTotalCount\":17.000000,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210420\",\"orgId\":159,\"productName\":\"怡宝纯净水1.555L（1*12）\",\"productSkuId\":15900002494978,\"specId\":2494,\"unitTotalCount\":12.000000,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210420\",\"orgId\":159,\"productName\":\"青岛清爽[听]8度330ml（1*24）\",\"productSkuId\":15900000947637,\"specId\":947,\"unitTotalCount\":144.785159,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210419\",\"orgId\":159,\"productName\":\"百事可乐[瓶]600ml（1*24）\",\"productSkuId\":15900001555063,\"specId\":1555,\"unitTotalCount\":231.355152,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210419\",\"orgId\":159,\"productName\":\"百岁山饮用天然矿泉水570ml（1*24）\",\"productSkuId\":15900001698710,\"specId\":1698,\"unitTotalCount\":72.000000,\"warehouseId\":1591},{\"date\":\"\",\"orderNo\":\"DDMC159120210419\",\"orgId\":159,\"productName\":\"维他柠檬茶饮料【瓶】500ml（1*15）\",\"productSkuId\":4777582275521374212,\"specId\":278888,\"unitTotalCount\":14.689189,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210418\",\"orgId\":159,\"productName\":\"农夫山泉550ml（1*24）\",\"productSkuId\":4776428017752634507,\"specId\":1196,\"unitTotalCount\":45.728000,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"0b6e3838953843e8a0af48c98a9e24f3\",\"errorWmsOwnerId\":1395869718271632734,\"orderNo\":\"DDMC159120210418\",\"orgId\":159,\"productName\":\"百事可乐[瓶]600ml（1*24）\",\"productSkuId\":15900001555063,\"specId\":1555,\"unitTotalCount\":100.946667,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"be2061c921dd456995b2f9a0667c411e\",\"errorWmsOwnerId\":1395869718239578869,\"orderNo\":\"DDMC159120210418\",\"orgId\":159,\"productName\":\"青岛清爽[听]8度330ml（1*24）\",\"productSkuId\":15900000947637,\"specId\":947,\"unitTotalCount\":21.224348,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"0b6e3838953843e8a0af48c98a9e24f3\",\"errorWmsOwnerId\":1395869718271632734,\"orderNo\":\"DDMC159120210418\",\"orgId\":159,\"productName\":\"雀巢咖啡丝滑拿铁268ml（1*15）\",\"productSkuId\":15900002112802,\"specId\":2112,\"unitTotalCount\":13.698222,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210418\",\"orgId\":159,\"productName\":\"百岁山饮用天然矿泉水570ml（1*24）\",\"productSkuId\":15900001698710,\"specId\":1698,\"unitTotalCount\":48.000000,\"warehouseId\":1591},{\"date\":\"\",\"errorErpOwnerId\":\"30eb598739614d8d8fedf06a965af7bb\",\"errorWmsOwnerId\":1395869718239558528,\"orderNo\":\"DDMC159120210418\",\"orgId\":159,\"productName\":\"银鹭桂圆莲子八宝粥360g（1*12）\",\"productSkuId\":15900004804715,\"specId\":4804,\"unitTotalCount\":52.108000,\"warehouseId\":1591},{\"date\":\"\",\"orderNo\":\"DDMC159120210418\",\"orgId\":159,\"productName\":\"维他柠檬茶饮料【瓶】500ml（1*15）\",\"productSkuId\":4777582275521374212,\"specId\":278888,\"unitTotalCount\":44.067568,\"warehouseId\":1591},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"f5c807351b5f4fc0a3141a8091924983\",\"errorWmsOwnerId\":1395869718239584402,\"orderNo\":\"DDMC412120210419\",\"orgId\":412,\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":41200001548573,\"specId\":1548,\"unitTotalCount\":58.000000,\"warehouseId\":4121},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"f5c807351b5f4fc0a3141a8091924983\",\"errorWmsOwnerId\":1395869718239584402,\"orderNo\":\"DDMC412120210419\",\"orgId\":412,\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":41200001188935,\"specId\":1188,\"unitTotalCount\":2.000000,\"warehouseId\":4121},{\"date\":\"2021-04-18 00:00:00\",\"errorErpOwnerId\":\"1764dbc8f15042689805a232ff825700\",\"errorWmsOwnerId\":1395869718239555868,\"orderNo\":\"DDMC412120210419\",\"orgId\":412,\"productName\":\"古井淡雅42度450ml（1*4）\",\"productSkuId\":41200011226417,\"specId\":11226,\"unitTotalCount\":4.000000,\"warehouseId\":4121},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"542459504db4468d8890dd70119a2c27\",\"errorWmsOwnerId\":1395869718248270351,\"orderNo\":\"DDMC412120210418\",\"orgId\":412,\"productName\":\"百事可乐2L（1*6）\",\"productSkuId\":41200003107709,\"specId\":3107,\"unitTotalCount\":7.000000,\"warehouseId\":4121},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"f5c807351b5f4fc0a3141a8091924983\",\"errorWmsOwnerId\":1395869718239584402,\"orderNo\":\"DDMC412120210418\",\"orgId\":412,\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":41200001548573,\"specId\":1548,\"unitTotalCount\":48.000000,\"warehouseId\":4121},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"f5c807351b5f4fc0a3141a8091924983\",\"errorWmsOwnerId\":1395869718239584402,\"orderNo\":\"DDMC412120210418\",\"orgId\":412,\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":41200001188935,\"specId\":1188,\"unitTotalCount\":24.000000,\"warehouseId\":4121},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"f5c807351b5f4fc0a3141a8091924983\",\"errorWmsOwnerId\":1395869718239584402,\"orderNo\":\"DDMC412120210418\",\"orgId\":412,\"productName\":\"美汁源果粒橙1.8L（1*6）\",\"productSkuId\":41200003839759,\"specId\":3839,\"unitTotalCount\":24.000000,\"warehouseId\":4121},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"f5c807351b5f4fc0a3141a8091924983\",\"errorWmsOwnerId\":1395869718239584402,\"orderNo\":\"DDMC412120210418\",\"orgId\":412,\"productName\":\"雪碧【听装】330ml（1*24）\",\"productSkuId\":41200001547655,\"specId\":1547,\"unitTotalCount\":70.000000,\"warehouseId\":4121},{\"date\":\"\",\"errorErpOwnerId\":\"f59933529a0e4a73a6929c881ef7cd22\",\"errorWmsOwnerId\":1395869718239584388,\"orderNo\":\"DDMC473120210418\",\"orgId\":473,\"productName\":\"女儿红绍兴老酒桶装黄酒14度2.5L\",\"productSkuId\":47300004857769,\"specId\":4857,\"unitTotalCount\":25.000000,\"warehouseId\":4731},{\"date\":\"\",\"errorErpOwnerId\":\"a7467171ba24472b8c0bd03eee63e441\",\"errorWmsOwnerId\":1395869718239576683,\"orderNo\":\"DDMC473120210418\",\"orgId\":473,\"productName\":\"老村长富贵酒42度450ml\",\"productSkuId\":47300005371601,\"specId\":5371,\"unitTotalCount\":8.925455,\"warehouseId\":4731},{\"date\":\"\",\"errorErpOwnerId\":\"f8317c16fa0941f2a5cc4a44a6b69e9c\",\"errorWmsOwnerId\":1395869718239584657,\"orderNo\":\"DDMC473120210418\",\"orgId\":473,\"productName\":\"贵宾歪脖小郎酒45度100ml\",\"productSkuId\":4906403955730592475,\"specId\":238,\"unitTotalCount\":95.000000,\"warehouseId\":4731},{\"date\":\"\",\"errorErpOwnerId\":\"c7ef05e9b8164cc284bddb5e88285530\",\"errorWmsOwnerId\":1395869718239579826,\"orderNo\":\"DDMC406120210422\",\"orgId\":406,\"productName\":\"统一来一桶老坛酸菜牛肉面香辣味120g（1*12）\",\"productSkuId\":40600007145129,\"specId\":7145,\"unitTotalCount\":24.000000,\"warehouseId\":4061},{\"date\":\"\",\"errorErpOwnerId\":\"d1b6fd0d32e8491d83cc244332cfde7b\",\"errorWmsOwnerId\":1395869718239580830,\"orderNo\":\"DDMC406120210421\",\"orgId\":406,\"productName\":\"统一来一桶老坛酸菜牛肉面香辣味120g（1*12）\",\"productSkuId\":40600007145129,\"specId\":7145,\"unitTotalCount\":24.000000,\"warehouseId\":4061},{\"date\":\"\",\"errorErpOwnerId\":\"ce7771a3189d46ceb776b6e75ca21a9c\",\"errorWmsOwnerId\":1395869718239580494,\"orderNo\":\"DDMC406120210421\",\"orgId\":406,\"productName\":\"稻花香过桥米线酸辣牛肉味110g（1*12）\",\"productSkuId\":40600060789141,\"specId\":60789,\"unitTotalCount\":552.000000,\"warehouseId\":4061},{\"date\":\"\",\"errorErpOwnerId\":\"d1b6fd0d32e8491d83cc244332cfde7b\",\"errorWmsOwnerId\":1395869718239580830,\"orderNo\":\"DDMC406120210420\",\"orgId\":406,\"productName\":\"统一来一桶老坛酸菜牛肉面香辣味120g（1*12）\",\"productSkuId\":40600007145129,\"specId\":7145,\"unitTotalCount\":120.000000,\"warehouseId\":4061},{\"date\":\"\",\"errorErpOwnerId\":\"0cd5ffcad7d14319adf2fcb67e1ca972\",\"errorWmsOwnerId\":1395869718239554704,\"orderNo\":\"DDMC406120210420\",\"orgId\":406,\"productName\":\"金龙鱼黄金比例食用调和油5L（1*4）\",\"productSkuId\":40600007322579,\"specId\":7322,\"unitTotalCount\":1.000000,\"warehouseId\":4061},{\"date\":\"\",\"errorErpOwnerId\":\"d1b6fd0d32e8491d83cc244332cfde7b\",\"errorWmsOwnerId\":1395869718239580830,\"orderNo\":\"DDMC406120210419\",\"orgId\":406,\"productName\":\"统一来一桶老坛酸菜牛肉面香辣味120g（1*12）\",\"productSkuId\":40600007145129,\"specId\":7145,\"unitTotalCount\":408.000000,\"warehouseId\":4061},{\"date\":\"\",\"errorErpOwnerId\":\"c7ef05e9b8164cc284bddb5e88285530\",\"errorWmsOwnerId\":1395869718239579826,\"orderNo\":\"DDMC406120210418\",\"orgId\":406,\"productName\":\"统一来一桶老坛酸菜牛肉面香辣味120g（1*12）\",\"productSkuId\":40600007145129,\"specId\":7145,\"unitTotalCount\":239.916522,\"warehouseId\":4061},{\"date\":\"\",\"errorErpOwnerId\":\"0cd5ffcad7d14319adf2fcb67e1ca972\",\"errorWmsOwnerId\":1395869718239554704,\"orderNo\":\"DDMC406120210418\",\"orgId\":406,\"productName\":\"金龙鱼黄金比例食用调和油5L（1*4）\",\"productSkuId\":40600007322579,\"specId\":7322,\"unitTotalCount\":1.000000,\"warehouseId\":4061},{\"date\":\"\",\"errorWmsOwnerId\":1395869718239584532,\"orderNo\":\"DDMC403120210421\",\"orgId\":403,\"productName\":\"可口可乐[听]330ml（1*24）\",\"productSkuId\":40300001789506,\"specId\":1789,\"unitTotalCount\":24.000000,\"warehouseId\":4031},{\"date\":\"\",\"errorErpOwnerId\":\"0a048d140b5241d4840631d144ac53e5\",\"errorWmsOwnerId\":1395869718239554398,\"orderNo\":\"DDMC403120210419\",\"orgId\":403,\"productName\":\"可口可乐零度汽水680ml（1*12）\",\"productSkuId\":4841638631619101918,\"specId\":247343,\"unitTotalCount\":21.072000,\"warehouseId\":4031},{\"date\":\"\",\"errorErpOwnerId\":\"0a048d140b5241d4840631d144ac53e5\",\"errorWmsOwnerId\":1395869718239554398,\"orderNo\":\"DDMC403120210418\",\"orgId\":403,\"productName\":\"可口可乐畅爽装680ml（1*12）\",\"productSkuId\":40300031652437,\"specId\":31652,\"unitTotalCount\":35.083429,\"warehouseId\":4031},{\"date\":\"\",\"errorErpOwnerId\":\"0a048d140b5241d4840631d144ac53e5\",\"errorWmsOwnerId\":1395869718239554398,\"orderNo\":\"DDMC403120210418\",\"orgId\":403,\"productName\":\"可口可乐零度汽水680ml（1*12）\",\"productSkuId\":4841638631619101918,\"specId\":247343,\"unitTotalCount\":0.040000,\"warehouseId\":4031},{\"date\":\"2021-04-17 00:00:00\",\"errorErpOwnerId\":\"5476282036447307444\",\"errorWmsOwnerId\":1395869718239566685,\"orderNo\":\"DDMC419120210418\",\"orgId\":419,\"productName\":\"加多宝新装[听]310ml（1*24）\",\"productSkuId\":41900001570554,\"specId\":1570,\"unitTotalCount\":24.000000,\"warehouseId\":4191},{\"date\":\"2021-04-20 00:00:00\",\"errorErpOwnerId\":\"b15396a4adef4aef9bba9863890513b8\",\"errorWmsOwnerId\":1395869718239577663,\"orderNo\":\"DDMC723120210421\",\"orgId\":723,\"productName\":\"燕京U8啤酒8度500ml（1*12）\",\"productSkuId\":4858349024854966668,\"specId\":333218,\"unitTotalCount\":168.000000,\"warehouseId\":7231},{\"date\":\"2021-04-20 00:00:00\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210421\",\"orgId\":723,\"productName\":\"雅鲁河高粱原浆42度500ml（1*6）\",\"productSkuId\":72300064063536,\"specId\":64063,\"unitTotalCount\":148.000000,\"warehouseId\":7231},{\"date\":\"2021-04-20 00:00:00\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210421\",\"orgId\":723,\"productName\":\"汾酒玻璃瓶42度475ml\",\"productSkuId\":72300000734167,\"specId\":734,\"unitTotalCount\":0.953043,\"warehouseId\":7231},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210420\",\"orgId\":723,\"productName\":\"雅鲁河高粱原浆42度500ml（1*6）\",\"productSkuId\":72300064063536,\"specId\":64063,\"unitTotalCount\":480.000000,\"warehouseId\":7231},{\"date\":\"2021-04-19 00:00:00\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210420\",\"orgId\":723,\"productName\":\"汾酒玻璃瓶42度475ml\",\"productSkuId\":72300000734167,\"specId\":734,\"unitTotalCount\":4.765797,\"warehouseId\":7231},{\"date\":\"\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210419\",\"orgId\":723,\"productName\":\"雅鲁河高粱原浆42度500ml（1*6）\",\"productSkuId\":72300064063536,\"specId\":64063,\"unitTotalCount\":107.500000,\"warehouseId\":7231},{\"date\":\"\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210419\",\"orgId\":723,\"productName\":\"汾酒玻璃瓶42度475ml\",\"productSkuId\":72300000734167,\"specId\":734,\"unitTotalCount\":0.953043,\"warehouseId\":7231},{\"date\":\"\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210418\",\"orgId\":723,\"productName\":\"雅鲁河高粱原浆42度500ml（1*6）\",\"productSkuId\":72300064063536,\"specId\":64063,\"unitTotalCount\":65.000000,\"warehouseId\":7231},{\"date\":\"\",\"errorErpOwnerId\":\"b3e4b2e9f8114b2babfff2b6f35a3dc9\",\"errorWmsOwnerId\":1395869718239577897,\"orderNo\":\"DDMC723120210418\",\"orgId\":723,\"productName\":\"汾酒玻璃瓶42度475ml\",\"productSkuId\":72300000734167,\"specId\":734,\"unitTotalCount\":4.974571,\"warehouseId\":7231}]\n";
        List<ErpProductOwnerDTO> result = JSON.parseArray(text, ErpProductOwnerDTO.class);

        Set<Long> skuIds = result.stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
        Set<Long> ownerIds = result.stream().map(it -> it.getErrorWmsOwnerId()).collect(Collectors.toSet());

        System.out.println("所有差异单货主数据数据：" + JSON.toJSONString(ownerIds));
        System.out.println("所有差异单sku数据：" + JSON.toJSONString(skuIds));

        return result;
    }

    /**
     * 获取结算单
     *
     * @return
     */
    public static List<ErpProductOwnerDTO> geterpjiesuandata() {
        String text = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\结算单所有产品与二级货主对应关系.json");
        List<ErpProductOwnerDTO> result = JSON.parseArray(text, ErpProductOwnerDTO.class);

        List<ErpProductOwnerDTO> collect = result.stream().filter(it -> it.getWarehouseId() == null).collect(Collectors.toList());
        System.out.println("仓库id不存在：" + JSON.toJSONString(collect));

        Set<Long> skuIds = result.stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
        Set<Long> ownerIds = result.stream().map(it -> it.getErrorWmsOwnerId()).collect(Collectors.toSet());

        System.out.println("所有结算单货主数据数据：" + JSON.toJSONString(ownerIds));
        System.out.println("所有结算单sku数据：" + JSON.toJSONString(skuIds));

        return result;
    }


    public static void getWarehouseProduct() {
        Map<String, List<Long>> result = new HashMap<>();
        List<ErpProductOwnerDTO> geterpdata = geterpjiesuandata();
        Map<Integer, List<ErpProductOwnerDTO>> map = geterpdata.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId()));
        for (Map.Entry<Integer, List<ErpProductOwnerDTO>> entry : map.entrySet()) {
            Set<Long> skuSet = entry.getValue().stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
            result.put(entry.getKey().toString(), new ArrayList<>(skuSet));
        }
        System.out.println(JSON.toJSONString(result));

    }


    public static Map<String, List<Long>> getChayiWarehouseProduct() {
        Map<String, List<Long>> result = new HashMap<>();
        String json = "{\"4051\":[40500047275913,40500001732374,40500001542870,40500001543931],\"7231\":[72300064063536,4858349024854966668,72300000734167],\"4041\":[40400001083802,4863407525556840346,40400004804436,4843976557031033624,40400003532053,4792681681467797833],\"7211\":[72100000561291],\"4031\":[40300031652437,4841638631619101918,40300001789506],\"7111\":[4911289754947203800,71100083356891,4798125746493601992,71100009754035,71100045702871],\"4021\":[40200001196309,4772133343308590227,40200151112433,40200191003138,40200001185134],\"4121\":[41200001548573,41200001188935,41200003839759,41200011226417,41200003107709,41200001547655],\"4001\":[40000000311338,40000007147440,40000002257189,40000125367050,40000000314758,4864434714945576796,40000004919492,40000001548114,40000008122805,40000002057402,40000001542800,4810048808338993613,40000002112159,40000031358303,4867681516293513043,40000000274708,40000025226449,40000003839768,40000001188672,40000011177290],\"4651\":[46500004120239],\"4211\":[42100001740974,42100001548502],\"1681\":[16800001550060,16800054414485,4837683092788004680,16800005831135,16800001198513,4856422847213753558],\"1031\":[10300001198659,10300002257379,10300001817353,10300001188290,10300001541851,10300034772186],\"1141\":[11400151112789],\"1591\":[15900001555063,15900003107231,15900002494978,15900001698710,4776428017752634507,4777582275521374212,15900000947637,15900001543515,15900002112802,15900004804715],\"4191\":[41900001570554],\"7041\":[70400058662050,70400003872819],\"1191\":[11900003173415,11900107485366,11900002257872],\"4061\":[40600007145129,40600060789141,40600007322579],\"4731\":[47300004857769,47300005371601,4906403955730592475]}\n";
        result = JSON.parseObject(json, Map.class);
        System.out.println(JSON.toJSONString(result.keySet()));
        return result;

    }


    public static Map<String, List<Long>> getJiesuanWarehouseProduct() {
        Map<String, List<Long>> result = new HashMap<>();
        String json = "{\"4051\":[40500045918380,40500047275913,40500007324285,40500001732374,40500004903862,40500001542870,40500001543931],\"7231\":[72300064063536,4858349024854966668,72300000734167],\"4041\":[4863407525556840346,40400001083802,40400003801709,40400081238512,40400118324793,40400004804436,4843976557031033624,40400003532053,4792681681467797833],\"7131\":[71300018633970,71300007147815,71300016910015,71300002112740,71300001542537,71300005114385,71300125507884,71300015054397,71300124860465,71300065961108,71300006822427,71300033306951,71300107485940,71300020838857,4831457167568415948,4870215270593201360],\"7211\":[72100001474154,72100002257860,72100000561291,4850031898749511489,72100001543776,72100001544098,72100092246781,4904313684237470530,72100095772710,72100064063802],\"4031\":[40300031652437,4841638631619101918,4868120080311125195,40300002175530,40300001789506],\"7111\":[71100006808431,71100038136458,4762809650397956061,71100083356891,4798125746493601992,4903302845124561758,71100045702871,71100009754035,4846769685230200662,71100138217725,71100001698972,4914829890263136385,71100014942681,4911289754947203800,4914829746021642965,4911289297360599187,71100001542278,71100001840110,71100008402891],\"4021\":[4772133343308590227,40200151112433,40200001186081,40200068373569,40200002039377,40200017931599,40200001185134,40200001196309,4777195708915083281,40200191003138,40200000720852,40200006699081,4868120080000746717],\"7001\":[4868120092218754255],\"4571\":[45700151112247,45700002112726,45700001732122,45700006670766,4898229268965576593,45700163299992,4914905203882014871,45700212349819,45700004041800,4883722298632890510,45700157424090,45700007322813],\"4121\":[41200001188935,41200003839759,41200001548573,41200011226417,41200005460591,41200003107709,41200001547655],\"4001\":[40000000311338,40000001548114,40000008122805,40000011879564,40000001542800,40000002112159,40000031358303,4898913301915586445,40000000327603,40000011177290,4913792322898277086,4916246574359063435,40000007147440,40000002257189,40000125367050,40000000314758,40000035095723,4864434714945576796,40000004919492,40000014126194,40000002057402,4810048808338993613,4916350124036664198,4867681516293513043,40000025226449,40000000274708,40000003839768,40000001188672,40000000345936,4916350515008711581],\"4651\":[46500004120239],\"4211\":[4843976231850838792,42100003896749,42100001740974,42100125367541,42100001548502],\"1681\":[4837683092788004680,4851462338656020312,16800009707763,4818371453431371409,16800002494787,16800001198513,4856422847213753558,16800054414485,16800001550060,16800001556914,4914220663409259211,16800005831135,4856114310375047578,16800149552175,4865617929370338499],\"1031\":[10300036093825,10300002257379,10300001198659,10300001817353,10300001188290,10300039764286,10300002039168,10300002057249,4868120068898424027,10300058592849,10300001541851,10300034772186],\"1141\":[11400151112789],\"1591\":[15900003107231,15900001542822,15900001571045,15900002257896,4874307702317552080,4776428017752634507,15900139449334,15900039764356,4777582275521374212,15900000947637,15900002112802,15900001555063,15900001545525,15900002494978,15900001698710,15900137139844,15900042053339,15900004100919,15900002387732,15900001543515,15900001570200,4899573888009806981,15900020284900,15900004804715],\"4191\":[41900001570554,4811593850524995407],\"1181\":[11800001627349],\"7041\":[70400004179551,70400058662050,4902119644662319944,4868120093263135965,4878295444626545290,70400003872819],\"1191\":[11900003173415,4782934981700893586,11900107485366,11900002257872,11900001544369],\"4061\":[40600007145129,40600060789141,40600007322579],\"4731\":[47300005371601,47300004857769,47300000314832,4882236137363548800,4906403955730592475]}";
        result = JSON.parseObject(json, Map.class);
        System.out.println(JSON.toJSONString(result.keySet()));
        return result;

    }


}
