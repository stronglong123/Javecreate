package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.bl.AssetsManagerBL;
import com.common.generate.javacreate.domain.AssetsManager;
import com.common.generate.javacreate.service.IAssetsManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xialei
 * @date  2020-05-15
 */
@Service
public class AssetsManagerServiceImpl implements IAssetsManagerService {
    @Autowired
    private AssetsManagerBL assetsManagerBl;
    
    @Override
    public AssetsManager detail(String id){
        return assetsManagerBl.detail(id);
    }
    
    @Override
    public List<AssetsManager> list(AssetsManager assetsManager) {
        return assetsManagerBl.list(assetsManager);
    }
    
    @Override
    public void insert(AssetsManager assetsManager) {
        assetsManagerBl.insert(assetsManager);
    }
    
    @Override
    public void insertBatch(List<AssetsManager> assetsManagers){
        assetsManagerBl.insertBatch(assetsManagers);
    }
    
    @Override
    public void update(AssetsManager assetsManager) {
        assetsManagerBl.update(assetsManager);
    }
    
    @Override
    public void delete(AssetsManager assetsManager) {
        assetsManagerBl.delete(assetsManager);
    }

}
