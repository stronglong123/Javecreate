package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/5/13 10:57
 */
public class ErpCheckWmsDetailDTO implements Serializable {
    private static final long serialVersionUID = 6018134618082114780L;

    private String key ;

    private List<ErpCheckWmsDTO> wmsList;

    private List<ErpCheckWmsDTO> erpList;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<ErpCheckWmsDTO> getWmsList() {
        return wmsList;
    }

    public void setWmsList(List<ErpCheckWmsDTO> wmsList) {
        this.wmsList = wmsList;
    }

    public List<ErpCheckWmsDTO> getErpList() {
        return erpList;
    }

    public void setErpList(List<ErpCheckWmsDTO> erpList) {
        this.erpList = erpList;
    }
}
