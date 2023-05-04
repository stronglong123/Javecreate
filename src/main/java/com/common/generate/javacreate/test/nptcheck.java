package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.ordercenter.dto.NewData;
import com.common.generate.javacreate.ordercenter.dto.NewDataItem;
import com.common.generate.javacreate.ordercenter.dto.TrainsOutStockDTO;
import com.common.generate.javacreate.ordercenter.dto.TrainsOutStockDealerDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/4/20 9:11
 */
public class nptcheck {


    public static void main(String[] args){

        TrainsOutStockDTO outData = getOutData();
        OrderDocumentDTO omsData = getOmsData();


        List<Long> itemIds = new ArrayList<>();

        List<Long> trueItemIds = new ArrayList<>();

        outData.getTrainsOutStockOrderList().get(0).getTrainsOutStockOrderItemList().forEach(item->{
            TrainsOutStockDealerDTO nullSecOwner = item.getTrainsOutStockDealerList().stream().filter(it -> it.getSecOwnerId() == null).findFirst().orElse(null);
            if(nullSecOwner!=null){
                itemIds.add(item.getOrderItemId());
            }else {
                trueItemIds.add(item.getOrderItemId());
            }
        });
        System.out.println(itemIds);

        List<String> productList = omsData.getOrderItems().stream().filter(it -> itemIds.contains(it.getOrderItemBase().getOrderItemId())).map(it -> it.getOrderItemBase().getProductName()+"_"+it.getOrderItemBase().getCount()).collect(Collectors.toList());
        System.out.println("空二级货主产品:"+productList);
        System.out.println("空二级货主产品数量:"+productList.size());
        List<String> trueProductList = omsData.getOrderItems().stream().filter(it -> trueItemIds.contains(it.getOrderItemBase().getOrderItemId())).map(it -> it.getOrderItemBase().getProductName()+"_"+it.getOrderItemBase().getCount()).collect(Collectors.toList());
        System.out.println("二级货主产品:"+trueProductList);
        System.out.println("二级货主产品:"+trueProductList.size());

        NewData newData = getNewData();
        Map<Long, NewDataItem> newItemMap = newData.getList().stream().collect(Collectors.toMap(it -> it.getBusinessItemId(), it -> it));

        outData.getTrainsOutStockOrderList().get(0).getTrainsOutStockOrderItemList().forEach(item->{
            Long orderItemId = item.getOrderItemId();
            NewDataItem newDataItem = newItemMap.get(orderItemId);
            Long newSecOwnerId = newDataItem.getSecOwnerId();
            BigDecimal newUnitTotalCount = newDataItem.getUnitTotalCount();

            TrainsOutStockDealerDTO trainsOutStockDealer = item.getTrainsOutStockDealerList().get(0);
            if(trainsOutStockDealer.getUnitTotalCount().compareTo(newUnitTotalCount)!=0){
                throw new BusinessException("二级货主数量不匹配,明细id="+orderItemId);
            }
            if(trainsOutStockDealer.getSecOwnerId()!=newSecOwnerId){
                if(!itemIds.contains(orderItemId)){
                    throw new BusinessException("不在异常数据内"+orderItemId);
                }
                System.out.println(String.format("二级货主明细不匹配，明细id=%s,变更前=%s,变更后=%s",orderItemId,trainsOutStockDealer.getSecOwnerId(),newSecOwnerId));
                trainsOutStockDealer.setSecOwnerId(newSecOwnerId);
            }
        });
        System.out.println(JSON.toJSONString(outData));
    }




