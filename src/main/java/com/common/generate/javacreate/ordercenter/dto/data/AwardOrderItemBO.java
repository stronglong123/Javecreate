package com.common.generate.javacreate.ordercenter.dto.data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName AwardOrderItemBO
 * @Description TODO
 * @Author hhw
 * @Date 2022/5/13 10:19
 * @Version 1.0
 **/
public class AwardOrderItemBO {

    /**
     * 主键
     */
    private Long id;

    private Long order_Id;

    /**
     * 业务id
     */
    private Long business_Id;

    private Long businessItem_Id;

    /**
     * 产品ID
     */
    private Long productSku_Id;

    /**
     * 产品中台unifySkuId
     */
    private Long unifySkuId;

    /**
     * 原始skuid
     */
    private Long originalProductSkuId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 数量
     */
    private BigDecimal saleCount;

    /**
     * 单位名称
     */
    private String sellUnit;

    /**
     * 销售规格名称
     */
    private String productSaleSpec;

    /**
     * 包装规格名称
     */
    private String productSpec;

    /**
     * 销售规格系数
     */
    private BigDecimal saleSpecQuantity;

    /**
     * 销售规格系数
     */
    private BigDecimal specQuantity;

    /**
     * 销售价格单位
     */
    private String sellPriceUnit;

    /**
     * 销售数量小单位
     */
    private BigDecimal minUnitTotalCount;

    /**
     * 销售单价
     */
    private BigDecimal sellPrice;

    /**
     * 金额
     */
    private BigDecimal totalAmount;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 配送费用金额
     */
    private BigDecimal deliveryAmount;

    /**
     * 大单位名称
     */
    private String packageName;

    /**
     * 小单位名称
     */
    private String unitName;

    /**
     * 备注
     */
    private String remark;

    private Date createTime;

    private Integer createUser_Id;

    private Date lastUpdateTime;

    private Integer lastUpdateUser_Id;

    /**
     * 包装箱码
     */
    private String packageBoxNo;

    /**
     * 成本金额
     */
    private BigDecimal supplyCostPrice;

    /**
     * 成本价单位
     */
    private String supplyCostPriceUnit;

    /**
     * 产品货主
     */
    private Long productOwner_Id;

    /**
     * 规格ID
     */
    private Long specification_Id;

    /**
     * 原始下单数量
     */
    private BigDecimal originalSaleCount;

    /**
     * 拣货顺序
     */
    private Integer pickSequence;

    /**
     * 小单位内配成本价
     */
    private BigDecimal unitCostprice;

    /**
     * 控货策略
     */
    private Long productControl_Id;

    /**
     * 控货策略
     */
    private String productControlName;

    /**
     * 溯原码
     */
    private String productSourceName;

    /**
     * 扣库存数量
     */
    private BigDecimal inventoryCount;

    /**
     * 发货仓数量
     */
    private BigDecimal localOriginalSaleCount;

    /**
     * awardorderitem表主键
     */
    private Long awardOrderItemTableId;

    /**
     * awardorder表主键
     */
    private Long awardOrder_Id;

    /**
     * orderitem表主键
     */
    private Long orderItem_Id;

    /**
     * 申请兑换数量
     */
    private Integer applyAwardCount;

    /**
     * 审核通过的兑换数量
     */
    private Integer canAwardCount;

    /**
     * 兑换红包金额
     */
    private BigDecimal awardBonusAmount;

    /**
     * 过期时间
     */
    private Date deadLineTime;

    /**
     * 兑奖商品名称
     */
    private String awardName;

    /**
     * 财务标记状态 -1无配送状态 ，0全部兑换、2部分兑换、3延迟兑换，4不可兑换
     */
    private Integer deliveryState;

    /**
     * 兑奖类型：1=红包，2=现金，3=实物，4=礼品
     */
    private Integer awardType;

    /**
     * 礼品是否到货：1未到货，2=已到货
     */
    private Integer awardGiftState;

    /**
     * 标记数量/司机/经纪人
     */
    private Integer markAwardCount;

    /**
     * 兑现金金额=(CanAwardCount*AwardPolicyNumber/AwardPolicy
     */
    private BigDecimal awardCashAmount;

    /**
     * 兑奖政策备注
     */
    private String awardPolicyMemo;

    /**
     * 兑奖政策基数
     */
    private Integer awardPolicy;

    /**
     * 兑奖基数
     */
    private Integer awardPolicyNumber;

    /**
     * 兑奖政策基数单位:元/个/瓶
     */
    private String awardPolicyUnit;

    /**
     * 奖项等级
     */
    private String prizeName;

    /**
     * 兑奖基单位数(1个瓶盖)
     */
    private String awardPolicyNumberUnit;

    /**
     * 兑奖实物数量
     */
    private Integer awardNumber;

    /**
     * 现金领取人
     */
    private String receiveCashUser;

