package com.o3.apiserver.common.dto;

import lombok.Getter;

@Getter
public enum ErrorResponseCodeType {
    UNAUTHORIZED("UNAUTHORIZED", "인증이 필요합니다");

    private String code;
    private String message;

    ErrorResponseCodeType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
