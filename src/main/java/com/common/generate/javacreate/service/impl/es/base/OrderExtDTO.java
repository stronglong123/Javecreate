package com.common.generate.javacreate.service.impl.es.base;

import java.io.Serializable;
import java.util.Map;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

/**
 * 订单扩展信息
 * 
 * @author Hu Liangzhi
 *
 */
@ApiModel(description = "订单扩展信息")
public class OrderExtDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;
	
	/**
	 * 订单扩展信息
	 */

	private String ext;

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}


	//	@ApiParam(description = "订单扩展信息")
//	private Map<String, Object> ext;
//
//	public Map<String, Object> getExt() {
//		return ext;
//	}
//
//	public void setExt(Map<String, Object> ext) {
//		this.ext = ext;
//	}
}
