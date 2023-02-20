package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;

import com.common.generate.javacreate.model.DiaryDTO;
import com.common.generate.javacreate.model.DiaryQueryDTO;
import com.common.generate.javacreate.model.base.PageableResult;
import com.common.generate.javacreate.service.DiaryService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 日记
 * @author xialei
 * @date  2022-08-12
 */
@RestController
public class DiaryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiaryController.class);

    @Autowired
    private DiaryService diaryService;

    @PostMapping("/diary/pageList")
    public PageableResult<DiaryDTO> findPageByCondition(@RequestBody DiaryQueryDTO diary) {
        LOGGER.info("查询参数：{}", JSON.toJSONString(diary));
        PageableResult<DiaryDTO> diarys = diaryService.findPageByCondition(diary);
        return diarys;
    }

    @GetMapping("/diary/detail")
    public DiaryDTO getById(@RequestParam Long id) {
        DiaryDTO diary = diaryService.getById(id);
        return diary;
    }

    @PostMapping("/diary/insert")
    public Boolean insert(@RequestBody DiaryDTO diary) {
        LOGGER.info("新增参数：{}", JSON.toJSONString(diary));
        diaryService.insert(diary);
        return true;
    }

    @PostMapping("/diary/diary/insertBatch")
    public Boolean insertBatch(@RequestBody List<DiaryDTO> diarys) {
        LOGGER.info("批量新增：{}", JSON.toJSONString(diarys));

        diaryService.insertBatch(diarys);
        return true;
    }

    @PostMapping("/diary/update")
    public Boolean update(@RequestBody DiaryDTO diary) {
        LOGGER.info("修改：{}", JSON.toJSONString(diary));
        diaryService.update(diary);
        return true;
    }

    @PostMapping("/diary/delete")
    public Boolean delete(@RequestBody Long id) {
        LOGGER.info("删除：{}", JSON.toJSONString(id));
        diaryService.delete(id);
        return true;
    }

}
