package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderPayConfirm;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
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
//        pushTmsPayConfirm.setDeliveryTaskId(data.getTaskId());
//        pushTmsPayConfirm.setOrderIds(orderIds);
//        pushTmsPayConfirm.setOptUserId(data.getOptUserId());
//        System.out.println(JSON.toJSONString(pushTmsPayConfirm));
//        NewApiTest.processConfirmReceiptAmount("pre",pushTmsPayConfirm);


//        BatchPayConfirmDTO batchPayConfirmDTO = getData();
//        System.out.println(JSON.toJSONString(batchPayConfirmDTO));
//        NewApiTest.batchPayConfirm("pre",batchPayConfirmDTO);

        Map<Long, BigDecimal> map = new HashMap<>();
//        map.put(1240002307111949082L, BigDecimal.valueOf(288));
        map.put(1190002307101141845L, BigDecimal.valueOf(205.63));
        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO =new RepairSaleOrderConfirmPayDTO();
            repairSaleOrderConfirmPayDTO.setOptUserId(String.valueOf(7432));
            repairSaleOrderConfirmPayDTO.setOptUserName("7432");
            repairSaleOrderConfirmPayDTO.setOrderId(entry.getKey());
            repairSaleOrderConfirmPayDTO.setPayAmount(entry.getValue());
            repairSaleOrderConfirmPayDTO.setCollectionTime(new Date(1689150504070L));
            System.out.println(JSON.toJSONString(repairSaleOrderConfirmPayDTO));
            NewApiTest.orderPayConfirm("pre", repairSaleOrderConfirmPayDTO);
        }
//        singlePay();

    }


    private static BatchPayConfirmDTO getData() {
        String json = "{\"saleOrderPayConfirms\":[{\"orderId\":5212155138355924647,\"payAmount\":1353.9,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212300127425695402,\"payAmount\":598.3,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212332559705214635,\"payAmount\":99.0,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212332561001254569,\"payAmount\":465.0,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212381101962464933,\"payAmount\":323.0,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212391310487359139,\"payAmount\":513.0,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212404980245254624,\"payAmount\":291.6,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212404982366506670,\"payAmount\":36.9,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212434564603874986,\"payAmount\":627.8,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212434566050909858,\"payAmount\":55.0,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212437177509532134,\"payAmount\":374.0,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212453834592276962,\"payAmount\":324.3,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212484975021969893,\"payAmount\":336.8,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212485639641927335,\"payAmount\":307.6,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212509392606236329,\"payAmount\":328.9,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":5212637001117765290,\"payAmount\":318.6,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307151672938,\"payAmount\":3811.07,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307151973019,\"payAmount\":758.2,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307151973041,\"payAmount\":225.87,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307151973061,\"payAmount\":30.2,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307152373237,\"payAmount\":50.0,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307160073253,\"payAmount\":1102.25,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307160973329,\"payAmount\":527.32,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"},{\"orderId\":7120002307160973345,\"payAmount\":217.75,\"collectionTime\":\"2023-07-18T09:22:11.179+08:00\"}],\"returnOrderPayConfirms\":null,\"awardOrderPayConfirms\":null,\"taskId\":\"5212504011498824393\",\"optUserId\":\"67741513\",\"optUserName\":null,\"desc\":\"车次确认收款\"}";
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

//        PushTmsPayConfirmDTO pushTmsPayConfirm =new PushTmsPayConfirmDTO();
//        pushTmsPayConfirm.setDeliveryTaskId(data.getTaskId());
//        pushTmsPayConfirm.setOrderIds(orderIds);
//        pushTmsPayConfirm.setOptUserId(data.getOptUserId());
//        System.out.println(JSON.toJSONString(pushTmsPayConfirm));
//        NewApiTest.processConfirmReceiptAmount("pre",pushTmsPayConfirm);

    }
}
