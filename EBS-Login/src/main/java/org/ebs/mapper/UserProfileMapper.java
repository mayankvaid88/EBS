package org.ebs.mapper;

import org.ebs.entity.UserProfileEntity;
import org.ebs.model.UserProfile;
import org.springframework.beans.BeanUtils;

public class UserProfileMapper {

    public static final UserProfile MapUserProfileEntityToModel(UserProfileEntity userProfileEntity) {
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileEntity, userProfile);
        return userProfile;
    }
}
