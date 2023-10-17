package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderPayConfirm;
import com.common.generate.javacreate.ordercenter.dto.data.BatchPayConfirmDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xialei
 * @date 2023/5/27 21:49
 */
public class PayConfirmBL {


    public static void main(String[] args){
//        BatchPayConfirmDTO data = getData();
//        List<Long> orderIds = data.getSaleOrderPayConfirms().stream().map(it -> it.getOrderId()).filter(Objects::nonNull).collect(Collectors.toList());
//
//
//        PushTmsPayConfirmDTO pushTmsPayConfirm =new PushTmsPayConfirmDTO();
//        pushTmsPayConfirm.setDeliveryTaskId(5143861414145228801L);
//        pushTmsPayConfirm.setOrderIds(Arrays.asList(5143504159428274117L));
//        pushTmsPayConfirm.setOptUserId(1L);
//        System.out.println(JSON.toJSONString(pushTmsPayConfirm));
//        NewApiTest.processConfirmReceiptAmount("pre",pushTmsPayConfirm);


//        BatchPayConfirmDTO batchPayConfirmDTO = getData();
//        System.out.println(JSON.toJSONString(batchPayConfirmDTO));
//        NewApiTest.batchPayConfirm("pre",batchPayConfirmDTO);

//        Map<Long, BigDecimal> map = new HashMap<>();
////        map.put(4580002309122185242L, BigDecimal.valueOf(67.5));
////        map.put(4580002309122185241L, BigDecimal.valueOf(84.2));
////        map.put(4580002309122185240L, BigDecimal.valueOf(95.3));
////        map.put(4580002309122185237L, BigDecimal.valueOf(323.8));
////        map.put(4060002309121242788L, BigDecimal.valueOf(437.7));
//        map.put(5235643384228437026L, BigDecimal.valueOf(260.7));
//
//
//        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
//            RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO =new RepairSaleOrderConfirmPayDTO();
//            repairSaleOrderConfirmPayDTO.setOptUserId(String.valueOf(67910761));
//            repairSaleOrderConfirmPayDTO.setOptUserName("67910761");
//            repairSaleOrderConfirmPayDTO.setOrderId(entry.getKey());
//            repairSaleOrderConfirmPayDTO.setPayAmount(entry.getValue());
//            repairSaleOrderConfirmPayDTO.setCollectionTime(new Date(1695261353113L));
//            System.out.println(JSON.toJSONString(repairSaleOrderConfirmPayDTO));
//            NewApiTest.orderPayConfirm("pre", repairSaleOrderConfirmPayDTO);
//        }
        singlePay();

    }


    private static BatchPayConfirmDTO getData() {
        String json = "{\"desc\":\"车次确认收款\",\"optUserId\":\"67910761\",\"returnOrderPayConfirms\":[{\"orderId\":5242030797900145633,\"payAmount\":9.33,\"payTime\":1696987698649},{\"orderId\":5242030797925284418,\"payAmount\":1.5,\"payTime\":1696987698649},{\"orderId\":5242030800299287521,\"payAmount\":7.1,\"payTime\":1696987698649},{\"orderId\":5242030800529974249,\"payAmount\":6.75,\"payTime\":1696987698649},{\"orderId\":5242030802690040814,\"payAmount\":64.38,\"payTime\":1696987698649},{\"orderId\":5242030805739272778,\"payAmount\":27.92,\"payTime\":1696987698649},{\"orderId\":5242030806611715043,\"payAmount\":17.7,\"payTime\":1696987698649},{\"orderId\":5242030808411071467,\"payAmount\":59.78,\"payTime\":1696987698649},{\"orderId\":5242030809086354414,\"payAmount\":47.15,\"payTime\":1696987698649},{\"orderId\":5242030811393221605,\"payAmount\":8.8,\"payTime\":1696987698649},{\"orderId\":5242030811900732384,\"payAmount\":23.0,\"payTime\":1696987698649},{\"orderId\":5242030814232765412,\"payAmount\":70.7,\"payTime\":1696987698649},{\"orderId\":5242031355578999777,\"payAmount\":21.6,\"payTime\":1696987698649}],\"saleOrderPayConfirms\":[{\"collectionTime\":1696987698649,\"orderId\":4010002310071530450,\"payAmount\":237.5},{\"collectionTime\":1696987698649,\"orderId\":4010002310071830579,\"payAmount\":210.98},{\"collectionTime\":1696987698649,\"orderId\":4010002310071830594,\"payAmount\":431.0},{\"collectionTime\":1696987698649,\"orderId\":4010002310071930635,\"payAmount\":468.4},{\"collectionTime\":1696987698649,\"orderId\":4010002310071930642,\"payAmount\":275.0},{\"collectionTime\":1696987698649,\"orderId\":4010002310071930643,\"payAmount\":264.0},{\"collectionTime\":1696987698649,\"orderId\":4010002310072030688,\"payAmount\":352.74},{\"collectionTime\":1696987698649,\"orderId\":4010002310072130718,\"payAmount\":562.8},{\"collectionTime\":1696987698649,\"orderId\":4010002310081130932,\"payAmount\":206.55},{\"collectionTime\":1696987698649,\"orderId\":4010002310081130945,\"payAmount\":243.2},{\"collectionTime\":1696987698649,\"orderId\":4010002310081230980,\"payAmount\":166.0},{\"collectionTime\":1696987698649,\"orderId\":4010002310081230981,\"payAmount\":180.0},{\"collectionTime\":1696987698649,\"orderId\":4010002310081431033,\"payAmount\":208.4},{\"collectionTime\":1696987698649,\"orderId\":4010002310081731186,\"payAmount\":160.3},{\"collectionTime\":1696987698649,\"orderId\":4010002310082231356,\"payAmount\":36.8},{\"collectionTime\":1696987698649,\"orderId\":4010002310082231357,\"payAmount\":4233.29},{\"collectionTime\":1696987698649,\"orderId\":4010002310090931419,\"payAmount\":232.5},{\"collectionTime\":1696987698649,\"orderId\":5242778930175206382,\"payAmount\":364.4},{\"collectionTime\":1696987698649,\"orderId\":5242782555106632675,\"payAmount\":246.0},{\"collectionTime\":1696987698649,\"orderId\":5242782557249894980,\"payAmount\":60.9},{\"collectionTime\":1696987698649,\"orderId\":5242783282549941230,\"payAmount\":380.5},{\"collectionTime\":1696987698649,\"orderId\":5242783284588372973,\"payAmount\":90.4},{\"collectionTime\":1696987698649,\"orderId\":5242787922997836356,\"payAmount\":456.0},{\"collectionTime\":1696987698649,\"orderId\":5242793923994117090,\"payAmount\":150.5},{\"collectionTime\":1696987698649,\"orderId\":5242826014429444685,\"payAmount\":204.2},{\"collectionTime\":1696987698649,\"orderId\":5242826016409156164,\"payAmount\":90.4},{\"collectionTime\":1696987698649,\"orderId\":5242864638416053230,\"payAmount\":950.0},{\"collectionTime\":1696987698649,\"orderId\":5242869194965285440,\"payAmount\":328.3},{\"collectionTime\":1696987698649,\"orderId\":5242919148878461518,\"payAmount\":272.1},{\"collectionTime\":1696987698649,\"orderId\":5242948476873925605,\"payAmount\":141.9},{\"collectionTime\":1696987698649,\"orderId\":5242948478471928386,\"payAmount\":150.2},{\"collectionTime\":1696987698649,\"orderId\":5242948479885408843,\"payAmount\":2922.8},{\"collectionTime\":1696987698649,\"orderId\":5243072574232912864,\"payAmount\":275.0},{\"collectionTime\":1696987698649,\"orderId\":5243121826770379745,\"payAmount\":278.7},{\"collectionTime\":1696987698649,\"orderId\":5243121828397769704,\"payAmount\":103.0},{\"collectionTime\":1696987698649,\"orderId\":5243161552957137896,\"payAmount\":836.1},{\"collectionTime\":1696987698649,\"orderId\":5243205459615081448,\"payAmount\":200.5},{\"collectionTime\":1696987698649,\"orderId\":5243205461385077729,\"payAmount\":51.5},{\"collectionTime\":1696987698649,\"orderId\":5243215372273744460,\"payAmount\":379.0},{\"collectionTime\":1696987698649,\"orderId\":5243217281789360705,\"payAmount\":597.8}],\"taskId\":\"5243207740712026669\"}";
        BatchPayConfirmDTO batchPayConfirmDTO = JSON.parseObject(json, BatchPayConfirmDTO.class);
        return batchPayConfirmDTO;
    }


