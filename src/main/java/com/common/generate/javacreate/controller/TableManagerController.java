package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.TableDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.service.ITableCreateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xialei
 * @date 2020/5/15 14:57
 */

@RestController
public class TableManagerController {
    private static final Logger logger = LoggerFactory.getLogger(TableManagerController.class);

    @Autowired
    private ITableCreateService iTableCreateService;

    @PostMapping("/tableManager/createTable")
    public Result<List<String>> uploadProductInfo(@RequestBody List<TableDTO> tableDTOS) {
        logger.info("创建表参数：{}", JSON.toJSONString(tableDTOS));
        return RetResponse.makeOKRsp(iTableCreateService.createTableInfo(tableDTOS));
    }
}
