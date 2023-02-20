package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.ordercenter.dto.DeadLetterRecoverDTO;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.FixReturnOrderBO;
import com.common.generate.javacreate.ordercenter.dto.ReturnOrderDTO;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/1/4 17:29
 */
@Component
public class ReturnOrderNoSaleOrderFix {

    private static final String Cookie = "YJPINFO=9d907fb0-e58f-400a-a8d3-c214b443ed0f; YID=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODM4NCIsImlzcyI6InNzbyIsImV4cCI6MTY3Njg2NDg1OH0.Wk1w-3ZE7UqAY85xVABH5GdbAZdFE-h8ySrxivzjJGs";

    private static final String baseUrl = "http://console.pre.yijiupi.com";


    public static void main(String[] args) throws Exception {
//        fixReturnOrder();
        for (int i = 1; i > 0; i--) {
            fixSaleOrder(i);
        }

//        for (int i = 1; i > 0; i--) {
//            fixAwardOrder(i);
//        }


//        reSyncSaleOrder();

//        Map<String, String> oldFixData = getOldFixData();
//        System.out.println(JSON.toJSONString(oldFixData));
//        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[{},{\"pageIndex\":1,\"pageSize\":10}]");
//        List<FixReturnOrderBO> dataFromFile = getDataFromFile("C:\\Users\\Administrator\\Desktop\\退货单修复异常数据.txt");
//        Set<Long> collect = dataFromFile.stream().map(it -> it.getSaleOrderId()).collect(Collectors.toSet());
//        System.out.println(JSON.toJSONString(collect));
    }

