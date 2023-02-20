package com.common.generate.javacreate.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author xialei
 * @date 2022/6/17 17:10
 */
public class JsonPathUtils {

    public static void main(String[] args) throws IOException {

        // 定义需要测试的json字符串
        String testJson = getJson();

        //使用jackson对字符串反序列化为json对象
        ObjectMapper mapper = new ObjectMapper();
        HashMap responseJson = mapper.readValue(testJson, HashMap.class);


        // 输出text的值
        String text = JsonPath.read(responseJson, "$.saleOrders[?(@.secOrderType  == 10003)]");
        System.out.println(text);
    }


    private static String getJson(){
        return "{\"saleOrders\":[{\"orderBaseDTO\":{\"partnerCode\":\"YJP-TRD\",\"orderId\":5069638274926837719,\"orderNo\":\"103216800030\",\"shortOrderNo\":\"00455\",\"businessId\":\"103422061716026047\",\"firstOrderType\":1,\"companyCode\":\"YJP\",\"secOrderType\":10003,\"orgId\":103,\"state\":200,\"orderCreateTime\":\"2022-06-17T08:58:45.000+0000\",\"orderCompleteTime\":null,\"sysRemark\":null,\"createTime\":\"2022-06-17T08:58:46.000+0000\",\"lastUpdateTime\":\"2022-06-17T08:58:46.000+0000\",\"flowException\":null,\"haveException\":null,\"deliveryFee\":null},\"orderSaleDTO\":{\"partnerCode\":\"YJP-TRD\",\"orderId\":5069638274926837719,\"preSaleType\":0,\"shopId\":1031,\"shopName\":\"武汉酒类大区\",\"preSaleToNormalTime\":null,\"saleManId\":null,\"saleManName\":null,\"saleManPhone\":null,\"userConfirmState\":0,\"createTime\":\"2022-06-17T08:58:46.000+0000\",\"lastUpdateTime\":\"2022-06-17T08:58:46.000+0000\",\"shopType\":2},\"orderAmountDTO\":{\"orderId\":5069638274926837719,\"partnerCode\":\"YJP-TRD\",\"originalOrderAmount\":0.02,\"orderAmount\":0.02,\"originalPayableAmount\":0.02,\"payableAmount\":0.02,\"originalTotalDiscount\":0.0,\"totalDiscount\":0.0,\"receiveAmount\":0.0,\"uncollectedAmount\":0.02,\"payType\":0,\"payTypeName\":\"货到付款\",\"payTime\":null,\"onlinePayment\":false,\"createTime\":\"2022-06-17T08:58:46.000+0000\",\"lastUpdateTime\":\"2022-06-17T08:58:46.000+0000\",\"workingOrderAmount\":null},\"orderConsignorDTO\":null,\"orderContactDTO\":{\"orderId\":5069638274926837719,\"partnerCode\":\"YJP-TRD\",\"contact\":\"重构测试01\",\"contactPhone\":\"13072552953\",\"contactCompanyName\":\"重构测试01\",\"addressId\":2874772,\"province\":\"湖北省\",\"city\":\"武汉市\",\"county\":\"洪山区\",\"street\":\"关山街道\",\"detailAddress\":\"县政府\",\"longitude\":0.0,\"latitude\":0.0,\"remark\":\"\",\"createTime\":\"2022-06-17T08:58:46.000+0000\",\"lastUpdateTime\":\"2022-06-17T08:58:46.000+0000\",\"userId\":\"1737908\",\"signboard\":\"重构测试01\"},\"orderDeliveryDTO\":{\"id\":5069638275934774867,\"orderId\":5069638274926837719,\"partnerCode\":\"YJP-TRD\",\"deliveryMode\":0,\"logisticsId\":null,\"logisticName\":null,\"trackNumber\":null,\"deliveryTime\":null,\"deliveryCarId\":null,\"deliveryCarNumber\":null,\"deliveryCarName\":null,\"deliveryUserId\":null,\"deliveryUserName\":null,\"deliveryCenterId\":null,\"deliveryTaskId\":null,\"arriveTime\":null,\"deliveryPayAbleAmount\":null,\"deliveryReceiveAmount\":null,\"deliveryFee\":null,\"hopeArriveTime\":null,\"estimatedDeliveryTime\":null,\"createTime\":\"2022-06-17T08:58:46.000+0000\",\"lastUpdateTime\":\"2022-06-17T08:58:46.000+0000\",\"deliveryState\":null,\"deliveryItems\":[]},\"orderDeliverys\":null,\"orderPickDTO\":{\"partnerCode\":\"YJP-TRD\",\"orderId\":5069638274926837719,\"fromOrgId\":103,\"orgId\":103,\"fromWarehouseId\":9000100,\"warehouseId\":9000100,\"waveNo\":null,\"stevedoreUserId\":null,\"stevedoreUserName\":null,\"defaultLocationId\":null,\"defaultLocationName\":null,\"outStockTime\":null,\"inStockTime\":null,\"createTime\":\"2022-06-17T08:58:46.000+0000\",\"lastUpdateTime\":\"2022-06-17T08:58:46.000+0000\",\"printCount\":null},\"orderExtDTO\":{\"ext\":{\"orderSource\":3,\"LastUpdateTime\":\"2022-06-17T16:58:46\",\"CreateTime\":\"2022-06-17T16:58:46\",\"Id\":5069638276379001363,\"OrderId\":5069638274926837719,\"PartnerCode\":\"YJP-TRD\"}},\"orderMemberDTO\":{\"id\":5069638276176474176,\"orderId\":5069638274926837719,\"companyCode\":\"YJP-TRD\",\"partnerCode\":\"YJP-TRD\",\"userId\":1737908,\"userName\":\"重构测试01\",\"userMobile\":\"13072552953\",\"userType\":1,\"userClass\":null,\"userTags\":null,\"createTime\":\"2022-06-17T08:58:46.000+0000\",\"lastUpdateTime\":\"2022-06-17T08:58:46.000+0000\"},\"orderTagDTOList\":[],\"orderExceptionDTOList\":[],\"saleOrderItemDTOList\":[{\"orderId\":5069638274926837719,\"orderItemId\":5069638276498588994,\"orderItemBaseDTO\":{\"partnerCode\":null,\"orderItemId\":5069638276498588994,\"orderId\":5069638274926837719,\"businessItemId\":\"5069638271865842696\",\"productSkuId\":10300481361925,\"productName\":\"白酒02重构测试\",\"productStatisticsClass\":null,\"statisticsCategoryName\":null,\"boxCode\":null,\"originalCount\":10.0,\"count\":10.0,\"originalPrice\":0.01,\"price\":0.01,\"priceQuantity\":5.0,\"priceUnit\":\"件\",\"outStockCount\":0.0,\"inStockCount\":0.0,\"deliveryCount\":0.0,\"takeCount\":0.0,\"gift\":false,\"cost\":0.0,\"costPriceUnit\":null,\"saleUnit\":\"件\",\"saleSpec\":\"5箱/件\",\"saleSpecQuantity\":5.0,\"remark\":null,\"createTime\":null,\"lastUpdateTime\":null,\"productSpecificationId\":481361,\"ownerId\":null,\"packageName\":\"件\",\"unitName\":\"箱\",\"packageQuantity\":5.0,\"productSpec\":\"5箱/件\",\"warehouseProductSkuId\":\"5060909960968745371\",\"workingItemCount\":null,\"compositeId\":null,\"procurementMode\":null},\"orderItemAmountDTO\":{\"orderId\":5069638274926837719,\"partnerCode\":\"YJP-TRD\",\"orderItemId\":5069638276498588994,\"originalOrderItemAmount\":0.02,\"orderItemAmount\":0.02,\"originalPayableAmount\":0.02,\"payableAmount\":0.02,\"originalDiscount\":0.0,\"discount\":0.0,\"createTime\":null,\"lastUpdateTime\":null,\"workingOrderItemAmount\":null},\"orderItemFeeDTOList\":[],\"orderItemExtDTO\":null}]}],\"businessId\":\"103422061716026047\",\"businessNo\":\"103216800030\",\"inventoryAllocates\":[{\"id\":null,\"phase\":1,\"orderId\":5069638274926837719,\"orderItemId\":5069638276498588994,\"inventoryId\":5060955685086190478,\"orgId\":103,\"warehouseId\":9000100,\"productSkuId\":null,\"productSpecId\":481361,\"ownerId\":null,\"secOwnerId\":1,\"allocateCount\":10.0,\"diffCount\":null,\"outSecOwnerId\":null}]}";
    }
}
