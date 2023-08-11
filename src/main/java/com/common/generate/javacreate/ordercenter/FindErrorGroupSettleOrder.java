package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.GroupOtherOrderCreateDTO;
import com.common.generate.javacreate.ordercenter.dto.GroupOtherOrderItemCreateDTO;
import com.common.generate.javacreate.ordercenter.dto.GroupOtherOrderItemDetailDTO;
import com.common.generate.javacreate.ordercenter.dto.GroupSettleCompareDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author xialei
 * @date 2023/2/28 15:01
 */
public class FindErrorGroupSettleOrder {

    private static Pattern pattern = Pattern.compile("[^0-9]+");


    private static Pattern pattern2 = Pattern.compile("/[(.+?)]/g");


    public static void main(String[] args) {
        getOtherOrder();
//        findGroupSettleOrder();
//        List<Long> list= Arrays.asList(1646010362321101363L,1646010362321101363L,1646010362321101363L,1643330262662109977L,1643330262662109977L,1643330262662109977L,1618999002612100001L,1643330262662109977L,1648699192711100357L, 1648864165697100388L, 1648695710576100354L,1631457772131100279L,1643330262662109977L,1643330262662109977L,1643330262662109977L,1677479537104100414L, 1677479987775100535L, 1677479987775100534L,1618999002612100001L,1677383251673100080L, 1666229151616100003L,1643330262662109977L,1643330262662109977L,1643330262662109977L,1677479537104100414L, 1677479987775100535L, 1677479987775100534L,1622523866675100793L,1618999002612100001L,1643330262662109977L,1643330262662109977L,1643330262662109977L,1618999002612100001L,1677550036436100085L,1618999002612100001L,1677121712477100040L,1631182008583125398L,1643330262662109977L,1677550036436100085L,1631182008583125398L,1643330262662109977L,1643330262662109977L,1646010362321101363L,1631182008583125398L,1643330262662109977L,1643330262662109977L,1643330262662109977L,1677121712477100040L,1643330262662109977L,1643330262662109977L,1618999002612100001L,1628260203268100146L,1646010362321101363L,1618999002612100001L,1643330313844109787L, 1643330262662109977L,1623392163559108334L,1643330262662109977L,1643330262662109977L,1643330262662109977L,1677550036436100085L,1643330262662109977L,1618999002612100001L,1643330262662109977L);
//        Set<Long> set = new HashSet<>(list);
//        System.out.println(set);

        //        parseIfElse2Swith(getData());
//        groupSettleOrder();

//        String inputStr = "TMS已发货未完成的数量[[1646010362321101363]]=19200.000000，TMS已发货未完成的数量[[11111]]=19200.000000,TMS已发货未完成的数量[2222]=19200.000000";
//        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
//        Pattern pattern = Pattern.compile("\\[\\[(.*?)\\]\\]|\\[(.*?)\\]");
//        Pattern pattern = Pattern.compile("(.*?)(\\[\\[|\\[)(.*?)(\\]\\]|\\])");
//
//        Matcher matcher = pattern.matcher(inputStr);
//        while (matcher.find()){
////            System.out.println(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
//            System.out.println( matcher.group(3) + matcher.group(4));
//
//        }

    }


    public static void findGroupSettleOrder() {
        List<GroupSettleCompareDTO> groupSettleOrder = getGroupSettleOrder();
        Map<Long, String> resultMap = new HashMap<>();
        List<Integer> checkWarehouseIds = Arrays.asList(1191, 7111, 7131, 1591);

        for (GroupSettleCompareDTO groupSettleCompareDTO : groupSettleOrder) {
            Long productSkuId = groupSettleCompareDTO.getProductSkuId();
            if (productSkuId == null) {
                continue;
            }
//            if (!checkWarehouseIds.contains(groupSettleCompareDTO.getWarehouse_Id())) {
//                continue;
//            }

            String result = resultMap.get(productSkuId);
            if (StringUtils.isEmpty(result)) {
                result = fixWmsErpInventoryCheck(groupSettleCompareDTO.getOrgId(), groupSettleCompareDTO.getWarehouseId(), groupSettleCompareDTO.getProductSkuId());
            }
            String parseGroupSettle = getParseGroupSettle(groupSettleCompareDTO, result);
            FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\团购异常数据.txt", groupSettleCompareDTO + "," + parseGroupSettle + "\n");
        }
    }

