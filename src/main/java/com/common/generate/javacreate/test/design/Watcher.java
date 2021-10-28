package com.common.generate.javacreate.test.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author xialei
 * @date 2021/4/19 20:22
 */
public class Watcher implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("状态发生改变：" + ((Watched) o).getData());
    }
}
