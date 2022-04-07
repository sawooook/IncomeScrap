package com.o3.apiserver.infrastructure.thirdparty.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetScrapPayDetailDto;
import com.o3.apiserver.common.util.TimeConvertUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ThirdPartyPayDetailResponse {
    @JsonProperty("소득내역")
    private String incomeHistoryType;

    @JsonProperty("총지급액")
    private String totalGiveAmount;

    @JsonProperty("업무시작일")
    private String workStartedAt;

    @JsonProperty("기업명")
    private String companyName;

    @JsonProperty("이름")
    private String name;

    @JsonProperty("지급일")
    private String giveAmountAt;

    @JsonProperty("업무종료일")
    private String wordEndAt;

    @JsonProperty("주민등록번호")
    private String registerNumber;

    @JsonProperty("소득구분")
    private String incomePayType;

    @JsonProperty("사업자등록번호")
    private String companyRegisterNumber;

    public GetScrapPayDetailDto convertDto() {
        return new GetScrapPayDetailDto(incomeHistoryType, totalGiveAmount, TimeConvertUtil.toLocalDate(workStartedAt),
                companyName, name, TimeConvertUtil.toLocalDate(giveAmountAt), TimeConvertUtil.toLocalDate(wordEndAt),
                registerNumber, incomePayType, companyRegisterNumber);
    }
}
