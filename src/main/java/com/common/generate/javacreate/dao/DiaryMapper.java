package com.common.generate.javacreate.dao;



import com.common.generate.javacreate.model.DiaryDTO;
import com.common.generate.javacreate.model.DiaryQueryDTO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 日记
 * @author xialei
 * @date  2022-08-12
 */
public interface DiaryMapper {

     DiaryDTO selectByPrimaryKey(Long id);

     Page<DiaryDTO> findPageByCondition(DiaryQueryDTO diary);

     List<DiaryDTO> findByCondition(DiaryQueryDTO diary);

     int insert(DiaryDTO diary);

     int insertBatch(List<DiaryDTO> diarys);

     int updateByPrimaryKeySelective(DiaryDTO diary);

     int deleteByPrimaryKey(Long id);

}