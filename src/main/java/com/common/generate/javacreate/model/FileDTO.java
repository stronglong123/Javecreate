package com.common.generate.javacreate.model;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2020/12/1 11:51
 */
public class FileDTO implements Serializable {

    private static final long serialVersionUID = -7010468555023493335L;


    private String sourceFileName;

    private String targetFileName;

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getTargetFileName() {
        return targetFileName;
    }

    public void setTargetFileName(String targetFileName) {
        this.targetFileName = targetFileName;
    }
}
