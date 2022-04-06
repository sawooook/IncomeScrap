package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ThirdPartyResultResponse {
    @JsonProperty("scrap002")
    private final List<ThirdPartyTaxDetailResponse> taxDetailResponse;

    @JsonProperty("scrap001")
    private final List<ThirdPartyPayDetailResponse> payDetailResponse;

    @JsonProperty("errMsg")
    private final String errorMessage;

    @JsonProperty("company")
    private final String company;

    @JsonProperty("svcCd")
    private final String scvCd;

    @JsonProperty("userId")
    private final String userId;
}
