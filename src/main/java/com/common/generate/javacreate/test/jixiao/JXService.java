package com.common.generate.javacreate.test.jixiao;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.dto.Inventorycheck;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/8/26 14:46
 */
public class JXService {


    public static void main(String[] args) throws Exception {
        getData();
    }

    public static void getData() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\绩效数据.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<JXDTO> list = ExcelUtils.readExcelToEntity(JXDTO.class, file, "绩效数据.xlsx");
        System.out.println(JSON.toJSONString(list));
        list = list.stream().filter(it -> it.getType()!=null).collect(Collectors.toList());

        createSql(list);
    }

    public static void createSql(List<JXDTO> list) {
        StringBuilder pickSqls = new StringBuilder();
        StringBuilder driverSqls = new StringBuilder();

        for (JXDTO jxdto : list) {
            if (jxdto.getType() == 2) {
                pickSqls.append(createPickSql(jxdto));
            } else if (jxdto.getType() == 1) {
                driverSqls.append(createDriverSql(jxdto));
            }
        }
        System.out.println(pickSqls.toString());
        System.out.println(driverSqls.toString());

    }

    public static String createPickSql(JXDTO dto) {
        return String.format("UPDATE sc_pickstatistics.warehouse_sort_efficiency SET WarehouseId = %s,WarehouseName = '%s'  WHERE OutWarehouseId = '%s';",
                dto.getWarehouseId(), dto.getOutWarehouseName(), dto.getOutWarehouseId());
    }

    public static String createDriverSql(JXDTO dto){
        return String.format("UPDATE sc_pickstatistics.`driversettlement` SET Warehouse_Id = %s,WarehouseName = '%s' WHERE Warehouse_Id = 0 AND Source = 111 AND DeliveryTime > '2021-08-01 00:00:00' AND AssociatedWarehouse_Id = '%s';",
                dto.getWarehouseId(), dto.getOutWarehouseName(), dto.getOutWarehouseId());
    }

}
