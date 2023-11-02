package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.OrderPayDTO;
import com.common.generate.javacreate.ordercenter.dto.PushTmsPayConfirmDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderPayConfirm;
import com.common.generate.javacreate.ordercenter.dto.data.BatchPayConfirmDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
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


    public static void main(String[] args) {
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
//        map.put(4140002310251017328L, BigDecimal.valueOf(2600.00));
////        map.put(4580002309122185241L, BigDecimal.valueOf(84.2));
////        map.put(4580002309122185240L, BigDecimal.valueOf(95.3));
////        map.put(4580002309122185237L, BigDecimal.valueOf(323.8));
////        map.put(4060002309121242788L, BigDecimal.valueOf(437.7));
//        map.put(5235643384228437026L, BigDecimal.valueOf(260.7));
//
//
//        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
//            RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO =new RepairSaleOrderConfirmPayDTO();
//            repairSaleOrderConfirmPayDTO.setOptUserId(String.valueOf(2106859));
//            repairSaleOrderConfirmPayDTO.setOptUserName("2106859");
//            repairSaleOrderConfirmPayDTO.setOrderId(entry.getKey());
//            repairSaleOrderConfirmPayDTO.setPayAmount(entry.getValue());
//            repairSaleOrderConfirmPayDTO.setCollectionTime(new Date(1698215108526L));
//            System.out.println(JSON.toJSONString(repairSaleOrderConfirmPayDTO));
//            NewApiTest.orderPayConfirm("pre", repairSaleOrderConfirmPayDTO);
//        }
//        singlePay();
//        orderPay();
        pushTms();
    }


    private static BatchPayConfirmDTO getData() {
        String json = "{\"desc\":\"车次确认收款\",\"optUserId\":\"68156989\",\"saleOrderPayConfirms\":[{\"collectionTime\":1697760306621,\"orderId\":4020002310161672882,\"payAmount\":74.0},{\"collectionTime\":1697760306621,\"orderId\":4020002310161973314,\"payAmount\":310.6},{\"collectionTime\":1697760306621,\"orderId\":4020002310161973319,\"payAmount\":222.0},{\"collectionTime\":1697760306621,\"orderId\":4020002310162073617,\"payAmount\":209.28},{\"collectionTime\":1697760306621,\"orderId\":4020002310162373940,\"payAmount\":503.36},{\"collectionTime\":1697760306621,\"orderId\":4020002310170874154,\"payAmount\":427.6},{\"collectionTime\":1697760306621,\"orderId\":5246145712390830660,\"payAmount\":540.24},{\"collectionTime\":1697760306621,\"orderId\":5246154976375241291,\"payAmount\":641.37},{\"collectionTime\":1697760306621,\"orderId\":5246155436867877451,\"payAmount\":464.26},{\"collectionTime\":1697760306621,\"orderId\":5246155438252024806,\"payAmount\":99.49},{\"collectionTime\":1697760306621,\"orderId\":5246176516672223810,\"payAmount\":208.0},{\"collectionTime\":1697760306621,\"orderId\":5246176518144451554,\"payAmount\":208.0},{\"collectionTime\":1697760306621,\"orderId\":5246192107701330922,\"payAmount\":879.96},{\"collectionTime\":1697760306621,\"orderId\":5246205475317250631,\"payAmount\":283.76},{\"collectionTime\":1697760306621,\"orderId\":5246205476579763178,\"payAmount\":352.95},{\"collectionTime\":1697760306621,\"orderId\":5246342624280738377,\"payAmount\":23.99},{\"collectionTime\":1697760306621,\"orderId\":5246342625664858702,\"payAmount\":343.98},{\"collectionTime\":1697760306621,\"orderId\":5246348732537928270,\"payAmount\":510.5},{\"collectionTime\":1697760306621,\"orderId\":5246349088172991465,\"payAmount\":541.5},{\"collectionTime\":1697760306621,\"orderId\":5246360072774149092,\"payAmount\":89.8},{\"collectionTime\":1697760306621,\"orderId\":5246360074175019590,\"payAmount\":961.59},{\"collectionTime\":1697760306621,\"orderId\":5246380383158565445,\"payAmount\":545.88},{\"collectionTime\":1697760306621,\"orderId\":5246401776025762382,\"payAmount\":394.1},{\"collectionTime\":1697760306621,\"orderId\":5246417382888340045,\"payAmount\":328.47},{\"collectionTime\":1697760306621,\"orderId\":5246425783362053093,\"payAmount\":119.18},{\"collectionTime\":1697760306621,\"orderId\":5246425784993637357,\"payAmount\":287.05},{\"collectionTime\":1697760306621,\"orderId\":5246450301472269293,\"payAmount\":89.8},{\"collectionTime\":1697760306621,\"orderId\":5246450302776697825,\"payAmount\":295.84},{\"collectionTime\":1697760306621,\"orderId\":5246452684889684553,\"payAmount\":272.93},{\"collectionTime\":1697760306621,\"orderId\":5246452686378689513,\"payAmount\":151.87},{\"collectionTime\":1697760306621,\"orderId\":5246491261346440167,\"payAmount\":39.99},{\"collectionTime\":1697760306621,\"orderId\":5246491262646647370,\"payAmount\":242.0},{\"collectionTime\":1697760306621,\"orderId\":5246491264055960548,\"payAmount\":198.98},{\"collectionTime\":1697760306621,\"orderId\":5246497988112475105,\"payAmount\":204.98},{\"collectionTime\":1697760306621,\"orderId\":5246502666812449773,\"payAmount\":620.0}],\"taskId\":\"5246507994284381164\"}";
        BatchPayConfirmDTO batchPayConfirmDTO = JSON.parseObject(json, BatchPayConfirmDTO.class);
        return batchPayConfirmDTO;
    }


    @SneakyThrows
    private static void singlePay() {

//        List<Long> repairIds = Arrays.asList(
//                4060002309261974008L,4060002309261974069L,4060002309271375458L,4060002309271475614L,4060002309272277012L,4060002309281378589L
//        );
        BatchPayConfirmDTO data = getData();
        Long optUserId = data.getOptUserId();
        List<Long> orderIds = new ArrayList<>();
        for (SaleOrderPayConfirm saleOrderPayConfirm : data.getSaleOrderPayConfirms()) {
//            if(!repairIds.contains(saleOrderPayConfirm.getOrderId())){
//                continue;
//            }
            Long orderId = saleOrderPayConfirm.getOrderId();
//            OrderDocumentDTO orderDocumentDTO = NewApiTest.getOrderById("pre", orderId);
            List<OrderDocumentDTO> saleOrders = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderId\":" + orderId + ",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
            if (CollectionUtils.isEmpty(saleOrders)) {
                System.out.println("单据不存在,orderId=" + orderId);
                continue;
            }
            OrderDocumentDTO orderDocumentDTO = saleOrders.get(0);
            if (orderDocumentDTO.getOrderBase().getState() == 700) {
                System.out.println("单据已完成,orderId=" + orderId);
                continue;
            }
            if (orderDocumentDTO.getOrderBase().getState() != 502) {
                System.out.println("非配送完成不处理,orderId=" + orderId);
                continue;
            }
            orderIds.add(orderId);

            RepairSaleOrderConfirmPayDTO repairSaleOrderConfirmPayDTO = new RepairSaleOrderConfirmPayDTO();
            repairSaleOrderConfirmPayDTO.setOptUserId(String.valueOf(optUserId));
            repairSaleOrderConfirmPayDTO.setOptUserName(data.getOptUserName());
            repairSaleOrderConfirmPayDTO.setOrderId(saleOrderPayConfirm.getOrderId());
            repairSaleOrderConfirmPayDTO.setPayAmount(saleOrderPayConfirm.getPayAmount());
            repairSaleOrderConfirmPayDTO.setCollectionTime(saleOrderPayConfirm.getCollectionTime());
            System.out.println(JSON.toJSONString(repairSaleOrderConfirmPayDTO));
            NewApiTest.orderPayConfirm("pre", repairSaleOrderConfirmPayDTO);
            Thread.sleep(200L);
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


    public static void pushTms(){
        PushTmsPayConfirmDTO pushTmsPayConfirm =new PushTmsPayConfirmDTO();
        pushTmsPayConfirm.setDeliveryTaskId(5251287625732061285L);
        pushTmsPayConfirm.setOrderIds(Arrays.asList(5250820870622509163L));
        pushTmsPayConfirm.setOptUserId(68160150L);
        System.out.println(JSON.toJSONString(pushTmsPayConfirm));
        NewApiTest.processConfirmReceiptAmount("pre",pushTmsPayConfirm);
    }


    public static void orderPay() {
        String json = "{\"desc\":\"车次确认收款\",\"optUserId\":\"67719547\",\"saleOrderPayConfirms\":[{\"collectionTime\":1697159602874,\"orderId\":4000002310101711138,\"payAmount\":228.82},{\"collectionTime\":1697159602874,\"orderId\":4000002310101811193,\"payAmount\":420.8},{\"collectionTime\":1697159602874,\"orderId\":4000002310110011382,\"payAmount\":189.2},{\"collectionTime\":1697159602874,\"orderId\":4000002310110711404,\"payAmount\":238.8},{\"collectionTime\":1697159602874,\"orderId\":4000002310110811410,\"payAmount\":360.35},{\"collectionTime\":1697159602874,\"orderId\":4000002310110911462,\"payAmount\":190.3},{\"collectionTime\":1697159602874,\"orderId\":4000002310111211596,\"payAmount\":222.9},{\"collectionTime\":1697159602874,\"orderId\":4000002310111411643,\"payAmount\":189.7},{\"collectionTime\":1697159602874,\"orderId\":4000002310111611751,\"payAmount\":887.47},{\"collectionTime\":1697159602874,\"orderId\":4000002310111711827,\"payAmount\":76.0},{\"collectionTime\":1697159602874,\"orderId\":5243758399329303114,\"payAmount\":280.1},{\"collectionTime\":1697159602874,\"orderId\":5243758401166435307,\"payAmount\":127.8},{\"collectionTime\":1697159602874,\"orderId\":5243791380290921453,\"payAmount\":255.6},{\"collectionTime\":1697159602874,\"orderId\":5243817837411072588,\"payAmount\":1350.5},{\"collectionTime\":1697159602874,\"orderId\":5243823723235932740,\"payAmount\":443.5},{\"collectionTime\":1697159602874,\"orderId\":5243836324841972714,\"payAmount\":308.39},{\"collectionTime\":1697159602874,\"orderId\":5243836326922320458,\"payAmount\":215.89},{\"collectionTime\":1697159602874,\"orderId\":5243836328910420550,\"payAmount\":58.5},{\"collectionTime\":1697159602874,\"orderId\":5243850131853179458,\"payAmount\":249.69},{\"collectionTime\":1697159602874,\"orderId\":5243850655570781164,\"payAmount\":184.9},{\"collectionTime\":1697159602874,\"orderId\":5243850657273641546,\"payAmount\":31.9},{\"collectionTime\":1697159602874,\"orderId\":5243851078746694626,\"payAmount\":34.9},{\"collectionTime\":1697159602874,\"orderId\":5243851080134982211,\"payAmount\":172.0},{\"collectionTime\":1697159602874,\"orderId\":5243860187562828778,\"payAmount\":443.5},{\"collectionTime\":1697159602874,\"orderId\":5243885558958056419,\"payAmount\":443.5},{\"collectionTime\":1697159602874,\"orderId\":5243887921139710532,\"payAmount\":127.6},{\"collectionTime\":1697159602874,\"orderId\":5243887922549023726,\"payAmount\":86.9},{\"collectionTime\":1697159602874,\"orderId\":5243892473725352524,\"payAmount\":163.52},{\"collectionTime\":1697159602874,\"orderId\":5243892475545680452,\"payAmount\":206.2},{\"collectionTime\":1697159602874,\"orderId\":5243902385855560265,\"payAmount\":443.5},{\"collectionTime\":1697159602874,\"orderId\":5243906176143254500,\"payAmount\":179.4},{\"collectionTime\":1697159602874,\"orderId\":5243906177544152037,\"payAmount\":249.5},{\"collectionTime\":1697159602874,\"orderId\":5243908246028057165,\"payAmount\":38.8},{\"collectionTime\":1697159602874,\"orderId\":5243920552057272900,\"payAmount\":84.0},{\"collectionTime\":1697159602874,\"orderId\":5243920553315564102,\"payAmount\":644.2},{\"collectionTime\":1697159602874,\"orderId\":5243938592476002884,\"payAmount\":202.3},{\"collectionTime\":1697159602874,\"orderId\":5243953606196886088,\"payAmount\":443.5},{\"collectionTime\":1697159602874,\"orderId\":5243957663179400173,\"payAmount\":181.57},{\"collectionTime\":1697159602874,\"orderId\":5243977929527818827,\"payAmount\":108.1},{\"collectionTime\":1697159602874,\"orderId\":5243977931071322702,\"payAmount\":35.99},{\"collectionTime\":1697159602874,\"orderId\":5244009554265406030,\"payAmount\":145.9},{\"collectionTime\":1697159602874,\"orderId\":5244009555876018760,\"payAmount\":61.5},{\"collectionTime\":1697159602874,\"orderId\":5244044841939008073,\"payAmount\":213.0}],\"taskId\":\"5244060963444914472\"}";
        List<OrderPayDTO> payDTOS = JSON.parseArray(json, OrderPayDTO.class);

        List<OrderPayDTO> needFix = new ArrayList<>();
        for (OrderPayDTO payDTO : payDTOS) {
            Long orderId = payDTO.getOrderId();
            List<OrderDocumentDTO> saleOrders = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderId\":" + orderId + ",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
            if (CollectionUtils.isEmpty(saleOrders)) {
                System.out.println("单据不存在,orderId=" + orderId + "," + JSON.toJSONString(payDTO));
                needFix.add(payDTO);
                continue;
            }
            OrderDocumentDTO orderDocumentDTO = saleOrders.get(0);
            if (orderDocumentDTO.getOrderBase().getState() == 200) {
                System.out.println("待处理,orderId=" + orderId + "," + JSON.toJSONString(payDTO));
                needFix.add(payDTO);
            }
        }
        System.out.println(JSON.toJSONString(needFix));
    }
    /**
     * tidb-statistics.yjp.com/ordercenter/order_item_secowner/		http://ordercenter-tidb-dbcheck.yjp.com/tbl_sql.php?db=ordercenter&table=order_item_secowner
     *  正在显示第 0 -  3 行 (共 4 行, 查询花费 0.0072 秒。)
     *
     * Id	OrderNo	OrderCreateTime	State	PayableAmount
     * 5251112098462405420	712330400044-22	2023-10-31 11:15:57	200	185.290000
     * 5251112100853158695	712330400044-24	2023-10-31 11:15:57	200	223.800000
     * 5251112103298437934	712330400044-26	2023-10-31 11:15:57	200	113.600000
     * 5251112104862913314	712330400044-27	2023-10-31 11:15:57	200	228.000000
     */
}
