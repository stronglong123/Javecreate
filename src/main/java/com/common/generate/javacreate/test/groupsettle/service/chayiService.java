package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.groupsettle.dto.CommOrderDTO;
import com.common.generate.javacreate.test.groupsettle.dto.CommOrderItemDTO;
import com.common.generate.javacreate.test.groupsettle.dto.CommOrderItemDetailDTO;
import com.common.generate.javacreate.test.groupsettle.dto.ErpProductOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderQueryDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OutStockApplyDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OutStockItemApplyDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.DateUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/1 19:50
 */
public class chayiService {

    public static void main(String[] args) {
        getErpProductOwner();
    }




    public static List<ErpProductOwnerDTO> getChayiOrderByWarehouseId(Integer orgId,Integer warehouseId){
        /**获取差异单*/
        List<ErpProductOwnerDTO> chayiErpList =new ArrayList<>();

        List<OutStockApplyDTO> allChayiChu =new ArrayList<>();
        List<GroupSettleOrderQueryDTO> grouplist = finderrorbygroubill.grouplist(warehouseId);
        for (GroupSettleOrderQueryDTO dto : grouplist) {
            List<OutStockApplyDTO> chayuChu = finderrorbygroubill.getChayuChu(dto.getSettleNo(), orgId, warehouseId, null);
            allChayiChu.addAll(chayuChu);
        }

        List<OutStockItemApplyDTO> itemApplyDTOS = allChayiChu.stream().flatMap(it -> it.getOutStockItemApplyDTOS().stream()).collect(Collectors.toList());
        Map<String, List<OutStockItemApplyDTO>> chayiMap = itemApplyDTOS.stream().collect(Collectors.groupingBy(it -> it.getProductSkuId() + "_" + it.getSecOwnerId()));
        for (List<OutStockItemApplyDTO> value : chayiMap.values()) {
            OutStockItemApplyDTO outStockItemApplyDTO = value.get(0);
            BigDecimal addCount = value.stream().map(it -> it.getUnitTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            ErpProductOwnerDTO erpProductOwnerDTO = new ErpProductOwnerDTO();
            erpProductOwnerDTO.setOrderType(81);
            erpProductOwnerDTO.setUnitTotalCount(addCount);
            erpProductOwnerDTO.setErrorWmsOwnerId(outStockItemApplyDTO.getSecOwnerId());
            erpProductOwnerDTO.setProductSkuId(outStockItemApplyDTO.getProductSkuId());
            erpProductOwnerDTO.setProductName(outStockItemApplyDTO.getProductName());
            erpProductOwnerDTO.setWarehouseId(warehouseId);
            erpProductOwnerDTO.setOrgId(orgId);
            erpProductOwnerDTO.setSpecId(outStockItemApplyDTO.getProductSpecificationId());
            chayiErpList.add(erpProductOwnerDTO);
        }

        return chayiErpList;
    }


    /**
     * 获取差异单
     * @return
     */
    public static List<ErpProductOwnerDTO> getErpProductOwner() {
        List<CommOrderDTO> otherOrder = getOtherOrder();
        Map<Integer, List<String>> map = new HashMap<>();
        Map<Integer, List<CommOrderDTO>> orderMap = otherOrder.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId()));
        for (Map.Entry<Integer, List<CommOrderDTO>> entry : orderMap.entrySet()) {
            List<CommOrderDTO> list = entry.getValue();
            map.put(entry.getKey(), list.stream().map(CommOrderDTO::getRelatedOrderNo).collect(Collectors.toList()));
        }

        Set<Long> skuIds = otherOrder.stream().filter(it -> CollectionUtils.isNotEmpty(it.getCommOrderItemDTOS())).flatMap(it -> it.getCommOrderItemDTOS().stream()).filter(it -> it.getSkuId() != null).map(it -> it.getSkuId()).collect(Collectors.toSet());

        Set<String> secOwnerIds = otherOrder.stream().filter(it -> CollectionUtils.isNotEmpty(it.getCommOrderItemDTOS())).flatMap(it -> it.getCommOrderItemDTOS().stream()).filter(it -> CollectionUtils.isNotEmpty(it.getCommOrderItemDetailDTOS())).flatMap(it -> it.getCommOrderItemDetailDTOS().stream()).map(it -> String.valueOf(it.getSecOwnerId())).collect(Collectors.toSet());

        System.out.println("所有产品：" + JSON.toJSONString(skuIds));
        System.out.println("所有二级货主：" + JSON.toJSONString(secOwnerIds));

        List<ErpProductOwnerDTO> result =new ArrayList<>();
        Map<String, String> ownerMap = BaseUtils.getErpOwner();
        Map<Long, ErpProductOwnerDTO> skuMap = getSkuMap();

