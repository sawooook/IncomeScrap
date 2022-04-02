package com.o3.apiserver.common;

public class CommonResponse<T> {
    private final T data;
    private final String error;
    private final String message;

    public CommonResponse(T data, String error, String message) {
        this.data = data;
        this.error = error;
        this.message = message;
    }


    public static <T> CommonResponse<T> convert(T data) {
        return new CommonResponse<>(data, null, null);
    }

    public static CommonResponse error(String code, String message) {
        return new CommonResponse(null, code, message);
    }

    public static CommonResponse success(String code) {
        return new CommonResponse("OK", null, "OK");
    }
}
