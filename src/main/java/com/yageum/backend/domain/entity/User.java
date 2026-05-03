package com.yageum.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class User {

    @Id
    @Column(name = "id")
    private String id;

    private String email;
    private String password;
    private String nickname;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "monthly_budget")
    private Integer monthlyBudget;

    @Column(name = "joined_at")
    private LocalDate joinedAt;
}