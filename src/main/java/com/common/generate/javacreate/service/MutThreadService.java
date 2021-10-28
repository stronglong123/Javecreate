package com.common.generate.javacreate.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author xialei
 * @date 2021/4/26 11:54
 */
@Service
public class MutThreadService {
    private static final int NTHREADS=100;

    //固定大小的线程池
    private static final Executor exec= Executors.newFixedThreadPool(NTHREADS);
}
