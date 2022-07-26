package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.ReplaceDTO;
import com.common.generate.javacreate.model.ReplaceParamsDTO;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.utils.AssertUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 工具类
 * @author xialei
 * @date 2020/11/16 14:05
 */

@RestController
public class UtilsController {


    private static final Logger logger = LoggerFactory.getLogger(UtilsController.class);

    @PostMapping("/util/multipleReplace")
    @IgnoreAuthInterceptor
    public Result<String> uploadProductInfo(@RequestBody ReplaceDTO replaceDTO) {
        logger.info("接口参数：{}", JSON.toJSONString(replaceDTO));
        AssertUtils.notEmpty(replaceDTO.getReplaceList(),"替换参数不能为空");
        AssertUtils.notNull(replaceDTO.getData(),"原文本不能为空");
        String data = replaceDTO.getData();
        for (ReplaceParamsDTO paramsDTO : replaceDTO.getReplaceList()) {
            data = data.replaceAll(paramsDTO.getOldParam(), StringUtils.isEmpty(paramsDTO.getNewParam())?"":paramsDTO.getNewParam());
        }
        return RetResponse.makeOKRsp(data);
    }

    @GetMapping("/util/jmeter")
    public Result<String> jmeter() {
        Long begin = System.currentTimeMillis();
        ReentrantLock lock = new ReentrantLock();
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        try {
            lock.lock();
            // 休眠100毫秒
            TimeUnit.MILLISECONDS.sleep(100);
            // 查询操作
            logger.error(Thread.currentThread().getName());
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {

            lock.unlock();
        }
        Long end = System.currentTimeMillis();
        if (end - begin > 200) {
            throw new RuntimeException("接口超时抛出异常");
        }
        return RetResponse.makeOKRsp("true");
    }






}
