package com.o3.apiserver.infrastructure.user.repository;

import com.o3.apiserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserUniqueId(String userUniqueID);
}
