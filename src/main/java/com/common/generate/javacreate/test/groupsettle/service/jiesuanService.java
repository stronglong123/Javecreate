package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.groupsettle.dto.ErpProductOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderAllPageDTO;
import com.common.generate.javacreate.test.groupsettle.dto.ProductSkuListDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderItemSecOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.WarehouseDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

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
public class jiesuanService {


    public static void main(String[] args) throws Exception {

        Map<String,List<ErpProductOwnerDTO>> map =new HashMap<>();
        List<WarehouseDTO> jiezhuanWarehouse = BaseUtils.getJiesuanWarehouse();
        for (WarehouseDTO warehouseDTO : jiezhuanWarehouse) {
            List<ErpProductOwnerDTO> erpProductOwnerDTOS = listsingleGroupSettleOrder(warehouseDTO.getOrgId(), warehouseDTO.getWarehouseId(), null);
            map.put(warehouseDTO.getWarehouseId().toString(),erpProductOwnerDTOS);
        }
        System.out.println(JSON.toJSONString(map));

//        lsitAllSku();
//        listALLGroupSettleOrder();
    }


    public static void lsitAllSku() {
        List<WarehouseDTO> jiezhuanWarehouse = BaseUtils.getJiesuanWarehouse();
        Set<Long> skuIdAll = new HashSet<>();
        Set<Integer> warehouseAll = new HashSet<>();
        Map<String,List<String>> orderNoMap=new HashMap<>();
        List<String>  orderNoList =new ArrayList<>();
        for (WarehouseDTO warehouseDTO : jiezhuanWarehouse) {
            List<OrderAllPageDTO> listorder = listorder(warehouseDTO.getOrgId(), warehouseDTO.getWarehouseId());
            if (CollectionUtils.isNotEmpty(listorder)) {
                Set<Long> skuIds = listorder.stream()
                        .filter(it -> CollectionUtils.isNotEmpty(it.getItems()))
                        .flatMap(it -> it.getItems().stream()).map(it -> it.getProductSkuId())
                        .collect(Collectors.toSet());
                skuIdAll.addAll(skuIds);
                Set<Integer> warehouse = listorder.stream().map(it -> it.getWarehouseId()).collect(Collectors.toSet());
                warehouseAll.addAll(warehouse);
                Set<String> orderNos = listorder.stream().map(it -> it.getBusinessNo()).collect(Collectors.toSet());
                orderNoList.addAll(orderNos);
                orderNoMap.put(warehouseDTO.getWarehouseId().toString(),new ArrayList<>(orderNos));
            }
        }
        System.out.println("所有的skuId："+JSON.toJSONString(skuIdAll));
        System.out.println("所有的仓库id："+JSON.toJSONString(warehouseAll));
        System.out.println("所有单号:"+JSON.toJSONString(orderNoList));
        System.out.println("所有单号:"+JSON.toJSONString(orderNoMap));

    }


    /**
     * 查询结算出和结算入数据
     */
    public static List<ErpProductOwnerDTO> listsingleGroupSettleOrder(Integer orgId,Integer warehouseId,Integer orderSource) throws Exception {
        /**获取结算出入*/
        List<ErpProductOwnerDTO> result = listAllGroupSettleOrder(orgId, warehouseId, 111);
        List<ErpProductOwnerDTO> mtList = listAllGroupSettleOrder(orgId, warehouseId, 110);
        /**添加美团明细*/
        if(CollectionUtils.isNotEmpty(mtList)){
            result.addAll(mtList);
        }
        System.out.println("结算单：" + JSON.toJSONString(result));


//        /**获取差异单*/
        List<ErpProductOwnerDTO> chayiErpList = chayiService.getChayiOrderByWarehouseId(orgId, warehouseId);
        System.out.println("差异单：" + JSON.toJSONString(chayiErpList));
        /**添加差异明细*/
        if(CollectionUtils.isNotEmpty(chayiErpList)){
            result.addAll(chayiErpList);
        }

        System.out.println("合并前：" + JSON.toJSONString(result));

        /**合并数量,产品加规格分组，每组根据出入加减*/
        result = margeCountBySec(result);
        System.out.println(JSON.toJSONString(result));

        Set<Long> skuIds = result.stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
        Set<Long> ownerIds = result.stream().map(it -> it.getErrorWmsOwnerId()).collect(Collectors.toSet());
        result = result.stream().sorted(Comparator.comparing(it -> it.getProductSkuId())).collect(Collectors.toList());
        List<ErpProductOwnerDTO> error = result.stream().filter(it -> it.getSpecId() == null).collect(Collectors.toList());

        System.out.println("规格为空：" + JSON.toJSONString(error));
        System.out.println("所有货主数据数据：" + JSON.toJSONString(ownerIds));
        System.out.println("所有sku数据：" + JSON.toJSONString(skuIds));
        addTrueOwner(orgId,warehouseId,new ArrayList<>(skuIds),result);
        System.out.println("所有数据：" + JSON.toJSONString(result));

        result = result.stream().filter(it -> !it.getTureErpOwnerId().contains("(" + it.getErrorWmsOwnerId() + ")")).collect(Collectors.toList());
        System.out.println("异常数据：" + JSON.toJSONString(result));
        return result;
    }


