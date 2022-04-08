package com.o3.apiserver.common.exception;

public class AlreadyRegisterUserException extends RuntimeException {
    public AlreadyRegisterUserException() {
        super("이미등록된 유저입니다");
    }
}
