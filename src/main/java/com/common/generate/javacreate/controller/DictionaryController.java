package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.service.IDictionaryService;
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
public class DictionaryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private IDictionaryService dictionaryService;

    @PostMapping("/dictionary/pageList")
    public PageList<DictionaryDTO> pageList(@RequestBody DictionaryQueryDTO dictionary) {
        LOGGER.info("查询参数：{}", JSON.toJSONString(dictionary));
        return dictionaryService.pageList(dictionary);
    }


    @PostMapping("/dictionary/insert")
    public Boolean insert(@RequestBody DictionaryDTO dictionary) {
        LOGGER.info("新增参数：{}", JSON.toJSONString(dictionary));
        dictionaryService.insert(dictionary);
        return true;
    }

    @PostMapping("/dictionary/insertBatch")
    public Boolean insertBatch(@RequestBody List<DictionaryDTO> dictionarys) {
        LOGGER.info("批量新增：{}", JSON.toJSONString(dictionarys));
        dictionaryService.insertBatch(dictionarys);
        return true;
    }

    @PostMapping("/dictionary/update")
    public Boolean update(@RequestBody DictionaryDTO dictionary) {
        LOGGER.info("修改：{}", JSON.toJSONString(dictionary));
        dictionaryService.update(dictionary);
        return true;
    }

    @PostMapping("/dictionary/delete")
    public Boolean delete(@RequestBody DictionaryDTO dictionary) {
        LOGGER.info("删除：{}", JSON.toJSONString(dictionary));
        dictionaryService.delete(dictionary.getId());
        return true;
    }

}
