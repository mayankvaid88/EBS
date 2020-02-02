package org.ebs.entity;

import org.ebs.convertors.UserRoleConvertor;
import org.ebs.enums.UserRoleE;

import javax.persistence.*;

@Table(name = "LOGIN_TABLE")
@Entity
public class LoginEntity {

    @Id
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    @Convert(converter = UserRoleConvertor.class)
    private UserRoleE userRoleE;

    public LoginEntity() {}

    public LoginEntity(String userName, String password, UserRoleE userRoleE) {
        this.userName = userName;
        this.password = password;
        this.userRoleE = userRoleE;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleE getUserRoleE() {
        return userRoleE;
    }

    public void setUserRoleE(UserRoleE userRoleE) {
        this.userRoleE = userRoleE;
    }
}
