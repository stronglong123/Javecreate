package com.common.generate.javacreate.test;

import com.common.generate.javacreate.test.dto.Inventorycheck;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.UUIDUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author xialei
 * @date 2021/7/19 16:29
 */
public class CreateSqlUtil {


    private static final String ORDERSKUITEMSQL = "INSERT into oms_order_3.group_settle_order_sku_item " +
            "(Id, OrgId, SettleOrderId, SaleDate, AccountDate, SettleDate, SkuId, SkuSettleType, ChannelNo, ChannelCity, ChannelSkuName, ProductSaleSpec, SaleSpecQuantity," +
            " SalePrice, SaleAmount, MinUnitTotalCount, CreateTime, CreateUserId, LastUpdateTime, LastUpdateUserId, SellUnit, ProductSpecId, ProductOwnerId, DefaultCostPrice) " +
            "VALUES";
    private static final String ORDERSKUSQL = "INSERT into oms_order_3.group_settle_order_sku " +
            "(Id, OrgId, SkuId, SettleOrderId, SaleDate, AccountDate, SettleDate, SaleWarehouseId, ChannelNo, ChannelCity, SaleDeliverPackageCount, SaleDeliverUnitCount, " +
            "DeliverPackageCount, DeliverUnitCount, TransformPackageCount, TransformUnitCount, SaleStorePackageCount, SaleStoreUnitCount, StorePackageCount, StoreUnitCount," +
            " CancelStorePackageCount, CancelStoreUnitCount, SettleDiffPackageCount, SettleDiffUnitCount, SaleSpecQuantity, SettleAmount, SettleState, CreateTime, " +
            "CreateUserId, LastUpdateTime, LastUpdateUserId, ProductSpecId, ProductOwnerId, DefaultCostPrice) " +
            "VALUES";


    private static final String ORDERBILLSQL = "INSERT INTO oms_order_3.group_settle_order_bill (Id, OrgId, SettleOrderId, BusinessNo, OrderId, OrderItemId, OrderDate, OrderType, SkuId, " +
            "SkuName, ProductSaleSpec, SaleSpecQuantity, SellUnit, OrderPrice, OrderAmount, OriginalMinUnitTotalCount, MinUnitTotalCount, SettleMinUnitTotalCount, ProductOwnerId, " +
            "CreateTime, CreateUserId, LastUpdateTime, LastUpdateUserId, ProductSpecId) " +
            "VALUES";


    private static final String ORDERBILLOWNERSQL = "INSERT INTO oms_order_3.group_settle_order_bill_owner (Id, OrgId, SettleOrderId, BillId, OrderType, SkuId, " +
            "DispatchSecProductOwnerId, DispatchCount, CreateTime, CreateUserId, LastUpdateTime, LastUpdateUserId, ProductSpecId) " +
            "VALUES";


    private static final String split = ",";
    private static final String point = "'";



