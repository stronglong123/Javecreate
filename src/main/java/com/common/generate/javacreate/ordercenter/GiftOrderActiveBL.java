package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.GiftBO;
import com.common.generate.javacreate.ordercenter.dto.PageTurnParam;
import com.common.generate.javacreate.ordercenter.dto.PageTurnResult;
import com.common.generate.javacreate.service.impl.es.OrderSnapshotQuery;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderitemdocument.OrderItemDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/8/10 15:20
 */
@Service
public class GiftOrderActiveBL {

    @SneakyThrows
    public static void main(String[] args) {
//        activeByExcel();
        activeByOrderNo();
//        activeByQuery();
//        directActiveOrder();
//        directActive();
//        activeOrderByMq(4020002309061286000L);
    }


    @SneakyThrows
    private static void activeByOrderNo() {
        List<String> orderNoList = Arrays.asList(
                "160326100052-1"
                );
        for (String orderNo : orderNoList) {
            if (StringUtils.isEmpty(orderNo)) {
                continue;
            }
            checkOrderNeedActive(orderNo, false);
        }
    }

    public static void directActiveOrder() {
        List<String> orderNoList = Arrays.asList("114324600467-1");
        for (String orderNo : orderNoList) {
            if (StringUtils.isEmpty(orderNo)) {
                continue;
            }
            checkOrderNeedActive(orderNo, true);
        }
    }


