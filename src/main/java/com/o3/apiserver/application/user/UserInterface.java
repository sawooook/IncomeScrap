package com.o3.apiserver.application.user;

import com.o3.apiserver.domain.user.User;

import java.util.Optional;

public interface UserInterface {
    Optional<User> findNullableById(long id);

    void isAlreadyRegister(String userUniqueId);

    User save(User user);
}
