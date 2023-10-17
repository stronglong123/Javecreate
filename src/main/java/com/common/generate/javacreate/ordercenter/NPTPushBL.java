package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.ordercenter.dto.ERPTransferOrderDTO;
import com.common.generate.javacreate.ordercenter.dto.ERPTransferOrderItemDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemOwnerDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemSecOwnerAllocateDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderItemBaseDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderitemdocument.OrderItemDocumentDTO;
import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/7/20 15:56
 */
public class NPTPushBL {

    private static final String Cookie = "YJPINFO=ba028711-56b4-4b14-b88a-a41e16694c7a; YID=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODM4NCIsImlzcyI6InNzbyIsImV4cCI6MTY4OTg0MjU3Nn0.44DHiZpBmnowytSs3Bpq0XR9NtrmmDj_julxuLR6d3o";

    private static final String baseUrl = "http://console.pre.yijiupi.com";


    public static void main(String[] args){
        List<String> orderNos = Arrays.asList("123328100035","123328100034");
//        List<String> orderNos = Arrays.asList("DT414323800054", "DT414323800053", "DT414323900077", "DT461323900021", "DT461323900025-1", "DT414323800057");
        for (String orderNo : orderNos) {
            fixNPT(orderNo);
        }
//        fixNPT("DT164316000010");
    }


    @SneakyThrows
    public static void fixNPT(String orderNo){
        List<OrderDocumentDTO> returnOrders = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderNo\":\"" + orderNo + "\",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
        if(CollectionUtils.isEmpty(returnOrders)||returnOrders.size()>1){
            System.out.println("退货单据异常"+orderNo);
        }
        OrderDocumentDTO returnOrder = returnOrders.get(0);
        Long returnOrderId = returnOrder.getOrderBase().getOrderId();
        String returnOrderNo = returnOrder.getOrderBase().getOrderNo();
        Long saleorderId = returnOrder.getOrderReturn().getRefOrderId();

        List<OrderDocumentDTO> saleOrders = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderId\":" + saleorderId + ",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
        if(CollectionUtils.isEmpty(saleOrders)||saleOrders.size()>1){
            System.out.println("销售单据异常"+orderNo);
        }
        OrderDocumentDTO saleOrder = saleOrders.get(0);

        List<OrderDTO> secOwnerItems = NewApiTest.getOrderWithItemOwners("pre", "[\n" + "    [\n" + +returnOrderId + "    ]\n" + "]");
        OrderDTO orderDTO = secOwnerItems.get(0);
        Map<Long, List<OrderItemOwnerDTO>> itemOwnerMap = orderDTO.getOrderItems().stream().collect(Collectors.toMap(it -> it.getOrderItemId(), it -> it.getOrderItemOwners()));

        ERPTransferOrderDTO erpTransferOrderDTO = new ERPTransferOrderDTO();
        erpTransferOrderDTO.setBusinessNo("NPT"+returnOrderNo);
        erpTransferOrderDTO.setBusinessId(returnOrderId.toString());
        erpTransferOrderDTO.setFromOrgId(returnOrder.getOrderPick().getOrgId());
        erpTransferOrderDTO.setFromWarehouseId(returnOrder.getOrderPick().getWarehouseId());
        erpTransferOrderDTO.setOrderCreateTime(new Date());
        erpTransferOrderDTO.setOrgId(saleOrder.getOrderPick().getOrgId());
        erpTransferOrderDTO.setWarehouseId(saleOrder.getOrderPick().getWarehouseId());
        erpTransferOrderDTO.setTransferType(2);

        if(erpTransferOrderDTO.getWarehouseId().equals(erpTransferOrderDTO.getFromWarehouseId())){
            throw new BusinessValidateException("仓库id一样,不能生成内配退"+returnOrderNo);
        }

        List<ERPTransferOrderItemDTO> items = new ArrayList<>();
        for (OrderItemDocumentDTO returnOrderItemDTO : returnOrder.getOrderItems()) {
            OrderItemBaseDTO orderItemBaseDTO = returnOrderItemDTO.getOrderItemBase();
            if (orderItemBaseDTO == null) {
                throw new BusinessValidateException(
                        String.format("订单明细不存在,明细id=%s,订单id=%s", orderItemBaseDTO.getOrderItemId(), orderItemBaseDTO.getOrderId()));
            }
            ERPTransferOrderItemDTO itemDTO = new ERPTransferOrderItemDTO();
            itemDTO.setProductOwnerId(orderItemBaseDTO.getOwnerId());
            itemDTO.setBusinessItemId(orderItemBaseDTO.getOrderItemId().toString());
            itemDTO.setSpecificationId(orderItemBaseDTO.getProductSpecificationId());
            itemDTO.setProductSkuId(Long.valueOf(orderItemBaseDTO.getWarehouseProductSkuId()));
            itemDTO.setProductName(orderItemBaseDTO.getProductName());
            itemDTO.setSpecQuantity(orderItemBaseDTO.getPackageQuantity());
            itemDTO.setMinUnitTotalCount(orderItemBaseDTO.getCount());
            itemDTO.setSellPrice(BigDecimal.ZERO);
            itemDTO.setSellPriceUnit(orderItemBaseDTO.getPriceUnit());
            itemDTO.setPackageName(orderItemBaseDTO.getPackageName());
            itemDTO.setUnitName(orderItemBaseDTO.getUnitName());
            itemDTO.setTotalAmount(BigDecimal.ZERO);
            itemDTO.setPayAmount(BigDecimal.ZERO);
            itemDTO.setStatisticsCategoryName(orderItemBaseDTO.getStatisticsCategoryName());
            itemDTO.setSaleSpec(orderItemBaseDTO.getSaleSpec());
            itemDTO.setProductSpec(orderItemBaseDTO.getProductSpec());


            List<OrderItemSecOwnerAllocateDTO> itemSecOwnerAllocates = new ArrayList<>();
            List<OrderItemOwnerDTO> orderItemOwnerDTOS = itemOwnerMap.get(orderItemBaseDTO.getOrderItemId());
            BigDecimal secCount = orderItemOwnerDTOS.stream().map(it -> it.getCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            if(secCount.compareTo(itemDTO.getMinUnitTotalCount())!=0){
                throw new BusinessValidateException("明细与二级货主数量不一致,"+itemDTO.getBusinessItemId()+","+returnOrderNo);
            }
            for (OrderItemOwnerDTO orderItemOwnerDTO : orderItemOwnerDTOS) {
                OrderItemSecOwnerAllocateDTO secOwnerAllocateDTO = new OrderItemSecOwnerAllocateDTO();
                secOwnerAllocateDTO.setUnitTotalCount(orderItemOwnerDTO.getCount());
                secOwnerAllocateDTO.setSecOwnerId(orderItemOwnerDTO.getSecOwnerId());
                secOwnerAllocateDTO.setOrderItemId(orderItemBaseDTO.getOrderItemId());
                itemSecOwnerAllocates.add(secOwnerAllocateDTO);
            }

            itemDTO.setItemSecOwnerAllocates(itemSecOwnerAllocates);
            items.add(itemDTO);
        }
        erpTransferOrderDTO.setItems(items);

        System.out.println("内配退数据="+JSON.toJSONString(erpTransferOrderDTO));
        NewApiTest.addTransferOrder("pre",erpTransferOrderDTO);

    }


    public static void requeueWithBody(String params) {
        String url = baseUrl + "/Rabbit/DeadLetterRecover/requeueWithBody";
        String resultstr = HttpClientUtils.doPostWithCookie(Cookie, url, params);
        System.out.println(resultstr);
    }
}
