package com.common.generate.javacreate.ordercenter;

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

        String filePath = "C:\\Users\\Administrator\\Desktop\\激活赠品单.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "激活赠品单.xlsx");
        List<String> orderNoList = new ArrayList<>();
        for (ElkDTO elkDTO : list) {
            String orderNo = elkDTO.getOrderNo();
            if (StringUtils.isEmpty(orderNo)) {
                continue;
            }
            orderNoList.add(orderNo);
            checkOrderNeedActive(orderNo);
        }
//        System.out.println(JSON.toJSONString(orderNoList));
    }


    private static void checkOrderNeedActive(String orderNo) {
        List<GiftBO> giftList = new ArrayList<>();
        List<OrderDocumentDTO> orderList = getOrderByOrderNo(orderNo);
        for (OrderDocumentDTO orderDocumentDTO : orderList) {
            GiftBO giftBO = new GiftBO();
            giftBO.setOrderNo(orderDocumentDTO.getOrderBase().getOrderNo());
            giftBO.setOrderId(orderDocumentDTO.getOrderBase().getOrderId());
            giftBO.setState(orderDocumentDTO.getOrderBase().getState());
            giftBO.setDeliveryMode(orderDocumentDTO.getOrderDelivery().getDeliveryMode());
            List<OrderItemDocumentDTO> orderItems = orderDocumentDTO.getOrderItems();
            OrderItemDocumentDTO notGift = orderItems.stream().filter(it -> !it.getOrderItemBase().getGift()).findFirst().orElse(null);
            if(notGift==null){
                giftBO.setIfGiftOrder(true);
            }else {
                giftBO.setIfGiftOrder(false);
            }
            giftList.add(giftBO);
        }

        List<GiftBO> mainOrderList = giftList.stream().filter(it -> !it.isIfGiftOrder()).collect(Collectors.toList());
        List<GiftBO> giftOrderList = giftList.stream().filter(it -> it.isIfGiftOrder()).collect(Collectors.toList());

        GiftBO noCompleteOrder = mainOrderList.stream().filter(it -> it.getState() != 700).findFirst().orElse(null);
        if (noCompleteOrder == null) {
            List<String> collect = mainOrderList.stream().map(it -> it.getOrderNo()).collect(Collectors.toList());
            System.out.println("主单已经完成:" + collect);
        }

        for (GiftBO giftBO : giftOrderList) {
            System.out.println("赠品单需要激活" + JSON.toJSONString(giftBO));
            activeOrder(giftBO);
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


    @SneakyThrows
    private static void activeOrder(GiftBO giftBO) {
        if (giftBO.getState() != 200 && giftBO.getState() != 213) {
            System.out.println("赠品单状态异常," + JSON.toJSONString(giftBO));
            return;
        }

        if(!giftBO.getState().equals(200)){
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
