package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.RepairBusinessItemIdDTO;
import com.common.generate.javacreate.ordercenter.dto.ReturnCompleteError;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/12/23 15:09
 */
public class ExcelParse {


    public static void main(String[] args) throws Exception {
//        fixReturnComplete();
        fixReturnAuditOrder();
    }



    @SneakyThrows
    public static void fixReturnAuditOrder(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\退货单审核异常数据.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "退货单异常数据.xlsx");
        List<ElkDTO> resultList = list.stream().filter(it -> it.getBusinessItemId() != null).collect(Collectors.toList());

        for (ElkDTO elkDTO : resultList) {
            if(ObjectUtils.nullSafeEquals(elkDTO.getIsFix(),1)){
                continue;
            }
            RepairBusinessItemIdDTO repairBusinessItemIdDTO =new RepairBusinessItemIdDTO();
            repairBusinessItemIdDTO.setOrderId(elkDTO.getOrderId());
            repairBusinessItemIdDTO.setOrderItemId(elkDTO.getItemId());
            repairBusinessItemIdDTO.setBusinessItemId(elkDTO.getBusinessItemId().toString());
            repairBusinessItemIdDTO.setSourceOrderItemId(elkDTO.getSaleItemId());
            System.out.println(JSON.toJSONString(repairBusinessItemIdDTO));
            NewApiTest.repairReturnOrderBusinessItemId(repairBusinessItemIdDTO);
        }
    }

    @SneakyThrows
    public static void fixReturnComplete(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\退货单完成异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ReturnCompleteError> list = ExcelUtils.readExcelToEntity(ReturnCompleteError.class, file, "退货单异常数据.xlsx");
        List<ReturnCompleteError> resultList = list.stream().filter(it -> it.getReturnOrderId() != null).collect(Collectors.toList());

        List<Long> saleOrderIdList = new ArrayList<>();
        List<Long> returnOrderIdList = new ArrayList<>();
        for (ReturnCompleteError returnCompleteError : resultList) {
            if (ObjectUtils.nullSafeEquals(returnCompleteError.getIsFix(), 1)) {
                continue;
            }
            if(returnCompleteError.getSaleState().equals(402)){
                saleOrderIdList.add(returnCompleteError.getSaleOrderId());
            }
            if(returnCompleteError.getReturnState().equals(700)){
                returnOrderIdList.add(returnCompleteError.getReturnOrderId());
            }
        }


        if(CollectionUtils.isNotEmpty(saleOrderIdList)){
            System.out.println("修复销售单id=" + JSON.toJSONString(saleOrderIdList));
            for (Long saleOrderId : saleOrderIdList) {
                Thread.sleep(500);
                NewApiTest.evnetTrySaleComplete(saleOrderId);
            }
        }

//        if (CollectionUtils.isNotEmpty(returnOrderIdList)) {
//            System.out.println("修复退货单id=" + JSON.toJSONString(returnOrderIdList));
//            for (Long returnOrderId : returnOrderIdList) {
//                Thread.sleep(500);
//                NewApiTest.repairReturnComplete(returnOrderId);
//            }
//        }


    }


}
