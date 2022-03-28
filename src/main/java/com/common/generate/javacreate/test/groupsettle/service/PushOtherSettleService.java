package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.dto.SettleOrderItemDetailDTO;
import com.common.generate.javacreate.test.dto.SettlementOrderCreateDTO;
import com.common.generate.javacreate.test.dto.SettlementOrderItemCreateDTO;
import com.common.generate.javacreate.test.groupsettle.dto.PushOtherSettleDTO;
import com.common.generate.javacreate.utils.ExcelUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xialei
 * @date 2022/1/28 10:29
 */
public class PushOtherSettleService {


    public static void main(String[] args) throws Exception {
        List<PushOtherSettleDTO> data = getData();
        System.out.println("获取数据:" + JSON.toJSONString(data));
        List<SettlementOrderCreateDTO> createDTOS = convertOtherInOut(data);
        System.out.println("推送数据:" + JSON.toJSONString(createDTOS));
    }


    public static List<PushOtherSettleDTO> getData() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\团购其他出入数据.xlsx";
        List<PushOtherSettleDTO> list = ExcelUtils.readExcelToEntity(PushOtherSettleDTO.class, filePath, "推送其他出入.xlsx");
        return list;
    }

    private static List<SettlementOrderCreateDTO> convertOtherInOut(List<PushOtherSettleDTO> datas) {
        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        List<SettlementOrderCreateDTO> settlementOrderCreateList = new ArrayList<>();
        datas.forEach(it -> {
            if (it.getProductSkuId() != null && (it.getHasSend() == null || it.getHasSend() != 1)) {
                if (it.getOwnerId() == null || it.getOwnerId() < 0) {
                    it.setOwnerId(null);
                }
                SettlementOrderCreateDTO settlementOrderCreateDTO = convertOtherInOut(it);
                settlementOrderCreateList.add(settlementOrderCreateDTO);
            }
        });
        return settlementOrderCreateList;
    }

    private static SettlementOrderCreateDTO convertOtherInOut(PushOtherSettleDTO dto) {
        SettlementOrderCreateDTO createDTO = new SettlementOrderCreateDTO();
        Integer orderType = dto.getOrderType();

        /**出*/
        if (orderType == 1) {
            createDTO.setOrderType((byte) 64);
            createDTO.setChannelNo(110);
            createDTO.setOrderAmount(BigDecimal.ZERO);
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(dto.getOrgId());
            createDTO.setRelatedNoteNO(dto.getRelatedNoteNO());

            SettlementOrderItemCreateDTO itemCreateDTO = new SettlementOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getProductSkuId());
            itemCreateDTO.setProductName(dto.getProductName());
            itemCreateDTO.setMinUnitTotalCount(dto.getUnitTotalCount());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO);

            SettleOrderItemDetailDTO itemDetailDTO = new SettleOrderItemDetailDTO();
            itemDetailDTO.setSecOwnerId(dto.getSecOwnerId());
            itemDetailDTO.setUnitTotalCount(dto.getUnitTotalCount());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        } else {
            /**入*/
            createDTO.setOrderType((byte) 89);
            createDTO.setChannelNo(110);
            createDTO.setOrderAmount(BigDecimal.ZERO);
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(dto.getOrgId());
            createDTO.setRelatedNoteNO(dto.getRelatedNoteNO());
            SettlementOrderItemCreateDTO itemCreateDTO = new SettlementOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getProductSkuId());
            itemCreateDTO.setProductName(dto.getProductName());
            itemCreateDTO.setMinUnitTotalCount(dto.getUnitTotalCount());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO);
            SettleOrderItemDetailDTO itemDetailDTO = new SettleOrderItemDetailDTO();
            itemDetailDTO.setSecOwnerId(dto.getSecOwnerId());
            itemDetailDTO.setUnitTotalCount(dto.getUnitTotalCount());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        }
        return createDTO;
    }
}
