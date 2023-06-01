package com.common.generate.javacreate.ordercenter;

import cn.hutool.db.DaoTemplate;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.controller.DiaryController;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
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
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
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
        orderIdSync();
    }


    @SneakyThrows
    public static void orderIdSync() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\未同步数据.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "未同步数据.xlsx");
        for (ElkDTO elkDTO : list) {
            if (elkDTO.getOrderId() == null) {
                continue;
            }
            NewApiTest.initOrderCenterByOmsorderIds("pre", elkDTO.getOrderId());

            System.out.println("同步订单"+elkDTO.getOrderId());
            Thread.sleep(100);

        }
    }


    public static void warehouseSync() {
        List<WarehouseSyncDTO> warehouseSyncs = getData();
        List<Long> warehouseList = new ArrayList<>();
        Integer count = 0;

        for (WarehouseSyncDTO warehouseSync : warehouseSyncs) {
            if (warehouseSync.getWarehouseId() == null) {
                continue;
            }
            if (checkWarehouse(warehouseSync.getWarehouseId().intValue())) {
                System.out.println("受限仓库，不处理" + warehouseSync.getWarehouseId());
                continue;
            }
            if (warehouseSync.getOmscount() != null && warehouseSync.getOmscount() >= 200000 && warehouseSync.getOmscount() < 500000 && warehouseSync.getOccount() <= 100) {
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
        int sleep = BigDecimal.valueOf(omscount / 50f).setScale(0, RoundingMode.UP).intValue();
        //1000/20S
        Thread.sleep(sleep * 2000);

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
                "  \"syncEs\":false,\n" +
                "  \"startTime\":\"2020-01-01 00:00:00\",\n"+
                "  \"endTime\":\"2022-01-01 00:00:00\",\n"+
                "  \"limitNum\":500,\n" +
                "  \"orderTypes\":[0, 2, 12, 31, 33, 35, 13, 116,20, 32, 21, 26, 27, 34, 36\n" +
                "                , 37, 38, 39, 40, 41, 42, 20, 22, 21, 23, 118,15]\n" +
                "}";
        String url = "http://openapi.pre.yijiupi.com/openapi/oms/initOrderCenterByWarehouseIds";
        String resultstr = HttpClientUtils.doPost(url, params);
        System.out.println(resultstr);
    }


    public static boolean checkWarehouse(Integer warehouseId){
        List<Integer> ykblWarehouseId = Arrays.asList(1254,4127,4515,4865,4916,4933,7064,7065,7186,7242,7244,7246,7247,7249,7592,7593,7594,7595,7596,7597,7598,7599,7603,7638,7657,9951,9952,10222,10823,10824,11721,11722,11723,11724,11725,11727,11744,11814,11815,11816,11817,11835,11913,18717,18719,18720,40050,40051,40052,40053,40054,40056,40057,40076,40082,40083,40089,40096,40128,40129,40130,40131,40141,40149,40287,40288,40289,40324,40325,40335,40336,41215,41221,46721,49610,70023,70024,70025,70026,70027,70028,70029,70030,70036,70044,70053,70312,70313,70314,70315,70316,70317,70410,70411,70417,70443,70452,70510,70611,70620,70622,70628,70629,70642,71225,71226,71227,71228,71229,71237,71238,71239,71240,71241,71257,75910,75911,75923,99111,99112,99113,99831,99840,99841,103102,103103,103144,9000056,9000057,9000058,9000059,10000011,10000021,10000022,40000011,40000012,40000013,40000014,40000015,40000021,40000022,40000031,40000041,40000042,70000011,70000012,70000013,70000014,70000021,70000022,70000023,70000024,70000025,70000026,70000027,70000028,70000031,70000032,70000033,70000034,70000035,70000041,70000042,90000011,90000012,999930038,23,24,301,321,331,1002,1013,1024,1072,1073,1079,1101,1175,1188,1221,1271,1291,1336,1343,1344,1571,1581,1582,1631,1671,1672,1681,1691,1701,1711,1772,1781,1821,1878,1881,1981,2017,2022,2041,2053,2061,2071,2081,2106,2111,2121,2131,2141,2151,2161,2181,2191,2201,2211,2221,2231,4022,4065,4101,4112,4194,4261,4271,4292,4341,4351,4382,4421,4601,4641,4651,4671,4751,4782,4801,4812,4831,4841,4861,4881,4891,4925,4932,4941,4951,4981,5021,5041,5052,7012,7013,7021,7037,7048,7063,7101,7151,7181,7204,7272,7273,7274,7292,7293,7392,7412,7413,7502,7516,7521,7541,7612,7633,7643,7653,7662,7676,7681,7691,7701,7711,7721,7741,9011,9012,9013,9014,9015,9016,9017,9018,9019,9021,9022,9023,9041,9042,9051,9052,9091,9092,9101,9111,9915,9983,9984,9992,9993,9994,9995,9996,9997,9998,9999,10069,10071,10389,10861,10875,20001,20021,20022,20023,20024,20025,20026,20028,20029,40016,40032,40098,47315,70001,70021,70110,75913,90110,90111,90115,99813,99910,99911,99912,99913,99915,99981,200210,200211,200214,999225,999226,999235,999236,999237,9000027,999930001,1034,1035,1036,1037,1038,1039,1187,1197,1198,1199,4002,4113,7152,9965,10310,10311,10312,10313,10314,10315,10316,10317,10318,10319,10320,10321,10322,10323,10324,10325,10326,10337,10340,11910,11911,40116,99917,99918,99920,99921,99922,99923,99924,99925,99926,99927,99928,99929,99930,99931,99932,99933,99934,99935,99936,99937,99938,99939,99940,99941,99942,99943,99944,99945,99946,99947,99948,99949,99950,99951,99952,99953,99954,99955,99956,99957,99958,99959,99960,99961,99962,99963,99964,99965,99966,99967,99968,99969,99971,99972,99973,99974,99975,99976,99977,99978,99979,99980,99982,99983,99984,99985,99986,99987,99988,99989,99990,99991,99992,99993,99994,99995,99996,99997,99998,99999,999100,999101,999102,999103,999104,999105,999106,999107,999108,999109,999110,999111,999112,999113,999114,999115,999116,999117,999118,999119,999120,999121,999122,999123,999124,999125,999126,999127,999128,999129,999130,999131,999132,999133,999134,999135,999136,999137,999138,999139,999140,999141,999142,999143,999144,999145,999146,999147,999148,999149,999150,999151,999152,999153,999154,999155,999156,999157,999158,999159,999160,999161,999162,999163,999164,999165,999166,999167,999168,999169,999170,999171,999172,999173,999174,999175,999176,999177,999178,999179,999180,999181,999182,999183,999184,999185,999186,999187,999188,999189,999190,999191,999192,999193,999194,999195,999196,999197,999198,999199,999200,999201,999202,999203,999204,999205,999206,999207,999208,999209,999210,999211,999212,999213,999214,999215,999216,999217,999218,999223,999224,999227,999228,999229,999231,999232,999233,999234,999238,999259,999260,1074,1075,1076,1077,1078,1083,1097,1122,1162,1163,1164,1165,1166,1167,1168,1216,1217,1218,1219,1254,1265,1266,1585,1586,1587,1589,1654,1656,1657,1712,1743,1744,1746,1747,1761,1762,1773,1782,1783,1784,1785,1786,1787,1792,1793,1794,1795,1796,1797,1798,1799,1801,1802,1803,1804,1805,1806,1807,1812,1813,1814,1815,1822,1823,1824,1825,1826,1831,1832,1833,1835,1836,1837,1842,1843,1844,1845,1846,1847,1848,1852,1862,1863,1864,1871,1872,1873,1874,1875,1876,1877,1879,1991,2011,2021,2031,2051,2101,4049,4122,4123,4127,4128,4217,4232,4235,4255,4256,4257,4413,4619,4729,4862,4865,4872,4894,4911,4912,4916,4921,4931,4933,4961,4962,4963,4964,4965,4966,4967,4968,5001,5023,7059,7064,7065,7094,7103,7118,7125,7242,7244,7542,7554,7591,7601,7603,7611,7621,7622,7632,7638,7641,7642,7651,7652,7657,7661,7671,7683,10520,10522,10582,10583,10816,11712,12110,15712,15713,15715,15716,15717,15718,15719,15720,15721,15723,15724,15810,15820,15821,16015,16525,18414,18710,18711,18712,18713,18714,18717,18718,18719,18720,18726,20027,40011,40012,40347,40349,40350,40463,40526,40530,40531,40532,40533,40534,41214,41221,41312,41315,41936,41937,41938,42515,42912,45712,46032,46033,46719,46918,47124,47125,47126,47127,47128,47129,47912,49610,70022,70133,70331,70412,70413,70414,70610,70612,70630,70637,71119,71120,71121,71218,71238,71241,71255,75616,75918,91622,91627,91638,91654,91688,402118,402121,916105,916111,70000021,11,1596461015,1607066261,1773814334,1775045771,0);
        return ykblWarehouseId.contains(warehouseId);
    }


}
