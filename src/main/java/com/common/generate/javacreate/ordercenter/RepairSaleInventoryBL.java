package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.AllocateInventoryWithSecOwnerParam;
import com.common.generate.javacreate.ordercenter.dto.OwnerAllocateDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleInventoryAllocateDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleInventoryDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderBaseDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderPickDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderitemdocument.OrderItemBaseDocumentDTO;
import org.apache.curator.shaded.com.google.common.collect.Lists;
import org.elasticsearch.common.collect.HppcMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/10/30 20:53
 */
public class RepairSaleInventoryBL {


    public static void main(String[] args) {

        Long orderId = 5251630385861435598L;
        List<OwnerAllocateDTO> ownerList = NewApiTest.findProductOwnerByOrderIds("pre", orderId);
        Map<Long, OwnerAllocateDTO> ownerMap = ownerList.stream().collect(Collectors.toMap(it -> it.getOmsOrderItemId(), it -> it));

        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderId\":" + orderId + ",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
        OrderDocumentDTO orderDocumentDTO = orderList.get(0);
        OrderBaseDocumentDTO orderBase = orderDocumentDTO.getOrderBase();
        OrderPickDocumentDTO orderPick = orderDocumentDTO.getOrderPick();
        Map<Long, OrderItemBaseDocumentDTO> itemBaseMap = orderDocumentDTO.getOrderItems().stream().map(it -> it.getOrderItemBase()).collect(Collectors.toMap(it -> it.getOrderItemId(), it -> it));

        List<Long> ownerItemIdList = new ArrayList<>();
        List<Long> needItemIdList = new ArrayList<>();
        for (Map.Entry<Long, OrderItemBaseDocumentDTO> entry : itemBaseMap.entrySet()) {
            Long itemId = entry.getKey();
            OwnerAllocateDTO ownerAllocateDTO = ownerMap.get(itemId);
            if (ownerAllocateDTO == null) {
                needItemIdList.add(itemId);
            } else {
                ownerItemIdList.add(itemId);
            }
        }

        System.out.println("明细id无二级货主:" + needItemIdList.size());
        System.out.println("明细id有二级货主:" + ownerItemIdList.size());

        List<Long> inventoryIdList = new ArrayList<>();
        for (OwnerAllocateDTO ownerAllocateDTO : ownerList) {
            if(!ownerItemIdList.contains(ownerAllocateDTO.getOmsOrderItemId())){
                inventoryIdList.add(ownerAllocateDTO.getInventoryId());
            }
        }
//        Map<Long, OwnerAllocateDTO> inventoryOwnerMap = ownerList.stream().collect(Collectors.toMap(it -> it.getInventoryId(), it -> it));

        List<SaleInventoryDTO> saleInventoryDTOS = NewApiTest.findByInventoryIds("pre", inventoryIdList);
        Map<String, SaleInventoryDTO> saleInvetoryMap = saleInventoryDTOS.stream().collect(Collectors.toMap(it -> it.getProductSpecId() + "_" + it.getOwnerId(), it -> it));


        AllocateInventoryWithSecOwnerParam allocateInventoryParam = new AllocateInventoryWithSecOwnerParam();
        allocateInventoryParam.setOrderSource("YJP");
        allocateInventoryParam.setOrderId(orderBase.getOrderId());
        allocateInventoryParam.setOrderNo(orderBase.getOrderNo());
        allocateInventoryParam.setCityId(orderPick.getOrgId().intValue());
        allocateInventoryParam.setWarehouseId(orderPick.getWarehouseId().intValue());

        List<SaleInventoryAllocateDTO> orderItemSecOwnerInfos = new ArrayList<>();
        for (Long itemId : needItemIdList) {
            OrderItemBaseDocumentDTO orderItemBase = itemBaseMap.get(itemId);
            SaleInventoryDTO saleInventoryDTO = saleInvetoryMap.get(orderItemBase.getProductSpecificationId() + "_" + orderItemBase.getOwnerId());
            SaleInventoryAllocateDTO allocateDTO = new SaleInventoryAllocateDTO();
            allocateDTO.setOrderId(orderBase.getOrderId());
            allocateDTO.setOrderNo(orderBase.getOrderNo());
            allocateDTO.setOrderItemId(itemId);
            allocateDTO.setInventoryId(saleInventoryDTO.getId());
            allocateDTO.setCityId(orderPick.getOrgId().intValue());
            allocateDTO.setWarehouseId(orderPick.getWarehouseId().intValue());
            allocateDTO.setProductSpecId(orderItemBase.getProductSpecificationId());
            allocateDTO.setOwnerId(orderItemBase.getOwnerId());
            allocateDTO.setSecOwnerId(saleInventoryDTO.getSecOwnerId());
            allocateDTO.setAllocateCount(orderItemBase.getCount());
            orderItemSecOwnerInfos.add(allocateDTO);
        }
        allocateInventoryParam.setOrderItemSecOwnerInfos(orderItemSecOwnerInfos);
        System.out.println(JSON.toJSONString(allocateInventoryParam));

        NewApiTest.saveAllocatesSecOwner("pre",allocateInventoryParam);



    }
}
