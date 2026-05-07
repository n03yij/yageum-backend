package com.yageum.backend.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChallengeRequestDto {

    private String userId;
    private String monthlyChallengeId;
    private String status;
    private Integer spentAmount;
    private Integer savedAmount;
}
