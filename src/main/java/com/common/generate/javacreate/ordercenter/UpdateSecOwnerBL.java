package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.UpdateSecOwnerDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2023/5/6 13:50
 */
public class UpdateSecOwnerBL {


    @SneakyThrows
    public static void main(String[] args){
//        dealData();
//        String filePath = "C:\\Users\\Administrator\\Desktop\\二级或组合数量修复.xlsx";
//        FileInputStream file = new FileInputStream(filePath);
//        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "二级或组合数量修复.xlsx");
//        for (ElkDTO elkDTO : list) {
//            UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
//            updateSecOwnerDTO.setId(elkDTO.getSecId());
//            updateSecOwnerDTO.setCount(elkDTO.getWorkingItemCount());
//            System.out.println(JSON.toJSONString(updateSecOwnerDTO));
//            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
//        }



//        List<Long> orderList = Arrays.asList(5125843791303534862L,5125843791303534863L,5125843791303534864L,5125843791303534865L,5125843791303534866L,5125843791303534867L,5125843791303534868L,5125843791303534869L,5125843791303534870L,5125843791303534871L,5125843791303534872L,5125843791303534873L,5125843791303534874L,5125843791303534875L,5125843791303534876L,5125843791303534877L
//                );
//        for (Long orderId : orderList) {
//            UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
//            updateSecOwnerDTO.setId(orderId);
//            updateSecOwnerDTO.setWarehouseId(1031);
//            System.out.println(JSON.toJSONString(updateSecOwnerDTO));
//            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
//        }


        Map<Long, BigDecimal> map = new HashMap<>();
        map.put(5228792477783938736L, BigDecimal.valueOf(4));



        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
            updateSecOwnerDTO.setId(entry.getKey());
            updateSecOwnerDTO.setCount(entry.getValue());
            System.out.println(JSON.toJSONString(updateSecOwnerDTO));
            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
        }
    }


    @SneakyThrows
    public static void dealData() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\经销商单缺货异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "经销商单缺货异常.xlsx");
        for (ElkDTO elkDTO : list) {
            if (elkDTO.getItemId() == null) {
                continue;
            }
            if (elkDTO.getCount().compareTo(elkDTO.getWorkingItemCount()) == 0
                    && elkDTO.getCount().compareTo(elkDTO.getOriginalCount()) != 0) {
                UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
                updateSecOwnerDTO.setId(elkDTO.getId());
                updateSecOwnerDTO.setOrderItemId(elkDTO.getItemId());
                updateSecOwnerDTO.setOrderId(elkDTO.getOrderId());
                updateSecOwnerDTO.setCount(elkDTO.getCount());
                System.out.println(JSON.toJSONString(updateSecOwnerDTO));
                //            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
            }
        }
    }
}
