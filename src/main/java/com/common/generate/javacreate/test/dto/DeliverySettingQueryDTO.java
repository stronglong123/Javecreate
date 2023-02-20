package com.common.generate.javacreate.test.dto;

import java.sql.Date;
import java.util.List;

/**
 * @author xialei
 * @date 2022/2/9 11:45
 */
public class DeliverySettingQueryDTO {
    private static final long serialVersionUID = 5745403796421424882L;
    private String shipperCode;
    private String shipperName;
    private Byte state;
    private Date createTime;
    private Date lastUpdateTime;
    List<String> shipperCodeList;
    private Byte source;

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<String> getShipperCodeList() {
        return shipperCodeList;
    }

    public void setShipperCodeList(List<String> shipperCodeList) {
        this.shipperCodeList = shipperCodeList;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }
}
