package com.yageum.backend.domain.controller;

import com.yageum.backend.domain.dto.UserChallengeRequestDto;
import com.yageum.backend.domain.entity.UserChallenge;
import com.yageum.backend.domain.service.UserChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-challenges")
public class UserChallengeController {

    private final UserChallengeService userChallengeService;

    @PostMapping
    public ResponseEntity<UserChallenge> createUserChallenge(@RequestBody UserChallengeRequestDto dto) {
        return ResponseEntity.ok(userChallengeService.createUserChallenge(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserChallenge>> getUserChallenges(@PathVariable String userId) {
        return ResponseEntity.ok(userChallengeService.getUserChallenge(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserChallenge> updateUserChallenge(@PathVariable String id, @RequestBody UserChallengeRequestDto dto) {
        return ResponseEntity.ok(userChallengeService.updateUserChallenge(id, dto));
    }
}