    /**
     * 兑奖类型：0=无，1=红包，2=现金，3=实物，4=礼品
     */
    private Integer originalAwardType;

    /**
     * 兑奖产品sku
     */
    private Long awardProductSku_Id;

    /**
     * 兑奖奖项id
     */
    private Long awardProduct_Id;

    /**
     * 现金兑奖关联产品的数量
     */
    private BigDecimal relProductSkuNum;

    /**
     * 现金兑奖关联产品的单位
     */
    private String relProductSkuUnit;

    /**
     * 销售模式  0代营/1自营/2合作/3寄售/4大商转自营/5大商转配送/6入驻/7总部寄售
     */
    private Integer saleMode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Long getBusiness_Id() {
        return business_Id;
    }

    public void setBusiness_Id(Long business_Id) {
        this.business_Id = business_Id;
    }

    public Long getBusinessItem_Id() {
        return businessItem_Id;
    }

    public void setBusinessItem_Id(Long businessItem_Id) {
        this.businessItem_Id = businessItem_Id;
    }

    public Long getProductSku_Id() {
        return productSku_Id;
    }

    public void setProductSku_Id(Long productSku_Id) {
        this.productSku_Id = productSku_Id;
    }

    public Long getUnifySkuId() {
        return unifySkuId;
    }

    public void setUnifySkuId(Long unifySkuId) {
        this.unifySkuId = unifySkuId;
    }

    public Long getOriginalProductSkuId() {
        return originalProductSkuId;
    }

