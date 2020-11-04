package com.common.generate.javacreate.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xialei
 * @date 2020/6/4 16:35
 */
public class NoGeneratorUtil {

	private static final String DATE_FORMAT_YMD = "yyyyMMddHHmmss";

	private static final String REDIS_INSTOCK_ORDER_NO_KEY_PREFIX = "supf:transferNote:NOGenerator-%s%s";

	/**
	 * 创建调拨单号
	 * @return
	 */
	public static String createNO(String pre) {
		String dateFormat = DateFormatUtils.format(new Date(), DATE_FORMAT_YMD);
		// 通用单号
		StringBuilder commOrderNO = new StringBuilder();
		commOrderNO.append(pre).append(dateFormat);
//		// 缓存KEY
//		String redisKey = String.format(REDIS_INSTOCK_ORDER_NO_KEY_PREFIX, cityId, dateFormat);
//		// 直接KEY
//		redisTemplate.opsForValue().setIfAbsent(redisKey, 0);
//		// 设置过期时间
//		redisTemplate.expire(redisKey, 1, TimeUnit.DAYS);
//		// 调用 increment
//		String increaseNumStr = new DecimalFormat("0000").format(redisTemplate.opsForValue().increment(redisKey, 1));
//		return commOrderNO.append(increaseNumStr).toString();

		return commOrderNO.toString();
	}


}
