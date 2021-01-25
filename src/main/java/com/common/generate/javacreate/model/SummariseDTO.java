package com.common.generate.javacreate.model;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2021/1/16 17:43
 */
public class SummariseDTO implements Serializable {
    private static final long serialVersionUID = -3076377936519418629L;
    private String text;

    private int numSentences;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumSentences() {
        return numSentences;
    }

    public void setNumSentences(int numSentences) {
        this.numSentences = numSentences;
    }
}
