package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.service.newcheck.DataDTO;
import com.common.generate.javacreate.test.dto.InventoryDetailDTO;
import com.common.generate.javacreate.test.dto.Inventorycheck;
import com.common.generate.javacreate.test.dto.ProductSkuDTO;
import com.common.generate.javacreate.test.dto.SettleOrderItemDetailDTO;
import com.common.generate.javacreate.test.dto.SettleOrderUpdateDTO;
import com.common.generate.javacreate.test.dto.SettleSkuOrderUpdateDTO;
import com.common.generate.javacreate.test.dto.SettlementOrderCreateDTO;
import com.common.generate.javacreate.test.dto.SettlementOrderItemCreateDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderDetailDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderPageParamDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderQueryDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderCompleteItemMqDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderItemProductOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderCompleteMqDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.HttpClientUtils;
import com.common.generate.javacreate.utils.StringUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/11 15:12
 */
public class ErpInventoryCheck {

    private static final String cookie = "YJPID=4db0147aacf3453ab3103a6aed1f6743; JSESSIONID=F9D2BE160607C3EA98F91396076F9D82; acw_tc=2760820e16221660894535844ed618fde01386b5250e18ff2b7b387366fce0";
    private static final String baseUrl = "http://scop.pre.yijiupi.com/";



    public static void main(String[] args) throws Exception {
//        findCanOffset();
//        getInventoryDetail();
        pushToErp2();
    }

    public static List<Long> getSkuList() {
        return Arrays.asList(10300034772186L, 10300001541851L, 10300001817353L, 10300001188290L, 10300001198659L, 10300002257379L, 11400151112789L, 11900003173415L, 11900107485366L, 11900002257872L, 15900001555063L, 15900001543515L, 15900003107231L, 15900002494978L, 15900000947637L, 15900001698710L, 4777582275521374212L, 4776428017752634507L, 15900002112802L, 15900004804715L, 4837683092788004680L, 16800001198513L, 4856422847213753558L, 16800005831135L, 40000001548114L, 40000001188672L, 40000007147440L, 40000008122805L, 40000002057402L, 40000125367050L, 40000000311338L, 4867681516293513043L, 40000004919492L, 40000031358303L, 40000002257189L, 4864434714945576796L, 40000002112159L, 40000001542800L, 4810048808338993613L, 40000025226449L, 40000003839768L, 40300031652437L, 4841638631619101918L, 40300001789506L, 4792681681467797833L, 40400003532053L, 40400001083802L, 40400004804436L, 4863407525556840346L, 4843976557031033624L, 40500047275913L, 40500001732374L, 40500001543931L, 40500001542870L, 40600007145129L, 40600007322579L, 40600060789141L, 41200003107709L, 41200001548573L, 41200001188935L, 41200003839759L, 41200001547655L, 41200011226417L, 41900001570554L, 42100001548502L, 46500004120239L, 47300004857769L, 47300005371601L, 4906403955730592475L, 70400003872819L, 70400058662050L, 71100083356891L, 71100009754035L, 71100045702871L, 4798125746493601992L, 4911289754947203800L, 72100000561291L, 72300064063536L, 72300000734167L, 4858349024854966668L, 4863070008034982426L, 4863070007510694409L, 4913571146116674243L, 4871774843329237022L, 4882346446964030220L);
    }


    public static void pushToErp2() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\5-20差异数据.xlsx";
        filePath = "C:\\Users\\Administrator\\Desktop\\团购二级货主修复\\重推erp数据2.xlsx";

        FileInputStream file = new FileInputStream(filePath);
        List<Inventorycheck> list = ExcelUtils.readExcelToEntity(Inventorycheck.class, file, "5-26-1二级货主.xlsx");
        List<Inventorycheck> dtos = list.stream().filter(it -> it.getNeedFix() != null && it.getNeedFix().equals(1)).collect(Collectors.toList());
        Map<Long, ProductSkuDTO> skuMap = getskuMap();
        dtos.forEach(it -> {
            ProductSkuDTO productSkuDTO = skuMap.get(it.getProductSkuId());
            it.setSpecQuantity(productSkuDTO.getPackageQuantity().stripTrailingZeros());
            it.setSpecName(productSkuDTO.getSpecificationName());
            it.setProductSpecificationId(productSkuDTO.getProductSpecificationId());
            it.setPackageName(productSkuDTO.getPackageName());
            it.setUnitName(productSkuDTO.getUnitName());
            it.setOrgId(Integer.valueOf(it.getWarehouseId().toString().substring(0, 3)));
            it.setProductName(it.getProductName());
            it.setOwnerId(it.getOwnerId());
            it.setCreateTime(DateUtils.getCurrentTime());
            it.setLastUpdateTime(DateUtils.getCurrentTime());
            it.setCreateTime("2021-07-19 00:00:00");
            it.setLastUpdateTime("2021-07-19 00:00:00");
        });
        System.out.println(JSON.toJSONString(dtos));


        List<SettleOrderCompleteMqDTO> result = new ArrayList<>();
        List<SettlementOrderCreateDTO> result2 = new ArrayList<>();

        for (Inventorycheck dto : dtos) {
            if ("出".equals(dto.getType())) {
                result.add(convertComplete(dto, 1));
                result2.add(convertOtherInOut(dto, 2));
            }
            if ("入".equals(dto.getType())) {
                result.add(convertComplete(dto, 2));
                result2.add(convertOtherInOut(dto, 1));
            }
        }
        System.out.println("结算单:" + JSON.toJSONString(result));

        System.out.println("其他出入:" + JSON.toJSONString(result2));

        createSql(dtos);

