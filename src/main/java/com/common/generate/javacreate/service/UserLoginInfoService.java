package com.common.generate.javacreate.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.bl.UserBL;
import com.common.generate.javacreate.constants.SystemConstant;
import com.common.generate.javacreate.model.user.AdminUser;
import com.common.generate.javacreate.model.user.UserLoginInfoParam;
import com.common.generate.javacreate.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 用户
 *
 * @author: tangkun
 * @date: 2018年11月16日 下午4:00:57
 */
@Service
public class UserLoginInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginInfoService.class);

    @Resource
    protected RedisTemplate<String, AdminUser> redisTemplate;
    @Autowired
    private UserBL userBL;

    public AdminUser configLogin(UserLoginInfoParam param) {
        LOGGER.info("登录参数：{}", JSON.toJSONString(param));
        //验证用户名和密码
        AdminUser user = userBL.configLogin(param);
        String token = UUIDUtil.randonUUID();
        user.setToken(token);
//        setLoginToken(token, user);
        return user;
    }


    /**
     * 设置token到redis有效期30分钟.
     *
     * @param token
     * @param userIfo
     */
    public void setLoginToken(String token, AdminUser userIfo) {
        redisTemplate.opsForValue().set(token, userIfo, 30, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(SystemConstant.USERID_SESSION + userIfo.getId(), userIfo, 30, TimeUnit.MINUTES);
    }

    public AdminUser getLoginUserById(String userId) {
        return redisTemplate.opsForValue().get(SystemConstant.USERID_SESSION + userId);
    }

    public void clearUserByToken(String token) {
        AdminUser user = getUserInfoByToken(token);
        redisTemplate.delete(token);
        redisTemplate.delete(SystemConstant.USERID_SESSION + user.getId());

    }

    /**
     * 根据token获取用户id
     *
     * @param token
     * @return
     */
    public AdminUser getUserInfoByToken(String token) {
        return redisTemplate.opsForValue().get(token);
    }
}
