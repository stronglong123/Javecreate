package com.common.generate.javacreate.bl;

import com.common.generate.javacreate.dao.DictionaryMapper;
import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-10
 */
@Service
public class DictionaryBL {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    
    public DictionaryDTO selectByPrimaryKey(Long id){
        return dictionaryMapper.selectByPrimaryKey(id);
    }
    
    public PageList<DictionaryDTO> pageList(DictionaryQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<DictionaryDTO> list = dictionaryMapper.pageList(queryDTO);
        return new PageList<>(list);
    }
    
    public List<DictionaryDTO> list(DictionaryQueryDTO dictionary) {
        List<DictionaryDTO> list = dictionaryMapper.list(dictionary);
        return list;
    }
    
    public void insert(DictionaryDTO dictionary) {
        dictionaryMapper.insert(dictionary);
    }
    
    public void insertBatch(List<DictionaryDTO> dictionarys){
        dictionaryMapper.insertBatch(dictionarys);
    }
    
    public void updateByPrimaryKeySelective(DictionaryDTO dictionary) {
        dictionaryMapper.updateByPrimaryKeySelective(dictionary);
    }
    
    public void deleteByPrimaryKey(Long id) {
        dictionaryMapper.deleteByPrimaryKey(id);
    }

}
