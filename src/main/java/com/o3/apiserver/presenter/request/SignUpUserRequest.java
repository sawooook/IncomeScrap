package com.o3.apiserver.presenter.request;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import lombok.Data;

@Data
public class SignUpUserRequest {
    public String userId;
    public String password;
    public String name;
    public String regNo;

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
