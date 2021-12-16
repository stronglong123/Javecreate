package com.common.generate.javacreate.model;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2021/4/27 17:07
 */
public class TextSummaryDTO implements Serializable {
    private static final long serialVersionUID = -6303892042217405128L;

    private String text;

    private Integer type;

    private Integer numSentences;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumSentences() {
        return numSentences;
    }

    public void setNumSentences(Integer numSentences) {
        this.numSentences = numSentences;
    }
}
