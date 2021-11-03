package com.common.generate.javacreate.model;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2021/9/27 9:00
 */
public class StoryDTO implements Serializable {


    private static final long serialVersionUID = -8416250463692961153L;
    private String title;

    private String context;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
