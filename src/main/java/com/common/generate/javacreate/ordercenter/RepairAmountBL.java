package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.SpiDTO;
import com.common.generate.javacreate.ordercenter.dto.WarehouseDataDTO;
import com.common.generate.javacreate.utils.ExcelUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xialei
 * @date 2022/9/29 10:25
 */
public class RepairAmountBL {


    public static final int MAX_COUNT = 1000;
    public static final int MIN_COUNT = 100;


    public static void main(String[] args) throws Exception {
        String code = "pre";
        List<WarehouseDataDTO> warehouseDatas = getWarehouseId();
        repairByWarehouse(code, warehouseDatas);

    }

    private static void repairByWarehouse(String code, List<WarehouseDataDTO> warehouseDatas) throws Exception {
        List<Integer> repairWarehouseIds = new ArrayList<>();
        for (WarehouseDataDTO warehouseData : warehouseDatas) {
            Integer count = warehouseData.getCount();
            Params params = new Params();
            params.setSyncFms(false);
            params.setNeedUpdate(true);
            params.setWarehouseIds(Collections.singletonList(warehouseData.getWarehouseId()));
            System.out.println("修复仓库id:" + warehouseData.getWarehouseId());
            if (count > MAX_COUNT || count < MIN_COUNT) {
                System.out.println(String.format("修复仓库id:%s,数量大于%s不处理", warehouseData.getWarehouseId(), MAX_COUNT));
                continue;
            }
            try {
                ApiUtil.repairOriginDiscountAmount(code, params);
            } catch (Exception e) {
                Thread.sleep(count * 20L);
            }
            repairWarehouseIds.add(warehouseData.getWarehouseId());
        }
        System.out.println("修复仓库Id集合:" + JSON.toJSONString(repairWarehouseIds));
    }


    private static List<WarehouseDataDTO> getWarehouseId() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\金额异常bug.xlsx";
        List<WarehouseDataDTO> warehouseDataDTOS = ExcelUtils.readExcelToEntity(WarehouseDataDTO.class, filePath, "金额异常bug.xlsx");
        return warehouseDataDTOS;
    }

    static class Params {
        private List<Long> orderIds;
        private List<Integer> warehouseIds;
        private Boolean needUpdate;
        private Boolean syncFms;

        public List<Long> getOrderIds() {
            return orderIds;
        }

        public void setOrderIds(List<Long> orderIds) {
            this.orderIds = orderIds;
        }

        public List<Integer> getWarehouseIds() {
            return warehouseIds;
        }

        public void setWarehouseIds(List<Integer> warehouseIds) {
            this.warehouseIds = warehouseIds;
        }

        public Boolean getNeedUpdate() {
            return needUpdate;
        }

        public void setNeedUpdate(Boolean needUpdate) {
            this.needUpdate = needUpdate;
        }

        public Boolean getSyncFms() {
            return syncFms;
        }

        public void setSyncFms(Boolean syncFms) {
            this.syncFms = syncFms;
        }
    }

}
