package com.common.generate.javacreate.constants;

/**
 * @ClassName SaleOrderDataConstant
 * @Description 销售单数据常量类
 * @Author hhw
 * @Date 2022/5/11 17:28
 * @Version 1.0
 **/
public final class SaleOrderDataConstant {

    /**
     *oms订单状态
     * 已下单
     */
    public static final Integer OMS_STATE_ORDER = 1;
    /**
     * 审核通过
     */
    public static final Integer OMS_STATE_AUDITOK = 3;
    /**
     * 配送失败
     */
    public static final Integer OMS_STATE_DELIVERYFAILED = 8;
    /**
     * (已出库）仓管确认出库
     */
    public static final Integer OMS_STATE_OUTSTOCK = 30;
    /**
     * 已发车
     */
    public static final Integer OMS_STATE_SHIPPED = 6;
    /**
     * 已完成
     */
    public static final Integer OMS_STATE_COMPELETE = 7;
    /**
     * 默认
     */
    public static final Integer OMS_STATE_DEFAULT = 0;
    /**
     * 已取消
     */
    public static final Integer OMS_STATE_CANCEL = 2;
    /**
     * 审核拒绝
     */
    public static final Integer OMS_STATE_AUDITNO = 4;
    /**
     * 待发货
     */
    public static final Integer OMS_STATE_WAITDELIVERY = 5;
    /**
     * 待结账
     */
    public static final Integer OMS_STATE_WAITSETTLEMENT = 10;
    /**
     * 延迟配送
     */
    public static final Integer OMS_STATE_DELAY = 14;
    /**
     * 作废
     */
    public static final Integer OMS_STATE_DEL = 16;
    /**
     * 已结算
     */
    public static final Integer OMS_STATE_SETTLED = 20;
    /**
     * 待结算
     */
    public static final Integer OMS_STATE_WAITSETTLE = 21;
    /**
     * 待支付
     */
    public static final Integer OMS_STATE_WAITPAY = 11;
    /**
     * 调拨发货状态
     */
    public static final Integer STATE_ALLOCATION_DISPATCH = 36;

    /**
     * 调拨中
     */
    public static final Integer STATE_ALLOCATION_DISPATCHING = 35;
    /**
     * 合并状态
     */
    public static final Integer STATE_COMBINEORDER = 40;

    /**
     * 订单中台状态
     */
    /**
     * 已下单
     */
    public static final Integer ORDERCENTER_STATE_ADD = 200;
    /**
     * 已支付
     */
    public static final Integer ORDERCENTER_STATE_PAID = 202;
    /**
     * 审核通过
     */
    public static final Integer ORDERCENTER_STATE_AUDIT_PASS = 203;
    /**
     * 开始调度
     */
    public static final Integer ORDERCENTER_STATE_SCHEDULING = 205;
    /**
     * 开始作业
     */
    public static final Integer ORDERCENTER_STATE_WORK = 206;
    /**
     * 复核中
     */
    public static final Integer ORDERCENTER_STATE_REVIEWING = 208;
    /**
     * 预售中
     */
    public static final Integer ORDERCENTER_STATE_PRESALE = 209;
    /**
     * 待自提
     */
    public static final Integer ORDERCENTER_STATE_WAIT_SELFUP = 222;
    /**
     * 审核拒绝
     */
    public static final Integer ORDERCENTER_STATE_AUDIT_REJECT = 301;
    /**
     * 配送失败
     */
    public static final Integer ORDERCENTER_STATE_FAIL = 302;
    /**
     * 用户取消
     */
    public static final Integer ORDERCENTER_STATE_USERCANCEL = 304;
    /**
     * 后台取消
     */
    public static final Integer ORDERCENTER_STATE_SHOPCANCEL = 305;
    /**
     * 作废
     */
    public static final Integer ORDERCENTER_STATE_DEL = 306;
    /**
     * 已出库
     */
    public static final Integer ORDERCENTER_STATE_OUTSTOCK = 400;
    /**
     * 已发车
     */
    public static final Integer ORDERCENTER_STATE_DISPATCH = 401;
    /**
     * 确认送达
     */
    public static final Integer ORDERCENTER_STATE_CONFIRE = 502;
    /**
     * 已收款
     */
    public static final Integer ORDERCENTER_STATE_RECEIVED = 504;
    /**
     * 已完成
     */
    public static final Integer ORDERCENTER_STATE_COMPLETE = 700;
    /**
     * 待装车
     */
    public static final Integer ORDERCENTER_STATE_WAITLOAD = 220;
    /**
     * 待支付
     */
    public static final Integer ORDERCENTER_STATE_WAITPAY = 201;
    /**
     * 已发货
     */
    public static final Integer ORDERCENTER_STATE_SHIPPED = 402;
    /**
     * 配送中
     */
    public static final Integer ORDERCENTER_STATE_SHIPPING = 409;

