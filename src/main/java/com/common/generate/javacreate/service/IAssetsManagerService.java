package com.common.generate.javacreate.service;


import com.common.generate.javacreate.domain.AssetsManager;

import java.util.List;

/**
 * @author xialei
 * @date  2020-05-15
 */
public interface IAssetsManagerService {

     AssetsManager detail(String id);

     List<AssetsManager> list(AssetsManager assetsManager);

     void insert(AssetsManager assetsManager);

     void insertBatch(List<AssetsManager> assetsManagers);

     void update(AssetsManager assetsManager);

     void delete(AssetsManager assetsManager);

}
