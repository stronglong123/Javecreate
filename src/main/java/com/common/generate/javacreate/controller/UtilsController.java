package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.ReplaceDTO;
import com.common.generate.javacreate.model.ReplaceParamsDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.utils.AssertUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工具类
 * @author xialei
 * @date 2020/11/16 14:05
 */

@RestController
public class UtilsController {

    private static final Logger logger = LoggerFactory.getLogger(UtilsController.class);

    @PostMapping("/util/multipleReplace")
    @IgnoreAuthInterceptor
    public Result<String> uploadProductInfo(@RequestBody ReplaceDTO replaceDTO) {
        logger.info("接口参数：{}", JSON.toJSONString(replaceDTO));
        AssertUtils.notEmpty(replaceDTO.getReplaceList(),"替换参数不能为空");
        AssertUtils.notNull(replaceDTO.getData(),"原文本不能为空");
        String data = replaceDTO.getData();
        for (ReplaceParamsDTO paramsDTO : replaceDTO.getReplaceList()) {
            data = data.replaceAll(paramsDTO.getOldParam(), StringUtils.isEmpty(paramsDTO.getNewParam())?"":paramsDTO.getNewParam());
        }
        return RetResponse.makeOKRsp(data);
    }



}
