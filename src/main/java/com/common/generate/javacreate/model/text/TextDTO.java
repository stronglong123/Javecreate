package com.common.generate.javacreate.model.text;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/5/15 15:26
 */
public class TextDTO implements Serializable {

    private static final long serialVersionUID = -3572153239503486313L;

    /**
     * 表名
     */
    private String title;
    /**
     * 描述
     */
    private String comment;

    /**
     *
     * @return
     */
    private String source;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
