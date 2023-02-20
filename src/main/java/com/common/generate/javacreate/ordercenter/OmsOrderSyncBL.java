package com.common.generate.javacreate.ordercenter;

import cn.hutool.db.DaoTemplate;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.controller.DiaryController;
import com.common.generate.javacreate.ordercenter.dto.WarehouseSyncDTO;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xialei
 * @date 2023/2/10 11:19
 */
@Component
public class OmsOrderSyncBL {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmsOrderSyncBL.class);


    @SneakyThrows
    public static void main(String[] args) {
        warehouseSync();
    }


    public static void warehouseSync() {
        List<WarehouseSyncDTO> warehouseSyncs = getData();
        List<Long> warehouseList = new ArrayList<>();
        Integer count = 0;

        for (WarehouseSyncDTO warehouseSync : warehouseSyncs) {
            if (warehouseSync.getWarehouseId() == null) {
                continue;
            }
            if (warehouseSync.getOmscount() != null && warehouseSync.getOmscount() >= 10000 && warehouseSync.getOmscount() < 50000) {
                initOrderCenterByWarehouseIds(warehouseSync.getWarehouseId());
                System.out.println(DateUtils.date2String(new Date()) + " 已修复仓库=" + warehouseSync.getWarehouseId() + " 已修复数量=" + warehouseSync.getOmscount());
                warehouseList.add(warehouseSync.getWarehouseId());
                count += warehouseSync.getOmscount();
                sleep(warehouseSync.getOmscount());
            }
        }
        System.out.printf("%s 修复总数量=%s,仓库id=%s%n",DateUtils.date2String(new Date()), count, JSON.toJSONString(warehouseList));
    }

    @SneakyThrows
    private static void sleep(Integer omscount) {
        int sleep = BigDecimal.valueOf(omscount / 500f).setScale(0, RoundingMode.UP).intValue();
        //1000/20S
        Thread.sleep(sleep * 20000);
    }


    @SneakyThrows
    private static List<WarehouseSyncDTO> getData() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\中台未同步数据比对.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<WarehouseSyncDTO> list = ExcelUtils.readExcelToEntity(WarehouseSyncDTO.class, file, "中台未同步数据比对.xlsx");
        return list;
    }


    public static void initOrderCenterByWarehouseIds(Long warehouseId) {
        String params = "{\n" +
                "  \"warehouseIds\": [\n" +
                warehouseId +
                "  ],\n" +
                "  \"limitNum\":500,\n" +
                "  \"orderTypes\":[0, 2, 12, 31, 33, 35, 13, 116,20, 32, 21, 26, 27, 34, 36\n" +
                "                , 37, 38, 39, 40, 41, 42, 20, 22, 21, 23, 118,15]\n" +
                "}";
        String url = "http://openapi.pre.yijiupi.com/openapi/oms/initOrderCenterByWarehouseIds";
        String resultstr = HttpClientUtils.doPost(url, params);
    }


}
