package com.yageum.backend.domain.service;

import com.yageum.backend.domain.dto.UserChallengeRequestDto;
import com.yageum.backend.domain.entity.MonthlyChallenge;
import com.yageum.backend.domain.entity.User;
import com.yageum.backend.domain.entity.UserChallenge;
import com.yageum.backend.domain.repository.MonthlyChallengeRepository;
import com.yageum.backend.domain.repository.UserChallengeRepository;
import com.yageum.backend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserChallengeService {
    private final UserChallengeRepository userChallengeRepository;
    private final UserRepository userRepository;
    private final MonthlyChallengeRepository monthlyChallengeRepository;

    // 챌린지 참여
    public UserChallenge createUserChallenge(UserChallengeRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        MonthlyChallenge monthlyChallenge = monthlyChallengeRepository.findById(dto.getMonthlyChallengeId())
                .orElseThrow(() -> new RuntimeException("챌린지를 찾을 수 없습니다."));

        UserChallenge userChallenge = UserChallenge.builder()
                .id(UUID.randomUUID().toString())
                .user(user)
                .monthlyChallenge(monthlyChallenge)
                .status("active")
                .spentAmount(0)
                .savedAmount(0)
                .build();

        return userChallengeRepository.save(userChallenge);
    }

    // 내 챌린지 목록 조회 (userId로)
    public List<UserChallenge> getUserChallenge(String userId) {
        return userChallengeRepository.findByUserId(userId);
    }

    // 챌린지 상태/금액 업데이트 (active→success/fail)
    public UserChallenge updateUserChallenge(String id, UserChallengeRequestDto dto) {
        UserChallenge userChallenge = userChallengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("챌린지를 찾을 수 없습니다."));

        userChallenge.setStatus(dto.getStatus());
        userChallenge.setSpentAmount(dto.getSpentAmount());
        userChallenge.setSavedAmount(dto.getSavedAmount());

        return userChallengeRepository.save(userChallenge);
    }
}
