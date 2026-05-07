package com.yageum.backend.domain.repository;

import com.yageum.backend.domain.entity.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, String> {
    List<UserChallenge> findByUserId(String userId);
}
