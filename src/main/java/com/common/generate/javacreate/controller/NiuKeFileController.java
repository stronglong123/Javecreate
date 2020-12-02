package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.FileDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.service.impl.NiuKeService;
import com.common.generate.javacreate.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xialei
 * @date 2020/12/1 11:49
 */

@RestController
public class NiuKeFileController {

    @Autowired
    private NiuKeService fileService;

    @IgnoreAuthInterceptor
    @PostMapping("/niuke/getFileByName")
    public Result<Boolean> getFileByName(@RequestBody FileDTO fileDTO) {
        AssertUtils.notNull(fileDTO.getSourceFileName(),"源文件名不能为空");
        fileService.getFileByName(fileDTO.getSourceFileName());
        return RetResponse.makeOKRsp();
    }


}
