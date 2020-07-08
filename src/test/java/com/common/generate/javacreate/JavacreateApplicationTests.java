package com.common.generate.javacreate;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.bl.AssetsManagerBL;
import com.common.generate.javacreate.domain.AssetsManager;
import com.common.generate.javacreate.service.IAssetsManagerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavacreateApplication.class)
class JavacreateApplicationTests {

    @Autowired
    private IAssetsManagerService assetsManagerService;

    @Autowired
    private AssetsManagerBL assetsManagerBL;

    @Test
    void List() {
        AssetsManager assetsManager = new AssetsManager();
        List<AssetsManager> list =assetsManagerBL.list(assetsManager);
        System.out.println(JSON.toJSONString(list));
    }

}
