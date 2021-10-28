package com.common.generate.javacreate.service.multthread;

/**
 * @author xialei
 * @date 2021/10/26 13:59
 */
public class MyTest {


    public static void main(String[] args) {
        MyThread myThread = new MyThread("测试");
        myThread.start();
        Thread thread = new Thread(myThread);
        thread.start();

        Thread thread1 = new Thread(new MyRunable("测试2"));
        thread1.start();
    }
}
