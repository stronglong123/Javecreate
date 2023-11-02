package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.enums.TrdPayTypeEnum;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderItemBaseDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderItemDTO;
import com.common.generate.javacreate.service.IUserServicce;
import com.common.generate.javacreate.service.impl.es.base.OrderAmountDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderConsignorDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderContactDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderDeliveryDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderReturnDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderSaleDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.elasticsearch.client.indices.IndexTemplatesExistRequest;
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
//        updateOrderAmount();
//        updateOrderDelivery();
//        updateOrderBase();

//        updateOrderConsignor();
//        retrySyncEs();
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



        Map<Long ,BigDecimal> map = new HashMap<>();
        map.put(5248929940148451879L,BigDecimal.valueOf(0));

        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            OrderReturnDTO orderReturnDTO = new OrderReturnDTO();
            orderReturnDTO.setOrderId(entry.getKey());
            orderReturnDTO.setActualReturnAmount(entry.getValue());
            System.out.println(JSON.toJSONString(orderReturnDTO));
            NewApiTest.updateOrderReturn("pre", orderReturnDTO);
        }


//        for (Long orderId : orderIds) {
//            OrderAmountDTO orderAmountDTO = new OrderAmountDTO();
//            orderAmountDTO.setOrderId(7110002310311283911L);
//            orderAmountDTO.setPayType(21);
//            orderAmountDTO.setPayTypeName("二维码支付");
////            orderAmountDTO.setOrderAmount(BigDecimal.valueOf(3.6));
////            orderAmountDTO.setPayableAmount(BigDecimal.valueOf(3.6));
////            orderAmountDTO.setReceiveAmount(BigDecimal.valueOf(54));
////            orderAmountDTO.setUncollectedAmount(BigDecimal.valueOf(0));
////            orderAmountDTO.setTotalDiscount(BigDecimal.valueOf(5));
////            orderAmountDTO.setUncollectedAmount(BigDecimal.valueOf(918));
////            orderAmountDTO.setPayableAmount(BigDecimal.valueOf(918));
//            NewApiTest.updateOrderAmount("pre", orderAmountDTO);
//            NewApiTest.retrySyncOrderByOrderIds("pre", 1000002310311203046L);

//        }

//        List<Long> orderIds = Arrays.asList();
//        for (Long orderId : orderIds) {
//            OrderContactDTO orderContactDTO = new OrderContactDTO();
//            orderContactDTO.setOrderId(orderId);
//            orderContactDTO.setContactPhone("15117225549");
//            NewApiTest.updateOrderContract("saas", orderContactDTO);
//        }

//        for (Long orderId : orderIds) {
//            OrderConsignorDTO orderConsignorDTO = new OrderConsignorDTO();
//            orderConsignorDTO.setOrderId(orderId);
//            orderConsignorDTO.setAddressId(2864021L);
//            System.out.println(JSON.toJSONString(orderConsignorDTO));
//            NewApiTest.updateOrderConsignor("pre", orderConsignorDTO);
//        }

//        List<Long> orderIds = Arrays.asList(5225460663836768844L,
//                5225481381839460195L,
//                5225719066374994496L,
//                5225753996647758400L,
//                5225785459292273222L,
//                5225886429325121386L);
//        for (Long orderId : orderIds) {
//            OrderSaleDTO orderSaleDTO = new OrderSaleDTO();
//            orderSaleDTO.setOrderId(orderId);
//            orderSaleDTO.setCheckoutWarehouseId(4784L);
//            System.out.println(JSON.toJSONString(orderSaleDTO));
//            NewApiTest.updateOrderSale("pre", orderSaleDTO);
//        }
    }

    @SneakyThrows
    public static void updateOrderBase() {
        List<Long> orderIds = Arrays.asList();
        for (Long orderId : orderIds) {
            OrderBaseDTO orderBaseDTO = new OrderBaseDTO();
            orderBaseDTO.setOrderId(orderId);
            orderBaseDTO.setState(401);
            NewApiTest.updateState("pre", orderBaseDTO);
            NewApiTest.retrySyncOrderByOrderIds("pre", orderId);
        }
    }
    @SneakyThrows
    public static void updateOrderAmount() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\paytype修复.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "paytype修复.xlsx");
        for (ElkDTO elkDTO : list) {
            if (elkDTO.getId() == null || elkDTO.getPayType() == null) {
                continue;
            }
            OrderAmountDTO orderAmountDTO = new OrderAmountDTO();
            orderAmountDTO.setOrderId(elkDTO.getId());
            orderAmountDTO.setPayType(elkDTO.getPayType());
            orderAmountDTO.setPayTypeName(TrdPayTypeEnum.getTextByValue(elkDTO.getPayType()));
            System.out.println(JSON.toJSONString(orderAmountDTO));
            NewApiTest.updateOrderAmount("pre", orderAmountDTO);
        }
    }

    @SneakyThrows
    public static void updateOrderDelivery() {
        List<Long> orderIds = Arrays.asList(4000002310181315910L, 4510002310121008603L, 4020002308150935222L, 4020002307171570382L, 4020002307171570366L, 4020002307141764594L, 4020002306291730710L, 4020002306191508413L, 4250002306171478610L, 4250002306171478609L, 4250002306171478607L, 4250002306171478605L, 4250002306171478604L, 4250002306171478603L, 4690002306161063984L, 4020002306031373023L, 4020002306031373011L, 4020002305061212328L, 4020002305060611767L, 4850002305271863560L, 4020002304081357182L, 4040002303241104759L, 7010002307311765518L, 7550002304231343574L, 7550002304231343573L, 7550002304231343572L, 7550002304231343571L);
        for (Long orderId : orderIds) {
            OrderDeliveryDTO orderDeliveryDTO = new OrderDeliveryDTO();
            orderDeliveryDTO.setOrderId(orderId);
            orderDeliveryDTO.setDeliveryMode(102);
            NewApiTest.updateOrderDelivery("pre", orderDeliveryDTO);
            NewApiTest.retrySyncOrderByOrderIds("pre", orderId);
        }

    }

    @SneakyThrows
    public static void updateOrderConsignor() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\异常userId.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "异常userId.xlsx");
        for (ElkDTO elkDTO : list) {

            OrderConsignorDTO orderConsignorDTO = new OrderConsignorDTO();
            orderConsignorDTO.setOrderId(elkDTO.getId());
            orderConsignorDTO.setUserId(String.valueOf(elkDTO.getUserId()));
            System.out.println(JSON.toJSONString(orderConsignorDTO));
            NewApiTest.updateOrderConsignor("pre", orderConsignorDTO);
        }
    }


    @SneakyThrows
    public static void retrySyncEs() {

//        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[\n" +
//                "    {\n" +
//                "        \"awardType\": 5\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"pageIndex\": 1,\n" +
//                "        \"pageSize\": 50\n" +
//                "    }\n" +
//                "]");
//        System.out.println(JSON.toJSONString(orderList));


//        String filePath = "C:\\Users\\Administrator\\Desktop\\兑奖单重新同步.xlsx";
//        FileInputStream file = new FileInputStream(filePath);
//        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "兑奖单重新同步.xlsx");
//        for (ElkDTO elkDTO : list) {
//            if(elkDTO.getId()==null){
//                continue;
//            }
//            NewApiTest.retrySyncOrderByOrderIds("pre", elkDTO.getId());
//            Thread.sleep(100);
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
