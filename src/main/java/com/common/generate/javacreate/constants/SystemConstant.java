package com.common.generate.javacreate.constants;

/**
 *
 *
 **/
public class SystemConstant {
	
	private SystemConstant() {}

    /**
     * 状态1正常0冻结/停用-1删除
     */
    public static final int NORMAL_STATUS = 1;
    public static final int DELETE_STATUS = -1;
    public static final int FROZEN_STATUS = 0;
    /**
     *
     * 存入cookie的userId的 key
     */
    public static final String COOKIE_USERID = "userId";
    /**
     * 存入session的用户信息
     */
    public static final String SESSION_USER = "UserInfo";

    /** 用户权限角色缓存前缀*/
    public static final String ROLEORG_PREFIX = "roleorg_";
    
    /** 角色列表缓存前缀*/
    public static final String ROLELIST_PREFIX = "rolelist";
    
    /** 机构树缓存 */
    public static final String ORGTREE_PREFIX = "OrgTrees_";

    /** 图片验证码*/
    public static final String IMAGE_PREFIX = "imageCode_";

    /** 手机验证码*/
    public static final String PHONE_PREFIX = "phoneCode_";

    /** 图片验证码*/
    public static final String AREA_PREFIX = "arealist_";

    /** 图片验证码*/
    public static final String REGISTER_USER = "Register_User_10_minutes";

    /** 注册用户验证码*/
    public static final String REGISTER_PREFIX = "Register_User_";

    public static final String ORDERPHONE_PREFIX = "Order_PhoneCode_";
    
    /** userIdsession标识 */
    public static final String USERID_SESSION = "userId_Session";

    public static final String FORGET_PASSWORD_PREFIX = "Forget_Password_10_Minutes_";

}
