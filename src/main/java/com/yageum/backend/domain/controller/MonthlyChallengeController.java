package com.yageum.backend.domain.controller;

import com.yageum.backend.domain.dto.MonthlyChallengeRequestDto;
import com.yageum.backend.domain.entity.MonthlyChallenge;
import com.yageum.backend.domain.service.MonthlyChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/challenges")
public class MonthlyChallengeController {

    private final MonthlyChallengeService challengeService;

    // 챌린지 추가
    @PostMapping
    public ResponseEntity<MonthlyChallenge> createChallenge(@RequestBody MonthlyChallengeRequestDto dto) {
        return ResponseEntity.ok(challengeService.createChallenge(dto));
    }

    // 챌린지 조회
    @GetMapping("/{id}")
    public ResponseEntity<MonthlyChallenge> getChallenge(@PathVariable String id) {
        return ResponseEntity.ok(challengeService.getChallenge(id));
    }

    // 챌린지 수정
    @PutMapping("/{id}")
    public ResponseEntity<MonthlyChallenge> updateChallenge(@PathVariable String id, @RequestBody MonthlyChallengeRequestDto dto) {
        return ResponseEntity.ok(challengeService.updateChallenge(id, dto));
    }

    // 챌린지 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllChallenges(@PathVariable String id) {
        challengeService.deleteChallenge(id);
        return ResponseEntity.noContent().build();
    }
}