    public static void addTrueOwner(Integer orgId,Integer warehouseId,List<Long> skuIds,List<ErpProductOwnerDTO> result){
        Map<String, String> owerMap = BaseUtils.getErpOwner();
        Set<String> secOwnerList =new HashSet<>();
        Map<String, String> productSecOwner =  MergeService.findSaleProductSecOwner(orgId, warehouseId, secOwnerList, skuIds);
        result.forEach(it -> {
            String owner = productSecOwner.get(it.getProductSkuId().toString());
            it.setTureWmsOwnerId(owner);
            it.setTureErpOwnerId(BaseUtils.getErpOwnerString(owerMap, owner));
        });

    }

    /**
     * 查询结算出和结算入数据
     */
    public static void listALLGroupSettleOrder() throws Exception {
        List<ErpProductOwnerDTO> result = new ArrayList<>();
        List<WarehouseDTO> jiezhuanWarehouse = BaseUtils.getJiesuanWarehouse();
        for (WarehouseDTO warehouseDTO : jiezhuanWarehouse) {
            List<ErpProductOwnerDTO> dtos = listAllGroupSettleOrder(warehouseDTO.getOrgId(), warehouseDTO.getWarehouseId(),111);
            result.addAll(dtos);

            List<ErpProductOwnerDTO> mtlist = listAllGroupSettleOrder(warehouseDTO.getOrgId(), warehouseDTO.getWarehouseId(), 110);
            result.addAll(mtlist);
        }



        /**合并数量,产品加规格分组，每组根据出入加减*/
        result = margeCount(result);
        System.out.println(JSON.toJSONString(result));

        Set<Long> skuIds = result.stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
        Set<Long> ownerIds = result.stream().map(it -> it.getErrorWmsOwnerId()).collect(Collectors.toSet());

        List<ErpProductOwnerDTO> error = result.stream().filter(it -> it.getSpecId() == null).collect(Collectors.toList());

        System.out.println("规格为空：" + JSON.toJSONString(error));
        System.out.println("所有货主数据数据：" + JSON.toJSONString(ownerIds));
        System.out.println("所有sku数据：" + JSON.toJSONString(skuIds));
        System.out.println("所有数据：" + JSON.toJSONString(result));

    }


