package com.common.generate.javacreate.service.impl.es.base;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 兑奖明细信息
 *
 * @author Hu Liangzhi
 */
@ApiModel(description = "兑奖单明细")
public class OrderItemAwardDTO implements Serializable {
    private static final long serialVersionUID = 5079932771578474388L;

    @ApiParam(description = "应用接入方", required = true)
    private String partnerCode;

    @ApiParam(description = "订单id")
    private Long orderId;

    @ApiParam(description = "订单明细id")
    private Long orderItemId;

    @ApiParam(description = "兑奖类型 1=红包，2=现金，3=实物，4=礼品", required = true)
    private Integer awardType;

    @ApiParam(description = "兑奖名称", required = true)
    private String awardName;

    @ApiParam(description = "兑奖数量", required = true)
    private BigDecimal awardCount;

    @ApiParam(description = "兑奖金额", required = true)
    private BigDecimal awardAmount;

    @ApiParam(description = "兑奖过期时间")
    private Date expiredDate;

    // 1个瓶盖兑换5元
    @ApiParam(description = "兑奖规则描述", required = true)
    private String awardPolicyDesc;

    // 1
    @ApiParam(description = "兑奖规则基数", required = true)
    @NotNull
    private BigDecimal awardPolicyNum;

    // 个瓶盖
    @ApiParam(description = "兑奖规则基数单位", required = true)
    private String awardPolicyUnit;

    // 5
    @ApiParam(description = "兑奖规则兑换数量", required = true)
    private BigDecimal awardPolicyExchangeNum;

    // 元
    @ApiParam(description = "兑奖规则兑换单位", required = true)
    private String awardPolicyExchangeUnit;

    @ApiParam(description = "创建时间")
    private Date createTime;

    @ApiParam(description = "更新时间")
    private Date lastUpdateTime;

    @ApiParam(description = "兑出产品SkuId")
    private Long relProductSkuId;

    @ApiParam(description = "产品奖励项id", required = true)
    private Long productAwardId;

    @ApiParam(description = "兑出产品的数量")
    private BigDecimal relProductSkuNum;

    @ApiParam(description = "兑出产品的单位")
    private String relProductSkuUnit;

    @ApiParam(description = "兑奖等级", required = true)
    private String prizeName;

    @ApiParam(description = "兑奖标记图片集合")
    private List<String> awardMarkPictures;

    @ApiParam(description = "兑出产品包装规格")
    private BigDecimal relSpecQuantity;

    @ApiParam(description = "兑出产品销售规格")
    private BigDecimal relSaleSpecQuantity;

    @ApiParam(description = "兑出产品大单位")
    private String relPackageName;

    @ApiParam(description = "兑出产品小单位")
    private String relUnitName;

    @ApiParam(description = "兑出产品货主id")
    private Long relOwnerId;

    @ApiParam(description = "兑出产品规格id")
    private Long relProductSpecificationId;

    @ApiParam(description = "兑出产品小单位总数")
    private BigDecimal relMinUnitTotalCount;

    @ApiParam(description = "兑出产品销售规格名称")
    private String relSaleSpec;

    @ApiParam(description = "兑出产品包装规格名称")
    private String relProductSpec;

    @ApiParam(description = "兑出产品名称")
    private String relProductName;

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
     * 获取 @ApiParam(description = "兑奖标记图片集合")
     *
     * @return awardMarkPictures @ApiParam(description = "兑奖标记图片集合")
     */
    public List<String> getAwardMarkPictures() {
        return this.awardMarkPictures;
    }

    /**
     * 设置 @ApiParam(description = "兑奖标记图片集合")
     *
     * @param awardMarkPictures @ApiParam(description = "兑奖标记图片集合")
     */
    public void setAwardMarkPictures(List<String> awardMarkPictures) {
        this.awardMarkPictures = awardMarkPictures;
    }

    public BigDecimal getRelSpecQuantity() {
        return this.relSpecQuantity;
    }

    public void setRelSpecQuantity(final BigDecimal relSpecQuantity) {
        this.relSpecQuantity = relSpecQuantity;
    }

    public BigDecimal getRelSaleSpecQuantity() {
        return this.relSaleSpecQuantity;
    }

    public void setRelSaleSpecQuantity(final BigDecimal relSaleSpecQuantity) {
        this.relSaleSpecQuantity = relSaleSpecQuantity;
    }

    public String getRelPackageName() {
        return this.relPackageName;
    }

    public void setRelPackageName(final String relPackageName) {
        this.relPackageName = relPackageName;
    }

    public String getRelUnitName() {
        return this.relUnitName;
    }

    public void setRelUnitName(final String relUnitName) {
        this.relUnitName = relUnitName;
    }
    public Long getRelOwnerId() {
        return this.relOwnerId;
    }

    public void setRelOwnerId(final Long relOwnerId) {
        this.relOwnerId = relOwnerId;
    }

    public Long getRelProductSpecificationId() {
        return this.relProductSpecificationId;
    }

    public void setRelProductSpecificationId(final Long relProductSpecificationId) {
        this.relProductSpecificationId = relProductSpecificationId;
    }

    public BigDecimal getRelMinUnitTotalCount() {
        return this.relMinUnitTotalCount;
    }

    public void setRelMinUnitTotalCount(final BigDecimal relMinUnitTotalCount) {
        this.relMinUnitTotalCount = relMinUnitTotalCount;
    }

    public String getRelSaleSpec() {
        return this.relSaleSpec;
    }

    public void setRelSaleSpec(final String relSaleSpec) {
        this.relSaleSpec = relSaleSpec;
    }

    public String getRelProductSpec() {
        return this.relProductSpec;
    }

    public void setRelProductSpec(final String relProductSpec) {
        this.relProductSpec = relProductSpec;
    }

    public String getRelProductName() {
        return this.relProductName;
    }

    public void setRelProductName(final String relProductName) {
        this.relProductName = relProductName;
    }
}
