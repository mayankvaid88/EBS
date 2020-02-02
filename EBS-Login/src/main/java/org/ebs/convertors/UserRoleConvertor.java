package org.ebs.convertors;

import org.ebs.enums.UserRoleE;

import javax.persistence.AttributeConverter;

public class UserRoleConvertor implements AttributeConverter<UserRoleE, String> {
    @Override
    public String convertToDatabaseColumn(UserRoleE userRoleE) {
        return userRoleE.getRole();
    }

    @Override
    public UserRoleE convertToEntityAttribute(String s) {
        return UserRoleE.valueOf(s);
    }
}
