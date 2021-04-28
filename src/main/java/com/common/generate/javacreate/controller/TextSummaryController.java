package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.BaiduOrcResultDTO;
import com.common.generate.javacreate.model.SummariseDTO;
import com.common.generate.javacreate.model.TextSummaryDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.utils.AssertUtils;
import com.common.generate.javacreate.utils.BaiduOrcUtil;
import com.common.generate.javacreate.utils.NewsSummaryUtil;
import com.common.generate.javacreate.utils.SimpleSummariserAlgorithmUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xialei
 * @date 2021/1/16 16:42
 */


@RestController
public class TextSummaryController {

    @Autowired
    private NewsSummaryUtil newsSummaryUtil;

    @PostMapping("/summary/textSummary")
    @IgnoreAuthInterceptor
    public Result<String> uploadProductInfo(@RequestBody TextSummaryDTO dto) {
        AssertUtils.notNull(dto.getText(),"文本不能为空");
        String result ="";
        if (dto.getType() == null || dto.getType() == 1) {
            result = SimpleSummariserAlgorithmUtil.summarise(dto.getText(), dto.getNumSentences() == null ? 5 : dto.getNumSentences());
        } else if (dto.getType() == 2) {
            result = newsSummaryUtil.SummaryMeanstdTxt(dto.getText());
        } else if (dto.getType() == 3) {
            result = newsSummaryUtil.SummaryMMRNTxt(dto.getText());
        } else if (dto.getType() == 4) {
            result = newsSummaryUtil.SummaryTopNTxt(dto.getText());
        }
        return RetResponse.makeOKRsp(result);
    }
}
