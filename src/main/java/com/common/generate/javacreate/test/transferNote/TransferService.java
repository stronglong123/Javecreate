package com.common.generate.javacreate.test.transferNote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.utils.HttpClientUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/2/7 19:35
 */

@Service
public class TransferService {

    private static final String token = "08b1567a-fd15-4d3f-a8f3-bd87da43cd02";

    private static final String baseUrl = "https://wms.yijiupi.com/supplyChain/";


    public static void main(String[] args) {
        TransferService transferService = new TransferService();
        transferService.findTransferError();
    }


    public void findTransferError() {
        List<ErrorResult> allResult = new ArrayList<>();
        List<TransferNoteDTO> transferNoteDTOS = listTransferNote();
        /**倒数锁*/
        /**定义线程池大小为5*/
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //结束的倒数锁
        final CountDownLatch latch = new CountDownLatch(transferNoteDTOS.size());
        for (int i = 1; i <= transferNoteDTOS.size(); i++) {
            int finalI = i;
            Runnable runnable = () -> {
                try {
                    List<ErrorResult> transferError = findTransferError(transferNoteDTOS.get(finalI));
                    if(CollectionUtils.isNotEmpty(transferError)){
                        allResult.addAll(transferError);
                    }
                } finally {
                    //有一个线程进来就减1
                    latch.countDown();
                }
            };
            pool.submit(runnable);
        }
        /**采用countlatch的递减方法，同时执行await()方法进行阻塞，每一个线程执行完就进行递减，直到为0才继续执行最终的统计输出代码*/
        try {
            //阻塞，直到latch为0才执行下面的输出语句
            latch.await();
            System.out.println("所有线程执行完毕！");
        } catch (Exception e) {
            throw new BusinessValidateException("线程执行失败");
        }
        pool.shutdown();

        Map<String, List<ErrorResult>> transferError = allResult.stream().collect(Collectors.groupingBy(ErrorResult::getTransferNo));
        System.out.println("最终比对结果：" + JSON.toJSONString(transferError));
        setSql(transferError);
        setTransferNo(allResult);
    }


//    public void findTransferError2() {
//        List<ErrorResult> allResult = new ArrayList<>();
//        List<TransferNoteDTO> transferNoteDTOS = listTransferNote();
//        for (TransferNoteDTO transferNoteDTO : transferNoteDTOS) {
//            if(transferNoteDTO.getOrgId()==999||transferNoteDTO.getOrgId()==998||transferNoteDTO.getInOrgId()==999||transferNoteDTO.getInOrgId()==998){
//                continue;
//            }
//            List<OutStockOrderDTO> outStocks = findOutStock(transferNoteDTO.getOrgId(), transferNoteDTO.getOutWarehouseId(), transferNoteDTO.getTransferNo());
//            List<InStockApplyDTO> inStockApplys = findInStockApply(transferNoteDTO.getInOrgId(), transferNoteDTO.getInWarehouseId(), transferNoteDTO.getTransferNo());
//            for (InStockApplyDTO inStockApplyDTO : inStockApplys) {
//                String relatedNoteNO = inStockApplyDTO.getRelatedNoteNO();
//                OutStockOrderDTO outStockOrderDTO = outStocks.stream().filter(it -> it.getRefOrderNo().equals(relatedNoteNO)).findFirst().orElse(null);
//                if (outStockOrderDTO == null) {
//                    System.out.println(inStockApplyDTO.getBusinessNO() + "调拨入库申请单没有对应单号");
//                }
//                List<OutStockOrderItemDTO> outStockOrderItemDTOS = outStockOrderDTO.getOutStockOrderItemDTOS();
//                List<InStockItemApplyDTO> applyItems = inStockApplyDTO.getItems();
//                List<TransferNoteItemDTO> transferNoteItems = transferNoteDTO.getTransferNoteItems();
//                List<ErrorResult> error = findError(outStockOrderItemDTOS, applyItems, transferNoteItems);
//                System.out.println("比对数据：" + JSON.toJSONString(error));
//                List<ErrorResult> collect = error.stream().filter(ErrorResult::isError).collect(Collectors.toList());
//                System.out.println("比对结果：" + JSON.toJSONString(collect));
//                if (CollectionUtils.isNotEmpty(collect)) {
//                    collect.forEach(it -> it.setTransferNo(transferNoteDTO.getTransferNo()));
//                    allResult.addAll(collect);
//                }
//            }
//            findTransferError(transferNoteDTO);
//        }
//        Map<String, List<ErrorResult>> transferError = allResult.stream().collect(Collectors.groupingBy(ErrorResult::getTransferNo));
//        System.out.println("最终比对结果：" + JSON.toJSONString(transferError));
//        setSql(transferError);
//        setTransferNo(allResult);
//    }

