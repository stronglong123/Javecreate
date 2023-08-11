package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.UpdateSecOwnerDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author xialei
 * @date 2023/6/28 12:55
 */
public class completePushBL {

    public static void main(String[] args){
        saleOrderComplete();
//        returnOrderComplete();
    }


    @SneakyThrows
    public static void saleOrderComplete() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\易款便利重推.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "易款便利重推.xlsx");
        for (ElkDTO elkDTO : list) {
            if (elkDTO.getOrderId() == null) {
                continue;
            }
            System.out.println(JSON.toJSONString(elkDTO.getOrderId()));
            NewApiTest.repairSaleComplete("pre", elkDTO.getOrderId());
            Thread.sleep(100);
        }
    }


    public static void returnOrderComplete(){
        List<Long> orderIds = Arrays.asList(

                );

        for (Long orderId : orderIds) {

            NewApiTest.repairReturnComplete("pre", orderId);
        }
    }
}
