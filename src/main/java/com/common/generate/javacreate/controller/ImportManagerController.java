package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.TableDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.service.ITableCreateService;
import com.common.generate.javacreate.utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
}
