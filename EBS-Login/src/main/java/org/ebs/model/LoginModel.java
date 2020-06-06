package org.ebs.model;

public class LoginModel {

    private String userName;
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
