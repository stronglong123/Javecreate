package com.common.generate.javacreate.bl;

import com.common.generate.javacreate.constants.SystemConstant;
import com.common.generate.javacreate.dao.AdminUserMapper;
import com.common.generate.javacreate.enums.BusinessCodeEnum;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.model.user.AdminUser;
import com.common.generate.javacreate.model.user.UserLoginInfoParam;
import com.common.generate.javacreate.model.user.UserQueryDTO;
import com.common.generate.javacreate.utils.Md5Utils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author xialei
 * @date 2020-11-08
 */
@Service
public class UserBL {
    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser detail(Long id) {
        return adminUserMapper.detail(id);
    }

    public PageList<AdminUser> pageList(UserQueryDTO adminUser) {
        PageHelper.startPage(adminUser.getPageNum(), adminUser.getPageSize());
        List<AdminUser> list = adminUserMapper.list(adminUser);
        return new PageList<>(list);
    }

    public List<AdminUser> list(UserQueryDTO adminUser) {
        return adminUserMapper.list(adminUser);
    }

    @Transactional
    public void insert(AdminUser adminUser) {
        adminUser.setPassword(Md5Utils.encrytMD5(adminUser.getPassword()));
        adminUserMapper.insert(adminUser);
    }

    @Transactional
    public void update(AdminUser adminUser) {
        adminUserMapper.update(adminUser);
    }

    @Transactional
    public void delete(AdminUser adminUser) {
        adminUserMapper.delete(adminUser);
    }

    /**
     * @param loginParam 登录参数
     * @return void
     * @author wyf
     * @description 登录
     * @date 2019/4/13 下午 12:20
     */
    public AdminUser configLogin(UserLoginInfoParam loginParam) {
        String phoneNum = loginParam.getUserName();
        String password = loginParam.getPassword();
        //查询账号是否存在
        AdminUser user = adminUserMapper.getUserByPhoneNum(phoneNum);
        return extractCode(user, password);
    }

    /**
     * 验证密码是否正确
     *
     * @author wyf
     * @description 抽出的公用方法
     */
    private AdminUser extractCode(AdminUser user, String password) {
//        if (ObjectUtils.isNotEmpty(user)) {
//            if (user.getState() != SystemConstant.NORMAL_STATUS) {
//                throw new BusinessException(BusinessCodeEnum.LOCKED_ACCOUNT.getText(), BusinessCodeEnum.LOCKED_ACCOUNT.getCode());
//            }
//            String md5Password = Md5Utils.encrytMD5(password);
//            if (Objects.equals(md5Password, user.getPassword())) {
//                return user;
//            } else {
//                throw new BusinessException(BusinessCodeEnum.LOGIN_ERROR.getText(), BusinessCodeEnum.LOGIN_ERROR.getCode());
//            }
//        } else {
//            throw new BusinessException(BusinessCodeEnum.USER_IS_NULL.getText(), BusinessCodeEnum.USER_IS_NULL.getCode());
//        }
        return null;
    }

}