    private static NewData getNewData(){
        String json ="{\n" +
                "        \"businessId\": 5177158237001564195,\n" +
                "        \"businessType\": 11,\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237489052871,\n" +
                "                \"id\": 5177657132858006120,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 4.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237405166793,\n" +
                "                \"id\": 5177657132858006121,\n" +
                "                \"secOwnerId\": 1395869718239564346,\n" +
                "                \"unitTotalCount\": 12.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237434526916,\n" +
                "                \"id\": 5177657132858006122,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237229006029,\n" +
                "                \"id\": 5177657132858006123,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237518412998,\n" +
                "                \"id\": 5177657132858006124,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237262560451,\n" +
                "                \"id\": 5177657132858006125,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 4.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237291920579,\n" +
                "                \"id\": 5177657132858006126,\n" +
                "                \"secOwnerId\": 1395869718239573031,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237350640834,\n" +
                "                \"id\": 5177657132858006127,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 4.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237547773133,\n" +
                "                \"id\": 5177657132858006128,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237380000968,\n" +
                "                \"id\": 5177657132858006129,\n" +
                "                \"secOwnerId\": 1395869718239571944,\n" +
                "                \"unitTotalCount\": 12.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237321280709,\n" +
                "                \"id\": 5177657132858006130,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237577133248,\n" +
                "                \"id\": 5177657132858006131,\n" +
                "                \"secOwnerId\": 1395869718239563092,\n" +
                "                \"unitTotalCount\": 12.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237631659204,\n" +
                "                \"id\": 5177657132858006132,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237606493383,\n" +
                "                \"id\": 5177657132858006133,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237661019341,\n" +
                "                \"id\": 5177657132858006134,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 1.000000\n" +
                "            },\n" +
                "            {\n" +
                "                \"businessItemId\": 5177158237459692740,\n" +
                "                \"id\": 5177657132858006135,\n" +
                "                \"secOwnerId\": 1,\n" +
                "                \"unitTotalCount\": 6.000000\n" +
                "            }\n" +
                "        ],\n" +
                "        \"orgId\": 476,\n" +
                "        \"warehouseId\": 4761,\n" +
                "        \"wmsOrderType\": 105\n" +
                "    }";
        NewData newData = JSON.parseObject(json, NewData.class);
        return newData;

    }


    private static TrainsOutStockDTO getOutData(){
        String json = "{\"cityId\":476,\"deliveryCarNumber\":\"CK476123041100017\",\"deliveryTaskChangeFetchOrderList\":[{\"deliveryTaskChangeFetchOrderItemList\":[{\"orderId\":5177158237001564195,\"orderItemId\":5177158237229006029,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237262560451,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237291920579,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237321280709,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237350640834,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237380000968,\"scheduleUnitTotalCount\":12.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237405166793,\"scheduleUnitTotalCount\":12.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237434526916,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237459692740,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237489052871,\"scheduleUnitTotalCount\":4.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237518412998,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237547773133,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237577133248,\"scheduleUnitTotalCount\":12.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237606493383,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237631659204,\"scheduleUnitTotalCount\":6.0},{\"orderId\":5177158237001564195,\"orderItemId\":5177158237661019341,\"scheduleUnitTotalCount\":1.0}],\"fetchOrderId\":4760392304111608499}],\"deliveryTaskId\":\"5177628642481968353\",\"optUserId\":\"42457\",\"outStockTime\":1681210028955,\"trainsOutStockOrderList\":[{\"orderId\":5177158237001564195,\"orderType\":3,\"outStockOrderId\":5177158239106842664,\"outStockOrderType\":1,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5177158237229006029,\"outStockOrderItemId\":5177158239112779462,\"trainsOutStockDealerList\":[{\"productSpecificationId\":147367,\"secOwnerId\":1,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237262560451,\"outStockOrderItemId\":5177158239142139587,\"trainsOutStockDealerList\":[{\"productSpecificationId\":390370,\"secOwnerId\":1,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":5177158237291920579,\"outStockOrderItemId\":5177158239158916803,\"trainsOutStockDealerList\":[{\"productSpecificationId\":161386,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237321280709,\"outStockOrderItemId\":5177158239175694026,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10927,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237350640834,\"outStockOrderItemId\":5177158239192471233,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10922,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":5177158237380000968,\"outStockOrderItemId\":5177158239209248451,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17774,\"unitTotalCount\":12.0}],\"unitTotalCount\":12.0},{\"orderItemId\":5177158237405166793,\"outStockOrderItemId\":5177158239226025670,\"trainsOutStockDealerList\":[{\"productSpecificationId\":7876,\"unitTotalCount\":12.0}],\"unitTotalCount\":12.0},{\"orderItemId\":5177158237434526916,\"outStockOrderItemId\":5177158239242802890,\"trainsOutStockDealerList\":[{\"productSpecificationId\":41029,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237459692740,\"outStockOrderItemId\":5177158239259580104,\"trainsOutStockDealerList\":[{\"productSpecificationId\":16764,\"secOwnerId\":1,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237489052871,\"outStockOrderItemId\":5177158239280551626,\"trainsOutStockDealerList\":[{\"productSpecificationId\":36322,\"unitTotalCount\":4.0}],\"unitTotalCount\":4.0},{\"orderItemId\":5177158237518412998,\"outStockOrderItemId\":5177158239293134531,\"trainsOutStockDealerList\":[{\"productSpecificationId\":17158,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237547773133,\"outStockOrderItemId\":5177158239309911745,\"trainsOutStockDealerList\":[{\"productSpecificationId\":10924,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237577133248,\"outStockOrderItemId\":5177158239326688971,\"trainsOutStockDealerList\":[{\"productSpecificationId\":23759,\"unitTotalCount\":12.0}],\"unitTotalCount\":12.0},{\"orderItemId\":5177158237606493383,\"outStockOrderItemId\":5177158239339271874,\"trainsOutStockDealerList\":[{\"productSpecificationId\":51129,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237631659204,\"outStockOrderItemId\":5177158239356049092,\"trainsOutStockDealerList\":[{\"productSpecificationId\":77558,\"secOwnerId\":1,\"unitTotalCount\":6.0}],\"unitTotalCount\":6.0},{\"orderItemId\":5177158237661019341,\"outStockOrderItemId\":5177158239368632014,\"trainsOutStockDealerList\":[{\"productSpecificationId\":514813,\"secOwnerId\":1,\"unitTotalCount\":1.0}],\"unitTotalCount\":1.0}]}],\"warehouseId\":4761}";
        TrainsOutStockDTO trainsOutStockDTO = JSON.parseObject(json, TrainsOutStockDTO.class);
        return trainsOutStockDTO;
    }


