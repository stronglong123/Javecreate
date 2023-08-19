package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.GiftBO;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.service.impl.es.orderitemdocument.OrderItemDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    }


    @SneakyThrows
    private static void activeByOrderNo() {
        List<String> orderNoList = Arrays.asList("417322700037-2");
        for (String orderNo : orderNoList) {
            if (StringUtils.isEmpty(orderNo)) {
                continue;
            }
            checkOrderNeedActive(orderNo);
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
            List<GiftBO> giftBOS = checkOrderNeedActive(orderNo);
            for (GiftBO giftBO : giftBOS) {
                orderNoList.add(giftBO.getOrderNo());
            }
        }
        System.out.println(JSON.toJSONString("要激活赠品单=" + JSON.toJSONString(orderNoList)));
    }


    @SneakyThrows
    private static List<GiftBO> checkOrderNeedActive(String orderNo) {
        List<GiftBO> giftList = new ArrayList<>();
        List<OrderDocumentDTO> orderList = getOrderByOrderNo(orderNo);
        for (OrderDocumentDTO orderDocumentDTO : orderList) {
            GiftBO giftBO = new GiftBO();
            giftBO.setOrderNo(orderDocumentDTO.getOrderBase().getOrderNo());
            giftBO.setOrderId(orderDocumentDTO.getOrderBase().getOrderId());
            giftBO.setState(orderDocumentDTO.getOrderBase().getState());
            giftBO.setDeliveryMode(orderDocumentDTO.getOrderDelivery().getDeliveryMode());
            giftBO.setOutOfStock(checkOutOfStock(orderDocumentDTO));
            List<OrderItemDocumentDTO> orderItems = orderDocumentDTO.getOrderItems();
            OrderItemDocumentDTO notGift = orderItems.stream().filter(it -> !it.getOrderItemBase().getGift()).findFirst().orElse(null);
            if (notGift == null) {
                giftBO.setIfGiftOrder(true);
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
            List<Integer> cancelStates = Arrays.asList(300, 305, 304);
            List<String> orderNos = mainOrderList.stream().map(it -> it.getOrderNo()).collect(Collectors.toList());
            List<String> cancelNos = mainOrderList.stream().filter(it -> cancelStates.contains(it.getState())).map(it -> it.getOrderNo()).collect(Collectors.toList());

            if (CollectionUtils.isNotEmpty(cancelNos)) {
                if (orderNos.size() == cancelNos.size()) {
                    mainType = 3;
                    builder.append("主单已经全部取消=" + JSON.toJSONString(cancelNos));
                } else {
                    mainType = 4;
                    builder.append("主单部分取消=" + JSON.toJSONString(cancelNos));
                }
            } else {
                mainType = 2;
                builder.append("主单未完成=" + orderNos);
            }
        } else {
            mainType = 1;
        }

        if (mainType == 3) {
            builder.append(",需要取消的赠品单" + JSON.toJSONString(giftOrderList));
            System.out.println(builder.toString());
        }
        if (mainType == 4) {
            builder.append(",需要判断是否取消的赠品单" + JSON.toJSONString(giftOrderList));
            System.out.println(builder.toString());
        }

        if(mainType!=1){
            return Collections.emptyList();
        }

        List<GiftBO> activeGiftList = new ArrayList<>();

        if (mainType == 1) {
            GiftBO outOfStockOrder = mainOrderList.stream().filter(it -> it.isOutOfStock()).collect(Collectors.toList()).stream().findFirst().orElse(null);
            if (mainType == 1 && outOfStockOrder != null) {
                System.out.println("主单存在缺货,赠品单无法激活" + JSON.toJSONString(giftOrderList));
                return activeGiftList;
            }
            for (GiftBO giftBO : giftOrderList) {
                if (giftBO.getState() == 200 || giftBO.getState() == 213) {
                    System.out.println("赠品单需要激活" + giftBO.getOrderNo());
                    activeGiftList.add(giftBO);
                    activeOrder(giftBO);
//                    Thread.sleep(200L);
                }
            }
        }
        return activeGiftList;

    }


    private static boolean checkOutOfStock(OrderDocumentDTO orderDocumentDTO) {
        OrderItemDocumentDTO orderItemDocumentDTO = orderDocumentDTO.getOrderItems().stream().filter(item -> item.getOrderItemBase().getOriginalCount().compareTo(item.getOrderItemBase().getCount()) != 0).findFirst().orElse(null);
        return orderItemDocumentDTO != null;
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


    @SneakyThrows
    private static void activeOrder(GiftBO giftBO) {
        if (giftBO.getState() != 200 && giftBO.getState() != 213) {
            System.out.println("赠品单状态异常," + JSON.toJSONString(giftBO));
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


}
