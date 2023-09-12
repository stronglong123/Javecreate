package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.PushTmsPayConfirmDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderPayConfirm;
import lombok.Data;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<Long, BigDecimal> map = new HashMap<>();
        map.put(4010002308301905756L, BigDecimal.valueOf(696.8));
        map.put(4010002308301605581L, BigDecimal.valueOf(664.29));
        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO =new RepairSaleOrderConfirmPayDTO();
            repairSaleOrderConfirmPayDTO.setOptUserId(String.valueOf(68126516));
            repairSaleOrderConfirmPayDTO.setOptUserName("68126516");
            repairSaleOrderConfirmPayDTO.setOrderId(entry.getKey());
            repairSaleOrderConfirmPayDTO.setPayAmount(entry.getValue());
            repairSaleOrderConfirmPayDTO.setCollectionTime(new Date(1693658738728L));
            System.out.println(JSON.toJSONString(repairSaleOrderConfirmPayDTO));
            NewApiTest.orderPayConfirm("pre", repairSaleOrderConfirmPayDTO);
        }
//        singlePay();

    }


    private static BatchPayConfirmDTO getData() {
        String json = "{\"desc\":\"车次确认收款\",\"optUserId\":\"68029183\",\"saleOrderPayConfirms\":[{\"collectionTime\":1680223439579,\"orderId\":5172802868776876613,\"payAmount\":409.4},{\"collectionTime\":1680223439579,\"orderId\":5172815362064988750,\"payAmount\":560.8},{\"collectionTime\":1680223439579,\"orderId\":5172971184001915424,\"payAmount\":567.0},{\"collectionTime\":1680223439579,\"orderId\":5173017548635249196,\"payAmount\":400.4},{\"collectionTime\":1680223439579,\"orderId\":5173165262304787014,\"payAmount\":438.0},{\"collectionTime\":1680223439579,\"orderId\":5173169162395138638,\"payAmount\":347.0},{\"collectionTime\":1680223439579,\"orderId\":5173196017868479020,\"payAmount\":525.0},{\"collectionTime\":1680223439579,\"orderId\":5173200264697748009,\"payAmount\":744.8},{\"collectionTime\":1680223439579,\"orderId\":5173202631397554763,\"payAmount\":492.0}],\"taskId\":\"5173207844723791081\"}";
        BatchPayConfirmDTO batchPayConfirmDTO = JSON.parseObject(json, BatchPayConfirmDTO.class);
        return batchPayConfirmDTO;
    }


    @SneakyThrows
    private static void singlePay(){
        BatchPayConfirmDTO data = getData();
        Long optUserId = data.getOptUserId();
        List<Long> orderIds =new ArrayList<>();
        for (SaleOrderPayConfirm saleOrderPayConfirm : data.getSaleOrderPayConfirms()) {
            orderIds.add(saleOrderPayConfirm.getOrderId());

            RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO =new RepairSaleOrderConfirmPayDTO();
            repairSaleOrderConfirmPayDTO.setOptUserId(String.valueOf(optUserId));
            repairSaleOrderConfirmPayDTO.setOptUserName(data.getOptUserName());
            repairSaleOrderConfirmPayDTO.setOrderId(saleOrderPayConfirm.getOrderId());
            repairSaleOrderConfirmPayDTO.setPayAmount(saleOrderPayConfirm.getPayAmount());
            repairSaleOrderConfirmPayDTO.setCollectionTime(saleOrderPayConfirm.getCollectionTime());
            System.out.println(JSON.toJSONString(repairSaleOrderConfirmPayDTO));
            NewApiTest.orderPayConfirm("pre", repairSaleOrderConfirmPayDTO);
            Thread.sleep(500L);
        }

        PushTmsPayConfirmDTO pushTmsPayConfirm =new PushTmsPayConfirmDTO();
        pushTmsPayConfirm.setDeliveryTaskId(data.getTaskId());
        pushTmsPayConfirm.setOrderIds(orderIds);
        pushTmsPayConfirm.setOptUserId(data.getOptUserId());
        System.out.println(JSON.toJSONString(pushTmsPayConfirm));
        NewApiTest.processConfirmReceiptAmount("pre",pushTmsPayConfirm);

    }
}
