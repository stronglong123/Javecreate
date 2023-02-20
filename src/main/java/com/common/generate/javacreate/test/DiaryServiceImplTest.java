package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.DiaryDTO;
import com.common.generate.javacreate.model.DiaryQueryDTO;
import com.common.generate.javacreate.model.base.PageableResult;
import com.common.generate.javacreate.service.impl.DiaryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 日记
 * @author xialei
 * @date  2022-08-12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DiaryServiceImplTest {
    @Autowired
    private DiaryServiceImpl diaryService;

    
    @Test
    public void detail(){
        DiaryDTO byId = diaryService.getById(1L);
        System.out.println(JSON.toJSONString(byId));
    }
    
    @Test
    public void findPageByCondition() {
        DiaryQueryDTO diary = new DiaryQueryDTO();
        PageableResult<DiaryDTO> pageByCondition = diaryService.findPageByCondition(diary);
        System.out.println(JSON.toJSONString(pageByCondition));
    }

    
    @Test
    public void insert() {
        DiaryDTO diary = new DiaryDTO();
        diaryService.insert(diary);
    }
    
    @Test
    public void insertBatch(){
        List<DiaryDTO> diarys = new ArrayList();
        diaryService.insertBatch(diarys);
    }
    
    @Test
    public void update() {
        DiaryDTO diary = new DiaryDTO();
        diaryService.update(diary);
    }
    
    @Test
    public void delete() {
        diaryService.delete(1L);
    }

}