        for (List<CommOrderDTO> orders : orderMap.values()) {

            for (CommOrderDTO order : orders) {

                for (CommOrderItemDTO item : order.getCommOrderItemDTOS()) {
                    ErpProductOwnerDTO product = skuMap.get(item.getSkuId());
                    for (CommOrderItemDetailDTO itemDetailDTO : item.getCommOrderItemDetailDTOS()) {
                        ErpProductOwnerDTO productOwnerDTO =new ErpProductOwnerDTO();
                        String orgId = String.valueOf(order.getWarehouseId()).substring(0, 3);
                        productOwnerDTO.setOrgId(Integer.valueOf(orgId));
                        productOwnerDTO.setWarehouseId(order.getWarehouseId());
                        productOwnerDTO.setOrderNo(order.getRelatedOrderNo());
                        productOwnerDTO.setProductSkuId(item.getSkuId());
                        productOwnerDTO.setErrorWmsOwnerId(itemDetailDTO.getSecOwnerId());
                        productOwnerDTO.setErrorErpOwnerId(ownerMap.get(String.valueOf(itemDetailDTO.getSecOwnerId())));
                        productOwnerDTO.setProductName(product.getProductName());
                        productOwnerDTO.setSpecId(product.getSpecId());
                        productOwnerDTO.setDate(order.getSaleTimeStr());
                        productOwnerDTO.setUnitTotalCount(itemDetailDTO.getUnitTotalCount());
                        result.add(productOwnerDTO);
                    }
                }
            }
        }
        System.out.println(JSON.toJSONString(result));
        return result;
    }


    /***
     * 差异单数据
     * @return
     */
    public static List<CommOrderDTO> getOtherOrder() {
//        String text = FileUtil.readFileByChars("C:\\Users\\Administrator\\Desktop\\差异单.json");

        String text ="[\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800005831135\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239576307,\n" +
                "                        \"unitTotalCount\": 46.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800001550060\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"何宛玲\",\n" +
                "        \"createUserId\": 67710114,\n" +
                "        \"orderAmount\": 185.313324,\n" +
                "        \"orgId\": 168,\n" +
                "        \"packageCount\": 3,\n" +
                "        \"relatedOrderId\": \"4919577590005492868\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210427\",\n" +
                "        \"saleTime\": 1619366400000,\n" +
                "        \"unitCount\": 22,\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 23.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800001550060\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"何宛玲\",\n" +
                "        \"createUserId\": 67710114,\n" +
                "        \"orderAmount\": 49.184005,\n" +
                "        \"orgId\": 168,\n" +
                "        \"packageCount\": 0,\n" +
                "        \"relatedOrderId\": \"4919138284210249563\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210426\",\n" +
                "        \"saleTime\": 1619280000000,\n" +
                "        \"unitCount\": 23,\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 25.604677\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800001550060\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558230,\n" +
                "                        \"unitTotalCount\": 15.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800054414485\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"何宛玲\",\n" +
                "        \"createUserId\": 67710114,\n" +
                "        \"orderAmount\": 153.236318,\n" +
                "        \"orgId\": 168,\n" +
                "        \"packageCount\": 2,\n" +
                "        \"relatedOrderId\": \"4919129506802851665\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210425\",\n" +
                "        \"saleTime\": 1619193600000,\n" +
                "        \"unitCount\": 1.604677,\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558230,\n" +
                "                        \"unitTotalCount\": 43.803226\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800054414485\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"何宛玲\",\n" +
                "        \"createUserId\": 67710114,\n" +
                "        \"orderAmount\": 135.790001,\n" +
                "        \"orgId\": 168,\n" +
                "        \"packageCount\": 2,\n" +
                "        \"relatedOrderId\": \"4918163000913823121\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210424\",\n" +
                "        \"saleTime\": 1619107200000,\n" +
                "        \"unitCount\": 13.803226,\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 112.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4867681516293513043\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 3.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002257189\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239566340,\n" +
                "                        \"unitTotalCount\": 9.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000004919492\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239576507,\n" +
                "                        \"unitTotalCount\": 40.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000011177290\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 325.083728,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 7,\n" +
                "        \"relatedOrderId\": \"4919136991018245973\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210426\",\n" +
                "        \"saleTime\": 1619280000000,\n" +
                "        \"unitCount\": 16,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 3.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4867681516293513043\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 336.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002257189\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 1527.392970,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 14,\n" +
                "        \"relatedOrderId\": \"4919128924566347590\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210425\",\n" +
                "        \"saleTime\": 1619193600000,\n" +
                "        \"unitCount\": 3,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 0.004286\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000125367050\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 26.772308\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4867681516293513043\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 4.260551\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002257189\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 11.760000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000001188672\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 3.648000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000008122805\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 110.990022,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 0,\n" +
                "        \"relatedOrderId\": \"4918161248124626134\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210424\",\n" +
                "        \"saleTime\": 1619107200000,\n" +
                "        \"unitCount\": 46.445145,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239569085,\n" +
                "                        \"unitTotalCount\": 155.184615\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4867681516293513043\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 30.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000011177290\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 160.800034,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 7,\n" +
                "        \"relatedOrderId\": \"4918056484859264202\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210423\",\n" +
                "        \"saleTime\": 1619020800000,\n" +
                "        \"unitCount\": 21.184615,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 11.680000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000001188672\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239582114,\n" +
                "                        \"unitTotalCount\": 0.481304\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000003839768\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239554799,\n" +
                "                        \"unitTotalCount\": 9.637681\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000000314758\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 134.429996,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 0,\n" +
                "        \"relatedOrderId\": \"4917439096556076230\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210422\",\n" +
                "        \"saleTime\": 1618934400000,\n" +
                "        \"unitCount\": 21.798985,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718392263257,\n" +
                "                        \"unitTotalCount\": 1.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000000274708\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 37,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 0,\n" +
                "        \"relatedOrderId\": \"4917385449755360466\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210421\",\n" +
                "        \"saleTime\": 1618848000000,\n" +
                "        \"unitCount\": 1,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 110.193721\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200151112433\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580225,\n" +
                "                        \"unitTotalCount\": 120.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200001196309\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"吴涛\",\n" +
                "        \"createUserId\": 1602,\n" +
                "        \"orderAmount\": 694.945006,\n" +
                "        \"orgId\": 402,\n" +
                "        \"packageCount\": 14,\n" +
                "        \"relatedOrderId\": \"4916980691980111052\",\n" +
                "        \"relatedOrderNo\": \"DDMC402120210420\",\n" +
                "        \"saleTime\": 1618761600000,\n" +
                "        \"unitCount\": 2.193721,\n" +
                "        \"warehouseId\": 4021\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 42.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200001185134\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239560371,\n" +
                "                        \"unitTotalCount\": 72.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200151112433\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580225,\n" +
                "                        \"unitTotalCount\": 168.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200001196309\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718272179017,\n" +
                "                        \"unitTotalCount\": 30.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200191003138\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580225,\n" +
                "                        \"unitTotalCount\": 15.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4772133343308590227\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"吴涛\",\n" +
                "        \"createUserId\": 1602,\n" +
                "        \"orderAmount\": 871.800051,\n" +
                "        \"orgId\": 402,\n" +
                "        \"packageCount\": 23,\n" +
                "        \"relatedOrderId\": \"4916628226511768854\",\n" +
                "        \"relatedOrderNo\": \"DDMC402120210419\",\n" +
                "        \"saleTime\": 1618675200000,\n" +
                "        \"unitCount\": 0,\n" +
                "        \"warehouseId\": 4021\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584402,\n" +
                "                        \"unitTotalCount\": 58.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200001548573\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584402,\n" +
                "                        \"unitTotalCount\": 2.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200001188935\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239555868,\n" +
                "                        \"unitTotalCount\": 4.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200011226417\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"王刚\",\n" +
                "        \"createUserId\": 15827,\n" +
                "        \"orderAmount\": 222.595536,\n" +
                "        \"orgId\": 412,\n" +
                "        \"packageCount\": 3,\n" +
                "        \"relatedOrderId\": \"4919227812823431116\",\n" +
                "        \"relatedOrderNo\": \"DDMC412120210419\",\n" +
                "        \"saleTime\": 1618675200000,\n" +
                "        \"unitCount\": 12,\n" +
                "        \"warehouseId\": 4121\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000008122805\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 47.400000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000125367050\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239582114,\n" +
                "                        \"unitTotalCount\": 23.926957\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000003839768\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239569899,\n" +
                "                        \"unitTotalCount\": 12.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000004919492\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 3.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4864434714945576796\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 479.04,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 8,\n" +
                "        \"relatedOrderId\": \"4916965013183674782\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210420\",\n" +
                "        \"saleTime\": 1618761600000,\n" +
                "        \"unitCount\": 20.326957,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577663,\n" +
                "                        \"unitTotalCount\": 168.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4858349024854966668\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 148.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300064063536\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 0.953043\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300000734167\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"马翔\",\n" +
                "        \"createUserId\": 88941,\n" +
                "        \"orderAmount\": 2328.880056,\n" +
                "        \"orgId\": 723,\n" +
                "        \"packageCount\": 38,\n" +
                "        \"relatedOrderId\": \"4918132743403955412\",\n" +
                "        \"relatedOrderNo\": \"DDMC723120210421\",\n" +
                "        \"saleTime\": 1618848000000,\n" +
                "        \"unitCount\": 4.953043,\n" +
                "        \"warehouseId\": 7231\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 480.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300064063536\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 4.765797\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300000734167\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"马翔\",\n" +
                "        \"createUserId\": 88941,\n" +
                "        \"orderAmount\": 584.420001,\n" +
                "        \"orgId\": 723,\n" +
                "        \"packageCount\": 80,\n" +
                "        \"relatedOrderId\": \"4918131864061709579\",\n" +
                "        \"relatedOrderNo\": \"DDMC723120210420\",\n" +
                "        \"saleTime\": 1618761600000,\n" +
                "        \"unitCount\": 4.765797,\n" +
                "        \"warehouseId\": 7231\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239567101,\n" +
                "                        \"unitTotalCount\": 11.882835\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40500047275913\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"范灵宝\",\n" +
                "        \"createUserId\": 8007,\n" +
                "        \"orderAmount\": 62.880006,\n" +
                "        \"orgId\": 405,\n" +
                "        \"packageCount\": 0,\n" +
                "        \"relatedOrderId\": \"4916964708501043600\",\n" +
                "        \"relatedOrderNo\": \"DDMC405120210420\",\n" +
                "        \"saleTime\": 1618761600000,\n" +
                "        \"unitCount\": 11.882835,\n" +
                "        \"warehouseId\": 4051\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 51.655384\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800005831135\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"何宛玲\",\n" +
                "        \"createUserId\": 67710114,\n" +
                "        \"orderAmount\": 97.929982,\n" +
                "        \"orgId\": 168,\n" +
                "        \"packageCount\": 2,\n" +
                "        \"relatedOrderId\": \"4917443621417368795\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210422\",\n" +
                "        \"saleTime\": 1618934400000,\n" +
                "        \"unitCount\": 3.655384,\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239559734,\n" +
                "                        \"unitTotalCount\": 22.749851\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 10300001188290\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239570212,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 10300001198659\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558274,\n" +
                "                        \"unitTotalCount\": 23.222143\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 10300002257379\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orderAmount\": 257.890002,\n" +
                "        \"orgId\": 103,\n" +
                "        \"packageCount\": 2,\n" +
                "        \"relatedOrderId\": \"4916982062819721430\",\n" +
                "        \"relatedOrderNo\": \"DDMC103120210420\",\n" +
                "        \"saleTime\": 1618761600000,\n" +
                "        \"unitCount\": 33.971994,\n" +
                "        \"warehouseId\": 1031\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580157,\n" +
                "                        \"unitTotalCount\": 14.237538\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 70400003872819\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 14.458647\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 70400058662050\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orderAmount\": 79.298961,\n" +
                "        \"orgId\": 704,\n" +
                "        \"packageCount\": 1,\n" +
                "        \"relatedOrderId\": \"4918407371795874000\",\n" +
                "        \"relatedOrderNo\": \"DDMC704120210419\",\n" +
                "        \"saleTime\": 1618675200000,\n" +
                "        \"unitCount\": 16.696185,\n" +
                "        \"warehouseId\": 7041\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 23.000471\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72100000561291\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orderAmount\": 40.729993,\n" +
                "        \"orgId\": 721,\n" +
                "        \"packageCount\": 0,\n" +
                "        \"relatedOrderId\": \"4916626844941398926\",\n" +
                "        \"relatedOrderNo\": \"DDMC721120210419\",\n" +
                "        \"saleTime\": 1618675200000,\n" +
                "        \"unitCount\": 23.000471,\n" +
                "        \"warehouseId\": 7211\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718299174727,\n" +
                "                        \"unitTotalCount\": 36.932432\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4792681681467797833\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239560816,\n" +
                "                        \"unitTotalCount\": 114.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40400003532053\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577392,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40400001083802\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239575072,\n" +
                "                        \"unitTotalCount\": 12.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40400004804436\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239569537,\n" +
                "                        \"unitTotalCount\": 13.871241\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4863407525556840346\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 12.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4843976557031033624\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"魏义峰\",\n" +
                "        \"createUserId\": 8006,\n" +
                "        \"orderAmount\": 2949.108530,\n" +
                "        \"orgId\": 404,\n" +
                "        \"packageCount\": 26,\n" +
                "        \"relatedOrderId\": \"4916336261383967255\",\n" +
                "        \"relatedOrderNo\": \"DDMC404120210418\",\n" +
                "        \"saleTime\": 1618588800000,\n" +
                "        \"unitCount\": 38.803673,\n" +
                "        \"warehouseId\": 4041\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 61.965000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 42100001548502\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orderAmount\": 123.93,\n" +
                "        \"orgId\": 421,\n" +
                "        \"packageCount\": 2,\n" +
                "        \"relatedOrderId\": \"4916622550179623836\",\n" +
                "        \"relatedOrderNo\": \"DDMC421120210419\",\n" +
                "        \"saleTime\": 1618675200000,\n" +
                "        \"unitCount\": 13.965,\n" +
                "        \"warehouseId\": 4211\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 120.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000001548114\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 0.999770\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4864434714945576796\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 30.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002112159\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 23.840000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000001188672\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 60.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000007147440\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239581420,\n" +
                "                        \"unitTotalCount\": 15.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000001542800\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239555488,\n" +
                "                        \"unitTotalCount\": 528.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000008122805\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002057402\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239576923,\n" +
                "                        \"unitTotalCount\": 36.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000125367050\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239562859,\n" +
                "                        \"unitTotalCount\": 4.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4810048808338993613\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000025226449\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558853,\n" +
                "                        \"unitTotalCount\": 2.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000031358303\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239555488,\n" +
                "                        \"unitTotalCount\": 311.685138\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002257189\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239562859,\n" +
                "                        \"unitTotalCount\": 22.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000000311338\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"范灵宝\",\n" +
                "        \"createUserId\": 8007,\n" +
                "        \"orderAmount\": 3079.380352,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 57,\n" +
                "        \"relatedOrderId\": \"4916612053313293585\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210419\",\n" +
                "        \"saleTime\": 1618675200000,\n" +
                "        \"unitCount\": 48.524908,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239566685,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41900001570554\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"魏义峰\",\n" +
                "        \"createUserId\": 8006,\n" +
                "        \"orderAmount\": 52.999992,\n" +
                "        \"orgId\": 419,\n" +
                "        \"packageCount\": 1,\n" +
                "        \"relatedOrderId\": \"4916325351892151813\",\n" +
                "        \"relatedOrderNo\": \"DDMC419120210418\",\n" +
                "        \"saleTime\": 1618588800000,\n" +
                "        \"unitCount\": 0,\n" +
                "        \"warehouseId\": 4191\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 111,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718248270351,\n" +
                "                        \"unitTotalCount\": 7.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200003107709\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584402,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200001548573\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584402,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200001188935\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584402,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200003839759\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584402,\n" +
                "                        \"unitTotalCount\": 70.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 41200001547655\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"魏义峰\",\n" +
                "        \"createUserId\": 8006,\n" +
                "        \"orderAmount\": 562.520001,\n" +
                "        \"orgId\": 412,\n" +
                "        \"packageCount\": 11,\n" +
                "        \"relatedOrderId\": \"4918885803449382850\",\n" +
                "        \"relatedOrderNo\": \"DDMC412120210418\",\n" +
                "        \"saleTime\": 1618588800000,\n" +
                "        \"unitCount\": 23,\n" +
                "        \"warehouseId\": 4121\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 110,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239571015,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002257189\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 109.000008,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 1,\n" +
                "        \"relatedOrderId\": \"4917428464263871690\",\n" +
                "        \"relatedOrderNo\": \"MTYX400120210422\",\n" +
                "        \"saleTime\": 1618761600000,\n" +
                "        \"unitCount\": 0,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"accessPlatformType\": 110,\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239571015,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002257189\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"钱安民\",\n" +
                "        \"createUserId\": 13897,\n" +
                "        \"orderAmount\": 218.000016,\n" +
                "        \"orgId\": 400,\n" +
                "        \"packageCount\": 2,\n" +
                "        \"relatedOrderId\": \"4917412687037841546\",\n" +
                "        \"relatedOrderNo\": \"MTYX400120210420\",\n" +
                "        \"saleTime\": 1618588800000,\n" +
                "        \"unitCount\": 0,\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 389.615436\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200001185134\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239560371,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200151112433\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580225,\n" +
                "                        \"unitTotalCount\": 144.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40200001196309\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"魏义峰\",\n" +
                "        \"createUserId\": 8006,\n" +
                "        \"orgId\": 402,\n" +
                "        \"relatedOrderId\": \"4916312034201005579\",\n" +
                "        \"relatedOrderNo\": \"DDMC402120210418\",\n" +
                "        \"warehouseId\": 4021\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 42100001740974\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"林龙\",\n" +
                "        \"createUserId\": 33422,\n" +
                "        \"orgId\": 421,\n" +
                "        \"relatedOrderId\": \"4916332025950622235\",\n" +
                "        \"relatedOrderNo\": \"DDMC421120210418\",\n" +
                "        \"warehouseId\": 4211\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239579826,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600007145129\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orgId\": 406,\n" +
                "        \"relatedOrderId\": \"4917439482684489863\",\n" +
                "        \"relatedOrderNo\": \"DDMC406120210422\",\n" +
                "        \"warehouseId\": 4061\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 93.886061\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900001555063\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 22.230000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900001543515\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 17.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900003107231\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 12.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900002494978\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 144.785159\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900000947637\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orgId\": 159,\n" +
                "        \"relatedOrderId\": \"4916966557550779152\",\n" +
                "        \"relatedOrderNo\": \"DDMC159120210420\",\n" +
                "        \"warehouseId\": 1591\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 231.355152\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900001555063\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 72.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900001698710\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 14.689189\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4777582275521374212\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orgId\": 159,\n" +
                "        \"relatedOrderId\": \"4916605509620052874\",\n" +
                "        \"relatedOrderNo\": \"DDMC159120210419\",\n" +
                "        \"warehouseId\": 1591\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239553509,\n" +
                "                        \"unitTotalCount\": 4.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4911289754947203800\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239570580,\n" +
                "                        \"unitTotalCount\": 4.228571\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 71100083356891\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orgId\": 711,\n" +
                "        \"relatedOrderId\": \"4916623265119898896\",\n" +
                "        \"relatedOrderNo\": \"DDMC711120210419\",\n" +
                "        \"warehouseId\": 7111\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239570580,\n" +
                "                        \"unitTotalCount\": 398.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 71100083356891\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 11.768889\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 71100009754035\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 44.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 71100045702871\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 3.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4798125746493601992\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"孙荣梅\",\n" +
                "        \"createUserId\": 90082,\n" +
                "        \"orgId\": 711,\n" +
                "        \"relatedOrderId\": \"4916310848582570516\",\n" +
                "        \"relatedOrderNo\": \"DDMC711120210418\",\n" +
                "        \"warehouseId\": 7111\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580830,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600007145129\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580494,\n" +
                "                        \"unitTotalCount\": 552.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600060789141\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 406,\n" +
                "        \"relatedOrderId\": \"4917384305327718543\",\n" +
                "        \"relatedOrderNo\": \"DDMC406120210421\",\n" +
                "        \"warehouseId\": 4061\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239576245,\n" +
                "                        \"unitTotalCount\": 22.987252\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800005831135\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 168,\n" +
                "        \"relatedOrderId\": \"4917388557169180817\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210421\",\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584532,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40300001789506\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 403,\n" +
                "        \"relatedOrderId\": \"4917396104839412948\",\n" +
                "        \"relatedOrderNo\": \"DDMC403120210421\",\n" +
                "        \"warehouseId\": 4031\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580830,\n" +
                "                        \"unitTotalCount\": 120.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600007145129\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239554704,\n" +
                "                        \"unitTotalCount\": 1.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600007322579\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 406,\n" +
                "        \"relatedOrderId\": \"4916964897709497108\",\n" +
                "        \"relatedOrderNo\": \"DDMC406120210420\",\n" +
                "        \"warehouseId\": 4061\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239581073,\n" +
                "                        \"unitTotalCount\": 95.023729\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 46500004120239\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 465,\n" +
                "        \"relatedOrderId\": \"4916965725342939529\",\n" +
                "        \"relatedOrderNo\": \"DDMC465120210420\",\n" +
                "        \"warehouseId\": 4651\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239556789,\n" +
                "                        \"unitTotalCount\": 74.856383\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 11900003173415\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 135.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 11900107485366\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239560776,\n" +
                "                        \"unitTotalCount\": 78.497455\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 11900002257872\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 119,\n" +
                "        \"relatedOrderId\": \"4916968697258981788\",\n" +
                "        \"relatedOrderNo\": \"DDMC119120210420\",\n" +
                "        \"warehouseId\": 1191\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 32.668657\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800001198513\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 168,\n" +
                "        \"relatedOrderId\": \"4916970255862348184\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210420\",\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239581073,\n" +
                "                        \"unitTotalCount\": 20.587119\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 46500004120239\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 465,\n" +
                "        \"relatedOrderId\": \"4916602884703161614\",\n" +
                "        \"relatedOrderNo\": \"DDMC465120210419\",\n" +
                "        \"warehouseId\": 4651\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239556789,\n" +
                "                        \"unitTotalCount\": 95.476364\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 11900002257872\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 119,\n" +
                "        \"relatedOrderId\": \"4916606708587203866\",\n" +
                "        \"relatedOrderNo\": \"DDMC119120210419\",\n" +
                "        \"warehouseId\": 1191\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239569353,\n" +
                "                        \"unitTotalCount\": 36.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40500047275913\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239574029,\n" +
                "                        \"unitTotalCount\": 24.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40500001732374\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 15.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40500001543931\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239563807,\n" +
                "                        \"unitTotalCount\": 15.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40500001542870\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 405,\n" +
                "        \"relatedOrderId\": \"4916614674631658758\",\n" +
                "        \"relatedOrderNo\": \"DDMC405120210419\",\n" +
                "        \"warehouseId\": 4051\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 107.500000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300064063536\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 0.953043\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300000734167\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 723,\n" +
                "        \"relatedOrderId\": \"4916619667824554907\",\n" +
                "        \"relatedOrderNo\": \"DDMC723120210419\",\n" +
                "        \"warehouseId\": 7231\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239554398,\n" +
                "                        \"unitTotalCount\": 21.072000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4841638631619101918\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 403,\n" +
                "        \"relatedOrderId\": \"4916621382695105430\",\n" +
                "        \"relatedOrderNo\": \"DDMC403120210419\",\n" +
                "        \"warehouseId\": 4031\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580830,\n" +
                "                        \"unitTotalCount\": 408.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600007145129\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 406,\n" +
                "        \"relatedOrderId\": \"4916623343209264030\",\n" +
                "        \"relatedOrderNo\": \"DDMC406120210419\",\n" +
                "        \"warehouseId\": 4061\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 78.797015\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 16800001198513\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1,\n" +
                "                        \"unitTotalCount\": 31.979130\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4856422847213753558\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 168,\n" +
                "        \"relatedOrderId\": \"4916627593079403398\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210419\",\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718368273196,\n" +
                "                        \"unitTotalCount\": 12.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 10300034772186\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239560582,\n" +
                "                        \"unitTotalCount\": 8.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 10300001541851\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239580513,\n" +
                "                        \"unitTotalCount\": 11.147027\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 10300001817353\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 103,\n" +
                "        \"relatedOrderId\": \"4916025175355605455\",\n" +
                "        \"relatedOrderNo\": \"DDMC103120210418\",\n" +
                "        \"warehouseId\": 1031\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 65.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300064063536\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239577897,\n" +
                "                        \"unitTotalCount\": 4.974571\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 72300000734167\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 723,\n" +
                "        \"relatedOrderId\": \"4916297796145344020\",\n" +
                "        \"relatedOrderNo\": \"DDMC723120210418\",\n" +
                "        \"warehouseId\": 7231\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239578271,\n" +
                "                        \"unitTotalCount\": 2348.614925\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4837683092788004680\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 168,\n" +
                "        \"relatedOrderId\": \"4916306244595733014\",\n" +
                "        \"relatedOrderNo\": \"DDMC168120210418\",\n" +
                "        \"warehouseId\": 1681\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239579826,\n" +
                "                        \"unitTotalCount\": 239.916522\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600007145129\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239554704,\n" +
                "                        \"unitTotalCount\": 1.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40600007322579\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 406,\n" +
                "        \"relatedOrderId\": \"4916314622401146373\",\n" +
                "        \"relatedOrderNo\": \"DDMC406120210418\",\n" +
                "        \"warehouseId\": 4061\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239582114,\n" +
                "                        \"unitTotalCount\": 167.990204\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000001548114\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239582114,\n" +
                "                        \"unitTotalCount\": 36.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000001188672\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239570091,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000007147440\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239576923,\n" +
                "                        \"unitTotalCount\": 120.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000008122805\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239566116,\n" +
                "                        \"unitTotalCount\": 120.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000002057402\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239582114,\n" +
                "                        \"unitTotalCount\": 36.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000125367050\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239562859,\n" +
                "                        \"unitTotalCount\": 14.200000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000000311338\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239569085,\n" +
                "                        \"unitTotalCount\": 28.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4867681516293513043\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239569899,\n" +
                "                        \"unitTotalCount\": 83.889438\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000004919492\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558853,\n" +
                "                        \"unitTotalCount\": 1.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40000031358303\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 400,\n" +
                "        \"relatedOrderId\": \"4916319929171038746\",\n" +
                "        \"relatedOrderNo\": \"DDMC400120210418\",\n" +
                "        \"warehouseId\": 4001\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718355813066,\n" +
                "                        \"unitTotalCount\": 286.169492\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 46500004120239\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 465,\n" +
                "        \"relatedOrderId\": \"4916322616929119746\",\n" +
                "        \"relatedOrderNo\": \"DDMC465120210418\",\n" +
                "        \"warehouseId\": 4651\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584388,\n" +
                "                        \"unitTotalCount\": 25.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 47300004857769\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239576683,\n" +
                "                        \"unitTotalCount\": 8.925455\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 47300005371601\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239584657,\n" +
                "                        \"unitTotalCount\": 95.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4906403955730592475\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 473,\n" +
                "        \"relatedOrderId\": \"4916325857731662366\",\n" +
                "        \"relatedOrderNo\": \"DDMC473120210418\",\n" +
                "        \"warehouseId\": 4731\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239554398,\n" +
                "                        \"unitTotalCount\": 35.083429\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 40300031652437\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239554398,\n" +
                "                        \"unitTotalCount\": 0.040000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4841638631619101918\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 403,\n" +
                "        \"relatedOrderId\": \"4916332911145898520\",\n" +
                "        \"relatedOrderNo\": \"DDMC403120210418\",\n" +
                "        \"warehouseId\": 4031\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 45.728000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4776428017752634507\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718271632734,\n" +
                "                        \"unitTotalCount\": 100.946667\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900001555063\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239578869,\n" +
                "                        \"unitTotalCount\": 21.224348\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900000947637\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718271632734,\n" +
                "                        \"unitTotalCount\": 13.698222\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900002112802\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 48.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900001698710\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239558528,\n" +
                "                        \"unitTotalCount\": 52.108000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 15900004804715\n" +
                "            },\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 44.067568\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 4777582275521374212\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"张本军\",\n" +
                "        \"createUserId\": 10972,\n" +
                "        \"orgId\": 159,\n" +
                "        \"relatedOrderId\": \"4916334706540637721\",\n" +
                "        \"relatedOrderNo\": \"DDMC159120210418\",\n" +
                "        \"warehouseId\": 1591\n" +
                "    },\n" +
                "    {\n" +
                "        \"commOrderItemDTOS\": [\n" +
                "            {\n" +
                "                \"commOrderItemDetailDTOS\": [\n" +
                "                    {\n" +
                "                        \"secOwnerId\": 1395869718239582625,\n" +
                "                        \"unitTotalCount\": 12.000000\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"skuId\": 11400151112789\n" +
                "            }\n" +
                "        ],\n" +
                "        \"createUser\": \"吴梦晗\",\n" +
                "        \"createUserId\": 67777905,\n" +
                "        \"orgId\": 114,\n" +
                "        \"relatedOrderId\": \"4916592790426727297\",\n" +
                "        \"relatedOrderNo\": \"DDMC114120210418\",\n" +
                "        \"warehouseId\": 1141\n" +
                "    }\n" +
                "]";
        List<CommOrderDTO> commOrderDTOS = JSON.parseArray(text, CommOrderDTO.class);
        for (CommOrderDTO commOrderDTO : commOrderDTOS) {
            commOrderDTO.setSaleTimeStr(DateUtils.date2String(commOrderDTO.getSaleTime()));
        }
        return commOrderDTOS;
    }


    public static Map<Long, ErpProductOwnerDTO> getSkuMap() {
        String json = "[{\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":10300001188290,\"specId\":1188},{\"productName\":\"怡宝水555ml （1*24）\",\"productSkuId\":10300001198659,\"specId\":1198},{\"productName\":\"统一绿茶1L（1*8）\",\"productSkuId\":10300001541851,\"specId\":1541},{\"productName\":\"百事可乐1L（1*12）\",\"productSkuId\":10300001817353,\"specId\":1817},{\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":10300002257379,\"specId\":2257},{\"productName\":\"黄鹤楼升级版15年42度500ml（1*6）\",\"productSkuId\":10300034772186,\"specId\":34772},{\"productName\":\"乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\"productSkuId\":11400151112789,\"specId\":151112},{\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":11900002257872,\"specId\":2257},{\"productName\":\"乐虎380ml（1*15）\",\"productSkuId\":11900003173415,\"specId\":3173},{\"productName\":\"水润坊能量100牛磺酸强化型维生素饮料600ml（1*15）\",\"productSkuId\":11900107485366,\"specId\":107485},{\"productName\":\"青岛清爽[听]8度330ml（1*24）\",\"productSkuId\":15900000947637,\"specId\":947},{\"productName\":\"脉动水蜜桃口味600ml（1*15）\",\"productSkuId\":15900001543515,\"specId\":1543},{\"productName\":\"百事可乐[瓶]600ml（1*24）\",\"productSkuId\":15900001555063,\"specId\":1555},{\"productName\":\"百岁山饮用天然矿泉水570ml（1*24）\",\"productSkuId\":15900001698710,\"specId\":1698},{\"productName\":\"雀巢咖啡丝滑拿铁268ml（1*15）\",\"productSkuId\":15900002112802,\"specId\":2112},{\"productName\":\"怡宝纯净水1.555L（1*12）\",\"productSkuId\":15900002494978,\"specId\":2494},{\"productName\":\"百事可乐2L（1*6）\",\"productSkuId\":15900003107231,\"specId\":3107},{\"productName\":\"银鹭桂圆莲子八宝粥360g（1*12）\",\"productSkuId\":15900004804715,\"specId\":4804},{\"productName\":\"怡宝水555ml （1*24）\",\"productSkuId\":16800001198513,\"specId\":1198},{\"productName\":\"百事可乐[瓶]500ml（1*24）\",\"productSkuId\":16800001550060,\"specId\":1550},{\"productName\":\"维他奶原味豆奶【盒】250ml（1*24）\",\"productSkuId\":16800005831135,\"specId\":5831},{\"productName\":\"统一阿萨姆原味奶茶新装500ml（1*15）\",\"productSkuId\":16800054414485,\"specId\":54414},{\"productName\":\"汾酒光瓶53度475ml（1*12）\",\"productSkuId\":40000000274708,\"specId\":274},{\"productName\":\"牛栏山陈酿42度500ml（1*12）\",\"productSkuId\":40000000311338,\"specId\":311},{\"productName\":\"古越龙山清醇三年500ml\",\"productSkuId\":40000000314758,\"specId\":314},{\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":40000001188672,\"specId\":1188},{\"productName\":\"脉动青柠口味600ml（1*15）\",\"productSkuId\":40000001542800,\"specId\":1542},{\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":40000001548114,\"specId\":1548},{\"productName\":\"王老吉（听装）310ml（1*24）\",\"productSkuId\":40000002057402,\"specId\":2057},{\"productName\":\"雀巢咖啡丝滑拿铁268ml（1*15）\",\"productSkuId\":40000002112159,\"specId\":2112},{\"productName\":\"红牛250ml（1*24）\",\"productSkuId\":40000002257189,\"specId\":2257},{\"productName\":\"美汁源果粒橙1.8L（1*6）\",\"productSkuId\":40000003839768,\"specId\":3839},{\"productName\":\"蒙牛特仑苏（纯牛奶）250ml（1*12）\",\"productSkuId\":40000004919492,\"specId\":4919},{\"productName\":\"康师傅红烧牛肉面108g（1*12）\",\"productSkuId\":40000007147440,\"specId\":7147},{\"productName\":\"冰露饮用纯净水550ml（1*24）\",\"productSkuId\":40000008122805,\"specId\":8122},{\"productName\":\"康师傅香辣牛肉面桶装108g（1*12）\",\"productSkuId\":40000011177290,\"specId\":11177},{\"productName\":\"今麦郎软化纯净水550ml（1*24）\",\"productSkuId\":40000025226449,\"specId\":25226},{\"productName\":\"七度空间（QUC8110）优雅系列卫生巾空气感日用丝柔超薄（10片）245mm\",\"productSkuId\":40000031358303,\"specId\":31358},{\"productName\":\"美汁源果粒橙420ml（1*12）\",\"productSkuId\":40000125367050,\"specId\":125367},{\"productName\":\"可口可乐2L（1*6）\",\"productSkuId\":40200001185134,\"specId\":1185},{\"productName\":\"农夫山泉550ml（1*24）\",\"productSkuId\":40200001196309,\"specId\":1196},{\"productName\":\"乌苏（红）啤酒【瓶】纸箱装11度620ml（1*12）\",\"productSkuId\":40200151112433,\"specId\":151112},{\"productName\":\"加多宝（瓶装）550ml（1*15）\",\"productSkuId\":40200191003138,\"specId\":191003},{\"productName\":\"可口可乐[听]330ml（1*24）\",\"productSkuId\":40300001789506,\"specId\":1789},{\"productName\":\"可口可乐畅爽装680ml（1*12）\",\"productSkuId\":40300031652437,\"specId\":31652},{\"productName\":\"东北坊珍酿六年45度450ml\",\"productSkuId\":40400001083802,\"specId\":1083},{\"productName\":\"和酒金色年华6年（红箱）9度500ml\",\"productSkuId\":40400003532053,\"specId\":3532},{\"productName\":\"银鹭桂圆莲子八宝粥360g（1*12）\",\"productSkuId\":40400004804436,\"specId\":4804},{\"productName\":\"脉动青柠口味600ml（1*15）\",\"productSkuId\":40500001542870,\"specId\":1542},{\"productName\":\"脉动水蜜桃口味600ml（1*15）\",\"productSkuId\":40500001543931,\"specId\":1543},{\"productName\":\"椰树椰汁1L（1*12）\",\"productSkuId\":40500001732374,\"specId\":1732},{\"productName\":\"百威啤酒9.7度【听】500ml（1*12）\",\"productSkuId\":40500047275913,\"specId\":47275},{\"productName\":\"统一来一桶老坛酸菜牛肉面香辣味120g（1*12）\",\"productSkuId\":40600007145129,\"specId\":7145},{\"productName\":\"金龙鱼黄金比例食用调和油5L（1*4）\",\"productSkuId\":40600007322579,\"specId\":7322},{\"productName\":\"稻花香过桥米线酸辣牛肉味110g（1*12）\",\"productSkuId\":40600060789141,\"specId\":60789},{\"productName\":\"美汁源果粒橙1.25L（1*12）\",\"productSkuId\":41200001188935,\"specId\":1188},{\"productName\":\"雪碧【听装】330ml（1*24）\",\"productSkuId\":41200001547655,\"specId\":1547},{\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":41200001548573,\"specId\":1548},{\"productName\":\"百事可乐2L（1*6）\",\"productSkuId\":41200003107709,\"specId\":3107},{\"productName\":\"美汁源果粒橙1.8L（1*6）\",\"productSkuId\":41200003839759,\"specId\":3839},{\"productName\":\"古井淡雅42度450ml（1*4）\",\"productSkuId\":41200011226417,\"specId\":11226},{\"productName\":\"加多宝新装[听]310ml（1*24）\",\"productSkuId\":41900001570554,\"specId\":1570},{\"productName\":\"雪碧【瓶】500ml（1*24）\",\"productSkuId\":42100001548502,\"specId\":1548},{\"productName\":\"芬达橙味汽水500ml（1*24）\",\"productSkuId\":42100001740974,\"specId\":1740},{\"productName\":\"蒙牛纯牛奶（盒装）250ml（1*24）\",\"productSkuId\":46500004120239,\"specId\":4120},{\"productName\":\"女儿红绍兴老酒桶装黄酒14度2.5L\",\"productSkuId\":47300004857769,\"specId\":4857},{\"productName\":\"老村长富贵酒42度450ml\",\"productSkuId\":47300005371601,\"specId\":5371},{\"productName\":\"伊利优酸乳原味250ml（1*24）\",\"productSkuId\":70400003872819,\"specId\":3872},{\"productName\":\"太原高粱白【升级版】42度450ml（1*12）\",\"productSkuId\":70400058662050,\"specId\":58662},{\"productName\":\"秋林格瓦斯350ml（1*12）\",\"productSkuId\":71100009754035,\"specId\":9754},{\"productName\":\"立白新金桔洗洁精1kg+120g（1*10）\",\"productSkuId\":71100045702871,\"specId\":45702},{\"productName\":\"雕牌全效加浓洗洁精1.5kg\",\"productSkuId\":71100083356891,\"specId\":83356},{\"productName\":\"哈尔滨小麦王【听】10度330ml（1*24）\",\"productSkuId\":72100000561291,\"specId\":561},{\"productName\":\"汾酒玻璃瓶42度475ml\",\"productSkuId\":72300000734167,\"specId\":734},{\"productName\":\"雅鲁河高粱原浆42度500ml（1*6）\",\"productSkuId\":72300064063536,\"specId\":64063},{\"productName\":\"农夫山泉维他命水柑橘风味（力量帝）500ml（1*15）\",\"productSkuId\":4772133343308590227,\"specId\":29222},{\"productName\":\"农夫山泉550ml（1*24）\",\"productSkuId\":4776428017752634507,\"specId\":1196},{\"productName\":\"维他柠檬茶饮料【瓶】500ml（1*15）\",\"productSkuId\":4777582275521374212,\"specId\":278888},{\"productName\":\"中盐精制加碘盐500g（1*40）\",\"productSkuId\":4792681681467797833,\"specId\":308897},{\"productName\":\"金沙河刀削原味面片200g（1*25）\",\"productSkuId\":4798125746493601992,\"specId\":48025},{\"productName\":\"绵柔尖庄（红）42度500ml（1*4）\",\"productSkuId\":4810048808338993613,\"specId\":334557},{\"productName\":\"康师傅矿物质水500ml（1*28）\",\"productSkuId\":4837683092788004680,\"specId\":270849},{\"productName\":\"可口可乐零度汽水680ml（1*12）\",\"productSkuId\":4841638631619101918,\"specId\":247343},{\"productName\":\"银鹭桂圆八宝粥360g（1*12）\",\"productSkuId\":4843976557031033624,\"specId\":112022},{\"productName\":\"夏宝牛牛菊花植物饮料250ml（1*24）\",\"productSkuId\":4856422847213753558,\"specId\":382026},{\"productName\":\"燕京U8啤酒8度500ml（1*12）\",\"productSkuId\":4858349024854966668,\"specId\":333218},{\"productName\":\"多力葵花籽油5.68L（1*4）\",\"productSkuId\":4863407525556840346,\"specId\":19914},{\"productName\":\"旺仔牛奶8罐*245ml+旺旺O泡果奶原味4罐*245ml\",\"productSkuId\":4864434714945576796,\"specId\":381180},{\"productName\":\"康师傅包装饮用水[瓶]550ml（1*28）\",\"productSkuId\":4867681516293513043,\"specId\":370265},{\"productName\":\"贵宾歪脖小郎酒45度100ml\",\"productSkuId\":4906403955730592475,\"specId\":238},{\"productName\":\"娃哈哈饮用天然矿泉水4.5L（1*4）\",\"productSkuId\":4911289754947203800,\"specId\":277444}]\n";
        List<ErpProductOwnerDTO> erpProductOwnerDTOS = JSON.parseArray(json, ErpProductOwnerDTO.class);
        Map<Long, ErpProductOwnerDTO> skuMap = erpProductOwnerDTOS.stream().collect(Collectors.toMap(it -> it.getProductSkuId(), it -> it, (v1, v2) -> v1));
        return skuMap;
    }




}
