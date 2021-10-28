package com.common.generate.javacreate.service.newcheck;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.ErpInventoryCheck;
import com.common.generate.javacreate.test.dto.Inventorycheck;
import com.common.generate.javacreate.test.groupsettle.dto.OrderAllPageDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderItemSecOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import com.common.generate.javacreate.utils.HttpClientUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/14 20:57
 */
public class newCheckServiceDetail {


    private static final String settleOut = "结算出";
    private static final String settleIn = "结算入";

    private static final String otherOut = "其他出";
    private static final String otherIn = "其他入";


    public static void main(String[] args) throws Exception {
        findDetail();
//        getWmsProductOwnerList();
    }


    public static void findDetail() throws Exception {
        Integer inWarehouseId =null ;

        String filePath = "C:\\Users\\Administrator\\Desktop\\团购二级货主修复\\新建文件夹\\拼团货主数据(最新版数据).xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<DataDTO> erpList = ExcelUtils.readExcelToEntity(DataDTO.class, file, "拼团货主数据(最新版数据).xlsx");
        if(inWarehouseId!=null){
            erpList = erpList.stream().filter(it->it.getStorehouseId().equals(inWarehouseId)).collect(Collectors.toList());
        }
        erpList.stream().filter(it->StringUtils.isEmpty(it.getOwnerId())).forEach(it->it.setOwnerId("null"));



        String text = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\团购二级货主修复\\新建文件夹\\wms拼团数据.json");
        List<CompareSettleOrderBillOwnerBO> wmsList = JSON.parseArray(text, CompareSettleOrderBillOwnerBO.class);
        if(inWarehouseId!=null){
            wmsList = wmsList.stream().filter(it->it.getWarehouseId().equals(inWarehouseId)).collect(Collectors.toList());
        }
        wmsList.stream().filter(it->StringUtils.isEmpty(it.getProductOwnerId())).forEach(it->it.setProductOwnerId("null"));

        List<Inventorycheck> inventorychecks = ErpInventoryCheck.findCanOffset();

        List<Integer> warehouseIdList =Arrays.asList(7111,7131,7211 );
        inventorychecks = inventorychecks.stream().filter(it -> warehouseIdList.contains(it.getWarehouseId())).collect(Collectors.toList());

        System.out.println("异常数据："+JSON.toJSONString(inventorychecks));

        List<DetailDTO> result =new ArrayList<>();
        for (Inventorycheck inventorycheck : inventorychecks) {
            DetailDTO detailDTO =new DetailDTO();
            List<DataDTO> erp = erpList.stream().filter(it -> it.getStorehouseId().equals(inventorycheck.getWarehouseId()) && it.getDesc_ProductName().equals(inventorycheck.getProductName())).collect(Collectors.toList());
            List<CompareSettleOrderBillOwnerBO> wms = wmsList.stream().filter(it -> it.getWarehouseId().equals(inventorycheck.getWarehouseId()) && it.getSkuId().equals(inventorycheck.getProductSkuId())).collect(Collectors.toList());
            detailDTO.setSkuId(inventorycheck.getProductSkuId());
            detailDTO.setSkuName(inventorycheck.getProductName());
            detailDTO.setDiffCount(inventorycheck.getDiffTotalCount());
            detailDTO.setOwnerId(String.valueOf(inventorycheck.getSecOwnerId()));
            detailDTO.setOwnerName(inventorycheck.getSecOwnerName());
            detailDTO.setErpList(erp);
            detailDTO.setWmsList(wms);
            result.add(detailDTO);
        }
        System.out.println(JSON.toJSONString(result));
    }


