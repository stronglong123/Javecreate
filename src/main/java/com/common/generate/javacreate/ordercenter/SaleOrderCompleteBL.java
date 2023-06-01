package com.common.generate.javacreate.ordercenter;

import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author xialei
 * @date 2023/5/31 17:47
 */
public class SaleOrderCompleteBL {


    @SneakyThrows
    public static void main(String[] args) {
//        NewApiTest.reTrdSaleOrderComplete("pre", 4220002305281105409L);

        String filePath = "C:\\Users\\Administrator\\Desktop\\重推商城数据.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "重推商城数据.xlsx");

        for (ElkDTO elkDTO : list) {
            if (elkDTO.getOrderId() == null) {
                continue;
            }
//            NewApiTest.reTrdSaleOrderComplete("pre", elkDTO.getOrderId());
            System.out.println("重推数据,orderId="+elkDTO.getOrderId()+",orderNo="+elkDTO.getOrderNo());
            Thread.sleep(100);
        }
    }
}
