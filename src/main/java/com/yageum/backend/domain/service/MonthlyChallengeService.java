package com.yageum.backend.domain.service;

import com.yageum.backend.domain.dto.MonthlyChallengeRequestDto;
import com.yageum.backend.domain.entity.MonthlyChallenge;
import com.yageum.backend.domain.repository.MonthlyChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MonthlyChallengeService {
    private final MonthlyChallengeRepository monthlyChallengeRepository;

    // 챌린지 추가
    public MonthlyChallenge createChallenge(MonthlyChallengeRequestDto dto) {
        MonthlyChallenge challenge = MonthlyChallenge.builder()
                .id(UUID.randomUUID().toString())
                .month(dto.getMonth())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .targetAmount(dto.getTargetAmount())
                .description(dto.getDescription())
                .build();

        return monthlyChallengeRepository.save(challenge);
    }

    // 챌린지 조회
    public MonthlyChallenge getChallenge(String id) {
        return monthlyChallengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("챌린지를 찾을 수 없습니다."));
    }

    // 챌린지 수정
    public MonthlyChallenge updateChallenge(String id, MonthlyChallengeRequestDto dto) {
        MonthlyChallenge challenge = monthlyChallengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("챌린지를 찾을 수 없습니다."));

        challenge.setMonth(dto.getMonth());
        challenge.setTitle(dto.getTitle());
        challenge.setCategory(dto.getCategory());
        challenge.setTargetAmount(dto.getTargetAmount());
        challenge.setDescription(dto.getDescription());

        return monthlyChallengeRepository.save(challenge);
    }

    // 챌린지 삭제
    public void deleteChallenge(String id) {
        MonthlyChallenge challenge = monthlyChallengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("챌린지를 찾을 수 없습니다."));

        monthlyChallengeRepository.delete(challenge);
    }
}
