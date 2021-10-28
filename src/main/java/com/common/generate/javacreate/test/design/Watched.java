package com.common.generate.javacreate.test.design;

import java.util.Observable;

/**
 * @author xialei
 * @date 2021/4/19 20:22
 */
public class Watched extends Observable {

    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }
}
