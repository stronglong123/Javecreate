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
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/1/4 17:29
 */
@Component
public class ReturnOrderNoSaleOrderFix {

    private static final String Cookie = "YJPINFO=58acf457-c1f3-43ce-bc70-1cd059910eab; YID=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODM4NCIsImlzcyI6InNzbyIsImV4cCI6MTY4MTA5NzM5OX0.xW-muM2B0lOewJLIf952wxkywwfPvqlpOwgc0MVc-U0";

    private static final String baseUrl = "http://console.pre.yijiupi.com";


    public static void main(String[] args) throws Exception {
//        reSyncSaleOrder();
//        for (int i = 1; i > 0; i--) {
//            fixReturnOrder(i);
//        }

//        for (int i = 2; i > 0; i--) {
//            fixSaleOrder(i);
//        }

//        for (int i = 1; i > 0; i--) {
//            fixAwardOrder(i);
//        }


//        reSyncSaleOrder();

//        Map<String, String> oldFixData = getOldFixData();
//        System.out.println(JSON.toJSONString(oldFixData));
//        List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[{},{\"pageIndex\":1,\"pageSize\":10}]");
//        List<FixReturnOrderBO> dataFromFile = getDataFromFile("C:\\Users\\Administrator\\Desktop\\退货单修复异常数据.txt");
//        Set<Long> collect = dataFromFile.stream().map(it -> it.getSaleOrderId()).collect(Collectors.toSet());
//        System.out.println(JSON.toJSONString(collect))
    }

