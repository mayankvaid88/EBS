package org.ebs.enums;

public enum UserRoleE {
    USER("USER"), ADMIN("ADMIN"), DBA("DBA");

    private String role;

    UserRoleE(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
