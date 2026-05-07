package com.yageum.backend.domain.repository;

import com.yageum.backend.domain.entity.MonthlyChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyChallengeRepository extends JpaRepository<MonthlyChallenge, String> {
}
