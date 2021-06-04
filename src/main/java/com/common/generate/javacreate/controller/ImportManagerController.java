package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.authutils.MyBeanUtil;
import com.common.generate.javacreate.model.CategoryDTO;
import com.common.generate.javacreate.model.TableDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.model.text.TextDTO;
import com.common.generate.javacreate.service.ITableCreateService;
import com.common.generate.javacreate.test.dto.CheckDTO;
import com.common.generate.javacreate.test.dto.ErpCheckWmsDTO;
import com.common.generate.javacreate.test.dto.ErpCheckWmsDetailDTO;
import com.common.generate.javacreate.test.dto.ErpProductSecDTO;
import com.common.generate.javacreate.test.dto.ErpResultDTO;
import com.common.generate.javacreate.test.groupsettle.dto.GroupSettleOrderBillDTO;
import com.common.generate.javacreate.test.groupsettle.service.finderrorbygroubill;
import com.common.generate.javacreate.utils.ExcelUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2020/5/15 14:57
 */
@IgnoreAuthInterceptor
@RestController
public class ImportManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ImportManagerController.class);

    @Autowired
    private ITableCreateService iTableCreateService;

    @PostMapping("/import/importTable")
    public Result<List<String>> uploadProductInfo(@RequestParam("file") MultipartFile file) throws Exception {
        if (null == file) {
            return RetResponse.makeErrRsp(new ArrayList<>(), "上传失败，无法找到文件！");
        }
        List<TableDTO> tableDTOS = ExcelUtils.readExcelToEntity(TableDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}", JSON.toJSONString(tableDTOS));
        return RetResponse.makeOKRsp(iTableCreateService.createTableInfo(tableDTOS));
    }


    @IgnoreAuthInterceptor
    @PostMapping("/import/importCategory")
    public Result importCategory(@RequestParam("file") MultipartFile file) throws Exception {
        if (null == file) {
            return RetResponse.makeErrRsp(new ArrayList<>(), "上传失败，无法找到文件！");
        }
        List<CategoryDTO> dtos = ExcelUtils.readExcelToEntity(CategoryDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}", JSON.toJSONString(dtos));

        return RetResponse.makeOKRsp(dtos);
    }

    @PostMapping("/import/test")
    public String test(@RequestParam("file") String file) {
        return "true";
    }



    @SuppressWarnings({"unchecked", "rawtypes"})
    private List<Map> convert2Map(List dtos) {
        List<Map> result = new ArrayList<>();
        dtos.forEach(dto -> result.add(MyBeanUtil.transBean2Map(dto)));
        return result;
    }


    @PostMapping("/import/uploadText")
    public void uploadText(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        List<TextDTO> tableDTOS = ExcelUtils.readExcelToEntity(TextDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}", JSON.toJSONString(tableDTOS));
        StringBuilder result = new StringBuilder();
        tableDTOS.forEach(it -> {
            result.append(("\r\n")).append(it.getTitle()).append(("\r\n")).append(it.getComment());
        });

        exportTxt(response, result.toString());
    }


    /* 导出txt文件
     * @author
     * @param	response
     * @param	text 导出的字符串
     * @return
     */
    public void exportTxt(HttpServletResponse response, String text) {
        response.setCharacterEncoding("utf-8");
        //设置响应的内容类型
        response.setContentType("text/plain");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition", "attachment;filename="
                + genAttachmentFileName("文件名称", "JSON_FOR_UCC_")//设置名称格式，没有这个中文名称无法显示
                + ".txt");
        BufferedOutputStream buff = null;
        ServletOutputStream outStr = null;
        try {
            outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            buff.write(text.getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            //LOGGER.error("导出文件文件出错:{}",e);
        } finally {
            try {
                buff.close();
                outStr.close();
            } catch (Exception e) {
                //LOGGER.error("关闭流对象出错 e:{}",e);
            }
        }
    }

    public String genAttachmentFileName(String cnName, String defaultName) {
        try {
            cnName = new String(cnName.getBytes("gb2312"), "ISO8859-1");
        } catch (Exception e) {
            cnName = defaultName;
        }
        return cnName;
    }

    @PostMapping("/import/parse")
    public void parse(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        List<TextDTO> tableDTOS = ExcelUtils.readExcelToEntity(TextDTO.class, file.getInputStream(), file.getOriginalFilename());
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (TextDTO it : tableDTOS) {
            if (StringUtils.isNotEmpty(it.getComment())) {
                stringBuilder.append("UPDATE oms_order_3.jiupiorderitem set SkuRef_Id =")
                        .append(it.getComment())
                        .append(" where Id = ").append(it.getTitle()).append(";");
                count++;
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println(count);
    }


    @PostMapping("/import/parse2")
    public void parse2(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        List<TextDTO> tableDTOS = ExcelUtils.readExcelToEntity(TextDTO.class, file.getInputStream(), file.getOriginalFilename());
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        stringBuilder.append("SELECT * FROM oms_order_3.jiupiorderitem  t where t.Id in (");
        for (TextDTO it : tableDTOS) {
            if (StringUtils.isNotEmpty(it.getComment())) {
                stringBuilder.append(it.getTitle()).append(",");
                count++;
            }
        }
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
        System.out.println(count);
    }


    @PostMapping("/import/parseErp")
    public void parseErp(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        List<ErpProductSecDTO> result = new ArrayList<>();
        List<ErpProductSecDTO> list = ExcelUtils.readExcelToEntity(ErpProductSecDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}", JSON.toJSONString(list));
        List<ErpProductSecDTO> pageList = list.stream().filter(it -> it.getType() != null).collect(Collectors.toList());
        logger.info("解析数据：{}", JSON.toJSONString(pageList));
        Map<String, List<ErpProductSecDTO>> collect = pageList.stream().collect(Collectors.groupingBy(it -> it.getStorehouseId() + "_" + it.getDesc_ProductName()));
        for (List<ErpProductSecDTO> dtos : collect.values()) {
            BigDecimal outCount = dtos.stream().filter(it -> it.getType().equals(1)).map(it -> it.getTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inCount = dtos.stream().filter(it -> it.getType().equals(2)).map(it -> it.getTotalCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            ErpProductSecDTO erpProductSecDTO = new ErpProductSecDTO();
            BeanUtils.copyProperties(dtos.get(0), erpProductSecDTO);
            erpProductSecDTO.setOutTotalCount(outCount);
            erpProductSecDTO.setInTotalCount(inCount);
            erpProductSecDTO.setCalCount(outCount.subtract(inCount));
            result.add(erpProductSecDTO);
        }
        System.out.println("结果:" + JSON.toJSONString(result));

//        List<ErpProductSecDTO> erpProductSecDTOS = result.stream().filter(it -> it.getStorehouseId().equals(1031)).collect(Collectors.toList());
//
//        System.out.println("erp产品统计："+JSON.toJSONString(erpProductSecDTOS));

        Map<Integer, List<ErpProductSecDTO>> erpWarehouseMap = result.stream().collect(Collectors.groupingBy(it -> it.getStorehouseId()));

        Map<String, List<CheckDTO>> map = new HashMap<>();
        for (List<ErpProductSecDTO> erpProductSecDTOS : erpWarehouseMap.values()) {
            Integer cityid = erpProductSecDTOS.get(0).getCityid();
            Integer storehouseId = erpProductSecDTOS.get(0).getStorehouseId();
            erpProductSecDTOS = erpProductSecDTOS.stream().sorted(Comparator.comparing(it -> it.getDesc_ProductName())).collect(Collectors.toList());
            List<GroupSettleOrderBillDTO> wmsProducts = finderrorbygroubill.allSearch(cityid, storehouseId);
            List<CheckDTO> checkDTOS = checkDiff(erpProductSecDTOS, wmsProducts);
//            System.out.println("差异数据："+JSON.toJSONString(checkDTOS));
            if (CollectionUtils.isNotEmpty(checkDTOS)) {
                map.put(storehouseId.toString(), checkDTOS);
            }
        }

        System.out.println("差异数据：" + JSON.toJSONString(map));

    }

    public List<CheckDTO> checkDiff(List<ErpProductSecDTO> erpProductSecDTOS, List<GroupSettleOrderBillDTO> wmsProducts) {
        Map<String, GroupSettleOrderBillDTO> wmsproductMap = wmsProducts.stream().collect(Collectors.toMap(it -> it.getSkuName(), it -> it, (v1, v2) -> v1));
        Map<String, ErpProductSecDTO> erpproductMap = erpProductSecDTOS.stream().collect(Collectors.toMap(it -> it.getDesc_ProductName(), it -> it, (v1, v2) -> v1));

        List<CheckDTO> result = new ArrayList<>();
        for (ErpProductSecDTO erpProduct : erpProductSecDTOS) {

            GroupSettleOrderBillDTO orderBillDTO = wmsproductMap.get(erpProduct.getDesc_ProductName());
            if (orderBillDTO == null) {
                CheckDTO checkDTO = new CheckDTO();
                checkDTO.setErpProduct(erpProduct);
                checkDTO.setWmsProduct(orderBillDTO);
                result.add(checkDTO);
                continue;
            }

            if (orderBillDTO.getCalCount().compareTo(erpProduct.getCalCount().setScale(6, BigDecimal.ROUND_HALF_UP)) != 0) {
                CheckDTO checkDTO = new CheckDTO();
                checkDTO.setErpProduct(erpProduct);
                checkDTO.setWmsProduct(orderBillDTO);
                result.add(checkDTO);
            }
        }
        for (GroupSettleOrderBillDTO wmsProduct : wmsProducts) {
            if (erpproductMap.get(wmsProduct.getSkuName()) == null) {
                CheckDTO checkDTO = new CheckDTO();
                checkDTO.setWmsProduct(wmsProduct);
                result.add(checkDTO);
            }
        }
        return result;

    }


    @PostMapping("/import/erpWmsCheck")
    public void erpWmsCheck(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        List<ErpCheckWmsDTO> result = new ArrayList<>();
        List<ErpCheckWmsDTO> list = ExcelUtils.readExcelToEntity(ErpCheckWmsDTO.class, file.getInputStream(), file.getOriginalFilename());
        System.out.println(JSON.toJSONString(list));
        list.forEach(it->{
            if(StringUtils.isEmpty(it.getSecOwnerName())){
                it.setSecOwnerName("null");
            }
        });
        List<ErpCheckWmsDTO> collect = list.stream().filter(it -> it.getSecCount() == null).collect(Collectors.toList());
        System.out.println("数量为null:"+JSON.toJSONString(collect));
        List<ErpCheckWmsDTO> erpOut = list.stream().filter(it -> StringUtils.isNotEmpty(it.getType())&&it.getType().equals("ERP其他出")).collect(Collectors.toList());
        List<ErpCheckWmsDTO> erpIn = list.stream().filter(it -> StringUtils.isNotEmpty(it.getType())&&it.getType().equals("ERP其他入")).collect(Collectors.toList());
        List<ErpCheckWmsDTO> wmsIn = list.stream().filter(it -> StringUtils.isNotEmpty(it.getType())&&it.getType().equals("WMS其他入")).collect(Collectors.toList());
        List<ErpCheckWmsDTO> wmsOut = list.stream().filter(it -> StringUtils.isNotEmpty(it.getType())&&it.getType().equals("WMS其他出")).collect(Collectors.toList());


        Map<String, List<ErpCheckWmsDTO>> erpInMap = erpIn.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getProductName()+"_"+it.getSecCount()));
        Map<String, List<ErpCheckWmsDTO>> wmsInMap = wmsIn.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getProductName()+"_"+it.getSecCount()));
//        getDiff(erpInMap,wmsInMap);

        Map<String, List<ErpCheckWmsDTO>> erpOutMap = erpOut.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getProductName()+"_"+it.getSecCount()));
        Map<String, List<ErpCheckWmsDTO>> wmsOutMap = wmsOut.stream().collect(Collectors.groupingBy(it -> it.getWarehouseId() + "_" + it.getProductName()+"_"+it.getSecCount()));
        getDiff(erpOutMap,wmsOutMap);

    }

    public List<ErpCheckWmsDetailDTO> getDiff(Map<String, List<ErpCheckWmsDTO>> erpMap, Map<String, List<ErpCheckWmsDTO>> wmsMap) {
        List<ErpCheckWmsDetailDTO> errorList = new ArrayList<>();
        for (Map.Entry<String, List<ErpCheckWmsDTO>> wmsEntry : wmsMap.entrySet()) {

            List<ErpCheckWmsDTO> wmsDTOS = wmsEntry.getValue();
            String key = wmsEntry.getKey();
            List<ErpCheckWmsDTO> erpDTOs = erpMap.get(key);
            if (CollectionUtils.isEmpty(erpDTOs)) {
                ErpCheckWmsDetailDTO detailDTO = new ErpCheckWmsDetailDTO();
                detailDTO.setKey(key);
                detailDTO.setWmsList(wmsDTOS);
                errorList.add(detailDTO);
                continue;
            }

            List<String> erpOwnerNameList = erpDTOs.stream().map(it -> it.getSecOwnerName()).collect(Collectors.toList());
            ErpCheckWmsDTO find = wmsDTOS.stream()
                        .filter(it -> !erpOwnerNameList.contains(it.getSecOwnerName()))
                        .findFirst().orElse(null);
            if(find!=null){
                ErpCheckWmsDetailDTO detailDTO = new ErpCheckWmsDetailDTO();
                detailDTO.setKey(key);
                detailDTO.setWmsList(wmsDTOS);
                detailDTO.setErpList(erpDTOs);
                errorList.add(detailDTO);
            }
        }
        List<ErpCheckWmsDetailDTO> collect = errorList.stream()
                .filter(it -> CollectionUtils.isNotEmpty(it.getErpList()) && it.getWmsList().size() == it.getErpList().size())
                .collect(Collectors.toList());
//        System.out.println("异常2:" + JSON.toJSONString(errorList));
        System.out.println("异常1:" + JSON.toJSONString(collect));

        List<ErpResultDTO> result =new ArrayList<>();
        for (ErpCheckWmsDetailDTO detailDTO : collect) {
            List<ErpCheckWmsDTO> wmsLists = detailDTO.getWmsList();
            for (int i = 0; i < wmsLists.size(); i++) {
                ErpCheckWmsDTO erpList = detailDTO.getErpList().get(i);
                ErpCheckWmsDTO wmsList = detailDTO.getWmsList().get(i);
                ErpResultDTO erpResultDTO = new ErpResultDTO();
                erpResultDTO.setErpNo(erpList.getBusinessNo());
                erpResultDTO.setWmsNo(wmsList.getBusinessNo());
                erpResultDTO.setSkuId(wmsList.getSkuId());
                erpResultDTO.setSkuName(wmsList.getProductName());
                erpResultDTO.setTrueWmsSecOwnerId(wmsList.getWmsSecOwnerId());
                erpResultDTO.setTrueErpSecOwnerId(wmsList.getErpSecOwnerId());
                erpResultDTO.setFalseWmsSecOwnerId(erpList.getWmsSecOwnerId());
                erpResultDTO.setFalseErpSecOwnerId(erpList.getErpSecOwnerId());
                erpResultDTO.setSecCount(wmsList.getSecCount());
                erpResultDTO.setWarehouseId(erpList.getWarehouseId());
                erpResultDTO.setWarehouseName(erpList.getWarehouseName());
                erpResultDTO.setFalseSecOwnerName(erpList.getSecOwnerName());
                erpResultDTO.setTrueSecOwnerName(wmsList.getSecOwnerName());
                result.add(erpResultDTO);

            }


        }

        result = result.stream().sorted(Comparator.comparing(ErpResultDTO::getWarehouseId).thenComparing(ErpResultDTO::getSkuId)).collect(Collectors.toList());
        System.out.println("异常产品："+JSON.toJSONString(result));

        return errorList;
    }


}
