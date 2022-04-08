package com.o3.apiserver.common.exception;

public class NotFoundDataException extends RuntimeException{
    public NotFoundDataException() {
        super("해당 정보를 찾을 수 없습니다");
    }
}
