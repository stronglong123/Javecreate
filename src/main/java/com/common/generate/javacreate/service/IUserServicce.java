package com.common.generate.javacreate.service;

import com.common.generate.javacreate.model.user.AdminUser;
import com.common.generate.javacreate.model.user.UserLoginInfoParam;
import org.springframework.stereotype.Service;

/**
 * @author wyf
 * @date 2019/4/1 下午 8:14
 **/
@Service
public interface IUserServicce {

    /**
     * @param userDTO 用户dto实体
     * @author wyf
     * @description 新增用户
     * @date 2019/4/9 上午 11:58
     */
    void insertUser(AdminUser userDTO);

    /**
     * @param user 用户实体
     * @author wyf
     * @description 修改用户
     * @date 2019/4/9 上午 11:56
     */
    void updateUser(AdminUser user);

    /**
     * @param user 实体
     * @author wyf
     * @description 修改密码
     * @date 2019/4/8 上午 10:31
     */
    void updatePassword(AdminUser user);

    /**
     * @param userName 用户登录名
     * @return java.lang.Boolean
     * @author wyf
     * @description 检测用户名是否可用。可用返回true
     * @date 2019/4/8 上午 10:35
     */
    Boolean checkUserName(String userName);

    /**
     * @param id 用户id
     * @return com.yijiupi.himalaya.erp3.platform.domain.model.po.system.User
     * @author wyf
     * @description 根据id获取用户
     * @date 2019/4/8 下午 4:53
     */
    AdminUser getUserById(Long id);

    /**
     * @param loginParam 登录参数
     * @return void
     * @author wyf
     * @description 登录
     * @date 2019/4/13 下午 12:20
     */
    AdminUser configLogin(UserLoginInfoParam loginParam);
}