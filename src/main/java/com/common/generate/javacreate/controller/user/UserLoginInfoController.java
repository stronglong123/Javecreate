package com.common.generate.javacreate.controller.user;

import com.common.generate.javacreate.advice.aop.IgnoreAuthInterceptor;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.RetResponse;
import com.common.generate.javacreate.model.user.AdminUser;
import com.common.generate.javacreate.model.user.UserLoginInfoParam;
import com.common.generate.javacreate.service.UserLoginInfoService;
import com.common.generate.javacreate.utils.CookieHelper;
import com.common.generate.javacreate.utils.RedisKeyHelper;
import com.common.generate.javacreate.utils.UserInfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆获取用户信息
 *
 * @author: tangkun
 * @date: 2018年11月16日 下午3:25:34
 */
@RestController
public class UserLoginInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginInfoController.class);

    @Autowired
    private UserLoginInfoService userService;
    @Autowired
    private UserInfoUtils userInfoUtils;

    /**
     * 登录用户新接口
     *
     * @param param
     * @return
     * @throws Exception
     */
    @IgnoreAuthInterceptor
    @PostMapping(value = "/user/loginInfo")
    public Result<AdminUser> queryUserInfo(@RequestBody UserLoginInfoParam param,
										   HttpServletRequest request, HttpServletResponse response) {

        //验证用户名和密码
        return RetResponse.makeOKRsp(userService.configLogin(param));
    }


    /**
     * 清除cookie 如果用户存在
     *
     * @param request
     * @param response
     */
    @PostMapping(value = "/user/clearCookie")
    public void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        /** 检查cookie是否存在，存在则删除之前的缓存信息 */
        String token = request.getHeader("token");
        userService.clearUserByToken(token);
        userInfoUtils.removeUserInfo();// 清除用户线程信息
    }
}
