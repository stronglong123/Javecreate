package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2020/11/16 14:07
 */
public class ReplaceDTO implements Serializable {


    private String data;


    private List<ReplaceParamsDTO>  replaceList;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<ReplaceParamsDTO> getReplaceList() {
        return replaceList;
    }

    public void setReplaceList(List<ReplaceParamsDTO> replaceList) {
        this.replaceList = replaceList;
    }
}
