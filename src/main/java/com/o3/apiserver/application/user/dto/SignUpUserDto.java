package com.o3.apiserver.application.user.dto;

import lombok.Data;

@Data
public class SignUpUserDto {
    private String userUniqueId;
    private String password;
    private String name;
    private String regNo;

    public SignUpUserDto(String userId, String password, String name, String regNo) {
        this.userUniqueId = userId;
        this.password = password;
        this.name = name;
        this.regNo = regNo;
    }
}
