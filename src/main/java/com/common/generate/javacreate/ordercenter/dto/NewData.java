package com.common.generate.javacreate.ordercenter.dto;

import java.util.List;

/**
 * @author xialei
 * @date 2023/4/20 11:21
 */
public class NewData {

    private Long businessId;

    private List<NewDataItem> list;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public List<NewDataItem> getList() {
        return list;
    }

    public void setList(List<NewDataItem> list) {
        this.list = list;
    }
}
