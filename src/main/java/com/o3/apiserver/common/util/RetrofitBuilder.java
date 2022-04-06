package com.o3.apiserver.common.util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitBuilder {

    public static Retrofit.Builder create(int readTimeOut, int connectionTimeOut) {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .readTimeout(readTimeOut, TimeUnit.SECONDS)
                .connectTimeout(connectionTimeOut, TimeUnit.SECONDS);

        OkHttpClient build = client.build();

        return new Retrofit.Builder()
                .addConverterFactory(
                        JacksonConverterFactory.create()
                ).client(build);
    }
}
