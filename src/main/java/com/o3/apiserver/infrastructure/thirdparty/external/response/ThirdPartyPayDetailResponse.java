package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetScrapPayDetailDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class ThirdPartyPayDetailResponse {
    @JsonProperty("소득내역")
    private final String incomeHistoryType;

    @JsonProperty("총지급액")
    private final String totalGiveAmount;

    @JsonProperty("업무시작일")
    private final LocalDate workStartedAt;

    @JsonProperty("기업명")
    private final String companyName;

    @JsonProperty("이름")
    private final String name;

    @JsonProperty("지급일")
    private final LocalDate giveAmountAt;

    @JsonProperty("업무종료일")
    private final LocalDate wordEndAt;

    @JsonProperty("주민등록번호")
    private final String registerNumber;

    @JsonProperty("소득구분")
    private final String incomePayType;

    @JsonProperty("사업자등록번호")
    private final String companyRegisterNumber;

    public GetScrapPayDetailDto convertDto() {
        return new GetScrapPayDetailDto(incomeHistoryType, totalGiveAmount, workStartedAt,
                companyName, name, giveAmountAt, wordEndAt, registerNumber, incomePayType, companyRegisterNumber);
    }
}
