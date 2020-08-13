/*********************************************
 * ClassName: UUIDUtil
 * Description: id生成工具类
 * @date
 *********************************************/

/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */

package com.common.generate.javacreate.utils;

import java.util.UUID;

public class UUIDUtil {
    private UUIDUtil() {
        super();
    }

    public static Long randonUUID() {
        return UUID.randomUUID().getLeastSignificantBits() * -1;
    }

    public static Long getUuid(){
       return SnowflakeComponent.getInstance().nextId();
    }

}
