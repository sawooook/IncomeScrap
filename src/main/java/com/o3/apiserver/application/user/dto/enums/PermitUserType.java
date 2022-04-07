package com.o3.apiserver.application.user.dto.enums;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PermitUserType {


    REGISTER_A("1", "홍길동", "860824-1655068"),
    REGISTER_B("2", "김둘리", "921108-1582816"),
    REGISTER_C("3", "마징가", "880601-2455116"),
    REGISTER_D("4", "배지터", "910411-1655068"),
    REGISTER_E("5", "손오공", "820326-2715702");


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