        updateData(dtos);

    }


    private static void updateData(List<Inventorycheck> dtos ){
        List<SettleOrderUpdateDTO> settleOrderUpdateDTOS =new ArrayList<>();
        List<SettleOrderUpdateDTO> settleOrderUpdateDTOS2 =new ArrayList<>();

        List<SettleSkuOrderUpdateDTO> settleSkuOrderUpdateDTOS =new ArrayList<>();

        dtos.stream().filter(it -> it.getSqlType().equals(1)).forEach(it -> {
            SettleOrderUpdateDTO settleOrderUpdateDTO = new SettleOrderUpdateDTO();
            settleOrderUpdateDTO.setId(it.getSettleId());
            if (it.getType().equals("入")) {
                settleOrderUpdateDTO.setSettleAmount(it.getTotalAmount().negate());
            }else {
                settleOrderUpdateDTO.setSettleAmount(it.getTotalAmount());
            }
            settleOrderUpdateDTOS.add(settleOrderUpdateDTO);
        });

        dtos.stream().filter(it -> it.getSqlType().equals(2)).forEach(it -> {
            SettleOrderUpdateDTO settleOrderUpdateDTO = new SettleOrderUpdateDTO();
            settleOrderUpdateDTO.setId(it.getSettleId());
            if (it.getType().equals("入")) {
                settleOrderUpdateDTO.setSettleAmount(it.getTotalAmount().negate());
            }else {
                settleOrderUpdateDTO.setSettleAmount(it.getTotalAmount());
            }
            settleOrderUpdateDTOS2.add(settleOrderUpdateDTO);

            SettleSkuOrderUpdateDTO settleSkuOrderUpdateDTO =new SettleSkuOrderUpdateDTO();
            settleSkuOrderUpdateDTO.setId(it.getGroupOrderSkuId());
            BigDecimal[] counts = it.getDiffTotalCount().divideAndRemainder(it.getSpecQuantity(), new MathContext(2, RoundingMode.HALF_UP));
            BigDecimal bigCount = counts[0];
            BigDecimal unitCount = counts[1];

            if (it.getType().equals("入")) {
                settleSkuOrderUpdateDTO.setStorePackageCount(bigCount);
                settleSkuOrderUpdateDTO.setStoreUnitCount(unitCount);
                settleSkuOrderUpdateDTO.setSaleStorePackageCount(bigCount);
                settleSkuOrderUpdateDTO.setSaleStoreUnitCount(unitCount);
                settleSkuOrderUpdateDTO.setSettleAmount(it.getTotalAmount().negate());
            }else {
                settleSkuOrderUpdateDTO.setDeliverPackageCount(bigCount);
                settleSkuOrderUpdateDTO.setDeliverUnitCount(unitCount);
                settleSkuOrderUpdateDTO.setSaleDeliverPackageCount(bigCount);
                settleSkuOrderUpdateDTO.setSaleDeliverUnitCount(unitCount);
                settleSkuOrderUpdateDTO.setSettleAmount(it.getTotalAmount());
            }
            settleSkuOrderUpdateDTOS.add(settleSkuOrderUpdateDTO);
        });

        System.out.println("order:"+JSON.toJSONString(settleOrderUpdateDTOS));
        System.out.println("order2:"+JSON.toJSONString(settleOrderUpdateDTOS2));

        System.out.println("ordersku:"+JSON.toJSONString(settleSkuOrderUpdateDTOS));

    }


    private static void createSql(List<Inventorycheck> dtos) {
        List<String> skuItemSqls = new ArrayList<>();
        List<String> skuSqls = new ArrayList<>();
        List<String> orderBillSqls = new ArrayList<>();
        List<String> orderBillOwnerSqls = new ArrayList<>();

        List<String> groupBillSqls = new ArrayList<>();


        List<String> updateSkuSqls = new ArrayList<>();
        List<String> updateOrderBillSqls = new ArrayList<>();
        List<String> updateGroupBillSqls = new ArrayList<>();

        List<SettleOrderUpdateDTO> settleOrderUpdateDTOS =new ArrayList<>();
        for (Inventorycheck dto : dtos) {
            if (dto.getSqlType() == null) {
                return;
            }
            if (dto.getSqlType().equals(1)) {
                createInsertSql(dto, skuItemSqls, skuSqls, orderBillSqls,orderBillOwnerSqls, groupBillSqls);
            } else {
                createUpdateSql(dto, updateSkuSqls,updateOrderBillSqls, updateGroupBillSqls);
            }
        }

        System.out.println("#新增 group_settle_order_sku:" + JSON.toJSONString(skuSqls));
        System.out.println("#新增 group_settle_order_sku_item:" + JSON.toJSONString(skuItemSqls));
        System.out.println("#新增 group_settle_order_bill:" + JSON.toJSONString(orderBillSqls));
        System.out.println("#新增 group_settle_order_bill_owner:" + JSON.toJSONString(orderBillOwnerSqls));
        System.out.println("#新增变更账单 groupBillSqls:" + JSON.toJSONString(groupBillSqls));

        System.out.println("#修改 group_settle_order_sku:" + JSON.toJSONString(updateSkuSqls));
        System.out.println("#修改变更账单 group_settle_order:" + JSON.toJSONString(updateGroupBillSqls));

    }

    private static void createUpdateSql(Inventorycheck dto, List<String> skuSqls,List<String> orderBillSqls, List<String> groupBillSqls) {
        skuSqls.add(CreateSqlUtil.updateSkuSql(dto));
        orderBillSqls.add(CreateSqlUtil.updateOrderBillSql(dto));
        groupBillSqls.add(CreateSqlUtil.createGroupBillSql(dto));
    }

    private static void createInsertSql(Inventorycheck dto, List<String> skuItemSqls, List<String> skuSqls, List<String> orderBillSqls,
                                        List<String> orderBillOwnerSqls, List<String> groupBillSqls) {

//        skuSqls.add(CreateSqlUtil.createSkuSql(dto));
//
//        skuItemSqls.add(CreateSqlUtil.createSkuItemSql(dto));
//
//        orderBillSqls.add(CreateSqlUtil.createOrderBillSql(dto));
//
//        orderBillOwnerSqls.add(CreateSqlUtil.createOrderBillOwnerSql(dto));

        groupBillSqls.add(CreateSqlUtil.createGroupBillSql(dto));

    }




    private static SettlementOrderCreateDTO convertOtherInOut(Inventorycheck dto, Integer type) {
        SettlementOrderCreateDTO createDTO = new SettlementOrderCreateDTO();
        /**出*/
        if (type == 1) {
            createDTO.setOrderType((byte) 64);
            createDTO.setChannelNo(110);
            createDTO.setOrderAmount(BigDecimal.ZERO);
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(Integer.valueOf(dto.getWarehouseId().toString().substring(0, 3)));
            createDTO.setRelatedNoteNO(dto.getSettleNo());

            SettlementOrderItemCreateDTO itemCreateDTO = new SettlementOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getProductSkuId());
            itemCreateDTO.setProductName(dto.getProductName());
            itemCreateDTO.setMinUnitTotalCount(dto.getDiffTotalCount());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO);

            SettleOrderItemDetailDTO itemDetailDTO = new SettleOrderItemDetailDTO();
            if (StringUtils.isNotEmpty(dto.getTrueOwnerId())) {
                itemDetailDTO.setSecOwnerId(Long.valueOf(dto.getTrueOwnerId()));
            }
            itemDetailDTO.setUnitTotalCount(dto.getDiffTotalCount());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        } else {
            /**入*/
            createDTO.setOrderType((byte) 89);
            createDTO.setChannelNo(110);
            createDTO.setOrderAmount(BigDecimal.ZERO);
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(Integer.valueOf(dto.getWarehouseId().toString().substring(0, 3)));
            createDTO.setRelatedNoteNO(dto.getSettleNo());
            SettlementOrderItemCreateDTO itemCreateDTO = new SettlementOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getProductSkuId());
            itemCreateDTO.setProductName(dto.getProductName());
            itemCreateDTO.setMinUnitTotalCount(dto.getDiffTotalCount());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO);

            SettleOrderItemDetailDTO itemDetailDTO = new SettleOrderItemDetailDTO();
            if (StringUtils.isNotEmpty(dto.getTrueOwnerId())) {
                itemDetailDTO.setSecOwnerId(Long.valueOf(dto.getTrueOwnerId()));
            }
            itemDetailDTO.setUnitTotalCount(dto.getDiffTotalCount());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        }
        return createDTO;
    }


    private static SettleOrderCompleteMqDTO convertComplete(Inventorycheck dto, Integer type) {
        Long settleId = dto.getSettleId();
//        String substringSettleId = String.valueOf(settleId).substring(0, 17);
        SettleOrderCompleteMqDTO completeMqDTO = new SettleOrderCompleteMqDTO();
        BigDecimal diffTotalCount = dto.getDiffTotalCount();
        completeMqDTO.setCompanyCode(dto.getCompanyCode());
        completeMqDTO.setOrderSource((byte) 0);
        completeMqDTO.setUserId(dto.getUserId());
        completeMqDTO.setWarehouseId(dto.getWarehouseId());
        completeMqDTO.setOrgId(Integer.valueOf(dto.getWarehouseId().toString().substring(0, 3)));
        completeMqDTO.setOrderCreateTime(dto.getDate());
        completeMqDTO.setOrderCompleteTime(dto.getCompleteTime());
        completeMqDTO.setOrderAmount(dto.getTotalAmount());
        completeMqDTO.setPayableAmount(dto.getTotalAmount());
        completeMqDTO.setOmsOrderId(settleId);
        OrderCompleteItemMqDTO itemMqDTO = new OrderCompleteItemMqDTO();
        itemMqDTO.setOrderItemId(dto.getGroupOrderSkuId());
        itemMqDTO.setMinUnitTotalCount(diffTotalCount);
        itemMqDTO.setProductSkuId(dto.getProductSkuId());
        itemMqDTO.setProductName(dto.getProductName());
        itemMqDTO.setSellPrice(dto.getCostPrice());
        if (type == 2) {
            completeMqDTO.setOrderNo(dto.getSettleNo() + "-4");
            completeMqDTO.setOrderType((byte) 78);
            completeMqDTO.setState((byte) 10);
            OrderItemProductOwnerDTO ownerDTO = new OrderItemProductOwnerDTO();
            ownerDTO.setCount(diffTotalCount);
            if (StringUtils.isNotEmpty(dto.getTrueOwnerId()) && !dto.getTrueOwnerId().equals("0") && !dto.getTrueOwnerId().equals("NULL") && !dto.getTrueOwnerId().equals("null")) {
                ownerDTO.setSecOwnerId(dto.getTrueOwnerId());
            }
            itemMqDTO.setTotalAmount(dto.getTotalAmount());
            itemMqDTO.setPayableAmount(dto.getTotalAmount());
            itemMqDTO.setSecOwnerDetail(Arrays.asList(ownerDTO));
        } else {
            completeMqDTO.setOrderNo(dto.getSettleNo() + "-3");
            completeMqDTO.setOrderType((byte) 77);
            completeMqDTO.setState((byte) 7);
            OrderItemProductOwnerDTO ownerDTO = new OrderItemProductOwnerDTO();
            ownerDTO.setCount(diffTotalCount);
//            if (StringUtils.isNotEmpty(dto.getErrorOwnerId()) && !dto.getErrorOwnerId().equals("0") && !dto.getErrorOwnerId().equals("NULL") && !dto.getErrorOwnerId().equals("null")) {
//                ownerDTO.setSecOwnerId(dto.getErrorOwnerId());
//            }
            if (StringUtils.isNotEmpty(dto.getTrueOwnerId()) && !dto.getTrueOwnerId().equals("0") && !dto.getTrueOwnerId().equals("NULL") && !dto.getTrueOwnerId().equals("null")) {
                ownerDTO.setSecOwnerId(dto.getTrueOwnerId());
            }
            itemMqDTO.setSecOwnerDetail(Arrays.asList(ownerDTO));
            itemMqDTO.setTotalAmount(dto.getTotalAmount());
            itemMqDTO.setPayableAmount(dto.getTotalAmount());
        }
        completeMqDTO.setItems(Arrays.asList(itemMqDTO));
        return completeMqDTO;
    }


