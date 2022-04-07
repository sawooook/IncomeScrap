package com.o3.apiserver.application.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SignUpUserDto {
    private final String userUniqueId;
    private final String password;
    private final String name;
    private final String regNo;

    public SignUpUserDto(String userId, String password, String name, String regNo) {
        this.userUniqueId = userId;
        this.password = password;
        this.name = name;
        this.regNo = regNo;
    }
}

