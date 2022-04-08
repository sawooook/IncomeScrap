package com.o3.apiserver.common.exception;

public class NotFoundScrapDataException extends RuntimeException{
    public NotFoundScrapDataException() {
        super("스크랩 데이터가 존재하지 않습니다.");
    }
}
