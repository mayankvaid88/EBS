package org.ebs.service;

import org.ebs.entity.UserProfileEntity;
import org.ebs.exception.UserProfileNotFoundException;
import org.ebs.mapper.UserProfileMapper;
import org.ebs.model.UserProfile;
import org.ebs.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Cacheable(value = "userProfile", key = "#loginId")
    public UserProfile getUserProfile(String loginId) throws UserProfileNotFoundException {
        UserProfileEntity userProfile = userProfileRepository.findByLoginId(loginId);
        if (userProfile == null) {
            throw new UserProfileNotFoundException();
        }
        return UserProfileMapper.MapUserProfileEntityToModel(userProfile);
    }
}
