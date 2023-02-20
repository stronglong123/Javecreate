package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.OrderAddDTO;

import java.util.Date;

/**
 * @author xialei
 * @date 2022/9/30 17:15
 */
public class InformaAddBL {

    public static void main(String[] args) {
        retryOrder();
    }


    private static void retryOrder() {
        for (int i = 0; i < 10; i++) {
            int baseNum = i * 4;
            for (int j = 1; j <= 4; j++) {
                OrderAddDTO orderAddDTO = swithOrder(j);
                if (orderAddDTO == null) {
                    continue;
                }
                orderAddDTO.setOrderNo(buildOrderNo(baseNum + j));
                orderAddDTO.setOrderCreateTime(new Date());
//                AbilityUtil.addInformaSaleOrder(orderAddDTO);
            }
        }
    }


    private static String buildOrderNo(Integer count) {
        long orderNo = 2022093000250L;
        orderNo = orderNo + count.longValue();
        return Long.toString(orderNo);
    }


    private static OrderAddDTO swithOrder(Integer type) {
        switch (type) {
            case 1:
                return getOrder1039();
            case 2:
                return getOrder10310();
            case 3:
                return getOrder9000007();
            case 4:
                return getOrder90000036();
        }
        return null;
    }


    private static OrderAddDTO getOrder1039() {
        //warehouseId:1039
        String json = "{\"addressId\":2874696,\"balancePayAmount\":0,\"bizUserLevel\":1,\"channelType\":0,\"city\":\"武汉市\",\"cityId\":103,\"contact\":\"何必\",\"county\":\"洪山区\",\"detailAddress\":\"常家山路花山生态湿地公园101\",\"giveBonusAmount\":0.0,\"giveCouponAmount\":0.0,\"items\":[{\"costPrice\":0.01,\"costPriceUnit\":\"只\",\"deliveryMode\":0,\"minUnitTotalCount\":2,\"onlinePayment\":true,\"orderItemId\":5102223277100414721,\"packageName\":\"盒\",\"payAmount\":0.02,\"payType\":1,\"preSale\":false,\"productBrand\":\"测试7感品牌217\",\"productName\":\"测试供应商新增产品信息02\",\"productOwnerId\":7939486172863319300,\"productSaleSpec\":\"1只/套\",\"productSkuId\":40400492602235,\"productSpec\":\"16只/盒\",\"productType\":0,\"reduceBonusAmount\":0.0,\"reduceCouponAmount\":0.0,\"reduceOrderAmount\":0.0,\"reduceProductAmount\":0.0,\"reduceSelfPickUp\":0.0,\"reduceTotal\":0.0,\"relationOrderItemIds\":[],\"saleCount\":2,\"saleMode\":0,\"saleSpecQuantity\":1,\"selfPickup\":false,\"sellPrice\":0.01,\"sellPriceUnit\":\"只\",\"sellUnit\":\"套\",\"shopId\":10067,\"shopName\":\"informa官方店铺\",\"shopType\":2,\"skuHasInputTaxInvoice\":false,\"sourceId\":\"40400492602235\",\"sourceType\":0,\"specQuantity\":16,\"specificationId\":492602,\"totalAmount\":0.02,\"unitName\":\"只\",\"userRemark\":\"\",\"warehouseId\":1039}],\"latitude\":0.0,\"longitude\":0.0,\"orderAmount\":0.02,\"orderCreateTime\":1663225196000,\"orderId\":103422091514002452,\"orderNo\":\"103225800118\",\"orderSource\":4,\"payableAmount\":0.02,\"phone\":\"18483601784\",\"productReduceAmount\":0.0,\"province\":\"湖北省\",\"reduceAmount\":0.0,\"state\":200,\"street\":\"花山街道\",\"useBonusAmount\":0.0,\"useCouponAmount\":0.0,\"userClassName\":\"\",\"userCompanyName\":\"何必\",\"userId\":1737852,\"userMobileNo\":\"18483601784\",\"userName\":\"何必\",\"userRemark\":\"\",\"userSource\":0,\"vipBizUserOrder\":false}";
        OrderAddDTO orderAddDTO = JSON.parseObject(json, OrderAddDTO.class);
        return orderAddDTO;
    }


