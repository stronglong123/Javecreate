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
        String json ="{\"saleOrderPayConfirms\":[{\"orderId\":4000002306181943032,\"payAmount\":482.3,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":4000002306190043211,\"payAmount\":283.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":4000002306190343221,\"payAmount\":139.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":4000002306190843268,\"payAmount\":213.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":4000002306191043325,\"payAmount\":303.2,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":4000002306191343461,\"payAmount\":230.3,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":4000002306191443504,\"payAmount\":332.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202358707052626656,\"payAmount\":154.2,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202358708617102062,\"payAmount\":189.68,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202359187547898594,\"payAmount\":376.7,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202359188854096935,\"payAmount\":467.59,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202375662226326572,\"payAmount\":179.3,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202383759382954730,\"payAmount\":810.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202414570578330658,\"payAmount\":498.1,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202432595666879531,\"payAmount\":107.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202432596847903470,\"payAmount\":713.57,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202519120379331618,\"payAmount\":456.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202519875878339620,\"payAmount\":206.98,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202523583290754091,\"payAmount\":388.2,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202528212523107372,\"payAmount\":186.59,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202538507878482980,\"payAmount\":91.29,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202538509031916585,\"payAmount\":379.01,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202541639998391016,\"payAmount\":388.65,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202548864219038752,\"payAmount\":303.6,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202548865941127916,\"payAmount\":39.99,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202599609104876258,\"payAmount\":185.94,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202599610536903723,\"payAmount\":69.8,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202606827457692714,\"payAmount\":275.9,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202612898501247721,\"payAmount\":42.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202612899537240812,\"payAmount\":1611.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202624904970847272,\"payAmount\":265.66,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202634707784909858,\"payAmount\":81.8,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202634709009646629,\"payAmount\":1611.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202636275674465313,\"payAmount\":1777.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202667352136827948,\"payAmount\":69.8,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202667353214764074,\"payAmount\":399.6,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202675898230784736,\"payAmount\":318.2,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202675899570537505,\"payAmount\":552.79,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202684603458405102,\"payAmount\":1335.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202685705251734242,\"payAmount\":355.99,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202685706599875617,\"payAmount\":132.5,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202702574903575587,\"payAmount\":240.0,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202702576191226919,\"payAmount\":108.9,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202711104618775269,\"payAmount\":171.78,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"},{\"orderId\":5202711105998701281,\"payAmount\":218.5,\"collectionTime\":\"2023-06-21T07:07:22.485+08:00\"}],\"returnOrderPayConfirms\":null,\"awardOrderPayConfirms\":null,\"taskId\":\"5202778294886398213\",\"optUserId\":\"67789714\",\"optUserName\":null,\"desc\":\"车次确认收款\"}";
        BatchPayConfirmDTO batchPayConfirmDTO = JSON.parseObject(json, BatchPayConfirmDTO.class);

        List<Long> orderIds =new ArrayList<>();
        for (SaleOrderPayConfirm saleOrderPayConfirm : batchPayConfirmDTO.getSaleOrderPayConfirms()) {
            orderIds.add(saleOrderPayConfirm.getOrderId());
        }
        return orderIds;
    }
}
