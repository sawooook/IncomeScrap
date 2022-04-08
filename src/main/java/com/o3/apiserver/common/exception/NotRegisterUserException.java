package com.o3.apiserver.common.exception;

public class NotRegisterUserException extends RuntimeException {
    public NotRegisterUserException() {
        super("회원가입 할 수 없는 유저입니다");
    }
}