    /**
     * 商品特征类型
     */
    public static final Integer FEATURE_TYPE_DAJIAN = 1;
    public static final Integer FEATURE_TYPE_XIAOJIAN = 2;
    public static final Integer FEATURE_TYPE_DANPING = 3;
    public static final Integer FEATURE_TYPE_DRINKING = 4;
    public static final Integer FEATURE_TYPE_REST = 5;
    public static final Integer FEATURE_TYPE_TC = 6;
    public static final Integer FEATURE_TYPE_WAREHOUSE_UNION = 7;
    public static final Integer FEATURE_TYPE_WAREHOUSE_UNION_RETURN = 8;
    public static final Integer FEATURE_TYPE_VIP_FASTDELIVERY = 9;
    public static final Integer FEATURE_TYPE_REFUND_NO_PICKUP = 10;
    public static final Integer FEATURE_TYPE_CONDIMENT = 11;

    /**
     * 支付方式类型
     */
    public static final Integer PAYTYPE_DELIVERY = 0;
    public static final Integer PAYTYPE_WEBCHAT = 1;
    public static final Integer PAYTYPE_ALIPAY = 2;
    public static final Integer PAYTYPE_UNIONPAY = 3;
    public static final Integer PAYTYPE_LIANLIAN = 5;
    public static final Integer PAYTYPE_LOAN = 6;
    public static final Integer PAYTYPE_ALREADY_ONLINE = 10;
    public static final Integer PAYTYPE_OFFLINETRANSFER = 11;
    public static final Integer PAYTYPE_DISTRIBUTOR = 12;
    public static final Integer PAYTYPE_COMBINE_PAY = 113;
    public static final Integer PAYTYPE_NONEED_PAY = 114;
    public static final Integer PAYTYPE_YUE = 13;
    public static final Integer PAYTYPE_99BILL = 14;
    public static final Integer PAYTYPE_BAILING = 15;
    public static final Integer PAYTYPE_ERWEIMA = 21;
    public static final Integer PAYTYPE_ERWEIMA_USER = 22;
    public static final Integer PAYTYPE_ERWEIMA_PAYMENTED_DELIVERY = 23;
    public static final Integer PAYTYPE_OP_ERWEIMA = 17;
    public static final Integer PAYTYPE_LARGETRANSFER = 18;
    public static final Integer PAYTYPE_BAITIAO = 20;
    public static final Integer PAYTYPE_TRANSFER_TO_CORPORATE = 25;
    public static final Integer PAYTYPE_WALLET = 30;
    public static final Integer PAYTYPE_GROUP_PAY = 31;
    public static final Integer PAYTYPE_NO_NEED = 114;

    private SaleOrderDataConstant() {
    }

    public static Integer getOrderCenterState(Integer omsState) {
        switch (omsState) {
            case 1:
                return ORDERCENTER_STATE_ADD;
            case 3:
                return ORDERCENTER_STATE_AUDIT_PASS;
            case 8:
                return ORDERCENTER_STATE_FAIL;
            case 30:
                return ORDERCENTER_STATE_OUTSTOCK;
            case 6:
                return ORDERCENTER_STATE_DISPATCH;
            case 7:
                return ORDERCENTER_STATE_COMPLETE;
            case 0:
                return ORDERCENTER_STATE_ADD;
            case 2:
                return ORDERCENTER_STATE_USERCANCEL;
            case 4:
                return ORDERCENTER_STATE_AUDIT_REJECT;
            case 5:
                return ORDERCENTER_STATE_WORK;
            case 10:
                return ORDERCENTER_STATE_CONFIRE;
            case 14:
                return ORDERCENTER_STATE_DISPATCH;
            case 16:
                return ORDERCENTER_STATE_DEL;
            case 35:
                return ORDERCENTER_STATE_AUDIT_PASS;
            case 11:
                return ORDERCENTER_STATE_ADD;
            case 36:
                return ORDERCENTER_STATE_SHIPPING;
            case 40:
                return ORDERCENTER_STATE_ADD;
            case 20:
                return ORDERCENTER_STATE_COMPLETE;
            default:
        }
        return null;
    }

