package com.o3.apiserver.controller.user.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginUserResponse {
    private final String token;

    public static LoginUserResponse convert(String token) {
        return new LoginUserResponse(token);
    }
}
