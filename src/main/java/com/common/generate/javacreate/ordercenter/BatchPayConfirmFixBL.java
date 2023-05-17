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
        String json ="{\"saleOrderPayConfirms\":[{\"orderId\":5187280451829621831,\"payAmount\":263.93,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187280453012415565,\"payAmount\":259.93,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187295689539934988,\"payAmount\":189.88,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187296431335138379,\"payAmount\":204.67,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187296433004471363,\"payAmount\":153.89,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187296434489254982,\"payAmount\":59.8,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187315596280325194,\"payAmount\":239.94,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187315699217947393,\"payAmount\":79.98,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187315700350409484,\"payAmount\":143.96,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187323907704742985,\"payAmount\":171.86,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187323908972436229,\"payAmount\":193.43,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187331460580893765,\"payAmount\":209.3,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187331462044705856,\"payAmount\":99.6,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187334309218966282,\"payAmount\":132.98,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187334310547547205,\"payAmount\":392.66,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187334312493704259,\"payAmount\":96.0,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187348009996868356,\"payAmount\":52.99,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187348010986724105,\"payAmount\":293.27,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187436835658357512,\"payAmount\":516.39,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187455834240670464,\"payAmount\":215.97,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187455835528321800,\"payAmount\":93.59,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187456607355755264,\"payAmount\":30.5,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187456608524952654,\"payAmount\":293.19,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187490937242248259,\"payAmount\":313.83,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187533981745094285,\"payAmount\":92.89,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187533983129214595,\"payAmount\":179.4,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187533984773381768,\"payAmount\":35.99,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187651365994700429,\"payAmount\":167.19,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187651367336089381,\"payAmount\":208.29,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187658302785525542,\"payAmount\":219.8,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187658303989290786,\"payAmount\":133.97,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187727975942133542,\"payAmount\":133.7,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187727977158481700,\"payAmount\":388.76,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187747032137406251,\"payAmount\":51.6,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187747033128050311,\"payAmount\":288.94,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187808094355136133,\"payAmount\":2065.56,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187811577652516650,\"payAmount\":139.19,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187811578868864813,\"payAmount\":251.06,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187836486349692546,\"payAmount\":229.97,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"},{\"orderId\":5187836488023219851,\"payAmount\":292.67,\"collectionTime\":\"2023-05-11T23:05:22.719+08:00\"}],\"returnOrderPayConfirms\":null,\"awardOrderPayConfirms\":null,\"taskId\":\"5187863131149503881\",\"optUserId\":\"16203\",\"optUserName\":null,\"desc\":\"车次确认收款\"}";
        BatchPayConfirmDTO batchPayConfirmDTO = JSON.parseObject(json, BatchPayConfirmDTO.class);

        List<Long> orderIds =new ArrayList<>();
        for (SaleOrderPayConfirm saleOrderPayConfirm : batchPayConfirmDTO.getSaleOrderPayConfirms()) {
            orderIds.add(saleOrderPayConfirm.getOrderId());
        }
        return orderIds;
    }
}
