/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户信息线程本地变量
 *
 * @author fengjiaqian
 */
public class UserInfoContext {
	private UserInfoContext() {}

    private static final ThreadLocal<Integer> THREADLOCAL = new ThreadLocal<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoContext.class);

    public static void set(Integer user) {
        THREADLOCAL.set(user);
    }

    public static void remove() {
    	try {
    		THREADLOCAL.remove();
    	} catch (Exception e) {
    		LOGGER.error("移除用户失败");
    	}
    }

    public static Integer get() {
    	return THREADLOCAL.get();
    }
}