    private static void findError() throws Exception {
        List<CompareSettleOwnerDataBO> findErrorList = new ArrayList<>();
        List<CompareSettleOwnerDataBO> findTrueList = new ArrayList<>();

        Integer inWarehouseId=1591;

        /**erp解析数据*/
        List<CompareSettleOwnerDataBO> erpOwnerDataList = parseErpExcel(inWarehouseId);
        /**wms解析数据*/
        List<CompareSettleOwnerDataBO> wmsOwnerDataList = parseWmsJSON(inWarehouseId);

        /**wms数据根据仓库id、规格id和货主id分组*/
        Map<String, List<CompareSettleOwnerDataBO>> wmsProductMap = wmsOwnerDataList.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getProductSpecId() ));
        Map<String, List<CompareSettleOwnerDataBO>> erpProductMap = erpOwnerDataList.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getProductSpecId() ));

        for (Map.Entry<String, List<CompareSettleOwnerDataBO>> entry : erpProductMap.entrySet()) {
            List<CompareSettleOwnerDataBO> erpList = entry.getValue();
            String key = entry.getKey();
            List<CompareSettleOwnerDataBO> wmsList = wmsProductMap.get(key);

            Map<String, List<CompareSettleOwnerDataBO>> erpOwnerListMap = erpList.stream().collect(Collectors.groupingBy(it -> it.getProductOwnerId()));
            Map<String, List<CompareSettleOwnerDataBO>> wmsOwnerListMap = wmsList.stream().collect(Collectors.groupingBy(it -> it.getProductOwnerId()));


            for (Map.Entry<String, List<CompareSettleOwnerDataBO>> erpOwnerEntry : erpOwnerListMap.entrySet()) {
                String ownerId = erpOwnerEntry.getKey();
                List<CompareSettleOwnerDataBO> wmsOwnerList = wmsOwnerListMap.get(ownerId);
                CompareSettleOwnerDataBO erpOwner = erpOwnerEntry.getValue().get(0);
                if(CollectionUtils.isEmpty(wmsOwnerList)){
//                    // TODO: 2021/5/17 暂时屏蔽,如果二级货主存在异常暂时不处理
//                    findErrorList.add(erpOwner);
                    continue;
                }
                /**比较数量差异*/
                compareCout(wmsOwnerList,erpOwner,findErrorList,findTrueList);
            }
        }
        System.out.println("最终结果" + JSON.toJSONString(findErrorList));

        System.out.println("相同结果" + JSON.toJSONString(findTrueList));

