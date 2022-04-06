package com.o3.apiserver.infrastructure.thirdparty.client;

import com.o3.apiserver.common.util.RetrofitBuilder;
import com.o3.apiserver.infrastructure.thirdparty.external.ThirdPartyApiPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
public class ThirdPartyRetrofitConfig {

    @Value("${external.url}")
    private String thirdPartyUrl;

    @Bean
    public ThirdPartyApiPort thirdPartyClient() {
        Retrofit retrofit = RetrofitBuilder.create(21, 3)
                .baseUrl(thirdPartyUrl).build();
        return retrofit.create(ThirdPartyApiPort.class);
    }
}
