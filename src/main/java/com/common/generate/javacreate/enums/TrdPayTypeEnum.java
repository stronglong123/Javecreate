package com.common.generate.javacreate.enums;

/**
 * trd支付方式
 *
 * @author xialei
 * @date 2022/2/17 9:59
 */
public enum TrdPayTypeEnum {
    /**
     * 货到付款
     */
    PAYTYPE_DELIVERY("货到付款", 0),
    PAYTYPE_WEBCHAT("微信支付", 1),
    PAYTYPE_ALIPAY("支付宝支付", 2),
    PAYTYPE_UNIONPAY("银联支付", 3),
    PAYTYPE_LIANLIAN("连连支付", 5),
    PAYTYPE_LOAN("易酒贷", 6),
    PAYTYPE_OFFLINETRANSFER("线下结算", 11),
    PAYTYPE_DISTRIBUTOR("经销商收款", 12),
    PAYTYPE_COMBINE_PAY("多种支付", 113),
    PAYTYPE_YUE("余额支付", 13),
    PAYTYPE_99BILL("快钱支付", 14),
    PAYTYPE_BAILING("百凌支付", 15),
    PAYTYPE_ERWEIMA("二维码支付", 21),
    PAYTYPE_ERWEIMA_USER("用户扫码付", 22),
    PAYTYPE_ERWEIMA_PAYMENTED_DELIVERY("款到发货", 23),
    PAYTYPE_LARGETRANSFER("大额转账", 18),
    PAYTYPE_BAITIAO("白条支付", 20),
    PAYTYPE_TRANSFER_TO_CORPORATE("对公转账", 25),
    PAYTYPE_WALLET("钱包支付", 30),
    PAYTYPE_GROUP_PAY("组合支付", 31),
    DIRECT_DISCOUNT_PAY("银行卡转账支付", 32);


    private Integer value;
    private String text;

    TrdPayTypeEnum(String text, Integer value) {
        this.value = value;
        this.text = text;
    }

    public static String getTextByValue(Integer value) {
        if (null == value) {
            return "";
        }
        for (TrdPayTypeEnum bt : values()) {
            if (bt.getValue().equals(value)) {
                return bt.getText();
            }
        }
        return "";
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }
}