    @SneakyThrows
    private static void singlePay(){

//        List<Long> repairIds = Arrays.asList(
//                4060002309261974008L,4060002309261974069L,4060002309271375458L,4060002309271475614L,4060002309272277012L,4060002309281378589L
//        );
        BatchPayConfirmDTO data = getData();
        Long optUserId = data.getOptUserId();
        List<Long> orderIds =new ArrayList<>();
        for (SaleOrderPayConfirm saleOrderPayConfirm : data.getSaleOrderPayConfirms()) {
//            if(!repairIds.contains(saleOrderPayConfirm.getOrderId())){
//                continue;
//            }
            Long orderId = saleOrderPayConfirm.getOrderId();
            OrderDocumentDTO orderDocumentDTO = NewApiTest.getOrderById("pre", orderId);
            if (orderDocumentDTO.getOrderBase().getState() == 700) {
                System.out.println("单据已完成,orderId=" + orderId);
                continue;
            }
            if(orderDocumentDTO.getOrderBase().getState() != 502){
                System.out.println("非配送完成不处理,orderId=" + orderId);
                continue;
            }
            orderIds.add(orderId);

//            RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO =new RepairSaleOrderConfirmPayDTO();
//            repairSaleOrderConfirmPayDTO.setOptUserId(String.valueOf(optUserId));
//            repairSaleOrderConfirmPayDTO.setOptUserName(data.getOptUserName());
//            repairSaleOrderConfirmPayDTO.setOrderId(saleOrderPayConfirm.getOrderId());
//            repairSaleOrderConfirmPayDTO.setPayAmount(saleOrderPayConfirm.getPayAmount());
//            repairSaleOrderConfirmPayDTO.setCollectionTime(saleOrderPayConfirm.getCollectionTime());
//            System.out.println(JSON.toJSONString(repairSaleOrderConfirmPayDTO));
//            NewApiTest.orderPayConfirm("pre", repairSaleOrderConfirmPayDTO);
//            Thread.sleep(200L);
        }
        System.out.println(orderIds);

//        List<ReturnOrderPayConfirm> returnOrderPayConfirms = data.getReturnOrderPayConfirms();
//        for (ReturnOrderPayConfirm returnOrderPayConfirm : returnOrderPayConfirms) {
//            orderIds.add(returnOrderPayConfirm.getOrderId());
//        }
//
//        PushTmsPayConfirmDTO pushTmsPayConfirm =new PushTmsPayConfirmDTO();
//        pushTmsPayConfirm.setDeliveryTaskId(data.getTaskId());
//        pushTmsPayConfirm.setOrderIds(orderIds);
//        pushTmsPayConfirm.setOptUserId(data.getOptUserId());
//        System.out.println(JSON.toJSONString(pushTmsPayConfirm));
//        NewApiTest.processConfirmReceiptAmount("pre",pushTmsPayConfirm);

    }
}
