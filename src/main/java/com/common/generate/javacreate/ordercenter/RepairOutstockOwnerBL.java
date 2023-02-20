package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.OutstockOwnerDTO;
import com.common.generate.javacreate.ordercenter.dto.WarehouseDataDTO;
import com.common.generate.javacreate.utils.ExcelUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xialei
 * @date 2022/9/29 10:25
 */
public class RepairOutstockOwnerBL {


    public static final int MAX_COUNT = 1000;
    public static final int MIN_COUNT = 100;


    public static void main(String[] args) throws Exception {
        String code = "pre";
        List<OutstockOwnerDTO> outstockOwnerDTOS = getWarehouseId();
        buildSql(outstockOwnerDTOS);
    }


    public static void buildSql(List<OutstockOwnerDTO> outstockOwnerDTOS){
        for (OutstockOwnerDTO outstockOwnerDTO : outstockOwnerDTOS) {
            StringBuilder stringBuilder =new StringBuilder();
            stringBuilder.append("update oms_order_2.orderitemproductowner set DispatchCount = ")
                    .append(outstockOwnerDTO.getAddCount())
                    .append(" where Id =").append(outstockOwnerDTO.getId()).append(";");
            System.out.println(stringBuilder.toString());
        }

    }



    private static List<OutstockOwnerDTO> getWarehouseId() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\出库二级货主数量修复.xlsx";
        List<OutstockOwnerDTO> outstockOwnerDTOS = ExcelUtils.readExcelToEntity(OutstockOwnerDTO.class, filePath, "金额异常bug.xlsx");
        return outstockOwnerDTOS;
    }


}
