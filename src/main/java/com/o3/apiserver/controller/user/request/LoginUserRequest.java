package com.o3.apiserver.presenter.request;

import com.o3.apiserver.application.user.dto.LoginUserDto;
import lombok.Getter;

@Getter
public class LoginUserRequest {
    private final String userId;
    private final String password;

    public LoginUserRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public LoginUserDto convertDto() {
        return new LoginUserDto(this.userId, this.password);
    }
}
