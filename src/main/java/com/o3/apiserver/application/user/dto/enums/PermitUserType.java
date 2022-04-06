package com.o3.apiserver.application.user.dto.enums;

public enum PermitUserType {


    REGISTER_A("2", "홍길동", "860824-1655068"),
    REGISTER_B("3", "김둘리", "860824-1655068"),
    REGISTER_C("4", "마징가", "860824-1655068"),
    REGISTER_D("5", "배지터", "860824-1655068"),
    REGISTER_E("6", "손오공", "860824-1655068");


    private final String userUniqueId;
    private final String name;
    private final String registerNumber;


    PermitUserType(String userUniqueId, String name, String registerNumber) {
        this.userUniqueId = userUniqueId;
        this.name = name;
        this.registerNumber = registerNumber;
    }
//
//    public boolean isPermitUser(SignUpUserDto signUpUserDto, PermitUserType type) {
//        if (type.name.equals(signUpUserDto.getName())
//                && (type.userUniqueId.equals(signUpUserDto.getUserId())
//                && (type.registerNumber.equals(signUpUserDto.getRegNo())))
//        ) {
//
//        }
//    }
}
