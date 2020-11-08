package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.model.user.AdminUser;
import com.common.generate.javacreate.model.user.UserLoginInfoParam;
import com.common.generate.javacreate.service.IUserServicce;
import org.springframework.stereotype.Service;

/**
 * @author xialei
 * @date 2020/11/8 17:27
 */
@Service
public class UserServicceImpl implements IUserServicce {
    @Override
    public void insertUser(AdminUser userDTO) {

    }

    @Override
    public void updateUser(AdminUser user) {

    }

    @Override
    public void updatePassword(AdminUser user) {

    }

    @Override
    public Boolean checkUserName(String userName) {
        return null;
    }

    @Override
    public AdminUser getUserById(Long id) {
        return null;
    }

    @Override
    public AdminUser configLogin(UserLoginInfoParam loginParam) {
        return null;
    }
}