    /**
     * 获取订单
     */
    public static List<ErpProductOwnerDTO> listAllGroupSettleOrder(Integer orgId, Integer warehosueId,Integer ordersource) throws Exception {
        List<ErpProductOwnerDTO> result = new ArrayList<>();

        /**获取结算单*/
        List<OrderAllPageDTO> orderAllPageDTOS = listorder(orgId, warehosueId,ordersource);
        if(CollectionUtils.isEmpty(orderAllPageDTOS)){
            return Collections.emptyList();
        }
        /**wms货主和erp货主对应关系*/
        Map<String, String> erpOwnerMap = BaseUtils.getErpOwner();
        /**产品skuid和规格id对应关系*/
        Map<Long, Long> skuSpecMap = BaseUtils.getSkuSpecMap();
        List<ErpProductOwnerDTO> list = new ArrayList<>();

        List<Long> orderIds = orderAllPageDTOS.stream().map(it -> Long.valueOf(it.getOrderId())).collect(Collectors.toList());
        /**获取二级货主数量*/
        Map<Long, List<SettleOrderItemSecOwnerDTO>> secMap = selectOrderItemOwnerByOrderIds(orderIds);
        for (OrderAllPageDTO order : orderAllPageDTOS) {
            /**获取订单所有二级货主*/
            List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = secMap.get(Long.valueOf(order.getOrderId()));
            Map<Long, List<SettleOrderItemSecOwnerDTO>> itemOwnerMap = secOwnerDTOS.stream().collect(Collectors.groupingBy(SettleOrderItemSecOwnerDTO::getOmsOrdetItemId));
            /**只处理指定产品*/
            order.getItems().stream().forEach(it -> {
                List<SettleOrderItemSecOwnerDTO> itemOwnerList = itemOwnerMap.get(it.getOrderItemId());
                List<SettleOrderItemSecOwnerDTO> skuItemSecOwnr = itemOwnerList.stream()
                        .filter(itemOwner -> itemOwner.getProductSkuId().equals(it.getProductSkuId()))
                        .collect(Collectors.toList());
                /**转换erp所需数据*/
                for (SettleOrderItemSecOwnerDTO settleOrderItemSecOwnerDTO : skuItemSecOwnr) {
                    ErpProductOwnerDTO erpProductOwnerDTO = new ErpProductOwnerDTO();
                    erpProductOwnerDTO.setProductName(it.getProductName());
                    erpProductOwnerDTO.setProductSkuId(it.getProductSkuId());
                    erpProductOwnerDTO.setOrgId(order.getOrgId());
                    erpProductOwnerDTO.setWarehouseId(order.getWarehouseId());
                    erpProductOwnerDTO.setOrderType(order.getOrderType().intValue());
                    erpProductOwnerDTO.setErrorWmsOwnerId(settleOrderItemSecOwnerDTO.getSecOwnerId());
                    erpProductOwnerDTO.setErrorErpOwnerId(erpOwnerMap.get(String.valueOf(erpProductOwnerDTO.getErrorWmsOwnerId())));
                    erpProductOwnerDTO.setUnitTotalCount(settleOrderItemSecOwnerDTO.getSecCount());
                    erpProductOwnerDTO.setOrderNo(order.getRemark());
                    erpProductOwnerDTO.setOmsItemId(settleOrderItemSecOwnerDTO.getOmsOrdetItemId());
                    erpProductOwnerDTO.setSpecId(skuSpecMap.get(it.getProductSkuId()));
                    list.add(erpProductOwnerDTO);
                }
            });
        }

        return list;
    }

//    /**
//     * 获取订单
//     */
//    public static List<ErpProductOwnerDTO> listGroupSettleOrder(Integer orgId, Integer warehosueId) throws Exception {
//        List<ErpProductOwnerDTO> result = new ArrayList<>();
//        List<OrderAllPageDTO> orderAllPageDTOS = listorder(orgId, warehosueId);
//
//        /**名称和仓库对应关系*/
//        Map<Integer, List<String>> skuNameMap = getSkuNameMap();
//        /**wms货主和erp货主对应关系*/
//        Map<String, String> erpOwnerMap = BaseUtils.getErpOwner();
//        /**产品skuid和规格id对应关系*/
//        Map<Long, Long> skuSpecMap = getSkuSpec();
//        List<ErpProductOwnerDTO> list = new ArrayList<>();
//
//        List<Long> orderIds = orderAllPageDTOS.stream().map(it -> Long.valueOf(it.getOrderId())).collect(Collectors.toList());
//        /**获取二级货主数量*/
//        Map<Long, List<SettleOrderItemSecOwnerDTO>> secMap = selectOrderItemOwnerByOrderIds(orderIds);
//        for (OrderAllPageDTO order : orderAllPageDTOS) {
//            List<String> skuNameList = skuNameMap.get(order.getWarehouseId());
//            if (CollectionUtils.isEmpty(skuNameList)) {
//                return result;
//            }
//
//            /**获取订单所有二级货主*/
//            List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = secMap.get(Long.valueOf(order.getOrderId()));
//            Map<Long, List<SettleOrderItemSecOwnerDTO>> itemOwnerMap = secOwnerDTOS.stream().collect(Collectors.groupingBy(SettleOrderItemSecOwnerDTO::getOmsOrdetItemId));
//            /**只处理指定产品*/
//            order.getItems().stream().filter(it -> skuNameList.contains(it.getProductName())).forEach(it -> {
//                List<SettleOrderItemSecOwnerDTO> itemOwnerList = itemOwnerMap.get(it.getOrderItemId());
//                List<SettleOrderItemSecOwnerDTO> skuItemSecOwnr = itemOwnerList.stream()
//                        .filter(itemOwner -> itemOwner.getProductSkuId().equals(it.getProductSkuId()))
//                        .collect(Collectors.toList());
//                /**转换erp所需数据*/
//                for (SettleOrderItemSecOwnerDTO settleOrderItemSecOwnerDTO : skuItemSecOwnr) {
//                    ErpProductOwnerDTO erpProductOwnerDTO = new ErpProductOwnerDTO();
//                    erpProductOwnerDTO.setProductName(it.getProductName());
//                    erpProductOwnerDTO.setProductSkuId(it.getProductSkuId());
//                    erpProductOwnerDTO.setOrgId(order.getOrgId());
//                    erpProductOwnerDTO.setWarehouseId(order.getWarehouseId());
//                    erpProductOwnerDTO.setOrderType(order.getOrderType().intValue());
//                    erpProductOwnerDTO.setErrorWmsOwnerId(settleOrderItemSecOwnerDTO.getSecOwnerId());
//                    erpProductOwnerDTO.setErrorErpOwnerId(erpOwnerMap.get(String.valueOf(erpProductOwnerDTO.getErrorWmsOwnerId())));
//                    erpProductOwnerDTO.setUnitTotalCount(settleOrderItemSecOwnerDTO.getSecCount());
//                    erpProductOwnerDTO.setOrderNo(order.getRemark());
//                    erpProductOwnerDTO.setSpecId(skuSpecMap.get(it.getProductSkuId()));
//                    erpProductOwnerDTO.setOmsItemId(settleOrderItemSecOwnerDTO.getOmsOrdetItemId());
//                    list.add(erpProductOwnerDTO);
//                }
//            });
//        }
//
//        /**合并数量,产品加规格分组，每组根据出入加减*/
//        result = margeCount(result);
//        System.out.println(JSON.toJSONString(result));
//        return result;
//    }


