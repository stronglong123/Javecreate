package com.common.generate.javacreate.ordercenter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 兑奖明细信息
 *
 * @author Hu Liangzhi
 */
public class OrderItemAwardDTO implements Serializable {
    private static final long serialVersionUID = 5079932771578474388L;

    //(description = "应用接入方", required = true)
    private String partnerCode;

    //(description = "订单id")
    private Long orderId;

    //(description = "订单明细id")
    private Long orderItemId;

    //(description = "兑奖类型 1=红包，2=现金，3=实物，4=礼品 ", required = true)
    private Integer awardType;

    //(description = "兑奖名称", required = true)
    private String awardName;

    //(description = "兑奖数量", required = true)
    private BigDecimal awardCount;

    //(description = "兑奖金额", required = true)
    private BigDecimal awardAmount;

    //(description = "兑奖过期时间")
    private Date expiredDate;

    // 1个瓶盖兑换5元
    //(description = "兑奖规则描述", required = true)
    private String awardPolicyDesc;

    // 1
    //(description = "兑奖规则基数", required = true)
    private BigDecimal awardPolicyNum;

    // 个瓶盖
    //(description = "兑奖规则基数单位", required = true)
    private String awardPolicyUnit;

    // 5
    //(description = "兑奖规则兑换数量", required = true)
    private BigDecimal awardPolicyExchangeNum;

    // 元
    //(description = "兑奖规则兑换单位", required = true)
    private String awardPolicyExchangeUnit;

    //(description = "创建时间")
    private Date createTime;

    //(description = "更新时间")
    private Date lastUpdateTime;

    //(description = "现金兑奖关联的产品SkuId")
    private Long relProductSkuId;

    //(description = "产品奖励项id", required = true)
    private Long productAwardId;

    //(description = "现金兑奖关联产品的数量")
    private BigDecimal relProductSkuNum;

    //(description = "现金兑奖关联产品的单位")
    private String relProductSkuUnit;

    //(description = "兑奖等级", required = true)
    private String prizeName;

    //(description = "兑奖标记图片集合")
    private List<String> awardMarkPictures;

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public BigDecimal getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(BigDecimal awardCount) {
        this.awardCount = awardCount;
    }

    public BigDecimal getAwardAmount() {
        return awardAmount;
    }

    public void setAwardAmount(BigDecimal awardAmount) {
        this.awardAmount = awardAmount;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getAwardPolicyDesc() {
        return awardPolicyDesc;
    }

    public void setAwardPolicyDesc(String awardPolicyDesc) {
        this.awardPolicyDesc = awardPolicyDesc;
    }

    public BigDecimal getAwardPolicyNum() {
        return awardPolicyNum;
    }

    public void setAwardPolicyNum(BigDecimal awardPolicyNum) {
        this.awardPolicyNum = awardPolicyNum;
    }

    public String getAwardPolicyUnit() {
        return awardPolicyUnit;
    }

    public void setAwardPolicyUnit(String awardPolicyUnit) {
        this.awardPolicyUnit = awardPolicyUnit;
    }

    public BigDecimal getAwardPolicyExchangeNum() {
        return awardPolicyExchangeNum;
    }

    public void setAwardPolicyExchangeNum(BigDecimal awardPolicyExchangeNum) {
        this.awardPolicyExchangeNum = awardPolicyExchangeNum;
    }

    public String getAwardPolicyExchangeUnit() {
        return awardPolicyExchangeUnit;
    }

    public void setAwardPolicyExchangeUnit(String awardPolicyExchangeUnit) {
        this.awardPolicyExchangeUnit = awardPolicyExchangeUnit;
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

    public Long getRelProductSkuId() {
        return relProductSkuId;
    }

    public void setRelProductSkuId(Long relProductSkuId) {
        this.relProductSkuId = relProductSkuId;
    }

    public Long getProductAwardId() {
        return productAwardId;
    }

    public void setProductAwardId(Long productAwardId) {
        this.productAwardId = productAwardId;
    }

    public BigDecimal getRelProductSkuNum() {
        return relProductSkuNum;
    }

    public void setRelProductSkuNum(BigDecimal relProductSkuNum) {
        this.relProductSkuNum = relProductSkuNum;
    }

    public String getRelProductSkuUnit() {
        return relProductSkuUnit;
    }

    public void setRelProductSkuUnit(String relProductSkuUnit) {
        this.relProductSkuUnit = relProductSkuUnit;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    /**
     * 获取 //(description = "兑奖标记图片集合")
     *
     * @return awardMarkPictures //(description = "兑奖标记图片集合")
     */
    public List<String> getAwardMarkPictures() {
        return this.awardMarkPictures;
    }

    /**
     * 设置 //(description = "兑奖标记图片集合")
     *
     * @param awardMarkPictures //(description = "兑奖标记图片集合")
     */
    public void setAwardMarkPictures(List<String> awardMarkPictures) {
        this.awardMarkPictures = awardMarkPictures;
    }
}
