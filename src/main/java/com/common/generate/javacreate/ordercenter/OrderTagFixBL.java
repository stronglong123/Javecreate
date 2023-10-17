package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.constants.SaleOrderDataConstant;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderTagDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author xialei
 * @date 2023/10/17 17:25
 */
public class OrderTagFixBL {



    public static void main(String[] args){

        reparitOrderFeature();

    }


    @SneakyThrows
    public static void reparitOrderFeature(){

        String filePath = "C:\\Users\\Administrator\\Desktop\\订单特征修复.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "订单特征修复.xlsx");
        for (ElkDTO elkDTO : list) {
            Long orderId = elkDTO.getId();
            Integer featureType = elkDTO.getFeatureType();

            OrderTagDTO orderTagDTO = new OrderTagDTO();
            orderTagDTO.setCompanyCode("YJP");
            orderTagDTO.setOrderId(orderId);
            orderTagDTO.setTagType(featureType);
            orderTagDTO.setTagTypeTxt(SaleOrderDataConstant.getFeatureName(featureType));
            orderTagDTO.setPartnerCode("YJP-TRD");
            orderTagDTO.setDescription("");
            System.out.println(JSON.toJSONString(orderTagDTO));
            NewApiTest.reparitOrderFeature("pre",orderTagDTO);
        }
    }
}
