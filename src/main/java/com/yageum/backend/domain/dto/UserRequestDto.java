package com.yageum.backend.domain.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserRequestDto {

    private String email;
    private String password;
    private String nickname;
    private String profileImage;
    private Integer monthlyBudget; // 월 예산
    private LocalDate joinedAt;
}