    @SneakyThrows
    public static void reSyncSaleOrder(){
        List<Long> orderIds = getOrderIds();
        for (Long orderId : orderIds) {
            Thread.sleep(500L);

            List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderWord\":" + orderId.toString() + ",\"companyCode\":\"YJP\"},{\"pageIndex\":5,\"pageSize\":100}]");
            if (CollectionUtils.isNotEmpty(orderList)) {
                System.out.println("销售单已经同步无需重新同步:" + JSON.toJSONString(orderId));
            }else {
                initOrderCenterByOmsorderIds("{\n" +
                        "  \"omsorderIds\": [\n" +
                        orderId +
                        "  ]\n" +
                        "}");
            }
        }
    }

    @SneakyThrows
    private static List<Long> getOrderIds() {
        List<Long> orderIds = new ArrayList<>();


        //销售单未同步excel文档
        String filePath = "C:\\Users\\Administrator\\Desktop\\销售单未同步.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "销售单未同步.xlsx");
        for (ElkDTO elkDTO : list) {
            if (elkDTO.getOrderId() == null) {
                continue;
            }
            orderIds.add(elkDTO.getOrderId());
        }


//        List<FixReturnOrderBO> fixReturnOrderBOS = getDataFromFile("C:\\Users\\Administrator\\Desktop\\退货单已修复数据.txt");
//        Set<Long> orderIdSet = fixReturnOrderBOS.stream().map(it -> it.getSaleOrderId()).collect(Collectors.toSet());
//        orderIds = new ArrayList<>(orderIdSet);

//        orderIds = Arrays.asList(1160002301061107774L,1240002301061102519L,1240002301061102520L,1240002301061102523L,1240002301061102524L,1240002301061102525L,
//                1240002301061102526L);
        return orderIds;
    }


    @SneakyThrows
    public static void fixReturnOrder() {
        String params = "{\"queueName\":\"mq.ordercenter.returnorder.sync\",\"state\":0,\"pageIndex\":1,\"pageSize\":100}";
        List<DeadLetterRecoverDTO> deadLetterRecoverList = getDeadLetterRecover(params);
        if (CollectionUtils.isEmpty(deadLetterRecoverList)) {
            return;
        }
        List<FixReturnOrderBO> fixReturnOrderBOS = new ArrayList<>();
        for (DeadLetterRecoverDTO deadLetterRecoverDTO : deadLetterRecoverList) {
            if (!deadLetterRecoverDTO.getCauseException().contains("退货单同步根据refOrderId查询销售单明细为空")) {
                continue;
            }
            String messageBody = deadLetterRecoverDTO.getMessageBody();
            ReturnOrderDTO returnOrderDTO = JSON.parseObject(messageBody, ReturnOrderDTO.class);

            FixReturnOrderBO fixReturnOrderBO = new FixReturnOrderBO();
            fixReturnOrderBO.setSaleOrderId(returnOrderDTO.getReturnOrderBO().getRefOmsOrderId());
            fixReturnOrderBO.setMqId(deadLetterRecoverDTO.getId());
            fixReturnOrderBO.setReturnOrderNo(returnOrderDTO.getReturnOrderBO().getBusinessNo());
            fixReturnOrderBOS.add(fixReturnOrderBO);
        }
        if (CollectionUtils.isEmpty(fixReturnOrderBOS)) {
            return;
        }

        Map<String, String> oldFixDataMap = getOldFixData();

        for (FixReturnOrderBO fixReturnOrderBO : fixReturnOrderBOS) {
            if (oldFixDataMap.get(fixReturnOrderBO.getReturnOrderNo())!= null) {
                FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\退货单修复异常数据.txt", JSON.toJSONString(fixReturnOrderBO)+",");
                continue;
            }
            System.out.println("修复数据:" + JSON.toJSONString(fixReturnOrderBO));
            fix(fixReturnOrderBO);
        }

    }

    public static void fix(FixReturnOrderBO fixReturnOrderBO) {
        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderWord\":" + fixReturnOrderBO.getSaleOrderId().toString() + ",\"companyCode\":\"YJP\"},{\"pageIndex\":1,\"pageSize\":10}]");
        if (CollectionUtils.isNotEmpty(orderList)) {
            System.out.println("销售单已经同步无需重新同步:" + JSON.toJSONString(fixReturnOrderBO));
        }else {
            initOrderCenterByOmsorderIds("{\n" +
                    "  \"omsorderIds\": [\n" +
                    fixReturnOrderBO.getSaleOrderId() +
                    "  ]\n" +
                    "}");
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {

        }
        requeue(JSON.toJSONString(Arrays.asList(fixReturnOrderBO.getMqId())));
        FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\退货单已修复数据.txt", JSON.toJSONString(fixReturnOrderBO)+",");
    }


    public static List<DeadLetterRecoverDTO> getDeadLetterRecover(String params) {
        String url = baseUrl + "/Rabbit/DeadLetterRecover/list";
        String resultstr = HttpClientUtils.doPostWithCookie(Cookie, url, params);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object datas = result.getDatas();
        List<DeadLetterRecoverDTO> resultList = JSON.parseArray(JSON.toJSONString(datas), DeadLetterRecoverDTO.class);
        return resultList;
    }


    public static void requeue(String params) {
        String url = baseUrl + "/Rabbit/DeadLetterRecover/requeue";
        String resultstr = HttpClientUtils.doPostWithCookie(Cookie, url, params);
    }


    public static void initOrderCenterByOmsorderIds(String params) {
        String url = "http://openapi.pre.yijiupi.com/openapi/oms/initOrderCenterByOmsorderIds";
        String resultstr = HttpClientUtils.doPostWithCookie(Cookie, url, params);
    }

    public static Map<String, String> getOldFixData() {
        List<FixReturnOrderBO> fixReturnOrderBOS = getDataFromFile("C:\\Users\\Administrator\\Desktop\\退货单已修复数据.txt");
        Map<String, String> oldFixDataMap = fixReturnOrderBOS.stream().collect(Collectors.toMap(it -> it.getReturnOrderNo(), it ->it.getReturnOrderNo()));
        return oldFixDataMap;
    }


    private static List<FixReturnOrderBO> getDataFromFile(String filePath){
        String json = FileUtil.readFileByLines(filePath);
        if (StringUtils.isEmpty(json)) {
            return Collections.EMPTY_LIST;
        }
        String substring = json.substring(0, json.length() - 1);
        List<FixReturnOrderBO> fixReturnOrderBOS = JSON.parseArray("[" + substring + "]", FixReturnOrderBO.class);
        return fixReturnOrderBOS;
    }


    @SneakyThrows
    public static void fixSaleOrder(Integer pageIndex) {
        String params = "{\"queueName\":\"mq.ordercenter.saleorder.sync\",\"state\":0,\"pageIndex\":" + pageIndex + ",\"pageSize\":100}";
        List<DeadLetterRecoverDTO> deadLetterRecoverList = getDeadLetterRecover(params);
        Integer fixCount = 0;
        if (CollectionUtils.isEmpty(deadLetterRecoverList)) {
            return;
        }
        for (DeadLetterRecoverDTO deadLetterRecoverDTO : deadLetterRecoverList) {
            if (!deadLetterRecoverDTO.getCauseException().contains("Data too long for column 'ContactPhone' ")) {
                continue;
            }
            requeue(JSON.toJSONString(Collections.singletonList(deadLetterRecoverDTO.getId())));
            fixCount++;
            Thread.sleep(200L);
        }
        System.out.println("修复总数：" + fixCount);
    }

    @SneakyThrows
    public static void fixAwardOrder(Integer pageIndex) {
        String params = "{\"queueName\":\"mq.ordercenter.awardorder.sync\",\"state\":0,\"pageIndex\":" + pageIndex + ",\"pageSize\":100}";
        List<DeadLetterRecoverDTO> deadLetterRecoverList = getDeadLetterRecover(params);
        Integer fixCount = 0;
        if (CollectionUtils.isEmpty(deadLetterRecoverList)) {
            return;
        }
        for (DeadLetterRecoverDTO deadLetterRecoverDTO : deadLetterRecoverList) {
            if (!deadLetterRecoverDTO.getCauseException().contains("java.lang.NullPointerException")) {
                continue;
            }
            requeue(JSON.toJSONString(Collections.singletonList(deadLetterRecoverDTO.getId())));
            fixCount++;
            Thread.sleep(300L);
        }
        System.out.println("修复总数：" + fixCount);
    }
}
