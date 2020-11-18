package com.common.generate.javacreate.model;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/11/16 14:10
 */
public class ReplaceParamsDTO implements Serializable {

    private String oldParam;


    private String newParam;


    public String getOldParam() {
        return oldParam;
    }

    public void setOldParam(String oldParam) {
        this.oldParam = oldParam;
    }

    public String getNewParam() {
        return newParam;
    }

    public void setNewParam(String newParam) {
        this.newParam = newParam;
    }
}
