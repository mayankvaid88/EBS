package org.ebs.repository;

import org.ebs.entity.UserProfileEntity;

public interface CustomUserProfileRepository {

    public UserProfileEntity findByLoginId(String loginId);

}
