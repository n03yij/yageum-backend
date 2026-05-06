package com.yageum.backend.domain.controller;

import com.yageum.backend.domain.dto.UserRequestDto;
import com.yageum.backend.domain.entity.User;
import com.yageum.backend.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 유저 추가
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    // 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    // 유저 수정
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}