package com.yageum.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monthly_challenge")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyChallenge {

    @Id
    @Column(name = "id")
    private String id;

    private String month;
    private String title;
    private String category;

    @Column(name = "target_amount")
    private Integer targetAmount;

    @Column(columnDefinition = "TEXT")
    private String description;
}
