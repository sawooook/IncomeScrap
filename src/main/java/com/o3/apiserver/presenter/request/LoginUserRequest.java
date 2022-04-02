package com.o3.apiserver.presenter.request;

import com.o3.apiserver.application.user.dto.LoginUserDto;
import lombok.Getter;

@Getter
public class LoginUserRequest {
    private String userId;
    private String password;

    public LoginUserDto convertDto() {
        return new LoginUserDto(this.userId, this.password);
    }
}
