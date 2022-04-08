package com.o3.apiserver.controller.user.response;

import com.o3.apiserver.common.dto.LoginAuthUserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MyInfoUserResponse {
    private final String userId;
    private final String name;

    public static MyInfoUserResponse convert(LoginAuthUserDto loginAuthUserDto) {
        return new MyInfoUserResponse(loginAuthUserDto.getUserUniqueId(), loginAuthUserDto.getName());
    }
}
