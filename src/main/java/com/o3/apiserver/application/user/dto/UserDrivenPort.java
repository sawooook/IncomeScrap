package com.o3.apiserver.application.port;

import com.o3.apiserver.domain.user.User;

public interface UserDrivenPort {
    User findByUserUniqueId(String userUniqueId);

    void isAlreadyRegister(String userUniqueId);

    User save(User user);
}
