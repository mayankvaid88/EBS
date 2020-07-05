package org.ebs.model;

import javax.validation.constraints.NotNull;

public class SignUpModel {

    @NotNull
    private String username;
    @NotNull
    private char[] password;
    @NotNull
    private char[] confirmPassword;

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

    public char[] getConfirmPassword() {
        return confirmPassword;
    }
}
