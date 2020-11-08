package com.common.generate.javacreate.authutils;

public enum BasicClassType {
	STRING("java.lang.String"), LONG("java.lang.Long"), BOOLEAN("java.lang.Boolean"),
	INTEGER("java.lang.Integer"), DOUBLE("java.lang.Double"), FLOAT("java.lang.Float"),
	BYTE("java.lang.Byte"), SHORT("java.lang.Short"), BIGDECIMAL("java.math.BigDecimal");

	public String type;
	  
	BasicClassType(String type) {
        this.type = type;

    }

	public String getType() {
		return type;
	}
}
