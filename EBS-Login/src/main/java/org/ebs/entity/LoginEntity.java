package org.ebs.entity;

import org.ebs.enums.RoleE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "LOGIN_TABLE")
@Entity
public class LoginEntity {

    @Id
    @Column(name = "login_id")
    private String userName;
    @Column(name = "password")
    private String password;

    public LoginEntity() {}

    public LoginEntity(String userName, String password, RoleE roleE) {
        this.userName = userName;
        this.password = password;
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
}