//    public static void pushToErp() throws Exception {
//        String filePath = "C:\\Users\\Administrator\\Desktop\\5-20差异数据.xlsx";
//        filePath = "C:\\Users\\Administrator\\Desktop\\团购二级货主修复\\二级货主10.xlsx";
//
//        FileInputStream file = new FileInputStream(filePath);
//        List<Inventorycheck> list = ExcelUtils.readExcelToEntity(Inventorycheck.class, file, "二级货主10.xlsx");
//
//        List<Inventorycheck> dtos = list.stream().filter(it -> it.getNeedFix() != null && it.getNeedFix().equals(1)).collect(Collectors.toList());
//
//        System.out.println(JSON.toJSONString(dtos));
//        List<SettleOrderCompleteMqDTO> result = new ArrayList<>();
//        for (Inventorycheck dto : dtos) {
//            SettleOrderCompleteMqDTO completeMqDTO = new SettleOrderCompleteMqDTO();
//            BigDecimal diffTotalCount = dto.getDiffTotalCount();
//            if (dto.getDiffTotalCount().compareTo(BigDecimal.ZERO) > 0) {
//                completeMqDTO.setOrderType((byte) 77);
//            } else {
//                diffTotalCount = diffTotalCount.negate();
//                completeMqDTO.setOrderType((byte) 78);
//            }
//            completeMqDTO.setCompanyCode(dto.getCompanyCode());
//            completeMqDTO.setOrderSource((byte) 0);
//            completeMqDTO.setUserId(dto.getUserId());
//            completeMqDTO.setWarehouseId(dto.getWarehouseId());
//            completeMqDTO.setOrgId(Integer.valueOf(dto.getWarehouseId().toString().substring(0,3)));
//            OrderCompleteItemMqDTO itemMqDTO = new OrderCompleteItemMqDTO();
//            itemMqDTO.setMinUnitTotalCount(diffTotalCount);
//            itemMqDTO.setProductSkuId(dto.getProductSkuId());
//            itemMqDTO.setProductName(dto.getProductName());
//            itemMqDTO.setSellPrice(dto.getCostPrice());
//            OrderItemProductOwnerDTO ownerDTO = new OrderItemProductOwnerDTO();
//            ownerDTO.setCount(diffTotalCount);
//            if(!dto.getTrueOwnerId().equals("0")){
//                ownerDTO.setSecOwnerId(dto.getTrueOwnerId());
//            }
//            itemMqDTO.setSecOwnerDetail(Arrays.asList(ownerDTO));
//            completeMqDTO.setItems(Arrays.asList(itemMqDTO));
//            result.add(completeMqDTO);
//        }
//        System.out.println(JSON.toJSONString(result));
//    }


    public static List<Inventorycheck> findCanOffset() {
        List<Inventorycheck> dtos = pageList();

//        List<Long> skuList1 = getSkuList();
//        List<Inventorycheck> collect3 = dtos.stream().filter(it -> skuList1.contains(it.getProductSkuId())).collect(Collectors.toList());
//        System.out.println("出库申请单涉及涉及数据1："+JSON.toJSONString(collect3));
//        Set<String> collect4 = collect3.stream().map(it -> it.getWarehouseName()).collect(Collectors.toSet());
//        System.out.println("出库申请单涉及涉及数据2："+JSON.toJSONString(collect4));
//        Map<String, List<Inventorycheck>> collect5 = collect3.stream().collect(Collectors.groupingBy(it -> it.getWarehouseName()));
//        System.out.println("出库申请单涉及涉及数据3："+JSON.toJSONString(collect5));

        Set<Integer> warehouseIds = dtos.stream().map(it -> it.getWarehouseId()).collect(Collectors.toSet());
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> noWarehouse = new ArrayList<>();
        List<Integer> needWarehouse = new ArrayList<>();
        Set<Long> skuIdSet = new HashSet<>();
        System.out.println(JSON.toJSONString(warehouseIds));
        for (Integer warehouseId : warehouseIds) {
            List<GroupSettleOrderQueryDTO> grouplist = grouplist(warehouseId);
            if (CollectionUtils.isNotEmpty(grouplist)) {
                needWarehouse.add(warehouseId);
            } else {
                noWarehouse.add(warehouseId);
            }
        }

        System.out.println("需要处理仓库Id：" + JSON.toJSONString(needWarehouse));
        System.out.println("不需要处理仓库ID：" + JSON.toJSONString(noWarehouse));
        System.out.println("未过滤数据:" + JSON.toJSONString(dtos));
        List<Inventorycheck> collect = dtos.stream().filter(it -> noWarehouse.contains(it.getWarehouseId())).collect(Collectors.toList());
        Set<String> collect1 = collect.stream().map(it -> it.getWarehouseName()).collect(Collectors.toSet());
        System.out.println("过滤仓库:" + JSON.toJSONString(collect1));
        System.out.println("过滤仓库的数据:" + JSON.toJSONString(collect));


        dtos = dtos.stream().filter(it -> needWarehouse.contains(it.getWarehouseId())).collect(Collectors.toList());
        Set<String> warehouseSet = dtos.stream().map(it -> it.getWarehouseName()).collect(Collectors.toSet());
        System.out.println("处理仓库:" + JSON.toJSONString(warehouseSet));
        System.out.println("过滤仓库后数据:" + JSON.toJSONString(dtos));


        /**过滤skuId*/
        List<Long> skuList = getSkuList(needWarehouse);
        List<Inventorycheck> notExistskuDTOs = dtos.stream().filter(it -> !skuList.contains(it.getProductSkuId())).collect(Collectors.toList());
        System.out.println("需要过滤的产品:" + JSON.toJSONString(notExistskuDTOs));

        List<Inventorycheck> existskuDTOs = dtos;
//        List<Inventorycheck> existskuDTOs = dtos.stream().filter(it -> skuList.contains(it.getProductSkuId())).collect(Collectors.toList());
//        System.out.println("过滤产品后:"+JSON.toJSONString(existskuDTOs));

//        List<Integer> warehouesIds = Arrays.asList(4001);
//        List<Inventorycheck> collect3 = existskuDTOs.stream().filter(it -> warehouesIds.contains(it.getWarehouseId())).collect(Collectors.toList());
//        System.out.println("今日处理异常："+JSON.toJSONString(collect3));


        List<Inventorycheck> notGroupList = new ArrayList<>();
        notGroupList.addAll(collect);
        notGroupList.addAll(notExistskuDTOs);
        System.out.println("过滤总数：" + JSON.toJSONString(notGroupList));


        Map<String, List<Inventorycheck>> collect2 = dtos.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getWarehouseId())));
        System.out.println("分仓库：" + JSON.toJSONString(collect2));

        List<Inventorycheck> result = new ArrayList<>();
        Map<Long, List<Inventorycheck>> skuSecMap = dtos.stream().collect(Collectors.groupingBy(it -> it.getProductSkuId()));
        for (List<Inventorycheck> inventorychecks : skuSecMap.values()) {
            BigDecimal addCount = inventorychecks.stream().map(it -> it.getDiffTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            if (addCount != null && addCount.compareTo(BigDecimal.ZERO) == 0) {
                result.addAll(inventorychecks);
            }
        }
        Map<String, List<Inventorycheck>> listMap = result.stream().collect(Collectors.groupingBy(it -> String.valueOf(it.getWarehouseId())));
        System.out.println("可抵消数据:" + JSON.toJSONString(listMap));

        return existskuDTOs;
    }


    public static void getInventoryDetail() {
        List<InventoryDetailDTO> inventoryDetail = getInventoryDetailPageList();
        List<InventoryDetailDTO> collect = inventoryDetail.stream().filter(it -> Arrays.asList(119, 74, 75, 76, 77, 78, 6).contains(it.getOrderType())
                && it.getCreateTime().after(DateUtils.string2Date("2021-04-01 00:16:25"))).collect(Collectors.toList());
        System.out.println("查询结果:" + JSON.toJSONString(inventoryDetail));
        System.out.println("团购单据:" + JSON.toJSONString(collect));

        BigDecimal reduce = collect.stream().map(it -> it.getAddStoreCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("总数量：" + reduce);
    }


    public static List<Inventorycheck> pageList() {
        String body = "{\"state\":1,\"startTime\":\"2021-05-24 00:00:00\",\"endTime\":\"2021-05-24 23:59:59\",\"orgId\":null,\"pageNum\":1,\"pageSize\":500}";
        String url = baseUrl + "/listInventoryCheckRecord";
        String resultstr = HttpClientUtils.doPostWithCookie(cookie, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        JSONObject pageList = (JSONObject) data;
        Object dataList = pageList.get("dataList");
        List<Inventorycheck> dtos = JSON.parseArray(JSON.toJSONString(dataList), Inventorycheck.class);
        System.out.println("接口返回数据：" + JSON.toJSONString(dtos));
        return dtos;
    }

    public static List<InventoryDetailDTO> getInventoryDetailPageList() {
        String body = "{\"state\":0,\"productSkuId\":\"41200001548573\",\"productStoreRecordSO\":{\"storeId\":\"6280f2ea5a2f49c4b133a25afe290070\"},\"currentPage\":1,\"pageSize\":500}";
        String url = baseUrl + "/getInventoryDetail";
        String resultstr = HttpClientUtils.doPostWithCookie(cookie, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        JSONObject pageList = (JSONObject) data;
        Object dataList = pageList.get("dataList");
        List<InventoryDetailDTO> dtos = JSON.parseArray(JSON.toJSONString(dataList), InventoryDetailDTO.class);
        for (InventoryDetailDTO dto : dtos) {
            dto.setAddStoreCount(dto.getAddStoreCountDTO().get(0).getTotalCountMinUnit());
            dto.setNewStoreCount(dto.getNewStoreCountDTO().get(0).getTotalCountMinUnit());
            dto.setSourceStoreCount(dto.getSourceStoreCountDTO().get(0).getTotalCountMinUnit());
            dto.setAddStoreCountDTO(null);
            dto.setNewStoreCountDTO(null);
            dto.setSourceStoreCountDTO(null);
        }
        return dtos;
    }


    /**
     * 查询账单列表
     *
     * @param warehosueId
     * @return
     */
    public static List<GroupSettleOrderQueryDTO> grouplist(Integer warehosueId) {
        String url = "groupsettle/list";
        String body = "{\"warehouseId\":1591,\"settleState\":\"2\",\"pageNum\":1,\"pageSize\":100}";
        GroupSettleOrderPageParamDTO query = JSON.parseObject(body, GroupSettleOrderPageParamDTO.class);
        query.setWarehouseId(warehosueId);
        String dataList = BaseUtils.pageList(url, JSON.toJSONString(query));
        List<GroupSettleOrderQueryDTO> result = JSON.parseArray(dataList, GroupSettleOrderQueryDTO.class);
        return result;
    }


    /**
     * 查询账单明细
     *
     * @param id
     * @param orgId
     * @return
     */
    public static GroupSettleOrderDetailDTO detail(Long id, Integer orgId) {
        String url = "/groupsettle/detail";
        String body = "{\"id\":\"" + id + "\",\"orgId\":" + orgId + "}";
        String dataList = BaseUtils.postRequest(url, body);
        GroupSettleOrderDetailDTO result = JSON.parseObject(dataList, GroupSettleOrderDetailDTO.class);
        return result;
    }


    public static List<Long> getSkuList(List<Integer> warehouseIds) {
        String json = "[11900002257872,11900001544369,15900039764356,4776428017752634507,15900001555063,15900001542822,15900001543515,15900002257896,15900004100919,15900003107231,15900020284900,15900000947637,15900001571045,4899573888009806981,15900001545525,15900002112802,15900002494978,15900001570200,15900002387732,15900001698710,15900004804715,4777582275521374212,10300036093825,10300034772186,10300001541851,10300001198659,4868120063903326040,10300058592849,10300001188290,10300039764286,10300002039168,10300001817353,11800001627349,4782934981700893586,11900003173415,11900107485366,15900139449334,15900042053339,15900137139844,4874307702317552080,16800001550060,16800001198513,16800001556914,4856422847213753558,16800005831135,4856114310375047578,16800002494787,4865617929370338499,16800149552175,4837683092788004680,16800009707763,10300002257379,10300002057249,16800054414485,4914220663409259211,4851462338656020312,4818371453431371409,10300000806628,10300001698774,10300011390332,10300024035200,4830010229609609425,10300001631835,4828648007766314381,15900001544189,15900002057998,15900001199688,4915539548343577494,4915538815550878724,4915538441600969606,15900001558415,15900002855769,15900096999325,4840550029370375748,4918521705039509965,15900001598166,4762808136317126601,4918811970881133015,4762809646526613465,4843977609109277455,15900007921311,4918812164504795588,15900011414123,16800107485056,10500001550578,15900001198232,4840550023645150798,10300040463503,10300032242993,10300007091822,4916954516003666062,10300013470005,10300000767772,10300000603421,11800002373505,4784349768017238225,10300001539221,10300001544384,10300029255314,10300006249906,10300001738539,40500045918380,40500004903862,40500007324285,4868120080311125195,4868120075144060753,40300031652437,4841638631619101918,47300004857769,47300005371601,47300000314832,4906403955730592475,4882236137363548800,46500004120239,40000001548114,40000002257189,40000002112159,40000001188672,40000007147440,40000008122805,40000002057402,40000125367050,40000000311338,40000014126194,4810048808338993613,40000035095723,40000000274708,4867681516293513043,40000004919492,40000031358303,40600007145129,40600007322579,40300002175530,40500047275913,40500001732374,40500001543931,40500001542870,40300001789506,40600060789141,4883722298632890510,45700002112726,4898229268965576593,45700004041800,45700007322813,45700151112247,45700212349819,45700001732122,45700006670766,45700157424090,4914905203882014871,45700163299992,4843976231850838792,42100001548502,42100003896749,42100001740974,40200001186081,40200001185134,40200191003138,40200151112433,40200002039377,40200000720852,4777195708915083281,40200001196309,4772133343308590227,40200068373569,41200003107709,41200001548573,41200001188935,41200011226417,41200005460591,41200003839759,41200001547655,41900001570554,4811593850524995407,4864434714945576796,40000001542800,40000011879564,40000003839768,40000025226449,42100125367541,4792681681467797833,40400003801709,40400003532053,40400001083802,40400081238512,40400118324793,40400004804436,4863407525556840346,4843976557031033624,40200017931599,4868120080000746717,40200006699081,40000000327603,40000000314758,40000011177290,40000000345936,4898913301915586445,4916350124036664198,4916350515008711581,4916246574359063435,4913792322898277086,40200001966917,4868120074816905051,4883722293336912022,4852495604158768973,45700154818520,4868120083825951965,4917073746453540618,4868120078717607765,40200002008745,40400000929540,40400025296238,40400002002831,40400002068227,40400001427967,40200107485257,4839885575663431176,40200010344660,4914474963946911887,4805790846589663702,4898229335453140054,45700001538697,42200001740632,4842424896706774238,4886895033932507286,4886895099478323342,4886895034370142364,4886892810884278411,42200001786669,42200001188278,42200025341318,4842424897222673611,4886897863277195419,4857529822652957063,4837685784688117583,42200018295307,4886894880253208708,42200007345215,42200001184477,42200003142517,4881180841792941125,4886894775563380875,4867019886400429917,4881180841284472989,42200001547915,42200001789404,42200001942800,4782907262911535635,42200001951095,42200001544233,42200001539825,42200001946499,42200001538285,42200001548310,42100001698022,4918865705011452365,4919247781099411906,42100004120664,40000001543981,40000001728709,4853961132699320718,40000024449226,40000001198979,40000001700443,4806183958200123102,40200006584526,40000023612916,4913824116469183198,47300019078504,40200007091250,40200001738274,40200009282764,40200013440757,4917063267437981459,40200032242553,40200005820548,40200002091175,4876383192217752645,40000205549629,40000053880558,46500098532278,4894970858680640154,4863070007510694409,4882346446964030220,4868120087060078413,71300005114385,71300125507884,71300016910015,71300001542537,71300018633970,71300002112740,71300015054397,71300124860465,71300065961108,4870215270593201360,71300007147815,71300006822427,71300020838857,71300107485940,72300064063536,72300000734167,4831457167568415948,71300033306951,71100001840110,4903302845124561758,71100038136458,71100138217725,71100083356891,4911289297360599187,71100001542278,71100009754035,71100045702871,4798125746493601992,71100014942681,4762809650397956061,4911289754947203800,4914829890263136385,4914829746021642965,4846769685230200662,70400058662050,70400003872819,70400004179551,4868120088104460106,4878295444626545290,4856545731224830355,71100001698972,71100006808431,4871774843329237022,72100001474154,4850031898749511489,72100095772710,72100001543776,4904313684237470530,72100001544098,72100000561291,4902119644662319944,4868120093263135965,4858349024854966668,4918775309778491867,4918775309522639299,4918775309243627971,4910822936935086237,4911187536171972763,71100008402891,4848561593682175825,4868120096660522176,72100002257860,72100092246781,72100064063802,4864101728907429059,72300002257688,4834051738386133523,4913473019518335118,72300151112005,72300002008258,4834074924121816020,72300001544974,72300061977471,4859048460132319624,72300001909023,4901876068776837957,4857194405374230935,72300007091337,72300008050469,4901122570588587091,72300011597837,4802652529178245579,4901872572377844568,4896054445971689374,72300002175500,72300126503494,4800288484106238425,72300003838941,72300001194493,4859371726133548241,72300011007495,72300000735098,4807710028041490262,72300002112939,4818830102728526662,72300020284517,72300006808810,4843980890195856148,4843984450853767939,72300001708490,4906463524741755609,72300001550426,72300020996550,72300000574724,4797817258464063064,4762811780701734866,4883715837932529819,72300006543979,4906463524472699011,4906475799615681220,72300008964881,72300119508442,72300000458563,72300002168344,72300015545895,4834728309226503706,70400001198573,70400246577610,70400035310888,4900666372567770268,4878249982938717824,70400036434349,70400002192815,70400119508960,70400020507124,70400004771458,70400001805161,70400000561123,70400107485774,4867775094944171223,70400045729366,70400000734145,70400137280702,70400137279046,70400012808917,70400015545097,4883715833935358105,4808579259717062493,70400001712088,4902109199868087134,70400007511548,70400000866295,70400223569221,70400055296219,4764773244960492378,70400001909142,70400055574169,4762842167339227603,70000003997500,71100001963062,4901051202577015936,4762809650167269330,4868120093514794184,70500002257905,70500061926486,70500000866450,4818112386641221276,70400152658472,4838025282723928450,4856064445599220100,70400002112386,4762809650133714895,4899929219156059285,4868120088377089884,70500001550988,4762808139823564743,70500001544859,4914049324954202825,70500000274925,4826453454930390036,4914136355822057616,70500003805568,70500003596766,4909104290470770831,70500000458508,70500000735764,4911899597349368516,4854433480133083522,70400137277122,70400126503449,70400065675182,4896760769680330628,4902591415888806737,70400001867611,70400147806561,70400042370760,70400134355089,70400001869226,70400004238313,70400001550198,70400147146765,70400259291478,4848810096002017111,4911899698733463695,70400006543454,70400147142269,70400075894126,70400161053907,70400015092172,4903667074948123469,70400047275562,4881229043816639561,70400018214677,70400014531341,4800288481950366171,70400001199510,70400000311984,72300001187941,72300001789482,70500199537436,4916711874550952975,70500003778179,4916711285903010715,70500079755292,70500119508499,4906566038166221518,70500025226304,4902584337789078352,72300007423164,4868120091619286854,4838803828364324358,70400003873278,70400003874554,70500001192110,70400075893526,70400000274814,4900731231291597453,4913571146116674243,4863070008034982426,71300014555974,4899686626614748292,71300013064726,71300011123336,4865909013648826176,4842071646737475410,71300001629182,4855383977274933636,71300052175451,70400115128069,72100003107482,72100001550612,4901129003966685850,70500241074592,4898229684818235287,4904980342309696222,4921298735416154580,71300011495444,4800288483103799771,71300013036684,70400000735411,71300011497641,4823452413621428445,71300018982931,71300013057202,4801442823674199745,71300011703678,4869915748583343307,4783221732033557568,71300045702952,4868120098103362753,4797796471748276498,71100025775936,71100016625753,4917041199350755086,71300001963842,4797459273308025105,4914137360543036101,4801442961708744409,4868120095301567694,4868120090226777946,71300014395671,71300127049672,4922394221610998226,4922392874176068035,4868120092218754255,70400001708531,71300025293315,71300021930906,4915161568935539739,71300023597087,4870947087826814160,4871406621964164952,4872879733728268301,4868043693907042130,4874552746374778884,4868042839539900230,4868082199761051456,4874551004962672662,4868080062016577366,4868040502377242451,4868080931504185158,4870292772846362447,4870261144627184845,72300220555560,72300007321449,4901873120338496349,4901871604930085716,72300002057004,4896054649897640581,4896054644521652125,4896054603705770642,4896054598468194184,4870261878966247250,4868068115338233041,4913788052504787076,4914970724153995973,4868874819554828105,4899663650217611147,71100046687950,71100024359765,71100017081970,71100017082489]";
        List<Long> skuIds = JSON.parseArray(json, Long.class);
//        skuIds = jiesuanService.listALLGroupSettleOrderSku(warehouseIds);

        return skuIds;

    }



    public static Map<Long, ProductSkuDTO> getskuMap() {
        String json = "[\n" +
                "    {\n" +
                "        \"cityId\": 119,\n" +
                "        \"defaultImageFileId\": \"51554\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 17.5,\n" +
                "        \"length\": 29.5,\n" +
                "        \"monthOfShelfLife\": 10,\n" +
                "        \"name\": \"雀巢咖啡丝滑拿铁268ml（1*15）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 15.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"雀巢\",\n" +
                "        \"productInfoId\": 2109,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 11900002112931,\n" +
                "        \"productSpecificationId\": 2112,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"11900002112931\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627948466035355,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"15瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"29.5*18.5*17.5\",\n" +
                "        \"weight\": 4.7,\n" +
                "        \"width\": 18.5\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 119,\n" +
                "        \"defaultImageFileId\": \"46673\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 6,\n" +
                "        \"name\": \"伊利金典纯牛奶250ml（1*12）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 12.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"伊利\",\n" +
                "        \"productInfoId\": 6651,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 11900006670219,\n" +
                "        \"productSpecificationId\": 6670,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"11900006670219\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"纯牛奶\",\n" +
                "        \"secondStatisticsClassId\": 4729628135724931723,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"12瓶/件\",\n" +
                "        \"statisticsClass\": \"牛奶乳品\",\n" +
                "        \"statisticsClassId\": 4729627946540849811,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 121,\n" +
                "        \"defaultImageFileId\": \"3531567\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"红牛250ml（1*24）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"红牛\",\n" +
                "        \"productInfoId\": 2254,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 12100002257692,\n" +
                "        \"productSpecificationId\": 2257,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"12100002257692\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439640,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 404,\n" +
                "        \"defaultImageFileId\": \"3531567\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"红牛250ml（1*24）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"红牛\",\n" +
                "        \"productInfoId\": 2254,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 40400002257302,\n" +
                "        \"productSpecificationId\": 2257,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"40400002257302\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439640,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 471,\n" +
                "        \"defaultImageFileId\": \"51554\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 17.5,\n" +
                "        \"length\": 29.5,\n" +
                "        \"monthOfShelfLife\": 10,\n" +
                "        \"name\": \"[下架]雀巢咖啡丝滑拿铁268ml（1*15）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 15.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"雀巢\",\n" +
                "        \"productInfoId\": 2109,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 47100002112418,\n" +
                "        \"productSpecificationId\": 2112,\n" +
                "        \"productState\": 0,\n" +
                "        \"refProductSkuId\": \"47100002112418\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627948466035355,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"15瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"29.5*18.5*17.5\",\n" +
                "        \"weight\": 4.7,\n" +
                "        \"width\": 18.5\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 713,\n" +
                "        \"defaultImageFileId\": \"9425911\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 10,\n" +
                "        \"name\": \"脉动青柠口味600ml（1*15）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 15.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"脉动\",\n" +
                "        \"productInfoId\": 1540,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 71300001542537,\n" +
                "        \"productSpecificationId\": 1542,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"71300001542537\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439640,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"15瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 723,\n" +
                "        \"defaultImageFileId\": \"8490850\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 9,\n" +
                "        \"name\": \"[下架]乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 12.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"乌苏\",\n" +
                "        \"productInfoId\": 145930,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 72300151112005,\n" +
                "        \"productSpecificationId\": 151112,\n" +
                "        \"productState\": 0,\n" +
                "        \"refProductSkuId\": \"799777805606240520\",\n" +
                "        \"saleModel\": 3,\n" +
                "        \"secondStatisticsClass\": \"国产\",\n" +
                "        \"secondStatisticsClassId\": 4729627943067966101,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"12瓶/件\",\n" +
                "        \"statisticsClass\": \"啤酒\",\n" +
                "        \"statisticsClassId\": 4729627941671262851,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 723,\n" +
                "        \"defaultImageFileId\": \"46673\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 6,\n" +
                "        \"name\": \"[下架]伊利金典纯牛奶250ml（1*12）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 12.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"伊利\",\n" +
                "        \"productInfoId\": 6651,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4769468096336272147,\n" +
                "        \"productSpecificationId\": 6670,\n" +
                "        \"productState\": 0,\n" +
                "        \"refProductSkuId\": \"72300006670055\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"纯牛奶\",\n" +
                "        \"secondStatisticsClassId\": 4729628135724931723,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"12瓶/件\",\n" +
                "        \"statisticsClass\": \"牛奶乳品\",\n" +
                "        \"statisticsClassId\": 4729627946540849811,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 704,\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 365,\n" +
                "        \"name\": \"[下架]燕京啤酒小度酒U8大滋味8度500ml（1*12）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 12.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"燕京\",\n" +
                "        \"productInfoId\": 285795,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4797796031061143825,\n" +
                "        \"productSpecificationId\": 294058,\n" +
                "        \"productState\": 0,\n" +
                "        \"refProductSkuId\": \"70400294058145\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"国产\",\n" +
                "        \"secondStatisticsClassId\": 4729627943067966101,\n" +
                "        \"shelfLifeUnit\": 3,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"12罐/件\",\n" +
                "        \"statisticsClass\": \"啤酒\",\n" +
                "        \"statisticsClassId\": 4729627941671262851,\n" +
                "        \"unitName\": \"罐\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 723,\n" +
                "        \"defaultImageFileId\": \"9649440\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"康师傅喝开水熟水饮用水550ml（1*24）\",\n" +
                "        \"ownerName\": \"易酒批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"康师傅\",\n" +
                "        \"productInfoId\": 298541,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4807710028041490262,\n" +
                "        \"productSpecificationId\": 307499,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"72300307499499\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"水\",\n" +
                "        \"secondStatisticsClassId\": 4729627945517439636,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易酒批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 713,\n" +
                "        \"defaultImageFileId\": \"9649440\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"康师傅喝开水熟水饮用水550ml（1*24）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"康师傅\",\n" +
                "        \"productInfoId\": 298541,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4823452413621428445,\n" +
                "        \"productSpecificationId\": 307499,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"76900307499409\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"水\",\n" +
                "        \"secondStatisticsClassId\": 4729627945517439636,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 769,\n" +
                "        \"defaultImageFileId\": \"9791255\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"name\": \"康师傅茉莉蜜茶500ml（1*16）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 16.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"康师傅\",\n" +
                "        \"productInfoId\": 317638,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4868065781715567831,\n" +
                "        \"productSpecificationId\": 328247,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"76900328247824\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439638,\n" +
                "        \"shelfLifeUnit\": 0,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"16瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 101,\n" +
                "        \"defaultImageFileId\": \"10348341\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"[下架]恒大天然矿泉水570ml（1*24）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"恒大\",\n" +
                "        \"productInfoId\": 379950,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4868120068239918288,\n" +
                "        \"productSpecificationId\": 393405,\n" +
                "        \"productState\": 0,\n" +
                "        \"refProductSkuId\": \"70100393405423\",\n" +
                "        \"saleModel\": 3,\n" +
                "        \"secondStatisticsClass\": \"水\",\n" +
                "        \"secondStatisticsClassId\": 4729627945517439636,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 704,\n" +
                "        \"defaultImageFileId\": \"10348341\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"[下架]恒大天然矿泉水570ml（1*24）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"恒大\",\n" +
                "        \"productInfoId\": 379950,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4868120093263135965,\n" +
                "        \"productSpecificationId\": 393405,\n" +
                "        \"productState\": 0,\n" +
                "        \"refProductSkuId\": \"70100393405423\",\n" +
                "        \"saleModel\": 3,\n" +
                "        \"secondStatisticsClass\": \"水\",\n" +
                "        \"secondStatisticsClassId\": 4729627945517439636,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 713,\n" +
                "        \"defaultImageFileId\": \"10348341\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"[下架]恒大天然矿泉水570ml（1*24）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"恒大\",\n" +
                "        \"productInfoId\": 379950,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4868120090226777946,\n" +
                "        \"productSpecificationId\": 393405,\n" +
                "        \"productState\": 0,\n" +
                "        \"refProductSkuId\": \"70100393405423\",\n" +
                "        \"saleModel\": 3,\n" +
                "        \"secondStatisticsClass\": \"水\",\n" +
                "        \"secondStatisticsClassId\": 4729627945517439636,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 769,\n" +
                "        \"defaultImageFileId\": \"3531567\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 18,\n" +
                "        \"name\": \"红牛250ml（1*24）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"红牛\",\n" +
                "        \"productInfoId\": 2254,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4871406621964164952,\n" +
                "        \"productSpecificationId\": 2257,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"76900002257181\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439640,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 769,\n" +
                "        \"defaultImageFileId\": \"9425911\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 10,\n" +
                "        \"name\": \"脉动青柠口味600ml（1*15）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 15.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"脉动\",\n" +
                "        \"productInfoId\": 1540,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4872879733728268301,\n" +
                "        \"productSpecificationId\": 1542,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"76900001542182\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439640,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"15瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 769,\n" +
                "        \"defaultImageFileId\": \"8490850\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 9,\n" +
                "        \"name\": \"乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 12.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"乌苏\",\n" +
                "        \"productInfoId\": 145930,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4874552746374778884,\n" +
                "        \"productSpecificationId\": 151112,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"76900151112702\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"国产\",\n" +
                "        \"secondStatisticsClassId\": 4729627943067966101,\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"12瓶/件\",\n" +
                "        \"statisticsClass\": \"啤酒\",\n" +
                "        \"statisticsClassId\": 4729627941671262851,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 772,\n" +
                "        \"defaultImageFileId\": \"9791255\",\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"name\": \"康师傅茉莉蜜茶500ml（1*16）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 16.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"康师傅\",\n" +
                "        \"productInfoId\": 317638,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4912419848918971076,\n" +
                "        \"productSpecificationId\": 328247,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"77200328247796\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439638,\n" +
                "        \"shelfLifeUnit\": 0,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"16瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"cityId\": 723,\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0,\n" +
                "        \"length\": 0,\n" +
                "        \"monthOfShelfLife\": 365,\n" +
                "        \"name\": \"燕京啤酒小度酒U8大滋味8度500ml（1*12）\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 12.000000,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"燕京\",\n" +
                "        \"productInfoId\": 285795,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productSkuId\": 4939565532622387660,\n" +
                "        \"productSpecificationId\": 294058,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"72300294058799\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"国产\",\n" +
                "        \"secondStatisticsClassId\": 4729627943067966101,\n" +
                "        \"shelfLifeUnit\": 3,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"specificationName\": \"12罐/件\",\n" +
                "        \"statisticsClass\": \"啤酒\",\n" +
                "        \"statisticsClassId\": 4729627941671262851,\n" +
                "        \"unitName\": \"罐\",\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"weight\": 0,\n" +
                "        \"width\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"boxCode\": \"6940553360036、6922858211046、6939223900092、6940159410043、6949133700057、6908946284451\",\n" +
                "        \"cityId\": 105,\n" +
                "        \"costPrice\": 4.831722,\n" +
                "        \"defaultImageFileId\": \"16963\",\n" +
                "        \"deliveryFee\": 0.0000,\n" +
                "        \"deliveryPayType\": 0,\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"fleeGoods\": 0,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0.0,\n" +
                "        \"isComplete\": 0,\n" +
                "        \"length\": 0.0,\n" +
                "        \"monthOfShelfLife\": 12,\n" +
                "        \"name\": \"百事可乐2L（1*8）\",\n" +
                "        \"newBoxCode\": \"6940553360036\",\n" +
                "        \"newPackageCode\": \"6940553360036\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageCode\": \"6940553360036、6922858211046\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 8.000000,\n" +
                "        \"pick\": 0,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"百事可乐\",\n" +
                "        \"productFeature\": 1,\n" +
                "        \"productGrade\": 0,\n" +
                "        \"productInfoId\": 2064,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productRelevantState\": 1,\n" +
                "        \"productSkuId\": 10500002067772,\n" +
                "        \"productSpecificationId\": 2067,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"10500002067772\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClassId\": 4729627945517439639,\n" +
                "        \"sellingPrice\": 42.800000,\n" +
                "        \"sellingPriceUnit\": \"件\",\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"sortingFee\": 0.300,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"sow\": 1,\n" +
                "        \"specificationName\": \"8瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"storageType\": 0,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"unpackage\": true,\n" +
                "        \"volume\": \"0*0*0\",\n" +
                "        \"warehouseCustodyFee\": 0.0000,\n" +
                "        \"weight\": 0.0,\n" +
                "        \"width\": 0.0\n" +
                "    },\n" +
                "    {\n" +
                "        \"boxCode\": \"6949930102306\",\n" +
                "        \"cityId\": 105,\n" +
                "        \"costPrice\": 2.002382,\n" +
                "        \"defaultImageFileId\": \"16435\",\n" +
                "        \"deliveryFee\": 0.0000,\n" +
                "        \"deliveryPayType\": 0,\n" +
                "        \"distributionPercent\": 1.00,\n" +
                "        \"distributionPercentForAmount\": 1.00,\n" +
                "        \"fleeGoods\": 0,\n" +
                "        \"hasManyStore\": false,\n" +
                "        \"height\": 0.0,\n" +
                "        \"isComplete\": 0,\n" +
                "        \"length\": 0.0,\n" +
                "        \"monthOfShelfLife\": 12,\n" +
                "        \"name\": \"百事可乐[瓶]500ml（1*24）\",\n" +
                "        \"newBoxCode\": \"6949930102306\",\n" +
                "        \"newPackageCode\": \"6924862100033\",\n" +
                "        \"ownerName\": \"易久批\",\n" +
                "        \"packageCode\": \"6924862100033、6939223900016、6925788302624、6908946288305、6940553360012、6949930102306\",\n" +
                "        \"packageName\": \"件\",\n" +
                "        \"packageQuantity\": 24.000000,\n" +
                "        \"pick\": 0,\n" +
                "        \"process\": 0,\n" +
                "        \"productBrand\": \"百事可乐\",\n" +
                "        \"productFeature\": 1,\n" +
                "        \"productGrade\": 0,\n" +
                "        \"productInfoId\": 1548,\n" +
                "        \"productInfoStatus\": 1,\n" +
                "        \"productRelevantState\": 1,\n" +
                "        \"productSkuId\": 10500001550578,\n" +
                "        \"productSpecificationId\": 1550,\n" +
                "        \"productState\": 2,\n" +
                "        \"refProductSkuId\": \"10500001550849\",\n" +
                "        \"saleModel\": 0,\n" +
                "        \"secondStatisticsClass\": \"碳酸饮料\",\n" +
                "        \"secondStatisticsClassId\": 4729627945517439639,\n" +
                "        \"sellingPrice\": 50.500000,\n" +
                "        \"sellingPriceUnit\": \"件\",\n" +
                "        \"shelfLifeUnit\": 2,\n" +
                "        \"sortingFee\": 0.300,\n" +
                "        \"source\": 0,\n" +
                "        \"sourceName\": \"易久批\",\n" +
                "        \"sow\": 1,\n" +
                "        \"specificationName\": \"24瓶/件\",\n" +
                "        \"statisticsClass\": \"饮料\",\n" +
                "        \"statisticsClassId\": 4729627945492273810,\n" +
                "        \"storageType\": 0,\n" +
                "        \"unitName\": \"瓶\",\n" +
                "        \"unpackage\": true,\n" +
                "        \"volume\": \"0.0*0.0*0.0\",\n" +
                "        \"warehouseCustodyFee\": 0.0000,\n" +
                "        \"weight\": 0.0,\n" +
                "        \"width\": 0.0\n" +
                "    }\n" +
                "]";
        List<ProductSkuDTO> productSkuDTOS = JSON.parseArray(json, ProductSkuDTO.class);
        List<Long> collect = productSkuDTOS.stream().map(it -> it.getProductSkuId()).collect(Collectors.toList());
        System.out.println("skuId" + JSON.toJSONString(collect));
        Map<Long, ProductSkuDTO> map = productSkuDTOS.stream().collect(Collectors.toMap(it -> it.getProductSkuId(), it -> it));
        return map;

    }


}
