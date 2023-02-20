package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.bl.DiaryBL;
import com.common.generate.javacreate.model.DiaryDTO;
import com.common.generate.javacreate.model.DiaryQueryDTO;
import com.common.generate.javacreate.model.base.PageableResult;
import com.common.generate.javacreate.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日记
 * @author xialei
 * @date  2022-08-12
 */
@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryBL diaryBl;
    
    @Override
    public DiaryDTO getById(Long id){
        return diaryBl.getById(id);
    }
    
    @Override
    public PageableResult<DiaryDTO> findPageByCondition(DiaryQueryDTO diary) {
        return diaryBl.findPageByCondition(diary);
    }

    
    @Override
    public List<DiaryDTO> findByCondition(DiaryQueryDTO diary) {
        return diaryBl.findByCondition(diary);
    }

    
    @Override
    public void insert(DiaryDTO diary) {
        diaryBl.insert(diary);
    }
    
    @Override
    public void insertBatch(List<DiaryDTO> diarys){
        diaryBl.insertBatch(diarys);
    }
    
    @Override
    public void update(DiaryDTO diary) {
        diaryBl.updateByPrimaryKeySelective(diary);
    }
    
    @Override
    public void delete(Long id) {
        diaryBl.deleteByPrimaryKey(id);
    }

}
