package com.o3.apiserver.common.exception;

public class InValidTokenException extends RuntimeException {
    public InValidTokenException() {
        super("토큰 생성 오류가 발생하였습니다");
    }
}