    public static String createSkuSql(Inventorycheck dto) {
        BigDecimal[] counts = dto.getDiffTotalCount().divideAndRemainder(dto.getSpecQuantity());
        StringBuilder skuSql = new StringBuilder();
        String mainSql = changeDateSource(ORDERSKUSQL,dto.getDateSource());
        skuSql.append(mainSql).append("(").append(getId()).append(split)
                .append(point).append(dto.getOrgId()).append(point).append(split)
                .append(point).append(dto.getProductSkuId()).append(point).append(split)
                .append(point).append(dto.getSettleId()).append(point).append(split)
                .append(point).append(getSaleDate(dto.getDate())).append(point).append(split)
                .append(point).append(dto.getDate()).append(point).append(split)
                .append(point).append(getSettleDate(dto.getDate())).append(point).append(split)
                .append(point).append(dto.getWarehouseId()).append(point).append(split)
                .append(point).append(getOrderSource(dto.getCompanyCode())).append(point).append(split)
                .append(point).append(dto.getChannelCity()).append(point).append(split);
        if (dto.getType().equals("入")) {
            skuSql.append(point).append(counts[0]).append(point).append(split)
                    .append(point).append(counts[1]).append(point).append(split)
                    .append(point).append(counts[0]).append(point).append(split)
                    .append(point).append(counts[1]).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split);
        } else {
            skuSql.append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(counts[0]).append(point).append(split)
                    .append(point).append(counts[1]).append(point).append(split)
                    .append(point).append(counts[0]).append(point).append(split)
                    .append(point).append(counts[1]).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split)
                    .append(point).append(0).append(point).append(split);
        }

        skuSql.append(point).append(dto.getSpecQuantity()).append(point).append(split)
                .append(point).append(dto.getTotalAmount()).append(point).append(split)
                .append(point).append("2").append(point).append(split)
                .append(point).append(dto.getCreateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getLastUpdateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getProductSpecificationId()).append(point).append(split)
                .append("null").append(split)
                .append(point).append(dto.getCostPrice()).append(point)
                .append(");");
        return skuSql.toString();
    }



    public static String createSkuItemSql(Inventorycheck dto) {
        StringBuilder skuItemSql = new StringBuilder();
        String mainSql = changeDateSource(ORDERSKUITEMSQL,dto.getDateSource());
        skuItemSql.append(mainSql).append("(").append(getId()).append(split)
                .append(point).append(dto.getOrgId()).append(point).append(split)
                .append(point).append(dto.getSettleId()).append(point).append(split)
                .append(point).append(getSaleDate(dto.getDate())).append(point).append(split)
                .append(point).append(dto.getDate()).append(point).append(split)
                .append(point).append(getSettleDate(dto.getDate())).append(point).append(split)
                .append(point).append(dto.getProductSkuId()).append(point).append(split)
                .append(point).append(dto.getType().equals("出") ? 1 : 2).append(point).append(split)
                .append(point).append(getOrderSource(dto.getCompanyCode())).append(point).append(split)
                .append(point).append(dto.getChannelCity()).append(point).append(split)
                .append(point).append(dto.getProductName()).append(point).append(split)
                .append(point).append(dto.getSpecName()).append(point).append(split)
                .append(point).append(dto.getSpecQuantity()).append(point).append(split)
                .append(point).append(dto.getCostPrice()).append(point).append(split)
                .append(point).append(dto.getTotalAmount()).append(point).append(split)
                .append(point).append(dto.getDiffTotalCount()).append(point).append(split)
                .append(point).append(dto.getCreateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getLastUpdateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getUnitName()).append(point).append(split)
                .append(point).append(dto.getProductSpecificationId()).append(point).append(split)
                .append("null").append(split)
                .append(point).append(dto.getCostPrice()).append(point)
                .append(");");
        return skuItemSql.toString();
    }


    public static String createOrderBillSql(Inventorycheck dto) {
        StringBuilder orderBillSql = new StringBuilder();
        Long id = getId();
        dto.setBillId(id);
        String mainSql = changeDateSource(ORDERBILLSQL,dto.getDateSource());
        orderBillSql.append(mainSql).append("(").append(id).append(split)
                .append(point).append(dto.getOrgId()).append(point).append(split)
                .append(point).append(dto.getSettleId()).append(point).append(split)
                .append(point).append(dto.getOrderNo()).append(point).append(split)
                .append(point).append(dto.getOrderId()).append(point).append(split)
                .append(point).append(dto.getOrderItemId()).append(point).append(split)
                .append(point).append(dto.getDate()).append(point).append(split)
                .append(point).append(dto.getType().equals("出") ? 1 : 2).append(point).append(split)
                .append(point).append(dto.getProductSkuId()).append(point).append(split)
                .append(point).append(dto.getProductName()).append(point).append(split)
                .append(point).append(dto.getSpecName()).append(point).append(split)
                .append(point).append(dto.getSpecQuantity()).append(point).append(split)
                .append(point).append(dto.getUnitName()).append(point).append(split)
                .append(point).append(dto.getCostPrice()).append(point).append(split)
                .append(point).append(dto.getTotalAmount()).append(point).append(split)
                .append(point).append(dto.getDiffTotalCount()).append(point).append(split)
                .append(point).append(dto.getDiffTotalCount()).append(point).append(split)
                .append(point).append(dto.getDiffTotalCount()).append(point).append(split)
                .append("null").append(split)
                .append(point).append(dto.getCreateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getLastUpdateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getProductSpecificationId()).append(point)
                .append(");");
        return orderBillSql.toString();
    }


    public static String createOrderBillOwnerSql(Inventorycheck dto){
        StringBuilder orderBillSql = new StringBuilder();
        String mainSql = changeDateSource(ORDERBILLOWNERSQL,dto.getDateSource());
        orderBillSql.append(mainSql).append("(").append(getId()).append(split)
                .append(point).append(dto.getOrgId()).append(point).append(split)
                .append(point).append(dto.getSettleId()).append(point).append(split)
                .append(point).append(dto.getBillId()).append(point).append(split)
                .append(point).append(dto.getType().equals("出") ? 1 : 2).append(point).append(split)
                .append(point).append(dto.getProductSkuId()).append(point).append(split)
                .append(point).append(dto.getTrueOwnerId()).append(point).append(split)
                .append(point).append(dto.getDiffTotalCount()).append(point).append(split)
                .append(point).append(dto.getCreateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getLastUpdateTime()).append(point).append(split)
                .append(point).append("1").append(point).append(split)
                .append(point).append(dto.getProductSpecificationId()).append(point)
                .append(");");
        return orderBillSql.toString();
    }


    public static String updateOrderBillSql(Inventorycheck dto){
        StringBuilder groupBillSql = new StringBuilder();
        String mainSql = changeDateSource("UPDATE oms_order_3.group_settle_order_bill set ",dto.getDateSource());
        groupBillSql.append(mainSql);
        if (dto.getType().equals("入")) {
            String connnect = " - ";

            groupBillSql.append(" OriginalMinUnitTotalCount = OriginalMinUnitTotalCount").append(connnect)
                    .append(dto.getDiffTotalCount())
                    .append(",MinUnitTotalCount = MinUnitTotalCount").append(connnect)
                    .append(dto.getDiffTotalCount())
                    .append(",SettleMinUnitTotalCount = SettleMinUnitTotalCount").append(connnect)
                    .append(dto.getDiffTotalCount())
                    .append(",OrderAmount = OrderAmount").append(connnect)
                    .append(dto.getTotalAmount());
        }else {
            String connnect = " + ";
            groupBillSql.append(" OriginalMinUnitTotalCount = OriginalMinUnitTotalCount").append(connnect)
                    .append(dto.getDiffTotalCount())
                    .append(",MinUnitTotalCount = MinUnitTotalCount").append(connnect)
                    .append(dto.getDiffTotalCount())
                    .append(",SettleMinUnitTotalCount = SettleMinUnitTotalCount").append(connnect)
                    .append(dto.getDiffTotalCount())
                    .append(",OrderAmount = OrderAmount").append(connnect)
                    .append(dto.getTotalAmount());
        }

        groupBillSql.append(" WHERE Id = ")
                .append(dto.getGroupOrderSkuId())
                .append(";");
        return groupBillSql.toString();
    }


    public static String updateSkuSql(Inventorycheck dto){
        StringBuilder groupBillSql = new StringBuilder();
        String mainSql = changeDateSource("UPDATE oms_order_3.group_settle_order_sku set ",dto.getDateSource());
        groupBillSql.append(mainSql);
        BigDecimal[] counts = dto.getDiffTotalCount().divideAndRemainder(dto.getSpecQuantity(), new MathContext(2, RoundingMode.HALF_UP));

        if (dto.getType().equals("入")) {
            groupBillSql.append(" SaleStorePackageCount = SaleStorePackageCount  + ")
                    .append(counts[0])
                    .append(",SaleStoreUnitCount = SaleStoreUnitCount + ")
                    .append(counts[1])
                    .append(",StorePackageCount = StorePackageCount + ")
                    .append(counts[0])
                    .append(",StoreUnitCount = StoreUnitCount + ")
                    .append(counts[1])
                    .append(",SettleAmount = SettleAmount - ")
                    .append(dto.getTotalAmount());
        }else {
            groupBillSql.append(" SaleDeliverPackageCount = SaleDeliverPackageCount  + ")
                    .append(counts[0])
                    .append(",SaleDeliverUnitCount = SaleDeliverUnitCount + ")
                    .append(counts[1])
                    .append(",DeliverPackageCount = DeliverPackageCount + ")
                    .append(counts[0])
                    .append(",DeliverUnitCount = DeliverUnitCount + ")
                    .append(counts[1])
                    .append(",SettleAmount = SettleAmount + ")
                    .append(dto.getTotalAmount());
        }

        groupBillSql.append(" WHERE Id = ")
                .append(dto.getGroupOrderSkuId())
                .append(";");
        return groupBillSql.toString();
    }


    public static String createGroupBillSql(Inventorycheck dto) {
        StringBuilder groupBillSql = new StringBuilder();
        String connnect;
        if (dto.getType().equals("入")) {
            connnect = " - ";
        }else {
            connnect = " + ";
        }
        String mainSql = changeDateSource("UPDATE oms_order_3.group_settle_order set  SettleAmount = SettleAmount",dto.getDateSource());

        groupBillSql.append(mainSql)
                .append(connnect)
                .append(dto.getTotalAmount())
                .append(" WHERE Id = ")
                .append(dto.getSettleId())
                .append(" AND ChannelNo = ")
                .append(getOrderSource(dto.getCompanyCode()))
                .append(" AND SettleNo = ")
                .append(point)
                .append(dto.getSettleNo())
                .append(point)
                .append(";");
        return groupBillSql.toString();
    }


    public static void main(String[] args){
        System.out.println(getId());
    }


    private static String changeDateSource(String mainSql,String dateSource){
        String orderskusql = mainSql;
        if(dateSource.equals("1")){
            orderskusql = mainSql.replace("oms_order_3","oms_order_1");
        }else if(dateSource.equals("2")){
            orderskusql = mainSql.replace("oms_order_3","oms_order_2");
        }
        return orderskusql;
    }

    public static Long getId(){
        return UUIDUtil.getUuid();
    }



    private static String getSaleDate(String dateString){
        Date date = DateUtils.string2Date(dateString);
        return DateUtils.getBeforeDay(date,3);
    }


    private static String getSettleDate(String dateString){
        Date date = DateUtils.string2Date(dateString);
        return DateUtils.getBeforeDay(date,-1);
    }

    public static byte getOrderSource(String companyCode) {
        byte result = (byte) 110;
        switch (companyCode) {
            case "MTYX":
                result = (byte) 110;
                break;
            case "DDMC":
                result = (byte) 111;
                break;
        }
        return result;
    }
}
