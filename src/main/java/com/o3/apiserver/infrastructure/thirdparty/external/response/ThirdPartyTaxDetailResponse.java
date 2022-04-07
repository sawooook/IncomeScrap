package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetScrapTaxDetailDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class ThirdPartyTaxDetailResponse {
    @JsonProperty("총사용금액")
    private String totalUseAmount;

    @JsonProperty("소득구분")
    private String incomePayType;

    public GetScrapTaxDetailDto convertDto() {
        return new GetScrapTaxDetailDto(totalUseAmount, incomePayType);
    }
}
