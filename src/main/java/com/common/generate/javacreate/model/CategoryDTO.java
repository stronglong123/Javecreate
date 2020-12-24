package com.common.generate.javacreate.model;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/12/23 9:33
 */
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 3718944623998470626L;

    private String wmsCat;

    private Long catId;

    private String catName;

    public String getWmsCat() {
        return wmsCat;
    }

    public void setWmsCat(String wmsCat) {
        this.wmsCat = wmsCat;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
