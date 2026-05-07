package com.yageum.backend.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyChallengeRequestDto {

    private String month;
    private String title;
    private String category;
    private Integer targetAmount;
    private String description;
}