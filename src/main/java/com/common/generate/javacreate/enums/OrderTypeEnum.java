package com.common.generate.javacreate.enums;

import java.util.Arrays;

/**
 * 单据类型类型（1、销售出、2、销售退、3、结转入、4、结转出、5、差异）
 * 
 * @author liaojiejie
 * @date 2021/03/26
 */
public enum OrderTypeEnum {

	SALE_DELIVER(1, 119, "销售出库", 1),
	SALE_DIRECT_DELIVER(1, 120, "直配销售出库", 1),
	REFUND_STORE(2, 74, "销售退货", 3),
	TF_DELIVER(3, 75, "结转出库", 2),
	TF_STORE(4, 76, "结转入库", 4),
	DIFF(5, -1, "差异调整", 5),
	SETTLE_DELIVER(6, 77, "结算出库", 6),
	SETTLE_STORE(7, 78, "结算入库", 7),
	MORE_STORE(8, 89, "其它入库", 8),
	
	WRITEOFF_DELIVER(9, -1, "冲销出库", 9),
	WRITEOFF_STORE(10, -1, "冲销入库", 10),
	
	MORE_DELIVER(11, 64, "其它出库", 11),
	
	WRITEOFF_MORE_STORE(12, 89, "其它入库", 12),
	WRITEOFF_MORE_DELIVER(13, 64, "其它出库", 13);
	
	private int code;

	private int omsOrderType;

	private String desc;
	
	private int sort;

	private OrderTypeEnum(int code, int omsOrderType, String desc, int sort) {
		this.code = code;
		this.omsOrderType = omsOrderType;
		this.desc = desc;
		this.sort = sort;
	}

	public int getCode() {
		return code;
	}
	
	public int getOmsOrderType() {
		return omsOrderType;
	}

	public String getDesc() {
		return desc;
	}
	
	public int getSort() {
		return sort;
	}

	public byte toCode() {
		return (byte)getCode();
	}
	
	public byte toOmsOrderType() {
		return (byte)getOmsOrderType();
	}

	public static OrderTypeEnum getInstance(Integer code) {
		return Arrays.stream(values()).filter(e -> code != null && e.getCode() == code).findFirst().orElse(null);
	}

	public static OrderTypeEnum getInstance(Byte code) {
		return Arrays.stream(values()).filter(e -> code != null && e.getCode() == code.intValue()).findFirst().orElse(null);
	}

	public static OrderTypeEnum getInstanceByOmsOrderType(Integer omsOrderType) {
		return Arrays.stream(values()).filter(e -> omsOrderType != null && e.getOmsOrderType() == omsOrderType).findFirst().orElse(null);
	}

	public static OrderTypeEnum getInstanceByOmsOrderType(Byte omsOrderType) {
		return Arrays.stream(values()).filter(e -> omsOrderType != null && e.getOmsOrderType() == omsOrderType.intValue()).findFirst().orElse(null);
	}

}