    public static List<ErpProductOwnerDTO> margeCount(List<ErpProductOwnerDTO> list) {
        List<ErpProductOwnerDTO> result = new ArrayList<>();
        List<ErpProductOwnerDTO> collect = list.stream().filter(it -> it.getUnitTotalCount() == null).collect(Collectors.toList());
        System.out.println(JSON.toJSONString("数量为空："+JSON.toJSONString(collect)));
        /**合并数量,产品加规格分组，每组根据出入加减*/
        Map<String, List<ErpProductOwnerDTO>> map = list.stream().filter(it->it.getUnitTotalCount()!=null).collect(Collectors.groupingBy(it -> it.getProductSkuId() + "_" + it.getErrorWmsOwnerId()+"_"+it.getOrderType()));
        for (List<ErpProductOwnerDTO> value : map.values()) {
            BigDecimal addCount = value.stream().map(ErpProductOwnerDTO::getUnitTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
            ErpProductOwnerDTO dto = new ErpProductOwnerDTO();
            BeanUtils.copyProperties(value.get(0), dto);
            dto.setUnitTotalCount(addCount);
            result.add(dto);
        }

        return result;
    }

    public static List<ErpProductOwnerDTO> margeCountBySec(List<ErpProductOwnerDTO> list) {
        List<Integer> outOrderTypes =Arrays.asList(77,81);

        List<ErpProductOwnerDTO> result = new ArrayList<>();
        List<ErpProductOwnerDTO> collect = list.stream().filter(it -> it.getUnitTotalCount() == null).collect(Collectors.toList());
        System.out.println(JSON.toJSONString("数量为空："+JSON.toJSONString(collect)));
        /**合并数量,产品加规格分组，每组根据出入加减*/
        Map<String, List<ErpProductOwnerDTO>> map = list.stream().filter(it -> it.getUnitTotalCount() != null).collect(Collectors.groupingBy(it -> it.getProductSkuId() + "_" + it.getErrorWmsOwnerId()));
        for (List<ErpProductOwnerDTO> value : map.values()) {
            BigDecimal outCount = value.stream().filter(it->outOrderTypes.contains(it.getOrderType())).map(ErpProductOwnerDTO::getUnitTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inCount = value.stream().filter(it->it.getOrderType().equals(78)).map(ErpProductOwnerDTO::getUnitTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
            ErpProductOwnerDTO dto = new ErpProductOwnerDTO();
            BeanUtils.copyProperties(value.get(0), dto);
            dto.setOrderType(null);
            dto.setInCount(inCount);
            dto.setOutCount(outCount);
            dto.setUnitTotalCount(outCount.subtract(inCount));
            if (dto.getUnitTotalCount() != null && dto.getUnitTotalCount().compareTo(BigDecimal.ZERO) != 0) {
                result.add(dto);
            }
        }

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


    public static List<OrderAllPageDTO> listorder(Integer orgId, Integer warehosueId) {
        String url = "order/listGroupSettleOrder";
        String body = "{\"pageSize\":200,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehosueId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"111\",\"currentPage\":1,\"orderTypes\":[77,78],\"states\":[7,10]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        return orderAllPageDTOS;
    }

    public static List<OrderAllPageDTO> listorder(Integer orgId, Integer warehosueId,Integer orderSource) {
        String url = "order/listGroupSettleOrder";
        String body = "{\"pageSize\":200,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehosueId + "],\"orderCreateTimeStart\":\"2021-03-30 00:00:00\",\"orderCreateTimeEnd\":\"2021-04-30 23:59:59\",\"orderSource\":\"" + orderSource + "\",\"currentPage\":1,\"orderTypes\":[77,78],\"states\":[7,10]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        return orderAllPageDTOS;
    }


    /**
     * 获取产品信息
     *
     * @param skuIds
     * @param orgId
     * @return
     */
    public static Map<Long, ProductSkuListDTO> getSkuInfoMap(List<Long> skuIds, Integer orgId) {
        String url = "/productSku/getProductSku/";
        List<ProductSkuListDTO> skuInfoList = new ArrayList<>();
        for (Long skuId : skuIds) {
            String sku = BaseUtils.getRequest(url, skuId.toString());
            if (sku != null && !sku.equals("null")) {
                ProductSkuListDTO skuInfo = JSON.parseObject(sku, ProductSkuListDTO.class);
                skuInfoList.add(skuInfo);
            }
        }
        Map<Long, ProductSkuListDTO> skuInfoMap = skuInfoList.stream().collect(Collectors.toMap(it -> it.getProductSkuId(), it -> it, (v1, v2) -> v1));
        return skuInfoMap;
    }


    /**
     * 仓库和sku对应关系
     *
     * @return
     */
    public static Map<Integer, List<String>> getSkuNameMap() {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1681, Arrays.asList("怡宝水555ml （1*24）", "维他奶原味豆奶【盒】250ml（1*24）"));
        map.put(4001, Arrays.asList("雪碧【瓶】500ml（1*24）", "红牛250ml（1*24）", "康师傅香辣牛肉面桶装108g（1*12）", "今麦郎软化纯净水550ml（1*24）", "康师傅包装饮用水[瓶]550ml（1*28）"));
        map.put(4041, Arrays.asList("迎驾银星（新包装）42度450ml（1*4）"));
        map.put(4031, Arrays.asList("喜之郎美好时光海苔原味1.5g（1*90）"));
        map.put(7041, Arrays.asList("怡宝水555ml （1*24）", "王老吉凉茶植物饮料（听装）310ml（1*20）", "汾阳王八年39度248ml", "蒙牛酸酸乳原味250ml（1*24）"
                , "达利园桂圆莲子八宝粥360ml（1*12）", "老白汾酒十年42度450ml", "百威啤酒[瓶]9.7度460ml（1*12）", "晋泉高粱白清香型42度550ml（1*6）", "燕京啤酒U8/8度500ml（1*12）"
                , "汾酒玻璃瓶42度475ml （1*12）【美团专供】"));
        map.put(7111, Arrays.asList("脉动青柠口味600ml（1*15）", "百岁山饮用天然矿泉水348ml（1*24）", "娃哈哈AD钙奶100g（1*48）", "伊利高端畅饮系列安慕希希腊风味酸奶230g（1*10）"
                , "娃哈哈饮用天然矿泉水596ml（1*24）", "雕牌全效加浓洗洁精1.5kg", "俄罗斯米勒4.2度450ml（1*12）"));
        return map;
    }

    /**
     * 产品和二级货主对应关系
     *
     * @return
     */
    public static Map<String, String> getSkuSec() {
        Map<String, String> map = new HashMap<>();
        map.put("怡宝水555ml （1*24）", "1395869718239583051");
        map.put("维他奶原味豆奶【盒】250ml（1*24）", "1395869718239584926");
        map.put("雪碧【瓶】500ml（1*24）", "1395869718239582114");
        map.put("红牛250ml（1*24）", "1395869718239566340");
        map.put("康师傅香辣牛肉面桶装108g（1*12）", "1395869718239570091");
        map.put("今麦郎软化纯净水550ml（1*24）", "1395869718239572067");
        map.put("康师傅包装饮用水[瓶]550ml（1*28）", "1395869718239569085");
        map.put("迎驾银星（新包装）42度450ml（1*4）", "");
//        map.put("怡宝水555ml （1*24）","1395869718239558797");
        map.put("老白汾酒十年42度450ml", "1395869718239558216");
        map.put("汾酒玻璃瓶42度475ml （1*12）【美团专供】", "1395869718239558216");
        map.put("脉动青柠口味600ml（1*15）", "null");
        map.put("百岁山饮用天然矿泉水348ml（1*24）", "1395869718239560788");
        map.put("娃哈哈AD钙奶100g（1*48）", "1395869718239553509");
        map.put("伊利高端畅饮系列安慕希希腊风味酸奶230g（1*10）", "1395869718239575624");
        map.put("娃哈哈饮用天然矿泉水596ml（1*24）", "1395869718239553509");
        map.put("雕牌全效加浓洗洁精1.5kg", "1395869718239571945");
        map.put("俄罗斯米勒4.2度450ml（1*12）", "1395869718239575428");
        return map;
    }

    /**
     * 产品和规格对应关系
     * todo 待补充数据
     * [71100038136458,71100083356891,40000002257189,4903302845124561758,71100138217725,16800001198513,40000001548114,4902119644662319944,
     * 4911289297360599187,71100001542278,16800005831135,4867681516293513043,40000025226449,40000011177290,71100001840110]
     *
     * @return
     */
    public static Map<Long, Long> getSkuSpec() {
        Map<Long, Long> map = new HashMap<>();
        map.put(16800001198513L, 1198L);
        map.put(16800005831135L, 5831L);
        map.put(40000001548114L, 1548L);
        map.put(40000002257189L, 2257L);
        map.put(40000011177290L, 11177L);
        map.put(40000025226449L, 25226L);
        map.put(71100001542278L, 1542L);
        map.put(71100001840110L, 1840L);
        map.put(71100038136458L, 38136L);
        map.put(71100083356891L, 83356L);
        map.put(71100138217725L, 138217L);
        map.put(4867681516293513043L, 370265L);
        map.put(4902119644662319944L, 417014L);
        map.put(4903302845124561758L, 6021L);
        map.put(4911289297360599187L, 74902L);
        return map;
    }



}
