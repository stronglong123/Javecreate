package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.bl.DictionaryBL;
import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-10
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    private DictionaryBL dictionaryBl;
    
    @Override
    public DictionaryDTO detail(Long id){
        return dictionaryBl.selectByPrimaryKey(id);
    }
    
    @Override
    public PageList<DictionaryDTO> pageList(DictionaryQueryDTO dictionary) {
        return dictionaryBl.pageList(dictionary);
    }

    
    @Override
    public List<DictionaryDTO> list(DictionaryQueryDTO dictionary) {
        return dictionaryBl.list(dictionary);
    }

    
    @Override
    public void insert(DictionaryDTO dictionary) {
        dictionaryBl.insert(dictionary);
    }
    
    @Override
    public void insertBatch(List<DictionaryDTO> dictionarys){
        dictionaryBl.insertBatch(dictionarys);
    }
    
    @Override
    public void update(DictionaryDTO dictionary) {
        dictionaryBl.updateByPrimaryKeySelective(dictionary);
    }
    
    @Override
    public void delete(Long id) {
        dictionaryBl.deleteByPrimaryKey(id);
    }

}
