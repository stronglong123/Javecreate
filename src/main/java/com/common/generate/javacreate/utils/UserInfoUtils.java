/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.utils;


import com.common.generate.javacreate.constants.SystemConstant;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.model.user.AdminUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 获取用户信息
 *
 */
@Component
public class UserInfoUtils {
	
    @Resource
    protected RedisTemplate<String, AdminUser> redisTemplate;

    public AdminUser getUserInfo() {
    	Integer userId = UserInfoContext.get();
        if (null == userId) {
            throw new BusinessException("登陆超时，请重新登录！");
        } else {
        	return redisTemplate.opsForValue().get(SystemConstant.USERID_SESSION + userId);
        }
    }
    
    public AdminUser getUser() {
    	Integer userId = UserInfoContext.get();
        if (null != userId) {
        	return redisTemplate.opsForValue().get(SystemConstant.USERID_SESSION + userId);
        }
        AdminUser adminUser = new AdminUser();
        adminUser.setId(1);
        return adminUser;
    }

    public void setUserInfo(AdminUser user) {
    	UserInfoContext.set(user.getId());
    }

    public void removeUserInfo() {
    	UserInfoContext.remove();
    }
}