    public static Integer getOmsState(Integer orderCenterState) {
        switch (orderCenterState) {
            case 200:
                return OMS_STATE_ORDER;
            case 202:
                return OMS_STATE_WAITDELIVERY;
            case 203:
                return OMS_STATE_AUDITOK;
            case 205:
                return OMS_STATE_WAITDELIVERY;
            case 206:
                return OMS_STATE_WAITDELIVERY;
            case 208:
                return OMS_STATE_ORDER;
            case 209:
                return OMS_STATE_ORDER;
            case 302:
                return OMS_STATE_DELIVERYFAILED;
            case 304:
                return OMS_STATE_CANCEL;
            case 305:
                return OMS_STATE_CANCEL;
            case 400:
                return OMS_STATE_OUTSTOCK;
            case 401:
                return OMS_STATE_SHIPPED;
            case 502:
                return OMS_STATE_WAITSETTLEMENT;
            case 504:
                return OMS_STATE_COMPELETE;
            case 700:
                return OMS_STATE_COMPELETE;
            case 220:
                return OMS_STATE_DELAY;
            case 201:
                return OMS_STATE_WAITPAY;
            case 402:
                return OMS_STATE_SHIPPED;
            default:
        }
        return null;
    }

    public static String getFeatureName(Integer featureType) {
        if (FEATURE_TYPE_DAJIAN.equals(featureType)) {
            return "大件";
        } else if (FEATURE_TYPE_XIAOJIAN.equals(featureType)) {
            return "小件";
        } else if (FEATURE_TYPE_DANPING.equals(featureType)) {
            return "单品";
        } else if (FEATURE_TYPE_DRINKING.equals(featureType)) {
            return "酒饮";
        } else if (FEATURE_TYPE_REST.equals(featureType)) {
            return "休食";
        } else if (FEATURE_TYPE_TC.equals(featureType)) {
            return "统采";
        } else if (FEATURE_TYPE_WAREHOUSE_UNION.equals(featureType)) {
            return "联合仓";
        } else if (FEATURE_TYPE_WAREHOUSE_UNION_RETURN.equals(featureType)) {
            return " 联合仓退货";
        } else if (FEATURE_TYPE_VIP_FASTDELIVERY.equals(featureType)) {
            return "闪电送";
        } else if (FEATURE_TYPE_REFUND_NO_PICKUP.equals(featureType)) {
            return "退款不退货";
        } else {
            return FEATURE_TYPE_CONDIMENT.equals(featureType) ? "调味品" : "";
        }
    }

    public static String getPayTypeName(Integer payType) {
        if (PAYTYPE_DELIVERY.equals(payType)) {
            return "货到付款";
        } else if (PAYTYPE_WEBCHAT.equals(payType)) {
            return "微信支付";
        } else if (PAYTYPE_ALIPAY.equals(payType)) {
            return "支付宝支付";
        } else if (PAYTYPE_UNIONPAY.equals(payType)) {
            return "银联支付";
        } else if (PAYTYPE_LIANLIAN.equals(payType)) {
            return "连连支付";
        } else if (PAYTYPE_LOAN.equals(payType)) {
            return "易酒贷";
        } else if (PAYTYPE_OFFLINETRANSFER.equals(payType)) {
            return "线下结算";
        } else if (PAYTYPE_DISTRIBUTOR.equals(payType)) {
            return "经销商收款";
        } else if (PAYTYPE_COMBINE_PAY.equals(payType)) {
            return "多种支付";
        } else if (PAYTYPE_NONEED_PAY.equals(payType)) {
            return "无需支付";
        } else if (PAYTYPE_YUE.equals(payType)) {
            return "余额支付";
        } else if (PAYTYPE_99BILL.equals(payType)) {
            return "快钱支付";
        } else if (PAYTYPE_BAILING.equals(payType)) {
            return "百凌支付";
        } else if (PAYTYPE_ERWEIMA.equals(payType)) {
            return "二维码支付";
        } else if (PAYTYPE_ERWEIMA_USER.equals(payType)) {
            return "用户扫码付";
        } else if (PAYTYPE_ERWEIMA_PAYMENTED_DELIVERY.equals(payType)) {
            return "款到发货";
        } else if (PAYTYPE_LARGETRANSFER.equals(payType)) {
            return "大额转账";
        } else if (PAYTYPE_BAITIAO.equals(payType)) {
            return "白条支付";
        } else if (PAYTYPE_TRANSFER_TO_CORPORATE.equals(payType)) {
            return "对公转账";
        } else if (PAYTYPE_WALLET.equals(payType)) {
            return "钱包支付";
        } else if (PAYTYPE_GROUP_PAY.equals(payType)) {
            return "组合支付";
        } else if (PAYTYPE_ALREADY_ONLINE.equals(payType)) {
            return "已在线支付";
        } else {
            return PAYTYPE_NO_NEED.equals(payType) ? "无需支付" : "";
        }
    }
}
