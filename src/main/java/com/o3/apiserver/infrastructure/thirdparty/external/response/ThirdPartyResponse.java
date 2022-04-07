package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetScrapDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThirdPartyResponse {
    @JsonProperty("jsonList")
    private ThirdPartyResultResponse response;

    @JsonProperty("appVer")
    private String appVersion;

    @JsonProperty("hostNm")
    private String hostName;

    @JsonProperty("workerReqDt")
    private LocalDateTime workerRequestDateTime;

    @JsonProperty("workerResDt")
    private LocalDateTime workerResponseDateTime;

    public ThirdPartyResponse() {
    }

    public GetScrapDto convertDto() {
        return new GetScrapDto(response.convertDto(), appVersion, hostName, workerRequestDateTime, workerResponseDateTime);
    }
}
