package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.test.groupsettle.dto.ErpProductOwnerDTO;
import com.common.generate.javacreate.test.groupsettle.util.BaseUtils;
import com.common.generate.javacreate.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/5/2 16:04
 */
public class FindError {


    public static void main(String[] args){
        List<ErpProductOwnerDTO> chayiError = findChayiError();
        List<ErpProductOwnerDTO> jiesuanChuError = findJiesuanChuError();
        List<ErpProductOwnerDTO> jiesuanRu = findJiesuanRu();

        List<ErpProductOwnerDTO> list =new ArrayList<>();
        list.addAll(chayiError);
        list.addAll(jiesuanChuError);
        list.addAll(jiesuanRu);

        List<ErpProductOwnerDTO> result =new ArrayList<>();
        Map<String, List<ErpProductOwnerDTO>> collect = list.stream().filter(it -> StringUtils.isNotEmpty(it.getErrorErpOwnerId())).collect(Collectors.groupingBy(it -> it.getProductSkuId() + "_" + it.getErrorWmsOwnerId()));
       List<Integer> orderTypes = Arrays.asList(77,80);
        for (List<ErpProductOwnerDTO> value : collect.values()) {
            BigDecimal addCount = value.stream().filter(it->orderTypes.contains(it.getOrderType())).map(it -> it.getUnitTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal subCount = value.stream().filter(it->it.getOrderType().equals(78)).map(it -> it.getUnitTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            ErpProductOwnerDTO dto = new ErpProductOwnerDTO();
            BeanUtils.copyProperties(value.get(0), dto);
            dto.setOrderType(null);
            dto.setType("");
            dto.setUnitTotalCount(addCount.subtract(subCount));
            if(dto.getUnitTotalCount().compareTo(BigDecimal.ZERO)!=0){
                result.add(dto);
            }
        }
        System.out.println("最终结果:"+JSON.toJSONString(result));

    }


    public static List<ErpProductOwnerDTO> findChayiError(){
        List<ErpProductOwnerDTO> result =new ArrayList<>();
        List<ErpProductOwnerDTO> erpProductOwnerDTOS = geterpChayidata();
        for (ErpProductOwnerDTO it : erpProductOwnerDTOS) {
            if(!it.getTureErpOwnerId().contains("("+it.getErrorWmsOwnerId()+")")){
                result.add(it);
            }
        }
        System.out.println("结算出:"+JSON.toJSONString(result));
        return result;
    }

    public static List<ErpProductOwnerDTO> findJiesuanChuError(){
        List<ErpProductOwnerDTO> result =new ArrayList<>();
        List<ErpProductOwnerDTO> erpProductOwnerDTOS = geterpJiesuanChudata();
        for (ErpProductOwnerDTO it : erpProductOwnerDTOS) {
            if(!it.getTureErpOwnerId().contains("("+it.getErrorWmsOwnerId()+")")){
                result.add(it);
            }
        }
        System.out.println("结算出:"+JSON.toJSONString(result));
        return result;
    }

    public static List<ErpProductOwnerDTO> findJiesuanRu(){
        List<ErpProductOwnerDTO> result =new ArrayList<>();
        List<ErpProductOwnerDTO> erpProductOwnerDTOS = geterpJiesuanRudata();
        for (ErpProductOwnerDTO it : erpProductOwnerDTOS) {
            if(!it.getTureErpOwnerId().contains("("+it.getErrorWmsOwnerId()+")")){
                result.add(it);
            }
        }
        System.out.println("结算出:"+JSON.toJSONString(result));
        return result;
    }




    /**
     * 获取结算单
     *
     * @return
     */
    public static List<ErpProductOwnerDTO> geterpJiesuanChudata() {
        String text = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\结算\\结算出.json");
        List<ErpProductOwnerDTO> result = JSON.parseArray(text, ErpProductOwnerDTO.class);

        List<ErpProductOwnerDTO> collect = result.stream().filter(it -> it.getWarehouseId() == null).collect(Collectors.toList());
        System.out.println("仓库id不存在：" + JSON.toJSONString(collect));

        Set<Long> skuIds = result.stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
        Set<Long> ownerIds = result.stream().map(it -> it.getErrorWmsOwnerId()).collect(Collectors.toSet());
        Map<String, String> erpOwner = BaseUtils.getErpOwner();
        System.out.println("所有结算单货主数据数据：" + JSON.toJSONString(ownerIds));
        System.out.println("所有结算单sku数据：" + JSON.toJSONString(skuIds));
        result.stream().forEach(it->{
            if(it.getOrderType().equals(77)){
                it.setType("结算出");
            }
            if(it.getErrorWmsOwnerId()!=null && StringUtils.isEmpty(it.getErrorErpOwnerId())){
                it.setErrorErpOwnerId(erpOwner.get(String.valueOf(it.getErrorWmsOwnerId())));
            }
        });
        System.out.println("结算单:"+JSON.toJSONString(result));
        return result;
    }


    /**
     * 获取结算单
     *
     * @return
     */
    public static List<ErpProductOwnerDTO> geterpJiesuanRudata() {
        String text = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\结算\\结算入.json");
        List<ErpProductOwnerDTO> result = JSON.parseArray(text, ErpProductOwnerDTO.class);

        List<ErpProductOwnerDTO> collect = result.stream().filter(it -> it.getWarehouseId() == null).collect(Collectors.toList());
        System.out.println("仓库id不存在：" + JSON.toJSONString(collect));

        Set<Long> skuIds = result.stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
        Set<Long> ownerIds = result.stream().map(it -> it.getErrorWmsOwnerId()).collect(Collectors.toSet());
        Map<String, String> erpOwner = BaseUtils.getErpOwner();

        System.out.println("所有结算单货主数据数据：" + JSON.toJSONString(ownerIds));
        System.out.println("所有结算单sku数据：" + JSON.toJSONString(skuIds));
        result.stream().forEach(it->{
            if(it.getOrderType().equals(78)){
                it.setType("结算入");
            }
            if(it.getErrorWmsOwnerId()!=null && StringUtils.isEmpty(it.getErrorErpOwnerId())){
                it.setErrorErpOwnerId(erpOwner.get(String.valueOf(it.getErrorWmsOwnerId())));
            }
        });
        return result;
    }


    /**
     * 获取结算单
     *
     * @return
     */
    public static List<ErpProductOwnerDTO> geterpChayidata() {
        String text = FileUtil.readFileByLines("C:\\Users\\Administrator\\Desktop\\结算\\差异.json");
        List<ErpProductOwnerDTO> result = JSON.parseArray(text, ErpProductOwnerDTO.class);

        List<ErpProductOwnerDTO> collect = result.stream().filter(it -> it.getWarehouseId() == null).collect(Collectors.toList());
        System.out.println("仓库id不存在：" + JSON.toJSONString(collect));

        Set<Long> skuIds = result.stream().map(it -> it.getProductSkuId()).collect(Collectors.toSet());
        Set<Long> ownerIds = result.stream().map(it -> it.getErrorWmsOwnerId()).collect(Collectors.toSet());

        System.out.println("所有结算单货主数据数据：" + JSON.toJSONString(ownerIds));
        System.out.println("所有结算单sku数据：" + JSON.toJSONString(skuIds));
        result.stream().forEach(it->{
            it.setOrderType(80);
        });
        return result;
    }
}