    @SneakyThrows
    private static void activeByExcel() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\激活赠品单.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "激活赠品单.xlsx");
        List<String> orderNoList = new ArrayList<>();


        for (ElkDTO elkDTO : list) {
            String orderNo = elkDTO.getOrderNo();
            if (StringUtils.isEmpty(orderNo)) {
                continue;
            }
            List<GiftBO> giftBOS = checkOrderNeedActive(orderNo, false);
            for (GiftBO giftBO : giftBOS) {
                orderNoList.add(giftBO.getOrderNo());
            }
        }
        println(JSON.toJSONString("要激活赠品单=" + JSON.toJSONString(orderNoList)));
    }

    @SneakyThrows
    private static void activeByQuery() {
        String nextScrollId = null;
        PageTurnParam pageTurnParam = new PageTurnParam();
        pageTurnParam.setPageSize(10);
        do {
            // 查询预售数据
            pageTurnParam.setScrollId(nextScrollId);
            OrderSnapshotQuery orderSnapshotQuery = new OrderSnapshotQuery();
            orderSnapshotQuery.setState(213);
            orderSnapshotQuery.setSortByOrderCreateTime(0);
            orderSnapshotQuery.setCompanyCode("YJP");
            PageTurnResult<OrderDocumentDTO> orderByPageTurn = NewApiTest.findOrderSnapshotByPageTurn("pre", JSON.toJSONString(Arrays.asList(orderSnapshotQuery, pageTurnParam)));
            nextScrollId = orderByPageTurn.getNextScrollId();
            if (CollectionUtils.isEmpty(orderByPageTurn.getDatas())) {
                continue;
            }
            for (OrderDocumentDTO orderDocumentDTO : orderByPageTurn.getDatas()) {
                checkOrderNeedActive(orderDocumentDTO.getOrderBase().getOrderNo(), false);
            }
        } while (StringUtils.isNotEmpty(nextScrollId) && !"-1".equals(nextScrollId));
    }


    @SneakyThrows
    private static List<GiftBO> checkOrderNeedActive(String orderNo, boolean partCanActive) {
        List<GiftBO> giftList = new ArrayList<>();
        List<OrderDocumentDTO> orderList = getOrderByOrderNo(orderNo);
        for (OrderDocumentDTO orderDocumentDTO : orderList) {
            GiftBO giftBO = new GiftBO();
            giftBO.setOrderNo(orderDocumentDTO.getOrderBase().getOrderNo());
            giftBO.setOrderId(orderDocumentDTO.getOrderBase().getOrderId());
            giftBO.setState(orderDocumentDTO.getOrderBase().getState());
            giftBO.setDeliveryMode(orderDocumentDTO.getOrderDelivery().getDeliveryMode());
            checkOutOfStock(orderDocumentDTO, giftBO);
            List<OrderItemDocumentDTO> orderItems = orderDocumentDTO.getOrderItems();
            OrderItemDocumentDTO notGift = orderItems.stream().filter(it -> !it.getOrderItemBase().getGift()).findFirst().orElse(null);
            if (notGift == null) {
                List<String> giftProductList = orderItems.stream().map(it -> it.getOrderItemBase().getProductName()).collect(Collectors.toList());
                giftBO.setIfGiftOrder(true);
                giftBO.setGiftProductList(giftProductList);
            } else {
                giftBO.setIfGiftOrder(false);
            }
            giftList.add(giftBO);
        }

        List<GiftBO> mainOrderList = giftList.stream().filter(it -> !it.isIfGiftOrder()).collect(Collectors.toList());
        List<GiftBO> giftOrderList = giftList.stream().filter(it -> it.isIfGiftOrder()).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        GiftBO noCompleteOrder = mainOrderList.stream().filter(it -> it.getState() != 700).findFirst().orElse(null);

        // 1、全部完成，2、存在未完成，3、全部取消。4、部分取消,5、存在缺货
        Integer mainType;
        if (noCompleteOrder != null) {
            List<Integer> cancelStates = Arrays.asList(300,302, 305, 304);
            Set<String> orderNos = mainOrderList.stream().map(it -> it.getOrderNo()).collect(Collectors.toSet());
            Set<String> cancelNos = mainOrderList.stream().filter(it -> cancelStates.contains(it.getState())).map(it -> it.getOrderNo()).collect(Collectors.toSet());
            GiftBO completeMainBO = mainOrderList.stream().filter(it -> it.getState() == 700).findFirst().orElse(null);
            if (CollectionUtils.isNotEmpty(cancelNos)) {
                if (orderNos.size() == cancelNos.size()) {
                    mainType = 3;
                    builder.append("主单已经全部取消=" + JSON.toJSONString(cancelNos));
                } else {
                    mainType = 4;
                    builder.append("主单部分取消=" + JSON.toJSONString(cancelNos));
                    activeOrderByMq(completeMainBO.getOrderId());
                }
            } else {
                mainType = 2;
                builder.append("主单未完成=" + orderNos);
            }
        } else {
            mainType = 1;
        }

        if (mainType == 4) {
            builder.append(",需要判断是否取消/激活的赠品单" + JSON.toJSONString(giftOrderList));
            println(builder.toString());
            return Collections.emptyList();
        }

        if (mainType != 1 && mainType != 3) {
            builder.append(",需要判断是否取消/激活的赠品单" + JSON.toJSONString(giftOrderList));
            return Collections.emptyList();
        }

//        GiftBO notYJX = giftOrderList.stream().filter(it -> it.getDeliveryMode() != 1).findFirst().orElse(null);
//        if (notYJX != null) {
//            println("非经销商配送单子，暂不处理," + JSON.toJSONString(giftOrderList));
//            return Collections.emptyList();
//        }


        if (mainType == 3) {
            builder.append(",需要直接取消的赠品单" + JSON.toJSONString(giftOrderList));
            println(builder.toString());
            for (GiftBO giftBO : giftOrderList) {
                if (giftBO.getState() == 213) {
                    println("赠品单需要取消" + giftBO.getOrderNo());
//                    NewApiTest.cancelSaleOrder("pre", giftBO.getOrderId());
                    Thread.sleep(200L);
                }
            }
        }

        List<GiftBO> activeGiftList = new ArrayList<>();
        if (mainType == 1) {
//            GiftBO giftBO = mainOrderList.stream().filter(it->it.getState().equals(700)).findFirst().orElse(null);
//            if (giftBO != null) {
//                activeOrderByMq(giftBO.getOrderId());
//            }
            List<List<String>> productList = mainOrderList.stream().filter(it -> it.isOutOfStock()).collect(Collectors.toList()).stream().map(it -> it.getOutOfStockProductList()).collect(Collectors.toList());
            if (!partCanActive && mainType == 1 && CollectionUtils.isNotEmpty(productList)) {

                GiftBO giftBO = mainOrderList.stream().filter(it->it.getState().equals(700)).findFirst().orElse(null);
                if (giftBO != null) {
                    activeOrderByMq(giftBO.getOrderId());
                }
                println("主单存在缺货,"+ productList + ",赠品单需确认激活" + JSON.toJSONString(giftOrderList));
                return activeGiftList;
            }
            for (GiftBO giftBO : giftOrderList) {
                if (giftBO.getState() == 200 || giftBO.getState() == 213) {
                    println("赠品单需要激活" + giftBO.getOrderNo());
                    activeGiftList.add(giftBO);
                    activeOrder(giftBO);
                    Thread.sleep(200L);
                }
            }
        }
        return activeGiftList;
    }


    private static void checkOutOfStock(OrderDocumentDTO orderDocumentDTO, GiftBO giftBO) {
        List<String> outOfStockProductList = orderDocumentDTO.getOrderItems().stream().filter(item -> item.getOrderItemBase().getOriginalCount().compareTo(item.getOrderItemBase().getCount()) != 0).map(it -> it.getOrderItemBase().getProductName()).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(outOfStockProductList)) {
            giftBO.setOutOfStock(true);
            giftBO.setOutOfStockProductList(outOfStockProductList);
        } else {
            giftBO.setOutOfStock(false);
        }
    }


    private static List<OrderDocumentDTO> getOrderByOrderNo(String orderNo) {
        if (orderNo.contains("-")) {
            String[] split = orderNo.split("-");
            orderNo = split[0];
        }
        String param = "[{\"orderWord\":\"" +
                orderNo +
                "\"},{\"pageIndex\":1,\"pageSize\":10}]";
        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", param);
        return orderList;
    }


    private static List<OrderDocumentDTO> getOrderByDirectOrderNo(String orderNo) {
        String param = "[{\"orderWord\":\"" +
                orderNo +
                "\"},{\"pageIndex\":1,\"pageSize\":10}]";
        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", param);
        return orderList;
    }

    @SneakyThrows
    private static void activeOrderByMq(Long orderId) {
        println("赠品单接口激活," + orderId);
        Map<String,Object> map = new HashMap<>();
        map.put("id","DelayMessageProcessor:5236751358886376966");
        map.put("messageBody",orderId.toString());
        String json ="{\"x-company-code\":\"YJP\",\"x-logId\":\"DelayMessageProcessor:5236751358886376966\",\"x-tenant-id\":\"9\",\"x-partner-app-key\":null,\"exchange\":\"\",\"x-partner-code\":\"YJP-TRD\",\"rabbit-tracer\":\"ac1904a6169529921014881281#0#0\",\"MESSAGE_ORIGIN_CLASS_TYPE\":null,\"x-partner-app-id\":null,\"routingKey\":\"mq.ordercenter.giftorder.active\"}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        map.put("header",JSON.toJSONString(hashMap));
        println(JSON.toJSONString(map));
        NewApiTest.requeueWithBody(JSON.toJSONString(map));

    }


    @SneakyThrows
    private static void activeOrder(GiftBO giftBO) {
        if (giftBO.getState() != 200 && giftBO.getState() != 213) {
            println("赠品单状态异常," + JSON.toJSONString(giftBO));
            return;
        }

        if (!giftBO.getState().equals(200)) {
            OrderBaseDTO orderBaseDTO = new OrderBaseDTO();
            orderBaseDTO.setOrderId(giftBO.getOrderId());
            orderBaseDTO.setState(200);
            NewApiTest.updateState("pre", orderBaseDTO);
            Thread.sleep(100L);
        }
        NewApiTest.auditComplete("pre", giftBO.getOrderId());
        Thread.sleep(100L);
    }


    public static void directActive() {
        List<String> orderNos = Arrays.asList("406323900466-4");
        for (String orderNo : orderNos) {
            List<OrderDocumentDTO> orderList = getOrderByDirectOrderNo(orderNo);
            if (CollectionUtils.isEmpty(orderList) || orderList.size() > 1) {
                throw new BusinessException("单据存在异常," + orderNo);
            }
            OrderDocumentDTO orderDocumentDTO = orderList.get(0);
            GiftBO giftBO = new GiftBO();
            giftBO.setOrderNo(orderDocumentDTO.getOrderBase().getOrderNo());
            giftBO.setOrderId(orderDocumentDTO.getOrderBase().getOrderId());
            giftBO.setState(orderDocumentDTO.getOrderBase().getState());
            giftBO.setDeliveryMode(orderDocumentDTO.getOrderDelivery().getDeliveryMode());
            checkOutOfStock(orderDocumentDTO, giftBO);
            List<OrderItemDocumentDTO> orderItems = orderDocumentDTO.getOrderItems();
            OrderItemDocumentDTO notGift = orderItems.stream().filter(it -> !it.getOrderItemBase().getGift()).findFirst().orElse(null);
            if (notGift == null) {
                List<String> giftProductList = orderItems.stream().map(it -> it.getOrderItemBase().getProductName()).collect(Collectors.toList());
                giftBO.setIfGiftOrder(true);
                giftBO.setGiftProductList(giftProductList);
            } else {
                giftBO.setIfGiftOrder(false);
            }
            activeOrder(giftBO);
        }
    }


    private static void println(String content) {
        System.out.println(content);
        FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\激活赠品单异常.txt", content + "\n");
    }

}