    public List<ErrorResult> findTransferError(TransferNoteDTO transferNoteDTO) {
        List<ErrorResult> allResult =new ArrayList<>();
        if(transferNoteDTO.getOrgId()==999||transferNoteDTO.getOrgId()==998||transferNoteDTO.getInOrgId()==999||transferNoteDTO.getInOrgId()==998){
            return allResult;
        }
        List<OutStockOrderDTO> outStocks = findOutStock(transferNoteDTO.getOrgId(), transferNoteDTO.getOutWarehouseId(), transferNoteDTO.getTransferNo());
        List<InStockApplyDTO> inStockApplys = findInStockApply(transferNoteDTO.getInOrgId(), transferNoteDTO.getInWarehouseId(), transferNoteDTO.getTransferNo());
        for (InStockApplyDTO inStockApplyDTO : inStockApplys) {
            String relatedNoteNO = inStockApplyDTO.getRelatedNoteNO();
            OutStockOrderDTO outStockOrderDTO = outStocks.stream().filter(it -> it.getRefOrderNo().equals(relatedNoteNO)).findFirst().orElse(null);
            if (outStockOrderDTO == null) {
                System.out.println(inStockApplyDTO.getBusinessNO() + "调拨入库申请单没有对应单号");
            }
            List<OutStockOrderItemDTO> outStockOrderItemDTOS = outStockOrderDTO.getOutStockOrderItemDTOS();
            List<InStockItemApplyDTO> applyItems = inStockApplyDTO.getItems();
            List<TransferNoteItemDTO> transferNoteItems = transferNoteDTO.getTransferNoteItems();
            List<ErrorResult> error = findError(outStockOrderItemDTOS, applyItems, transferNoteItems);
            System.out.println("比对数据：" + JSON.toJSONString(error));
            List<ErrorResult> collect = error.stream().filter(ErrorResult::isError).collect(Collectors.toList());
            System.out.println("比对结果：" + JSON.toJSONString(collect));
            if (CollectionUtils.isNotEmpty(collect)) {
                collect.forEach(it -> it.setTransferNo(transferNoteDTO.getTransferNo()));
                allResult.addAll(collect);
            }
        }
        return allResult;
    }


    private List<ErrorResult> findError(List<OutStockOrderItemDTO> outStockOrderItemDTOS, List<InStockItemApplyDTO> applyItems, List<TransferNoteItemDTO> transferNoteItems) {
        List<ErrorResult> errorResults = new ArrayList<>();
        Map<String, List<OutStockOrderItemDTO>> outItemMap = outStockOrderItemDTOS.stream().collect(Collectors.groupingBy(it -> it.getProductSpecificationId() + "_" + it.getOwnerId()));
        Map<String, List<InStockItemApplyDTO>> applyItemMap = applyItems.stream().collect(Collectors.groupingBy(it -> it.getProductSpecificationId() + "_" + it.getOwnerId()));
        Map<String, List<TransferNoteItemDTO>> transferItemMap = transferNoteItems.stream().collect(Collectors.groupingBy(it -> it.getSpecificationId() + "_" + it.getProductOwnerId()));
        for (Map.Entry<String, List<InStockItemApplyDTO>> inApplyItemEntity : applyItemMap.entrySet()) {
            String key = inApplyItemEntity.getKey();
            List<InStockItemApplyDTO> values = inApplyItemEntity.getValue();
            List<OutStockOrderItemDTO> outItems = outItemMap.get(key);
            List<TransferNoteItemDTO> transferItems = transferItemMap.get(key);
            List<OutErrorResult> outErrorResults = convertOutErrorResult(outItems, "");
            List<InApplyErrorResult> inApplyErrorResults = convertApplyErrorResult(values, "");
            ErrorResult errorResult = new ErrorResult();
            errorResult.setProductName(values.get(0).getProductName());

            errorResult.setError(false);
//            if (checkError(outErrorResults, inApplyErrorResults)) {
//                errorResult.setOutErrorResults(outErrorResults);
//                errorResult.setInApplyErrorResults(inApplyErrorResults);
//                errorResult.setError(true);
//                errorResults.add(errorResult);
//            }
            if (!errorResult.isError() && checkCountError(inApplyErrorResults, transferItems)) {
                errorResult.setError(true);
                List<InApplyErrorResult> collect = inApplyErrorResults.stream().filter(it -> it.getTranferItemInUnitTotalCount() != null).collect(Collectors.toList());
                errorResult.setInApplyErrorResults(collect);
                errorResults.add(errorResult);
            }
        }
        return errorResults;
    }

