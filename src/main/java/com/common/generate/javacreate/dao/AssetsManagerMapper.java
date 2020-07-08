package com.common.generate.javacreate.dao;


import com.common.generate.javacreate.domain.AssetsManager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xialei
 * @date  2020-05-15
 */
public interface AssetsManagerMapper {

     AssetsManager detail(String id);

     List<AssetsManager> list(AssetsManager assetsManager);

     int insert(AssetsManager assetsManager);

     int insertBatch(List<AssetsManager> assetsManagers);

     int update(AssetsManager assetsManager);

     int delete(AssetsManager assetsManager);

}