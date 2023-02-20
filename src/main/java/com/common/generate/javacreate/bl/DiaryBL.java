package com.common.generate.javacreate.bl;

import com.common.generate.javacreate.dao.DiaryMapper;
import com.common.generate.javacreate.model.DiaryDTO;
import com.common.generate.javacreate.model.DiaryQueryDTO;
import com.common.generate.javacreate.model.base.PageableResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * 日记
 *
 * @author xialei
 * @date 2022-08-12
 */
@Service
public class DiaryBL {

    @Autowired
    private DiaryMapper diaryMapper;

    public static void main(String[] args){
        String str =  String.valueOf(10);
        String first3char = str.substring(0,3);
        System.out.println(first3char);
    }

    public DiaryDTO getById(Long id) {
        return diaryMapper.selectByPrimaryKey(id);
    }

    public PageableResult<DiaryDTO> findPageByCondition(DiaryQueryDTO queryDTO) {
        /**设置分页信息*/
        PageMethod.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        Page<DiaryDTO> pageResult = diaryMapper.findPageByCondition(queryDTO);
        /**分页数据*/
        PageableResult<DiaryDTO> result = new PageableResult<>();
        result.setCurrentPage(pageResult.getPageNum());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalPage(pageResult.getPages());
        result.setRecordCount(Math.toIntExact(pageResult.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getResult())) {
            result.setDatas(Collections.emptyList());
            return result;
        }
        result.setDatas(pageResult.getResult());
        return result;
    }

    public List<DiaryDTO> findByCondition(DiaryQueryDTO diary) {
        List<DiaryDTO> list = diaryMapper.findByCondition(diary);
        return list;
    }

    public void insert(DiaryDTO diary) {
        diaryMapper.insert(diary);
    }

    public void insertBatch(List<DiaryDTO> diarys) {
        diaryMapper.insertBatch(diarys);
    }

    public void updateByPrimaryKeySelective(DiaryDTO diary) {
        diaryMapper.updateByPrimaryKeySelective(diary);
    }

    public void deleteByPrimaryKey(Long id) {
        diaryMapper.deleteByPrimaryKey(id);
    }

}