    private static String getParseGroupSettle(GroupSettleCompareDTO groupSettleCompareDTO, String result) {
        if (StringUtils.isEmpty(result)) {
            return "";
        }
        String[] split = result.split("\",");
        for (String str : split) {
            if (str.contains(groupSettleCompareDTO.getSecOwnerId().toString())) {
                return str;
            }
        }
        return "";
    }


    private static String getParseGroupSettleTMS(GroupSettleCompareDTO groupSettleCompareDTO, String result) {
        String[] split = result.split("\",");
        for (String str : split) {
            if (str.contains(groupSettleCompareDTO.getSecOwnerId().toString())) {
                String[] split2 = str.split("\\|");
                for (String s : split2) {
                    if (s.contains("TMS已发货未完成的数量")) {
                        return s;
                    }
                }
            }
        }
        return "";
    }

    @SneakyThrows
    private static List<GroupSettleCompareDTO> getGroupSettleOrder() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\荆州团购异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<GroupSettleCompareDTO> list = ExcelUtils.readExcelToEntity(GroupSettleCompareDTO.class, file, "荆州团购异常.xlsx");
        return list;
    }


    public static String fixWmsErpInventoryCheck(Integer orgId, Integer warehouseId, Long skuId) {
        String params = "{\n" + "  \"repairInventoryParamDTO\": {\n" + "    \"cityId\":" + orgId + ",\n" + "    \"warehouseId\": " + warehouseId + ",\n" + "    \"skuIdList\": [" + skuId + "]\n" + "  }\n" + "}";
        String url = "http://openapi.pre.yijiupi.com/openapi/oms/update/fixWmsErpInventoryCheck";
        String resultstr = HttpClientUtils.doPost(url, params);
        System.out.println(resultstr);
        return resultstr;
    }

    public static void parseIfElse2Swith(String json) {
        String[] split = json.split("\n");
        List<Integer> keyList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.contains("State")) {
                String trim = pattern.matcher(s).replaceAll("").trim();
                keyList.add(Integer.valueOf(trim));
            } else if (s.contains("return")) {
                String aReturn = s.replace("return", "").trim();
                valueList.add(aReturn);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("switch (omsState){");
        for (int i = 0; i < keyList.size(); i++) {
            Integer key = keyList.get(i);
            String value = valueList.get(i);
            stringBuilder.append("case ").append(key).append(":").append(" return ").append(value);
        }
        stringBuilder.append("default:");
        stringBuilder.append("}");
        System.out.println(stringBuilder.toString());
    }


    public static String getData() {
        return "if (orderCenterState == 200) {\n" + "            return OMS_STATE_ORDER;\n" + "        }\n" + "        if (orderCenterState == 202) {\n" + "            return OMS_STATE_WAITDELIVERY;\n" + "        }\n" + "        if (orderCenterState == 203) {\n" + "            return OMS_STATE_AUDITOK;\n" + "        }\n" + "        if (orderCenterState == 205) {\n" + "            return OMS_STATE_WAITDELIVERY;\n" + "        }\n" + "        if (orderCenterState == 206) {\n" + "            return OMS_STATE_WAITDELIVERY;\n" + "        }\n" + "        if (orderCenterState == 208) {\n" + "            return OMS_STATE_ORDER;\n" + "        }\n" + "        if (orderCenterState == 209) {\n" + "            return OMS_STATE_ORDER;\n" + "        }\n" + "        if (orderCenterState == 302) {\n" + "            return OMS_STATE_DELIVERYFAILED;\n" + "        }\n" + "        if (orderCenterState == 304) {\n" + "            return OMS_STATE_CANCEL;\n" + "        }\n" + "        if (orderCenterState == 305) {\n" + "            return OMS_STATE_CANCEL;\n" + "        }\n" + "        if (orderCenterState == 400) {\n" + "            return OMS_STATE_OUTSTOCK;\n" + "        }\n" + "        if (orderCenterState == 401) {\n" + "            return OMS_STATE_SHIPPED;\n" + "        }\n" + "        if (orderCenterState == 502) {\n" + "            return OMS_STATE_WAITSETTLEMENT;\n" + "        }\n" + "        if (orderCenterState == 504) {\n" + "            return OMS_STATE_COMPELETE;\n" + "        }\n" + "        if (orderCenterState == 700) {\n" + "            return OMS_STATE_COMPELETE;\n" + "        }\n" + "        if (orderCenterState == 220) {\n" + "            return OMS_STATE_DELAY;\n" + "        }\n" + "        if (orderCenterState == 201) {\n" + "            return OMS_STATE_WAITPAY;\n" + "        }\n" + "        if (orderCenterState == 402) {\n" + "            return OMS_STATE_SHIPPED;\n" + "        }";
    }


    @SneakyThrows
    public static void getOtherOrder() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\荆州团购异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<GroupOtherOrderDTO> list = ExcelUtils.readExcelToEntity(GroupOtherOrderDTO.class, file, "荆州团购异常.16.xlsx");


        List<GroupSettleOrderBillInsertDTO>  settleOrderBillList = new ArrayList<>();

        List<GroupOtherOrderCreateDTO> createList = new ArrayList<>();
        for (GroupOtherOrderDTO groupOtherOrderDTO : list) {
            if(!ObjectUtils.nullSafeEquals(groupOtherOrderDTO.getNeedFix(),0)) {
                continue;
            }
//            if (groupOtherOrderDTO.getOutStockCount() != null) {
//                createList.add(convertOtherInOut(groupOtherOrderDTO, 1));
//                settleOrderBillList.add(buildSettleOrderBill(groupOtherOrderDTO, 1));
//            }
            if (groupOtherOrderDTO.getInStockCount() != null) {
                createList.add(convertOtherInOut(groupOtherOrderDTO, 2));
                settleOrderBillList.add(buildSettleOrderBill(groupOtherOrderDTO, 2));

            }
        }

