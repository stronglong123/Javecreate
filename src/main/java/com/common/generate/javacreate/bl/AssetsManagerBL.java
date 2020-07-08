package com.common.generate.javacreate.bl;


import com.common.generate.javacreate.dao.AssetsManagerMapper;
import com.common.generate.javacreate.domain.AssetsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xialei
 * @date  2020-05-15
 */
@Service
public class AssetsManagerBL {
    @Autowired
    private AssetsManagerMapper assetsManagerMapper;
    
    public AssetsManager detail(String id){
        return assetsManagerMapper.detail(id);
    }
    
    public List<AssetsManager> list(AssetsManager assetsManager) {
        return assetsManagerMapper.list(assetsManager);
    }
    
    public void insert(AssetsManager assetsManager) {
        assetsManagerMapper.insert(assetsManager);
    }
    
    public void insertBatch(List<AssetsManager> assetsManagers){
        assetsManagerMapper.insertBatch(assetsManagers);
    }
    
    public void update(AssetsManager assetsManager) {
        assetsManagerMapper.update(assetsManager);
    }
    
    public void delete(AssetsManager assetsManager) {
        assetsManagerMapper.delete(assetsManager);
    }

}
