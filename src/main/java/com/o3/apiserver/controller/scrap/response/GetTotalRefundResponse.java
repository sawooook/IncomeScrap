package com.o3.apiserver.controller.scrap.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.o3.apiserver.application.scrap.dto.GetTotalRefundDto;
import lombok.Getter;

@Getter
public class GetTotalRefundResponse {

    @JsonProperty("이름")
    private final String name;

    @JsonProperty("한도")
    private final String limitAmount;

    @JsonProperty("공제액")
    private final String deductAmount;

    @JsonProperty("환급액")
    private final String refundAmount;

    public GetTotalRefundResponse(String name, String limitAmount, String deductAmount, String refundAmount) {
        this.name = name;
        this.limitAmount = limitAmount;
        this.deductAmount = deductAmount;
        this.refundAmount = refundAmount;
    }

    public static GetTotalRefundResponse convert(GetTotalRefundDto dto) {
        return new GetTotalRefundResponse(
                dto.getName(),
                dto.getLimitAmount(),
                dto.getDeductAmount(),
                dto.getTotalRefundAmount()
        );
    }
}
