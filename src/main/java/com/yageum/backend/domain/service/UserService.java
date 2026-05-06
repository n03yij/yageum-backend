package com.yageum.backend.domain.service;

import com.yageum.backend.domain.dto.UserRequestDto;
import com.yageum.backend.domain.entity.User;
import com.yageum.backend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 추가
    public User createUser(UserRequestDto dto) {
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .profileImage(dto.getProfileImage())
                .monthlyBudget(dto.getMonthlyBudget())
                .joinedAt(dto.getJoinedAt())
                .build();

        return userRepository.save(user);
    }

    // 유저 조회
    public User getUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
    }

    // 유저 수정
    public User updateUser(String id, UserRequestDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        user.setEmail(dto.getEmail());
        user.setNickname(dto.getNickname());
        user.setProfileImage(dto.getProfileImage());
        user.setMonthlyBudget(dto.getMonthlyBudget());

        return userRepository.save(user);
    }

    // 유저 삭제
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        userRepository.delete(user);
    }
}