package com.yageum.backend.domain.repository;

import com.yageum.backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}