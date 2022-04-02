package com.o3.apiserver.application.user.dto;

import lombok.Getter;

@Getter
public class LoginUserDto {
    private final String userUniqueId;
    private final String password;

    public LoginUserDto(String userUniqueId, String password) {
        this.userUniqueId = userUniqueId;
        this.password = password;
    }
}
