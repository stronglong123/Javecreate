package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.PushTmsPayConfirmDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/5/27 21:49
 */
public class PushTmsPayConfirmBL {


    public static void main(String[] args){
        BatchPayConfirmDTO data = getData();
        List<Long> orderIds = data.getSaleOrderPayConfirms().stream().map(it -> it.getOrderId()).filter(Objects::nonNull).collect(Collectors.toList());


        PushTmsPayConfirmDTO pushTmsPayConfirm =new PushTmsPayConfirmDTO();
        pushTmsPayConfirm.setDeliveryTaskId(data.getTaskId());
        pushTmsPayConfirm.setOrderIds(orderIds);
        pushTmsPayConfirm.setOptUserId(data.getOptUserId());
        System.out.println(JSON.toJSONString(pushTmsPayConfirm));

        NewApiTest.processConfirmReceiptAmount("pre",pushTmsPayConfirm);


    }


    private static BatchPayConfirmDTO getData(){
        String json ="{\n" +
                "    \"desc\": \"车次确认收款\",\n" +
                "    \"optUserId\": \"16203\",\n" +
                "    \"saleOrderPayConfirms\": [\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5187870212081262221,\n" +
                "            \"payAmount\": 5.00\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5187870213103884077,\n" +
                "            \"payAmount\": 162.09\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5187870214530735758,\n" +
                "            \"payAmount\": 194.70\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5188079250797958946,\n" +
                "            \"payAmount\": 326.96\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5188079252069621377,\n" +
                "            \"payAmount\": 30.50\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5188120046243618434,\n" +
                "            \"payAmount\": 485.72\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5188126470582769452,\n" +
                "            \"payAmount\": 219.80\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1683850851778,\n" +
                "            \"orderId\": 5188189158646947467,\n" +
                "            \"payAmount\": 180.08\n" +
                "        }\n" +
                "    ],\n" +
                "    \"taskId\": \"5188360364605608778\"\n" +
                "}";
        BatchPayConfirmDTO batchPayConfirmDTO = JSON.parseObject(json, BatchPayConfirmDTO.class);
        return  batchPayConfirmDTO;
    }
}
