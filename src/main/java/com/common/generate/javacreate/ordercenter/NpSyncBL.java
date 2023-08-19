package com.common.generate.javacreate.ordercenter;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;
import com.common.generate.javacreate.ordercenter.dto.TrainsOutStockDTO;
import com.common.generate.javacreate.ordercenter.dto.TrainsOutStockDealerDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.FileUtil;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2023/7/25 16:39
 */
public class NpSyncBL {


    public static void main(String[] args){
        TrainsOutStockDTO preData = getPreData();
        System.out.println(JSON.toJSONString(preData));
        NewApiTest.nptOutSyncErp("pre",JSON.toJSONString(preData));
    }


    private static TrainsOutStockDTO getReleaseData() {
        String json ="{\"deliveryTaskId\":\"5215662834877877899\",\"deliveryCarNumber\":\"CK724123072500002\",\"cityId\":724,\"warehouseId\":7241,\"optUserId\":\"67799384\",\"outStockTime\":1690271779077,\"trainsOutStockOrderList\":[{\"orderId\":5215660868280881931,\"orderType\":1,\"trainsInStockOrderItemList\":null,\"trainsOutStockOrderItemList\":[{\"orderItemId\":5215660869567094601,\"unitTotalCount\":54.000000,\"trainsInStockDealerList\":null,\"trainsOutStockDealerList\":[{\"unitTotalCount\":54.000000,\"secOwnerId\":1,\"productionDate\":null,\"ownerId\":null,\"erpSecOwnerId\":null,\"productSpecificationId\":560037,\"expirationDate\":null}],\"outStockOrderItemId\":5215660890365378947,\"inStockOrderItemId\":null,\"tag\":null,\"productSkuId\":null},{\"orderItemId\":5215660869718089550,\"unitTotalCount\":54.000000,\"trainsInStockDealerList\":null,\"trainsOutStockDealerList\":[{\"unitTotalCount\":54.000000,\"secOwnerId\":2405152967181595524,\"productionDate\":null,\"ownerId\":null,\"erpSecOwnerId\":null,\"productSpecificationId\":559945,\"expirationDate\":null}],\"outStockOrderItemId\":5215660890466042252,\"inStockOrderItemId\":null,\"tag\":null,\"productSkuId\":null}],\"outStockOrderType\":8,\"outStockOrderId\":5215660890129161826,\"inStockOrderType\":null,\"inStockOrderId\":null,\"inBoundType\":null,\"imageUrls\":null,\"reviewImageUrls\":null,\"tag\":null}],\"deliveryTaskChangeFetchOrderList\":[{\"fetchOrderId\":7240392307251500029,\"deliveryTaskChangeFetchOrderItemList\":[{\"orderId\":5215660868280881931,\"orderItemId\":5215660869567094601,\"scheduleUnitTotalCount\":54.000000},{\"orderId\":5215660868280881931,\"orderItemId\":5215660869718089550,\"scheduleUnitTotalCount\":54.000000}]}],\"advancePickup\":false}";
        TrainsOutStockDTO trainsOutStockDTO = JSON.parseObject(json, TrainsOutStockDTO.class);
        return trainsOutStockDTO;
    }

    private static TrainsOutStockDTO getPreData() {
        String json = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\内配退异常.txt");;
//        String json ="";
        TrainsOutStockDTO trainsOutStockDTO = JSON.parseObject(json, TrainsOutStockDTO.class);
        fixNptOutData(trainsOutStockDTO);

        List<Long> orderItemIds = new ArrayList<>();
        trainsOutStockDTO.getTrainsOutStockOrderList().forEach(it->it.getTrainsOutStockOrderItemList().forEach(item->{
            List<TrainsOutStockDealerDTO> trainsOutStockDealerList = item.getTrainsOutStockDealerList();
            for (TrainsOutStockDealerDTO trainsOutStockDealerDTO : trainsOutStockDealerList) {
                if(trainsOutStockDealerDTO.getSecOwnerId()==null){
                    orderItemIds.add(item.getOrderItemId());
                }
            }
        }));

        if(CollectionUtils.isNotEmpty(orderItemIds)){
            throw new BusinessException("二级货主id不能为null,"+orderItemIds);
        }
        return trainsOutStockDTO;
    }


