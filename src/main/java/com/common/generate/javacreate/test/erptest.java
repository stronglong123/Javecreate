package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.test.dto.Inventorycheck;
import com.common.generate.javacreate.test.groupsettle.dto.OrderCompleteItemMqDTO;
import com.common.generate.javacreate.test.groupsettle.dto.OrderItemProductOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.dto.SettleOrderCompleteMqDTO;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import com.common.generate.javacreate.utils.StringUtil;
import com.common.generate.javacreate.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2021/8/5 15:18
 */
public class erptest {


    public static void main(String[] args) throws Exception {
//        getErp();
        Long a =1L;
        ErpDTO dto =new ErpDTO();
        Map<String, Object> map = JSON.parseObject(JSON.toJSONString(dto));
    }



    public static void getErp() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\福州异常处理\\异常处理.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ErpDTO> list = ExcelUtils.readExcelToEntity(ErpDTO.class, file, "异常处理.xlsx");
        System.out.println(JSON.toJSONString(list));

    }


    public static void convertErp(List<ErpDTO> list){
        SettleOrderCompleteMqDTO mqDTO =new SettleOrderCompleteMqDTO();

    }


    private static SettleOrderCompleteMqDTO convertComplete(ErpDTO dto, Integer type) {
        Long orderId = UUIDUtil.getUuid();
        Long orderItemId = UUIDUtil.getUuid();

        SettleOrderCompleteMqDTO completeMqDTO = new SettleOrderCompleteMqDTO();
        completeMqDTO.setCompanyCode(dto.getCompanyCode());
        completeMqDTO.setOrderSource((byte) 0);
        completeMqDTO.setUserId(dto.getUserId());
        completeMqDTO.setWarehouseId(dto.getWarehouseId());
        completeMqDTO.setOrgId(dto.getOrgId());
        completeMqDTO.setOrderCreateTime(DateUtils.getCurrentTime());
        completeMqDTO.setOrderCompleteTime(DateUtils.getCurrentTime());
        completeMqDTO.setOrderAmount(BigDecimal.ZERO);
        completeMqDTO.setPayableAmount(BigDecimal.ZERO);
        completeMqDTO.setOmsOrderId(orderId);
        completeMqDTO.setOrderNo(dto.getOrderNo() + "w");
        completeMqDTO.setOrderType(dto.getOrderType());
        completeMqDTO.setBusinessType(dto.getBusinessType());
        completeMqDTO.setDeliveryCarId(dto.getDeliveryCarId());
        completeMqDTO.setDeliveryCarName(dto.getDeliveryCarName());
        completeMqDTO.setDeliveryMode(dto.getDeliveryMode());
        completeMqDTO.setOrderSource(dto.getOrderSource());
        completeMqDTO.setStevedoreUserId(dto.getStevedoreUserId());
        completeMqDTO.setStevedoreUserName(dto.getStevedoreUserName());

        OrderCompleteItemMqDTO itemMqDTO = new OrderCompleteItemMqDTO();
        itemMqDTO.setOrderItemId(orderItemId);
        itemMqDTO.setMinUnitTotalCount(dto.getMinUnitTotalCount());
        itemMqDTO.setProductSkuId(dto.getProductSkuId());
        itemMqDTO.setProductName(dto.getProductName());
        itemMqDTO.setSellPrice(BigDecimal.ZERO);
        itemMqDTO.setSellUnit(dto.getUnitName());
        itemMqDTO.setSpecificationId(dto.getSpecificationId());
        itemMqDTO.setOrderItemId(dto.getOmsOrderItemId());
        itemMqDTO.setTakeCount(dto.getMinUnitTotalCount());
        itemMqDTO.setBuyCount(dto.getMinUnitTotalCount());
        itemMqDTO.setDeliveryCount(dto.getMinUnitTotalCount());
        itemMqDTO.setLackCount(BigDecimal.ZERO);
        itemMqDTO.setDelayCount(BigDecimal.ZERO);
        itemMqDTO.setTotalAmount(BigDecimal.ZERO);
        itemMqDTO.setPayableAmount(BigDecimal.ZERO);
        itemMqDTO.setPackageName(dto.getPackageName());
        itemMqDTO.setUnitName(dto.getUnitName());
        itemMqDTO.setReduceBonusAmount(BigDecimal.ZERO);
        itemMqDTO.setReduceCouponAmount(BigDecimal.ZERO);
        itemMqDTO.setReduceOrderAmount(BigDecimal.ZERO);
        itemMqDTO.setReduceProductAmount(BigDecimal.ZERO);
        itemMqDTO.setReduceProductPrice(BigDecimal.ZERO);
        itemMqDTO.setSpecQuantity(dto.getSaleSpecQuantity());
        itemMqDTO.setSaleSpecQuantity(dto.getSaleSpecQuantity());


        OrderItemProductOwnerDTO ownerDTO = new OrderItemProductOwnerDTO();
        ownerDTO.setCount(dto.getCount());
        ownerDTO.setDispatchCount(dto.getCount());
        ownerDTO.setSecOwnerId(dto.getSecOwnerId());
        itemMqDTO.setSecOwnerDetail(Arrays.asList(ownerDTO));
        completeMqDTO.setItems(Arrays.asList(itemMqDTO));
        return completeMqDTO;
    }


    public static void getParams(){
        String json ="id orgId payType orderNo omsOrderId salesmanId CompanyCode deliveryCarId DeliveryCarName DeliveryMode orderSource deliveryState userId useCouponAmount deliveryUserId DeliveryUserName OrderType BusinessType    State warehouseId CreateTime OrderCreateTime stevedoreUserId StevedoreUserName omsOrderItemId productSkuId PackageName UnitName ProductName saleSpecQuantity specificationId MinUnitTotalCount count secOwnerId";
        String[] strings = json.split(" ");
        StringBuffer buffer =new StringBuffer();
        for (String string : strings) {
            if(StringUtils.isEmpty(string)){
                continue;
            }
            buffer.append("private String ").append(StringUtil.firstToLowerCase(string)).append(";");
        }
        System.out.println(buffer.toString());
    }
}
