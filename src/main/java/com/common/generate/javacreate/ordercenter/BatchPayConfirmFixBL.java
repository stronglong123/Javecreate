package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.BatchPayConfirmDTO;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.SaleOrderPayConfirm;
import com.common.generate.javacreate.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.apache.lucene.index.OrdTermState;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xialei
 * @date 2023/5/12 18:17
 */
public class BatchPayConfirmFixBL {

    @SneakyThrows
    public static void main(String[] args) {
        List<Long> orderIdList = getOrderIdList();
        System.out.println(orderIdList.size());
        System.out.println(orderIdList);
        for (Long orderid : orderIdList) {
            NewApiTest.evnetTrySaleComplete(orderid);
            Thread.sleep(500L);
        }
    }


    private static List<Long> getOrderIdList(){
        String json ="{\"desc\":\"车次确认收款\",\"optUserId\":\"68029183\",\"saleOrderPayConfirms\":[{\"collectionTime\":1680049351338,\"orderId\":5172161099456016235,\"payAmount\":414.4},{\"collectionTime\":1680049351338,\"orderId\":5172268313216293420,\"payAmount\":363.8},{\"collectionTime\":1680049351338,\"orderId\":5172291407277275721,\"payAmount\":467.6},{\"collectionTime\":1680049351338,\"orderId\":5172305695027051073,\"payAmount\":739.0},{\"collectionTime\":1680049351338,\"orderId\":5172441647686097440,\"payAmount\":451.8},{\"collectionTime\":1680049351338,\"orderId\":5172454009118734917,\"payAmount\":776.6},{\"collectionTime\":1680049351338,\"orderId\":5172473308864657989,\"payAmount\":433.0},{\"collectionTime\":1680049351338,\"orderId\":5172484683506727492,\"payAmount\":420.0}],\"taskId\":\"5172495202067178286\"}";
        BatchPayConfirmDTO batchPayConfirmDTO = JSON.parseObject(json, BatchPayConfirmDTO.class);

        List<Long> orderIds =new ArrayList<>();
        for (SaleOrderPayConfirm saleOrderPayConfirm : batchPayConfirmDTO.getSaleOrderPayConfirms()) {
            orderIds.add(saleOrderPayConfirm.getOrderId());
        }
        return orderIds;
    }
}