//        Map<String, List<CompareSettleOwnerDataBO>> collect = findErrorList.stream().collect(Collectors.groupingBy(it -> it.getSkuName()));
//        System.out.println("分组:"+JSON.toJSONString(collect));

        filterNotExitsStoreError(findErrorList);
    }


    private static void filterNotExitsStoreError(List<CompareSettleOwnerDataBO> findErrorList ){
        List<Inventorycheck> inventorychecks = ErpInventoryCheck.pageList();
        Set<String> skuNameSet = inventorychecks.stream().map(it -> it.getProductName()).collect(Collectors.toSet());
        ArrayList<String> skuNameList = new ArrayList<>(skuNameSet);
        findErrorList = findErrorList.stream().filter(it -> skuNameList.contains(it.getSkuName())).collect(Collectors.toList());

        Map<String, List<CompareSettleOwnerDataBO>> inventoryMap = findErrorList.stream().collect(Collectors.groupingBy(it -> it.getSkuName()));
        System.out.println("分组:"+JSON.toJSONString(inventoryMap));

        inventoryMap=new HashMap<>();
        Map<String, Inventorycheck> inventorycheckMap = inventorychecks.stream().collect(Collectors.toMap(it -> it.getWarehouseId() + "_" + it.getProductName() + "_" + it.getSecOwnerId(), it -> it));
        Map<String, List<CompareSettleOwnerDataBO>> result =new HashMap<>();
        Map<String, List<CompareSettleOwnerDataBO>> listMap = findErrorList.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getSkuName() + "_" + it.getProductOwnerId()));
        for (Map.Entry<String, List<CompareSettleOwnerDataBO>> entry : listMap.entrySet()) {
            String key = entry.getKey();
            List<CompareSettleOwnerDataBO> values = entry.getValue();
            Inventorycheck inventorycheck = inventorycheckMap.get(key);
            if(inventorycheck==null){
                continue;
            }else {
                inventoryMap.put(entry.getKey(),entry.getValue());
            }
            BigDecimal erpCount = values.get(0).getWarehouseMinUnitTotalCount();
            BigDecimal wmsCount = values.get(1).getWarehouseMinUnitTotalCount();
            BigDecimal diffCount = erpCount.subtract(wmsCount);
            if(inventorycheck.getDiffTotalCount().compareTo(diffCount)==0){
                result.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println("分组2:"+JSON.toJSONString(inventoryMap));
        System.out.println("完全匹配:"+JSON.toJSONString(result));

    }


    /**
     * 比较wms和erp产品二级货主
     * @param wmeOwnerDataBO
     * @param erpOwnerDataBO
     * @param findErrorList
     * @param findTrueList
     */
    private static void compareCout(List<CompareSettleOwnerDataBO> wmsOwnerDataList,CompareSettleOwnerDataBO erpOwnerDataBO,List<CompareSettleOwnerDataBO> findErrorList,List<CompareSettleOwnerDataBO> findTrueList){
        BigDecimal erpSettleDeliverMinUnitTotalCount = erpOwnerDataBO.getSettleDeliverMinUnitTotalCount();
        BigDecimal wmsSettleDeliverMinUnitTotalCount = wmsOwnerDataList.stream().map(it->it.getSettleDeliverMinUnitTotalCount()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal erpSettleStoreMinUnitTotalCount = erpOwnerDataBO.getSettleStoreMinUnitTotalCount();
        BigDecimal wmsSettleStoreMinUnitTotalCount = wmsOwnerDataList.stream().map(it->it.getSettleStoreMinUnitTotalCount()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal erportherDeliverMinUnitTotalCount = erpOwnerDataBO.getOrtherDeliverMinUnitTotalCount();
        BigDecimal wmsortherDeliverMinUnitTotalCount = wmsOwnerDataList.stream().map(it->it.getOrtherDeliverMinUnitTotalCount()).reduce(BigDecimal.ZERO,BigDecimal::add);;
        BigDecimal erportherStoreMinUnitTotalCount = erpOwnerDataBO.getOrtherStoreMinUnitTotalCount();
        BigDecimal wmsortherStoreMinUnitTotalCount =wmsOwnerDataList.stream().map(it->it.getOrtherStoreMinUnitTotalCount()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal erpdeliverMinUnitTotalCount = erpOwnerDataBO.getDeliverMinUnitTotalCount();
        BigDecimal wmsdeliverMinUnitTotalCount = wmsOwnerDataList.stream().map(it->it.getDeliverMinUnitTotalCount()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal erpstoreMinUnitTotalCount = erpOwnerDataBO.getStoreMinUnitTotalCount();
        BigDecimal wmsstoreMinUnitTotalCount =wmsOwnerDataList.stream().map(it->it.getStoreMinUnitTotalCount()).reduce(BigDecimal.ZERO,BigDecimal::add);

        BigDecimal wmsWarehouseMinUnitTotalCount =wmsOwnerDataList.stream().map(it->it.getWarehouseMinUnitTotalCount()).reduce(BigDecimal.ZERO,BigDecimal::add);

        // TODO: 2021/5/17  过滤存在二级货主差异数据
        CompareSettleOwnerDataBO error = wmsOwnerDataList.stream().filter(it -> StringUtils.isNotEmpty(it.getErrorOwnerId())).findFirst().orElse(null);
        if(error!=null){
            return;
        }

        CompareSettleOwnerDataBO wmsOwnerDataBO = wmsOwnerDataList.get(0);
        wmsOwnerDataBO.setSkuName(erpOwnerDataBO.getSkuName());
        wmsOwnerDataBO.setSettleDeliverMinUnitTotalCount(wmsSettleDeliverMinUnitTotalCount);
        wmsOwnerDataBO.setSettleStoreMinUnitTotalCount(wmsSettleStoreMinUnitTotalCount);
        wmsOwnerDataBO.setOrtherDeliverMinUnitTotalCount(wmsortherDeliverMinUnitTotalCount);
        wmsOwnerDataBO.setOrtherStoreMinUnitTotalCount(wmsortherStoreMinUnitTotalCount);
        wmsOwnerDataBO.setDeliverMinUnitTotalCount(wmsdeliverMinUnitTotalCount);
        wmsOwnerDataBO.setStoreMinUnitTotalCount(wmsstoreMinUnitTotalCount);
        wmsOwnerDataBO.setWarehouseMinUnitTotalCount(wmsWarehouseMinUnitTotalCount);
        /**比较结算出入、其他出入单*/
//            if (erpSettleDeliverMinUnitTotalCount.compareTo(wmsSettleDeliverMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0 ||
//                    erpSettleStoreMinUnitTotalCount.compareTo(wmsSettleStoreMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0 ||
//                    erportherDeliverMinUnitTotalCount.compareTo(wmsortherDeliverMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0 ||
//                    erportherStoreMinUnitTotalCount.compareTo(wmsortherStoreMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0 ||
//                    erpdeliverMinUnitTotalCount.compareTo(wmsdeliverMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0 ||
//                    erpstoreMinUnitTotalCount.compareTo(wmsstoreMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0
//            ) {
//                wmeOwnerDataBO.setSkuName(skuName);
//                findErrorList.add(erpOwnerDataBO);
//                findErrorList.add(wmeOwnerDataBO);
//                continue;
//            }
        /**比较总数*/
        if (erpdeliverMinUnitTotalCount.compareTo(wmsdeliverMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0 ||
                erpstoreMinUnitTotalCount.compareTo(wmsstoreMinUnitTotalCount.setScale(6, BigDecimal.ROUND_HALF_UP)) != 0
        ) {
            findErrorList.add(erpOwnerDataBO);
            findErrorList.add(wmsOwnerDataBO);
            return;
        }

        findTrueList.add(erpOwnerDataBO);
        findTrueList.add(wmsOwnerDataBO);
    }


    public static List<CompareSettleOwnerDataBO> parseErpExcel(Integer inWarehouseId) throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\团购二级货主修复\\新建文件夹\\拼团货主数据(最新版数据).xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<DataDTO> list = ExcelUtils.readExcelToEntity(DataDTO.class, file, "拼团货主数据(最新版数据).xlsx");
        if(inWarehouseId!=null){
            list = list.stream().filter(it->it.getStorehouseId().equals(inWarehouseId)).collect(Collectors.toList());
        }
        list.stream().filter(it->StringUtils.isEmpty(it.getOwnerId())).forEach(it->it.setOwnerId("null"));

        List<CompareSettleOwnerDataBO> result = new ArrayList<>();
        Map<String, Long> ownerMap = getOwnerMap();
        Map<String, List<DataDTO>> groupList = list.stream().collect(Collectors.groupingBy(it -> it.getSpecid() + "_" + it.getOwnerId()));
        for (List<DataDTO> datas : groupList.values()) {
            DataDTO dataDTO = datas.get(0);
            // 仓库ID
            Integer warehouseId = dataDTO.getStorehouseId();
            // 规格ID
            Long productSpecId = dataDTO.getSpecid();
            // 货主ID
            Long productOwnerId = null;
            if (dataDTO.getOwnerId() != null && !"".equals(dataDTO.getOwnerId())) {
                productOwnerId = ownerMap.get(dataDTO.getOwnerId());
            }
            // 产品名称
            String skuName = dataDTO.getDesc_ProductName();

            CompareSettleOwnerDataBO ownerDataBO = new CompareSettleOwnerDataBO();
            ownerDataBO.setType(1);
            ownerDataBO.setProductSpecId(dataDTO.getSpecid());
            ownerDataBO.setWarehouseId(warehouseId);
            ownerDataBO.setProductSpecId(productSpecId);
            ownerDataBO.setProductOwnerId(String.valueOf(productOwnerId));
            ownerDataBO.setSkuName(skuName);
            List<DataDTO> settleOutList = datas.stream().filter(it -> settleOut.equals(it.getType())).collect(Collectors.toList());
            List<DataDTO> settleInList = datas.stream().filter(it -> settleIn.equals(it.getType())).collect(Collectors.toList());
            List<DataDTO> otherOutList = datas.stream().filter(it -> otherOut.equals(it.getType())).collect(Collectors.toList());
            List<DataDTO> otherInList = datas.stream().filter(it -> otherIn.equals(it.getType())).collect(Collectors.toList());

            // 1 结算出
            if (CollectionUtils.isNotEmpty(settleOutList)) {
                BigDecimal totalCount = settleOutList.stream().map(DataDTO::getTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 出库数量
                ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(totalCount));
                // 结算出库数量
                ownerDataBO.setSettleDeliverMinUnitTotalCount(ownerDataBO.getSettleDeliverMinUnitTotalCount().add(totalCount));
            }

            // 2 结算入
            if (CollectionUtils.isNotEmpty(settleInList)) {
                BigDecimal totalCount = settleInList.stream().map(DataDTO::getTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 入库数量
                ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(totalCount));
                // 结算入库数量
                ownerDataBO.setSettleStoreMinUnitTotalCount(ownerDataBO.getSettleStoreMinUnitTotalCount().add(totalCount));
            }

            // 3 其它出
            if (CollectionUtils.isNotEmpty(otherOutList)) {
                BigDecimal totalCount = otherOutList.stream().map(DataDTO::getTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 出库数量
                ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(totalCount));
                // 其它出库数量
                ownerDataBO.setOrtherDeliverMinUnitTotalCount(ownerDataBO.getOrtherDeliverMinUnitTotalCount().add(totalCount));
            }

            // 4 其它入
            if (CollectionUtils.isNotEmpty(otherInList)) {
                BigDecimal totalCount = otherInList.stream().map(DataDTO::getTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 入库数量
                ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(totalCount));
                // 其它入库数量
                ownerDataBO.setOrtherStoreMinUnitTotalCount(ownerDataBO.getOrtherStoreMinUnitTotalCount().add(totalCount));
            }

            // 库存数量
            ownerDataBO.setWarehouseMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().subtract(ownerDataBO.getStoreMinUnitTotalCount()));
            result.add(ownerDataBO);
        }
        return result;
    }


    private static List<CompareSettleOwnerDataBO> parseWmsJSON(Integer inWarehouseId) {
        String text = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\团购二级货主修复\\新建文件夹\\wms拼团数据.json");
        List<CompareSettleOrderBillOwnerBO> wmsList = JSON.parseArray(text, CompareSettleOrderBillOwnerBO.class);
        if(inWarehouseId!=null){
            wmsList = wmsList.stream().filter(it->it.getWarehouseId().equals(inWarehouseId)).collect(Collectors.toList());
        }

        wmsList.stream().filter(it->StringUtils.isEmpty(it.getProductOwnerId())).forEach(it->it.setProductOwnerId("null"));

        Map<String, List<CompareSettleOrderBillOwnerBO>> groupList = wmsList.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getProductSpecId() + "_" + it.getProductOwnerId()));
        Map<Integer, Integer> warehouseMap = wmsList.stream().collect(Collectors.toMap(it -> it.getWarehouseId(), it -> it.getWarehouseId(), (v1, v2) -> v1));

        Map<Long, Set<String>> ownerMap = new HashMap<>();
        for (Integer warehouseId : warehouseMap.keySet()) {
            String orgId = warehouseId.toString().substring(0, 3);
            Map<Long, Set<String>> stringMap = listSaleOrderOwner(Integer.valueOf(orgId), warehouseId);
            if (stringMap != null && stringMap.size() != 0) {
                ownerMap.putAll(stringMap);
            }
        }

        List<CompareSettleOwnerDataBO> result = new ArrayList<>();

        for (List<CompareSettleOrderBillOwnerBO> datas : groupList.values()) {
            CompareSettleOrderBillOwnerBO dataDTO = datas.get(0);
            // 仓库ID
            Integer warehouseId = dataDTO.getWarehouseId();
            // 规格ID
            Long productSpecId = dataDTO.getProductSpecId();
            // 货主ID,转换为可能正确货主id
            String productOwnerId = dataDTO.getProductOwnerId();

            Set<String> mayOwnerId = ownerMap.get(dataDTO.getSkuId());
            List<String> suggestOwnIdlist = new ArrayList<>();
            if(CollectionUtils.isNotEmpty(mayOwnerId)){
                suggestOwnIdlist.addAll(mayOwnerId);
            }

            /**产品skuId*/
            Long skuId = dataDTO.getSkuId();

            CompareSettleOwnerDataBO ownerDataBO = new CompareSettleOwnerDataBO();
            ownerDataBO.setType(2);
            ownerDataBO.setProductSpecId(dataDTO.getProductSpecId());
            ownerDataBO.setWarehouseId(warehouseId);
            ownerDataBO.setProductSpecId(productSpecId);
            ownerDataBO.setSkuId(skuId);

            ownerDataBO.setProductOwnerId(String.valueOf(productOwnerId));

            /**存在异常产品*/
            if (CollectionUtils.isNotEmpty(suggestOwnIdlist) && !suggestOwnIdlist.contains(String.valueOf(productOwnerId))) {
                ownerDataBO.setSuggestOwnerIds(JSON.toJSONString(suggestOwnIdlist));
                ownerDataBO.setErrorOwnerId(productOwnerId);
                ownerDataBO.setProductOwnerId(suggestOwnIdlist.get(0));
                // TODO: 2021/5/17  暂时不处理
//                continue;
            }

            List<Byte> settleOutBytes = Arrays.asList((byte) 1, (byte) 3);
            List<Byte> settleInBytes = Arrays.asList((byte) 2, (byte) 4);
            List<Byte> otherOutBytes = Arrays.asList((byte) 5, (byte) 11);
            List<Byte> otherInBytes = Arrays.asList((byte) 8);

            List<CompareSettleOrderBillOwnerBO> settleOutList = datas.stream().filter(it -> settleOutBytes.contains(it.getOrderType())).collect(Collectors.toList());
            List<CompareSettleOrderBillOwnerBO> settleInList = datas.stream().filter(it -> settleInBytes.contains(it.getOrderType())).collect(Collectors.toList());
            List<CompareSettleOrderBillOwnerBO> otherOutList = datas.stream().filter(it -> otherOutBytes.contains(it.getOrderType())).collect(Collectors.toList());
            List<CompareSettleOrderBillOwnerBO> otherInList = datas.stream().filter(it -> otherInBytes.contains(it.getOrderType())).collect(Collectors.toList());

            // 1 结算出
            if (CollectionUtils.isNotEmpty(settleOutList)) {
                BigDecimal totalCount = settleOutList.stream().filter(it -> it.getMinUnitTotalCount() != null).map(CompareSettleOrderBillOwnerBO::getMinUnitTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 出库数量
                ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(totalCount));
                // 结算出库数量
                ownerDataBO.setSettleDeliverMinUnitTotalCount(ownerDataBO.getSettleDeliverMinUnitTotalCount().add(totalCount));
            }

            // 2 结算入
            if (CollectionUtils.isNotEmpty(settleInList)) {
                BigDecimal totalCount = settleInList.stream().filter(it -> it.getMinUnitTotalCount() != null).map(CompareSettleOrderBillOwnerBO::getMinUnitTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 入库数量
                ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(totalCount));
                // 结算入库数量
                ownerDataBO.setSettleStoreMinUnitTotalCount(ownerDataBO.getSettleStoreMinUnitTotalCount().add(totalCount));
            }

            // 3 其它出
            if (CollectionUtils.isNotEmpty(otherOutList)) {
                BigDecimal totalCount = otherOutList.stream().filter(it -> it.getMinUnitTotalCount() != null).map(CompareSettleOrderBillOwnerBO::getMinUnitTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 出库数量
                ownerDataBO.setDeliverMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().add(totalCount));
                // 其它出库数量
                ownerDataBO.setOrtherDeliverMinUnitTotalCount(ownerDataBO.getOrtherDeliverMinUnitTotalCount().add(totalCount));
            }

            // 4 其它入
            if (CollectionUtils.isNotEmpty(otherInList)) {
                BigDecimal totalCount = otherInList.stream().filter(it -> it.getMinUnitTotalCount() != null).map(CompareSettleOrderBillOwnerBO::getMinUnitTotalCount).reduce(BigDecimal.ZERO, BigDecimal::add);
                // 入库数量
                ownerDataBO.setStoreMinUnitTotalCount(ownerDataBO.getStoreMinUnitTotalCount().add(totalCount));
                // 其它入库数量
                ownerDataBO.setOrtherStoreMinUnitTotalCount(ownerDataBO.getOrtherStoreMinUnitTotalCount().add(totalCount));
            }

            // 库存数量
            ownerDataBO.setWarehouseMinUnitTotalCount(ownerDataBO.getDeliverMinUnitTotalCount().subtract(ownerDataBO.getStoreMinUnitTotalCount()));
            result.add(ownerDataBO);
        }
        return result;
    }

    private static Map<String, Long> getOwnerMap() {
        Map<String, Long> ownerMap = ParseDataServiceTest.getOwnerMap("C:\\Users\\Administrator\\Desktop\\团购二级货主修复\\新建文件夹\\owner.txt");
        return ownerMap;
    }


    /**
     * 获取wms产品
     */
    private static void getWmsProductOwnerList() {
        List<String> warehouseIds = Arrays.asList("1191", "1591", "1031", "1181",
                "1681", "1051", "4051", "4031", "4731", "4651", "4001", "4061", "4571",
                "4211", "4021", "4121", "4191", "4041", "4221", "7001", "7131", "7231", "7111", "7041");
        for (String warehouseId : warehouseIds) {
            String url = "http://wms.pre.yijiupi.com/supplyChain/groupsettle/hisDataWriteOff?startDate=" + warehouseId + "&channelNo=1119";
            String s = HttpClientUtils.doPostWithToken(BaseUtils.token, url, "{}");
            System.out.println(s);
        }
    }


    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public static Map<Long, Set<String>> listSaleOrderOwner(Integer orgId, Integer warehouseId) {
        String url = "/order/listGroupSettleOrder";
        Map<Long, Set<String>> result = new HashMap<>();

        List<String> companyCodeList = Arrays.asList("DDMC", "MTYX");
        System.out.println("订单获取" + url);
        String body = "{\"pageSize\":100,\"orgId\":" + orgId + ",\"warehouseIds\":[" + warehouseId + "],\"orderCreateTimeStart\":\"2021-04-15 00:00:00\",\"orderCreateTimeEnd\":\"2021-05-17 23:59:59\",\"orderSource\":\"111\",\"currentPage\":1,\"orderTypes\":[119,74]}";
        String dataList = BaseUtils.pageList(url, body);
        List<OrderAllPageDTO> orderAllPageDTOS = JSON.parseArray(dataList, OrderAllPageDTO.class);
        if(CollectionUtils.isEmpty(orderAllPageDTOS)){
            return result;
        }
        orderAllPageDTOS = orderAllPageDTOS.stream().filter(it -> StringUtils.isNotEmpty(it.getCompanyCode()) && companyCodeList.contains(it.getCompanyCode())).collect(Collectors.toList());
        List<Long> orderIds = orderAllPageDTOS.stream().map(it -> Long.valueOf(it.getOrderId())).collect(Collectors.toList());
        List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = selectOrderItemOwnerByOrderIds(orderIds);
        Map<Long, List<SettleOrderItemSecOwnerDTO>> secMap = secOwnerDTOS.stream().collect(Collectors.groupingBy(it -> it.getProductSkuId()));
        for (Map.Entry<Long, List<SettleOrderItemSecOwnerDTO>> entry : secMap.entrySet()) {
            List<SettleOrderItemSecOwnerDTO> owners = entry.getValue();
            Set<String> secOwnerIdSet = owners.stream().map(it -> String.valueOf(it.getSecOwnerId())).collect(Collectors.toSet());
            result.put(entry.getKey(), secOwnerIdSet);
        }
        return result;
    }

    /**
     * 根据订单id获取二级货主数据
     *
     * @param orderIds
     * @return
     */
    public static List<SettleOrderItemSecOwnerDTO> selectOrderItemOwnerByOrderIds(List<Long> orderIds) {
        String url = "/groupsettle/selectOrderItemOwnerByOrderIds";
        String dataList = BaseUtils.list(url, JSON.toJSONString(orderIds));
        List<SettleOrderItemSecOwnerDTO> secOwnerDTOS = JSON.parseArray(dataList, SettleOrderItemSecOwnerDTO.class);
        return secOwnerDTOS;
    }






}
