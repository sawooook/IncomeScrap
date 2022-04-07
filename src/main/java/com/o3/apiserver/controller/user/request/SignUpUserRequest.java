package com.o3.apiserver.controller.user.request;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public class SignUpUserRequest {
    private final String userId;
    private final String password;
    private final String name;
    private final String regNo;


    public SignUpUserRequest(String userId, String password, String name, String regNo) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.regNo = regNo;
    }

    public SignUpUserDto convertDto() {
        return new SignUpUserDto(this.userId, this.password, this.name, this.regNo);
    }
}
