package com.o3.apiserver.application.user;

import com.o3.apiserver.domain.user.User;

public interface UserInterface {
    User findByUserUniqueId(String userUniqueId);

    void isAlreadyRegister(String userUniqueId);

    User save(User user);
}
