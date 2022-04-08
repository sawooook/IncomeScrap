package com.o3.apiserver.infrastructure.user.adapter;

import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.common.exception.AlreadyRegisterUserException;
import com.o3.apiserver.common.exception.NotFoundDataException;
import com.o3.apiserver.domain.user.User;
import com.o3.apiserver.infrastructure.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAdapter implements UserDrivenPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User findByUserUniqueId(String userUniqueId) {
        return userJpaRepository.findByUserUniqueId(userUniqueId).orElseThrow(() -> {
            throw new NotFoundDataException();
        });
    }

    @Override
    public void isAlreadyRegister(String userUniqueId) {
        Optional<User> user = userJpaRepository.findByUserUniqueId(userUniqueId);
        if (user.isPresent()) {
            throw new AlreadyRegisterUserException();
        }
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }
}
