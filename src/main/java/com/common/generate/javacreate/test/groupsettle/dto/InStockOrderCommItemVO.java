package com.common.generate.javacreate.test.groupsettle.dto;

import com.common.generate.javacreate.test.transferNote.InStockOrderCommItemDetailDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class InStockOrderCommItemVO implements Serializable {
    private static final long serialVersionUID = -2650618208682572178L;
    /**
     * @Fields inStockUnitCount 已入库小单位数量
     */
    private BigDecimal inStockUnitCount = BigDecimal.ZERO;
    /**
     * @Fields inStockPackageCount 已入库大单位数量
     */
    private BigDecimal inStockPackageCount = BigDecimal.ZERO;

    /**
     * @Fields inStockUnitCount 应入库小单位数量
     */
    private BigDecimal unitCount = BigDecimal.ZERO;
    /**
     * @Fields inStockPackageCount 应入库大单位数量
     */
    private BigDecimal packageCount = BigDecimal.ZERO;

    private String orderItemId;
    private String orderItemNO;
    private String relatedItemId;
    private Integer orderItemState;
    private String productName;
    private String productBarCode;
    private Long skuId;
    private String productBrand;
    private String categoryName;
    private String specName;
    private String packageName;
    private String unitName;
    private BigDecimal specQuantity;
    private BigDecimal unitTotalCount;
    private BigDecimal inUnitTotalCount;
    private BigDecimal totalAmount;
    private BigDecimal payAmount;
    private Long locationId;
    private String locationName;
    private Long ownerId;
    private String ownerName;
    private Long secOwnerId;
    private Long productSpecificationId;
    private Long productInfoId;
    private String productionDate;
    private Integer dayOfShelfLife;
    private String expireTime;
    private String businessTime;
    private String batchTime;
    private String remark;
    private Integer isGift;
    private Integer deleted;
    private Map<String, Object> extContent;
    private BigDecimal price;
    private String priceUnit;
    private Long productControlStrategyId;
    private List<String> traceabilityCodeList;
    private String productionDateImgId;
    private List<String> productionDateImgUrlList;
    private Byte qualityType;
    private BigDecimal qualityRatio;
    private Long wmsOrderItemId;
    private List<InStockOrderCommItemDetailDTO> itemDetailDTOList;

    public BigDecimal getInStockUnitCount() {
        return inStockUnitCount;
    }

    public void setInStockUnitCount(BigDecimal inStockUnitCount) {
        this.inStockUnitCount = inStockUnitCount;
    }

    public BigDecimal getInStockPackageCount() {
        return inStockPackageCount;
    }

    public void setInStockPackageCount(BigDecimal inStockPackageCount) {
        this.inStockPackageCount = inStockPackageCount;
    }

    public BigDecimal getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(BigDecimal unitCount) {
        this.unitCount = unitCount;
    }

    public BigDecimal getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(BigDecimal packageCount) {
        this.packageCount = packageCount;
    }
}
