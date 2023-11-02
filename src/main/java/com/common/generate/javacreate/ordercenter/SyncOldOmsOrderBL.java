package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderCenterMarkDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author xialei
 * @date 2023/10/12 10:49
 */
public class SyncOldOmsOrderBL {


    public static void main(String[] args){
//        returnOrderStateSyncOldOms();




    }




    @SneakyThrows
    private static void returnOrderStateSyncOldOmsByExcel(){
        String code = "pre";


        String filePath = "C:\\Users\\Administrator\\Desktop\\老oms退货单状态更新.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "老oms退货单状态更新.xlsx");
        for (ElkDTO elkDTO : list) {
            Long orderId = elkDTO.getId();

            OrderCenterMarkDTO orderCenterMark = new OrderCenterMarkDTO();
            orderCenterMark.setOmsOrderId(orderId);
            orderCenterMark.setMarkWarehouseId(elkDTO.getWarehouseId());
            orderCenterMark.setState(2);
            orderCenterMark.setUserId(1L);
            boolean orderCenterOrder = NewApiTest.isOrderCenterOrder(code, orderId);
            if(!orderCenterOrder){
                System.out.println("非中台流程单据:"+orderId);
                continue;
            }
            System.out.println(JSON.toJSONString(orderCenterMark));
            NewApiTest.orderCenterMarKAdjustOldOms(code, orderCenterMark);
            Thread.sleep(200L);
        }
    }


    @SneakyThrows
    private static void returnOrderStateSyncOldOmsByOrderId(){
        String code = "pre";

        List<Long> orderIds = Arrays.asList();

//        for (Long orderId : orderIds) {
//            List<OrderDocumentDTO> orders = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderId\":" + orderId + ",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
//            if(CollectionUtils.isEmpty(orders)){
//                continue;
//            }
//            OrderDocumentDTO orderDocumentDTO = orders.get(0);
//            OrderCenterMarkDTO orderCenterMark = new OrderCenterMarkDTO();
//            orderCenterMark.setOmsOrderId(orderId);
//            orderCenterMark.setMarkWarehouseId(elkDTO.getWarehouseId());
//            orderCenterMark.setState(2);
//            orderCenterMark.setUserId(1L);
//            boolean orderCenterOrder = NewApiTest.isOrderCenterOrder(code, orderId);
//            if(!orderCenterOrder){
//                System.out.println("非中台流程单据:"+orderId);
//                continue;
//            }
//            System.out.println(JSON.toJSONString(orderCenterMark));
//            NewApiTest.orderCenterMarKAdjustOldOms(code, orderCenterMark);
//            Thread.sleep(200L);
//        }
    }

}
