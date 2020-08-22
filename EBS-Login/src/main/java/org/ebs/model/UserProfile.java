package org.ebs.model;

import org.ebs.enums.RoleE;

import java.io.Serializable;

public class UserProfile implements Serializable {

    private String loginId;
    private String name;
    private RoleE roleE;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleE getRoleE() {
        return roleE;
    }

    public void setRoleE(RoleE roleE) {
        this.roleE = roleE;
    }
}
