package com.common.generate.javacreate.ordercenter;

import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.PushTmsPayConfirmDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author xialei
 * @date 2023/5/31 17:47
 */
public class SaleOrderCompleteBL {


    @SneakyThrows
    public static void main(String[] args) {

//        NewApiTest.reTrdSaleOrderComplete("pre", 1580002306271670939L);

        String filePath = "C:\\Users\\Administrator\\Desktop\\takecount数量异常订单.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "takecount数量异常订单.xlsx");

        for (ElkDTO elkDTO : list) {
            if (elkDTO.getOrderId() == null) {
                continue;
            }
            System.out.println("重推数据,orderId="+elkDTO.getOrderId()+",orderNo="+elkDTO.getOrderNo());
            NewApiTest.reTrdSaleOrderComplete("pre", elkDTO.getOrderId());
            Thread.sleep(1500);
        }
    }
}
