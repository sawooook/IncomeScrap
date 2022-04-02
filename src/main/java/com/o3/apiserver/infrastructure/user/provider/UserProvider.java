package com.o3.apiserver.infrastructure.user.provider;

import com.o3.apiserver.application.user.UserInterface;
import com.o3.apiserver.domain.user.User;
import com.o3.apiserver.infrastructure.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserProvider implements UserInterface {

    private final UserJpaRepository userJpaRepository;

    public UserProvider(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<User> findNullableById(long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public void isAlreadyRegister(String userUniqueId) {
        Optional<User> user = userJpaRepository.findByUserUniqueId(userUniqueId);
        if (user.isPresent()) {
            throw new IllegalArgumentException("이미 등록된 유저입니다.");
        }
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }
}
