package com.common.generate.javacreate.ordercenter.dto.event;

import java.util.List;

/**
 * @author xialei
 * @date 2022/7/22 10:13
 */
public class OutEventAndInEventDTO {

    private String inPartnerCode;

    private String inEventCode;

    private String inEventName;


    List<EventSimple> outEventList;

    public String getInPartnerCode() {
        return inPartnerCode;
    }

    public void setInPartnerCode(String inPartnerCode) {
        this.inPartnerCode = inPartnerCode;
    }

    public String getInEventCode() {
        return inEventCode;
    }

    public void setInEventCode(String inEventCode) {
        this.inEventCode = inEventCode;
    }

    public String getInEventName() {
        return inEventName;
    }

    public void setInEventName(String inEventName) {
        this.inEventName = inEventName;
    }

    public List<EventSimple> getOutEventList() {
        return outEventList;
    }

    public void setOutEventList(List<EventSimple> outEventList) {
        this.outEventList = outEventList;
    }
}
