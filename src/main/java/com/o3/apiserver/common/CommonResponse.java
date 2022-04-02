package com.o3.apiserver.common;

public class CommonResponse<T> {
    private T data;
    private String error;
    private String message;

    public CommonResponse(T data, String error, String message) {
        this.data = data;
        this.error = error;
        this.message = message;
    }


    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(data, null, null);
    }
}
