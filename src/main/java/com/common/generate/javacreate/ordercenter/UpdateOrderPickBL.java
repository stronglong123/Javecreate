package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemBaseDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderItemDTO;
import com.common.generate.javacreate.service.IUserServicce;
import com.common.generate.javacreate.service.impl.es.base.OrderAmountDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderConsignorDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderContactDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderReturnDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Action;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2023/5/6 13:50
 */
public class UpdateOrderPickBL {

//    public int maxRealValue (int m, Integer[] sellPrice, int[] realValue) {
//        // write code here
//
//    }

    @Autowired
    private IUserServicce userServicce;

    @SneakyThrows
    public static void main(String[] args) {
//        fixByExcel();

//        List<Long> orderIds =Arrays.asList(5195773240349836000L,5195773240488248040L);
//        Long warehouseId =8986L;
//        Long orgId = 898L;
//
//        for (Long orderId : orderIds) {
//            OrderPickDTO orderPickDTO = new OrderPickDTO();
//            orderPickDTO.setOrderId(orderId);
//            orderPickDTO.setFromWarehouseId(warehouseId);
//            orderPickDTO.setWarehouseId(warehouseId);
//            orderPickDTO.setFromOrgId(orgId);
//            orderPickDTO.setOrgId(orgId);
//            NewApiTest.updateWarehouse("pre", orderPickDTO);
//        }

        List<Long> orderIds = Arrays.asList(5219383248150003393L);
        for (Long orderId : orderIds) {
            OrderBaseDTO orderBaseDTO = new OrderBaseDTO();
            orderBaseDTO.setOrderId(orderId);
            orderBaseDTO.setState(200);
            NewApiTest.updateState("pre", orderBaseDTO);
        }

//        Map<Long ,BigDecimal> map = new HashMap<>();
//        map.put(4620002307061904536L,BigDecimal.valueOf(3));
//        map.put(4620002307061904537L,BigDecimal.valueOf(7));
//
//        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
//            OrderReturnDTO orderReturnDTO = new OrderReturnDTO();
//            orderReturnDTO.setOrderId(entry.getKey());
//            orderReturnDTO.setActualReturnAmount(entry.getValue());
//            System.out.println(JSON.toJSONString(orderReturnDTO));
//            NewApiTest.updateOrderReturn("pre", orderReturnDTO);
//        }


//        for (Long orderId : orderIds) {
//            OrderAmountDTO orderAmountDTO = new OrderAmountDTO();
//            orderAmountDTO.setOrderId(orderId);
////            orderAmountDTO.setOrderAmount(BigDecimal.valueOf(3.6));
////            orderAmountDTO.setPayableAmount(BigDecimal.valueOf(3.6));
////            orderAmountDTO.setReceiveAmount(BigDecimal.valueOf(54));
////            orderAmountDTO.setUncollectedAmount(BigDecimal.valueOf(0));
//            orderAmountDTO.setTotalDiscount(BigDecimal.ZERO);
//            NewApiTest.updateOrderAmount("release", orderAmountDTO);
//        }

//        List<Long> orderIds = Arrays.asList();
//        for (Long orderId : orderIds) {
//            OrderContactDTO orderContactDTO = new OrderContactDTO();
//            orderContactDTO.setOrderId(orderId);
//            orderContactDTO.setDetailAddress("安顺康驾校(古井训练场)东北侧260米新会区古井镇闲时商店");
//            NewApiTest.updateOrderContract("pre", orderContactDTO);
//        }

//        for (Long orderId : orderIds) {
//            OrderConsignorDTO orderConsignorDTO = new OrderConsignorDTO();
//            orderConsignorDTO.setOrderId(orderId);
//            orderConsignorDTO.setAddressId(2864021L);
//            System.out.println(JSON.toJSONString(orderConsignorDTO));
//            NewApiTest.updateOrderConsignor("pre", orderConsignorDTO);
//        }
    }


    @SneakyThrows
    public static void fixByExcel() {

        String filePath = "C:\\Users\\Administrator\\Desktop\\内配单类型异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "内配单类型异常.xlsx");

        for (ElkDTO elkDTO : list) {
            if (elkDTO.getOrderId() == null) {
                continue;
            }
//            OrderPickDTO orderPickDTO = new OrderPickDTO();
//            orderPickDTO.setOrderId(elkDTO.getOrderId());
//            orderPickDTO.setFromWarehouseId(elkDTO.getFromWarehouseId());
//            orderPickDTO.setWarehouseId(elkDTO.getWarehouseId());
//            orderPickDTO.setFromOrgId(elkDTO.getFromCityId());
//            orderPickDTO.setOrgId(elkDTO.getOrgId());
//            System.out.println(JSON.toJSONString(orderPickDTO));
//            NewApiTest.updateWarehouse("pre", orderPickDTO);

            OrderBaseDTO orderBaseDTO = new OrderBaseDTO();
            orderBaseDTO.setOrderId(elkDTO.getOrderId());
            orderBaseDTO.setFirstOrderType(3);
            orderBaseDTO.setSecOrderType(30001);
            orderBaseDTO.setBusinessType(5);
            System.out.println(JSON.toJSONString(orderBaseDTO));
//            NewApiTest.updateState("pre", orderBaseDTO);
//            System.out.println("     ");
        }
    }


}