    private boolean checkCountError(List<InApplyErrorResult> inApplyErrorResults, List<TransferNoteItemDTO> transferItems) {
        boolean hasError = false;
        for (InApplyErrorResult inApplyErrorResult : inApplyErrorResults) {
            TransferNoteItemDTO noteItemDTO = transferItems.stream().filter(it -> (it.getSpecificationId() + "_" + it.getProductOwnerId()).equals(inApplyErrorResult.getProductSpecificationId() + "_" + inApplyErrorResult.getInApplyOwnerId())).findFirst().orElse(null);
            if (noteItemDTO == null) {
                hasError = true;
                continue;
            }
            if (noteItemDTO.getInUnitTotalCount() != null && inApplyErrorResult.getApplyHasInUnitTotalCount().compareTo(noteItemDTO.getInUnitTotalCount()) != 0) {
                inApplyErrorResult.setTranferItemInUnitTotalCount(noteItemDTO.getInUnitTotalCount());
                BigDecimal tranferItemInStockCount = inApplyErrorResult.getTranferItemInUnitTotalCount();
                BigDecimal[] quantitys = tranferItemInStockCount.divideAndRemainder(noteItemDTO.getSpecQuantity());
                inApplyErrorResult.setTranferItemInPackageCount(quantitys[0]);
                inApplyErrorResult.setTranferItemInUnitCount(quantitys[1]);
                hasError = true;
            }
        }
        return hasError;
    }

    private boolean checkError(List<OutErrorResult> outErrorResults, List<InApplyErrorResult> inApplyErrorResults) {
        if (outErrorResults.size() != inApplyErrorResults.size()) {
            return true;
        }
        for (InApplyErrorResult inApplyErrorResult : inApplyErrorResults) {
            List<OutErrorResult> collect = outErrorResults.stream()
                    .filter(it -> (it.getOutSecOwnerId() == null ? -1L : it.getOutSecOwnerId()) == (inApplyErrorResult.getInApplySecOwnerId() == null ? -1 : inApplyErrorResult.getInApplySecOwnerId())
                            && it.getOutUnitTotalCount().compareTo(inApplyErrorResult.getInApplyUnitTotalCount()) == 0)
                    .collect(Collectors.toList());
            if (CollectionUtils.isEmpty(collect) || collect.size() > 1) {
                return true;
            }
            OutErrorResult outErrorResult = collect.get(0);

            if (outErrorResult.getOutSecOwnerId() == null && inApplyErrorResult.getInApplySecOwnerId() == null) {
                continue;
            }
            if (outErrorResult.getOutSecOwnerId() == null || inApplyErrorResult.getInApplySecOwnerId() == null
                    || !outErrorResult.getOutSecOwnerId().equals(inApplyErrorResult.getInApplySecOwnerId())) {
                return true;
            }

        }
        return false;
    }


    private List<InApplyErrorResult> convertApplyErrorResult(List<InStockItemApplyDTO> applyItems, String outNo) {
        List<InApplyErrorResult> result = new ArrayList<>();
        for (InStockItemApplyDTO applyItem : applyItems) {
            InApplyErrorResult errorResult = new InApplyErrorResult();
            errorResult.setProductName(applyItem.getProductName());
            if (StringUtils.isNotEmpty(applyItem.getOwnerId())) {
                errorResult.setInApplyOwnerId(Long.valueOf(applyItem.getOwnerId()));
            }
            errorResult.setInApplyItemId(applyItem.getId());
            errorResult.setInApplySecOwnerId(applyItem.getSecOwnerId());
            errorResult.setInApplyUnitTotalCount(applyItem.getApplyUnitTotalCount());
            errorResult.setApplyHasInPackageCount(applyItem.getInStockPackageCount());
            errorResult.setApplyHasInUnitCount(applyItem.getApplyUnitCount());
            errorResult.setApplyHasInUnitTotalCount(applyItem.getInStockUnitTotalCount());
            errorResult.setBusinessItemId(applyItem.getBusinessItemId());
            errorResult.setSpecQuantity(applyItem.getSpecQuantity());
            errorResult.setProductSpecificationId(applyItem.getProductSpecificationId());
            result.add(errorResult);
        }
        result.sort(Comparator.comparing(it -> it.getInApplyUnitTotalCount()));
        return result;
    }


