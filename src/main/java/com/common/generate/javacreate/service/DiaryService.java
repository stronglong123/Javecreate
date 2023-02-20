package com.common.generate.javacreate.service;

import com.common.generate.javacreate.model.DiaryDTO;
import com.common.generate.javacreate.model.DiaryQueryDTO;
import com.common.generate.javacreate.model.base.PageableResult;

import java.util.List;

/**
 * 日记
 * @author xialei
 * @date  2022-08-12
 */
public interface DiaryService {
    /**
    * 获取详情
    * @param id 主键id
    * @return 查询结果
    */
     DiaryDTO getById(Long id);

    /**
    * 分页查询
    * @param diary 查询参数
    * @return 查询结果
    */
     PageableResult<DiaryDTO> findPageByCondition(DiaryQueryDTO diary);

    /**
    * 条件查询
    * @param diary 查询参数
    * @return 查询结果
    */
     List<DiaryDTO> findByCondition(DiaryQueryDTO diary);


    /**
    * 新增
    * @param diary  新增参数
    */
     void insert(DiaryDTO diary);

    /**
    * 批量新增
    * @param diarys 新增参数
    */
     void insertBatch(List<DiaryDTO> diarys);

    /**
    * 修改
    * @param diary 修改参数
    */
     void update(DiaryDTO diary);

    /**
    * 删除
    * @param id 主键id
    */
     void delete(Long id);

}
