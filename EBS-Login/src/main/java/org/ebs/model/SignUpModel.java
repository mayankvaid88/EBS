package org.ebs.model;

import javax.validation.constraints.NotNull;

public class SignUpModel {

    @NotNull
    private String username;
    @NotNull
    private char[] password;
    @NotNull
    private String confirmPassword;

    public SignUpModel() {
    }

    public SignUpModel(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
