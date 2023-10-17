package com.common.generate.javacreate.ordercenter;

/**
 * @author xialei
 * @date 2023/9/20 11:23
 */
public class CompleteDeliveryRepair {


    public static void main (String[] args){
        String json = "{\"deliveryCenterId\":9000599,\"taskId\":\"5200706422171429510\",\"deliveryTaskNo\":\"DD90020230614008996\",\"schedulerTaskNo\":\"ST900059920230614000023\",\"deliveryCarId\":1,\"deliveryCarName\":\"自带车\",\"deliveryUserId\":14201,\"deliveryUserName\":\"岳 军\",\"optUserId\":\"8979\",\"arriveDeliveryTime\":\"1687139926000\",\"deliveryUserMobile\":\"15353212816\",\"deliveryTaskCompleteOrderList\":[{\"orderId\":5200705669179130600,\"markType\":10,\"startLocation\":{\"id\":9000599,\"name\":\"新铜川市仓库\",\"type\":2},\"endLocation\":{\"id\":1185843,\"name\":\"党彬彬\",\"type\":1},\"saleOrderDeliveryTaskCompleteOrderItemList\":[{\"orderItemId\":5200705669432898570,\"receivedUnitTotalCount\":12.000000,\"unReceivedUnitTotalCount\":0.000000},{\"orderItemId\":5200705669483230218,\"receivedUnitTotalCount\":12.000000,\"unReceivedUnitTotalCount\":0.000000},{\"orderItemId\":5200705669525173259,\"receivedUnitTotalCount\":12.000000,\"unReceivedUnitTotalCount\":0.000000},{\"orderItemId\":5200705669571310593,\"receivedUnitTotalCount\":24.000000,\"unReceivedUnitTotalCount\":0.000000},{\"orderItemId\":5200705669625836546,\"receivedUnitTotalCount\":12.000000,\"unReceivedUnitTotalCount\":0.000000}]}],\"returnOrderDeliveryTaskCompleteOrderDTOList\":[],\"awardOrderDeliveryTaskCompleteOrderDTOList\":[],\"receiptOrderDeliveryTaskCompleteOrderDTOList\":[]}";
        NewApiTest.batchCompleteDelivery("pre",json);


    }
}
