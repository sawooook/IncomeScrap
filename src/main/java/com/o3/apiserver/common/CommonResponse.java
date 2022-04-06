package com.o3.apiserver.common;

import com.o3.apiserver.controller.user.response.MyInfoUserResponse;

public class CommonResponse<T> {
    private final T data;
    private final String error;

    public CommonResponse(T data, String error) {
        this.data = data;
        this.error = error;
    }


    public static <T> CommonResponse<MyInfoUserResponse> convert(T data) {
        return new CommonResponse<>(data, null);
    }


    public static CommonResponse<?> success() {
        return new CommonResponse<>("OK", null);
    }

    public static CommonResponse<?> error(String code) {
        return new CommonResponse<> (null, code);
    }
}
