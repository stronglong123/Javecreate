package com.common.generate.javacreate.ordercenter;

/**
 * @author xialei
 * @date 2023/7/10 11:44
 */
public class SelfSaleOrderBL {



    public static void main(String[] args){
//        NewApiTest.actionSelfOrder("release", 5213127930376411373L);
        orderOutStockNotify();
    }

    public static void orderOutStockNotify(){
        String param="[\n" +
                "    {\n" +
                "        \"cityId\": 700,\n" +
                "        \"warehouseId\": 7006,\n" +
                "        \"outStockTime\": 1659682880780,\n" +
                "        \"optUserId\": \"67795309\",\n" +
                "        \"orderId\": 5210876004972540396,\n" +
                "        \"orderType\": 2,\n" +
                "        \"orderItemOutStockList\": [\n" +
                "            {\n" +
                "                \"orderItemId\": 5210876005841773835,\n" +
                "                \"unitTotalCount\": 60,\n" +
                "                \"orderOutStockDealerList\": [\n" +
                "                    {\n" +
                "                        \"unitTotalCount\": 60,\n" +
                "                        \"secOwnerId\": 1\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";
        NewApiTest.orderOutStockNotify("release",param);
    }



}
