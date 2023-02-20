package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.ElkSourceDTO;
import com.common.generate.javacreate.utils.FileUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xialei
 * @date 2022/9/1 11:58
 */
public class ELKJSONParseBL {


    public static void main(String[] args){
        String data = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\es错误数据.txt");;
        List<ElkDTO> elkDTOS = JSON.parseArray(data, ElkDTO.class);
        System.out.println(JSON.toJSONString(elkDTOS));
        Set<String> orderNos =new HashSet<>();

        List<String> exsitsOrderList = getExsitsOrderList();
        for (ElkDTO elkDTO : elkDTOS) {
            ElkSourceDTO source = elkDTO.get_source();
            String message = source.getMessage();
            String[] split = message.split("，");
            for (String str : split) {
                if(str.contains("单号")){
                    String trim = str.replace("单号：", "").trim();
                    if(!exsitsOrderList.contains(trim)){
                        orderNos.add(trim);
                    }
                }
            }
        }
        System.out.println(JSON.toJSONString(orderNos));
    }


    private static List<String> getExsitsOrderList(){
        List<String> orderNoList =new ArrayList<>();
        String json ="134225800021,\n" +
                "134225800022,\n" +
                "134225800023,\n" +
                "134225800024,\n" +
                "134225800025,\n" +
                "134225800026,\n" +
                "134225800027,\n" +
                "134225900025,\n" +
                "134225900026,\n" +
                "134225900027,\n" +
                "134225900028,\n" +
                "134225900029,\n" +
                "134225900030,\n" +
                "137225800007,\n" +
                "139225800023-1,\n" +
                "139225800023-2,\n" +
                "139225800024,\n" +
                "139225800025,\n" +
                "139225800026,\n" +
                "139225800027,\n" +
                "139225800028,\n" +
                "139225800029,\n" +
                "139225900028,\n" +
                "139225900029,\n" +
                "141225800019,\n" +
                "141225800020,\n" +
                "141225800021,\n" +
                "141225800022,\n" +
                "141225800023,\n" +
                "141225900012,\n" +
                "141225900013,\n" +
                "746225800018,\n" +
                "746225800019-1,\n" +
                "746225800019-2,\n" +
                "746225800020,\n" +
                "746225800021,\n" +
                "746225800022,\n" +
                "746225900017,\n" +
                "746225900018";
        String[] split = json.split(",");
        for (String str : split) {
            orderNoList.add(str.trim());
        }
        return orderNoList;
    }


    private void parseOrderId(){
        String data = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\es错误数据.txt");;
        List<ElkDTO> elkDTOS = JSON.parseArray(data, ElkDTO.class);
        System.out.println(JSON.toJSONString(elkDTOS));
        List<Long> orderIdList = new ArrayList<>();
        Set<Integer> warehouseIds =new HashSet<>();
        for (ElkDTO elkDTO : elkDTOS) {
            ElkSourceDTO source = elkDTO.get_source();
            String message = source.getMessage();
            if(message.contains("warehouseId=9981")){
                continue;
            }

            String[] split = message.split(",");
            for (String str : split) {
                if(str.contains("warehouseId")){
                    String trim = str.replace("warehouseId=", "").trim();
                    warehouseIds.add(Integer.valueOf(trim));
                }
                if(str.contains("orderId")){
                    String trim = str.replace("orderId=", "").trim();
                    orderIdList.add(Long.valueOf(trim));
                }

            }
        }

        System.out.println(JSON.toJSONString(orderIdList));
        System.out.println(JSON.toJSONString(warehouseIds));
    }



}
