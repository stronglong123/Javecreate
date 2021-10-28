package com.common.generate.javacreate.service.newcheck;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/5/18 9:27
 */
public class DetailDTO {


    private Long skuId;

    private String skuName;

    private List<DataDTO> erpList;

    private String ownerId;

    private String ownerName;

    private BigDecimal diffCount;

    List<CompareSettleOrderBillOwnerBO> wmsList;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getDiffCount() {
        return diffCount;
    }

    public void setDiffCount(BigDecimal diffCount) {
        this.diffCount = diffCount;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public List<DataDTO> getErpList() {
        return erpList;
    }

    public void setErpList(List<DataDTO> erpList) {
        this.erpList = erpList;
    }

    public List<CompareSettleOrderBillOwnerBO> getWmsList() {
        return wmsList;
    }

    public void setWmsList(List<CompareSettleOrderBillOwnerBO> wmsList) {
        this.wmsList = wmsList;
    }
}
