package org.ebs.model;

import javax.validation.constraints.NotEmpty;

public class LoginModel {

    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;

    public LoginModel() {

    }

    public LoginModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
