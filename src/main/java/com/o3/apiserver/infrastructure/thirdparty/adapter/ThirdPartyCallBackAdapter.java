package com.o3.apiserver.infrastructure.thirdparty.adapter;

import com.o3.apiserver.application.scrap.MakeScrapService;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ThirdPartyCallBackAdapter {

    private final MakeScrapService makeScrapService;

    public Callback<ThirdPartyResponse> callback() {
        return new Callback<ThirdPartyResponse>() {
            @Override
            public void onResponse(Call<ThirdPartyResponse> call, Response<ThirdPartyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    makeScrapService.make(response.body().convertDto());
                }
            }

            // 네트워크 환경문제로 데이터 가져오는부분이 실패 할 수 있으니 한번 더 재시도를 함
            @Override
            public void onFailure(Call<ThirdPartyResponse> call, Throwable t) {

                call.clone().enqueue(new Callback<ThirdPartyResponse>() {
                    @Override
                    public void onResponse(Call<ThirdPartyResponse> call, Response<ThirdPartyResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            makeScrapService.make(response.body().convertDto());
                        }
                    }

                    @Override
                    public void onFailure(Call<ThirdPartyResponse> call, Throwable t) {
                        log.error("[NETWORK ERROR] 네트워크 오류로 인해");
                    }
                });
            }
        };
    }
}
