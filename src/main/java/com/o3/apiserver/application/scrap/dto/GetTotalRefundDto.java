package com.o3.apiserver.application.scrap.dto;

import com.o3.apiserver.common.util.TaxNameConvertUtil;
import lombok.Getter;

@Getter
public class GetTotalRefundDto {

    private final String limitAmount;
    private final String deductAmount;
    private final String totalRefundAmount;
    private final String name;

    public GetTotalRefundDto(String limitAmount, String deductAmount, String totalRefundAmount, String name) {
        this.limitAmount = limitAmount;
        this.deductAmount = deductAmount;
        this.totalRefundAmount = totalRefundAmount;
        this.name = name;
    }

    public static GetTotalRefundDto convert(int limitAmount, int deductAmount, int resultRefundAmount, String name) {
        return new GetTotalRefundDto(
                TaxNameConvertUtil.wonDisplay(limitAmount),
                TaxNameConvertUtil.wonDisplay(deductAmount),
                TaxNameConvertUtil.wonDisplay(resultRefundAmount),
                name
        );
    }
}