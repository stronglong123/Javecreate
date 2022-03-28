package com.common.generate.javacreate.service.multthread;

/**
 * @author xialei
 * @date 2021/10/26 13:58
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("test");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "Thread多线程:" + name);
    }
}
