package com.o3.apiserver.infrastructure.thirdparty.external;

import com.o3.apiserver.infrastructure.thirdparty.external.request.GetThirdPartyScrapRequest;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ThirdPartyApiPort {
    @POST("/scrap/")
    Call<ThirdPartyResponse> getScrap(@Body GetThirdPartyScrapRequest request);
}
