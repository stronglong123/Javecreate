package com.common.generate.javacreate.model.user;

import com.common.generate.javacreate.model.base.search.PageCondition;

import java.io.Serializable;
import java.util.Date;

/*********************************************
 * ClassName: AdminUser
 * @Description: 酒批运营用户
 * @author
 *********************************************/
public class UserQueryDTO extends PageCondition implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1132234046933466553L;
    /**
     * 主键编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 姓名
     */
    private String trueName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 性别
     */
    private String gender;
    /**
     * 状态 1正常 0冻结/停用 -1删除
     */
    private Integer state;
    /**
     * 用户最后登陆时间
     */
    private Date lastLoginTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者Id
     */
    private Integer createUser;
    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;
    /**
     * 修改人Id
     */
    private Integer lastUpdateUser;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 入职时间
     */
    private Date hiredate;
    /**
     * 离职时间
     */
    private Date leaveDate;
    /**
     * 最后更改密码的时间
     */
    private Date lastChangePasswordTime;
    /**
     * 联系电话
     */
    private String contactNumber;
    /**
     * 身份证信息
     */
    private String idCard;
    /**
     * 人员类型
     */
    private Integer employeeType;
    /**
     * 人员类型名称
     */
    private String employeeTypeName;

    private String token;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Date getLastChangePasswordTime() {
        return lastChangePasswordTime;
    }

    public void setLastChangePasswordTime(Date lastChangePasswordTime) {
        this.lastChangePasswordTime = lastChangePasswordTime;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(Integer lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }


}