    @SneakyThrows
    public static void reSyncSaleOrder() {

        List<Long> orderIds = getOrderIds();
        for (Long orderId : orderIds) {
            Thread.sleep(100L);
            initOrderCenterByOmsorderIds("{\n" +
                    "  \"omsorderIds\": [\n" +
                    orderId +
                    "  ],\n" +
                    " \"queryNpt\":true\n"+
                    "}");

//            List<OrderDocumentDTO> orderList = NewApiTest.findPageByOrderSnapshot("pre", "[{\"orderWord\":" + orderId.toString() + ",\"companyCode\":\"YJP\"},{\"pageIndex\":5,\"pageSize\":100}]");
//            if (CollectionUtils.isNotEmpty(orderList)) {
//                System.out.println("销售单已经同步无需重新同步:" + JSON.toJSONString(orderId));
//            } else {
//                initOrderCenterByOmsorderIds("{\n" +
//                        "  \"omsorderIds\": [\n" +
//                        orderId +
//                        "  ]\n" +
//                        "}");
//            }
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
    public static void fixReturnOrder(Integer pageIndex) {
        String params = "{\"queueName\":\"mq.ordercenter.returnorder.sync\",\"state\":0,\"pageIndex\":" + pageIndex + ",\"pageSize\":100}";
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
            if (oldFixDataMap.get(fixReturnOrderBO.getReturnOrderNo()) != null) {
                FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\退货单修复异常数据.txt", JSON.toJSONString(fixReturnOrderBO) + ",");
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
        } else {
            initOrderCenterByOmsorderIds("{\n" +
                    "  \"omsorderIds\": [\n" +
                    fixReturnOrderBO.getSaleOrderId() +
                    "  ]\n" +
                    "}");
        }
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {

        }
        requeue(JSON.toJSONString(Arrays.asList(fixReturnOrderBO.getMqId())));
        FileUtil.writeTxt("C:\\Users\\Administrator\\Desktop\\退货单已修复数据.txt", JSON.toJSONString(fixReturnOrderBO) + ",");
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
        Map<String, String> oldFixDataMap = fixReturnOrderBOS.stream().collect(Collectors.toMap(it -> it.getReturnOrderNo(), it -> it.getReturnOrderNo()));
        return oldFixDataMap;
    }


    private static List<FixReturnOrderBO> getDataFromFile(String filePath) {
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
            if (!deadLetterRecoverDTO.getCauseException().contains("An invalid response was received from the upstream server")) {
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


    public static void requeueWithBody(String params) {
        String url = baseUrl + "/Rabbit/DeadLetterRecover/requeueWithBody";
        String resultstr = HttpClientUtils.doPostWithCookie(Cookie, url, params);
        System.out.println(resultstr);
    }

    private static String getData() {
//        return "{\"id\":\"5ff81ef6-eeb6-4434-9894-00db350a04ad\",\"messageBody\":\"{\\\"items\\\":[{\\\"orderItemId\\\":5159163741352267857,\\\"productInfoSpecificationId\\\":459746,\\\"productSkuId\\\":5090202638231053908,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"易尔惠折扣仓购物袋（中）\\\",\\\"productSaleSpec\\\":\\\"1个\\\",\\\"productSpec\\\":\\\"1个\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"30000997\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":0.400000,\\\"sellPriceUnit\\\":\\\"个\\\",\\\"packageName\\\":\\\"个\\\",\\\"unitName\\\":\\\"个\\\",\\\"sellUnit\\\":\\\"个\\\",\\\"totalAmount\\\":0.400000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":0.400000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":0.210000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267857,\\\"secondOwnerId\\\":1395869718240789677,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267859,\\\"productInfoSpecificationId\\\":556105,\\\"productSkuId\\\":5069631962839272009,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"古立特小麦啤酒11.3度500ml\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"4250594201734\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":4.120000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":4.120000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":4.120000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":3.400000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267859,\\\"secondOwnerId\\\":5067130310507069836,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267860,\\\"productInfoSpecificationId\\\":420506,\\\"productSkuId\\\":5046098272539450140,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"锐澳百香果伏特加风味3度330ml\\\",\\\"productSaleSpec\\\":\\\"1听\\\",\\\"productSpec\\\":\\\"1听\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6935145343078\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":5.970000,\\\"sellPriceUnit\\\":\\\"听\\\",\\\"packageName\\\":\\\"听\\\",\\\"unitName\\\":\\\"听\\\",\\\"sellUnit\\\":\\\"听\\\",\\\"totalAmount\\\":5.970000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":5.970000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":5.416667000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267860,\\\"secondOwnerId\\\":1395869718239580124,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267861,\\\"productInfoSpecificationId\\\":537937,\\\"productSkuId\\\":5077211207782393738,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"农夫山泉茶π果味茶饮料柑普柠檬茶500ml\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6921168597734\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":3.980000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":3.980000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":3.980000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":3.533333000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267861,\\\"secondOwnerId\\\":1395869718239564606,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267862,\\\"productInfoSpecificationId\\\":1748,\\\"productSkuId\\\":5026185782402892838,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"农夫山泉水溶C100西柚汁饮料445ml\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6921168500970\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":3.980000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":3.980000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":3.980000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":3.400000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267862,\\\"secondOwnerId\\\":1395869718239564606,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267863,\\\"productInfoSpecificationId\\\":1931,\\\"productSkuId\\\":5026149193844581888,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"可口可乐零度（瓶）500ml\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6954767423579\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":2.300000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":2.300000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":2.300000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":2.093122000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267863,\\\"secondOwnerId\\\":1395869718239557406,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267864,\\\"productInfoSpecificationId\\\":602751,\\\"productSkuId\\\":5154686377642483673,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"牛顿农场发酵酸奶饮品草莓味320ml\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6975752910058\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":6.970000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":6.970000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":6.970000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":5.500000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267864,\\\"secondOwnerId\\\":5114840623052399170,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267865,\\\"productInfoSpecificationId\\\":375110,\\\"productSkuId\\\":5051546308483494097,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"雀巢茶萃柠檬冰红茶果汁茶饮料250ml\\\",\\\"productSaleSpec\\\":\\\"1盒\\\",\\\"productSpec\\\":\\\"1盒\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6926892576109\\\",\\\"saleCount\\\":6.000000,\\\"minUnitTotalCount\\\":6.000000,\\\"sellPrice\\\":1.583333,\\\"sellPriceUnit\\\":\\\"盒\\\",\\\"packageName\\\":\\\"盒\\\",\\\"unitName\\\":\\\"盒\\\",\\\"sellUnit\\\":\\\"盒\\\",\\\"totalAmount\\\":9.499998000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":9.500000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":1.333333000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267865,\\\"secondOwnerId\\\":1395869718239562206,\\\"saleCount\\\":6.000000,\\\"minUnitTotalCount\\\":6.000000}]},{\\\"orderItemId\\\":5159163741352267866,\\\"productInfoSpecificationId\\\":553562,\\\"productSkuId\\\":5066385509054309082,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"集良木金银花蒲公英茶255g\\\",\\\"productSaleSpec\\\":\\\"1袋\\\",\\\"productSpec\\\":\\\"1袋\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6971793502832\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":14.800000,\\\"sellPriceUnit\\\":\\\"袋\\\",\\\"packageName\\\":\\\"袋\\\",\\\"unitName\\\":\\\"袋\\\",\\\"sellUnit\\\":\\\"袋\\\",\\\"totalAmount\\\":14.800000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":14.800000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":12.000000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267866,\\\"secondOwnerId\\\":5043896006095363221,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267867,\\\"productInfoSpecificationId\\\":405591,\\\"productSkuId\\\":5139541866214788442,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"意文菠萝汁1L\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"5290040004198\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":8.520000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":8.520000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":8.520000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":6.500000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267867,\\\"secondOwnerId\\\":5040604360256251795,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267868,\\\"productInfoSpecificationId\\\":587047,\\\"productSkuId\\\":5156201586320781715,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"今麦郎天豹电解质饮料荔枝海盐口味520ml\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6939729904808\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":3.670000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":3.670000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":3.670000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":3.000000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267868,\\\"secondOwnerId\\\":1395869718239564606,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267869,\\\"productInfoSpecificationId\\\":233305,\\\"productSkuId\\\":5026147100234382037,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"VOSS芙丝饮用天然矿泉水330ml\\\",\\\"productSaleSpec\\\":\\\"1瓶\\\",\\\"productSpec\\\":\\\"1瓶\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6970920140015\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":3.120000,\\\"sellPriceUnit\\\":\\\"瓶\\\",\\\"packageName\\\":\\\"瓶\\\",\\\"unitName\\\":\\\"瓶\\\",\\\"sellUnit\\\":\\\"瓶\\\",\\\"totalAmount\\\":3.120000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":3.120000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":2.916665000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267869,\\\"secondOwnerId\\\":1395869718239557406,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267870,\\\"productInfoSpecificationId\\\":441314,\\\"productSkuId\\\":5063891720317866386,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"辈儿香八爪烧酱爆肉味200g\\\",\\\"productSaleSpec\\\":\\\"1袋\\\",\\\"productSpec\\\":\\\"1袋\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6937821529806\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":6.500000,\\\"sellPriceUnit\\\":\\\"袋\\\",\\\"packageName\\\":\\\"袋\\\",\\\"unitName\\\":\\\"袋\\\",\\\"sellUnit\\\":\\\"袋\\\",\\\"totalAmount\\\":6.500000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":6.500000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":5.500000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267870,\\\"secondOwnerId\\\":1395869718239579060,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]},{\\\"orderItemId\\\":5159163741352267871,\\\"productInfoSpecificationId\\\":59264,\\\"productSkuId\\\":5026146588216787526,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"统一汤达人日式豚骨拉面五合一【包】125g\\\",\\\"productSaleSpec\\\":\\\"1袋\\\",\\\"productSpec\\\":\\\"1袋\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6925303710903\\\",\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000,\\\"sellPrice\\\":18.900000,\\\"sellPriceUnit\\\":\\\"袋\\\",\\\"packageName\\\":\\\"袋\\\",\\\"unitName\\\":\\\"袋\\\",\\\"sellUnit\\\":\\\"袋\\\",\\\"totalAmount\\\":18.900000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":18.900000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":17.000000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159163741352267871,\\\"secondOwnerId\\\":1395869718239582115,\\\"saleCount\\\":1.000000,\\\"minUnitTotalCount\\\":1.000000}]}],\\\"cityId\\\":2260555425545285415,\\\"ownerId\\\":2260555425545285415,\\\"warehouseId\\\":70000031,\\\"orderId\\\":5159163741348664209,\\\"orderNo\\\":\\\"5159163741348664209\\\",\\\"orderCreateTime\\\":1676800863335,\\\"payType\\\":0,\\\"userId\\\":1204,\\\"userName\\\":\\\"李宇飞\\\",\\\"userCompanyName\\\":\\\"石家庄易尔惠双鸽食品城折扣仓\\\",\\\"userMobileNo\\\":\\\"15227871882\\\",\\\"detailAddress\\\":\\\"胜利南街307号双鸽食品城二楼\\\",\\\"addressId\\\":0,\\\"province\\\":\\\"河北省\\\",\\\"city\\\":\\\"石家庄市\\\",\\\"county\\\":\\\"裕华区\\\",\\\"street\\\":\\\"建通街道\\\",\\\"contact\\\":\\\"李宇飞\\\",\\\"phone\\\":\\\"15227871882\\\",\\\"latitude\\\":37.994972,\\\"longitude\\\":114.494156,\\\"sysRemark\\\":null,\\\"orderAmount\\\":92.729998000000,\\\"reduceAmount\\\":null,\\\"useBonusAmount\\\":null,\\\"productReduceAmount\\\":null,\\\"useCouponAmount\\\":null,\\\"payableAmount\\\":92.730000,\\\"createUserId\\\":2260555425527163155,\\\"wmsRegionId\\\":7000003,\\\"offlineFlag\\\":1,\\\"shopType\\\":1}\"}";
        return "{\"id\":\"5ff81ef6-eeb6-4434-9894-00db350a04ad\",\"messageBody\":\"{\\\"items\\\":[{\\\"orderItemId\\\":5159442207681591504,\\\"productInfoSpecificationId\\\":163865,\\\"productSkuId\\\":5026147182790867660,\\\"unifySkuId\\\":null,\\\"productName\\\":\\\"钻石(金石)\\\",\\\"productSaleSpec\\\":\\\"1盒\\\",\\\"productSpec\\\":\\\"1盒\\\",\\\"saleSpecQuantity\\\":1,\\\"specQuantity\\\":1,\\\"productBrand\\\":null,\\\"productStatisticsClass\\\":null,\\\"statisticsCategoryName\\\":null,\\\"boxCode\\\":\\\"6901028250788\\\",\\\"saleCount\\\":2.000000,\\\"minUnitTotalCount\\\":2.000000,\\\"sellPrice\\\":16.000000,\\\"sellPriceUnit\\\":\\\"盒\\\",\\\"packageName\\\":\\\"盒\\\",\\\"unitName\\\":\\\"盒\\\",\\\"sellUnit\\\":\\\"盒\\\",\\\"totalAmount\\\":32.000000000000,\\\"reduceProductAmount\\\":null,\\\"reduceOrderAmount\\\":null,\\\"reduceCouponAmount\\\":null,\\\"reduceBonusAmount\\\":null,\\\"reduceTotal\\\":null,\\\"payAmount\\\":32.000000,\\\"ownerId\\\":null,\\\"centerProductOwnerId\\\":2260555425545285415,\\\"unitCostprice\\\":14.310000000000,\\\"ownerItems\\\":[{\\\"orderItemId\\\":5159442207681591504,\\\"secondOwnerId\\\":5028577587191831442,\\\"saleCount\\\":2.000000,\\\"minUnitTotalCount\\\":2.000000}]}],\\\"cityId\\\":2260555425545285415,\\\"ownerId\\\":2260555425545285415,\\\"warehouseId\\\":70000034,\\\"orderId\\\":5159442207674943111,\\\"orderNo\\\":\\\"5159442207674943111\\\",\\\"orderCreateTime\\\":1676867254782,\\\"payType\\\":0,\\\"userId\\\":1201,\\\"userName\\\":\\\"苏云静\\\",\\\"userCompanyName\\\":\\\"石家庄易尔惠师大店\\\",\\\"userMobileNo\\\":\\\"17098331612\\\",\\\"detailAddress\\\":\\\"建设南大街师大科技园C座1层\\\",\\\"addressId\\\":0,\\\"province\\\":\\\"河北省\\\",\\\"city\\\":\\\"石家庄市\\\",\\\"county\\\":\\\"裕华区\\\",\\\"street\\\":null,\\\"contact\\\":\\\"苏云静\\\",\\\"phone\\\":\\\"17098331612\\\",\\\"latitude\\\":37.996265,\\\"longitude\\\":114.51387,\\\"sysRemark\\\":null,\\\"orderAmount\\\":32.000000000000,\\\"reduceAmount\\\":null,\\\"useBonusAmount\\\":null,\\\"productReduceAmount\\\":null,\\\"useCouponAmount\\\":null,\\\"payableAmount\\\":32.000000,\\\"createUserId\\\":1323386169814995352,\\\"wmsRegionId\\\":7000003,\\\"offlineFlag\\\":1,\\\"shopType\\\":1}\"}";
    }
}
