package com.common.generate.javacreate.service.multthread;

/**
 * @author xialei
 * @date 2021/10/26 14:01
 */
public class MyRunable implements Runnable {


    private String name;

    public MyRunable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "多线程：" + name);
    }
}
