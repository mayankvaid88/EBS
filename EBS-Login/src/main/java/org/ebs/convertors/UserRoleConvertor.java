package org.ebs.convertors;

import org.ebs.enums.RoleE;

import javax.persistence.AttributeConverter;

public class UserRoleConvertor implements AttributeConverter<RoleE, String> {
    @Override
    public String convertToDatabaseColumn(RoleE roleE) {
        return roleE.getRole();
    }

    @Override
    public RoleE convertToEntityAttribute(String s) {
        return RoleE.valueOf(s);
    }
}
