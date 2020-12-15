package com.common.generate.javacreate.service;

import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-10
 */
public interface IDictionaryService {

     DictionaryDTO detail(Long id);

     PageList<DictionaryDTO> pageList(DictionaryQueryDTO dictionary);

     List<DictionaryDTO> list(DictionaryQueryDTO dictionary);


     void insert(DictionaryDTO dictionary);

     void insertBatch(List<DictionaryDTO> dictionarys);

     void update(DictionaryDTO dictionary);

     void delete(Long id);

}
