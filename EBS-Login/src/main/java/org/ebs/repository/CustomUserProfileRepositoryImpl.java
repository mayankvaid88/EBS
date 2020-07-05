package org.ebs.repository;

import org.ebs.entity.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CustomUserProfileRepositoryImpl implements CustomUserProfileRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserProfileEntity findByLoginId(String loginId) {
        return (UserProfileEntity) entityManager.
                createNamedQuery("UserProfile.findByLoginId").
                setParameter("loginId", loginId).getSingleResult();
    }
}
