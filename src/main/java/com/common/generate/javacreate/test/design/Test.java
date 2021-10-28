package com.common.generate.javacreate.test.design;


import java.util.Observer;

/**
 * @author xialei
 * @date 2021/4/19 20:20
 */
public class Test {


    public static void main(String[] args){
        // 创建被观察者对象
        Watched watched1 = new Watched();

        Watched watched2 = new Watched();

        // 创建观察者对象，并将观察者对象登记
        Observer watcher1 = new Watcher();
        Observer watcher2 = new Watcher();

        watched1.addObserver(watcher1);
        watched1.addObserver(watcher2);


        // 给观察者状态赋值
        watched1.setData("start");
        watched1.setData("run");
        watched1.setData("stop");

        watched2.setData("start2");
        watched2.setData("run2");
        watched2.setData("stop2");
    }



}
