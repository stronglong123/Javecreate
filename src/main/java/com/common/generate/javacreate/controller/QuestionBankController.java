package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;
import com.common.generate.javacreate.model.QuestionBankDTO;
import com.common.generate.javacreate.model.QuestionBankQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.service.IDictionaryService;
import com.common.generate.javacreate.service.IQuestionBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-10
 */
@RestController
public class QuestionBankController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionBankController.class);

    @Autowired
    private IQuestionBankService service;

    @PostMapping("/questionbank/pageList")
    public PageList<QuestionBankDTO> pageList(@RequestBody QuestionBankQueryDTO queryDTO) {
        LOGGER.info("查询参数：{}", JSON.toJSONString(queryDTO));
        return service.pageList(queryDTO);
    }


    @PostMapping("/questionbank/insert")
    public Boolean insert(@RequestBody QuestionBankDTO dto) {
        LOGGER.info("新增参数：{}", JSON.toJSONString(dto));
        service.insert(dto);
        return true;
    }

    @PostMapping("/questionbank/insertBatch")
    public Boolean insertBatch(@RequestBody List<QuestionBankDTO> dtos) {
        LOGGER.info("批量新增：{}", JSON.toJSONString(dtos));
        service.insertBatch(dtos);
        return true;
    }

    @PostMapping("/questionbank/update")
    public Boolean update(@RequestBody QuestionBankDTO dto) {
        LOGGER.info("修改：{}", JSON.toJSONString(dto));
        service.update(dto);
        return true;
    }

    @PostMapping("/questionbank/delete")
    public Boolean delete(@RequestBody QuestionBankDTO dto) {
        LOGGER.info("删除：{}", JSON.toJSONString(dto));
        service.delete(dto);
        return true;
    }

}