    private List<OutErrorResult> convertOutErrorResult(List<OutStockOrderItemDTO> outItems, String outNo) {
        if (CollectionUtils.isEmpty(outItems)) {
            return new ArrayList<>();
        }
        List<OutErrorResult> result = new ArrayList<>();
        for (OutStockOrderItemDTO outItem : outItems) {
            List<OutStockOrderItemDetailDTO> itemDetailDTOS = outItem.getOutStockOrderItemDetailDTOS();
            if (CollectionUtils.isEmpty(itemDetailDTOS)) {
                OutErrorResult outErrorResult = new OutErrorResult();
                outErrorResult.setOutNo(outNo);
                outErrorResult.setOutItemId(Long.valueOf(outItem.getId()));
                outErrorResult.setProductName(outItem.getProductName());
                outErrorResult.setOutOwnerId(outItem.getOwnerId());
                outErrorResult.setOutSecOwnerId(outItem.getSecOwnerId());
                outErrorResult.setOutUnitTotalCount(outItem.getUnitTotalCount());
                outErrorResult.setProductSpecificationId(outItem.getProductSpecificationId());
                result.add(outErrorResult);
                continue;
            }
            for (OutStockOrderItemDetailDTO itemDetailDTO : itemDetailDTOS) {
                OutErrorResult outErrorResult = new OutErrorResult();
                outErrorResult.setOutNo(outNo);
                outErrorResult.setOutItemId(Long.valueOf(outItem.getId()));
                outErrorResult.setOutItemDetailId(itemDetailDTO.getId());
                outErrorResult.setProductSpecificationId(outItem.getProductSpecificationId());
                outErrorResult.setProductName(outItem.getProductName());
                outErrorResult.setOutOwnerId(itemDetailDTO.getOwnerId());
                outErrorResult.setOutSecOwnerId(itemDetailDTO.getSecOwnerId());
                outErrorResult.setOutUnitTotalCount(itemDetailDTO.getUnitTotalCount());
                result.add(outErrorResult);
            }
        }
        result.sort(Comparator.comparing(it -> it.getOutUnitTotalCount()));
        return result;
    }


    /**
     * 获取调拨单
     *
     * @return
     */
    public List<TransferNoteDTO> listTransferNote() {
        TransferNoteQueryDTO queryDTO = new TransferNoteQueryDTO();
//        queryDTO.setTransferNo("XC202101260069");
        queryDTO.setPageNum(1);
        queryDTO.setPageSize(1000);
        queryDTO.setState((byte) 5);
//        queryDTO.setTransferNo("XC202101290035");
        String url = "transfernote/getTransferNoteList";
        String dataList = pageList(url, JSON.toJSONString(queryDTO));
        System.out.println("调拨单：" + dataList);
        List<TransferNoteDTO> transferNoteDTOS = JSON.parseArray(dataList, TransferNoteDTO.class);
        return transferNoteDTOS;
    }


    /**
     * 获取出库单
     *
     * @param orgId
     * @param warehouseId
     * @param businessNo
     * @return
     */
    private List<OutStockOrderDTO> findOutStock(Integer orgId, Integer warehouseId, String businessNo) {
        OutStockOrderQueryDTO outStockOrderQueryDTO = new OutStockOrderQueryDTO();
        outStockOrderQueryDTO.setOrgId(orgId);
        outStockOrderQueryDTO.setWarehouseId(warehouseId);
        outStockOrderQueryDTO.setRefOrderNo(businessNo);
        String url = "/outStockOrder/pageListOutStockOrder";
        String dataList = pageList(url, JSON.toJSONString(outStockOrderQueryDTO));
        System.out.println("出库单：" + dataList);
        List<OutStockOrderDTO> outStockList = JSON.parseArray(dataList, OutStockOrderDTO.class);
        return outStockList;
    }


    private List<InStockApplyDTO> findInStockApply(Integer orgId, Integer warehouseId, String businessNo) {
        PurchaseInStockApplyQuery applyQuery = new PurchaseInStockApplyQuery();
        applyQuery.setRelatedNoteNO(businessNo);
        applyQuery.setCityId(orgId);
        applyQuery.setStoreHouseId(warehouseId);
        String url = "/inStockOrderApply/findInStockOrderApply";
        String dataList = pageList(url, JSON.toJSONString(applyQuery));
        List<InStockApplyDTO> applyList = JSON.parseArray(dataList, InStockApplyDTO.class);
        System.out.println("调拨入库申请单数据:" + JSON.toJSONString(applyList));
        return applyList;
    }


