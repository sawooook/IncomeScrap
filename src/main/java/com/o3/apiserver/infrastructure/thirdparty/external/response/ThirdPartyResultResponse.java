package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetScrapPayDetailDto;
import com.o3.apiserver.application.scrap.dto.GetScrapResultDto;
import com.o3.apiserver.application.scrap.dto.GetScrapTaxDetailDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
    private final String svcCd;

    @JsonProperty("userId")
    private final String userId;

    public GetScrapResultDto convertDto() {
        List<GetScrapTaxDetailDto> taxDetail = taxDetailResponse.stream()
                .map(ThirdPartyTaxDetailResponse::convertDto)
                .collect(Collectors.toList());

        List<GetScrapPayDetailDto> payDetail = payDetailResponse.stream()
                .map(ThirdPartyPayDetailResponse::convertDto)
                .collect(Collectors.toList());

        return new GetScrapResultDto(taxDetail, payDetail, errorMessage, company, svcCd, userId);
    }
}