    @SneakyThrows
    private static void fixNptOutData(TrainsOutStockDTO trainsOutStockDTO) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\内配退二级货主异常.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        List<ElkDTO> list = ExcelUtils.readExcelToEntity(ElkDTO.class, file, "内配退二级货主异常.xlsx");
        Map<Long, List<ElkDTO>> map = list.stream().filter(it -> it.getItemId() != null).collect(Collectors.groupingBy(it -> it.getItemId()));
        trainsOutStockDTO.getTrainsOutStockOrderList().forEach(it -> it.getTrainsOutStockOrderItemList().forEach(item -> {
            List<TrainsOutStockDealerDTO> trainsOutStockDealerList = item.getTrainsOutStockDealerList();
            Map<Long, TrainsOutStockDealerDTO> dealerMap = trainsOutStockDealerList.stream().collect(Collectors.toMap(dealer -> dealer.getSecOwnerId(), dealer -> dealer));

            List<ElkDTO> itemDetails = map.get(item.getOrderItemId());
            Map<Long, ElkDTO> itemSecMap = itemDetails.stream().collect(Collectors.toMap(detail -> detail.getSecOwnerId(), detail -> detail));
            Long productSpecificationId = trainsOutStockDealerList.get(0).getProductSpecificationId();
            Long ownerId = trainsOutStockDealerList.get(0).getOwnerId();
            List<TrainsOutStockDealerDTO> newList = new ArrayList<>();
            for (TrainsOutStockDealerDTO trainsOutStockDealerDTO : trainsOutStockDealerList) {
                Long secOwnerId = trainsOutStockDealerDTO.getSecOwnerId();
                if (secOwnerId == null) {
                    ElkDTO elkDTO = itemSecMap.get(secOwnerId);
                    if (elkDTO.getCount().compareTo(trainsOutStockDealerDTO.getUnitTotalCount()) != 0) {
                        System.out.println("二级货主空货主数量异常," + item.getOrderItemId());
                        trainsOutStockDealerDTO.setUnitTotalCount(elkDTO.getCount());
                    }
                } else {
                    ElkDTO elkDTO = itemSecMap.get(secOwnerId);
                    if (elkDTO.getCount().compareTo(trainsOutStockDealerDTO.getUnitTotalCount()) != 0) {
                        trainsOutStockDealerDTO.setUnitTotalCount(elkDTO.getCount());
                        System.out.println("二级货主数量异常," + item.getOrderItemId());
                    }else {
                        if(!elkDTO.getSecOwnerId().equals(secOwnerId)){
                            System.out.println("二级货主变更,"+item.getOrderItemId());
                            trainsOutStockDealerDTO.setSecOwnerId(elkDTO.getSecOwnerId());
                        }
                    }
                }
            }

            for (Map.Entry<Long, ElkDTO> entry : itemSecMap.entrySet()) {
                TrainsOutStockDealerDTO trainsOutStockDealerDTO = dealerMap.get(entry.getKey());
                if(trainsOutStockDealerDTO==null){
                    ElkDTO value = entry.getValue();

                    TrainsOutStockDealerDTO newDTO = new TrainsOutStockDealerDTO();
                    newDTO.setSecOwnerId(value.getSecOwnerId());
                    newDTO.setUnitTotalCount(value.getCount());
                    newDTO.setProductSpecificationId(productSpecificationId);
                    newList.add(newDTO);
                }
            }

            if(CollectionUtils.isNotEmpty(newList)){
                trainsOutStockDealerList.addAll(newList);
            }

            item.setTrainsOutStockDealerList(trainsOutStockDealerList);


        }));
    }


}
