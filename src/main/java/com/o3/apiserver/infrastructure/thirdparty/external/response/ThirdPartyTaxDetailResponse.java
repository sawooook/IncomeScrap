package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetScrapTaxDetailDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ThirdPartyTaxDetailResponse {
    @JsonProperty("총사용금액")
    private final String totalUseAmount;

    @JsonProperty("소득구분")
    private final String incomePayType;

    public GetScrapTaxDetailDto convertDto() {
        return new GetScrapTaxDetailDto(totalUseAmount, incomePayType);
    }
}
