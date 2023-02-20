package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.utils.UUIDUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xialei
 * @date 2022/4/27 15:30
 */
public class test01 {


    private static ExecutorService executorService = Executors.newFixedThreadPool(20);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("开始");
        long beginTime = System.currentTimeMillis();
        List<Future<String>> futureList =new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<String> future = executorService.submit(() -> {
                try {
                    Thread.sleep( 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return UUIDUtil.randonUUID();
            });
            futureList.add(future);
        }


        List<String> result =new ArrayList<>();
        for (Future<String> stringFuture : futureList) {
            result.add(stringFuture.get());
        }

        System.out.println(JSON.toJSONString(result));
        System.out.println("结束，耗时：" + (System.currentTimeMillis() - beginTime));
        executorService.shutdown();
    }
}
