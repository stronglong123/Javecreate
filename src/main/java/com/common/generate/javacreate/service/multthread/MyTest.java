package com.common.generate.javacreate.service.multthread;

/**
 * @author xialei
 * @date 2021/10/26 13:59
 */
public class MyTest {


    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        MyThread myThread = new MyThread("测试");
        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(new MyRunable("测试2"));
        myThread.start();
//        myThread.join();
//        thread.start();
//        thread1.start();
        System.out.println("结束");

    }
}
