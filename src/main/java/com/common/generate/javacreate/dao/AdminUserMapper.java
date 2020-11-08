package com.common.generate.javacreate.dao;

import com.common.generate.javacreate.model.base.PageResult;
import com.common.generate.javacreate.model.user.AdminUser;
import com.common.generate.javacreate.model.user.UserLoginInfoParam;

import java.util.List;

/**
 * @author xialei
 * @date 2020-11-08
 */
public interface AdminUserMapper {

    AdminUser detail(Long id);

    PageResult<AdminUser> pageList(AdminUser adminUser);

     List<AdminUser> list(AdminUser adminUser);

     int insert(AdminUser adminUser);

    int insertBatch(List<AdminUser> adminUsers);

    int update(AdminUser adminUser);

    int delete(AdminUser adminUser);

    /**
     * 根据手机号查询用户
     * @author wyf
     * @param phoneNum 用户名
     * @return com.yijiupi.himalaya.erp3.platform.domain.model.po.system.User
     */
    AdminUser getUserByPhoneNum(String phoneNum);

    /**
     * 根据用户名查询用户
     * @author wyf
     * @param userName 用户名
     * @return com.yijiupi.himalaya.erp3.platform.domain.model.po.system.User
     */
    AdminUser getUserByUserName(String userName);



}