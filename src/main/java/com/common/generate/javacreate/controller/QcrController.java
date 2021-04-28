package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.BaiduOrcResultDTO;
import com.common.generate.javacreate.model.SummariseDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.utils.AssertUtils;
import com.common.generate.javacreate.utils.BaiduBodyUtil;
import com.common.generate.javacreate.utils.BaiduFaceUtil;
import com.common.generate.javacreate.utils.BaiduImageClassUtil;
import com.common.generate.javacreate.utils.BaiduImageSearchUtil;
import com.common.generate.javacreate.utils.BaiduOrcUtil;
import com.common.generate.javacreate.utils.SimpleSummariserAlgorithmUtil;
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
@IgnoreAuthInterceptor
public class QcrController {

    @PostMapping("/text/textRecognition")
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
        return RetResponse.makeOKRsp(SimpleSummariserAlgorithmUtil.summarise(summariseDTO.getText(), summariseDTO.getNumSentences()));
    }


    @PostMapping("/body/bodyAnalysis")
    @IgnoreAuthInterceptor
    public Result<String> bodyAnalysis(@RequestParam("file") MultipartFile file){
        if (null == file) {
            throw new BusinessValidateException("上传失败，无法找到文件！");
        }
        return RetResponse.makeOKRsp(BaiduBodyUtil.bodyAnalysis(file));
    }

    @PostMapping("/body/bodyAttr")
    @IgnoreAuthInterceptor
    public Result<String> bodyAttr(@RequestParam("file") MultipartFile file){
        if (null == file) {
            throw new BusinessValidateException("上传失败，无法找到文件！");
        }
        return RetResponse.makeOKRsp(BaiduBodyUtil.bodyAttr(file));
    }

    @PostMapping("/body/bodyNum")
    public Result<String> bodyNum(@RequestParam("file") MultipartFile file){
        if (null == file) {
            throw new BusinessValidateException("上传失败，无法找到文件！");
        }
        return RetResponse.makeOKRsp(BaiduBodyUtil.bodyNum(file));
    }

    @PostMapping("/image/advancedGeneral")
    public Result<String> advancedGeneral(@RequestParam("file") MultipartFile file){
        if (null == file) {
            throw new BusinessValidateException("上传失败，无法找到文件！");
        }
        return RetResponse.makeOKRsp(BaiduImageClassUtil.advancedGeneral(file));
    }

    @PostMapping("/image/sameHqSearch")
    public Result<String> sameHqSearch(@RequestParam("file") MultipartFile file){
        if (null == file) {
            throw new BusinessValidateException("上传失败，无法找到文件！");
        }
        return RetResponse.makeOKRsp(BaiduImageSearchUtil.sameHqSearch(file));
    }


    @PostMapping("/image/detect")
    public Result<String> detect(@RequestParam("file") MultipartFile file){
        if (null == file) {
            throw new BusinessValidateException("上传失败，无法找到文件！");
        }
        return RetResponse.makeOKRsp(BaiduFaceUtil.detect(file));
    }
}
