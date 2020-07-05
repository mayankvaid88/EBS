package org.ebs.enums;

public enum RoleE {
    USER("USER"), ADMIN("ADMIN");

    private String role;

    RoleE(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
