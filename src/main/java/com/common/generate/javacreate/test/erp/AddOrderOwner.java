package com.common.generate.javacreate.test.erp;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.dto.SettleOrderItemDetailDTO;
import com.common.generate.javacreate.test.dto.SettlementOrderCreateDTO;
import com.common.generate.javacreate.test.dto.SettlementOrderItemCreateDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/8/9 11:28
 */
public class AddOrderOwner {

    public static void main(String[] args) throws Exception {
        List<GroupSettleInsertDTO> data = getData();
        convertSaveData(data);
    }


    public static List<GroupSettleInsertDTO> getData() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\福州异常处理\\要保存到bill表数据.xlsx";
        List<GroupSettleInsertDTO> list = ExcelUtils.readExcelToEntity(GroupSettleInsertDTO.class, filePath, "要保存到bill表数据.xlsx");
        list.stream().forEach(it->{
            it.setSettleMinUnitTotalCount(it.getOriginalMinUnitTotalCount());
            it.setMinUnitTotalCount(it.getOriginalMinUnitTotalCount());
        });

        System.out.println(JSON.toJSONString(list));
        return list;
    }

    public static void convertSaveData(List<GroupSettleInsertDTO> datas) {
        List<GroupSettleOrderBillInsertDTO> billInsertList = new ArrayList<>();
        List<GroupSettleOrderBillOwnerDTO> billOwnerInsertList = new ArrayList<>();
        List<SettlementOrderCreateDTO> orderCreateDTOS = new ArrayList<>();
        datas = datas.stream().filter(it -> it.getNeedFixed() != null && it.getNeedFixed().equals(1)).collect(Collectors.toList());
        for (GroupSettleInsertDTO data : datas) {
            billInsertList.add(convertBill(data));
            billOwnerInsertList.add(convertBillOwner(data));
//            orderCreateDTOS.add(convertOtherInOut(data));
        }

        System.out.println("billInsertList:" + JSON.toJSONString(billInsertList));
        System.out.println("billOwnerInsertList:" + JSON.toJSONString(billOwnerInsertList));
        System.out.println("orderCreateDTOS:" + JSON.toJSONString(orderCreateDTOS));

    }

    public static GroupSettleOrderBillInsertDTO convertBill(GroupSettleInsertDTO excelDto) {
        GroupSettleOrderBillInsertDTO billInsertDTO = new GroupSettleOrderBillInsertDTO();
        BeanUtils.copyProperties(excelDto, billInsertDTO);
        return billInsertDTO;
    }

    public static GroupSettleOrderBillOwnerDTO convertBillOwner(GroupSettleInsertDTO excelDto) {
        GroupSettleOrderBillOwnerDTO billOwnerInsertDTO = new GroupSettleOrderBillOwnerDTO();
        billOwnerInsertDTO.setBillId(excelDto.getBillId());
        billOwnerInsertDTO.setDispatchCount(excelDto.getOriginalMinUnitTotalCount());
        billOwnerInsertDTO.setDispatchSecProductOwnerId(excelDto.getSecOwnerId());
        billOwnerInsertDTO.setOrderType(excelDto.getOrderType());
        billOwnerInsertDTO.setOrgId(excelDto.getOrgId());
        billOwnerInsertDTO.setProductSpecId(excelDto.getProductSpecId());
        billOwnerInsertDTO.setSkuId(excelDto.getSkuId());
        billOwnerInsertDTO.setSettleOrderId(excelDto.getSettleOrderId());
        return billOwnerInsertDTO;
    }


    private static SettlementOrderCreateDTO convertOtherInOut(GroupSettleInsertDTO dto) {
        SettlementOrderCreateDTO createDTO = new SettlementOrderCreateDTO();
        Byte orderType = dto.getOrderType();
        /**出*/
        if (orderType == 11) {
            createDTO.setOrderType((byte) 64);
            createDTO.setChannelNo(110);
            createDTO.setOrderAmount(BigDecimal.ZERO);
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(dto.getOrgId());
            createDTO.setRelatedNoteNO(dto.getSettleNo());

            SettlementOrderItemCreateDTO itemCreateDTO = new SettlementOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getSkuId());
            itemCreateDTO.setProductName(dto.getSkuName());
            itemCreateDTO.setMinUnitTotalCount(dto.getOriginalMinUnitTotalCount());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO);

            SettleOrderItemDetailDTO itemDetailDTO = new SettleOrderItemDetailDTO();
            itemDetailDTO.setSecOwnerId(dto.getSecOwnerId());
            itemDetailDTO.setUnitTotalCount(dto.getOriginalMinUnitTotalCount());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        } else {
            /**入*/
            createDTO.setOrderType((byte) 89);
            createDTO.setChannelNo(110);
            createDTO.setOrderAmount(BigDecimal.ZERO);
            createDTO.setWarehouseId(dto.getWarehouseId());
            createDTO.setOrgId(dto.getOrgId());
            createDTO.setRelatedNoteNO(dto.getSettleNo());
            SettlementOrderItemCreateDTO itemCreateDTO = new SettlementOrderItemCreateDTO();
            itemCreateDTO.setProductSkuId(dto.getSkuId());
            itemCreateDTO.setProductName(dto.getSkuName());
            itemCreateDTO.setMinUnitTotalCount(dto.getOriginalMinUnitTotalCount());
            itemCreateDTO.setTotalAmount(BigDecimal.ZERO);

            SettleOrderItemDetailDTO itemDetailDTO = new SettleOrderItemDetailDTO();
            itemDetailDTO.setSecOwnerId(dto.getSecOwnerId());

            itemDetailDTO.setUnitTotalCount(dto.getOriginalMinUnitTotalCount());
            itemCreateDTO.setDetails(Collections.singletonList(itemDetailDTO));
            createDTO.setItems(Collections.singletonList(itemCreateDTO));
        }
        return createDTO;
    }
}
