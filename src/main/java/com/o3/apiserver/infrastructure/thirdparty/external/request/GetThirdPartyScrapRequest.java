package com.o3.apiserver.infrastructure.thirdparty.external.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.infrastructure.thirdparty.adapter.dto.GetThirdPartyScrapDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetThirdPartyScrapRequest {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("regNo")
    private final String registerNumber;

    public static GetThirdPartyScrapRequest convert(GetThirdPartyScrapDto scrapDto) {
        return new GetThirdPartyScrapRequest(scrapDto.getName(), scrapDto.getRegisterNumber());
    }
}
