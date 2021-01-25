package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.BaiduOrcResultDTO;
import com.common.generate.javacreate.model.SummariseDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.utils.AssertUtils;
import com.common.generate.javacreate.utils.BaiduOrcUtil;
import com.common.generate.javacreate.utils.SimpleSummariserAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xialei
 * @date 2021/1/16 16:42
 */


@RestController
public class QcrController {

    @PostMapping("/import/textRecognition")
    @IgnoreAuthInterceptor
    public Result<BaiduOrcResultDTO> uploadProductInfo(@RequestParam("file") MultipartFile file) {
        if (null == file) {
            throw new BusinessValidateException("上传失败，无法找到文件！");
        }
        return RetResponse.makeOKRsp(BaiduOrcUtil.baseSample(file));
    }


    @PostMapping("/text/summarise")
    @IgnoreAuthInterceptor
    public Result<String> summarise(@RequestBody SummariseDTO summariseDTO) {
        AssertUtils.notNull(summariseDTO.getText(),"文本不能为空");
        AssertUtils.notNull(summariseDTO.getNumSentences(),"精度不能为空");
        return RetResponse.makeOKRsp(SimpleSummariserAlgorithm.summarise(summariseDTO.getText(), summariseDTO.getNumSentences()));
    }
}
