package com.o3.apiserver.infrastructure.thirdparty.adapter;

import com.o3.apiserver.application.scrap.port.ThirdPartyDrivenPort;
import com.o3.apiserver.application.scrap.MakeScrapService;
import com.o3.apiserver.infrastructure.thirdparty.adapter.dto.GetThirdPartyScrapDto;
import com.o3.apiserver.infrastructure.thirdparty.external.ThirdPartyApiPort;
import com.o3.apiserver.infrastructure.thirdparty.external.request.GetThirdPartyScrapRequest;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Service
@RequiredArgsConstructor
public class ThirdPartyAdapter implements ThirdPartyDrivenPort {

    private final ThirdPartyApiPort thirdPartyApiPort;
    private final MakeScrapService makeScrapService;


    @Override
    public void getScrap(GetThirdPartyScrapDto scrapDto) {
        Call<ThirdPartyResponse> response =
                thirdPartyApiPort.getScrap(new GetThirdPartyScrapRequest(scrapDto.getName(), scrapDto.getRegisterNumber()));

        response.enqueue(callback());
    }

    private Callback<ThirdPartyResponse> callback() {
        return new Callback<ThirdPartyResponse>() {
            @Override
            public void onResponse(Call<ThirdPartyResponse> call, Response<ThirdPartyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    makeScrapService.make(response.body());
                }
            }

            @Override
            public void onFailure(Call<ThirdPartyResponse> call, Throwable t) {
                // 네트워크 오류시 재시도

            }
        };
    }
}
