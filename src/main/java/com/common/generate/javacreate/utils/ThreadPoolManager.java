package com.common.generate.javacreate.utils;

import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xialei
 * @date 2022/3/22 17:57
 */
public class ThreadPoolManager {

    private final String TAG = this.getClass().getSimpleName();
    private volatile static ThreadPoolManager manager = null;
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();


    public ThreadPoolManager() {
    }

    public static ThreadPoolManager getInstance() {
        if (manager == null) {
            synchronized (ThreadPoolManager.class) {
                if (manager == null){
                    manager = new ThreadPoolManager();
                }
            }
        }
        return manager;
    }

    private static ThreadPoolExecutor threadPoolExecutor = null;
    private static ScheduledExecutorService scheduledExecutorService = null;


    private ThreadPoolExecutor getThreadPoolExecutor() {

        int corePoolSize = 2;//核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
        int maximumPoolSize = 5;//线程池最大能容忍的线程数
        long keepAliveTime = 0L; //线程存货时间
        TimeUnit unit = TimeUnit.MICROSECONDS;//keepAliveTime的时间单位

        if (!isThreadServiceEnable()) {
            threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        return threadPoolExecutor;
    }

    public void addThreadExecutor(Runnable runnable) {
//        if (!isThreadServiceEnable()){
        // submit实际上也是调用execute
        getThreadPoolExecutor().submit(runnable);
//        }
    }

    public void shutDownThreadPool() {
        if (!isThreadServiceEnable()) {
            getThreadPoolExecutor().shutdown();
        }
    }

    public void shutDownNowThreadPool() {
        if (!isThreadServiceEnable()) {
            getThreadPoolExecutor().shutdownNow();
        }
    }

    private boolean isThreadServiceEnable() {
        return !(threadPoolExecutor == null
                || threadPoolExecutor.isShutdown()
                || threadPoolExecutor.isTerminated());
    }

    private static final int SCHE_THREAD_SIZE = 5;

    public ScheduledExecutorService getScheduledExecutorService() {

        if (!isScheduledServiceEnable()) {
            scheduledExecutorService = new ScheduledThreadPoolExecutor(SCHE_THREAD_SIZE);
        }
        return scheduledExecutorService;
    }

    /**
     * @description: 循环执行任务
     * @date: 2018/12/10 15:09
     */
    public ScheduledFuture<?> addScheduledExecutor(TimerTask timerTask, long initialDelay, long period, TimeUnit timeUnit) {
        return getScheduledExecutorService().scheduleAtFixedRate(timerTask, initialDelay, period, timeUnit);
    }

    public ScheduledFuture<?> addDelayScheduledExecutor(Runnable runnable, long delay, TimeUnit timeUnit) {
        return getScheduledExecutorService().schedule(runnable, delay, timeUnit);
    }

    public void shutDownScheduledExecutor() {
        if (!isScheduledServiceEnable()) {
            //     先前提交的任务将会被工作线程执行，新的线程将会被拒绝。这个方法
            //     不会等待提交的任务执行完，我们可以用awaitTermination来等待任务执行完。
            getScheduledExecutorService().shutdown();
        }
    }

    public void shutDownNowScheduledExecutor() {
        if (!isScheduledServiceEnable()) {
            getScheduledExecutorService().shutdownNow();
        }
    }

    private boolean isScheduledServiceEnable() {
        return !(scheduledExecutorService == null
                || scheduledExecutorService.isShutdown()
                || scheduledExecutorService.isTerminated());
    }


}
