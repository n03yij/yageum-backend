package com.yageum.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_challenges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChallenge {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_challenge_id")
    private MonthlyChallenge monthlyChallenge;

    private String status;

    @Column(name = "spent_amount")
    private Integer spentAmount;

    @Column(name = "saved_amount")
    private Integer savedAmount;
}
