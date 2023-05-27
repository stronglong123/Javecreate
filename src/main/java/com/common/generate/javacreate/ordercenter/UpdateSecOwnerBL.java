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
//        String filePath = "C:\\Users\\Administrator\\Desktop\\二级货主仓库异常2.xlsx";
//        FileInputStream file = new FileInputStream(filePath);
//        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "二级货主仓库异常2.xlsx");
//        for (ElkDTO elkDTO : list) {
//            UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
//            updateSecOwnerDTO.setId(elkDTO.getId());
//            updateSecOwnerDTO.setCount(elkDTO.getCount());
//            System.out.println(JSON.toJSONString(updateSecOwnerDTO));
//            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
//        }



//        List<Long> orderList = Arrays.asList(5186970771933532744L,
//                5187305362630106595L,
//                5187305659083513325L);
//        for (Long orderId : orderList) {
//            UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
//            updateSecOwnerDTO.setId(orderId);
//            updateSecOwnerDTO.setCount(BigDecimal.ONE);
//            System.out.println(JSON.toJSONString(updateSecOwnerDTO));
//            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
//        }


        Map<Long, BigDecimal> map = new HashMap<>();
        map.put(5189193182650908294L,BigDecimal.valueOf(3));
        map.put(5189639907165421198L,BigDecimal.valueOf(15));
        map.put(5188402040259220199L,BigDecimal.valueOf(1));


        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            UpdateSecOwnerDTO updateSecOwnerDTO = new UpdateSecOwnerDTO();
            updateSecOwnerDTO.setId(entry.getKey());
            updateSecOwnerDTO.setCount(entry.getValue());
            System.out.println(JSON.toJSONString(updateSecOwnerDTO));
            NewApiTest.updateItemSercOwner("pre", updateSecOwnerDTO);
        }
    }
}
