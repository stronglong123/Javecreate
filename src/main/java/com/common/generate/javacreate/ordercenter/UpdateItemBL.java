package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemAmountDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemBaseDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderItemDTO;
import com.common.generate.javacreate.ordercenter.dto.UpdateSecOwnerDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
    public static void main(String[] args){
   List<Long> itemIds = Arrays.asList(4000012305290704713L);


        for (Long itemId : itemIds) {
            SaleOrderItemDTO saleOrderItemDTO = new SaleOrderItemDTO();
            OrderItemBaseDTO orderItemBaseDTO = new OrderItemBaseDTO();
            orderItemBaseDTO.setOrderItemId(itemId);
            orderItemBaseDTO.setCount(BigDecimal.ZERO);
//            orderItemBaseDTO.setRemark("");
            saleOrderItemDTO.setOrderItemBaseDTO(orderItemBaseDTO);

//            OrderItemAmountDTO orderItemAmountDTO = new OrderItemAmountDTO();
//            orderItemAmountDTO.setOrderItemId(orderItemId);
//            orderItemAmountDTO.setDiscount(BigDecimal.ZERO);
//            saleOrderItemDTO.setOrderItemAmountDTO(orderItemAmountDTO);
            NewApiTest.updateOrderItem("pre", saleOrderItemDTO);
            Thread.sleep(100);
        }
    }

    @SneakyThrows
    public static void fixByExcel(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\异常数据.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "异常数据.xlsx");


        for (ElkDTO elkDTO : list) {
            SaleOrderItemDTO saleOrderItemDTO = new SaleOrderItemDTO();
            OrderItemBaseDTO orderItemBaseDTO = new OrderItemBaseDTO();
            orderItemBaseDTO.setOrderItemId(elkDTO.getItemId());
            orderItemBaseDTO.setDeliveryCount(elkDTO.getOutStockCount());
//            orderItemBaseDTO.setRemark("");
            saleOrderItemDTO.setOrderItemBaseDTO(orderItemBaseDTO);

//            OrderItemAmountDTO orderItemAmountDTO = new OrderItemAmountDTO();
//            orderItemAmountDTO.setOrderItemId(orderItemId);
//            orderItemAmountDTO.setDiscount(BigDecimal.ZERO);
//            saleOrderItemDTO.setOrderItemAmountDTO(orderItemAmountDTO);
            NewApiTest.updateOrderItem("pre", saleOrderItemDTO);
            Thread.sleep(100);
        }
    }
}
