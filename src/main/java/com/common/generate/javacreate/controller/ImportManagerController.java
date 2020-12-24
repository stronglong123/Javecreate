package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.authutils.MyBeanUtil;
import com.common.generate.javacreate.model.CategoryDTO;
import com.common.generate.javacreate.model.TableDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.service.ITableCreateService;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.common.generate.javacreate.utils.excel.XlsViewMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2020/5/15 14:57
 */

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
        logger.info("解析数据：{}",JSON.toJSONString(tableDTOS));
        return RetResponse.makeOKRsp(iTableCreateService.createTableInfo(tableDTOS));
    }


    @IgnoreAuthInterceptor
    @PostMapping("/import/importCategory")
    public Result importCategory(@RequestParam("file") MultipartFile file) throws Exception {
        if (null == file) {
            return RetResponse.makeErrRsp(new ArrayList<>(), "上传失败，无法找到文件！");
        }
        List<CategoryDTO> dtos = ExcelUtils.readExcelToEntity(CategoryDTO.class, file.getInputStream(), file.getOriginalFilename());
        logger.info("解析数据：{}",JSON.toJSONString(dtos));

        return RetResponse.makeOKRsp(dtos);
    }

    @PostMapping("/import/test")
    public String test(@RequestParam("file") String file) {
        return "true";
    }

    /**
     * 下载货主批量导入模板
     */
    @GetMapping(value = "/templates/download")
    public String downloadCargoOwner(Model model){
        model.addAttribute("dataList", Collections.emptyList());
        model.addAttribute("Fields", "");
        model.addAttribute("DisplayNames", "货主名称,货主编码,类型:经销商/供应商,联系人,电话");
        model.addAttribute("fileName", "货主批量导入.xls");
        return  XlsViewMap.VIEW_NAME;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<Map> convert2Map(List dtos) {
        List<Map> result = new ArrayList<>();
        dtos.forEach(dto -> result.add(MyBeanUtil.transBean2Map(dto)));
        return result;
    }
}