    private static OrderAddDTO getOrder10310() {
        String json = "{\"addressId\":2874696,\"city\":\"武汉市\",\"cityId\":998,\"contact\":\"何必\",\"county\":\"洪山区\",\"detailAddress\":\"常家山路花山生态湿地公园101\",\"giveBonusAmount\":0,\"giveCouponAmount\":0,\"items\":[{\"costPrice\":0.2,\"costPriceUnit\":\"块\",\"minUnitTotalCount\":2.0,\"onlinePayment\":true,\"orderItemId\":5039113867301657057,\"packageName\":\"件\",\"payAmount\":1,\"payType\":1,\"preSale\":false,\"productBrand\":\"翡冷翠\",\"productName\":\"麦奇客京都酥粗粮味180g\",\"productOwnerId\":7939486172863319300,\"productSaleSpec\":\"24盒/件\",\"productSkuId\":6429259403097244059,\"productSpec\":\"24盒/件\",\"productType\":0,\"reduceBonusAmount\":0,\"reduceCouponAmount\":0,\"reduceOrderAmount\":0,\"reduceProductAmount\":0,\"reduceSelfPickUp\":0,\"reduceTotal\":0,\"relationOrderItemIds\":[],\"saleCount\":1,\"saleMode\":0,\"saleSpecQuantity\":10,\"selfPickup\":false,\"sellPrice\":1,\"sellPriceUnit\":\"件\",\"sellUnit\":\"件\",\"shopId\":10067,\"shopName\":\"informa官方店铺2\",\"shopType\":2,\"skuHasInputTaxInvoice\":false,\"sourceId\":\"40400492591793\",\"sourceType\":0,\"specQuantity\":10,\"specificationId\":492612,\"totalAmount\":1,\"unitName\":\"块\",\"userRemark\":\"\",\"warehouseId\":10310}],\"orderAmount\":1,\"orderCreateTime\":1648176356000,\"orderId\":1034202209301657024,\"orderNo\":\"1202209301657023\",\"orderSource\":4,\"payableAmount\":1,\"phone\":\"18483601784\",\"productReduceAmount\":0,\"province\":\"湖北省\",\"reduceAmount\":0,\"state\":200,\"street\":\"花山街道\",\"useBonusAmount\":0,\"useCouponAmount\":0,\"userClassName\":\"\",\"userCompanyName\":\"测试超市\",\"userId\":1737852,\"userMobileNo\":\"18483601784\",\"userName\":\"何必\",\"userRemark\":\"\"}";
        OrderAddDTO orderAddDTO = JSON.parseObject(json, OrderAddDTO.class);
        return orderAddDTO;
    }


    private static OrderAddDTO getOrder9000007() {
        String json = "{\"orderId\":103422092719002641,\"orderNo\":\"103227000009\",\"state\":200,\"orderCreateTime\":1664278197000,\"userId\":1737852,\"cityId\":103,\"userName\":\"何必\",\"userCompanyName\":\"何必\",\"userRemark\":\"\",\"userClassName\":\"\",\"userMobileNo\":\"18483601784\",\"addressId\":2874696,\"province\":\"湖北省\",\"city\":\"武汉市\",\"county\":\"洪山区\",\"street\":\"花山街道\",\"detailAddress\":\"常家山路花山生态湿地公园101\",\"latitude\":0.0,\"longitude\":0.0,\"contact\":\"何必\",\"phone\":\"18483601784\",\"giveCouponAmount\":0.0,\"giveBonusAmount\":0.0,\"orderAmount\":0.02,\"reduceAmount\":0.0,\"useBonusAmount\":0.0,\"productReduceAmount\":0.0,\"useCouponAmount\":0.0,\"payableAmount\":0.02,\"items\":[{\"orderItemId\":5106639884322199880,\"productSkuId\":40400492605686,\"productOwnerId\":7939486172863319300,\"productName\":\"测试新增0318-2\",\"shopId\":10067,\"shopType\":2,\"shopName\":\"informa官方店铺\",\"specificationId\":492605,\"productSaleSpec\":\"1盒/件\",\"productSpec\":\"1盒/件\",\"saleSpecQuantity\":1,\"specQuantity\":1,\"packageName\":\"件\",\"unitName\":\"盒\",\"productBrand\":\"翡冷翠\",\"sellPrice\":0.01,\"sellPriceUnit\":\"盒\",\"costPrice\":0.01,\"costPriceUnit\":\"盒\",\"saleMode\":0,\"productType\":0,\"sourceType\":0,\"sourceId\":\"40400492605686\",\"relationOrderItemIds\":[],\"saleCount\":2,\"sellUnit\":\"件\",\"minUnitTotalCount\":2,\"totalAmount\":0.02,\"reduceProductAmount\":0.0,\"reduceOrderAmount\":0.0,\"reduceCouponAmount\":0.0,\"reduceBonusAmount\":0.0,\"reduceSelfPickUp\":0.0,\"reduceTotal\":0.0,\"payAmount\":0.02,\"warehouseId\":9000007,\"preSale\":false,\"selfPickup\":false,\"payType\":1,\"userRemark\":\"\",\"onlinePayment\":true,\"skuHasInputTaxInvoice\":false,\"deliveryMode\":0}],\"channelType\":0,\"orderSource\":4,\"bizUserLevel\":1,\"userSource\":0,\"vipBizUserOrder\":false,\"balancePayAmount\":0}";
        OrderAddDTO orderAddDTO = JSON.parseObject(json, OrderAddDTO.class);
        return orderAddDTO;
    }


