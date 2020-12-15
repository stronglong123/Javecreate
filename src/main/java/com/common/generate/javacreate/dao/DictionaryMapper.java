package com.common.generate.javacreate.dao;

import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-10
 */
public interface DictionaryMapper {

     DictionaryDTO selectByPrimaryKey(Long id);

     List<DictionaryDTO> pageList(DictionaryQueryDTO dictionary);

     List<DictionaryDTO> list(DictionaryQueryDTO dictionary);

     int insert(DictionaryDTO dictionary);

     int insertBatch(List<DictionaryDTO> dictionarys);

     int updateByPrimaryKeySelective(DictionaryDTO dictionary);

     int deleteByPrimaryKey(Long id);

}