    private static OrderDocumentDTO getOmsData(){
        String json="{\n" +
                "    \"orderBase\": {\n" +
                "        \"businessId\": \"4000002304061804665\",\n" +
                "        \"companyCode\": \"YJP\",\n" +
                "        \"createTime\": \"1681091083000\",\n" +
                "        \"firstOrderType\": 3,\n" +
                "        \"lastUpdateTime\": \"1681808005000\",\n" +
                "        \"orderCreateTime\": \"1681091083000\",\n" +
                "        \"orderId\": \"5177158237001564195\",\n" +
                "        \"orderNo\": \"NPT476309600005\",\n" +
                "        \"orgId\": 476,\n" +
                "        \"partnerCode\": \"YJP-ERP\",\n" +
                "        \"printTimes\": 0,\n" +
                "        \"secOrderType\": 30001,\n" +
                "        \"shortOrderNo\": \"00001\",\n" +
                "        \"state\": 409\n" +
                "    },\n" +
                "    \"orderConsignor\": {\n" +
                "        \"city\": \"蚌埠市\",\n" +
                "        \"consignor\": \"无\",\n" +
                "        \"consignorPhone\": \"15651038101\",\n" +
                "        \"county\": \"蚌山区\",\n" +
                "        \"createTime\": \"1681091083000\",\n" +
                "        \"detailAddress\": \"安徽省蚌埠市蚌山区朝阳街道\",\n" +
                "        \"lastUpdateTime\": \"1681091083000\",\n" +
                "        \"latitude\": 32.976194,\n" +
                "        \"longitude\": 117.314164,\n" +
                "        \"orderId\": \"5177158237001564195\",\n" +
                "        \"partnerCode\": \"YJP-ERP\",\n" +
                "        \"province\": \"安徽省\",\n" +
                "        \"street\": \"朝阳街道\"\n" +
                "    },\n" +
                "    \"orderContact\": {\n" +
                "        \"addressId\": 0,\n" +
                "        \"city\": \"合肥市\",\n" +
                "        \"contact\": \"无\",\n" +
                "        \"contactPhone\": \"15955486984\",\n" +
                "        \"county\": \"包河区\",\n" +
                "        \"createTime\": \"1681091083000\",\n" +
                "        \"detailAddress\": \"安徽省合肥市包河区宿松路与卧云路交叉口，凌江汽车座椅园区内\",\n" +
                "        \"lastUpdateTime\": \"1681091083000\",\n" +
                "        \"latitude\": 31.72979,\n" +
                "        \"longitude\": 117.264105,\n" +
                "        \"orderId\": \"5177158237001564195\",\n" +
                "        \"partnerCode\": \"YJP-ERP\",\n" +
                "        \"province\": \"安徽省\",\n" +
                "        \"street\": \"宿松路与卧云路交叉口，凌江汽车座椅园区内\",\n" +
                "        \"userId\": \"0\"\n" +
                "    },\n" +
                "    \"orderDelivery\": {\n" +
                "        \"arriveTime\": \"1681808005000\",\n" +
                "        \"createTime\": \"1681091083000\",\n" +
                "        \"deliveryCarId\": \"8029655800563427635\",\n" +
                "        \"deliveryCarName\": \"樊光辉苏ATV685\",\n" +
                "        \"deliveryMode\": 0,\n" +
                "        \"deliveryTaskId\": \"5177628642481968353\",\n" +
                "        \"deliveryTime\": \"1681808001000\",\n" +
                "        \"deliveryUserId\": 101249,\n" +
                "        \"deliveryUserName\": \"樊光辉\",\n" +
                "        \"id\": \"5177158237094253449\",\n" +
                "        \"lastUpdateTime\": \"1681808035000\",\n" +
                "        \"orderId\": \"5177158237001564195\",\n" +
                "        \"partnerCode\": \"YJP-ERP\",\n" +
                "        \"pickUpTime\": \"1681808001000\"\n" +
                "    },\n" +
                "    \"orderDeliverys\": [\n" +
                "        {\n" +
                "            \"arriveTime\": \"1681808005000\",\n" +
                "            \"createTime\": \"1681091083000\",\n" +
                "            \"deliveryCarId\": \"8029655800563427635\",\n" +
                "            \"deliveryCarName\": \"樊光辉苏ATV685\",\n" +
                "            \"deliveryMode\": 0,\n" +
                "            \"deliveryTaskId\": \"5177628642481968353\",\n" +
                "            \"deliveryTime\": \"1681808001000\",\n" +
                "            \"deliveryUserId\": 101249,\n" +
                "            \"deliveryUserName\": \"樊光辉\",\n" +
                "            \"id\": \"5177158237094253449\",\n" +
                "            \"lastUpdateTime\": \"1681808035000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-ERP\",\n" +
                "            \"pickUpTime\": \"1681808001000\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"orderId\": \"5177158237001564195\",\n" +
                "    \"orderItems\": [\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237229006029\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895134\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237229006029\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 22.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 22.0,\n" +
                "                \"priceUnit\": \"袋\",\n" +
                "                \"productName\": \"乐事薯片金黄炒蟹味70g\",\n" +
                "                \"productSkuId\": \"40000147367843\",\n" +
                "                \"productSpec\": \"22袋/件\",\n" +
                "                \"productSpecificationId\": 147367,\n" +
                "                \"saleSpec\": \"1袋/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"袋\",\n" +
                "                \"statisticsCategoryName\": \"膨化食品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"袋\",\n" +
                "                \"warehouseProductSkuId\": \"47600147367368\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237229006029\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237262560451\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895135\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 4.0,\n" +
                "                \"deliveryCount\": 4.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237262560451\",\n" +
                "                \"originalCount\": 4.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 4.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 48.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 48.0,\n" +
                "                \"priceUnit\": \"盒\",\n" +
                "                \"productName\": \"好丽友派清新抹茶本味2枚72g\",\n" +
                "                \"productSkuId\": \"4885447965175113883\",\n" +
                "                \"productSpec\": \"48盒/件\",\n" +
                "                \"productSpecificationId\": 390370,\n" +
                "                \"saleSpec\": \"1盒/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"盒\",\n" +
                "                \"statisticsCategoryName\": \"饼干糕点\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"盒\",\n" +
                "                \"warehouseProductSkuId\": \"4920346120243059163\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237262560451\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237291920579\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895136\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237291920579\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 60.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 60.0,\n" +
                "                \"priceUnit\": \"袋\",\n" +
                "                \"productName\": \"福久福五香花生米120g\",\n" +
                "                \"productSkuId\": \"40000161386015\",\n" +
                "                \"productSpec\": \"60袋/件\",\n" +
                "                \"productSpecificationId\": 161386,\n" +
                "                \"saleSpec\": \"1袋/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"袋\",\n" +
                "                \"statisticsCategoryName\": \"坚果蜜饯\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"袋\",\n" +
                "                \"warehouseProductSkuId\": \"47600161386893\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237291920579\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237321280709\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895138\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237321280709\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 30.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 30.0,\n" +
                "                \"priceUnit\": \"盒\",\n" +
                "                \"productName\": \"好丽友好多鱼浓香茄汁味33g\",\n" +
                "                \"productSkuId\": \"40000010927972\",\n" +
                "                \"productSpec\": \"30盒/件\",\n" +
                "                \"productSpecificationId\": 10927,\n" +
                "                \"saleSpec\": \"1盒/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"盒\",\n" +
                "                \"statisticsCategoryName\": \"饼干糕点\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"盒\",\n" +
                "                \"warehouseProductSkuId\": \"47600010927886\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237321280709\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237350640834\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895139\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 4.0,\n" +
                "                \"deliveryCount\": 4.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237350640834\",\n" +
                "                \"originalCount\": 4.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 4.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 48.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 48.0,\n" +
                "                \"priceUnit\": \"盒\",\n" +
                "                \"productName\": \"好丽友Q蒂蛋糕摩卡巧克力味2枚56g\",\n" +
                "                \"productSkuId\": \"40000010922405\",\n" +
                "                \"productSpec\": \"48盒/件\",\n" +
                "                \"productSpecificationId\": 10922,\n" +
                "                \"saleSpec\": \"1盒/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"盒\",\n" +
                "                \"statisticsCategoryName\": \"饼干糕点\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"盒\",\n" +
                "                \"warehouseProductSkuId\": \"47600010922151\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237350640834\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237380000968\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895140\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 12.0,\n" +
                "                \"deliveryCount\": 12.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237380000968\",\n" +
                "                \"originalCount\": 12.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 12.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 12.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 12.0,\n" +
                "                \"priceUnit\": \"件\",\n" +
                "                \"productName\": \"恒顺料酒500ml\",\n" +
                "                \"productSkuId\": \"40000017774015\",\n" +
                "                \"productSpec\": \"12瓶/件\",\n" +
                "                \"productSpecificationId\": 17774,\n" +
                "                \"saleSpec\": \"1瓶/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"瓶\",\n" +
                "                \"statisticsCategoryName\": \"调味品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"瓶\",\n" +
                "                \"warehouseProductSkuId\": \"47600017774855\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237380000968\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237405166793\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895141\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 12.0,\n" +
                "                \"deliveryCount\": 12.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237405166793\",\n" +
                "                \"originalCount\": 12.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 12.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 12.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 12.0,\n" +
                "                \"priceUnit\": \"件\",\n" +
                "                \"productName\": \"海天特级金标生抽（塑料瓶）500ml\",\n" +
                "                \"productSkuId\": \"40000007876455\",\n" +
                "                \"productSpec\": \"12瓶/件\",\n" +
                "                \"productSpecificationId\": 7876,\n" +
                "                \"saleSpec\": \"1瓶/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"瓶\",\n" +
                "                \"statisticsCategoryName\": \"调味品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"瓶\",\n" +
                "                \"warehouseProductSkuId\": \"47600007876524\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237405166793\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237434526916\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895142\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237434526916\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 24.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 24.0,\n" +
                "                \"priceUnit\": \"罐\",\n" +
                "                \"productName\": \"乐事无限薯片翡翠黄瓜味40g（罐装）\",\n" +
                "                \"productSkuId\": \"40000041029893\",\n" +
                "                \"productSpec\": \"24罐/件\",\n" +
                "                \"productSpecificationId\": 41029,\n" +
                "                \"saleSpec\": \"1罐/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"罐\",\n" +
                "                \"statisticsCategoryName\": \"膨化食品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"罐\",\n" +
                "                \"warehouseProductSkuId\": \"47600041029482\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237434526916\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237459692740\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895143\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237459692740\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 20.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 20.0,\n" +
                "                \"priceUnit\": \"袋\",\n" +
                "                \"productName\": \"上好佳田园薯片甜辣口味50g\",\n" +
                "                \"productSkuId\": \"40000016764097\",\n" +
                "                \"productSpec\": \"20袋/件\",\n" +
                "                \"productSpecificationId\": 16764,\n" +
                "                \"saleSpec\": \"1袋/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"袋\",\n" +
                "                \"statisticsCategoryName\": \"膨化食品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"袋\",\n" +
                "                \"warehouseProductSkuId\": \"47600016764118\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237459692740\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237489052871\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895144\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 4.0,\n" +
                "                \"deliveryCount\": 4.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237489052871\",\n" +
                "                \"originalCount\": 4.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 4.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 16.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 16.0,\n" +
                "                \"priceUnit\": \"盒\",\n" +
                "                \"productName\": \"好丽友巧克力派6枚204g\",\n" +
                "                \"productSkuId\": \"40000036322830\",\n" +
                "                \"productSpec\": \"16盒/件\",\n" +
                "                \"productSpecificationId\": 36322,\n" +
                "                \"saleSpec\": \"1盒/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"盒\",\n" +
                "                \"statisticsCategoryName\": \"饼干糕点\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"盒\",\n" +
                "                \"warehouseProductSkuId\": \"47600036322662\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237489052871\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237518412998\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895145\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237518412998\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 22.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 22.0,\n" +
                "                \"priceUnit\": \"袋\",\n" +
                "                \"productName\": \"乐事大波浪薯片碳烤五花肉味70g\",\n" +
                "                \"productSkuId\": \"40000017158271\",\n" +
                "                \"productSpec\": \"22袋/件\",\n" +
                "                \"productSpecificationId\": 17158,\n" +
                "                \"saleSpec\": \"1袋/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"袋\",\n" +
                "                \"statisticsCategoryName\": \"膨化食品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"袋\",\n" +
                "                \"warehouseProductSkuId\": \"47600017158180\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237518412998\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237547773133\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895146\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237547773133\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 48.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 48.0,\n" +
                "                \"priceUnit\": \"盒\",\n" +
                "                \"productName\": \"好丽友蛋黄派2枚46g\",\n" +
                "                \"productSkuId\": \"40000010924575\",\n" +
                "                \"productSpec\": \"48盒/件\",\n" +
                "                \"productSpecificationId\": 10924,\n" +
                "                \"saleSpec\": \"1盒/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"盒\",\n" +
                "                \"statisticsCategoryName\": \"饼干糕点\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"盒\",\n" +
                "                \"warehouseProductSkuId\": \"47600010924259\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237547773133\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237577133248\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895147\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 12.0,\n" +
                "                \"deliveryCount\": 12.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237577133248\",\n" +
                "                \"originalCount\": 12.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 12.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 12.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 12.0,\n" +
                "                \"priceUnit\": \"件\",\n" +
                "                \"productName\": \"恒顺镇江香醋新B香500ml\",\n" +
                "                \"productSkuId\": \"40000023759502\",\n" +
                "                \"productSpec\": \"12瓶/件\",\n" +
                "                \"productSpecificationId\": 23759,\n" +
                "                \"saleSpec\": \"1瓶/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"瓶\",\n" +
                "                \"statisticsCategoryName\": \"调味品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"瓶\",\n" +
                "                \"warehouseProductSkuId\": \"47600023759556\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237577133248\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237606493383\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895148\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237606493383\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 50.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 50.0,\n" +
                "                \"priceUnit\": \"袋\",\n" +
                "                \"productName\": \"乐事大波浪薯片辛辣味40g\",\n" +
                "                \"productSkuId\": \"40000051129134\",\n" +
                "                \"productSpec\": \"50袋/件\",\n" +
                "                \"productSpecificationId\": 51129,\n" +
                "                \"saleSpec\": \"1袋/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"袋\",\n" +
                "                \"statisticsCategoryName\": \"膨化食品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"袋\",\n" +
                "                \"warehouseProductSkuId\": \"47600051129490\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237606493383\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237631659204\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895149\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 6.0,\n" +
                "                \"deliveryCount\": 6.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237631659204\",\n" +
                "                \"originalCount\": 6.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 6.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 50.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 50.0,\n" +
                "                \"priceUnit\": \"袋\",\n" +
                "                \"productName\": \"乐事大波浪薯片美国经典原味40g\",\n" +
                "                \"productSkuId\": \"4988021846337787660\",\n" +
                "                \"productSpec\": \"50袋/件\",\n" +
                "                \"productSpecificationId\": 77558,\n" +
                "                \"saleSpec\": \"1袋/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"袋\",\n" +
                "                \"statisticsCategoryName\": \"膨化食品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"袋\",\n" +
                "                \"warehouseProductSkuId\": \"5002264028222083028\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237631659204\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": \"5177158237661019341\",\n" +
                "            \"orderItemBase\": {\n" +
                "                \"businessItemId\": \"4000012304061895150\",\n" +
                "                \"cost\": 0.0,\n" +
                "                \"count\": 1.0,\n" +
                "                \"deliveryCount\": 1.0,\n" +
                "                \"gift\": false,\n" +
                "                \"inStockCount\": 0.0,\n" +
                "                \"orderId\": \"5177158237001564195\",\n" +
                "                \"orderItemId\": \"5177158237661019341\",\n" +
                "                \"originalCount\": 1.0,\n" +
                "                \"originalPrice\": 0.0,\n" +
                "                \"outStockCount\": 1.0,\n" +
                "                \"packageName\": \"件\",\n" +
                "                \"packageQuantity\": 14.0,\n" +
                "                \"price\": 0.0,\n" +
                "                \"priceQuantity\": 14.0,\n" +
                "                \"priceUnit\": \"袋\",\n" +
                "                \"productName\": \"乐事薯片醇香黑松露味116g\",\n" +
                "                \"productSkuId\": \"5106154512517462150\",\n" +
                "                \"productSpec\": \"14袋/件\",\n" +
                "                \"productSpecificationId\": 514813,\n" +
                "                \"saleSpec\": \"1袋/件\",\n" +
                "                \"saleSpecQuantity\": 1.0,\n" +
                "                \"saleUnit\": \"袋\",\n" +
                "                \"statisticsCategoryName\": \"膨化食品\",\n" +
                "                \"takeCount\": 0.0,\n" +
                "                \"unitName\": \"袋\",\n" +
                "                \"warehouseProductSkuId\": \"5175847339620429162\"\n" +
                "            },\n" +
                "            \"orderItemId\": \"5177158237661019341\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"orderPick\": {\n" +
                "        \"createTime\": \"1681091083000\",\n" +
                "        \"defaultLocationId\": \"1683793659363495276\",\n" +
                "        \"defaultLocationName\": \"ZZ601-01\",\n" +
                "        \"fromOrgId\": 476,\n" +
                "        \"fromWarehouseId\": 4761,\n" +
                "        \"lastUpdateTime\": \"1681210029000\",\n" +
                "        \"orderId\": \"5177158237001564195\",\n" +
                "        \"orgId\": 400,\n" +
                "        \"outStockTime\": \"1681210029000\",\n" +
                "        \"partnerCode\": \"YJP-ERP\",\n" +
                "        \"stevedoreUserName\": \"吴德旋\",\n" +
                "        \"warehouseId\": 4001,\n" +
                "        \"waveNo\": \"BC476123041100002\"\n" +
                "    },\n" +
                "    \"orderTraces\": [\n" +
                "        {\n" +
                "            \"createTime\": \"1681091083000\",\n" +
                "            \"id\": \"5177158238233928459\",\n" +
                "            \"lastUpdateTime\": \"1681091083000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-WMS\",\n" +
                "            \"tags\": {},\n" +
                "            \"traceName\": \"创建订单\",\n" +
                "            \"traceType\": 2000\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681203236000\",\n" +
                "            \"id\": \"5177628642712623520\",\n" +
                "            \"lastUpdateTime\": \"1681203236000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-TMS\",\n" +
                "            \"tags\": {},\n" +
                "            \"traceName\": \"订单装车\",\n" +
                "            \"traceType\": 20000,\n" +
                "            \"userTraceTxt\": \"订单装车，车辆：自带车(苏ATV685)，司机：樊光辉，操作人:吴德旋\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681203250000\",\n" +
                "            \"defaultTraceTxt\": \"创建出库批次，批次号：CK476123041100017\",\n" +
                "            \"id\": \"5177628701235467490\",\n" +
                "            \"lastUpdateTime\": \"1681203250000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-WMS\",\n" +
                "            \"systemTraceTxt\": \"创建出库批次，批次号：CK476123041100017\",\n" +
                "            \"tags\": {\n" +
                "                \"orderNo\": \"CK476123041100017\"\n" +
                "            },\n" +
                "            \"traceName\": \"创建出库批次\",\n" +
                "            \"traceType\": 10000,\n" +
                "            \"userTraceTxt\": \"创建出库批次，批次号：CK476123041100017\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681203251000\",\n" +
                "            \"defaultTraceTxt\": \"波次创建成功，波次号: BC476123041100002\",\n" +
                "            \"id\": \"5177628702351432102\",\n" +
                "            \"lastUpdateTime\": \"1681203251000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-WMS\",\n" +
                "            \"systemTraceTxt\": \"波次创建成功，波次号: BC476123041100002\",\n" +
                "            \"tags\": {\n" +
                "                \"opUserId\": \"吴德旋\",\n" +
                "                \"orderNo\": \"BC476123041100002\"\n" +
                "            },\n" +
                "            \"traceName\": \"创建波次\",\n" +
                "            \"traceType\": 10001,\n" +
                "            \"userTraceTxt\": \"波次创建成功，波次号: BC476123041100002\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681203776000\",\n" +
                "            \"defaultTraceTxt\": \"仓库完成拣货\",\n" +
                "            \"id\": \"5177630904360752356\",\n" +
                "            \"lastUpdateTime\": \"1681203776000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-WMS\",\n" +
                "            \"systemTraceTxt\": \"仓库完成拣货\",\n" +
                "            \"tags\": {\n" +
                "                \"opUserId\": \"吴德旋\"\n" +
                "            },\n" +
                "            \"traceName\": \"完成拣货\",\n" +
                "            \"traceType\": 10003,\n" +
                "            \"userTraceTxt\": \"仓库完成拣货\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681210029000\",\n" +
                "            \"defaultTraceTxt\": \"仓库确认出库，批次号：CK476123041100017\",\n" +
                "            \"id\": \"5177657133306598625\",\n" +
                "            \"lastUpdateTime\": \"1681210029000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-WMS\",\n" +
                "            \"systemTraceTxt\": \"仓库确认出库，批次号：CK476123041100017\",\n" +
                "            \"tags\": {\n" +
                "                \"opUserId\": \"吴德旋\",\n" +
                "                \"orderNo\": \"CK476123041100017\"\n" +
                "            },\n" +
                "            \"traceName\": \"已出库通知\",\n" +
                "            \"traceType\": 10004,\n" +
                "            \"userTraceTxt\": \"仓库确认出库，批次号：CK476123041100017\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681210029000\",\n" +
                "            \"id\": \"5177657133399153064\",\n" +
                "            \"lastUpdateTime\": \"1681210029000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-TMS\",\n" +
                "            \"tags\": {},\n" +
                "            \"traceName\": \"司机确认取货\",\n" +
                "            \"traceType\": 20103,\n" +
                "            \"userTraceTxt\": \"司机确认取货，调度任务号：ST476120230411000217，取货单号：Q476120230411000232，操作人:吴德旋\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681808002000\",\n" +
                "            \"id\": \"5180165213205860039\",\n" +
                "            \"lastUpdateTime\": \"1681808002000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-TMS\",\n" +
                "            \"tags\": {},\n" +
                "            \"traceName\": \"司机确认发车\",\n" +
                "            \"traceType\": 20001,\n" +
                "            \"userTraceTxt\": \"司机确认发车，车次号：DB47620230411000065，操作人：樊光辉\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681808005000\",\n" +
                "            \"id\": \"5180165226641159529\",\n" +
                "            \"lastUpdateTime\": \"1681808005000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-TMS\",\n" +
                "            \"tags\": {},\n" +
                "            \"traceName\": \"订单确认送达\",\n" +
                "            \"traceType\": 20005,\n" +
                "            \"userTraceTxt\": \"订单确认送达，操作人：樊光辉\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681808005000\",\n" +
                "            \"id\": \"5180165226791210702\",\n" +
                "            \"lastUpdateTime\": \"1681808005000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-TMS\",\n" +
                "            \"tags\": {},\n" +
                "            \"traceName\": \"车次配送完成\",\n" +
                "            \"traceType\": 20002,\n" +
                "            \"userTraceTxt\": \"车次配送完成，操作人：樊光辉\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"createTime\": \"1681808035000\",\n" +
                "            \"id\": \"5180165352871988938\",\n" +
                "            \"lastUpdateTime\": \"1681808035000\",\n" +
                "            \"orderId\": \"5177158237001564195\",\n" +
                "            \"partnerCode\": \"YJP-ERP\",\n" +
                "            \"tags\": {\n" +
                "                \"arriveDeliveryTime\": 1.681808005E+12,\n" +
                "                \"deliveryCarId\": 8.0296558005634273E+18,\n" +
                "                \"deliveryCarName\": \"樊光辉苏ATV685\",\n" +
                "                \"deliveryUserId\": 101249.0,\n" +
                "                \"deliveryUserMobile\": \"18755242400\",\n" +
                "                \"deliveryUserName\": \"樊光辉\",\n" +
                "                \"optUserId\": \"101249\"\n" +
                "            },\n" +
                "            \"traceName\": \"确认送达通知\",\n" +
                "            \"traceType\": 6000\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        OrderDocumentDTO orderDocumentDTO = JSON.parseObject(json, OrderDocumentDTO.class);
        return orderDocumentDTO;
    }
}
