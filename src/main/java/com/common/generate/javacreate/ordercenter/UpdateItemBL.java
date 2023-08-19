package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemAmountDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemAwardDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemBaseDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderItemDTO;
import com.common.generate.javacreate.ordercenter.dto.UpdateSecOwnerDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.apache.lucene.document.HalfFloatPoint;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/5/6 13:50
 */
public class UpdateItemBL {

//    public int maxRealValue (int m, Integer[] sellPrice, int[] realValue) {
//        // write code here
//
//    }


    @SneakyThrows
    public static void main(String[] args) {

        fixByMap();


    }


    @SneakyThrows
    public static void fixByMap() {
        Map<Long ,BigDecimal> itemmap = new HashMap<>();
        itemmap.put(5213850565108995973L,BigDecimal.valueOf(12));

        for (Map.Entry<Long, BigDecimal> entry : itemmap.entrySet()) {
            Long itemId = entry.getKey();
            BigDecimal count = entry.getValue();
            SaleOrderItemDTO saleOrderItemDTO = new SaleOrderItemDTO();

            OrderItemBaseDTO orderItemBaseDTO = new OrderItemBaseDTO();
            orderItemBaseDTO.setOrderItemId(itemId);
            orderItemBaseDTO.setCount(count);
//            orderItemBaseDTO.setTakeCount(count);
//            orderItemBaseDTO.setWorkingItemCount(count);
            saleOrderItemDTO.setOrderItemBaseDTO(orderItemBaseDTO);

//            OrderItemAmountDTO orderItemAmountDTO = new OrderItemAmountDTO();
//            orderItemAmountDTO.setOrderItemId(itemId);
////            orderItemAmountDTO.setDiscount(BigDecimal.valueOf(5));
//            orderItemAmountDTO.setPayableAmount(BigDecimal.valueOf(918));
////            orderItemAmountDTO.setWorkingOrderItemAmount(BigDecimal.valueOf(3.6));
//            saleOrderItemDTO.setOrderItemAmountDTO(orderItemAmountDTO);
            System.out.println(JSON.toJSONString(saleOrderItemDTO));
            NewApiTest.updateOrderItem("pre", saleOrderItemDTO);




//            OrderItemAwardDTO orderItemAwardDTO = new OrderItemAwardDTO();
//            orderItemAwardDTO.setOrderItemId(1111L);
//            orderItemAwardDTO.setPrizeName("");
//            NewApiTest.updateAwardItem("release",orderItemAwardDTO);

            Thread.sleep(100);
        }

    }


    @SneakyThrows
    public static void fixById() {
        List<Long> itemIds = Arrays.asList(5208690341410747143L);
//
//
        for (Long itemId : itemIds) {
            SaleOrderItemDTO saleOrderItemDTO = new SaleOrderItemDTO();
            OrderItemBaseDTO orderItemBaseDTO = new OrderItemBaseDTO();
            orderItemBaseDTO.setOrderItemId(itemId);
            orderItemBaseDTO.setCount(BigDecimal.valueOf(0));
            orderItemBaseDTO.setWorkingItemCount(BigDecimal.valueOf(0));
            saleOrderItemDTO.setOrderItemBaseDTO(orderItemBaseDTO);

//            OrderItemAmountDTO orderItemAmountDTO = new OrderItemAmountDTO();
//            orderItemAmountDTO.setOrderItemId(orderItemId);
//            orderItemAmountDTO.setDiscount(BigDecimal.ZERO);
//            saleOrderItemDTO.setOrderItemAmountDTO(orderItemAmountDTO);
            System.out.println(JSON.toJSONString(saleOrderItemDTO));
            NewApiTest.updateOrderItem("pre", saleOrderItemDTO);
            Thread.sleep(100);
        }
    }

    @SneakyThrows
    public static void fixByExcel() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\deliveryCount异常数据.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "deliveryCount异常数据.xlsx");

        for (ElkDTO elkDTO : list) {
            if (elkDTO.getItemId() == null) {
                continue;
            }
            SaleOrderItemDTO saleOrderItemDTO = new SaleOrderItemDTO();
            OrderItemBaseDTO orderItemBaseDTO = new OrderItemBaseDTO();
            orderItemBaseDTO.setOrderItemId(elkDTO.getItemId());
            orderItemBaseDTO.setDeliveryCount(elkDTO.getWorkingItemCount());
            saleOrderItemDTO.setOrderItemBaseDTO(orderItemBaseDTO);

            System.out.println(JSON.toJSONString(saleOrderItemDTO));
            NewApiTest.updateOrderItem("pre", saleOrderItemDTO);
            Thread.sleep(100);
        }
    }
}
