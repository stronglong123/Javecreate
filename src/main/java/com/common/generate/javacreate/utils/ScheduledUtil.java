package com.common.generate.javacreate.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xialei
 * @date 2022/3/22 16:58
 */
public class ScheduledUtil {

    private ScheduledUtil() {
    }

    private volatile static ScheduledExecutorService scheduler = null;

    private static final int SCHE_THREAD_SIZE = 5;

    public ScheduledExecutorService getScheduledExecutorService() {
        if (isScheduledServiceEnable()) {
            synchronized (ScheduledUtil.class){
                if (isScheduledServiceEnable()){
                    scheduler = new ScheduledThreadPoolExecutor(SCHE_THREAD_SIZE);
                }
            }
        }
        return scheduler;
    }

    private boolean isScheduledServiceEnable() {
        return scheduler == null
                || scheduler.isShutdown()
                || scheduler.isTerminated();
    }


    public static void main(String[] args) {
        ScheduledUtil scheduledUtil =new ScheduledUtil();
        scheduler = scheduledUtil.getScheduledExecutorService();

        System.out.println("main thread time : " + formatDateToString(new Date()));
        // 循环任务，按照上一次任务的发起时间计算下一次任务的开始时间
        scheduler.schedule(((
                        () -> {
                            System.out.println(
                                    " 开始 threadId = " + Thread.currentThread().getId()
                                            + ",,,threadName = " + Thread.currentThread().getName()
                                            + ",,,时间" + formatDateToString(new Date())
                            );

                            try {
                                Thread.sleep(1000);
                                System.out.println(" 结束 threadId = " + Thread.currentThread().getId()
                                        + ",,,threadName = " + Thread.currentThread().getName()
                                        + ",,,时间" + formatDateToString(new Date())
                                );

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        })),
                5,
                TimeUnit.SECONDS);
    }

    public static String formatDateToString(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(time);
    }

}
