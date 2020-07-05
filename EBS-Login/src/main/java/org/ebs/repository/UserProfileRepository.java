package org.ebs.repository;

import org.ebs.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity,String>, CustomUserProfileRepository {
}
