package com.yageum.backend.domain.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class TransactionRequestDto {

    private String userId;
    private String type;
    private String category;
    private Integer amount;
    private LocalDate date;
    private String merchant;
    private String memo;
}