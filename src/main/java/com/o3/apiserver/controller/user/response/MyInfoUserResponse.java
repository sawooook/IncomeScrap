package com.o3.apiserver.controller.user.response;

import com.o3.apiserver.common.dto.LoginAuthUserDto;

public class MyInfoUserResponse {
    private final String userId;
    private final String name;
    private final String registerNumber;

    public MyInfoUserResponse(String userId, String name, String registerNumber) {
        this.userId = userId;
        this.name = name;
        this.registerNumber = registerNumber;
    }

    public static MyInfoUserResponse convert(LoginAuthUserDto loginAuthUserDto) {
        return new MyInfoUserResponse(loginAuthUserDto.getUserUniqueId(), loginAuthUserDto.getName(), loginAuthUserDto.getRegisterNumber());
    }
}
