package com.o3.apiserver.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitBuilder {

    public static Retrofit create(int readTimeOut, int connectionTimeOut, String thirdPartyUrl) {


        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .readTimeout(readTimeOut, TimeUnit.SECONDS)

                .connectTimeout(connectionTimeOut, TimeUnit.SECONDS);

        OkHttpClient build = client.build();

        return new Retrofit.Builder()
                .baseUrl(thirdPartyUrl)
                .addConverterFactory(
                        JacksonConverterFactory.create(new ObjectMapper().registerModule(new JavaTimeModule()))
                ).client(build)
                .build();
    }
}
