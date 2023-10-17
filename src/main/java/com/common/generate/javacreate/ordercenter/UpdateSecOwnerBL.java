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



//        List<Long> orderList = Arrays.asList(
//                );
//        for (Long orderId : orderList) {
//            UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
//            updateSecOwnerDTO.setId(orderId);
//            updateSecOwnerDTO.setWarehouseId(71235);
//            System.out.println(JSON.toJSONString(updateSecOwnerDTO));
//            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
//        }


        Map<Long, BigDecimal> map = new HashMap<>();
        map.put(5243610284908393485L, BigDecimal.valueOf(6));
        map.put(5243612484839238786L, BigDecimal.valueOf(24));
        map.put(5243612484839238787L, BigDecimal.valueOf(24));
        map.put(5243612484839238788L, BigDecimal.valueOf(6));
        map.put(5243612484839238790L, BigDecimal.valueOf(13));
        map.put(5243612484839238789L, BigDecimal.valueOf(13));
        map.put(5243636980936127491L, BigDecimal.valueOf(28));
        map.put(5243636981074539534L, BigDecimal.valueOf(6));
        map.put(5243650400876016640L, BigDecimal.valueOf(24));

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
