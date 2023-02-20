package com.common.generate.javacreate.service.impl.es.base;

import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.io.Serializable;
import java.util.Map;

/**
 * 订单明细扩展信息
 * 
 * @author Hu Liangzhi
 *
 */
public class OrderExtItemDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;
	
	/**
	 * 订单明细扩展信息
	 */
	@ApiParam(description = "订单明细扩展信息")
	private Map<String, Object> ext;

	public Map<String, Object> getExt() {
		return ext;
	}

	public void setExt(Map<String, Object> ext) {
		this.ext = ext;
	}
}
