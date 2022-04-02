package com.o3.apiserver.application.user.dto;

import lombok.Data;

@Data
public class SignUpDto {
    public String userId;
    public String password;
    public String name;
    public String registerNumber;

    public SignUpDto(String userId, String password, String name, String registerNumber) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.registerNumber = registerNumber;
    }
}