    private static OrderAddDTO getOrder90000036() {
        String json = "{\"addressId\":2874626,\"balancePayAmount\":0,\"bizUserLevel\":1,\"channelType\":0,\"city\":\"武汉市\",\"cityId\":103,\"contact\":\"测试\",\"county\":\"洪山区\",\"detailAddress\":\"常家山路花山生态湿地公园\",\"giveBonusAmount\":0.0,\"giveCouponAmount\":0.0,\"items\":[{\"costPrice\":0.01,\"costPriceUnit\":\"只\",\"deliveryMode\":0,\"minUnitTotalCount\":2,\"onlinePayment\":false,\"orderItemId\":5106206482284534109,\"packageName\":\"盒\",\"payAmount\":0.02,\"payType\":0,\"preSale\":false,\"productBrand\":\"翡冷翠\",\"productName\":\"测试图片条码05\",\"productOwnerId\":7939486172863319300,\"productSaleSpec\":\"1只/套\",\"productSkuId\":40400492657849,\"productSpec\":\"9只/盒\",\"productType\":0,\"reduceBonusAmount\":0.0,\"reduceCouponAmount\":0.0,\"reduceOrderAmount\":0.0,\"reduceProductAmount\":0.0,\"reduceSelfPickUp\":0.0,\"reduceTotal\":0.0,\"relationOrderItemIds\":[],\"saleCount\":2,\"saleMode\":0,\"saleSpecQuantity\":1,\"selfPickup\":false,\"sellPrice\":0.01,\"sellPriceUnit\":\"只\",\"sellUnit\":\"套\",\"shopId\":10067,\"shopName\":\"informa官方店铺\",\"shopType\":2,\"skuHasInputTaxInvoice\":false,\"sourceId\":\"40400492657849\",\"sourceType\":0,\"specQuantity\":9,\"specificationId\":492657,\"totalAmount\":0.02,\"unitName\":\"只\",\"userRemark\":\"\",\"warehouseId\":90000036}],\"latitude\":0.0,\"longitude\":0.0,\"orderAmount\":0.02,\"orderCreateTime\":1664174866000,\"orderId\":103422092614002624,\"orderNo\":\"103226900019\",\"orderSource\":4,\"payableAmount\":0.02,\"phone\":\"13986086506\",\"productReduceAmount\":0.0,\"province\":\"湖北省\",\"reduceAmount\":0.0,\"state\":200,\"street\":\"花山街道\",\"useBonusAmount\":0.0,\"useCouponAmount\":0.0,\"userClassName\":\"\",\"userCompanyName\":\"测试\",\"userId\":1737798,\"userMobileNo\":\"13900000000\",\"userName\":\"测试\",\"userRemark\":\"\",\"userSource\":0,\"vipBizUserOrder\":false}";
        OrderAddDTO orderAddDTO = JSON.parseObject(json, OrderAddDTO.class);
        return orderAddDTO;
    }
}
