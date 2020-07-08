package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.domain.AssetsManager;
import com.common.generate.javacreate.service.IAssetsManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xialei
 * @date  2020-05-15
 */
@RestController
@RequestMapping(value = "/assetsManager")
public class AssetsManagerController {
    @Autowired
    private IAssetsManagerService assetsManagerService;

    @PostMapping("/list")
    public Object list(@RequestBody AssetsManager assetsManager) {
        List<AssetsManager> assetsManagers = assetsManagerService.list(assetsManager);
        return assetsManagers;
    }

    @GetMapping("/detail")
    public Object detail(@RequestParam String id) {
        AssetsManager assetsManager = assetsManagerService.detail(id);
        return assetsManager;
    }

    @PostMapping("/insert")
    public Boolean insert(@RequestBody AssetsManager assetsManager) {
        assetsManagerService.insert(assetsManager);
        return true;
    }

    @PostMapping("/insertBatch")
    public Boolean insertBatch(@RequestBody List<AssetsManager> assetsManagers) {
        assetsManagerService.insertBatch(assetsManagers);
        return true;
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody AssetsManager assetsManager) {
        assetsManagerService.update(assetsManager);
        return true;
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody AssetsManager assetsManager) {
        assetsManagerService.delete(assetsManager);
        return true;
    }

}
