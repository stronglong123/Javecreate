package com.common.generate.javacreate.study;

/**
 * @author xialei
 * @date 2023/5/22 18:01
 */
public class UserDTO {

    public UserDTO(Long id) {
        this.id = id;
    }

    private Long id;

    private UserDTO parentUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getParentUser() {
        return parentUser;
    }

    public void setParentUser(UserDTO parentUser) {
        this.parentUser = parentUser;
    }
}
