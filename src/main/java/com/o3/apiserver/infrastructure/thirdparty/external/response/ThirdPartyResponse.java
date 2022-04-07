package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetScrapDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ThirdPartyResponse {
    @JsonProperty("jsonList")
    private final ThirdPartyResultResponse response;

    @JsonProperty("appVer")
    private final String appVersion;

    @JsonProperty("hostNm")
    private final String hostName;

    @JsonProperty("workerReqDt")
    private final LocalDateTime workerRequestDateTime;

    @JsonProperty("workerResDt")
    private final LocalDateTime workerResponseDateTime;

    public GetScrapDto convertDto() {
        return new GetScrapDto(
                response.convertDto(), appVersion, hostName, workerRequestDateTime, workerRequestDateTime
        );
    }
}
