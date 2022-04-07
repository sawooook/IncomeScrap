package com.o3.apiserver.controller.user.request;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import lombok.Getter;


@Getter
public class SignUpUserRequest {
    public String userUniqueId;
    public String password;
    public String name;
    public String regNo;

    public SignUpUserRequest(String userId, String password, String name, String regNo) {
        this.userUniqueId = userId;
        this.password = password;
        this.name = name;
        this.regNo = regNo;
    }

    public SignUpUserDto convertDto() {
        return new SignUpUserDto(this.userUniqueId, this.password, this.name, this.regNo);
    }
}