    public String pageList(String url, String body) {
        url = baseUrl + url;
        String resultstr = HttpClientUtils.doPostWithToken(TransferService.token, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        JSONObject pageList = (JSONObject) data;
        Object dataList = pageList.get("dataList");
        return JSON.toJSONString(dataList);
    }


    public void setSql(Map<String, List<ErrorResult>> resultMap) {
        for (Map.Entry<String, List<ErrorResult>> stringListEntry : resultMap.entrySet()) {

        }
        Map<String,String> sqlMap =new HashMap<>();


        for (Map.Entry<String, List<ErrorResult>> entry : resultMap.entrySet()) {
            List<ErrorResult> errorResults = entry.getValue();
            StringBuilder builder = new StringBuilder();
            for (ErrorResult errorResult : errorResults) {
                if (CollectionUtils.isEmpty(errorResult.getInApplyErrorResults())) {
                    continue;
                }
                for (InApplyErrorResult result : errorResult.getInApplyErrorResults()) {
                    if (result.getTranferItemInUnitTotalCount() == null) {
                        continue;
                    }
                    String namespace = getNameSpace(errorResult.getTransferNo());
                    String sql = "\r\n#" + errorResult.getTransferNo() + ";" + result.getProductName() + "\r\n" +
                            "update "+namespace+".instockitemapply " +
                            " set " +
                            "InStockPackageCount= " + result.getTranferItemInPackageCount() + "," +
                            "InStockUnitCount = " + result.getTranferItemInUnitCount() + "," +
                            "InStockUnitTotalCount  = " + result.getTranferItemInUnitTotalCount() + "," +
                            "NotInStockPackageCount= 0," +
                            "NotInStockUnitCount= 0 " +
                            " where Id = " + result.getInApplyItemId() + ";";
                    builder.append(sql).append("\r\n");
                }

            }
            sqlMap.put(entry.getKey(),builder.toString());
        }
        System.out.println("sql脚本" + JSON.toJSONString(sqlMap));
    }

    private String getNameSpace(String transferNo){
        List<String> one  = Arrays.asList("XC202006300004",
                "XC201910150080",
                "XC201911080047",
                "XC202001200014",
                "XC202010310088",
                "XC202101260069",
                "XC202001200005",
                "XC201911190055",
                "XC202001030011",
                "XC202001130047",
                "XC202006120039",
                "XC202007140030",
                "XC202001150027",
                "XC202007040090",
                "XC202101160034",
                "XC202101250027",
                "XC202007130046");
        List<String> two  = Arrays.asList("XC202010240041",
                "XC202011160019",
                "XC201911060074",
                "XC202006040014",
                "XC202007250031",
                "XC202006020025",
                "XC202006030106",
                "XC202010270028",
                "XC201911060048",
                "XC202006040009",
                "XC202007250067",
                "XC202008210032",
                "XC202006120038",
                "XC202008030069",
                "XC202010270021",
                "XC202005200072",
                "XC202008140067");
        List<String> thre  = Arrays.asList(
                "XC202005270009",
                "XC202010200092",
                "XC202010200043");


        if(one.contains(transferNo)){
            return "sc_stockorder_1";
        }
        if(two.contains(transferNo)){
            return "sc_stockorder_2";
        }
        if(thre.contains(transferNo)){
            return "sc_stockorder_3";
        }
        return "sc_stockorder_0";

    }



    private void setTransferNo(List<ErrorResult> allResult){
        Set<String>  allTransferNo =new HashSet<>();
        Set<String>  inStockTransferNo =new HashSet<>();

        allResult.forEach(it->{
            allTransferNo.add(it.getTransferNo());
            it.getInApplyErrorResults().stream()
                    .filter(inApplyError->inApplyError.getApplyHasInUnitTotalCount() != null
                            && inApplyError.getApplyHasInUnitTotalCount().compareTo(BigDecimal.ZERO) > 0)
                    .forEach(inApplyError-> inStockTransferNo.add(it.getTransferNo()));
        });
        System.out.println("全部调拨单单号：" + JSON.toJSONString(allTransferNo));
        System.out.println("有入库调拨单单号：" + JSON.toJSONString(inStockTransferNo));


    }


}
