package com.o3.apiserver.infrastructure.thirdparty.adapter;

import com.o3.apiserver.application.scrap.port.ThirdPartyDrivenPort;
import com.o3.apiserver.infrastructure.thirdparty.adapter.dto.GetThirdPartyScrapDto;
import com.o3.apiserver.infrastructure.thirdparty.external.ThirdPartyApiPort;
import com.o3.apiserver.infrastructure.thirdparty.external.request.GetThirdPartyScrapRequest;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;

@Service
@RequiredArgsConstructor
public class ThirdPartyAdapter implements ThirdPartyDrivenPort {

    private final ThirdPartyCallBackAdapter thirdPartyCallBackAdapter;
    private final ThirdPartyApiPort thirdPartyApiPort;

    @Override
    public void getScrap(GetThirdPartyScrapDto scrapDto) {
        Call<ThirdPartyResponse> response =
                thirdPartyApiPort.getScrap(GetThirdPartyScrapRequest.convert(scrapDto));

        response.enqueue(thirdPartyCallBackAdapter.callback());
    }
}