    public void setOriginalProductSkuId(Long originalProductSkuId) {
        this.originalProductSkuId = originalProductSkuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(BigDecimal saleCount) {
        this.saleCount = saleCount;
    }

    public String getSellUnit() {
        return sellUnit;
    }

    public void setSellUnit(String sellUnit) {
        this.sellUnit = sellUnit;
    }

    public String getProductSaleSpec() {
        return productSaleSpec;
    }

    public void setProductSaleSpec(String productSaleSpec) {
        this.productSaleSpec = productSaleSpec;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public BigDecimal getSaleSpecQuantity() {
        return saleSpecQuantity;
    }

    public void setSaleSpecQuantity(BigDecimal saleSpecQuantity) {
        this.saleSpecQuantity = saleSpecQuantity;
    }

    public BigDecimal getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(BigDecimal specQuantity) {
        this.specQuantity = specQuantity;
    }

    public String getSellPriceUnit() {
        return sellPriceUnit;
    }

    public void setSellPriceUnit(String sellPriceUnit) {
        this.sellPriceUnit = sellPriceUnit;
    }

    public BigDecimal getMinUnitTotalCount() {
        return minUnitTotalCount;
    }

    public void setMinUnitTotalCount(BigDecimal minUnitTotalCount) {
        this.minUnitTotalCount = minUnitTotalCount;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(BigDecimal deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser_Id() {
        return createUser_Id;
    }

    public void setCreateUser_Id(Integer createUser_Id) {
        this.createUser_Id = createUser_Id;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUser_Id() {
        return lastUpdateUser_Id;
    }

    public void setLastUpdateUser_Id(Integer lastUpdateUser_Id) {
        this.lastUpdateUser_Id = lastUpdateUser_Id;
    }

    public String getPackageBoxNo() {
        return packageBoxNo;
    }

    public void setPackageBoxNo(String packageBoxNo) {
        this.packageBoxNo = packageBoxNo;
    }

    public BigDecimal getSupplyCostPrice() {
        return supplyCostPrice;
    }

    public void setSupplyCostPrice(BigDecimal supplyCostPrice) {
        this.supplyCostPrice = supplyCostPrice;
    }

    public String getSupplyCostPriceUnit() {
        return supplyCostPriceUnit;
    }

    public void setSupplyCostPriceUnit(String supplyCostPriceUnit) {
        this.supplyCostPriceUnit = supplyCostPriceUnit;
    }

    public Long getProductOwner_Id() {
        return productOwner_Id;
    }

    public void setProductOwner_Id(Long productOwner_Id) {
        this.productOwner_Id = productOwner_Id;
    }

    public Long getSpecification_Id() {
        return specification_Id;
    }

    public void setSpecification_Id(Long specification_Id) {
        this.specification_Id = specification_Id;
    }

    public BigDecimal getOriginalSaleCount() {
        return originalSaleCount;
    }

    public void setOriginalSaleCount(BigDecimal originalSaleCount) {
        this.originalSaleCount = originalSaleCount;
    }

    public Integer getPickSequence() {
        return pickSequence;
    }

    public void setPickSequence(Integer pickSequence) {
        this.pickSequence = pickSequence;
    }

    public BigDecimal getUnitCostprice() {
        return unitCostprice;
    }

    public void setUnitCostprice(BigDecimal unitCostprice) {
        this.unitCostprice = unitCostprice;
    }

    public Long getProductControl_Id() {
        return productControl_Id;
    }

    public void setProductControl_Id(Long productControl_Id) {
        this.productControl_Id = productControl_Id;
    }

    public String getProductControlName() {
        return productControlName;
    }

    public void setProductControlName(String productControlName) {
        this.productControlName = productControlName;
    }

    public String getProductSourceName() {
        return productSourceName;
    }

    public void setProductSourceName(String productSourceName) {
        this.productSourceName = productSourceName;
    }

    public BigDecimal getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(BigDecimal inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public BigDecimal getLocalOriginalSaleCount() {
        return localOriginalSaleCount;
    }

    public void setLocalOriginalSaleCount(BigDecimal localOriginalSaleCount) {
        this.localOriginalSaleCount = localOriginalSaleCount;
    }

    public Long getAwardOrderItemTableId() {
        return awardOrderItemTableId;
    }

    public void setAwardOrderItemTableId(Long awardOrderItemTableId) {
        this.awardOrderItemTableId = awardOrderItemTableId;
    }

    public Long getAwardOrder_Id() {
        return awardOrder_Id;
    }

    public void setAwardOrder_Id(Long awardOrder_Id) {
        this.awardOrder_Id = awardOrder_Id;
    }

    public Long getOrderItem_Id() {
        return orderItem_Id;
    }

    public void setOrderItem_Id(Long orderItem_Id) {
        this.orderItem_Id = orderItem_Id;
    }

    public Integer getApplyAwardCount() {
        return applyAwardCount;
    }

    public void setApplyAwardCount(Integer applyAwardCount) {
        this.applyAwardCount = applyAwardCount;
    }

    public Integer getCanAwardCount() {
        return canAwardCount;
    }

    public void setCanAwardCount(Integer canAwardCount) {
        this.canAwardCount = canAwardCount;
    }

    public BigDecimal getAwardBonusAmount() {
        return awardBonusAmount;
    }

    public void setAwardBonusAmount(BigDecimal awardBonusAmount) {
        this.awardBonusAmount = awardBonusAmount;
    }

    public Date getDeadLineTime() {
        return deadLineTime;
    }

    public void setDeadLineTime(Date deadLineTime) {
        this.deadLineTime = deadLineTime;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Integer getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public Integer getAwardGiftState() {
        return awardGiftState;
    }

    public void setAwardGiftState(Integer awardGiftState) {
        this.awardGiftState = awardGiftState;
    }

    public Integer getMarkAwardCount() {
        return markAwardCount;
    }

    public void setMarkAwardCount(Integer markAwardCount) {
        this.markAwardCount = markAwardCount;
    }

    public BigDecimal getAwardCashAmount() {
        return awardCashAmount;
    }

    public void setAwardCashAmount(BigDecimal awardCashAmount) {
        this.awardCashAmount = awardCashAmount;
    }

    public String getAwardPolicyMemo() {
        return awardPolicyMemo;
    }

    public void setAwardPolicyMemo(String awardPolicyMemo) {
        this.awardPolicyMemo = awardPolicyMemo;
    }

    public Integer getAwardPolicy() {
        return awardPolicy;
    }

    public void setAwardPolicy(Integer awardPolicy) {
        this.awardPolicy = awardPolicy;
    }

    public Integer getAwardPolicyNumber() {
        return awardPolicyNumber;
    }

    public void setAwardPolicyNumber(Integer awardPolicyNumber) {
        this.awardPolicyNumber = awardPolicyNumber;
    }

    public String getAwardPolicyUnit() {
        return awardPolicyUnit;
    }

    public void setAwardPolicyUnit(String awardPolicyUnit) {
        this.awardPolicyUnit = awardPolicyUnit;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getAwardPolicyNumberUnit() {
        return awardPolicyNumberUnit;
    }

    public void setAwardPolicyNumberUnit(String awardPolicyNumberUnit) {
        this.awardPolicyNumberUnit = awardPolicyNumberUnit;
    }

    public Integer getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(Integer awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getReceiveCashUser() {
        return receiveCashUser;
    }

    public void setReceiveCashUser(String receiveCashUser) {
        this.receiveCashUser = receiveCashUser;
    }

    public Integer getOriginalAwardType() {
        return originalAwardType;
    }

    public void setOriginalAwardType(Integer originalAwardType) {
        this.originalAwardType = originalAwardType;
    }

    public Long getAwardProductSku_Id() {
        return awardProductSku_Id;
    }

    public void setAwardProductSku_Id(Long awardProductSku_Id) {
        this.awardProductSku_Id = awardProductSku_Id;
    }

    public Long getAwardProduct_Id() {
        return awardProduct_Id;
    }

    public void setAwardProduct_Id(Long awardProduct_Id) {
        this.awardProduct_Id = awardProduct_Id;
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

    public Integer getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(Integer saleMode) {
        this.saleMode = saleMode;
    }
}

