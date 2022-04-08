package com.o3.apiserver.controller.user.request;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class SignUpUserRequest {
    private final String userId;
    private final String password;
    private final String name;
    private final String regNo;

    public SignUpUserDto convertDto() {
        return new SignUpUserDto(this.userId, this.password, this.name, this.regNo);
    }
}