//        System.out.println("其他出入:"+JSON.toJSON(createList));
        System.out.println("账单明细:"+JSON.toJSON(settleOrderBillList));

    }

    private static GroupSettleOrderBillInsertDTO buildSettleOrderBill(GroupOtherOrderDTO dto, Integer type){
        GroupSettleOrderBillInsertDTO groupSettleOrderBillInsertDTO = new GroupSettleOrderBillInsertDTO();
        /**出*/
        if (type == 1) {
            groupSettleOrderBillInsertDTO.setOrgId(dto.getOrgId());
            groupSettleOrderBillInsertDTO.setSettleOrderId(dto.getSettleOrderId());
            groupSettleOrderBillInsertDTO.setBusinessNo(dto.getBusinessNo());
            groupSettleOrderBillInsertDTO.setOrderId(dto.getOrderId());
            groupSettleOrderBillInsertDTO.setOrderItemId(dto.getOrderItemId());
            groupSettleOrderBillInsertDTO.setOrderType("11");
            groupSettleOrderBillInsertDTO.setSkuId(dto.getProductSkuId());
            groupSettleOrderBillInsertDTO.setSkuName(dto.getProductName());
            groupSettleOrderBillInsertDTO.setProductSaleSpec(dto.getProductSaleSpec());
            groupSettleOrderBillInsertDTO.setSaleSpecQuantity(dto.getSaleSpecQuantity());
            groupSettleOrderBillInsertDTO.setSellUnit(dto.getSellUnit());
            groupSettleOrderBillInsertDTO.setOrderPrice("0");
            groupSettleOrderBillInsertDTO.setOrderAmount("0");
            groupSettleOrderBillInsertDTO.setOriginalMinUnitTotalCount(dto.getOutStockCount().toString());
            groupSettleOrderBillInsertDTO.setMinUnitTotalCount(dto.getOutStockCount().toString());
            groupSettleOrderBillInsertDTO.setSettleMinUnitTotalCount(dto.getOutStockCount().toString());
            groupSettleOrderBillInsertDTO.setProductOwnerId(dto.getProductOwnerId());
            groupSettleOrderBillInsertDTO.setProductSpecId(dto.getProductSpecId());
        }else {
            groupSettleOrderBillInsertDTO.setOrgId(dto.getOrgId());
            groupSettleOrderBillInsertDTO.setSettleOrderId(dto.getSettleOrderId());
            groupSettleOrderBillInsertDTO.setBusinessNo(dto.getInBusinessNo());
            groupSettleOrderBillInsertDTO.setOrderId(dto.getInOrderId());
            groupSettleOrderBillInsertDTO.setOrderItemId(dto.getInOrderItemId());
            groupSettleOrderBillInsertDTO.setOrderType("8");
            groupSettleOrderBillInsertDTO.setSkuId(dto.getProductSkuId());
            groupSettleOrderBillInsertDTO.setSkuName(dto.getProductName());
            groupSettleOrderBillInsertDTO.setProductSaleSpec(dto.getProductSaleSpec());
            groupSettleOrderBillInsertDTO.setSaleSpecQuantity(dto.getSaleSpecQuantity());
            groupSettleOrderBillInsertDTO.setSellUnit(dto.getSellUnit());
            groupSettleOrderBillInsertDTO.setOrderPrice("0");
            groupSettleOrderBillInsertDTO.setOrderAmount("0");
            groupSettleOrderBillInsertDTO.setOriginalMinUnitTotalCount(dto.getInStockCount().toString());
            groupSettleOrderBillInsertDTO.setMinUnitTotalCount(dto.getInStockCount().toString());
            groupSettleOrderBillInsertDTO.setSettleMinUnitTotalCount(dto.getInStockCount().toString());
            groupSettleOrderBillInsertDTO.setProductOwnerId(dto.getProductOwnerId());
            groupSettleOrderBillInsertDTO.setProductSpecId(dto.getProductSpecId());
        }
        return groupSettleOrderBillInsertDTO;
    }


    private static GroupOtherOrderCreateDTO convertOtherInOut(GroupOtherOrderDTO dto, Integer type) {
        GroupOtherOrderCreateDTO createDTO = new GroupOtherOrderCreateDTO();
        /**出*/
        if (type == 1) {
            createDTO.setOrderType("64");
            createDTO.setChannelNo("111");
            createDTO.setOrderAmount(BigDecimal.ZERO.toString());
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(dto.getOrgId());

            GroupOtherOrderItemCreateDTO itemCreateDTO = new GroupOtherOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getProductSkuId());
            itemCreateDTO.setProductName(dto.getProductName());
            itemCreateDTO.setMinUnitTotalCount(dto.getOutStockCount().toString());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO.toString());

            GroupOtherOrderItemDetailDTO itemDetailDTO = new GroupOtherOrderItemDetailDTO();
            itemDetailDTO.setSecOwnerId(dto.getSecOwnerId());
            itemDetailDTO.setUnitTotalCount(dto.getOutStockCount().toString());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        } else {
            /**入*/
            createDTO.setOrderType("89");
            createDTO.setChannelNo("111");
            createDTO.setOrderAmount(BigDecimal.ZERO.toString());
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(dto.getOrgId());
            GroupOtherOrderItemCreateDTO itemCreateDTO = new GroupOtherOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getProductSkuId());
            itemCreateDTO.setProductName(dto.getProductName());
            itemCreateDTO.setMinUnitTotalCount(dto.getInStockCount().toString());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO.toString());

            GroupOtherOrderItemDetailDTO itemDetailDTO = new GroupOtherOrderItemDetailDTO();
            itemDetailDTO.setSecOwnerId(dto.getSecOwnerId());
            itemDetailDTO.setUnitTotalCount(dto.getInStockCount().toString());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        }
        return createDTO;
    }

}