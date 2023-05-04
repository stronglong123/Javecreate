package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.TemporaryDTO;
import com.common.generate.javacreate.ordercenter.dto.WarehouseSyncDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.springframework.util.ObjectUtils;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2023/4/14 9:29
 */
public class TemporaryTest {

    @SneakyThrows
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\待修复二级货主.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<TemporaryDTO> list = ExcelUtils.readExcelToEntity(TemporaryDTO.class, file, "待修复二级货主.xlsx");
        StringBuilder builder = new StringBuilder();
        for (TemporaryDTO temporary : list) {
            if (temporary.getId() == null) {
                continue;
            }
            if (!ObjectUtils.nullSafeEquals(temporary.getOmsItemId(), temporary.getOrderItemId()) ||
                    temporary.getRealSecCount().compareTo(temporary.getCount().divide(BigDecimal.valueOf(2)))!=0 ||
                    !ObjectUtils.nullSafeEquals(temporary.getSecOwnerId(), temporary.getRealSecOwnerId())) {
                System.out.println("非指定数据：" + JSON.toJSONString(temporary));
                continue;
            }
            builder.append("update ordercenter.order_item_secowner set count=")
                    .append(temporary.getRealSecCount())
                    .append(" where Id =")
                    .append(temporary.getId())
                    .append(";\n");

        }
        System.out.println(builder.toString());
    }
}
