package com.o3.apiserver.controller.user.request;

import com.o3.apiserver.application.user.dto.LoginUserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginUserRequest {
    private final String userId;
    private final String password;

    public LoginUserDto convertDto() {
        return new LoginUserDto(this.userId, this.password);
    }
}
