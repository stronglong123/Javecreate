package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.constants.OrdercenterConstant;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.ordercenter.dto.DeadLetterRecoverDTO;
import com.common.generate.javacreate.ordercenter.dto.MqQueryDTO;
import com.common.generate.javacreate.utils.HttpClientUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author xialei
 * @date 2023/9/12 14:35
 */
public class MqCheckBL {

    //配送完成
    public static final String BATCH_COMPLETE_DELIVERY = "mq.ordercenter.coordinator.onBatchCompleteDelivery";
    //配送完成通知wms生成待入库单
    public static final String INSTOCKORDER_CREATEINSTOCKBATCH = "mq.ordercenter.instockorder.createinstockbatch";
    //完成异常
    public static final String ORDERCOMPLETE_CHECK = "mq.ordercenter.ordercomplete.check";
    //回单入库
    public static final String ORDER_IN_STOCK = "mq.ordercenter.coordinator.onOrderInStock";

    public static final String BATCHPAY_CONFIRM = "mq.ordercenter.coordinator.onBatchPayConfirm";


    public static void main(String[] args){
        List<String> mqList = Arrays.asList(
//                BATCH_COMPLETE_DELIVERY,
//                INSTOCKORDER_CREATEINSTOCKBATCH,
//                ORDERCOMPLETE_CHECK,
                ORDER_IN_STOCK
//                BATCHPAY_CONFIRM
                );

        for (String mqName : mqList) {

            MqQueryDTO queryDTO =new MqQueryDTO();
            queryDTO.setPageIndex(1);
            queryDTO.setPageSize(100);
            queryDTO.setQueueName(mqName);
            queryDTO.setState(0);
            List<DeadLetterRecoverDTO> deadLetterRecover = getDeadLetterRecover(queryDTO);
            if(CollectionUtils.isNotEmpty(deadLetterRecover)){
                System.out.println("存在异常"+mqName);

                for (DeadLetterRecoverDTO deadLetterRecoverDTO : deadLetterRecover) {
                    if(deadLetterRecoverDTO.getCauseException().contains("退货单")){
                        requeue(JSON.toJSONString(Arrays.asList(deadLetterRecoverDTO.getId())));
                    }
                }
            }
        }
    }







    public static List<DeadLetterRecoverDTO> getDeadLetterRecover(MqQueryDTO queryDTO) {
        String url = OrdercenterConstant.MqBaseUrl + "/Rabbit/DeadLetterRecover/list";
        String resultstr = HttpClientUtils.doPostWithCookie(OrdercenterConstant.Cookie, url, JSON.toJSONString(queryDTO));
        Result result = JSON.parseObject(resultstr, Result.class);
        Object datas = result.getDatas();
        List<DeadLetterRecoverDTO> resultList = JSON.parseArray(JSON.toJSONString(datas), DeadLetterRecoverDTO.class);
        return resultList;
    }


    public static void requeue(String params) {
        String url = OrdercenterConstant.MqBaseUrl + "/Rabbit/DeadLetterRecover/requeue";
        String resultstr = HttpClientUtils.doPostWithCookie(OrdercenterConstant.Cookie, url, params);
    }

}
