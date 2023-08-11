package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.RepairAddressIdDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderConsignorDTO;
import com.common.generate.javacreate.utils.FileUtil;
import lombok.SneakyThrows;
import net.sf.jsqlparser.expression.LongValue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xialei
 * @date 2023/5/13 10:15
 */
public class aaaa {








    @SneakyThrows
    public static void main(String[] args){
        List<RepairAddressIdDTO> addressIdDTOS = readFileByLines("C:\\Users\\Administrator\\Desktop\\addressId修复.txt");
        System.out.println(JSON.toJSONString(addressIdDTOS));
        for (RepairAddressIdDTO addressIdDTO : addressIdDTOS) {
            OrderConsignorDTO orderConsignorDTO = new OrderConsignorDTO();
            orderConsignorDTO.setOrderId(addressIdDTO.getOrderId());
            orderConsignorDTO.setAddressId(addressIdDTO.getTrdAddressId());
            System.out.println(JSON.toJSONString(orderConsignorDTO));
            NewApiTest.updateOrderConsignor("pre",orderConsignorDTO);
            Thread.sleep(100L);
        }
    }

    public static List<RepairAddressIdDTO> readFileByLines(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        List<RepairAddressIdDTO> addressIdDTOS = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String[] split = tempString.split(",");
                RepairAddressIdDTO repairAddressIdDTO = new RepairAddressIdDTO();
                repairAddressIdDTO.setOrderId(Long.valueOf(split[0]));
                repairAddressIdDTO.setAddressId(Long.valueOf(split[1]));
                repairAddressIdDTO.setTrdAddressId(Long.valueOf(split[2]));
                addressIdDTOS.add(repairAddressIdDTO);
                line++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e1) {
                }
            }
        }
//        return stringBuilder.toString();
        return addressIdDTOS;
    }

}
