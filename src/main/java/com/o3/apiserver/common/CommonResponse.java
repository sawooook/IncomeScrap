package com.o3.apiserver.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonResponse<T> {
    private final T data;
    private final String error;



    public static <T> CommonResponse<T> convert(T data) {
        return new CommonResponse<T>(data, null);
    }


    public static CommonResponse<?> success() {
        return new CommonResponse<>("OK", null);
    }

    public static CommonResponse<?> error(String code) {
        return new CommonResponse<> (null, code);
    }
}
