package com.o3.apiserver.application.user.dto.enums;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PermitUserType {


    REGISTER_A("2", "홍길동", "860824-1655068"),
    REGISTER_B("3", "김둘리", "860824-1655068"),
    REGISTER_C("4", "마징가", "860824-1655068"),
    REGISTER_D("5", "배지터", "860824-1655068"),
    REGISTER_E("6", "손오공", "860824-1655068");


    private final String userUniqueId;
    private final String name;
    private final String registerNumber;


    public boolean isPermit(SignUpUserDto signUpUserDto) {
        if (userUniqueId.equals(signUpUserDto.getUserUniqueId())
                && name.equals(signUpUserDto.getName())
                && registerNumber.equals(signUpUserDto.getRegNo())
        ) {
            return true;
        }

        return false;
    }
}
